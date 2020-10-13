package com.cpy.screenculturemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpy.screenculturemanagement.entity.Barcode;
import com.cpy.screenculturemanagement.param.BarcodePageParam;
import com.cpy.screenculturemanagement.vo.BarcodeQueryVo;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 *  Mapper 接口
 *
 * @author wanght
 * @since 2020-10-12
 */
@Repository
public interface BarcodeMapper extends BaseMapper<Barcode> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    BarcodeQueryVo getBarcodeById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param barcodePageParam
     * @return
     */
    IPage<BarcodeQueryVo> getBarcodePageList(@Param("page") Page page, @Param("param") BarcodePageParam barcodePageParam);

}
