var app = angular.module('app', []);

var apiKey = 'YOUR_KEY', nprUrl = 'http://api.npr.org/query?id=61&fields=relatedLink,title,byline,text,audio,image,pullQuote,all&output=JSON';

app.controller('PlayerController', [ '$scope', function($scope) {
	$scope.playing = false;
	$scope.audio = document.createElement('audio');
	// $scope.audio.controls = 'controls';
	$scope.audio.src = '../../resources/angular/123.mp3';
	$scope.play = function() {
		$scope.audio.play();
		$scope.playing = true;
	};
	$scope.stop = function() {
		$scope.audio.pause();
		$scope.playing = false;
	};
	$scope.audio.addEventListener('ended', function() {
		$scope.$apply(function() {
			$scope.stop()
		});
	});
} ]);

app.controller('RelatedController', [ '$scope', function($scope) {
} ]);

app.run(function($rootScope) {
	$rootScope.name = "Ari Lerner";
});

app.controller('MyController', function($scope) {
	$scope.person = {
		name : "Ari Lerner"
	};
});

app.controller('ParentController', function($scope) {
	$scope.person = {
		greeted : false
	};
});

app.controller('ChildController', function($scope) {
	$scope.sayHello = function() {
		$scope.person.greeted = true;
	}
});