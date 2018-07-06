class UserService {

    constructor($http) {
        this.http = $http;
        this.baseurl = "http://localhost:8080/User";
        this.userLoggeado = undefined;
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
        return this.http.get(this.baseurl + "/search?deporte=" + deporte);
    }

    follow(followData) {
        return this.http({
            method: "POST",
            url: this.baseurl + "/follow",
            data: followData
        })
    }

    editar() {
        return this.http.put(this.baseurl + "/editar", this.userLoggeado)
    }

    setPassword(password) {
        this.userLoggeado.password = password;
    }

    setNombre(nombre) {
        this.userLoggeado.nombre = nombre;
    }

    setApellido(apellido) {
        this.userLoggeado.apellido = apellido;
    }

    setDeporte(deporte) {
        this.userLoggeado.deporte = deporte;
    }

    setTipo(tipo) {
        this.userLoggeado.tipo = tipo;
    }

}