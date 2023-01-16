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
		
		$http.put(URL + user.id, user)
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