/**
 * 
 */

angular.module('developersCorner').factory('ProfileService', ["$http", "$q", function($http, $q) {
	const URL = 'http://localhost:8080/users/user/profile';
	
	const factory = {
		getProfile, 

	}
	
	function getProfile(user) {
		const defered = $q.defer();
		
		$http.post(URL + "/login", user)
			.then((res) => {
				defered.resolve(res.data);
				localStorage.setItem("user", data);
			})
			.catch((err) => defered.reject(err));
			
		return defered.promise;
	}
	
	return factory;
}]);