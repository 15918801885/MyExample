package com.example.api;

import com.example.api.dictionary.application.service.IDictionaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 字典单元测试
 *
 * @author cliang
 * @since 2020/10/22 16:35
 */
@SpringBootTest
public class DictionaryServiceTest {
    /**
     * 注入字典接口
     *
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @Autowired
    private IDictionaryService dictionaryService;

    /**
     * @Title: wordsHandleTest1
     * <p>字典库分词处理1</p>
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @Test
    public void wordsHandleTest1() {
        String phrase = "ilikesamsungmobile";
        List<String> phrases = dictionaryService.wordsHandle(phrase);
        phrases.stream().forEach(r -> {
            System.out.println(r);
        });
    }

    /**
     * @Title: wordsHandleTest2
     * <p>字典库分词处理2</p>
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @Test
    public void wordsHandleTest2() {
        String phrase = "ilikeicecreamandmango";
        List<String> phrases = dictionaryService.wordsHandle(phrase);
        phrases.stream().forEach(r -> {
            System.out.println(r);
        });
    }

    /**
     * @Title: wordsHandleByCustomDict
     * <p>自定义字典分词处理</p>
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @Test
    public void wordsHandleByCustomDict() {
        String phrase = "ilikeicecreamandmango";
        String words = "i,like,sam,sung,mobile,icecream,man go,mango";
        List<String> phrases = dictionaryService.wordsHandleByCustomDict(phrase, words);
        phrases.stream().forEach(r -> {
            System.out.println(r);
        });
    }

    /**
     * @Title: wordsHandleByMergeCustomDict
     * <p>合并自定义字典分词处理</p>
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @Test
    public void wordsHandleByMergeCustomDict() {
        String phrase = "ilikeicecreamandmango";
        String words = "i,like,sam,sung,mobile,icecream,man go,mango";
        List<String> phrases = dictionaryService.wordsHandleByMergeCustomDict(phrase, words);
        phrases.stream().forEach(r -> {
            System.out.println(r);
        });
    }

}
