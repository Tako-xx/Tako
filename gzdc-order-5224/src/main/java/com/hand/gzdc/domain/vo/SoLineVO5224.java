package com.hand.gzdc.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoLineVO5224 {

    //
    // 数据库字段
    // ------------------------------------------------------------------------------
    @ApiModelProperty("订单行ID(主键)")
    @Id
    @GeneratedValue
    private Long lSoLineId;
    @ApiModelProperty(value = "订单头ID", required = true)
    @NotNull
    private Long lSoHeaderId;
    @ApiModelProperty(value = "行号", required = true)
    @NotNull
    private Long lLineNumber;
    @ApiModelProperty(value = "产品ID", required = true)
    @NotNull
    private Long lItemId;
    @ApiModelProperty(value = "数量", required = true)
    @NotNull
    private BigDecimal lOrderQuantity;
    @ApiModelProperty(value = "产品单位", required = true)
    @NotBlank
    private String lOrderQuantityUom;
    @ApiModelProperty(value = "销售单价", required = true)
    @NotNull
    private BigDecimal lUnitSellingPrice;
    @ApiModelProperty(value = "备注")
    private String lDescription;
    @ApiModelProperty(value = "附加信息1")
    private String lAddition1;
    @ApiModelProperty(value = "附加信息2")
    private String lAddition2;
    @ApiModelProperty(value = "附加信息3")
    private String lAddition3;
    @ApiModelProperty(value = "附加信息4")
    private String lAddition4;
    @ApiModelProperty(value = "附加信息5")
    private String lAddition5;
    @ApiModelProperty(value = "创建者", required = true)
    @NotNull
    private Long lCreatedBy;
    @ApiModelProperty(value = "创建日期", required = true)
    @NotNull
    private Date lCreationDate;
    @ApiModelProperty(value = "更新者", required = true)
    @NotNull
    private Long lLastUpdatedBy;
    @ApiModelProperty(value = "更新日期", required = true)
    @NotNull
    private Date lLastUpdateDate;
    @ApiModelProperty(value = "版本号", required = true)
    @NotNull
    private Long lObjectVersionNumber;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------
    @ApiModelProperty(value = "物料CODE",required = false)
    @Transient
    private String lItemCode;
    @ApiModelProperty(value = "物料描述",required = false)
    @Transient
    private String lItemDescription;
}
