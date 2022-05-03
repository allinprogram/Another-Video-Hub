package com.allinprogram.anothervideohub.component;

import com.allinprogram.anothervideohub.common.util.HtmlUtil;
import com.allinprogram.anothervideohub.common.util.RegexUtil;
import com.allinprogram.anothervideohub.infrastructure.http.NineOneClient;
import com.allinprogram.anothervideohub.model.Video;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * NineOneComponent
 *
 * @author AllinProgram
 * @since 2022-04-27 16:27 星期三
 */
@Slf4j
@Component
public class NineOneComponent {

    @Value("${nineOne.url.hot}")
    private String nineOneUrlHot;
    @Value("${nineOne.url.detail}")
    private String nineOneUrlDetail;

    @Value("${http.proxy.host}")
    private String proxyHost;
    @Value("${http.proxy.port}")
    private int proxyPort;

    @Value("${nineOne.re.indexVideoUrlList}")
    private String indexVideoUrlListRe;
    @Value("${nineOne.re.directUrlEscape}")
    private String directUrlEscapeRe;
    @Value("${nineOne.re.m3u8Url}")
    private String m3u8UrlRe;

    @Autowired
    private NineOneClient nineOneClient;

    @Cacheable("videos")
    public List<Video> findVideoDetailList() {
        String html = nineOneClient.get(proxyHost, proxyPort, nineOneUrlHot);

        Document document = Jsoup.parse(html);
        Elements videoHtmlList = document.getElementsByClass(indexVideoUrlListRe);

        return videoHtmlList.stream()
                .map(Video::buildVideoFromHtml)
                .collect(Collectors.toList());
    }

    @Cacheable("video")
    public String findVideoDirectUrl(String viewKey) {
        String videoDetailUrl = nineOneUrlDetail + viewKey;
        String html = nineOneClient.get(proxyHost, proxyPort, videoDetailUrl);
        String directUrlEscape = RegexUtil.parse(html, directUrlEscapeRe);
        String m3u8Url = HtmlUtil.unescape(directUrlEscape);
        return RegexUtil.parse(m3u8Url, m3u8UrlRe);
    }
}
