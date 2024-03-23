package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getByEmail(String email) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        User user = null;

        //User user = foundUser.orElseThrow(RuntimeException::new);

        if (foundUser.isPresent()) {
            user = foundUser.get();
        }
        return user;

    }

    @Override
    public User update(String email, User user) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        foundUser.get().setName(user.getName());

        foundUser.get().setSurname(user.getSurname());

        userRepository.delete(user);

        userRepository.save(foundUser.get());

        return foundUser.get();
    }

    @Override
    public User getRandom() {
        Optional<User> randomUser = userRepository.getRandom();
        User user = null;
        if (randomUser.isPresent()) {
            user = randomUser.get();
        }
        return user;
    }
}
