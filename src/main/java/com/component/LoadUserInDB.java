package com.component;

import com.model.User;
import com.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class LoadUserInDB implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String ...args) throws Exception{

        User user = new User("Nguyen","D", 29,"US");
        userRepository.save(user);
        userRepository.save( new User( "Nguyen","A", 25,"US"));
        userRepository.save(new User( "Nguyen","B", 27,"VN"));
        userRepository.save(new User( "Nguyen","C", 29,"TL"));

    }

}
