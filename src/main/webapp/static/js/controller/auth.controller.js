/**
 * 
 */

angular.module('developersCorner').controller("AuthController", ["$scope", "AuthService", function($scope, AuthService) {
	$scope.user = null;
	$scope.isLoggedIn = false;
	$scope.login = login;
	$scope.register = register;
	$scope.logout = logout;
	
	
	function login(user) {
		AuthService.login(user)
			.then((data) => {
				$scope.isLoggedIn = true;
				$scope.user = data
				localStorage.setItem("isLoggedIn", $scope.isLoggedIn);
			})
			.then((err) => console.log(err));
	}
	
	function register(user) {
		AuthService.register(user)
			.then((data) => $scope.user = data)
			.then((err) => console.log(err));
	}
	
	function logout() {
		$scope.isLoggedIn = false;
	}
}]);