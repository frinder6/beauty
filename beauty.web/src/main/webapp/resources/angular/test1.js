function ActivitiesListCtrl($scope, $http) {
	var url = 'http://localhost:8080/beauty/menu/select.action';
	$http.post(url, {}, {
		params : {
			search : '',
			pid : ''
		}
	}).success(function(data) {
		$scope.activities = data;
	});

	// $http({
	// url : url,
	// method : 'POST',
	// params : {
	// search : '',
	// pid : ''
	// }
	// }).success(function(data) {
	// $scope.activities = data;
	// }).error(function(msg) {
	// alert(msg);
	// });

};

function ActivitiesListCtrl1($scope) {
	$scope.activities = [ {
		"name" : "Wake up"
	}, {
		"name" : "Brush teeth"
	}, {
		"name" : "Shower"
	}, {
		"name" : "Have breakfast"
	}, {
		"name" : "Go to work"
	}, {
		"name" : "Write a Nettuts article"
	}, {
		"name" : "Go to the gym"
	}, {
		"name" : "Meet friends"
	}, {
		"name" : "Go to bed"
	} ];
};

