angular.module('movieApp.services', []).factory('Movie', function($resource) {
  return $resource('/herbs/:id', {id: '@id'}, {
    update: {
      method: 'PUT'
    }
  });
});