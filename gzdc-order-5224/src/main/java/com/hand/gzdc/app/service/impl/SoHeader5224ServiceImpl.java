package com.hand.gzdc.app.service.impl;

import com.hand.gzdc.app.constant.SystemContent;
import com.hand.gzdc.app.service.SoHeader5224Service;
import com.hand.gzdc.domain.entity.SoHeader5224;
import com.hand.gzdc.domain.entity.SoLine5224;
import com.hand.gzdc.domain.repository.SoHeader5224Repository;
import com.hand.gzdc.domain.repository.SoLine5224Repository;
import com.hand.gzdc.domain.vo.SoHeaderVO5224;
import com.hand.gzdc.domain.vo.SoLineVO5224;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.oauth.CustomUserDetails;
import io.choerodon.core.oauth.DetailsHelper;
import io.choerodon.mybatis.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 销售订单头信息应用服务默认实现
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@Slf4j
@Service
public class SoHeader5224ServiceImpl implements SoHeader5224Service {

    @Autowired
    private SoHeader5224Repository soHeader5224Repository;
    @Autowired
    private SoLine5224Repository soLine5224Repository;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;

    /**
     * 订单查询
     *
     * @param soHeaderId
     * @return
     */
    @Override
    public SoHeaderVO5224 querySoById(Long soHeaderId) {
        return soHeader5224Repository.querySoById(soHeaderId);
    }

    /**
     * 订单删除
     *
     * @param soHeaderId 订单头ID
     */
    @Override
    public void deleteSoById(Long soHeaderId) {
        //获取订单信息
        SoHeader5224 soHeader5224 = new SoHeader5224();
        soHeader5224.setSoHeaderId(soHeaderId);
        soHeader5224 = soHeader5224Repository.selectOne(soHeader5224);
        //订单存在的校验
        if (soHeader5224 == null) {
            throw new CommonException("ERR: 订单不存在！");
        }
        //当前用户是否为订单创建者
        if (DetailsHelper.getUserDetails().getUserId() != soHeader5224.getCreatedBy()) {
            soHeader5224 = null;
            throw new CommonException("ERR: 非本人订单禁止删除！");
        }
        //订单状态是否是NEW/REJECTED
        if (!(SystemContent.SO_STATUS_NEW.equals(soHeader5224.getOrderStatus()) || SystemContent.SO_STATUS_REJECTED.equals(soHeader5224.getOrderStatus()))) {
            soHeader5224 = null;
            throw new CommonException("ERR: 订单状态不是NEW/REJECTED禁止删除！");
        }
        //头行削除处理
        SoLine5224 soLine5224 = new SoLine5224();
        soLine5224.setSoHeaderId(soHeaderId);
        soHeader5224Repository.deleteByPrimaryKey(soHeaderId);
        soLine5224Repository.delete(soLine5224);
        //对象销毁
        soHeader5224 = null;
        soLine5224 = null;
    }

    /**
     * 保存订单
     *
     * @param soHeaderVO5224
     */
    @Override
    public void saveSoOrder(SoHeaderVO5224 soHeaderVO5224) {
        //订单保存
        //登录更新需要根据实际情况组合，此处不严谨
        if (soHeaderVO5224.getHSoHeaderId() == null) {
            //订单头登录
            insertSoHeader(soHeaderVO5224);
            //订单明细登录
            insertSoDetial(soHeaderVO5224);
        } else {
            //订单头更新
            updateSoHeader(soHeaderVO5224);
            //订单明细更新
            updateSoDetial(soHeaderVO5224);
        }
    }

