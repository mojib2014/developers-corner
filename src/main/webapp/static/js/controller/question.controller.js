/**
 * 
 */
'use strict';
angular.module('developersCorner').controller('QuestionController', ["$scope", "QuestionService", "AuthService", function($scope, QuestionService, AuthService) {
	$scope.questions = [];
	$scope.question = { id: null, username: '', role:'', tags: '', question: '', userId: null };
	$scope.showModal = false;
	$scope.isLoggedIn = false;
	$scope.updateUserQuestion = updateUserQuestion;
	$scope.deleteUserQuestion = deleteUserQuestion;
	$scope.logout = logout;
	$scope.openModal = openModal;
	$scope.closeModal = closeModal;
	
	fetchAllUserQuestions();
	
	async function fetchAllUserQuestions() {
		const user = await AuthService.getCurrentUser();
		if(user) $scope.isLoggedIn = true;
		if(!user) $scope.isLoggedIn = false;

			QuestionService.fetchAllUserQuestions(user.id)
				.then((data) => {
					console.log("questions: ", data);
					$scope.questions = data
					})
				.catch((err) => console.log(err));
	}
	
	function updateUserQuestion() {
		QuestionService.updateUserQuestion($scope.question)
			.then((data) => {
				$scope.question = data;
				fetchAllUserQuestions();
				closeModal();
			})
			.catch((err) => console.log(err));
	}
	
	function deleteUserQuestion(id) {
		QuestionService.deleteUserQuestion(id)
			.then((data) => {
				$scope.question = data;
			})
			.catch((err) => console.log(err));
	}
	
	function logout() {
		AuthService.logout();
	}
	
	function openModal(question) {
		$scope.question = question;
		$scope.showModal = true;
	}
	
	function closeModal() {
		$scope.showModal = false;
	}
}])