'use strict';
function mainController($scope, coldef_dashboard, GetAllSchoolService, GetAllEventDetailService, rowTemplate, GetAllActivityService, GetAllCouncilService,
	GetAllEventTypeseService, GetAllPOCDetailService, GetAllVolunteerService, $location, eventSearchService ,$filter) {
	
	
	$scope.eventsSelections=[];

	$scope.searchEventDashBoard = function() {
		var councilName_id = null;
		var schoolName_id = null;
		var activity_id = null;
		var eventType_id = null;
		var poc1_id = null;
		var poc2_id = null;
		var poc3_id = null;
		var eventDateFrom_id = null;
		var eventDateTo_id = null;
		if ($scope.dashboardSearch != null) {
			councilName_id = ($scope.dashboardSearch.council != null) ? $scope.dashboardSearch.council.id : null,
			schoolName_id = ($scope.dashboardSearch.schoolDetails!=null) ? $scope.dashboardSearch.schoolDetails.id : null,
			activity_id = ($scope.dashboardSearch.activity != null) ? $scope.dashboardSearch.activity.id : null,
			eventType_id = ($scope.dashboardSearch.eventType != null)? $scope.dashboardSearch.eventType.id : null,
			poc1_id = ($scope.dashboardSearch.pocDetailsByPoc1Id != null) ? $scope.dashboardSearch.pocDetailsByPoc1Id.id : null,
			poc2_id = ($scope.dashboardSearch.pocDetailsByPoc2Id != null) ? $scope.dashboardSearch.pocDetailsByPoc2Id.id : null,
			poc3_id = ($scope.dashboardSearch.pocDetailsByPoc3Id != null) ? $scope.dashboardSearch.pocDetailsByPoc3Id.id : null,
			eventDateFrom_id = ($scope.dashboardSearch.eventDateFrom != null) ? $filter('date')(new Date($scope.dashboardSearch.eventDateFrom),'yyyy-MM-dd') : null,
			eventDateTo_id = ($scope.dashboardSearch.eventDateTo != null) ? $filter('date')(new Date($scope.dashboardSearch.eventDateTo),'yyyy-MM-dd') : null
		};

		$scope.ctrlName = eventSearchService._search(
			{
				councilName : councilName_id,
				schoolName : schoolName_id,
				activity : activity_id,
				eventType : eventType_id,
				poc1 : poc1_id,
				poc2 : poc2_id,
				poc3 : poc3_id,
				eventDateFrom : eventDateFrom_id,
				eventDateTo : eventDateTo_id,
			}
		)
	}


	$scope.ctrlName = GetAllEventDetailService._get();

	$scope.ActivityName = GetAllActivityService._get();
	$scope.CouncilName = GetAllCouncilService._get();
	$scope.EventDetailName = GetAllEventDetailService._get();
	$scope.EventTypeName = GetAllEventTypeseService._get();
	$scope.SchoolName = GetAllSchoolService._get();
	$scope.POCDetailName = GetAllPOCDetailService._get();
	$scope.VolunteerName = GetAllVolunteerService._get();


	$scope.resetDashBoard = function() {
		$scope.dashboardSearch = null;
	}



	$scope.gridOptions = {
		data : 'ctrlName',
		columnDefs : coldef_dashboard,
		enablePaging : true,
		showFooter : false,
		showFilter : true,
		checkboxCellTemplate : undefined,
		checkboxHeaderTemplate : undefined,
		pagingOptions : $scope.pagingOptions,
		filterOptions : {
			filterText : "",
			useExternalFilter : false
		},
		afterSelectionChange : function() {
			
		},
		beforeSelectionChange : function() {
			return true;
		},
		enablePinning : true,
		enableRowReordering : true,
		enableRowSelection : true,
		enableSorting : true,
		footerRowHeight : 55,
		headerRowHeight : 30,
		keepLastSelected : true,
		multiSelect : true,
		enableColumnResize : true,
		rowTemplate : rowTemplate,
		selectedItems: $scope.eventsSelections,
		pagingOptions : {
			pageSizes : [ 250, 500, 1000 ],
			pageSize : 250,
			totalServerItems : 0,
			currentPage : 1
		},
		afterSelectionChange: function (data) {
			if ($scope.eventsSelections.length > 0) {
				console.log($scope.eventsSelections);
				}
		},
		rowHeight : 30,
		selectWithCheckboxOnly : true,
		showSelectionCheckbox : true,
		i18n : 'en',
		enableHighlighting : true,
	};

	$scope.selectEnosRow = function() {
		angular.forEach($scope.Details, function(data, index) {
			if (data.name == 'Enos') {
				$scope.gridOptions.selectItem(index, true);
			}
		});
	};


}



angular.module('dashboardcontroller', [])
	.controller('dashboardCtrl', mainController);