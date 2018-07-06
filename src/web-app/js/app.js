angular.module('linkSportsApp', ['ui.router'])
    .service("UserService", UserService)
    .service("SportService", SportService)
    .controller('UserController', UserController)
    .controller('SearchController', SearchController)
    .controller('EditarController', EditarController)
    .controller('VerPerfilController', VerPerfilController)
    .controller('HeaderController', HeaderController)
    .config(routes);
    