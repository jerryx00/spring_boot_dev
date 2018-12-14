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
package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.core.common.node.ZTreeNode;
import cn.stylefeng.guns.modular.system.dao.DeptMapper;
import cn.stylefeng.guns.modular.system.model.Dept;
import cn.stylefeng.guns.modular.system.service.IDeptService;
import cn.stylefeng.guns.modular.system.service.IOrderService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 部门服务
 *
 * @author fengshuonan
 * @Date 2018/10/15 下午11:39
 */
@Service
public class OrderServiceImpl implements IOrderService {


    @Override
    public String getPrice(String deptId) {
        return "10";
    }

    @Override
    public String getResponse(String deptId) {
        return null;
    }

    @Override
    public String getRequest(String deptId) {
        return null;
    }
}
