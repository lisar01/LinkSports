
class HeaderController {

    constructor(UserService, $state) {
        this.userService = UserService;
        this.state = $state;
    }

    logOut() {
        this.userService.userLoggeado = undefined;
        this.state.go("loginPage");
    }

    hayUserLoggeado() {
        return angular.isDefined(this.userService.userLoggeado);
    }

    irAHome() {
        if(this.hayUserLoggeado()) {
            this.state.go("mainPage");
        }
        else {
            this.state.go("loginPage");
        }
    }

}