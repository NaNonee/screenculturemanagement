package com.cpy.screenculturemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpy.screenculturemanagement.entity.Warehouserecord;
import com.cpy.screenculturemanagement.param.WarehouserecordPageParam;
import com.cpy.screenculturemanagement.vo.WarehouserecordQueryVo;

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
public interface WarehouserecordMapper extends BaseMapper<Warehouserecord> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    WarehouserecordQueryVo getWarehouserecordById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param warehouserecordQueryParam
     * @return
     */
    IPage<WarehouserecordQueryVo> getWarehouserecordPageList(@Param("page") Page page, @Param("param") WarehouserecordPageParam warehouserecordPageParam);

}
