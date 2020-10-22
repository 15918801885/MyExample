package com.example.api.dictionary.infrastructure.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 全局配置
 *
 * @author cliang
 * @CreateDate 2020年10月22日
 */
@Component
@Validated
@Data
public class ConstantConfig {

    /**
     * 字典配置
     */
    @Value("${dict.words}")
    public String words;

}
