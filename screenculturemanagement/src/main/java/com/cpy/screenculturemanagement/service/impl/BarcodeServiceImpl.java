package com.cpy.screenculturemanagement.service.impl;

import com.cpy.screenculturemanagement.entity.Barcode;
import com.cpy.screenculturemanagement.mapper.BarcodeMapper;
import com.cpy.screenculturemanagement.service.BarcodeService;
import com.cpy.screenculturemanagement.param.BarcodePageParam;
import com.cpy.screenculturemanagement.vo.BarcodeQueryVo;
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
public class BarcodeServiceImpl extends BaseServiceImpl<BarcodeMapper, Barcode> implements BarcodeService {

    @Autowired
    private BarcodeMapper barcodeMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveBarcode(Barcode barcode) throws Exception {
        return super.save(barcode);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateBarcode(Barcode barcode) throws Exception {
        return super.updateById(barcode);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteBarcode(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public BarcodeQueryVo getBarcodeById(Serializable id) throws Exception {
    return barcodeMapper.getBarcodeById(id);
    }

    @Override
    public Paging<BarcodeQueryVo> getBarcodePageList(BarcodePageParam barcodePageParam) throws Exception {
        Page<BarcodeQueryVo> page = new PageInfo<>(barcodePageParam, OrderItem.desc(getLambdaColumn(Barcode::getCreateTime)));
        IPage<BarcodeQueryVo> iPage = barcodeMapper.getBarcodePageList(page, barcodePageParam);
        return new Paging<BarcodeQueryVo>(iPage);
    }

}
