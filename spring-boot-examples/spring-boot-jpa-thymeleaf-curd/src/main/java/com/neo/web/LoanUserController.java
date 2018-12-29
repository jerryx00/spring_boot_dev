package com.neo.web;

import com.neo.entity.LoanUser;
import com.neo.entity.User;
import com.neo.service.LoanUserService;
import com.neo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanUserController {

    private static org.apache.log4j.Logger logger = LogManager.getLogger("fileLogger");
    @Resource
    LoanUserService userService;

    @RequestMapping("/")
    @ApiOperation(value="获取全部LoanUser", notes="")
    public List listGetAll() {
       return listAll();
    }
    @RequestMapping("/all")
    public List listAll() {
        logger.info("running list method.");
        List<LoanUser> users = userService.getUserList();
        return users;
    }

    @GetMapping("/{id}")
    @ApiOperation(value="获取某个LoanUser", notes="参数为id")
    public LoanUser getUser(@PathVariable Long id) {
        {
            logger.info("running list method.");
            LoanUser users = userService.findLoanUserById(id);
            return users;
        }
    }
}

