package service.sys.common.api;

import com.ymu.spcselling.infrastructure.spring.mvc.api.ApiRespResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.sys.common.vo.req.VIdGenReq;

/**
 * 分布式id生成服务。
 */
@RequestMapping("/id")
public interface IdGenerateServiceApi {

    /**
     * 生成分布式id
     * @param vIdGenReq 请求对象。body体
     * @return 生成的系统全局唯一id
     *
     * @api {post} /v1/id/gen 生成分布式id
     * @apiVersion 1.0.0
     * @apiName genId
     * @apiGroup ID
     * @apiPermission admin
     *
     * @apiDescription 通过数据中心id，机器id生成long型唯一id
     *
     * @apiParam {long} dataCenterId 数据中心id,0-31。
     * @apiParam {long} workerId 机器id，0-31。
     *
     * @apiParamExample {json} Request-Example:
     *     Request Headers
     *         Content-Type:application/json
     *     body:
     *     {
     *       "dataCenterId": 0,
     *       "workerId:" 0
     *     }
     *
     * @apiExample 请求例子:
     * curl -i http://localhost/user/4711
     *
     * @apiSuccess {long}   id      生成的id
     *
     * @apiError NoAccessRight 认证不通过
     * @apiError UserNotFound   The <code>id</code> of the User was not found.
     *
     * @apiErrorExample 响应例子:
     *     HTTP/1.1 401 Not Authenticated
     *     {
     *       "error": "NoAccessRight"
     *     }
     *
     * @apiSampleRequest url
     *
     */
    @PostMapping("/")
    long genId(@RequestBody @Validated VIdGenReq vIdGenReq);

    /**
     *
     * 解析分布式id
     * @param id
     * @return
     *
     * @api {post} /v1/id/expId  解析分布式id
     * @apiVersion 1.0.0
     * @apiName expId
     * @apiGroup ID
     * @apiPermission admin
     *
     * @apiDescription 把id解析成ID对象
     *
     * @apiParam {long} id 接口生成的id，必传。
     *
     * @apiExample 请求例子:
     *  http://localhost/v1/id/expId?id=352608540609069079
     *
     * @apiSuccess {long}   timeStamp     时间戳。41位的时间序列
     * @apiSuccess {long}   dataCenterId     数据中心id
     * @apiSuccess {long}   workerId     节点机器id
     * @apiSuccess {long}   sequence     序列号
     *
     * @apiError NoAccessRight 认证不通过
     *  //@apiError UserNotFound   The <code>id</code> of the User was not found.
     *
     * @apiErrorExample 响应例子:
     *     HTTP/1.1 401 Not Authenticated
     *     {
     *       "error": "NoAccessRight"
     *     }
     *
     * @apiSampleRequest http://localhost:8001/v1/id/expId
     *
     */
    @GetMapping("/{id}")
    ApiRespResultVO expId(@PathVariable(name = "id") long id);
}
