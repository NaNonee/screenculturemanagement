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
@ApiModel(value = "EquipmentQueryVo对象")
public class EquipmentQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("器材唯一码")
    private String singlecode;

    @ApiModelProperty("类别id")
    private Integer classfyid;

    @ApiModelProperty("型号id")
    private Integer modelid;

    @ApiModelProperty("器材序列号")
    private String serialcode;

    @ApiModelProperty("购买时间")
    private Date purchaseTime;

    @ApiModelProperty("保险生效日期")
    private Date insuranceTime;

    @ApiModelProperty("来源渠道")
    private String source;

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