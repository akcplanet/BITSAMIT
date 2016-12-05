var councilservice = angular.module('councilservice', [ 'ngResource', 'ngRoute' ]);

councilservice.factory('GetAllCouncilService', function ($resource) {
    return $resource('/council', {}, {
    	_get: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});