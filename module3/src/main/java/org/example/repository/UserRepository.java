package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.model.User;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.Optional;

@AllArgsConstructor
public class UserRepository {

    private final SessionFactory sessionFactory;

    public boolean saveUser(User user) {
        try (Session session = sessionFactory.openSession();) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (HibernateException e) {
            return false;
        }
        return true;
    }

    public Optional<User> getUser(String login) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where login = :login", User.class);
            query.setParameter("login", login);
            return Optional.ofNullable(query.getSingleResultOrNull());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
