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
 * 物料主数据
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@ApiModel("物料主数据")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_item_5224")
public class Item5224 extends AuditDomain {

    public static final String FIELD_ITEM_ID = "itemId";
    public static final String FIELD_ITEM_CODE = "itemCode";
    public static final String FIELD_ITEM_UOM = "itemUom";
    public static final String FIELD_ITEM_DESCRIPTION = "itemDescription";
    public static final String FIELD_SALEABLE_FLAG = "saleableFlag";
    public static final String FIELD_START_ACTIVE_DATE = "startActiveDate";
    public static final String FIELD_END_ACTIVE_DATE = "endActiveDate";
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


    @ApiModelProperty("物料ID(主键)")
    @Id
    @GeneratedValue
    private Long itemId;
    @ApiModelProperty(value = "物料编码", required = true)
    @NotBlank
    private String itemCode;
    @ApiModelProperty(value = "物料单位", required = true)
    @NotBlank
    private String itemUom;
    @ApiModelProperty(value = "物料描述", required = true)
    @NotBlank
    private String itemDescription;
    @ApiModelProperty(value = "可销售标识", required = true)
    @NotNull
    private Integer saleableFlag;
    @ApiModelProperty(value = "生效起始时间")
    private String startActiveDate;
    @ApiModelProperty(value = "生效结束时间")
    private String endActiveDate;
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
     * @return 物料ID(主键)
     */
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return 物料编码
     */
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return 物料单位
     */
    public String getItemUom() {
        return itemUom;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }

    /**
     * @return 物料描述
     */
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * @return 可销售标识
     */
    public Integer getSaleableFlag() {
        return saleableFlag;
    }

    public void setSaleableFlag(Integer saleableFlag) {
        this.saleableFlag = saleableFlag;
    }

    /**
     * @return 生效起始时间
     */
    public String getStartActiveDate() {
        return startActiveDate;
    }

    public void setStartActiveDate(String startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    /**
     * @return 生效结束时间
     */
    public String getEndActiveDate() {
        return endActiveDate;
    }

    public void setEndActiveDate(String endActiveDate) {
        this.endActiveDate = endActiveDate;
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
