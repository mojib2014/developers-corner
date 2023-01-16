/**
 * 
 */
'use strict';
angular.module('developersCorner').controller('QuestionController', ["$scope", "QuestionService", function($scope, QuestionService) {
	$scope.questions = [];
	$scope.question = { id: null, username: '', role:'', tags: '', question: '', userId: null };
	$scope.showModal = false;
	$scope.updateUserQuestion = updateUserQuestion;
	$scope.deleteUserQuestion = deleteUserQuestion;
	$scope.openModal = openModal;
	$scope.closeModal = closeModal;
	
	fetchAllUserQuestions();
	
	function fetchAllUserQuestions() {
			QuestionService.fetchAllUserQuestions(1)
				.then((data) => {
					console.log(data);
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
	
	function openModal(question) {
		$scope.question = question;
		$scope.showModal = true;
	}
	
	function closeModal() {
		$scope.showModal = false;
	}
}])