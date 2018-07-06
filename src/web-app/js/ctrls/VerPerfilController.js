class VerPerfilController {

    constructor(UserService) {
        this.userService = UserService;
    }

    getUsername() {
        return this.userService.userLoggeado.username;
    }

    getNombre() {
        return this.userService.userLoggeado.nombre;
    }

    getApellido() {
        return this.userService.userLoggeado.apellido;
    }

    getDeporte() {
        return this.userService.userLoggeado.deporte;
    }

    getTipo() {
        return this.userService.userLoggeado.tipo;
    }

}