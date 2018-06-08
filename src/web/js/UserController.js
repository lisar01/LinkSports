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
            alert(JSON.stringify(response.data.body));
        },
        function(error) {
            alert(JSON.stringify(error.data.body));
        })
    }
});