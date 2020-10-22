package com.example.api.dictionary.infrastructure.constant;

/**
 * 返回编码常量配置
 *
 * @author cliang
 * @CreateDate 2020年10月22日
 */
public class ReturnCode {

    /**
     * 200：返回成功
     */
    public final static String SUCCESS = "200";

    /**
     * 201:鉴权失败
     */
    public static final String AUTH_ERROR = "201";

    /**
     * 9999:失败
     */
    public static final String ERROR = "9999";
    /**
     * 9001:系统繁忙
     */
    public static final String CONNECTION_ERROR = "9001";
    /**
     * 9002:未知错误
     */
    public static final String UNKNOWN_ERROR = "9002";
    /**
     * 9003:数据库异常
     */
    public static final String DATEACCESS_ERROR = "9003";

    /**
     * 1000:非法参数
     */
    public static final String INVALID_PARAMTER = "1000";

}