package com.cpy.screenculturemanagement.entity;

import io.geekidea.springbootplus.framework.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;

/**
 * 
 *
 * @author wanght
 * @since 2020-10-12
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("t_warehouserecord")
@ApiModel(value = "Warehouserecord对象")
public class Warehouserecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空", groups = {Update.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "客户手机不能为空")
    @ApiModelProperty("客户手机")
    private String customerphone;

    @NotBlank(message = "器材唯一码不能为空")
    @ApiModelProperty("器材唯一码")
    private String equipmentsinglecode;

    private Date outTime;

    private Date inTime;

    @NotBlank(message = "操作名称（出库，入库）不能为空")
    @ApiModelProperty("操作名称（出库，入库）")
    private String operatype;

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}
