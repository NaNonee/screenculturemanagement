package com.cpy.screenculturemanagement.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *  查询结果对象
 * </pre>
 *
 * @author wanght
 * @date 2020-10-12
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CustomerQueryVo对象")
public class CustomerQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty("会员名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    private String email;

    private String address;

    @ApiModelProperty("身份证号")
    private String cardID;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private String remark;
}