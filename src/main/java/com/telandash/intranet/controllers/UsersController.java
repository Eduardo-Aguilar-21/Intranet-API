package com.telandash.intranet.controllers;

import com.telandash.intranet.models.UsersModel;
import com.telandash.intranet.services.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UsersController {
    @Autowired
    private UsersService userService;

    @GetMapping("/info")
    public ResponseEntity<UsersModel>findUserByUsername(@RequestParam String username ){
        Optional<UsersModel> data = userService.findUserByUsername(username);
        return data.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UsersModel>> getAll(){
        List<UsersModel> data = userService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsersModel> createUser(@RequestBody UsersModel usersModel){
        return new ResponseEntity<>(usersModel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersModel> updateUser(@PathVariable Long id, @RequestBody UsersModel usersModel){
        UsersModel data = userService.updateUser(id, usersModel);
        return data != null ?
                new ResponseEntity<>(data, HttpStatus.OK):
                ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public  ResponseEntity<UsersModel> deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
