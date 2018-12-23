package com.neo.repository;


import com.neo.entity.LoanUser;
import com.neo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface LoanUserRepository extends JpaRepository<LoanUser, Long> {

    LoanUser findById(long id);

    Long deleteById(Long id);

    @Transactional
    @Modifying
    @Query("update LoanUser u set u.status = ?1 where u.id = ?2")
    int updateStatus(@Param("status")String status, @Param("id")long id);

    List<LoanUser> findByStatusIs(@Param("status")String status);
}