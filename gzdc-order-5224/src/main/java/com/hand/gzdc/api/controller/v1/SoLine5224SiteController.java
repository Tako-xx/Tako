package com.hand.gzdc.api.controller.v1;

import com.hand.gzdc.app.service.SoLine5224Service;
import com.hand.gzdc.config.SwaggerTags;
import com.hand.gzdc.domain.entity.SoLine5224;
import com.hand.gzdc.domain.repository.SoLine5224Repository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 销售订单行信息 管理 API
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@Api(tags = SwaggerTags.SOLINE)
@RestController("soLine5224SiteController.v1")
@RequestMapping("/v1/so-line5224s")
public class SoLine5224SiteController extends BaseController {

    @Autowired
    private SoLine5224Repository soLine5224Repository;

    @ApiOperation(value = "销售订单行信息列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<SoLine5224>> list(SoLine5224 soLine5224, @ApiIgnore @SortDefault(value = SoLine5224.FIELD_SO_LINE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<SoLine5224> list = soLine5224Repository.pageAndSort(pageRequest, soLine5224);
        return Results.success(list);
    }

    @ApiOperation(value = "销售订单行信息明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{soLineId}")
    public ResponseEntity<SoLine5224> detail(@PathVariable Long soLineId) {
        SoLine5224 soLine5224 = soLine5224Repository.selectByPrimaryKey(soLineId);
        return Results.success(soLine5224);
    }

    @ApiOperation(value = "创建销售订单行信息")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<SoLine5224> create(@RequestBody SoLine5224 soLine5224) {
        validObject(soLine5224);
        soLine5224Repository.insertSelective(soLine5224);
        return Results.success(soLine5224);
    }

    @ApiOperation(value = "修改销售订单行信息")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<SoLine5224> update(@RequestBody SoLine5224 soLine5224) {
        SecurityTokenHelper.validToken(soLine5224);
        soLine5224Repository.updateByPrimaryKeySelective(soLine5224);
        return Results.success(soLine5224);
    }

    @ApiOperation(value = "删除销售订单行信息")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody SoLine5224 soLine5224) {
        SecurityTokenHelper.validToken(soLine5224);
        soLine5224Repository.deleteByPrimaryKey(soLine5224);
        return Results.success();
    }



    //===============================================================================================
    // 以下为自定义接口
    //===============================================================================================

    @Autowired
    private SoLine5224Service soLine5224Service;

    /**
     * 订单删行API
     * @param soLineId
     * @return
     */
    @ApiOperation(value = ">>>订单删行API<<<")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping(path = "/myself/deleteSoLineById/{soLineId}")
    public ResponseEntity<?> deleteSoLineById(@PathVariable @ApiParam(value = "订单明细ID",required = true) Long soLineId) {
        soLine5224Service.deleteSoLineById(soLineId);
        return Results.success();
    }

}
