package com.example.project.Service;

import com.example.project.Repository.UserRepository;
import com.example.project.Service.Imp.UserImp;
import com.example.project.Utils.ConvertRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConvertRelationship convertRelationship;
}
