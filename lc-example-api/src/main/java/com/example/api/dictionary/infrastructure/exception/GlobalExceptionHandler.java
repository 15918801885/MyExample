package com.example.api.dictionary.infrastructure.exception;

import com.example.api.dictionary.infrastructure.constant.ResultHelper;
import com.example.api.dictionary.infrastructure.constant.ResultModel;
import com.example.api.dictionary.infrastructure.constant.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 *
 * @author cliang
 * @createdate 2020年10月22日
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return ResultModel
     * @Title: exceptionHandler
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResultModel exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return ResultHelper.error(ReturnCode.ERROR, "请求的数据格式不符!");
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return ResultModel
     * @Title: exceptionHandler
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultModel exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:",e);
        return ResultHelper.error(ReturnCode.ERROR, "服务器正忙，请稍后再试！");
    }

}
