package com.allinprogram.anothervideohub.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegexUtil
 *
 * @author AllinProgram
 * @since 2022-04-27 17:35 星期三
 */
public class RegexUtil {

    public static String parse(String content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(content);
        PreconditionUtil.checkArgument(m.groupCount() >= 1, "can't find anything.");
        return m.find() ? m.group(1) : "";
    }
}
