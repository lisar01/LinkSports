package Application.DAOs;

import Application.Model.User;

import java.util.List;

public interface UserDAOCustom {
    //Es necesario hacer una custom interface si se quiere agregar comportamiento extra al DAO
    boolean checkLogin(User user);
    boolean existsByUsername(String username);
    List<User> getByDeporte(String deporte);
    User get(User user);
    void update(User user);
}
