package com.telandash.intranet.services;

import com.telandash.intranet.models.UsersModel;
import com.telandash.intranet.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

}
