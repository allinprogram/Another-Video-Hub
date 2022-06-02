package com.allinprogram.anothervideohub.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NineOneRouteComponent {

    @Value("${nineOne.url.theLatest}")
    private String theLatest;

    @Value("${nineOne.url.todayRank}")
    private String todayRank;

    @Value("${nineOne.url.nowHot}")
    private String nowHot;

    @Value("${nineOne.url.thisMonthHot}")
    private String thisMonthHot;

    @Value("${nineOne.url.lastMonthHot}")
    private String lastMonthHot;

    @Value("${nineOne.url.thisMonthCollect}")
    private String thisMonthCollect;

    @Value("${nineOne.url.allTimeCollect}")
    private String allTimeCollect;

    @Value("${nineOne.url.recentRefined}")
    private String recentRefined;

    public String route(String classify) {
        if (StringUtils.isBlank(classify)) {
            return theLatest;
        }
        switch (classify) {
            case "theLatest":
                return theLatest;
            case "todayRank":
                return todayRank;
            case "nowHot":
                return nowHot;
            case "lastMonthHot":
                return lastMonthHot;
            case "thisMonthHot":
                return thisMonthHot;
            case "thisMonthCollect":
                return thisMonthCollect;
            case "allTimeCollect":
                return allTimeCollect;
            case "recentRefined":
                return recentRefined;
            default:
                return theLatest;
        }
    }
}
