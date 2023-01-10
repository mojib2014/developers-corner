/**
 * User service module
 */

'use strict';

angular.module('developersCorner').factory('UserService', ['$http', '$q', function($http, $q) {
	const URL = 'http://localhost:8080/users';

	const factory = {
		fetchAllUsers,
		registerUser,
	};

	return factory;

	function fetchAllUsers() {
		const defered = $q.defer();
		$http.get(URL)
			.then((res) => {
				defered.resolve(res.data)
			}).catch((err) => {
				console.log('Error fetching users', err);
				defered.reject(err);
			});

		return defered.promise;
	};

	function registerUser(user) {
		const defered = $q.defer();
		$http.post(URL + "/register", user)
			.then((res) => defered.resolve(res.data))
			.catch((err) => {
				console.log('Error registering user', err);
				defered.reject(err);
			});
		return defered.promise;
	}
}])