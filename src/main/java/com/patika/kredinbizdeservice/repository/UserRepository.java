package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class UserRepository {

    private final List<User> userList = new ArrayList<>();

    @PostConstruct
    private void init() {
        createRandomUsers(10);
    }

    public void save(User user) {
        userList.add(user);
    }

    public List<User> getAll() {
        return userList;
    }

    public Optional<User> findByEmail(String email) {
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public Optional<User> getRandom() {
        return userList.stream()
                .skip(new Random().nextInt(userList.size())) // Rastgele bir önceki konumu atla
                .findFirst();
    }

    public void delete(User user) {
        userList.remove(user);
    }

    public LocalDate getRandomBirthDate() {
        Random random = new Random();
        return LocalDate.now().minusYears(random.nextInt(50) + 18).minusMonths(random.nextInt(11)).minusDays(random.nextInt(30));
    }

    public void createRandomUsers(int count) {
        String[] names = new String[]{"Alper", "Alper2", "Alper3", "Alper4", "Alper5", "Alper6", "Alper7", "Alper8", "Alper9", "Alper10", "Alper11", "Alper12"};

        // Belirtilen sayıda rastgele kullanıcı oluştur

        User defUser = new User("Cem", "Cem", getRandomBirthDate(),
                "cemdrman@gmail.com", "şifre", "+9000000000", true);
        save(defUser);
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            save(new User(names[random.nextInt(names.length)], "surname",
                    getRandomBirthDate(), "user" + i + "@gmail.com",
                    "şifre", "+90536000000", true));
        }
    }
}
