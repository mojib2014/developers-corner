/**
 * 
 */

'use strict';

angular.module('developersCorner').controller('UserController', UserController);

function UserController($scope, UserService, AuthService) {

	$scope.user = { id: null, firstName: '', lastName: '', nickName: '', type: '', email: '', password: '' };
	$scope.users = [];
	$scope.submit = submit;
	$scope.getCurrentUser = getCurrentUser;
	$scope.login = login;
	$scope.getUserById = getUserById;
	$scope.updateUserById = updateUserById;
	$scope.deleteUserById = deleteUserById;
	$scope.logout = logout;

	fetchAllUsers();

	function fetchAllUsers() {
		UserService.fetchAllUsers()
			.then((data) => {
				$scope.users = data
			})
			.catch((err) => console.log(err));
	}
	
	function getUserById(userId) {
		UserService.getUserById(userId)
			.then((user) => $scope.user = user)
			.catch((err) => console.log(err));
	}
	
	function updateUserById(user) {
		UserService.updateUserById(user)
			.then((res) => console.log(res))
			.catch((err) => console.log(err));
	}
	
	function deleteUserById(user) {
		UserService.deleteUserById(user)
			.then((res) => console.log(res))
			.catch((err) => console.log(err));
	}
	
	function login(user) {
		AuthService.login(user)
			.then((data) => console.log(data))
			.catch((err) => console.log(err));
	}

	function registerUser(user) {
		AuthService.register(user)
			.then(fetchAllUsers)
			.then(() => $scope.currentUser = AuthService.getCurrentUser())
			.catch((err) => console.log(err));
	}
	
	function getCurrentUser() {
		return AuthService.getCurrentUser();
	}
	
	function logout() {
		AuthService.logout();
	}

	function submit() {
		if ($scope.user.id === null) {
			registerUser($scope.user);
		/*	setTimeout(() => window.location = "/", 2000);*/
		} else {
			console.log('User updated with id ', $scope.user.id);
		}
	}
};