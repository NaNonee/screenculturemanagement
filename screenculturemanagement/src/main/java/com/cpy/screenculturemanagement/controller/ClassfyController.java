package com.cpy.screenculturemanagement.controller;

import com.cpy.screenculturemanagement.entity.Classfy;
import com.cpy.screenculturemanagement.service.ClassfyService;
import lombok.extern.slf4j.Slf4j;
import com.cpy.screenculturemanagement.param.ClassfyPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import com.cpy.screenculturemanagement.vo.ClassfyQueryVo;
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
@RequestMapping("/classfy")
@Module("screenculturemanagement")
@Api(value = "ClassfyControllerAPI", tags = {"器材类别"})
public class ClassfyController extends BaseController {

    @Autowired
    private ClassfyService classfyService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addClassfy(@Validated(Add.class) @RequestBody Classfy classfy) throws Exception {
        boolean flag = classfyService.saveClassfy(classfy);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateClassfy(@Validated(Update.class) @RequestBody Classfy classfy) throws Exception {
        boolean flag = classfyService.updateClassfy(classfy);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteClassfy(@PathVariable("id") Long id) throws Exception {
        boolean flag = classfyService.deleteClassfy(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = ClassfyQueryVo.class)
    public ApiResult<ClassfyQueryVo> getClassfy(@PathVariable("id") Long id) throws Exception {
        ClassfyQueryVo classfyQueryVo = classfyService.getClassfyById(id);
        return ApiResult.ok(classfyQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = ClassfyQueryVo.class)
    public ApiResult<Paging<ClassfyQueryVo>> getClassfyPageList(@Validated @RequestBody ClassfyPageParam classfyPageParam) throws Exception {
        Paging<ClassfyQueryVo> paging = classfyService.getClassfyPageList(classfyPageParam);
        return ApiResult.ok(paging);
    }

}

