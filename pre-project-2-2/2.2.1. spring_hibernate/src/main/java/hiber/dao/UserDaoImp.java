package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {

        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public Optional<User> getUserByCar(String model, Integer series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car.model = :model and car.series = :series", User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        try {
            User user = query.getSingleResult();
            Optional<User> userOp = Optional.of(user);
            return userOp;
        } catch (PersistenceException e) {
            return Optional.empty();
        }
    }
}
