/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.modular.api;

import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.core.util.JwtTokenUtil;
import cn.stylefeng.guns.modular.system.dao.UserMapper;
import cn.stylefeng.guns.modular.system.model.Order;
import cn.stylefeng.guns.modular.system.model.User;
import cn.stylefeng.guns.modular.system.service.IDeptService;
import cn.stylefeng.guns.modular.system.service.IOrderService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ErrorResponseData;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 接口控制器提供
 *
 * @author stylefeng
 * @Date 2018/7/20 23:39
 */
@RestController
@RequestMapping("/v1/order")
public class OrderController extends BaseController {

    @Autowired
    private IOrderService orderService;

    /**
     * http://localhost:8080/v1/order/getRes?username=1&password=2
     */
    @RequestMapping("/getRes")
    public Object getRes(@RequestParam("username") String username,
                       @RequestParam("password") String password) {
        boolean passwordTrueFlag = false;

        if (username.equalsIgnoreCase("1")) {
            HashMap<String, Object> result = new HashMap<>();
            List<Order> list = new ArrayList();
            Order order = new Order();
            order.setName("10M流量包");
            order.setDesc("测试");
            list.add(order);
            list.add(order);

            result.put("price",orderService.getPrice("1"));
            result.put("username",username);
            result.put("password",password);

            result.put("order", list);
            return result;
        } else {
            return new ErrorResponseData(500, "账号密码错误！");
        }
    }

    /**
     * 测试接口是否走鉴权
     */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Object test() {
        return SUCCESS_TIP;
    }

}

