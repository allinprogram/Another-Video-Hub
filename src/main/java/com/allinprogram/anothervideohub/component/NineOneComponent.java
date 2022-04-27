package com.allinprogram.anothervideohub.component;

import com.allinprogram.anothervideohub.common.util.HtmlUtil;
import com.allinprogram.anothervideohub.common.util.RegexUtil;
import com.allinprogram.anothervideohub.infrastructure.http.NineOneClient;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${http.proxy.host}")
    private String proxyHost;

    @Value("${http.proxy.port}")
    private int proxyPort;

    @Value("${nineOne.re.indexVideoUrlList}")
    private String indexVideoUrlListRe;

    @Value("${nineOne.re.directUrlEscape}")
    private String directUrlEscapeRe;

    @Autowired
    private NineOneClient nineOneClient;

    public List<String> findVideoDetailUrlList() {
        String html = nineOneClient.get(proxyHost, proxyPort, nineOneUrlHot);

        Document document = Jsoup.parse(html);
        Elements videos = document.select(indexVideoUrlListRe);

        return videos.stream()
                .map(video -> video.attr("href"))
                .collect(Collectors.toList());
    }

    public String findVideoDirectUrl(String videoDetailUrl) {
        String html = nineOneClient.get(proxyHost, proxyPort, videoDetailUrl);
        String directUrlEscape = RegexUtil.parse(html, directUrlEscapeRe);
        return HtmlUtil.unescape(directUrlEscape);
    }
}
