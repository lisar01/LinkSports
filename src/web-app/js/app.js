angular.module('linkSportsApp', ['ui.router'])
    .service("UserService", UserService)
    .controller('UserController', UserController)
    .controller('SearchController', SearchController)
    .config(routes);
    