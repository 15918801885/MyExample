package com.example.api.dictionary.application.service;

import java.util.List;

/**
 * <p>
 * 字典 服务类
 * </p>
 *
 * @author cliang
 * @since 2020-10-22
 */
public interface IDictionaryService {

    /**
     * 分词处理
     *
     * @param phrase 词组
     * @return List<String>
     * @Title: wordsHandle
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    List<String> wordsHandle(String phrase);

    /**
     * 自定义字典分词处理
     *
     * @param phrase 词组
     * @param words  用户自定义字典
     * @return List<String>
     * @Title: wordsHandle
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    List<String> wordsHandleByCustomDict(String phrase, String words);

    /**
     * 合并自定义字典分词处理
     *
     * @param phrase 词组
     * @param words  用户自定义字典
     * @return List<String>
     * @Title: wordsHandle
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    List<String> wordsHandleByMergeCustomDict(String phrase, String words);

}
