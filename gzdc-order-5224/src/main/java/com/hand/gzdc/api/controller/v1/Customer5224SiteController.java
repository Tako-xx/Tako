package com.hand.gzdc.api.controller.v1;

import com.hand.gzdc.config.SwaggerTags;
import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hand.gzdc.domain.entity.Customer5224;
import com.hand.gzdc.domain.repository.Customer5224Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 客户主数据表 管理 API
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@Api(tags = SwaggerTags.CUSTOMER)
@RestController("customer5224SiteController.v1")
@RequestMapping("/v1/customer5224s")
public class Customer5224SiteController extends BaseController {

    @Autowired
    private Customer5224Repository customer5224Repository;

    @ApiOperation(value = "客户主数据表列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<Customer5224>> list(Customer5224 customer5224, @ApiIgnore @SortDefault(value = Customer5224.FIELD_CUSTOMER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Customer5224> list = customer5224Repository.pageAndSort(pageRequest, customer5224);
        return Results.success(list);
    }

    @ApiOperation(value = "客户主数据表明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer5224> detail(@PathVariable Long customerId) {
        Customer5224 customer5224 = customer5224Repository.selectByPrimaryKey(customerId);
        return Results.success(customer5224);
    }

    @ApiOperation(value = "创建客户主数据表")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<Customer5224> create(@RequestBody Customer5224 customer5224) {
        validObject(customer5224);
        customer5224Repository.insertSelective(customer5224);
        return Results.success(customer5224);
    }

    @ApiOperation(value = "修改客户主数据表")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<Customer5224> update(@RequestBody Customer5224 customer5224) {
        SecurityTokenHelper.validToken(customer5224);
        customer5224Repository.updateByPrimaryKeySelective(customer5224);
        return Results.success(customer5224);
    }

    @ApiOperation(value = "删除客户主数据表")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Customer5224 customer5224) {
        SecurityTokenHelper.validToken(customer5224);
        customer5224Repository.deleteByPrimaryKey(customer5224);
        return Results.success();
    }

}
