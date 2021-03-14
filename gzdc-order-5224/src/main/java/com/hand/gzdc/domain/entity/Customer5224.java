package com.hand.gzdc.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;

import io.choerodon.mybatis.domain.AuditDomain;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * 客户主数据表
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@ApiModel("客户主数据表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_customer_5224")
public class Customer5224 extends AuditDomain {

    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_CUSTOMER_NUMBER = "customerNumber";
    public static final String FIELD_CUSTOMER_NAME = "customerName";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";
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


    @ApiModelProperty("客户ID(主键)")
    @Id
    @GeneratedValue
    private Long customerId;
    @ApiModelProperty(value = "客户编号", required = true)
    @NotBlank
    private String customerNumber;
    @ApiModelProperty(value = "客户名称", required = true)
    @NotBlank
    private String customerName;
    @ApiModelProperty(value = "公司ID", required = true)
    @NotNull
    private Long companyId;
    @ApiModelProperty(value = "启用标识", required = true)
    @NotNull
    private Integer enabledFlag;
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
     * @return 客户ID(主键)
     */
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return 客户编号
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * @return 客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
     * @return 启用标识
     */
    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
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
