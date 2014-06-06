angular.module("recipe-app", [])
	.controller("ListController", function($scope, $http) {
		$scope.remove = function(id) {
			$http.delete("ws/recipes/" + id);
		};
		
    	$http.get("ws/recipes/")
    		.success(function(data, status, headers, config) {
    				     $scope.recipes = data;
            	 	 })
            .error(function(data, status, headers, config) {
            	     alert("AJAX failed!");
            });
	});