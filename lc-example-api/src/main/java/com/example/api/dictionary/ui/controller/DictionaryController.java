package com.example.api.dictionary.ui.controller;

import com.example.api.dictionary.application.service.IDictionaryService;
import com.example.api.dictionary.infrastructure.base.BaseController;
import com.example.api.dictionary.infrastructure.constant.ResultModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 字典 前端控制器
 * </p>
 *
 * @author cliang
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/api/dictionary")
@Api(tags = "字典api")
public class DictionaryController extends BaseController {

    /**
     * 注入字典接口
     *
     * @author: cliang
     * @version 创建时间：2020年05月28日
     */
    @Autowired
    private IDictionaryService dictionaryService;

    /**
     * 字典库分词处理
     *
     * @param phrase 输入的词组
     * @return ResultModel
     * @Title: wordsHandle
     * @author: cliang
     * @version 创建时间：2020年07月21日
     */
    @ResponseBody
    @GetMapping("/wordsHandle")
    @ApiOperation(value = "字典库分词处理", notes = "字典库分词处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phrase", value = "输入的词组")
    })
    public ResultModel wordsHandle(String phrase) {
        List<String> list = dictionaryService.wordsHandle(phrase);
        return (list == null) ? this.errorResponse("字典库分词处理失败！") : this.successResponse("字典库分词处理成功", list);
    }

    /**
     * 自定义字典分词处理
     *
     * @param phrase 输入的词组
     * @param words  用户输入自定义字典
     * @return ResultModel
     * @Title: wordsHandleByCustomDict
     * @author: cliang
     * @version 创建时间：2020年07月21日
     */
    @ResponseBody
    @GetMapping("/wordsHandleByCustomDict")
    @ApiOperation(value = "自定义字典分词处理", notes = "自定义字典分词处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phrase", value = "输入的词组"),
            @ApiImplicitParam(name = "words", value = "用户输入自定义字典")
    })
    public ResultModel wordsHandleByCustomDict(String phrase, String words) {
        List<String> list = dictionaryService.wordsHandleByCustomDict(phrase, words);
        return (list == null) ? this.errorResponse("自定义字典分词处理失败！") : this.successResponse("自定义字典分词处理成功", list);
    }

    /**
     * 合并自定义字典分词处理
     *
     * @param phrase 输入的词组
     * @param words  用户输入自定义字典
     * @return ResultModel
     * @Title: wordsHandleByMergeCustomDict
     * @author: cliang
     * @version 创建时间：2020年07月21日
     */
    @ResponseBody
    @GetMapping("/wordsHandleByMergeCustomDict")
    @ApiOperation(value = "合并自定义字典分词处理", notes = "合并自定义字典分词处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phrase", value = "输入的词组"),
            @ApiImplicitParam(name = "words", value = "用户输入自定义字典")
    })
    public ResultModel wordsHandleByMergeCustomDict(String phrase, String words) {
        List<String> list = dictionaryService.wordsHandleByMergeCustomDict(phrase, words);
        return (list == null) ? this.errorResponse("合并自定义字典分词处理失败！") : this.successResponse("合并自定义字典分词处理成功", list);
    }

}
