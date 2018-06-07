package Application.DAOs.impl;

import Application.DAOs.UserDAO;
import Application.DAOs.UserDAOCustom;
import Application.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAOCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean checkLogin(User user) {
        Query query = entityManager.createNativeQuery("SELECT * FROM linksports.user " +
                "WHERE username LIKE :username and password LIKE :password", User.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        return query.getSingleResult() != null;
    }

    //Ejemplo
    @Override
    public List getFirstNamesLike(String firstName) {
        Query query = entityManager.createNativeQuery("SELECT * FROM linksports.user as user" +
                "WHERE user.firstname LIKE ?", User.class);
        query.setParameter(1, firstName + "%");
        return query.getResultList();
    }
}
