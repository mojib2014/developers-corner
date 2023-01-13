/**
 * 
 */

angular.module('developersCorner').factory('AuthService', ["$http", "$q", function($http, $q) {
	const URL = 'http://localhost:8080/users/auth';
	
	const factory = {
		login, 
		register,
		logout
	}
	
	function login(user) {
		const defered = $q.defer();
		
		$http.post(URL + "/login", user)
			.then((res) => {
				defered.resolve(res.data);
				localStorage.setItem("user", data);
			})
			.catch((err) => defered.reject(err));
			
		return defered.promise;
	}
	
	function register(user) {
		const defered = $q.defer();
		
		$http.post(URL + "/register", user)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));
			
		return defered.promise;
	}
	
	function logout() {
		localStorage.removeItem("user");
		localStorage.removeItem("isLoggedIn");
	}
	
	return factory;
}]);