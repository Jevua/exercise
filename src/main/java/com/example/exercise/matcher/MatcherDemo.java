package com.example.exercise.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xzh
 */
public class MatcherDemo {
    public static void main(String[] args) {
        // 匹配连续三个火五个数字
        Pattern pattern = Pattern.compile("(\\d{3,5})");
        String charSequence = "123-34345-234-00";
        Matcher matcher = pattern.matcher(charSequence);
        // 整个字符串匹配
        System.out.println(matcher.matches());
        // 从指定位置开始部分匹配
        System.out.println(matcher.lookingAt());
        // 从当前位置部分匹配
        System.out.println(matcher.find());
        System.out.println("groupCount:" + matcher.groupCount());
        System.out.println("group:" + matcher.group());
        System.out.println("group0:" + matcher.group(0));
        System.out.println("group1:" + matcher.group(1));
        System.out.println(matcher.find());
        // lookingAt和find匹配后位置保持不变会影响后续匹配
        System.out.println(matcher.find());

        System.out.println("##################");
        // 匹配 {{11}}*{{22}}之类的
        Pattern pattern1 = Pattern.compile("\\{\\{([0-9]{1,9})\\}\\}");
        String str = "{{11}}*{{22}}+2";
        Matcher matcher1 = pattern1.matcher(str);
        String value;
        StringBuffer stringBuffer = new StringBuffer();
        //
//        if (matcher1.find()) {
//            value = matcher1.group(1);
//            matcher1.appendReplacement(stringBuffer, value);
//        }
//        matcher1.appendTail(stringBuffer);
        // 所有的匹配都替换
        // 第一次匹配到{{11}} 第二次匹配到{{22}}
        while (matcher1.find()) {
            // 第一次{{11}} 第二次{{22}}
            System.out.println(matcher1.group(0));
            // 11 22
            System.out.println(matcher1.group(1));
            value = matcher1.group(1);
            // appendReplacement方法：value待替换的字符串，这个方法会把匹配到的内容替换为value，并且把从上次替换的位置到这次替换位置之间的字符串也拿到，然后，加上这次替换后的结果一起追加到StringBuffer里（假如这次替换是第一次替换，那就是只追加替换后的字符串啦）。
            // 第一次结果为 11 第二次为 11*22
            matcher1.appendReplacement(stringBuffer, value);
        }
        // 将最后匹配后的内容追加到stringBuffer
        matcher1.appendTail(stringBuffer);
        System.out.println(stringBuffer);
        // 转义
        System.out.println(Matcher.quoteReplacement("$"));
    }
}
