angular.module("recipe-app", [])
    .controller("ListController", function($scope, $http) {
    	var promise = $http.get("ws/recipes/");
    	promise.success(function(data, status, headers, config) {
    						$scope.recipes = data;
            			});
    	promise.error(function(data, status, headers, config) {
            		      alert("AJAX failed!");
            		  });
    });