package com.cpy.screenculturemanagement.controller;

import com.cpy.screenculturemanagement.entity.Warehouserecord;
import com.cpy.screenculturemanagement.service.WarehouserecordService;
import lombok.extern.slf4j.Slf4j;
import com.cpy.screenculturemanagement.param.WarehouserecordPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import com.cpy.screenculturemanagement.vo.WarehouserecordQueryVo;
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
@RequestMapping("/warehouserecord")
@Module("screenculturemanagement")
@Api(value = "出入库记录", tags = {"出入库记录"})
public class WarehouserecordController extends BaseController {

    @Autowired
    private WarehouserecordService warehouserecordService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addWarehouserecord(@Validated(Add.class) @RequestBody Warehouserecord warehouserecord) throws Exception {
        boolean flag = warehouserecordService.saveWarehouserecord(warehouserecord);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateWarehouserecord(@Validated(Update.class) @RequestBody Warehouserecord warehouserecord) throws Exception {
        boolean flag = warehouserecordService.updateWarehouserecord(warehouserecord);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteWarehouserecord(@PathVariable("id") Long id) throws Exception {
        boolean flag = warehouserecordService.deleteWarehouserecord(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = WarehouserecordQueryVo.class)
    public ApiResult<WarehouserecordQueryVo> getWarehouserecord(@PathVariable("id") Long id) throws Exception {
        WarehouserecordQueryVo warehouserecordQueryVo = warehouserecordService.getWarehouserecordById(id);
        return ApiResult.ok(warehouserecordQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = WarehouserecordQueryVo.class)
    public ApiResult<Paging<WarehouserecordQueryVo>> getWarehouserecordPageList(@Validated @RequestBody WarehouserecordPageParam warehouserecordPageParam) throws Exception {
        Paging<WarehouserecordQueryVo> paging = warehouserecordService.getWarehouserecordPageList(warehouserecordPageParam);
        return ApiResult.ok(paging);
    }

}

