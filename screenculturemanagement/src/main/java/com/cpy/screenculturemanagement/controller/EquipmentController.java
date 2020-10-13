package com.cpy.screenculturemanagement.controller;

import com.cpy.screenculturemanagement.entity.Equipment;
import com.cpy.screenculturemanagement.service.EquipmentService;
import lombok.extern.slf4j.Slf4j;
import com.cpy.screenculturemanagement.param.EquipmentPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import com.cpy.screenculturemanagement.vo.EquipmentQueryVo;
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
@RequestMapping("/equipment")
@Module("screenculturemanagement")
@Api(value = "EquipmentControllerAPI", tags = {"器材管理"})
public class EquipmentController extends BaseController {

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addEquipment(@Validated(Add.class) @RequestBody Equipment equipment) throws Exception {
        boolean flag = equipmentService.saveEquipment(equipment);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateEquipment(@Validated(Update.class) @RequestBody Equipment equipment) throws Exception {
        boolean flag = equipmentService.updateEquipment(equipment);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteEquipment(@PathVariable("id") Long id) throws Exception {
        boolean flag = equipmentService.deleteEquipment(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = EquipmentQueryVo.class)
    public ApiResult<EquipmentQueryVo> getEquipment(@PathVariable("id") Long id) throws Exception {
        EquipmentQueryVo equipmentQueryVo = equipmentService.getEquipmentById(id);
        return ApiResult.ok(equipmentQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = EquipmentQueryVo.class)
    public ApiResult<Paging<EquipmentQueryVo>> getEquipmentPageList(@Validated @RequestBody EquipmentPageParam equipmentPageParam) throws Exception {
        Paging<EquipmentQueryVo> paging = equipmentService.getEquipmentPageList(equipmentPageParam);
        return ApiResult.ok(paging);
    }

}

