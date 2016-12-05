var reportservice = angular.module('reportservice', [ 'ngResource', 'ngRoute' ]);

reportservice.factory("ReportService", function($resource) {
	return $resource("/schooldetail/byid/:id", {
		id : '@id'
	}, {
		_get : {
			method : "GET",
			isArray : true
		}
	});
});


reportservice.factory('xlsReportlService', [ '$resource', function($resource) {
	return $resource('/report/view', {}, {
		_report : {
			method : 'GET',
			params : {},
			responseType : 'arraybuffer'
		}
	}
	);
} ]);

reportservice.factory('downloadService', [ '$q', '$timeout', '$window', function($q, $timeout, $window) {
	return {
		download : function(id) {
			var defer = $q.defer();
			$timeout(function() {
				/*  $window.location = 'download?name=' + name;*/
				$window.location = '/report/view?id=' + id;
			}, 1000)
				.then(function() {
					defer.resolve('success');
				}, function() {
					defer.reject('error');
				});
			return defer.promise;
		}
	};
}
]);