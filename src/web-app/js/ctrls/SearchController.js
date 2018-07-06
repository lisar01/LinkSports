class SearchController {

    constructor(UserService, SportService, $state) {
        this.userService = UserService;
        this.state = $state;
        this.resultados = undefined;
        this.deportes = SportService.sportsToSearch();
        this.search("None")
    }

    search(deporte) {
        const self = this;
        this.searchResultados(deporte).then((response) => {self.resultados = response.data})
    }

    searchResultados(deporte) {
        if (deporte === "None") return this.userService.getAll();
        else return this.userService.search(deporte);
    }

    // noinspection JSMethodCanBeStatic
    imagenDe(user) {
        if (user.tipo === "Coach") return "/imagenes/whistle.png";
        else return "/imagenes/sneaker.png";
    }

    hayResultados() {
        return ! (angular.isUndefined(this.resultados) || !this.resultados.length);
    }

    goToEditarPage() {
        this.state.go("editarPage");
    }

}
