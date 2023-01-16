/**
 * App.js is the entry point for AngularJs front-end 
 */
'use strict';

const app = angular.module('developersCorner', ['angular-jwt'])
	.config(function Config($httpProvider, jwtOptionsProvider) {
		jwtOptionsProvider.config({
			unauthenticatedRedirector: ['$state', function($state) {
        		$state.go('/login');
      		}],
			tokenGetter: ['AuthService', function(AuthService) {
				AuthService.getToken();
				return localStorage.getItem('token');
			}]
		});
		
		$httpProvider.interceptors.push('jwtInterceptor');
	}).run(function(authManager) {
		authManager.checkAuthOnRefresh();
	});
