package com.hand.gzdc.app.service.impl;

import com.hand.gzdc.app.service.SoLine5224Service;
import com.hand.gzdc.domain.repository.SoLine5224Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 销售订单行信息应用服务默认实现
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@Service
public class SoLine5224ServiceImpl implements SoLine5224Service {

    @Autowired
    private SoLine5224Repository soLine5224Repository;

    @Override
    public void deleteSoLineById(Long soLineId) {
        soLine5224Repository.deleteByPrimaryKey(soLineId);
    }
}
