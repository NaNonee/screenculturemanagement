package com.cpy.screenculturemanagement.controller;

import com.cpy.screenculturemanagement.entity.Customer;
import com.cpy.screenculturemanagement.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import com.cpy.screenculturemanagement.param.CustomerPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import com.cpy.screenculturemanagement.vo.CustomerQueryVo;
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
@RequestMapping("/customer")
@Module("screenculturemanagement")
@Api(value = "会员管理", tags = {""})
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService customerService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addCustomer(@Validated(Add.class) @RequestBody Customer customer) throws Exception {
        boolean flag = customerService.saveCustomer(customer);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateCustomer(@Validated(Update.class) @RequestBody Customer customer) throws Exception {
        boolean flag = customerService.updateCustomer(customer);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteCustomer(@PathVariable("id") Long id) throws Exception {
        boolean flag = customerService.deleteCustomer(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = CustomerQueryVo.class)
    public ApiResult<CustomerQueryVo> getCustomer(@PathVariable("id") Long id) throws Exception {
        CustomerQueryVo customerQueryVo = customerService.getCustomerById(id);
        return ApiResult.ok(customerQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = CustomerQueryVo.class)
    public ApiResult<Paging<CustomerQueryVo>> getCustomerPageList(@Validated @RequestBody CustomerPageParam customerPageParam) throws Exception {
        Paging<CustomerQueryVo> paging = customerService.getCustomerPageList(customerPageParam);
        return ApiResult.ok(paging);
    }

}

