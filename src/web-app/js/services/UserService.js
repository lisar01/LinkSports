class UserService {

    constructor($http) {
        this.http = $http;
        this.baseurl = "http://localhost:8080/User";
    }

    login(logininfo) {
        return this.http({
            method: 'POST',
            url: this.baseurl + "/login",
            data: logininfo
        })
    }

    signup(user) {
        return this.http({
            method: 'POST',
            url: this.baseurl,
            data: user
        })
    }

    getAll() {
        return this.http.get(this.baseurl);
    }

    search(deporte) {
        return this.http.get(this.baseurl + '/search', {'deporte': deporte});
    }

}