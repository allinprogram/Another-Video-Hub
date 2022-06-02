package com.allinprogram.anothervideohub.model;

import com.allinprogram.anothervideohub.common.util.RegexUtil;
import lombok.Getter;
import lombok.Setter;
import org.jsoup.nodes.Element;

/**
 * Video
 *
 * @author AllinProgram
 * @since 2022-04-29 20:36 星期五
 */
@Getter
@Setter
public class Video {

    private String viewKey;

    private String previewPicture;

    private String videoName;

    private String authorName;

    private String duration;

    private Integer viewAmount;

    private Integer collectAmount;

    private String publishTime;

    public static Video buildVideoFromHtml(Element element) {
        Video video = new Video();
        video.setVideoName(element.getElementsByClass("video-title").text());
        video.setPreviewPicture(element.getElementsByClass("img-responsive").attr("src"));
        video.setDuration(element.getElementsByClass("duration").text());

        String videoHtml = element.html().replace("\n", "");
        video.setViewKey(RegexUtil.parse(videoHtml, "viewkey=(.*?)&").replace(" ", ""));
        video.setPublishTime(RegexUtil.parse(videoHtml, "添加时间:</span>(.*?)<br").replace(" ", ""));
        video.setAuthorName(RegexUtil.parse(videoHtml, "作者:</span>(.*?)<br").replace(" ", ""));
        video.setCollectAmount(RegexUtil.parse(videoHtml, "收藏:</span>(.*?)<br").replace(" ", ""));
        video.setViewAmount(RegexUtil.parse(videoHtml, "查看:</span>(.*?)&nbsp;").replace(" ", ""));

        return video;
    }

    public void setCollectAmount(String collectAmount) {
        this.collectAmount = Integer.parseInt(collectAmount);
    }

    public void setViewAmount(String viewAmount) {
        this.viewAmount = Integer.parseInt(viewAmount);
    }
}
