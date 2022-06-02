package com.allinprogram.anothervideohub.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HtmlUtilTest {

    @Test
    void unescape() {
        String encode = "%3c%73%6f%75%72%63%65%20%73%72%63%3d%27%68%74%74%70%73%3a%2f%2f%63%64%6e%37%37%2e%39%31%70%34%39%2e%63%6f%6d%2f%6d%33%75%38%2f%36%33%34%35%35%37%2f%36%33%34%35%35%37%2e%6d%33%75%38%27%20%74%79%70%65%3d%27%61%70%70%6c%69%63%61%74%69%6f%6e%2f%78%2d%6d%70%65%67%55%52%4c%27%3e";
        String decode = HtmlUtil.unescape(encode);
        Assertions.assertEquals(
                "<source src='https://cdn77.91p49.com/m3u8/634557/634557.m3u8' type='application/x-mpegURL'>",
                decode);
    }
}
