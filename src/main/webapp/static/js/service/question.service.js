/**
 * 
 */
'use strict';
angular.module('developersCorner').factory("QuestionService", ["$http", "$q", function($http, $q) {
	const URL = 'http://localhost:8080/user/questions';
	
	const factory = {
		fetchAllUserQuestions,
		editUserQuestion,
		deleteUserQuestion
	}
	
	return factory;
	
	function fetchAllUserQuestions(userId) {
		const defered = $q.defer();
		
			$http.get(URL + "/question?userId=" + userId)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));
		
		return defered.promise;
	}
	
	function editUserQuestion(updates) {
		const defered = $q.defer();
		updates.userId = updates.user.id;
		
		$http.put(URL + "/" + updates.id, updates)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));
			
		return defered.promise;
	}
	
	function deleteUserQuestion(id) {
		const defered = $q.defer();
		
		$http.delete(URL + "/" + id)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));
		window.location.href = window.location.href;
		return defered.promise;
	}
}]);