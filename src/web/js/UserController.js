angular.module("LinkSports", [])

.controller("UserController", function($scope, $http) {
    var url = "http://localhost:8080/User";
    $scope.deportes = ["Futbol", "Basketball", "Rugby", "Tenis", "Volley", "Jockey", "Handball"];

    $scope.login = function() {
        $http({
            method: 'POST',
            url: url + "/login",
            data: {"username": $scope.username, "password": $scope.password}
        })
        .then(function(response) {
            alert(JSON.stringify(response.data.body));
            window.location.href = "main.html";
        },
        function(error) {
            alert(JSON.stringify(error.data.body));
        })
    }
    $scope.signup = function() {
        $('#success_signup').hide();
        $('#error_signup').hide();
        $http({
            method: 'POST',
            url: url,
            data: {"username": $scope.username_signup, 
                   "password": $scope.password_signup,
                   "nombre": $scope.nombre,
                   "apellido": $scope.apellido,
                   "deporte": $scope.deporte,
                   "tipo": $scope.tipo,
                   "genero": $scope.genero }
        })
        .then(function(response) {
            $('#success_signup').show();
        },
        function(error) {
            $('#error_signup').show();
        })
    }
});