package com.hand.gzdc.api.controller.v1;

import com.hand.gzdc.config.SwaggerTags;
import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hand.gzdc.domain.entity.Item5224;
import com.hand.gzdc.domain.repository.Item5224Repository;
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
 * 物料主数据 管理 API
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@Api(tags = SwaggerTags.ITEM)
@RestController("item5224SiteController.v1")
@RequestMapping("/v1/item5224s")
public class Item5224SiteController extends BaseController {

    @Autowired
    private Item5224Repository item5224Repository;

    @ApiOperation(value = "物料主数据列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<Item5224>> list(Item5224 item5224, @ApiIgnore @SortDefault(value = Item5224.FIELD_ITEM_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Item5224> list = item5224Repository.pageAndSort(pageRequest, item5224);
        return Results.success(list);
    }

    @ApiOperation(value = "物料主数据明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{itemId}")
    public ResponseEntity<Item5224> detail(@PathVariable Long itemId) {
        Item5224 item5224 = item5224Repository.selectByPrimaryKey(itemId);
        return Results.success(item5224);
    }

    @ApiOperation(value = "创建物料主数据")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<Item5224> create(@RequestBody Item5224 item5224) {
        validObject(item5224);
        item5224Repository.insertSelective(item5224);
        return Results.success(item5224);
    }

    @ApiOperation(value = "修改物料主数据")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<Item5224> update(@RequestBody Item5224 item5224) {
        SecurityTokenHelper.validToken(item5224);
        item5224Repository.updateByPrimaryKeySelective(item5224);
        return Results.success(item5224);
    }

    @ApiOperation(value = "删除物料主数据")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Item5224 item5224) {
        SecurityTokenHelper.validToken(item5224);
        item5224Repository.deleteByPrimaryKey(item5224);
        return Results.success();
    }

}
