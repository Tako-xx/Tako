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
 * 公司主数据表
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@ApiModel("公司主数据表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_company_5224")
public class Company5224 extends AuditDomain {

    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_COMPANY_NUMBER = "companyNumber";
    public static final String FIELD_COMPANY_NAME = "companyName";
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


    @ApiModelProperty("公司ID(主键)")
    @Id
    @GeneratedValue
    private Long companyId;
    @ApiModelProperty(value = "公司编号", required = true)
    @NotBlank
    private String companyNumber;
    @ApiModelProperty(value = "公司名称", required = true)
    @NotBlank
    private String companyName;
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
     * @return 公司ID(主键)
     */
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return 公司编号
     */
    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    /**
     * @return 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
