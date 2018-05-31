package Application.DAOs;

import Application.Model.User;

import java.util.List;

public interface UserDAOCustom {
    //Es necesario hacer una custom interface si se quiere agregar comportamiento extra al DAO
    User getByUsername(String username) throws Exception;
    List getFirstNamesLike(String firstName);
}
