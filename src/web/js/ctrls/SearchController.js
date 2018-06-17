angular.module("LinkSports", [])

.controller("SearchController", SearchController);


class SearchController {

    constructor(UserService) {
        this.userService = UserService;
        this.resultados = undefined;
        this.deporte = undefined;
        this.search();
    }

    search() {
        const self = this;
        this.searchResultados().then((response) => {self.resultados = response.data})
    }

    searchResultados() {
        if (angular.isUndefined(this.deporte)) return this.userService.getAll();
        else return this.userService.search(this.deporte);
    }

}
