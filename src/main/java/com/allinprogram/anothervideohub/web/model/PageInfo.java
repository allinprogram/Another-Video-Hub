package com.allinprogram.anothervideohub.web.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * PageInfo
 *
 * @author AllinProgram
 * @since 2022-05-05 09:53:09
 */
@Getter
@Setter
public class PageInfo {

    private final static Map<String/*currentPageLink*/, PageInfo> PAGE_INFO_MAP = new HashMap<>() {{
        put("theLatest", new PageInfo("/?c=theLatest&", "最新视频", true));
        put("nowHot", new PageInfo("/?c=nowHot&", "当前最热", true));
        put("todayRank", new PageInfo("/?c=todayRank&", "今日排行", false));
        put("recentRefined", new PageInfo("/?c=recentRefined&", "最近加精", true));
        put("thisMonthHot", new PageInfo("/?c=thisMonthHot&", "本月最热", true));
        put("lastMonthHot", new PageInfo("/?c=lastMonthHot&", "上月最热", true));
        put("thisMonthCollect", new PageInfo("/?c=thisMonthCollect&", "本月收藏", true));
        put("allTimeCollect", new PageInfo("/?c=allTimeCollect&", "收藏最多", true));
        put("play", new PageInfo("/play", "当前播放", false));
        put(null, new PageInfo("/", "Home", false));
    }};
    private String pageLink;
    private String pageTitle;
    private Integer pageIndex;
    private Boolean pageTurn;

    private PageInfo(String pageLink, String pageTitle, Boolean pageTurn) {
        this.pageLink = pageLink;
        this.pageTitle = pageTitle;
        this.pageTurn = pageTurn;
    }

    public static PageInfo buildPageInfo(String classify, Integer currentPageIndex) {
        PageInfo rst = PAGE_INFO_MAP.get(classify);
        rst.setPageIndex((currentPageIndex != null && currentPageIndex > 0) ? currentPageIndex : 1);
        return rst;
    }
}
