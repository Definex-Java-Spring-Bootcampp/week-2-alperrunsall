package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.enums.ApplicationStatus;
import com.patika.kredinbizdeservice.model.*;
import com.patika.kredinbizdeservice.service.IBankService;
import com.patika.kredinbizdeservice.service.IUserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class ApplicationRepository {

    private final List<Application> applicationList = new ArrayList<>();
    @Autowired
    private IUserService userService;
    @Autowired
    private IBankService bankService;
    private final Random random = new Random();

    @PostConstruct
    private void init() {
        List<Bank> bankList = bankService.getAllBanks();
        int applicationCount = random.nextInt(20, 30);

        for (int i = 0; i < applicationCount; i++) {
            User user = userService.getRandom();
            Bank bank = bankList.get(random.nextInt(bankList.size()));
            Loan loan = bank.getLoanList().get(random.nextInt(bank.getLoanList().size()));
            CreditCard creditCard = bank.getCreditCards().get(random.nextInt(bank.getCreditCards().size()));

            Application application = new Application();
            application.setLoan(loan);
            //application.setCreditCard(creditCard);
            //application.setUser(user);
            application.setEmail(user.getEmail());
            application.setLocalDateTime(getRandomLocalDateTime());
            application.setApplicationStatus(ApplicationStatus.IN_PROGRESS);
            save(application);
            user.getApplicationList().add(application);
        }
    }

    public void save(Application application) {
        applicationList.add(application);
    }

    public List<Application> getAll() {
        return applicationList;
    }

    public List<Application> findByMail(String mail) {
        return applicationList.stream()
                .filter(application -> application.getEmail().equals(mail)) // getUser.getEmail ile de olabilir
                .collect(Collectors.toList());
    }

    public void delete(Application application) {
        applicationList.remove(application);
    }


    public LocalDateTime getRandomLocalDateTime() {
        return LocalDateTime.now().minusDays(random.nextInt(90));
    }

}
