package com.cpy.screenculturemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpy.screenculturemanagement.entity.Model;
import com.cpy.screenculturemanagement.param.ModelPageParam;
import com.cpy.screenculturemanagement.vo.ModelQueryVo;

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
public interface ModelMapper extends BaseMapper<Model> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ModelQueryVo getModelById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param modelQueryParam
     * @return
     */
    IPage<ModelQueryVo> getModelPageList(@Param("page") Page page, @Param("param") ModelPageParam modelPageParam);

}
