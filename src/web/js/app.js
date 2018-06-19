
angular.module("LinkSportsApp", ["ui-router"])
    .service('UserService', UserService)
    .controller('UserController', UserController)
    .controller('SearchController', SearchController)

.config(routes);