    /**
     * 新建订单头
     *
     * @param soHeaderVO5224
     */
    @Override
    public void insertSoHeader(SoHeaderVO5224 soHeaderVO5224) {
        //订单日是否大于等于当前日期
        if (soHeaderVO5224.getHOrderDate().compareTo(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) < 0) {
            throw new CommonException("ERR: 订单日期必须大于等于当前日期！");
        }
        //系统参数取得
        CustomUserDetails userInfo = DetailsHelper.getUserDetails();
        //当前时间取得
        Date date = new Date();
        //订单编号取得
        String orderNumbercode = codeRuleBuilder.generateCode(SystemContent.SO_ORDER_NUMBER, null);
        if (StringUtil.isEmpty(orderNumbercode)) {
            throw new CommonException("订单番号自动生成失败！");
        }
        //订单头情报设定
        soHeaderVO5224.setHOrderStatus(SystemContent.SO_STATUS_NEW);
        soHeaderVO5224.setHCreatedBy(userInfo.getUserId());
        SoHeader5224 soHeader5224 = new SoHeader5224();
        //soHeader5224.setSoHeaderId(); 自增主键
        soHeader5224.setOrderNumber(orderNumbercode);
        soHeader5224.setCompanyId(soHeaderVO5224.getHCompanyId());
        soHeader5224.setOrderDate(soHeaderVO5224.getHOrderDate());
        soHeader5224.setOrderStatus(SystemContent.SO_STATUS_NEW);
        soHeader5224.setCustomerId(soHeaderVO5224.getHCustomerId());
        soHeader5224.setCreatedBy(userInfo.getUserId());
        soHeader5224.setCreationDate(date);
        soHeader5224.setLastUpdatedBy(soHeaderVO5224.getHLastUpdatedBy());
        soHeader5224.setLastUpdateDate(date);
        soHeader5224.setObjectVersionNumber(1L);
        //订单头登录
        soHeader5224Repository.insertSelective(soHeader5224);
        //新建订单头ID格纳至参数对象中
        soHeaderVO5224.setHSoHeaderId(soHeader5224.getSoHeaderId());
        //对象销毁
        userInfo = null;
        date = null;
        orderNumbercode = null;
        soHeader5224 = null;
    }

    /**
     * 新建订单明细
     *
     * @param soHeaderVO5224
     */
    @Override
    public void insertSoDetial(SoHeaderVO5224 soHeaderVO5224) {
        //订单校验
        if (soHeaderVO5224 == null) {
            throw new CommonException("ERR: 订单对象为空！");
        }
        //当前用户是否为订单创建者
        if (DetailsHelper.getUserDetails().getUserId() != soHeaderVO5224.getHCreatedBy()) {
            throw new CommonException("ERR: 非本人订单禁止新增！");
        }
        //订单状态校验
        if (!(SystemContent.SO_STATUS_NEW.equals(soHeaderVO5224.getHOrderStatus()) || SystemContent.SO_STATUS_REJECTED.equals(soHeaderVO5224.getHOrderStatus()))) {
            throw new CommonException("ERR: 订单状态不是NEW/REJECTED禁止新增！");
        }
        //系统参数取得
        CustomUserDetails userInfo = DetailsHelper.getUserDetails();
        //当前时间取得
        Date date = new Date();
        //订单明细设定
        for (SoLineVO5224 soLineVO5224 : soHeaderVO5224.getSoLineVO5224List()) {
            SoLine5224 soLine5224 = new SoLine5224();
            //soLine5224.setSoLineId(); 主键自增长
            soLine5224.setSoHeaderId(soHeaderVO5224.getHSoHeaderId());
            soLine5224.setLineNumber(soLineVO5224.getLLineNumber());
            soLine5224.setItemId(soLineVO5224.getLItemId());
            soLine5224.setOrderQuantity(soLineVO5224.getLOrderQuantity());
            soLine5224.setOrderQuantityUom(soLineVO5224.getLOrderQuantityUom());
            soLine5224.setUnitSellingPrice(soLineVO5224.getLUnitSellingPrice());
            soLine5224.setDescription(soLineVO5224.getLDescription());
            soLine5224.setAddition1(soLineVO5224.getLAddition1());
            soLine5224.setAddition2(soLineVO5224.getLAddition2());
            soLine5224.setAddition3(soLineVO5224.getLAddition3());
            soLine5224.setAddition4(soLineVO5224.getLAddition4());
            soLine5224.setAddition5(soLineVO5224.getLAddition5());
            soLine5224.setCreatedBy(userInfo.getUserId());
            soLine5224.setCreationDate(date);
            soLine5224.setLastUpdatedBy(userInfo.getUserId());
            soLine5224.setLastUpdateDate(date);
            soLine5224.setObjectVersionNumber(1L);
            soLine5224Repository.insertSelective(soLine5224);
            soLine5224 = null;
        }
        //对象销毁
        userInfo = null;
        date = null;
    }

