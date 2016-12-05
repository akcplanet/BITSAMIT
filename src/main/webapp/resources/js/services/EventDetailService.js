var eventdetailservice = angular.module('eventdetailservice', [ 'ngResource', 'ngRoute' ]);


eventdetailservice.factory('GetAllEventDetailService', function ($resource) {
    return $resource('/eventdetail', {}, {
    	_get: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});

eventdetailservice.factory('SaveEventDetailService', function ($resource) {
    return $resource('/eventdetail/add', {}, {
    	_add: {
            method: 'POST',
            params: {},
            isArray: true
        }
    })
});


eventdetailservice.factory('eventSearchService', function ($resource) {
    return $resource('/eventdetail/search?councilName=:councilName&schoolName=:schoolName&activity=:activity&eventType=:eventType'
    		+'&poc1=:poc1&poc2=:poc2&poc3=:poc3&eventDateFrom=:eventDateFrom&eventDateTo=:eventDateTo', {}, {
    	_search: {
            method: 'GET',
            params: {
            	councilName: '@councilName',
            	schoolName: '@schoolName',
            	activity: '@activity',
            	eventType: '@eventType',
            	poc1: '@poc1',
            	poc2: '@poc2',
            	poc3: '@poc3',
            	eventDateFrom: '@eventDateFrom',
            	eventDateTo: '@eventDateTo'	
            },
            isArray: true
        }
    })
});