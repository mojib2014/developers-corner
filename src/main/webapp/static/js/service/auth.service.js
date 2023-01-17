/**
 * 
 */

angular.module('developersCorner').factory('AuthService', AuthService);

function AuthService($http, $q, jwtHelper, UserService) {
	const URL = 'http://localhost:8080/auth';

	const factory = {
		login,
		register,
		logout,
		getCurrentUser,
		getToken
	}

	function login(user) {
		const defered = $q.defer();

		$http.post(URL + "/login", user)
			.then((res) => {
				defered.resolve(res.data);
				localStorage.setItem("token", res.data.token);
			})
			.catch((err) => defered.reject(err));

		return defered.promise;
	}

	function register(user) {
		const defered = $q.defer();

		$http.post(URL + "/register", user)
			.then((res) => {
				localStorage.setItem('token', JSON.stringify(res.data.token));
				defered.resolve(res.data);
			})
			.catch((err) => defered.reject(err));

		return defered.promise;
	}

	function logout() {
		localStorage.removeItem("token");
		window.location = "/login";
	}

	async function getCurrentUser() {
		const token = getToken();
		const email =  token !== null ? jwtHelper.decodeToken(token).sub : null;
		const user = await UserService.getUserByEmail(email);

		return user;
	}
	
	function getToken() {
		return JSON.parse(localStorage.getItem('token'));
	}

	return factory;
};