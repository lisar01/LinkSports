package Application.DAOs.impl;

import Application.DAOs.UserDAOCustom;
import Application.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAOCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean checkLogin(User user) {
        String queryStr = "SELECT * FROM linksports.user WHERE username LIKE :username and password LIKE :password";
        Query query = em.createNativeQuery(queryStr, User.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        return query.getResultList().size() == 1;
    }

    @Override
    public User getByUsername(String username) {
        String queryStr = "SELECT * FROM linksports.user WHERE username LIKE :username";
        Query query = em.createNativeQuery(queryStr, User.class);
        query.setParameter("username", username);
        try {
            return (User) query.getSingleResult();
        }
        catch (Exception ex) { return null; }
    }

    //Ejemplo
    @Override
    public List getFirstNamesLike(String firstName) {
        Query query = em.createNativeQuery("SELECT * FROM linksports.user as user" +
                "WHERE user.firstname LIKE ?", User.class);
        query.setParameter(1, firstName + "%");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getByDeporte(String deporte) {
        String queryStr = "SELECT * FROM linksports.user WHERE deporte LIKE :deporte";
        Query query = em.createNativeQuery(queryStr, User.class);
        query.setParameter("deporte", deporte);
        return (List<User>) query.getResultList();
    }


}
