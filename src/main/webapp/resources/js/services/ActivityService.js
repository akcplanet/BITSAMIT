var activityservice = angular.module('activityservice', [ 'ngResource', 'ngRoute' ]);

activityservice.factory('GetAllActivityService', function ($resource) {
    return $resource('/activity', {}, {
    	_get: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});