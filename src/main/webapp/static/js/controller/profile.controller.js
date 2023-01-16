/**
 * 
 */

angular.module('developersCorner').controller("ProfileController", ["$scope", "ProfileService", function($scope, ProfileService) {
	$scope.user = null;
	$scope.isLoggedIn = false;
	$scope.showModal = false;
	$scope.getUserProfile = getUserProfile;
	$scope.editUserProfile = editUserProfile;
	$scope.deleteUserProfile = deleteUserProfile;
	$scope.openModal = openModal;
	$scope.closeModal = closeModal;

	getUserProfile(1);

	function getUserProfile(userId) {
		ProfileService.getUserProfile(userId)
			.then((data) => {
				$scope.user = data
			})
			.then((err) => console.log(err));
	}
	function editUserProfile(user) {
		ProfileService.editUserProfile(user)
			.then((data) => {
				$scope.user = data
				getUserProfile(user.id);
				closeModal();
			})
			.then((err) => console.log(err));
	}
	function deleteUserProfile(userId) {
		ProfileService.deleteUserProfile(userId)
			.then((data) => {
				console.log(data);
			})
			.then((err) => console.log(err));
	}

	function openModal(question) {
		$scope.question = question;
		$scope.showModal = true;
	}

	function closeModal() {
		$scope.showModal = false;
	}

}]);