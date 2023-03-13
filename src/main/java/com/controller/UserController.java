package com.controller;

import com.model.User;
import com.service.UserService;
import com.service.imp.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
//    public List<User> findAll(){
//        return userService.findAll();
//    };
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<List<User>>(userService.findAll(),HttpStatus.OK);
    };

    @GetMapping("/{id}")
//    public User findById(@PathVariable Long id){
//        Optional<User> userOpt = userService.findById(id);
//        if(userOpt.isPresent()){
//            return userOpt.get();
//        }
//        return null;
//    }
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<User> userOpt = userService.findById(id);
        if(userOpt.isPresent()){
            return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        userService.add(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<User> userOpt = userService.delete(id);
        if(userOpt.isPresent()){
            return new ResponseEntity<User>(userOpt.get(),HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user){
        Optional<User> optUser = userService.update(user);
        if(optUser.isPresent()){
            return new ResponseEntity<User>(optUser.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}

