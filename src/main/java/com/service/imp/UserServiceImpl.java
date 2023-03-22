package com.service.imp;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepository userRepository;




    @Override
    public List<User> findAll(){
        return userRepository.findAll();
       // return usersList.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long id) {
        //return usersList.stream().filter(user ->user.getId() ==id ).findFirst();
        return userRepository.findById(id);
    }

    @Override
    public void add(User user) {
        //user.setId(COUNTER++);
        //usersList.add(user);
        userRepository.save(user);

    }

    @Override
    public Optional<User> delete(Long id){
//        Optional<User> userOpt = usersList.stream().filter(user ->user.getId() ==id ).findFirst();
//
//        if(userOpt.isPresent()){
//            usersList = usersList.stream().filter(user -> userOpt.get().getId() != user.getId()).collect(Collectors.toList());
//            return userOpt;
//        }
//        return Optional.empty();
        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()){
            userRepository.delete(userOpt.get());
            return userOpt;
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> update(User user) {
        //Optional<User> userOpt = usersList.stream().filter(u ->u.getId() == user.getId() ).findFirst();
            Optional<User> userOpt = userRepository.findById(user.getId());
        if(userOpt.isPresent()){
            User existingUser = userOpt.get();

            if(user.getFirstName() != null ){
                existingUser.setFirstName(user.getFirstName());
            }
            if(user.getLastName() != null){
                existingUser.setLastName(user.getLastName());
            }
            if(user.getAge() != null){
                existingUser.setAge(user.getAge());
            }
            if(user.getCountry() != null){
                existingUser.setCountry(user.getCountry());
            }
//            usersList = usersList
//                    .stream()
//                    .filter( u -> u.getId() != existingUser.getId())
//                    .collect(Collectors.toList());
//            usersList.add(existingUser);
            userRepository.save(existingUser);
            return Optional.of(existingUser);
        }
        return Optional.empty();
    }

}
