var volunteerservice = angular.module('volunteerservice', [ 'ngResource', 'ngRoute' ]);

volunteerservice.factory('GetAllVolunteerService', function ($resource) {
    return $resource('/volunteer', {}, {
    	_get: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});

