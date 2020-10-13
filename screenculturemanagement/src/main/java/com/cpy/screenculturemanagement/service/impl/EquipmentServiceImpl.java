package com.cpy.screenculturemanagement.service.impl;

import com.cpy.screenculturemanagement.entity.Equipment;
import com.cpy.screenculturemanagement.mapper.EquipmentMapper;
import com.cpy.screenculturemanagement.service.EquipmentService;
import com.cpy.screenculturemanagement.param.EquipmentPageParam;
import com.cpy.screenculturemanagement.vo.EquipmentQueryVo;
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
public class EquipmentServiceImpl extends BaseServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveEquipment(Equipment equipment) throws Exception {
        return super.save(equipment);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateEquipment(Equipment equipment) throws Exception {
        return super.updateById(equipment);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteEquipment(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public EquipmentQueryVo getEquipmentById(Serializable id) throws Exception {
    return equipmentMapper.getEquipmentById(id);
    }

    @Override
    public Paging<EquipmentQueryVo> getEquipmentPageList(EquipmentPageParam equipmentPageParam) throws Exception {
        Page<EquipmentQueryVo> page = new PageInfo<>(equipmentPageParam, OrderItem.desc(getLambdaColumn(Equipment::getCreateTime)));
        IPage<EquipmentQueryVo> iPage = equipmentMapper.getEquipmentPageList(page, equipmentPageParam);
        return new Paging<EquipmentQueryVo>(iPage);
    }

}
