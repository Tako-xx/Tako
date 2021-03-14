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
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 销售订单行信息
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@ApiModel("销售订单行信息")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_so_line_5224")
public class SoLine5224 extends AuditDomain {

    public static final String FIELD_SO_LINE_ID = "soLineId";
    public static final String FIELD_SO_HEADER_ID = "soHeaderId";
    public static final String FIELD_LINE_NUMBER = "lineNumber";
    public static final String FIELD_ITEM_ID = "itemId";
    public static final String FIELD_ORDER_QUANTITY = "orderQuantity";
    public static final String FIELD_ORDER_QUANTITY_UOM = "orderQuantityUom";
    public static final String FIELD_UNIT_SELLING_PRICE = "unitSellingPrice";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_ADDITION1 = "addition1";
    public static final String FIELD_ADDITION2 = "addition2";
    public static final String FIELD_ADDITION3 = "addition3";
    public static final String FIELD_ADDITION4 = "addition4";
    public static final String FIELD_ADDITION5 = "addition5";
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


    @ApiModelProperty("订单行ID(主键)")
    @Id
    @GeneratedValue
    private Long soLineId;
    @ApiModelProperty(value = "订单头ID", required = true)
    @NotNull
    private Long soHeaderId;
    @ApiModelProperty(value = "行号", required = true)
    @NotNull
    private Long lineNumber;
    @ApiModelProperty(value = "产品ID", required = true)
    @NotNull
    private Long itemId;
    @ApiModelProperty(value = "数量", required = true)
    @NotNull
    private BigDecimal orderQuantity;
    @ApiModelProperty(value = "产品单位", required = true)
    @NotBlank
    private String orderQuantityUom;
    @ApiModelProperty(value = "销售单价", required = true)
    @NotNull
    private BigDecimal unitSellingPrice;
    @ApiModelProperty(value = "备注")
    private String description;
    @ApiModelProperty(value = "附加信息1")
    private String addition1;
    @ApiModelProperty(value = "附加信息2")
    private String addition2;
    @ApiModelProperty(value = "附加信息3")
    private String addition3;
    @ApiModelProperty(value = "附加信息4")
    private String addition4;
    @ApiModelProperty(value = "附加信息5")
    private String addition5;
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
     * @return 订单行ID(主键)
     */
    public Long getSoLineId() {
        return soLineId;
    }

    public void setSoLineId(Long soLineId) {
        this.soLineId = soLineId;
    }

    /**
     * @return 订单头ID
     */
    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    /**
     * @return 行号
     */
    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * @return 产品ID
     */
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return 数量
     */
    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    /**
     * @return 产品单位
     */
    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    /**
     * @return 销售单价
     */
    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    /**
     * @return 备注
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return 附加信息1
     */
    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1;
    }

    /**
     * @return 附加信息2
     */
    public String getAddition2() {
        return addition2;
    }

    public void setAddition2(String addition2) {
        this.addition2 = addition2;
    }

    /**
     * @return 附加信息3
     */
    public String getAddition3() {
        return addition3;
    }

    public void setAddition3(String addition3) {
        this.addition3 = addition3;
    }

    /**
     * @return 附加信息4
     */
    public String getAddition4() {
        return addition4;
    }

    public void setAddition4(String addition4) {
        this.addition4 = addition4;
    }

    /**
     * @return 附加信息5
     */
    public String getAddition5() {
        return addition5;
    }

    public void setAddition5(String addition5) {
        this.addition5 = addition5;
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
