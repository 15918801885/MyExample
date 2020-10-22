package com.example.core.dictionary;

import com.example.core.dictionary.model.WordbreakerPhrase;
import org.hibernate.validator.internal.util.StringHelper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字典 帮助类
 *
 * @author cliang
 * @since 2020-10-22
 */
public class DictionaryHelper {

    /**
     * 排查单词是否存在字典里
     *
     * @param phrase 词组
     * @param words  字典单词集合
     * @return List<String>
     * @Title checkWord
     * @author cliang
     * @version 创建时间：2020年10月22日
     */
    public static List<String> checkWord(List<String> words, String phrase) {
        List<String> dict = words.stream().distinct().collect(Collectors.toList());
        dict.remove(null);
        dict.remove("");
        List<WordbreakerPhrase> phrases = wordbreaker(dict, WordbreakerPhrase.builder()
                .phrase(phrase)
                .input(phrase)
                .output("")
                .build());
        List<String> list = new ArrayList<>();
        phrases.stream().forEach(r -> {
            list.add(r.getOutput().trim());
        });
        if (list.size() <= 0) {
            list.add(phrase);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 分词器检索
     *
     * @param phrase 词组
     * @param words  字典单词集合
     * @return List<WordbreakerPhrase>
     * @Title checkWord
     * @author cliang
     * @version 创建时间：2020年10月22日
     */
    public static List<WordbreakerPhrase> wordbreaker(List<String> words, WordbreakerPhrase phrase) {
        List<WordbreakerPhrase> list = new ArrayList<WordbreakerPhrase>();
        if (StringHelper.isNullOrEmptyString(phrase.getInput())) {
            list.add(phrase);
            return list;
        }
        for (String word : words) {
            String filterWord = word.replaceAll(" ", "");
            if (filterWord.length() <= 1) {
                continue;
            }
            if (phrase.getInput().toLowerCase().startsWith(filterWord.toLowerCase())) {
                list.addAll(wordbreaker(words, WordbreakerPhrase.builder()
                        .phrase(phrase.getPhrase())
                        .input(phrase.getInput().substring(filterWord.length()))
                        .output(phrase.getOutput() + word + " ")
                        .build()));
            }
        }
        return (list.size() > 0) ? list : wordbreakerToContain(words, phrase);
    }

    /**
     * 分词器中间检索
     *
     * @param phrase 词组
     * @param words  字典单词集合
     * @return List<WordbreakerPhrase>
     * @Title checkWord
     * @author cliang
     * @version 创建时间：2020年10月22日
     */
    public static List<WordbreakerPhrase> wordbreakerToContain(List<String> words, WordbreakerPhrase phrase) {
        List<WordbreakerPhrase> list = new ArrayList<WordbreakerPhrase>();
        if (StringHelper.isNullOrEmptyString(phrase.getInput())) {
            list.add(phrase);
            return list;
        }
        List<WordbreakerPhrase> wordbreakerPhrases = new ArrayList<WordbreakerPhrase>();
        int comparison = 0;
        for (String word : words) {
            String filterWord = word.replaceAll(" ", "");
            if (filterWord.length() <= 1) {
                continue;
            }
            int result = phrase.getInput().toLowerCase().indexOf(filterWord.toLowerCase());
            if (result > 0 && (comparison == 0 || result <= comparison)) {
                String input = phrase.getInput();
                String unidentified = input.substring(0, result);
                String surplus = input.substring(unidentified.length() + filterWord.length());
                if (result != comparison) {
                    wordbreakerPhrases.clear();
                }
                wordbreakerPhrases.add(WordbreakerPhrase.builder()
                        .phrase(phrase.getPhrase())
                        .input(surplus)
                        .output(phrase.getOutput() + unidentified + " " + word + " ")
                        .build());
                comparison = result;
            }
        }
        for (WordbreakerPhrase wordbreakerPhrase : wordbreakerPhrases) {
            list.addAll(wordbreaker(words, wordbreakerPhrase));
        }
        if (list.size() <= 0 && !StringHelper.isNullOrEmptyString(phrase.getOutput())) {
            list.add(WordbreakerPhrase.builder()
                    .phrase(phrase.getPhrase())
                    .input("")
                    .output(phrase.getOutput() + phrase.getInput() + " ")
                    .build());
        }
        return list;
    }

}
