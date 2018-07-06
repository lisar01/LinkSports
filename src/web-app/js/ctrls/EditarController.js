class EditarController {

    constructor(UserService, SportService, $state) {
        this.userService = UserService;
        this.deportes = SportService.deportes;
        this.perfilNuevo =  undefined;
        this.passInfo = undefined;
        this.crearPassInfo();
        this.crearPerfilNuevo();
    }

    crearPerfilNuevo() {
        this.perfilNuevo= {
            "nombre": undefined,
            "apellido": undefined,
            "deporte": undefined,
            "tipo": undefined
        };
    }

    crearPassInfo() {
        this.passInfo = {
            "antigua": undefined,
            "nueva": undefined,
            "deConfirmacion": undefined
        };
    }

    getUserLoggeado() {
        return this.userService.userLoggeado;
    }

    editarPass() {
        if(this.esMismaContraseniaAntigua() && this.esMismaContraseniaNueva()) {
            this.userService.setPassword(this.passInfo.nueva);
            this.userService.editar()
                .then(response => {
                    this.crearPassInfo();
                    this.mostrarAlerta("#new-password-success")
                })
        }
        else {
            if(! this.esMismaContraseniaNueva()) {
                this.mostrarAlerta("#new-password-error");
            }
            if(! this.esMismaContraseniaAntigua()) {
                this.mostrarAlerta("#old-password-error");
            }
        }

    }

    esMismaContraseniaNueva() {
        return this.passInfo.nueva === this.passInfo.deConfirmacion;
    }

    esMismaContraseniaAntigua() {
        return this.passInfo.antigua === this.getUserLoggeado().password;
    }

    editarPerfil() {
        this.mergeUser();
        this.userService.editar()
            .then(response => {
                this.crearPerfilNuevo();
                this.mostrarAlerta("#new-profile-success")
            })
    }

    mergeUser() {
        if (angular.isDefined(this.perfilNuevo.nombre)) this.userService.setNombre(this.perfilNuevo.nombre);
        if (angular.isDefined(this.perfilNuevo.apellido)) this.userService.setApellido(this.perfilNuevo.apellido);
        if (angular.isDefined(this.perfilNuevo.deporte)) this.userService.setDeporte(this.perfilNuevo.deporte);
        if (angular.isDefined(this.perfilNuevo.tipo)) this.userService.setTipo(this.perfilNuevo.tipo);
    }

    mostrarAlerta(alerta) {
        $(alerta).fadeTo(2000, 500).slideUp(500, function(){
            $(alerta).slideUp(500);
        });
    }

}