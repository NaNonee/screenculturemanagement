package com.cpy.screenculturemanagement.service;

import com.cpy.screenculturemanagement.entity.Equipment;
import com.cpy.screenculturemanagement.param.EquipmentPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import com.cpy.screenculturemanagement.vo.EquipmentQueryVo;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.io.Serializable;

/**
 *  服务类
 *
 * @author wanght
 * @since 2020-10-12
 */
public interface EquipmentService extends BaseService<Equipment> {

    /**
     * 保存
     *
     * @param equipment
     * @return
     * @throws Exception
     */
    boolean saveEquipment(Equipment equipment) throws Exception;

    /**
     * 修改
     *
     * @param equipment
     * @return
     * @throws Exception
     */
    boolean updateEquipment(Equipment equipment) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteEquipment(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    EquipmentQueryVo getEquipmentById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param equipmentPageParam
     * @return
     * @throws Exception
     */
    Paging<EquipmentQueryVo> getEquipmentPageList(EquipmentPageParam equipmentPageParam) throws Exception;

}
