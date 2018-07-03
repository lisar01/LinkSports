function UserController($scope, $state, UserService) {
    $scope.deportes = ["Football", "Basketball", "Rugby", "Tenis", "Volley", "Jockey", "Handball"];

    $scope.login = function () {
        const logininfo = {"username": $scope.username, "password": $scope.password};
        UserService.login(logininfo)
          .then(function (response) {
                    UserService.userLoggeado = response.data;
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

    $scope.follow = function(userToFollow) {
        const followData = {"loggedUsername": $scope.username, "toFollow": userToFollow};
        UserService.follow(followData)
        .then(function(response) {
            $state.reload();
        },
        function (error) {
            alert(JSON.stringify(error.data.body));
        });
    }

    $scope.isFollowing = function(user) {
        for(let i=0; i < user.followers.length; i++) {
            if(user.followers[i].username == $scope.username) return true;
        }
        return false;
    }
}