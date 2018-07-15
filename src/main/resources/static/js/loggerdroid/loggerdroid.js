/**
 * 
 */


var loggerdroid = angular.module('loggerdroid',['ngRoute']);


loggerdroid.config(['$routeProvider', function($routeProvider){
	
	console.log("Config");

	$routeProvider

	.when('/',{
		templateUrl: 'partials/main.html',
		controller: 'LoginController'
	})

	.when('/tables',{
		templateUrl: 'partials/something.html',
		controller: 'LoginController'
	})
	
	.otherwise({
		redirectTo: '/'
	})

}
]);



loggerdroid.controller('LoginController', function LoginController() {
	
	console.log("user = " );
});

