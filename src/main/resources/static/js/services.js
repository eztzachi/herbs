angular.module('herbApp.services', []).factory('Herb', function($resource) {
  return $resource('/herbs/:id', {id: '@id'}, {
    update: {
      method: 'PUT'
    }
  });
});