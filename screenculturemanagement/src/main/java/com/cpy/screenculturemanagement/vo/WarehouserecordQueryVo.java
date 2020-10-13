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
@ApiModel(value = "WarehouserecordQueryVo对象")
public class WarehouserecordQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty("客户手机")
    private String customerphone;

    @ApiModelProperty("器材唯一码")
    private String equipmentsinglecode;

    private Date outTime;

    private Date inTime;

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