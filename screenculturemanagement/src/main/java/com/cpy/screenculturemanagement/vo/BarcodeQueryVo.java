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
@ApiModel(value = "BarcodeQueryVo对象")
public class BarcodeQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty("器材唯一码")
    private String equipmentsinglecode;

    @ApiModelProperty("条形码url")
    private String url;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;
}