package com.example.core.dictionary.model;

import lombok.Builder;
import lombok.Data;

/**
 * 分词结构
 *
 * @author cliang
 * @since 2020-10-22
 */
@Builder
@Data
public class WordbreakerPhrase {

    /**
     * 原词组
     */
    private String phrase;

    /**
     * 输入
     */
    private String input;

    /**
     * 输出
     */
    private String output;

}

