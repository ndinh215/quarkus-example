package db.dao;

import db.dto.UserDto;
import db.quarkus.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Singleton
public class UserDao {
    @Inject
    private EntityManager entityManager;

    public void persist(User user) {
        entityManager.persist(user);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public List<User> findByName(String lastName) {
        return entityManager.createQuery("FROM User WHERE lastName = :lastName")
                .setParameter("lastName", lastName)
                .getResultList();
    }

    public List<User> findBornAfter(Date date) {
        return entityManager.createQuery("FROM User WHERE birth > :date")
                .setParameter("date", date)
                .getResultList();
    }
}