    /**
     * 更新订单头
     *
     * @param soHeaderVO5224
     */
    @Override
    public void updateSoHeader(SoHeaderVO5224 soHeaderVO5224) {
        //订单校验
        SoHeader5224 soHeader5224 = new SoHeader5224();
        soHeader5224 = soHeader5224Repository.selectByPrimaryKey(soHeaderVO5224.getHSoHeaderId());
        //订单存在校验
        if (soHeader5224 == null) {
            soHeader5224 = null;
            throw new CommonException("ERR: 订单不存在！");
        }
        //当前用户是否为订单创建者
        if (DetailsHelper.getUserDetails().getUserId() != soHeaderVO5224.getHCreatedBy()) {
            throw new CommonException("ERR: 非本人订单禁止更新！");
        }
        //订单状态校验
        if (!(SystemContent.SO_STATUS_NEW.equals(soHeader5224.getOrderStatus()) || SystemContent.SO_STATUS_REJECTED.equals(soHeader5224.getOrderStatus()))) {
            soHeader5224 = null;
            throw new CommonException("ERR: 订单状态不是NEW/REJECTED禁止更新！");
        }
        //系统参数取得
        CustomUserDetails userInfo = DetailsHelper.getUserDetails();
        //当前时间取得
        Date date = new Date();
        //订单头更新项目情报设定
        soHeader5224.setCompanyId(soHeaderVO5224.getHCompanyId());
        soHeader5224.setOrderDate(soHeaderVO5224.getHOrderDate());
        soHeader5224.setCustomerId(soHeaderVO5224.getHCustomerId());
        soHeader5224.setLastUpdatedBy(userInfo.getUserId());
        soHeader5224.setLastUpdateDate(date);
        //订单头更新
        soHeader5224Repository.updateByPrimaryKey(soHeader5224);
        //对象销毁
        userInfo = null;
        date = null;
        soHeader5224 = null;
    }

    /**
     * 更新订单明细
     *
     * @param soHeaderVO5224
     */
    @Override
    public void updateSoDetial(SoHeaderVO5224 soHeaderVO5224) {
        //订单校验
        if (soHeaderVO5224 == null) {
            throw new CommonException("ERR: 订单对象为空！");
        }
        //当前用户是否为订单创建者
        if (DetailsHelper.getUserDetails().getUserId() != soHeaderVO5224.getHCreatedBy()) {
            throw new CommonException("ERR: 非本人订单禁止更新！");
        }
        //订单状态校验
        if (!(SystemContent.SO_STATUS_NEW.equals(soHeaderVO5224.getHOrderStatus()) || SystemContent.SO_STATUS_REJECTED.equals(soHeaderVO5224.getHOrderStatus()))) {
            throw new CommonException("ERR: 订单状态不是NEW/REJECTED禁止更新！");
        }
        //系统参数取得
        CustomUserDetails userInfo = DetailsHelper.getUserDetails();
        //当前时间取得
        Date date = new Date();
        //订单明细情报设定
        for (SoLineVO5224 soLineVO5224 : soHeaderVO5224.getSoLineVO5224List()) {
            SoLine5224 soLine5224 = new SoLine5224();
            soLine5224 = soLine5224Repository.selectByPrimaryKey(soLineVO5224.getLSoLineId());
            soLine5224.setLineNumber(soLineVO5224.getLLineNumber());
            soLine5224.setItemId(soLineVO5224.getLItemId());
            soLine5224.setOrderQuantity(soLineVO5224.getLOrderQuantity());
            soLine5224.setOrderQuantityUom(soLineVO5224.getLOrderQuantityUom());
            soLine5224.setUnitSellingPrice(soLineVO5224.getLUnitSellingPrice());
            soLine5224.setDescription(soLineVO5224.getLDescription());
            soLine5224.setLastUpdatedBy(userInfo.getUserId());
            soLine5224.setLastUpdateDate(date);
            //订单明细跟新
            soLine5224Repository.updateByPrimaryKey(soLine5224);
            //对象销毁
            soLine5224 = null;
        }
        //对象销毁
        userInfo = null;
        date = null;
    }

