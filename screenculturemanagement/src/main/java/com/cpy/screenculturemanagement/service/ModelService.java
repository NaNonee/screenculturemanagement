package com.cpy.screenculturemanagement.service;

import com.cpy.screenculturemanagement.entity.Model;
import com.cpy.screenculturemanagement.param.ModelPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import com.cpy.screenculturemanagement.vo.ModelQueryVo;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.io.Serializable;

/**
 *  服务类
 *
 * @author wanght
 * @since 2020-10-12
 */
public interface ModelService extends BaseService<Model> {

    /**
     * 保存
     *
     * @param model
     * @return
     * @throws Exception
     */
    boolean saveModel(Model model) throws Exception;

    /**
     * 修改
     *
     * @param model
     * @return
     * @throws Exception
     */
    boolean updateModel(Model model) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteModel(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ModelQueryVo getModelById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param modelPageParam
     * @return
     * @throws Exception
     */
    Paging<ModelQueryVo> getModelPageList(ModelPageParam modelPageParam) throws Exception;

}
