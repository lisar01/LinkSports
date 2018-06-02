angular.module("LinkSports", [])

.controller("UserController", function($scope, $http) {
    var url = "http://localhost:8080/User";
    $scope.userlabel = "Usuario";

    $scope.login = function() {
        $http({
            method: 'POST',
            url: url + "/login",
            data: {"username": $scope.username, "password": $scope.password}
        })
        .then(function(response) {
            alert("Response: " + response.data);
        },
        function(error) {
            alert(error);
        })
    }
});