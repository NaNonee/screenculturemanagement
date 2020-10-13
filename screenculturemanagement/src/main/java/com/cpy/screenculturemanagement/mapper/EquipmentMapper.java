package com.cpy.screenculturemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpy.screenculturemanagement.entity.Equipment;
import com.cpy.screenculturemanagement.param.EquipmentPageParam;
import com.cpy.screenculturemanagement.vo.EquipmentQueryVo;

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
public interface EquipmentMapper extends BaseMapper<Equipment> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    EquipmentQueryVo getEquipmentById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param equipmentQueryParam
     * @return
     */
    IPage<EquipmentQueryVo> getEquipmentPageList(@Param("page") Page page, @Param("param") EquipmentPageParam equipmentPageParam);

}
