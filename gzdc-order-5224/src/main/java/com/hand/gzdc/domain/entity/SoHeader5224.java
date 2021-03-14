package com.hand.gzdc.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * 销售订单头信息
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@ApiModel("销售订单头信息")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_so_header_5224")
public class SoHeader5224 extends AuditDomain {

    public static final String FIELD_SO_HEADER_ID = "soHeaderId";
    public static final String FIELD_ORDER_NUMBER = "orderNumber";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_ORDER_DATE = "orderDate";
    public static final String FIELD_ORDER_STATUS = "orderStatus";
    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_CREATED_BY = "createdBy";
    public static final String FIELD_CREATION_DATE = "creationDate";
    public static final String FIELD_LAST_UPDATED_BY = "lastUpdatedBy";
    public static final String FIELD_LAST_UPDATE_DATE = "lastUpdateDate";
    public static final String FIELD_OBJECT_VERSION_NUMBER = "objectVersionNumber";

//
// 业务方法(按public protected private顺序排列)
// ------------------------------------------------------------------------------

//
// 数据库字段
// ------------------------------------------------------------------------------


    @ApiModelProperty("订单头ID(主键)")
    @Id
    @GeneratedValue
    private Long soHeaderId;
    @ApiModelProperty(value = "订单编号", required = true)
    @NotBlank
    private String orderNumber;
    @ApiModelProperty(value = "公司ID", required = true)
    @NotNull
    private Long companyId;
    @ApiModelProperty(value = "订单日期", required = true)
    @NotBlank
    private String orderDate;
    @ApiModelProperty(value = "订单状态", required = true)
    @NotBlank
    private String orderStatus;
    @ApiModelProperty(value = "客户ID", required = true)
    @NotNull
    private Long customerId;
    @ApiModelProperty(value = "创建者", required = true)
    @NotNull
    private Long createdBy;
    @ApiModelProperty(value = "创建日期", required = true)
    @NotNull
    private Date creationDate;
    @ApiModelProperty(value = "更新者", required = true)
    @NotNull
    private Long lastUpdatedBy;
    @ApiModelProperty(value = "更新日期", required = true)
    @NotNull
    private Date lastUpdateDate;
    @ApiModelProperty(value = "版本号", required = true)
    @NotNull
    private Long objectVersionNumber;

//
// 非数据库字段
// ------------------------------------------------------------------------------

//
// getter/setter
// ------------------------------------------------------------------------------

    /**
     * @return 订单头ID(主键)
     */
    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    /**
     * @return 订单编号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return 公司ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return 订单日期
     */
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return 订单状态
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return 客户ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return 创建日期
     */
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return 更新者
     */
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return 更新日期
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * @return 版本号
     */
    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

}
