angular.module('hello', ['ngRoute','ngTable','ngResource', 'ui.router', 'angularjs-dropdown-multiselect' ,'herbApp.controllers', 'herbApp.services']).config(function($stateProvider,$urlRouterProvider, $httpProvider) {
	$urlRouterProvider.otherwise('/');
	$stateProvider.state('home', {
		url : '/',
		templateUrl : 'home.html',
		controller : 'home'
	}).state('login', {
		url : '/login',
		templateUrl : 'login.html',
		controller : 'navigation'
	}).state('herbs', {
		url : '/herbs',
		templateUrl : 'herbs.html',
		controller : 'herbs'
	}).state('viewHerb', { //state for showing single herb
        url: '/herbs/:id/view',
        templateUrl: 'herb-view.html',
        controller: 'HerbViewController'
    }).state('editHerb', { //state for updating a herb
        url: '/herbs/:id/edit',
        templateUrl: 'herb-edit.html',
        controller: 'HerbEditController'
    }).state('newHerb', { //state for adding a new herb
          url: '/herbs/add',
          templateUrl: 'herb-add.html',
          controller: 'HerbCreateController'
    });

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}).run(function($state) {
          $state.go('home'); //make a transition to movies state when app starts
}).controller('navigation',
		function($rootScope, $scope, $http, $location, $route) {
//			$scope.tab = function(route) {
//				return $route.current && route === $route.current.controller;
//			};
			var authenticate = function(credentials, callback) {
				var headers = credentials ? {
					authorization : "Basic "
							+ btoa(credentials.username + ":"
									+ credentials.password)
				} : {};

				$http.get('user', {headers : headers})
				.success(function(data) {
					if (data.name) {
						$rootScope.authenticated = true;
					} else {
						$rootScope.authenticated = false;
					}
					callback && callback($rootScope.authenticated);
				}).error(function() {
					$rootScope.authenticated = false;
					callback && callback(false);
				});
			}
			authenticate();

			$scope.credentials = {};
			$scope.login = function() {
				authenticate($scope.credentials, function(authenticated) {
					if (authenticated) {
						console.log("Login succeeded");
						$location.path("/");
						$scope.error = false;
						$rootScope.authenticated = true;
					} else {
						console.log("Login failed");
						$location.path("/login");
						$scope.error = true;
						$rootScope.authenticated = false;
					}
				})
			};

			$scope.logout = function() {
				$http.post('logout', {}).success(function() {
					$rootScope.authenticated = false;
					$location.path("/");
				}).error(function(data) {
					console.log("Logout failed");
					$rootScope.authenticated = false;
				});
			}

		}).controller('home', function($scope, $http) {
	$http.get('/resource/').success(function(data) {
		$scope.greeting = data;
	})
});