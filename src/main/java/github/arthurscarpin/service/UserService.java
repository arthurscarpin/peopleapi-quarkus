package github.arthurscarpin.service;

import github.arthurscarpin.domain.User;
import github.arthurscarpin.exceptions.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    @Transactional
    public User create(User user) {
        User.persist(user);
        return user;
    }

    public List<User> findAll(Integer page, Integer size) {
        return User.findAll().page(page, size).list();
    }

    public User finById(UUID id) {
        return (User) User.findByIdOptional(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Transactional
    public User updateById(UUID id, User updateUser) {
        User user = finById(id);
        user.name = updateUser.name;
        user.email = updateUser.email;
        User.persist(user);
        return user;
    }

    @Transactional
    public void deleteById(UUID id) {
        User user = finById(id);
        user.delete();
    }
}
