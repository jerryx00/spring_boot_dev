package com.neo.schedule;

import com.neo.entity.User;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Component
public class Schedule
{

    @Value("${scheduled.enable}")
    private String scheduledEnable;

    public final static long ONE_Minute =  60 * 1000;

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob(){
        System.out.println((new Date())+" >>fixedDelay执行....");
    }

    @Scheduled(fixedRate=ONE_Minute)
    public void fixedRateJob(){
        System.out.println((new Date())+" >>fixedRate执行....");
    }

    @Scheduled(cron="0 15 3 * * ?")
    public void cronJob1(){ ;
        System.out.println((new Date())+" >>cron执行....");
    }

    @Scheduled(fixedRate = 6000)  //表示6秒执行一次
    public void cronJob2(){
        if(!Boolean.parseBoolean(scheduledEnable)){
            return;
        }
//        User u = userService.findUserById(1);
        User u = userRepository.findById(1);
        System.out.println((new Date())+" >>>>cron执行...." + u.toString());
    }

//0 0 3 * * ?     每天3点执行
//0 5 3 * * ?     每天3点5分执行
//0 5 3 ? * *     每天3点5分执行，与上面作用相同
//0 5/10 3 * * ?  每天3点的 5分，15分，25分，35分，45分，55分这几个时间点执行
//0 10 3 ? * 1    每周星期天，3点10分 执行，注：1表示星期天
//0 10 3 ? * 1#3  每个月的第三个星期，星期天 执行，#号只能出现在星期的位置
}
