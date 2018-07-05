class SearchController {

    constructor(UserService) {
        this.userService = UserService;
        this.resultados = undefined;
        this.deportes = [
            [ "Baseball", "Football", "Basket", "Rugby","Tenis"],
            ["Volley", "Jockey", "Boxeo", "Golf", "None"]
        ];
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
        return this.resultados.length
    }

}
