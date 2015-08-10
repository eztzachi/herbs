angular.module('herbApp.services', []).
  factory('Api', function($resource) {
    return {
      Herb: $resource('/api/herbs/:id', {id: '@id'},{
        update: {
          method: 'PUT'
        }
      }),
      Category: $resource('/api/category/:id', {id: '@id'}),
      Channel: $resource('/api/channel/:id', {id: '@id'})
    };
  });