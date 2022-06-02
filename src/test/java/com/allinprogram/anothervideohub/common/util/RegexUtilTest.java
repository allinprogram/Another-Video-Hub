package com.allinprogram.anothervideohub.common.util;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * RegexUtilTest
 *
 * @author AllinProgram
 * @since 2022-04-27 23:09 星期三
 */
@Slf4j
class RegexUtilTest {

    @Test
    void testParseBase() {
        String content = "<source src='https://AllinProgram.com/video.m3u8' type='application/x-mpegURL'>";
        String re = "(https.*?com)";
        Assertions.assertEquals(RegexUtil.parse(content, re), "https://AllinProgram.com");
    }

    @Test
    void testParseVideoDetail() {
        String html = "<div class=\"well well-sm videos-text-align\">\n" +
                "    <a href=\"https://AllinProgram.com/viewkey=10241342342324&\">\n" +
                "        <div class=\"thumb-overlay\" id=\"playvthumb_633123\">\n" +
                "            <img class=\"img-responsive\" src=\"https://AllinProgram.com.com/thumb/633123.jpg\" />\n" +
                "            <div class=\"original-text-icon\">AllinProgram</div>\n" +
                "\n" +
                "            <span class=\"duration\">04:40</span>\n" +
                "        </div>\n" +
                "        <span class=\"video-title title-truncate m-t-5\">[原创]真让人受不了。</span>\n" +
                "    </a>\n" +
                "    <span class=\"info\">添加时间:</span> 43 小时 前 <br />\n" +
                "    <span class=\"info\">作者:</span>\n" +
                "    Looks19<br />\n" +
                "    <span class=\"info\">查看:</span> 97799&nbsp;\n" +
                "    <span class=\"info\">收藏:</span> 1405 <br> <span class=\"info\">留言:</span> 14&nbsp;\n" +
                "    <span class=\"info\">积分:</span> 2000&nbsp; &nbsp;\n" +
                "    <img src=images/like.png height=10>81&nbsp; <img src=images/dislike.png height=10>\n" +
                "    13\n" +
                "</div>";

        Document document = Jsoup.parse(html);
        Elements videos = document.getElementsByClass("videos-text-align");
        for (Element video : videos) {
            // direct utl
            System.out.println(video.select("a").first().attr("href"));

            // title
            System.out.println(video.getElementsByClass("video-title").text());
            // preview picture
            System.out.println(video.getElementsByClass("img-responsive").attr("src"));
            // duration
            System.out.println(video.getElementsByClass("duration").text());

            html = html.replace("\n", "");
            System.out.println(RegexUtil.parse(html, "viewkey=(\\d+)").replace(" ", ""));
            System.out.println(RegexUtil.parse(html, "添加时间:</span>(.*?)<br").replace(" ", ""));
            System.out.println(RegexUtil.parse(html, "作者:</span>(.*?)<br").replace(" ", ""));
            System.out.println(RegexUtil.parse(html, "查看:</span>(.*?)&nbsp;").replace(" ", ""));
            System.out.println(RegexUtil.parse(html, "收藏:</span>(.*?)<br").replace(" ", ""));
        }
    }
}
