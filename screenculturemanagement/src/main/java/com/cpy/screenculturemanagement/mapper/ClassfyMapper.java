package com.cpy.screenculturemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpy.screenculturemanagement.entity.Classfy;
import com.cpy.screenculturemanagement.param.ClassfyPageParam;
import com.cpy.screenculturemanagement.vo.ClassfyQueryVo;

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
public interface ClassfyMapper extends BaseMapper<Classfy> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ClassfyQueryVo getClassfyById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param classfyQueryParam
     * @return
     */
    IPage<ClassfyQueryVo> getClassfyPageList(@Param("page") Page page, @Param("param") ClassfyPageParam classfyPageParam);

}
