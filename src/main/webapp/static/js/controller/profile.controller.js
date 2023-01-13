/**
 * 
 */

angular.module('developersCorner').controller("ProfileController", ["$scope", "ProfileService", function($scope, ProfileService) {
	$scope.user = null;
	$scope.isLoggedIn = false;
	$scope.getUserProfile = getUserProfile;
	
	
	function getUserProfile(user) {
		ProfileService.getProfile(user)
			.then((data) => {
				$scope.isLoggedIn = true;
				$scope.user = data
				localStorage.setItem("isLoggedIn", $scope.isLoggedIn);
			})
			.then((err) => console.log(err));
	}
	
}]);