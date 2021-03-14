package com.hand.gzdc.domain.repository;

import com.hand.gzdc.domain.entity.SoHeader5224;
import com.hand.gzdc.domain.vo.SoHeaderVO5224;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 销售订单头信息资源库
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
public interface SoHeader5224Repository extends BaseRepository<SoHeader5224> {
    SoHeaderVO5224 querySoById(Long SoHeaderId);

    List<SoHeaderVO5224> querySoCollect(Long companyId, Long customerId, String orderNumber, String orderStatus);

    String queryRoleCOde(Long id);
}
