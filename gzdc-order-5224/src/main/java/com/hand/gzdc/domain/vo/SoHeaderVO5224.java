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
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoHeaderVO5224 {
    //
    // 数据库字段
    // ------------------------------------------------------------------------------
    @ApiModelProperty("订单头ID(主键)")
    @Id
    @GeneratedValue
    private Long hSoHeaderId;
    @ApiModelProperty(value = "订单编号", required = true)
    @NotBlank
    private String hOrderNumber;
    @ApiModelProperty(value = "公司ID", required = true)
    @NotNull
    private Long hCompanyId;
    @ApiModelProperty(value = "订单日期", required = true)
    @NotBlank
    private String hOrderDate;
    @ApiModelProperty(value = "订单状态", required = true)
    @NotBlank
    private String hOrderStatus;
    @ApiModelProperty(value = "客户ID", required = true)
    @NotNull
    private Long hCustomerId;
    @ApiModelProperty(value = "创建者", required = true)
    @NotNull
    private Long hCreatedBy;
    @ApiModelProperty(value = "创建日期", required = true)
    @NotNull
    private Date hCreationDate;
    @ApiModelProperty(value = "更新者", required = true)
    @NotNull
    private Long hLastUpdatedBy;
    @ApiModelProperty(value = "更新日期", required = true)
    @NotNull
    private Date hLastUpdateDate;
    @ApiModelProperty(value = "版本号", required = true)
    @NotNull
    private Long hObjectVersionNumber;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------
    @ApiModelProperty(value = "公司名称",required = false)
    @Transient
    private String hCompanyName;
    @ApiModelProperty(value = "顾客番号",required = false)
    @Transient
    private String hCustomerNumber;
    @ApiModelProperty(value = "顾客名称",required = false)
    @Transient
    private String hCustomerName;
    @ApiModelProperty(value = "订单总金额",required = false)
    @Transient
    private BigDecimal hOrderAmount;
    @ApiModelProperty(value = "订单明细集",required = false)
    @Transient
    private List<SoLineVO5224> soLineVO5224List;
}
