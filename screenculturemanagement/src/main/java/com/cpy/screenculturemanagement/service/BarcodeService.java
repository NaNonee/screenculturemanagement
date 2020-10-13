package com.cpy.screenculturemanagement.service;

import com.cpy.screenculturemanagement.entity.Barcode;
import com.cpy.screenculturemanagement.param.BarcodePageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import com.cpy.screenculturemanagement.vo.BarcodeQueryVo;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.io.Serializable;

/**
 *  服务类
 *
 * @author wanght
 * @since 2020-10-12
 */
public interface BarcodeService extends BaseService<Barcode> {

    /**
     * 保存
     *
     * @param barcode
     * @return
     * @throws Exception
     */
    boolean saveBarcode(Barcode barcode) throws Exception;

    /**
     * 修改
     *
     * @param barcode
     * @return
     * @throws Exception
     */
    boolean updateBarcode(Barcode barcode) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteBarcode(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    BarcodeQueryVo getBarcodeById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param barcodePageParam
     * @return
     * @throws Exception
     */
    Paging<BarcodeQueryVo> getBarcodePageList(BarcodePageParam barcodePageParam) throws Exception;

}
