/**
 * 
 */

angular.module('developersCorner').controller("ProfileController", ["$scope", "ProfileService", "AuthService", function($scope, ProfileService, AuthService) {
	$scope.user = null;
	$scope.isLoggedIn = false;
	$scope.showModal = false;
	$scope.getUserProfile = getUserProfile;
	$scope.editUserProfile = editUserProfile;
	$scope.deleteUserProfile = deleteUserProfile;
	$scope.logout = logout;
	$scope.openModal = openModal;
	$scope.closeModal = closeModal;

	async function init() {
		const user = await AuthService.getCurrentUser();
		if(user) $scope.isLoggedIn = true;
		if(!user) $scope.isLoggedIn = false;
		getUserProfile(user.id);
	}

	init();
	
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
			.then((err) => console.log(err.message));
	}
	function deleteUserProfile(userId) {
		ProfileService.deleteUserProfile(userId)
			.then((data) => {
				console.log(data);
			})
			.then((err) => console.log(err));
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

}]);