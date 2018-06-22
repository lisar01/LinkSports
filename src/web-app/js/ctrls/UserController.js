function UserController($scope, $state, UserService) {
    $scope.deportes = ["Football", "Basketball", "Rugby", "Tenis", "Volley", "Jockey", "Handball"];
    $scope.currentUserId = null;

    $scope.login = function () {
        const logininfo = {"username": $scope.username, "password": $scope.password};
        UserService.login(logininfo)
        .then(function (response) {
            $scope.currentUser = $scope.username;
            $state.go('mainPage');
        },
        function (error) {
            alert(JSON.stringify(error.data.body));
        })
    };

    $scope.signup = function () {
        $('#success_signup').hide();
        $('#error_signup').hide();
        const user = {
            "username": $scope.username_signup,
            "password": $scope.password_signup,
            "nombre": $scope.nombre,
            "apellido": $scope.apellido,
            "deporte": $scope.deporte,
            "tipo": $scope.tipo,
            "genero": $scope.genero
        };
        UserService.signup(user)
        .then(function (response) {
            $('#success_signup').show();
        },
        function (error) {
            $('#error_signup').show();
        })
    }

    $scope.addContact = function(contact) {
        const addContactInfo = {"sender": $scope.currentUser, "receiver": contact};
        UserService.addContact(addContactInfo)
        .then(function(response) {
            alert("Se agrego el contacto a tu lista.");
        },
        function (error) {
            alert(JSON.stringify(error.data.body));
        });
    }
}