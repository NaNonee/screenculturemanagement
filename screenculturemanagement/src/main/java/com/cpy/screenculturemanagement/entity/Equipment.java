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
@TableName("t_equipment")
@ApiModel(value = "Equipment对象")
public class Equipment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "器材唯一码不能为空")
    @ApiModelProperty("器材唯一码")
    @TableId(value = "singlecode", type = IdType.AUTO)
    private String singlecode;

    @NotNull(message = "类别id不能为空")
    @ApiModelProperty("类别id")
    private Integer classfyid;

    @NotNull(message = "型号id不能为空")
    @ApiModelProperty("型号id")
    private Integer modelid;

    @NotBlank(message = "器材序列号不能为空")
    @ApiModelProperty("器材序列号")
    private String serialcode;

    @ApiModelProperty("购买时间")
    private Date purchaseTime;

    @ApiModelProperty("保险生效日期")
    private Date insuranceTime;

    @ApiModelProperty("来源渠道")
    private String source;

    @NotNull(message = "保期（单位/年）不能为空")
    @ApiModelProperty("保期（单位/年）")
    private Integer durationdate;

    @ApiModelProperty("在保状态（保险生效日期+保期判断，非国行all不在保）")
    private String insuranceState;

    @ApiModelProperty("器材状态（在库，出库，维修，已下架）")
    private String equipmentState;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("备注")
    private String remark;

}
