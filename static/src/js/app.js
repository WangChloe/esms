var esmsApp = angular.module("esmsApp", [
	// 外部库模块
	'ui.router'

	// 页面template, 自己写的公共模块、ui模块
    // 'mainTemplates', 'common', 'ui', 'zbModalModule', 'configModule',...

     // 下面的是业务相关的模块
    // 'searchModule','departmentMoudle'...
]);

//ui 模块
// var ui = angular.module('ui',[
// 	'folder','tabHeader','copyRight'...
// ]);

// common 模块, 公共的　filter、指令、之类的，不包括控件的指令
// var common = angular.module('common', ['commonDirective', 'commonFilter', 'commonService']);

esmsApp.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.ohterwise('/');
	$stateProvider
		.state('index2', {
			url: '/',
			views: {
				'': {
					templateUrl: '../index2.html'
				},
				'header@index': {
					templateUrl: '../header.html'
				},
				'content@index': {
					templateUrl: '../content.html'
				}
				'footer@index': {
					templateUrl: '../footer.html'
				}
				'modal@index': {
					templateUrl: '../modal.html'
				}

			}
		})
		// .state('index.reg', {
		// 	url:'reg',
		// 	views: {
		// 		'main@index': {
		// 			templateUrl: '../home.html',
		// 			controller: function($scope, $state) {
		// 				$scope.login = function(){
		// 					$state.go('index.reg.login');
		// 				}
		// 			}
		// 		}
		// 	}
		// }) 
		// .state('index.reg.login', {
		// 	url:'login',
		// 	templateUrl: '../login.html',
		// 	controller: function($scope, $state) {
		// 		$scope.backToPrevious = function() {
		// 			window.history.back();
		// 		}
		// 	}
		// }) 
})