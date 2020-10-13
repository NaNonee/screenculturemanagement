package com.cpy.screenculturemanagement.service.impl;

import com.cpy.screenculturemanagement.entity.Classfy;
import com.cpy.screenculturemanagement.mapper.ClassfyMapper;
import com.cpy.screenculturemanagement.service.ClassfyService;
import com.cpy.screenculturemanagement.param.ClassfyPageParam;
import com.cpy.screenculturemanagement.vo.ClassfyQueryVo;
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
public class ClassfyServiceImpl extends BaseServiceImpl<ClassfyMapper, Classfy> implements ClassfyService {

    @Autowired
    private ClassfyMapper classfyMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveClassfy(Classfy classfy) throws Exception {
        return super.save(classfy);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateClassfy(Classfy classfy) throws Exception {
        return super.updateById(classfy);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteClassfy(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public ClassfyQueryVo getClassfyById(Serializable id) throws Exception {
    return classfyMapper.getClassfyById(id);
    }

    @Override
    public Paging<ClassfyQueryVo> getClassfyPageList(ClassfyPageParam classfyPageParam) throws Exception {
        Page<ClassfyQueryVo> page = new PageInfo<>(classfyPageParam, OrderItem.desc(getLambdaColumn(Classfy::getCreateTime)));
        IPage<ClassfyQueryVo> iPage = classfyMapper.getClassfyPageList(page, classfyPageParam);
        return new Paging<ClassfyQueryVo>(iPage);
    }

}
