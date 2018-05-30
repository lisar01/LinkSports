package Application.DAOs.impl;

import Application.DAOs.UserDAOCustom;
import Application.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAOCustom {

    @PersistenceContext
    private EntityManager entityManager;

    //Ejemplo
    @Override
    public List getFirstNamesLike(String firstName) {
        Query query = entityManager.createNativeQuery("SELECT * FROM linkedindeportistas.user as user" +
                "WHERE user.firstname LIKE ?", User.class);
        query.setParameter(1, firstName + "%");
        return query.getResultList();
    }
}
