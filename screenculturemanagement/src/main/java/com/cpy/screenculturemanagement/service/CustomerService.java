package com.cpy.screenculturemanagement.service;

import com.cpy.screenculturemanagement.entity.Customer;
import com.cpy.screenculturemanagement.param.CustomerPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import com.cpy.screenculturemanagement.vo.CustomerQueryVo;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.io.Serializable;

/**
 *  服务类
 *
 * @author wanght
 * @since 2020-10-12
 */
public interface CustomerService extends BaseService<Customer> {

    /**
     * 保存
     *
     * @param customer
     * @return
     * @throws Exception
     */
    boolean saveCustomer(Customer customer) throws Exception;

    /**
     * 修改
     *
     * @param customer
     * @return
     * @throws Exception
     */
    boolean updateCustomer(Customer customer) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteCustomer(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    CustomerQueryVo getCustomerById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param customerPageParam
     * @return
     * @throws Exception
     */
    Paging<CustomerQueryVo> getCustomerPageList(CustomerPageParam customerPageParam) throws Exception;

}
