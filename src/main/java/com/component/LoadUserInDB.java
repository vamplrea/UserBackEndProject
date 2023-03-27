package com.component;

import com.model.User;
import com.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
//@Transactional
public class LoadUserInDB implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String ...args) throws Exception{

        User user1 = new User("Nguyen","A","nguyenA", UUID.randomUUID().toString(), 29,"US");
        User user2 = new User("Nguyen","B","nguyenB", UUID.randomUUID().toString(),22,"US");
        User user3 = new User("Nguyen","C","guyenC", UUID.randomUUID().toString(),26,"US");
        User user4 = new User("Nguyen","D","nguyenD", UUID.randomUUID().toString(),27,"US");
        User user5 = new User("Nguyen","E","nguyenE", UUID.randomUUID().toString(),21,"US");
        User user6 = new User("Nguyen","F","nguyenF", UUID.randomUUID().toString(),33,"US");
        User user7 = new User("Nguyen","G","nguyenG", UUID.randomUUID().toString(),77,"US");
        User user8 = new User("Nguyen","H","nguyenH", UUID.randomUUID().toString(),88,"US");
        User user9 = new User("Nguyen","L","nguyenL", UUID.randomUUID().toString(),29,"US");
        User user10 = new User("Nguyen","K","nguyenK", UUID.randomUUID().toString(),50,"US");
        User user11 = new User("Nguyen","I","nguyenI", UUID.randomUUID().toString(),56,"US");

        List<User> usersList = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11) ;
        usersList = usersList.stream().map(user -> {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return user;
        }).collect(Collectors.toList());
        userRepository.saveAll(usersList);
    }

}