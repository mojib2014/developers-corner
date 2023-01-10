/**
 * 
 */

'use strict';

angular.module('developersCorner').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {

	$scope.user = { id: null, firstName: '', lastName: '', nickName: '', email: '', password: '' };
	$scope.users = [];
	$scope.submit = submit;

	fetchAllUsers();

	function fetchAllUsers() {
		UserService.fetchAllUsers()
			.then((data) => {
				$scope.users = data
			})
			.catch((err) => console.log(err));
	}

	function registerUser(user) {
		UserService.registerUser(user)
			.then(fetchAllUsers)
			.catch((err) => console.log(err));
	}

	function submit() {
		if ($scope.user.id === null) {
			registerUser($scope.user);
		/*	setTimeout(() => window.location = "/", 2000);*/
		} else {

			console.log('User updated with id ', $scope.user.id);
		}
	}
}])