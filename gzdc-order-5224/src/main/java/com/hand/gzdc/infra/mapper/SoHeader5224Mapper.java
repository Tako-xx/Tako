package com.hand.gzdc.infra.mapper;

import com.hand.gzdc.domain.entity.SoHeader5224;
import com.hand.gzdc.domain.vo.SoHeaderVO5224;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * 销售订单头信息Mapper
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
public interface SoHeader5224Mapper extends BaseMapper<SoHeader5224> {
    List<SoHeaderVO5224> querySoByObj(SoHeader5224 soHeader5224);

    List<SoHeaderVO5224> querySoCollect(SoHeader5224 soHeader5224);

    String queryRoleCOde(Long id);
}
