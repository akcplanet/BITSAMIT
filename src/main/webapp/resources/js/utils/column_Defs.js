
var rowTemplate ='<div style="height: 100%" ng-class="{red: row.getProperty(\'viewed\') < 1}"><div ng-style="{ \'cursor\': row.cursor }" ng-repeat="col in renderedColumns" ng-class="col.colIndex()" class="ngCell ">' +
        '<div class="ngVerticalBar" ng-style="{height: rowHeight}" ng-class="{ ngVerticalBarVisible: !$last }"> </div>' +
       '<div ng-cell></div>' +
       '</div></div>';

var coldef_dashboard = [
	
	/*{
	field : 'id',
	displayName : 'ID ',
	width : "20%",
},*/
	{
		field : 'council.name',
		displayName : 'Council',
		width : "10%"
	} ,
	{
		field : 'schoolDetails.name',
		displayName : 'School Name',
		width : "10%"
	},
	{
		field : 'activity.name',
		displayName : 'Activity',
		width : "10%"
	},

	
	{
		field : 'eventType.typeOfEvent',
		displayName : 'Event Type',
		width : "10%",
		type: 'number'
	} ,
	
	{
		field : 'eventDate',
		displayName : 'Event Date',
		width : "10%",
		cellFilter: 'date:\'dd-MMM-yyyy\'' ,
		cellClass: 'text-center'
	} ,
	
	{
		field : 'noOfLivesImpct',
		displayName : 'Lives Impcted',
		width : "10%",
		cellTemplate: '<div class="ngCellText"><div ng-class="green">{{row.getProperty(col.field) | number :0}}</div></div>',
		cellClass: 'text-center'
	}  ,
	
	{
		field : 'totalHrs',
		displayName : 'Total Event Hrs',
		width : "10%",
		cellTemplate: '<div class="ngCellText"><div ng-class="green">{{row.getProperty(col.field)| number :0}}</div></div>',
		cellClass: 'text-center'
	} ,
	
	{
		field : 'pocDetailsByPoc1Id.name',
		displayName : 'POC-1',
		width : "10%"
	} ,
	{
		field : 'pocDetailsByPoc2Id.name',
		displayName : 'POC-2',
		width : "10%"
	} ,
	{
		field : 'pocDetailsByPoc3Id.name',
		displayName : 'POC-3',
		width : "10%"
	}  ,
	{
		field : 'createdBy',
		displayName : 'Created By',
		width : "10%",
		cellTemplate: '<div class="ngCellText"><div ng-class="green">{{row.getProperty(col.field)}}</div></div>',
		
	} ,
	{
		field : 'createdDate',
		displayName : 'Created Date',
		width : "10%",
		cellFilter: 'date:\'dd-MMM-yyyy\'' ,
		cellClass: 'text-center'
	} ,
	{
		field : 'updatedBy',
		displayName : 'Updated By',
		width : "10%"
	} ,
	{
		field : 'updatedDate',
		displayName : 'Updated Date',
		width : "10%",
		cellFilter: 'date:\'dd-MMM-yyyy\'' ,
		cellClass: 'text-center'
	}];



angular.module("columnUtils", [])
.value('rowTemplate', rowTemplate)
	.value('coldef_dashboard', coldef_dashboard);

