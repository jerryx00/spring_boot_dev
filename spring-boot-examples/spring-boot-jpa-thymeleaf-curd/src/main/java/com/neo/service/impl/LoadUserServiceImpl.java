package com.neo.service.impl;

import com.neo.entity.LoanUser;
import com.neo.repository.LoanUserRepository;
import com.neo.service.LoanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadUserServiceImpl implements LoanUserService {

    @Autowired
    private LoanUserRepository userRepository;

    @Override
    public List<LoanUser> getUserList() {
        return userRepository.findAll();
    }
    @Override
    public List<LoanUser> findByStatusIs(String status) {
        return userRepository.findByStatusIs(status);
    }
    @Override
    public int updateStatus(String status, long id) {
        return userRepository.updateStatus(status, id);
    }

    @Override
    public LoanUser findLoanUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(LoanUser user) {
        userRepository.save(user);
    }

    @Override
    public void edit(LoanUser user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}


