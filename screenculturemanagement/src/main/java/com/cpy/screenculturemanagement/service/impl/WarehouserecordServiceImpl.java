package com.cpy.screenculturemanagement.service.impl;

import com.cpy.screenculturemanagement.entity.Warehouserecord;
import com.cpy.screenculturemanagement.mapper.WarehouserecordMapper;
import com.cpy.screenculturemanagement.service.WarehouserecordService;
import com.cpy.screenculturemanagement.param.WarehouserecordPageParam;
import com.cpy.screenculturemanagement.vo.WarehouserecordQueryVo;
import io.geekidea.springbootplus.framework.common.service.impl.BaseServiceImpl;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.core.pagination.PageInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 *  服务实现类
 *
 * @author wanght
 * @since 2020-10-12
 */
@Slf4j
@Service
public class WarehouserecordServiceImpl extends BaseServiceImpl<WarehouserecordMapper, Warehouserecord> implements WarehouserecordService {

    @Autowired
    private WarehouserecordMapper warehouserecordMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveWarehouserecord(Warehouserecord warehouserecord) throws Exception {
        return super.save(warehouserecord);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateWarehouserecord(Warehouserecord warehouserecord) throws Exception {
        return super.updateById(warehouserecord);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteWarehouserecord(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public WarehouserecordQueryVo getWarehouserecordById(Serializable id) throws Exception {
    return warehouserecordMapper.getWarehouserecordById(id);
    }

    @Override
    public Paging<WarehouserecordQueryVo> getWarehouserecordPageList(WarehouserecordPageParam warehouserecordPageParam) throws Exception {
        Page<WarehouserecordQueryVo> page = new PageInfo<>(warehouserecordPageParam, OrderItem.desc(getLambdaColumn(Warehouserecord::getCreateTime)));
        IPage<WarehouserecordQueryVo> iPage = warehouserecordMapper.getWarehouserecordPageList(page, warehouserecordPageParam);
        return new Paging<WarehouserecordQueryVo>(iPage);
    }

}
