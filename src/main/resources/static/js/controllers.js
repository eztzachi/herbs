angular.module('herbApp.controllers', []).controller('HerbViewController',
function($scope, $stateParams, Api, ngTableParams) {
       $scope.herb = Api.Herb.get({ id: $stateParams.id }); //Get a single herb
       $scope.tableParams = new ngTableParams({
       },{
           counts: []
       });
}).controller('HerbEditController',function($scope, $state, $stateParams, Api){
      $scope.updateHerb=function(){
          $scope.herb.$update(function(){
              $state.go('herbs');   // on success go back to herbs state
          });
      };
      $scope.loadHerb=function(){
          $scope.herb = Api.Herb.get({id:$stateParams.id});
      };
      $scope.loadHerb();
      $scope.categories = Api.Category.query();
      $scope.channels = Api.Channel.query();
      $scope.channelsSettings = {
          smartButtonMaxItems: 6,
          smartButtonTextConverter: function(itemText, originalItem) {
              return originalItem.name;
          },
          displayProp: 'name',
          externalIdProp: ''
      };
}).controller('HerbCreateController', function($scope, $state, $stateParams, Api) {
    $scope.herb = new Api.Herb({channels:[]});
    $scope.addHerb = function() {
      $scope.herb.$save(function() {
        $state.go('herbs');
      });
    };
    $scope.categories = Api.Category.query();
    $scope.channels = Api.Channel.query();
    $scope.channelsSettings = {
              smartButtonMaxItems: 6,
              smartButtonTextConverter: function(itemText, originalItem) {
                  return originalItem.name;
              },
              displayProp: 'name',
              externalIdProp: ''
          };
}).controller('herbs', function($scope, Api) {
  	$scope.herbs = Api.Herb.query(); //fetch all movies. Issues a GET to /api/movies
//  	$scope.deleteMovie = function(movie) { // Delete a movie. Issues a DELETE to /api/movies/:id
//  		if (popupService.showPopup('Really delete this?')) {
//  			movie.$delete(function() {
//  				$window.location.href = ''; //redirect to home
//  	  		});
//  		}
//  	};
});