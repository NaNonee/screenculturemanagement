package com.cpy.screenculturemanagement.controller;

import com.cpy.screenculturemanagement.entity.Model;
import com.cpy.screenculturemanagement.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import com.cpy.screenculturemanagement.param.ModelPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import com.cpy.screenculturemanagement.vo.ModelQueryVo;
import io.geekidea.springbootplus.framework.common.api.ApiResult;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.common.param.IdParam;
import io.geekidea.springbootplus.framework.log.annotation.Module;
import io.geekidea.springbootplus.framework.log.annotation.OperationLog;
import io.geekidea.springbootplus.framework.log.enums.OperationLogType;
import io.geekidea.springbootplus.framework.core.validator.groups.Add;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  控制器
 *
 * @author wanght
 * @since 2020-10-12
 */
@Slf4j
@RestController
@RequestMapping("/model")
@Module("screenculturemanagement")
@Api(value = "器材名称", tags = {"器材名称"})
public class ModelController extends BaseController {

    @Autowired
    private ModelService modelService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addModel(@Validated(Add.class) @RequestBody Model model) throws Exception {
        boolean flag = modelService.saveModel(model);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateModel(@Validated(Update.class) @RequestBody Model model) throws Exception {
        boolean flag = modelService.updateModel(model);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteModel(@PathVariable("id") Long id) throws Exception {
        boolean flag = modelService.deleteModel(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = ModelQueryVo.class)
    public ApiResult<ModelQueryVo> getModel(@PathVariable("id") Long id) throws Exception {
        ModelQueryVo modelQueryVo = modelService.getModelById(id);
        return ApiResult.ok(modelQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = ModelQueryVo.class)
    public ApiResult<Paging<ModelQueryVo>> getModelPageList(@Validated @RequestBody ModelPageParam modelPageParam) throws Exception {
        Paging<ModelQueryVo> paging = modelService.getModelPageList(modelPageParam);
        return ApiResult.ok(paging);
    }

}

