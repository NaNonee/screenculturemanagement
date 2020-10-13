package com.cpy.screenculturemanagement.service;

import com.cpy.screenculturemanagement.entity.Warehouserecord;
import com.cpy.screenculturemanagement.param.WarehouserecordPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import com.cpy.screenculturemanagement.vo.WarehouserecordQueryVo;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.io.Serializable;

/**
 *  服务类
 *
 * @author wanght
 * @since 2020-10-12
 */
public interface WarehouserecordService extends BaseService<Warehouserecord> {

    /**
     * 保存
     *
     * @param warehouserecord
     * @return
     * @throws Exception
     */
    boolean saveWarehouserecord(Warehouserecord warehouserecord) throws Exception;

    /**
     * 修改
     *
     * @param warehouserecord
     * @return
     * @throws Exception
     */
    boolean updateWarehouserecord(Warehouserecord warehouserecord) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteWarehouserecord(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    WarehouserecordQueryVo getWarehouserecordById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param warehouserecordPageParam
     * @return
     * @throws Exception
     */
    Paging<WarehouserecordQueryVo> getWarehouserecordPageList(WarehouserecordPageParam warehouserecordPageParam) throws Exception;

}
