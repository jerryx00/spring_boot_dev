package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author
 * @since 2017-07-11
 */

@Data
public class Order {

    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String desc;


}
