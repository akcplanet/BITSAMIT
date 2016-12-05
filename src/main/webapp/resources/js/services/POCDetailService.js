var pocdetailservice = angular.module('pocdetailservice', [ 'ngResource', 'ngRoute' ]);

pocdetailservice.factory('GetAllPOCDetailService', function ($resource) {
    return $resource('/pocdetail', {}, {
    	_get: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});