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
@ApiModel(value = "ModelQueryVo对象")
public class ModelQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty("型号名称")
    private String modelname;

    @ApiModelProperty("型号码")
    private String modelcode;

    @ApiModelProperty("标准配件")
    private String standardpart;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private String remark;
}