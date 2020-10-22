package com.example.api.dictionary.application.service.impl;

import com.example.api.dictionary.application.service.IDictionaryService;
import com.example.api.dictionary.infrastructure.constant.ConstantConfig;
import com.example.core.constant.CommonConstant;
import com.example.core.dictionary.DictionaryHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 字典 服务实现类
 * </p>
 *
 * @author cliang
 * @since 2020-10-22
 */
@Service
@Slf4j
public class DictionaryServiceImpl implements IDictionaryService {

    /**
     * 注入参数配置
     *
     * @author: cliang
     * @version 创建时间：2020年07月22日
     */
    @Autowired
    private ConstantConfig constantConfig;

    /**
     * 字典库分词处理
     *
     * @param phrase 词组
     * @return List<String>
     * @Title: wordsHandle
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @Override
    public List<String> wordsHandle(String phrase) {
        try {
            List<String> dict = Arrays.asList(constantConfig.getWords().split(CommonConstant.DICTIONARY_SPLIT_SYMBOL));
            return DictionaryHelper.checkWord(dict, phrase);
        } catch (Exception e) {
            log.error("字典库分词处理异常！原因是:", e);
            return null;
        }
    }

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
    @Override
    public List<String> wordsHandleByCustomDict(String phrase, String words) {
        try {
            List<String> dict = Arrays.asList(words.split(CommonConstant.DICTIONARY_SPLIT_SYMBOL));
            return DictionaryHelper.checkWord(dict, phrase);
        } catch (Exception e) {
            log.error("自定义字典分词处理异常！原因是:", e);
            return null;
        }
    }

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
    @Override
    public List<String> wordsHandleByMergeCustomDict(String phrase, String words) {
        try {
            String customWords=constantConfig.getWords()+CommonConstant.DICTIONARY_SPLIT_SYMBOL+words;
            List<String> customDict = Arrays.asList(customWords.split(CommonConstant.DICTIONARY_SPLIT_SYMBOL));
            return DictionaryHelper.checkWord(customDict, phrase);
        } catch (Exception e) {
            log.error("自定义字典分词处理异常！原因是:", e);
            return null;
        }
    }

}
