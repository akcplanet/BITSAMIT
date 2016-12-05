'use strict';

function mainController($rootScope, $scope, GetAllActivityService, GetAllCouncilService, GetAllEventDetailService, GetAllEventTypeseService
	,GetAllSchoolService, GetAllPOCDetailService, GetAllVolunteerService, SaveEventDetailService,Flash,$timeout) {
	
	
	$scope.ActivityName = GetAllActivityService._get();
	$scope.CouncilName = GetAllCouncilService._get();
	$scope.EventDetailName = GetAllEventDetailService._get();
	$scope.EventTypeName = GetAllEventTypeseService._get();
	$scope.SchoolName = GetAllSchoolService._get();
	$scope.POCDetailName = GetAllPOCDetailService._get();
	$scope.VolunteerName = GetAllVolunteerService._get();




	$scope.addEvent = function() {
		$scope.eventDetails.noOfLivesImpct = '100';
		$scope.eventDetails.totalHrs = '10';
		var sd = $scope.eventDetails;
		sd.eventDate = new Date(sd.eventDate);
		console.log(sd);
		SaveEventDetailService._add(sd);
		Flash.create('success', 'Hooray!','custom-class');
		$scope.resetFrom();
	}
	
	
	$scope.resetFrom= function(){
		$scope.eventDetails=null;
	}


}



angular.module('eventdetailcontroller', [])
	.controller('eventdetailCtrl', mainController);