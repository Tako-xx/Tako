package com.hand.gzdc.app.service;

import com.hand.gzdc.domain.vo.SoHeaderVO5224;

import java.util.List;

/**
 * 销售订单头信息应用服务
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
public interface SoHeader5224Service {
    /**
     * 订单查询
     * @param soHeaderId
     * @return
     */
    SoHeaderVO5224 querySoById(Long soHeaderId);

    /**
     * 订单删除
     * @param soHeaderId 订单头ID
     */
    void deleteSoById(Long soHeaderId);

    /**
     * 保存订单
     * @param soHeaderVO5224
     */
    void saveSoOrder(SoHeaderVO5224 soHeaderVO5224);

    /**
     * 新建订单头
     * @param soHeaderVO5224
     */
    void insertSoHeader(SoHeaderVO5224 soHeaderVO5224);

    /**
     * 新建订单明细
     * @param soHeaderVO5224
     */
    void insertSoDetial(SoHeaderVO5224 soHeaderVO5224);

    /**
     * 更新订单头
     * @param soHeaderVO5224
     */
    void updateSoHeader(SoHeaderVO5224 soHeaderVO5224);

    /**
     * 更新订单明细
     * @param soHeaderVO5224
     */
    void updateSoDetial(SoHeaderVO5224 soHeaderVO5224);

    /**
     * 订单汇总查询
     * @param companyId
     * @param customerId
     * @param orderNumber
     * @param orderStatus
     * @return
     */
    List<SoHeaderVO5224> querySoCollect(String companyId, String customerId, String orderNumber, String orderStatus);

    /**
     * 订单状态API
     * @param soHeaderVO5224
     */
    public void updateSoOrderStatus(SoHeaderVO5224 soHeaderVO5224);
}
