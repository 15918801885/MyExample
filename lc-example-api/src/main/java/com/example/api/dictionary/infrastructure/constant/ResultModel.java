package com.example.api.dictionary.infrastructure.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 返回模型实体
 *
 * @author cliang
 * @createdate 2020年10月22日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultModel<T> implements Serializable {
    private static final long serialVersionUID = 6555943285979897107L;

    @ApiModelProperty(value = "状态")
    private Boolean success = false;

    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "消息")
    private String message;

    @ApiModelProperty(value = "数据")
    private T data;

    public ResultModel() {
    }

    public ResultModel(String code, String message, T data) {
        this.success = true;
        this.code = Integer.valueOf(code);
        this.message = message;
        this.data = data;
    }

    public ResultModel(String code, String message) {
        this.code = Integer.valueOf(code);
        this.message = message;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public String getCode() {
        return String.valueOf(this.code);
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("resultModel {");
        stringBuilder.append("\"success\"").append(":").append(this.success).append(", ");
        stringBuilder.append("\"code\"").append(":").append(this.code).append(", ");
        stringBuilder.append("\"message\"").append(":").append("\"").append(this.message).append("\"");
        if (this.data != null) {
            stringBuilder.append(", ").append("\"data\"").append(":").append("\"").append(this.data).append("\"");
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

