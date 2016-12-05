'use strict';
function mainController($scope,GetAllSchoolService,downloadService,xlsReportlService) {
	
	
	$scope.exportData = function () {	
	xlsReportlService._report().$promise.then(function (result, responseHeaders) {
			console.log(result);
			 var blob = new Blob([result], {
		            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
		        });
			/* var objectUrl = URL.createObjectURL(blob);
			    window.open(objectUrl);*/
			saveAs(blob, "Report.xls");	
		},function(httpResponse) {
		  alert('Failed: ' + httpResponse);
		});
    };
	
}
angular.module('reportcontroller',[])
.controller('reportCtrl',mainController);