angular.module("LinkSports", [])

.controller("SearchController", function($scope, $http) {
    var url = "http://localhost:8080/Search";
    $scope.users = ["Usuario 1", "Usuario 2", "Usuario 3", "Usuario 4", "Usuario 5", "Usuario 6"];

    $scope.search = function() {
        $http({
            method: 'GET',
            url: url + "/login",
            data: {"nombre": $scope.search_input}
        })
        .then(function(response) {
            alert(JSON.stringify(response.data.body));
        },
        function(error) {
            alert(JSON.stringify(error.data.body));
        })
    }
});