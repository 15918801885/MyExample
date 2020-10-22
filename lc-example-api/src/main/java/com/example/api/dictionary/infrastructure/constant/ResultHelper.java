package com.example.api.dictionary.infrastructure.constant;

/**
 * 返回模型处理类
 *
 * @author cliang
 * @createdate 2020年10月22日
 */
public class ResultHelper {
    public ResultHelper() {
    }

    public static <T> ResultModel<T> success(String code, String message, T data) {
        return new ResultModel(code, message, data);
    }

    public static <T> ResultModel<T> success(String code, String message) {
        return new ResultModel(code, message, (Object) null);
    }

    public static <T> ResultModel<T> error(String code, String message) {
        return new ResultModel(code, message);
    }
}
