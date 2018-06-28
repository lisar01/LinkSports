package Application.DAOs.impl;

import Application.DAOs.UserDAOCustom;
import Application.Model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAOCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean checkLogin(User user) {
        return this.get(user) != null;
    }

    @Override
    public boolean existsByUsername(String username) {
        String queryStr = "SELECT * FROM linksports.user WHERE username LIKE :username";
        Query query = em.createNativeQuery(queryStr, User.class);
        query.setParameter("username", username);
        return query.getResultList().size() == 1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getByDeporte(String deporte) {
        String queryStr = "SELECT * FROM linksports.user WHERE deporte LIKE :deporte";
        Query query = em.createNativeQuery(queryStr, User.class);
        query.setParameter("deporte", deporte);
        return (List<User>) query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User get(User user) {
        String queryStr = "SELECT * FROM linksports.user WHERE username LIKE :username and password LIKE :password";
        Query query = em.createNativeQuery(queryStr, User.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());

        List<User> userPosible = query.getResultList();

        if (userPosible.isEmpty()) return null;
        else return userPosible.get(0);
    }

    @Override
    @Transactional
    public void update(User user) {
        String queryStr = "UPDATE user SET " +
                "password= :password, " +
                "nombre= :nombre, " +
                "apellido = :apellido, " +
                "deporte= :deporte, " +
                "tipo=:tipo " +
                "WHERE username = :username";

        Query query = em.createNativeQuery(queryStr);

        query.setParameter("password", user.getPassword());
        query.setParameter("nombre", user.getNombre());
        query.setParameter("apellido",user.getApellido());
        query.setParameter("deporte", user.getDeporte());
        query.setParameter("tipo", user.getTipo());
        query.setParameter("username", user.getUsername());

        query.executeUpdate();
    }


}
