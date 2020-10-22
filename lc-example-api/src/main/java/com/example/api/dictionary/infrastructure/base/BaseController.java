package com.example.api.dictionary.infrastructure.base;

import com.example.api.dictionary.infrastructure.constant.ResultHelper;
import com.example.api.dictionary.infrastructure.constant.ResultModel;
import com.example.api.dictionary.infrastructure.constant.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 基础控制器类，提供通用的方法处理
 *
 * @author cliang
 * @createdate 2020年10月22日
 */
@Slf4j
public class BaseController {

    /**
     * format 失败 response。
     *
     * @param message 内容
     * @return
     */
    protected ResultModel errorResponse(String message) {
        return ResultHelper.error(ReturnCode.ERROR, message);
    }

    /**
     * format 失败 response。
     *
     * @param message 内容
     * @return
     */
    protected ResultModel errorResponse(String code, String message) {
        return ResultHelper.error(code, message);
    }

    /**
     * 成功的response
     *
     * @param message 内容
     * @param data    实体
     * @return ResponseDto
     */
    protected <T> ResultModel<T> successResponse(String message, T data) {
        return ResultHelper.success(ReturnCode.SUCCESS, message, data);
    }

    /**
     * 成功的response
     *
     * @param message 内容
     * @return ResponseDto
     */
    protected ResultModel successResponse(String message) {
        return ResultHelper.success(ReturnCode.SUCCESS, message);
    }

}
