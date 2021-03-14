package com.hand.gzdc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Api 描述配置
 */
@Configuration
public class SwaggerTags {

    public static final String COMPANY = "1.Company";
    public static final String CUSTOMER = "2.Customer";
    public static final String ITEM = "3.Item";
    public static final String SOHEADER = "4.SoHeader";
    public static final String SOLINE = "5.SoLine";

    @Autowired
    public SwaggerTags(Docket docket) {
        docket.tags(
                new Tag(COMPANY, "COMPANY-公司"),
                new Tag(CUSTOMER, "CUSTOMER-顾客"),
                new Tag(ITEM, "ITEM-物料"),
                new Tag(SOHEADER, "SOHEADER-订单头"),
                new Tag(SOLINE, "SOLINE-订单明细")
        );
    }
}
