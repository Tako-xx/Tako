package com.hand.gzdc.api.controller.v1;

import com.hand.gzdc.app.service.SoHeader5224Service;
import com.hand.gzdc.config.SwaggerTags;
import com.hand.gzdc.domain.entity.SoHeader5224;
import com.hand.gzdc.domain.repository.SoHeader5224Repository;
import com.hand.gzdc.domain.vo.SoHeaderVO5224;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 销售订单头信息 管理 API
 *
 * @author yu.zhang03@hand-china.com 2021-03-11 09:58:24
 */
@Slf4j
@Api(tags = SwaggerTags.SOHEADER)
@RestController("soHeader5224SiteController.v1")
@RequestMapping("/v1/so-header5224s")
public class SoHeader5224SiteController extends BaseController {

    @Autowired
    private SoHeader5224Repository soHeader5224Repository;

    @ApiOperation(value = "销售订单头信息列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<SoHeader5224>> list(SoHeader5224 soHeader5224, @ApiIgnore @SortDefault(value = SoHeader5224.FIELD_SO_HEADER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<SoHeader5224> list = soHeader5224Repository.pageAndSort(pageRequest, soHeader5224);
        return Results.success(list);
    }

    @ApiOperation(value = "销售订单头信息明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{soHeaderId}")
    public ResponseEntity<SoHeader5224> detail(@PathVariable Long soHeaderId) {
        SoHeader5224 soHeader5224 = soHeader5224Repository.selectByPrimaryKey(soHeaderId);
        return Results.success(soHeader5224);
    }

    @ApiOperation(value = "创建销售订单头信息")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<SoHeader5224> create(@RequestBody SoHeader5224 soHeader5224) {
        validObject(soHeader5224);
        soHeader5224Repository.insertSelective(soHeader5224);
        return Results.success(soHeader5224);
    }

    @ApiOperation(value = "修改销售订单头信息")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<SoHeader5224> update(@RequestBody SoHeader5224 soHeader5224) {
        SecurityTokenHelper.validToken(soHeader5224);
        soHeader5224Repository.updateByPrimaryKeySelective(soHeader5224);
        return Results.success(soHeader5224);
    }

    @ApiOperation(value = "删除销售订单头信息")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody SoHeader5224 soHeader5224) {
        SecurityTokenHelper.validToken(soHeader5224);
        soHeader5224Repository.deleteByPrimaryKey(soHeader5224);
        return Results.success();
    }


    //===============================================================================================
    // 以下为自定义接口
    //===============================================================================================

    @Autowired
    private SoHeader5224Service soHeader5224Service;

    /**
     * 订单查询API
     *
     * @param soHeaderId
     * @return
     */
    @ApiOperation(value = ">>>订单查询API<<<")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping(path = "/myself/querySoById/{soHeaderId}")
    public ResponseEntity<SoHeaderVO5224> querySoById(@ApiParam(value = "订单头ID", required = true) @PathVariable Long soHeaderId) {
        SoHeaderVO5224 soHeaderVO5224 = soHeader5224Service.querySoById(soHeaderId);
        return Results.success(soHeaderVO5224);
    }

    /**
     * 订单删除API
     *
     * @param soHeaderId
     * @return
     */
    @ApiOperation(value = ">>>订单删除API<<<")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping(path = "/myself/deleteSoById/{soHeaderId}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> deleteSoById(@ApiParam(value = "订单头ID", required = true) @PathVariable Long soHeaderId) {
        soHeader5224Service.deleteSoById(soHeaderId);
        return Results.success();
    }

    /**
     * 订单保存API
     *
     * @return
     */
    @ApiOperation(value = ">>>订单保存API<<<")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping(path = "/myself/saveSoOrder")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> saveSoOrder(@ApiParam(value = "订单头-明细") @RequestBody SoHeaderVO5224 soHeaderVO5224) {
        soHeader5224Service.saveSoOrder(soHeaderVO5224);
        return Results.success();
    }

    /**
     * 订单汇总API
     *
     * @param companyId
     * @param customerId
     * @param orderNumber
     * @param orderStatus
     * @return
     */
    @ApiOperation(value = ">>>订单汇总API<<<")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping(path = "/myself/querySoCollect/{companyId}/{customerId}/{orderNumber}/{orderStatus}")
    public ResponseEntity<List<SoHeaderVO5224>> querySoCollect(@ApiParam(value = "公司ID") @PathVariable(value = "companyId") String companyId,
                                                               @ApiParam(value = "顾客ID") @PathVariable(value = "customerId") String customerId,
                                                               @ApiParam(value = "订单号") @PathVariable(value = "orderNumber") String orderNumber,
                                                               @ApiParam(value = "订单状态") @PathVariable(value = "orderStatus") String orderStatus) {
        //Swagger中Long类型不传值会引起类型转换异常
        //追加注解@RequestParam(defaultValue = "")后Swagger参数始终为null（个人理解是Swagger页面的问题，在postman接口访问没有权限）
        //所以参数全定义为String类型
        //Swagger页面测试不传值时默认不为{companyId}，{customerId}，{orderNumber}，{orderStatus}
        //所以在类（SoHeader5224ServiceImpl.querySoCollect）中做了判断以及类型转换
        //正在寻找常规解决方法
        return Results.success(soHeader5224Service.querySoCollect(companyId, customerId, orderNumber, orderStatus));
    }

    /**
     * 订单状态API
     *
     * @param soHeaderVO5224
     * @return
     */
    @ApiOperation(value = ">>>订单状态API<<<")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping(path = "/updateSoOrderStatus")
    public ResponseEntity<?> updateSoOrderStatus(@RequestBody SoHeaderVO5224 soHeaderVO5224) {
        soHeader5224Service.updateSoOrderStatus(soHeaderVO5224);
        return Results.success();
    }
}
