var mainservice = angular.module('mainservice', [ 'ngResource', 'ngRoute' ]);

mainservice.factory("Updated", function($resource) {
	return $resource("/api/booking/:Id", {
		Id : "@Id"
	}, {
		update : {
			method : "PUT"
		},
		reviews : {
			'method' : 'GET',
			'params' : {
				'reviews_only' : "true"
			},
			isArray : true
		}

	});
});

/*mainservice.factory("GetAllService", function($resource) {
	return $resource("/test/user?id=:id", {id: '@id'}, {
		_get : {
			method : "GET"
		}
	});
});*/

mainservice.factory("GetAllService", function($resource) {
	return $resource("/schooldetail/byid/:id", {id: '@id'}, {
		_get : {
			method : "GET",
			isArray: true
		}
	});
});

mainservice.factory('Entry', function($resource) {
	  return $resource('/api/entries/:id', { id: '@_id' }, {
	    _update: {
	      method: 'PUT' 
	    }
	  });
	});



