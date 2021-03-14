package com.hand.gzdc.api.controller.v1;

import com.hand.gzdc.config.SwaggerTags;
import com.hand.gzdc.domain.entity.Company5224;
import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hand.gzdc.domain.repository.Company5224Repository;
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
 * 公司主数据表 管理 API
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@Api(tags = SwaggerTags.COMPANY)
@RestController("company5224SiteController.v1")
@RequestMapping("/v1/company5224s")
public class Company5224SiteController extends BaseController {

    @Autowired
    private Company5224Repository company5224Repository;

    @ApiOperation(value = "公司主数据表列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<Company5224>> list(Company5224 company5224, @ApiIgnore @SortDefault(value = Company5224.FIELD_COMPANY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Company5224> list = company5224Repository.pageAndSort(pageRequest, company5224);
        return Results.success(list);
    }

    @ApiOperation(value = "公司主数据表明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{companyId}")
    public ResponseEntity<Company5224> detail(@PathVariable Long companyId) {
        Company5224 company5224 = company5224Repository.selectByPrimaryKey(companyId);
        return Results.success(company5224);
    }

    @ApiOperation(value = "创建公司主数据表")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<Company5224> create(@RequestBody Company5224 company5224) {
        validObject(company5224);
        company5224Repository.insertSelective(company5224);
        return Results.success(company5224);
    }

    @ApiOperation(value = "修改公司主数据表")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<Company5224> update(@RequestBody Company5224 company5224) {
        SecurityTokenHelper.validToken(company5224);
        company5224Repository.updateByPrimaryKeySelective(company5224);
        return Results.success(company5224);
    }

    @ApiOperation(value = "删除公司主数据表")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Company5224 company5224) {
        SecurityTokenHelper.validToken(company5224);
        company5224Repository.deleteByPrimaryKey(company5224);
        return Results.success();
    }

}
