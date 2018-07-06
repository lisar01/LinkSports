class SportService {

    constructor($http) {
        this.deportes = ["Baseball", "Basket", "Boxeo", "Football", "Golf",
            "Jockey", "Rugby", "Tenis", "Volley"]
    }

    sportsToSearch() {
        const lssports2 = this.deportes.slice(5,9);
        lssports2.push("None");
        return [this.deportes.slice(0,5), lssports2]
    }

}