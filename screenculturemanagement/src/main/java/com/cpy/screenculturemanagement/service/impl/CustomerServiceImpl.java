package com.cpy.screenculturemanagement.service.impl;

import com.cpy.screenculturemanagement.entity.Customer;
import com.cpy.screenculturemanagement.mapper.CustomerMapper;
import com.cpy.screenculturemanagement.service.CustomerService;
import com.cpy.screenculturemanagement.param.CustomerPageParam;
import com.cpy.screenculturemanagement.vo.CustomerQueryVo;
import io.geekidea.springbootplus.framework.common.service.impl.BaseServiceImpl;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.core.pagination.PageInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 *  服务实现类
 *
 * @author wanght
 * @since 2020-10-12
 */
@Slf4j
@Service
public class CustomerServiceImpl extends BaseServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveCustomer(Customer customer) throws Exception {
        return super.save(customer);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateCustomer(Customer customer) throws Exception {
        return super.updateById(customer);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteCustomer(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public CustomerQueryVo getCustomerById(Serializable id) throws Exception {
    return customerMapper.getCustomerById(id);
    }

    @Override
    public Paging<CustomerQueryVo> getCustomerPageList(CustomerPageParam customerPageParam) throws Exception {
        Page<CustomerQueryVo> page = new PageInfo<>(customerPageParam, OrderItem.desc(getLambdaColumn(Customer::getCreateTime)));
        IPage<CustomerQueryVo> iPage = customerMapper.getCustomerPageList(page, customerPageParam);
        return new Paging<CustomerQueryVo>(iPage);
    }

}
