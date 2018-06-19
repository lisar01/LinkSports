const routes = function ($stateProvider, $urlRouterProvider) {

    $stateProvider

        .state('login', {
            url: "/login",
            templateUrl: "../partials/login-register.html",
            controller: "UserController as UserCtrl"
        })

        // .state('register', {
        //     url: "/reg",
        //     templateUrl: "../partials/registro.html",
        //     controller: "UsuarioController as UserCtrl"
        // })

        .state('mainPage', {
            url: "/main",
            templateUrl: "../partials/main.html",
            controller: "SearchController as SearchCtrl"
        });


    $urlRouterProvider.otherwise("/login");

};
