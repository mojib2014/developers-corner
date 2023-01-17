/**
 * 
 */

angular.module('developersCorner').factory('ProfileService', ["$http", "$q", function($http, $q) {
	const URL = 'http://localhost:8080/users/';
	
	const factory = {
		getUserProfile, 
		editUserProfile,
		deleteUserProfile

	}
	return factory;
	
	function getUserProfile(userId) {
		const defered = $q.defer();
		
		$http.get(URL + userId)
			.then((res) => {
				defered.resolve(res.data);
			})
			.catch((err) => defered.reject(err));
			
		return defered.promise;
	}
	
	function editUserProfile(user) {
		const defered = $q.defer();
		
		const updates = {
			firstName: user.firstName,
			lastName: user.lastName,
			nickName: user.nickName,
			email: user.email,
			password: user.password,
			type: user.type
		}
		$http.put(URL + user.id, updates)
			.then((res) => {
				defered.resolve(res.data);
			})
			.catch((err) => defered.reject(err));
			
		return defered.promise;
	}
	
	function deleteUserProfile(userId) {
		const defered = $q.defer();
		
		$http.delete(URL + userId)
			.then((res) => {
				defered.resolve(res.data);
			})
			.catch((err) => defered.reject(err));
			
		return defered.promise;
	}
}]);