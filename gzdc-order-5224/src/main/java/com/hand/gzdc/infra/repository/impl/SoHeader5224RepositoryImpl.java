package com.hand.gzdc.infra.repository.impl;

import com.hand.gzdc.domain.entity.SoHeader5224;
import com.hand.gzdc.domain.repository.SoHeader5224Repository;
import com.hand.gzdc.domain.vo.SoHeaderVO5224;
import com.hand.gzdc.infra.mapper.SoHeader5224Mapper;
import lombok.extern.slf4j.Slf4j;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 销售订单头信息 资源库实现
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@Slf4j
@Component
public class SoHeader5224RepositoryImpl extends BaseRepositoryImpl<SoHeader5224> implements SoHeader5224Repository {

    @Resource
    private SoHeader5224Mapper soHeader5224Mapper;

    @Override
    public SoHeaderVO5224 querySoById(Long soHeaderId) {
        SoHeader5224 soHeader5224 = new SoHeader5224();
        soHeader5224.setSoHeaderId(soHeaderId);
        List<SoHeaderVO5224> soHeaderVO5224List = soHeader5224Mapper.querySoByObj(soHeader5224);
        return (!soHeaderVO5224List.isEmpty()) ? soHeaderVO5224List.get(0) : null;
    }

    @Override
    public List<SoHeaderVO5224> querySoCollect(Long companyId, Long customerId, String orderNumber, String orderStatus) {
        SoHeader5224 soHeader5224 = new SoHeader5224();
        soHeader5224.setCompanyId(companyId);
        soHeader5224.setCustomerId(customerId);
        soHeader5224.setOrderNumber(orderNumber);
        soHeader5224.setOrderStatus(orderStatus);
        return soHeader5224Mapper.querySoCollect(soHeader5224);
    }

    @Override
    public String queryRoleCOde(Long id) {
       return soHeader5224Mapper.queryRoleCOde(id);
    }
}
