//(function(angular) {
var app = angular.module('app', []);
app.filter('capitalize', function() {
	return function(input, param) {
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
});
app.directive('focus', function() {
	return {
		link : function(scope, element, attrs) {
			alert(element[0].html());
			element[0].focus();
		}
	};
});
app.controller('MainCtrl', function($scope) {
	// $scope.message = 'World!';
	$scope.greet = function() {
		$scope.message = "Hello, " + $scope.user.name;
	}
	$scope.developers = [ {
		name : "Jesus",
		country : "Spain"
	}, {
		name : "Dave",
		country : "Canada"
	}, {
		name : "Wesley",
		country : "USA"
	}, {
		name : "Krzysztof",
		country : "Poland"
	} ];
});
// })(window.angular);
