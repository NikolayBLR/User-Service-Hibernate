package org.example.repository;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.utilita_hibernate.HibernateUtilita;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Slf4j
public class UserRepository {

    public User saveUser(User user) {
        Session session = HibernateUtilita.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            log.info("Создан и сохранен в базу данных пользователь: (id = {}, name = {}, email = {}, age = {}, created_at = {})",
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAge(),
                    user.getCreated_at());

            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        } finally {
            session.close();
        }

    }

    public User getUser(Integer id) {
        Session session = HibernateUtilita.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            transaction.commit();
            if (user == null) {
                log.info("Пользователь не найден с указанным id = {}", id);
                return null;
            }
            if (user != null) {
                log.info("Получен пользователь: (id = {}, name = {}, email = {}, age = {}, created_at = {})",
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getAge(),
                        user.getCreated_at());
            }
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        } finally {
            session.close();
        }

    }

    public User deleteUser(Integer id) {
        Session session = HibernateUtilita.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user == null) {
                log.info("Пользователь не найден с указанным id = {}", id);
                return null;
            }
            session.remove(user);
            transaction.commit();
            log.info("Удален пользователь: (id = {}, name = {}, email = {}, age = {}, created_at = {})",
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAge(),
                    user.getCreated_at());
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        } finally {
            session.close();
        }
    }

    public User updateUser(Integer id, User user) {
        Session session = HibernateUtilita.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            User user1 = session.get(User.class, id);
            if (user1 == null) {
                log.info("Пользователь не найден с указанным id = {}", id);
                return null;
            }
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            user1.setAge(user.getAge());
            user1.setCreated_at(user.getCreated_at());
            transaction.commit();
            if (user1 != null) {
                log.info("Обновлен пользователь: (id = {}, name = {}, email = {}, age = {}, created_at = {})",
                        user1.getId(),
                        user1.getName(),
                        user1.getEmail(),
                        user1.getAge(),
                        user1.getCreated_at());
            }
            return user1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        } finally {
            session.close();
        }
    }
}
