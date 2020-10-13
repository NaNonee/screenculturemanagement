package com.cpy.screenculturemanagement.service;

import com.cpy.screenculturemanagement.entity.Classfy;
import com.cpy.screenculturemanagement.param.ClassfyPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import com.cpy.screenculturemanagement.vo.ClassfyQueryVo;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.io.Serializable;

/**
 *  服务类
 *
 * @author wanght
 * @since 2020-10-12
 */
public interface ClassfyService extends BaseService<Classfy> {

    /**
     * 保存
     *
     * @param classfy
     * @return
     * @throws Exception
     */
    boolean saveClassfy(Classfy classfy) throws Exception;

    /**
     * 修改
     *
     * @param classfy
     * @return
     * @throws Exception
     */
    boolean updateClassfy(Classfy classfy) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteClassfy(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ClassfyQueryVo getClassfyById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param classfyQueryParam
     * @return
     * @throws Exception
     */
    Paging<ClassfyQueryVo> getClassfyPageList(ClassfyPageParam classfyPageParam) throws Exception;

}