    /**
     * 订单汇总
     *
     * @param companyId
     * @param customerId
     * @param orderNumber
     * @param orderStatus
     * @return
     */
    @Override
    public List<SoHeaderVO5224> querySoCollect(String companyId, String customerId, String orderNumber, String orderStatus) {
        return soHeader5224Repository.querySoCollect(("{companyId}".equals(companyId) ? null : Long.parseLong(companyId)),
                ("{customerId}".equals(customerId) ? null : Long.parseLong(customerId)),
                ("{orderNumber}".equals(orderNumber) ? null : orderNumber),
                ("{orderStatus}".equals(orderStatus) ? null : orderStatus));
    }

    /**
     * 订单状态API
     *
     * @param soHeaderVO5224
     */
    @Override
    public void updateSoOrderStatus(SoHeaderVO5224 soHeaderVO5224) {
        //刷新订单信息
        SoHeader5224 soHeader5224 = new SoHeader5224();
        soHeader5224.setSoHeaderId(soHeaderVO5224.getHSoHeaderId());
        soHeader5224 = soHeader5224Repository.selectByPrimaryKey(soHeader5224);
        //订单存在校验
        if (soHeader5224 == null) {
            throw new CommonException("ERR: 订单不存在！");
        }
        //提交状态时
        if (SystemContent.SO_STATUS_SUBMITED.equals(soHeaderVO5224.getHOrderStatus())) {
            if (DetailsHelper.getUserDetails().getUserId() != soHeader5224.getCreatedBy()) {
                throw new CommonException("ERR: 当前用户与单据创建人不一致！");
            }
            if (!(SystemContent.SO_STATUS_NEW.equals(soHeader5224.getOrderStatus()) || SystemContent.SO_STATUS_REJECTED.equals(soHeader5224.getOrderStatus()))) {
                throw new CommonException("ERR: 单据状态不为NEW/REJECTED禁止更新！");
            }
            //订单状态设定后执行更新
            soHeader5224.setOrderStatus(soHeaderVO5224.getHOrderStatus());
            soHeader5224Repository.updateByPrimaryKey(soHeader5224);
        }
        //审批状态时 - 拒绝状态时
        if (SystemContent.SO_STATUS_APPROVED.equals(soHeaderVO5224.getHOrderStatus()) || SystemContent.SO_STATUS_REJECTED.equals(soHeaderVO5224.getHOrderStatus())) {
            if (!SystemContent.LOGIN_USER_ROLE_CODE.equals(soHeader5224Repository.queryRoleCOde(DetailsHelper.getUserDetails().getRoleId()))) {
                //为创建自己的用户该消息只为为模拟异常消息
                throw new CommonException("ERR: 当前用户角色不是SALE_MANAGER_5224！");
            }
            if (!SystemContent.SO_STATUS_SUBMITED.equals(soHeader5224.getOrderStatus())) {
                throw new CommonException("ERR: 单据状态不为SUBMITED禁止更新！");
            }
            //订单状态设定后执行更新
            soHeader5224.setOrderStatus(soHeaderVO5224.getHOrderStatus());
            soHeader5224Repository.updateByPrimaryKey(soHeader5224);
        }
        //对象销毁
        soHeader5224 = null;
    }
}
