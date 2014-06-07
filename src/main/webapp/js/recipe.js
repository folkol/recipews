angular.module("recipe-app", [])
	.controller("ListController", function($scope, $http) {
		$scope.remove = function(index) {
			var recipe = $scope.recipes.splice(index, 1);
			$http.delete("ws/recipes/" + recipe[0].id);
		};
		
    	$scope.list = function () {
    		$http.get("ws/recipes/")
    		.success(function(data, status, headers, config) {
    				     $scope.recipes = data;
            	 	 })
            .error(function(data, status, headers, config) {
            	     alert("AJAX failed!");
            });
    	}
	});