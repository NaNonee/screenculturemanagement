package com.cpy.screenculturemanagement.service.impl;

import com.cpy.screenculturemanagement.entity.Model;
import com.cpy.screenculturemanagement.mapper.ModelMapper;
import com.cpy.screenculturemanagement.service.ModelService;
import com.cpy.screenculturemanagement.param.ModelPageParam;
import com.cpy.screenculturemanagement.vo.ModelQueryVo;
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
public class ModelServiceImpl extends BaseServiceImpl<ModelMapper, Model> implements ModelService {

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveModel(Model model) throws Exception {
        return super.save(model);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateModel(Model model) throws Exception {
        return super.updateById(model);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteModel(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public ModelQueryVo getModelById(Serializable id) throws Exception {
    return modelMapper.getModelById(id);
    }

    @Override
    public Paging<ModelQueryVo> getModelPageList(ModelPageParam modelPageParam) throws Exception {
        Page<ModelQueryVo> page = new PageInfo<>(modelPageParam, OrderItem.desc(getLambdaColumn(Model::getCreateTime)));
        IPage<ModelQueryVo> iPage = modelMapper.getModelPageList(page, modelPageParam);
        return new Paging<ModelQueryVo>(iPage);
    }

}
