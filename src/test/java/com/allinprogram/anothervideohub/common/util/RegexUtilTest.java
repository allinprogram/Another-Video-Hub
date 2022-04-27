package com.allinprogram.anothervideohub.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RegexUtilTest
 *
 * @author AllinProgram
 * @since 2022-04-27 23:09 星期三
 */
class RegexUtilTest {

    @Test
    void parse() {
        String content = "<source src='https://AllinProgram.com/video.m3u8' type='application/x-mpegURL'>";
        String re = "(https.*?com)";
        Assertions.assertEquals(RegexUtil.parse(content, re), "https://AllinProgram.com");
    }
}