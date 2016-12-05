var schooldetailservice = angular.module('schooldetailservice', [ 'ngResource', 'ngRoute' ]);

schooldetailservice.factory('GetAllSchoolService', function ($resource) {
    return $resource('/schooldetail', {}, {
    	_get: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});