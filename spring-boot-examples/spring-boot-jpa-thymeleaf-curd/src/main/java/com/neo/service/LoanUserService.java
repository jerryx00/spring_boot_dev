package com.neo.service;

import com.neo.entity.LoanUser;

import java.util.List;

public interface LoanUserService {

    public List<LoanUser> getUserList();

    public List<LoanUser> findByStatusIs(String status);

    public LoanUser findLoanUserById(long id);

    public void save(LoanUser user);

    public int updateStatus(String status, long id);

    public void edit(LoanUser user);

    public void delete(long id);


}
