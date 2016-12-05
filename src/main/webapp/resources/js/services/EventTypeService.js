var eventtypeservice = angular.module('eventtypeservice', [ 'ngResource', 'ngRoute' ]);

eventtypeservice.factory('GetAllEventTypeseService', function ($resource) {
    return $resource('/eventtype', {}, {
    	_get: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});