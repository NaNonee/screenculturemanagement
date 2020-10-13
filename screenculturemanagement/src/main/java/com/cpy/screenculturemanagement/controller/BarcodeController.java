package com.cpy.screenculturemanagement.controller;

import com.cpy.screenculturemanagement.entity.Barcode;
import com.cpy.screenculturemanagement.service.BarcodeService;
import lombok.extern.slf4j.Slf4j;
import com.cpy.screenculturemanagement.param.BarcodePageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import com.cpy.screenculturemanagement.vo.BarcodeQueryVo;
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
@RequestMapping("/barcode")
@Module("screenculturemanagement")
@Api(value = "BarcodeControllerAPI", tags = {"条形码管理"})
public class BarcodeController extends BaseController {

    @Autowired
    private BarcodeService barcodeService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addBarcode(@Validated(Add.class) @RequestBody Barcode barcode) throws Exception {
        boolean flag = barcodeService.saveBarcode(barcode);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateBarcode(@Validated(Update.class) @RequestBody Barcode barcode) throws Exception {
        boolean flag = barcodeService.updateBarcode(barcode);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteBarcode(@PathVariable("id") Long id) throws Exception {
        boolean flag = barcodeService.deleteBarcode(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = BarcodeQueryVo.class)
    public ApiResult<BarcodeQueryVo> getBarcode(@PathVariable("id") Long id) throws Exception {
        BarcodeQueryVo barcodeQueryVo = barcodeService.getBarcodeById(id);
        return ApiResult.ok(barcodeQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = BarcodeQueryVo.class)
    public ApiResult<Paging<BarcodeQueryVo>> getBarcodePageList(@Validated @RequestBody BarcodePageParam barcodePageParam) throws Exception {
        Paging<BarcodeQueryVo> paging = barcodeService.getBarcodePageList(barcodePageParam);
        return ApiResult.ok(paging);
    }

}

