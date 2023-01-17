/**
 * User service module
 */

'use strict';

angular.module('developersCorner').factory('UserService', ['$http', '$q', function($http, $q) {
	const URL = 'http://localhost:8080/users';

	const factory = {
		fetchAllUsers,
		getUserById,
		getUserByEmail,
		updateUserById,
		deleteUserById
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
	
	function getUserById(userId) {
		const defered = $q.defer();
		$http.get(URL + `/${userId}`)
			.then((res) => {
				defered.resolve(res.data)
			}).catch((err) => {
				console.log('Error fetching users', err);
				defered.reject(err);
			});

		return defered.promise;
	}
	
	function getUserByEmail(email) {
		const defered = $q.defer();
		$http.get(URL + `/email/${email}`)
			.then((res) => {
				defered.resolve(res.data)
			}).catch((err) => {
				console.log('Error fetching users', err);
				defered.reject(err);
			});

		return defered.promise;
	}
	
	function updateUserById(user) {
		const defered = $q.defer();
		$http.put(URL + `/${user.id}`, user)
			.then((res) => {
				fetchAllUsers();
				defered.resolve(res.data)
			}).catch((err) => {
				console.log('Error fetching users', err);
				defered.reject(err);
			});

		return defered.promise;
	}
	
	function deleteUserById(userId) {
		const defered = $q.defer();
		$http.delete(URL + `/${userId}`)
			.then((res) => {
				fetchAllUsers();
				defered.resolve(res.data)
			}).catch((err) => {
				console.log('Error fetching users', err);
				defered.reject(err);
			});

		return defered.promise;
	}

}])