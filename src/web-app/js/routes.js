const routes = function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/login");

    $stateProvider

        .state('loginPage', {
            url: "/login",
            templateUrl: "../partials/login-register.html",
            controller: "UserController as UserCtrl"
        })

        .state('mainPage', {
            url: "/main",
            templateUrl: "../partials/main.html",
            controller: "SearchController as SearchCtrl"
        })

        .state('editarPage', {
            url: "/editar",
            templateUrl: "../partials/editar.html",
            controller: "EditarController as EditCtrl"
        })

        .state('aboutPage', {
            url: "/about",
            templateUrl: "../partials/about.html"
        });

};
