package com.allinprogram.anothervideohub.infrastructure.http;

import com.dtflys.forest.annotation.HTTPProxy;
import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.annotation.Var;

/**
 * HttpClient
 *
 * @author AllinProgram
 * @since 2022-04-26 19:28 星期二
 */
public interface HttpClient {

    String HEADER_ACCEPT_LANGUAGE = "Accept-Language: zh-CN,zh;";

    @Request(
            url = "",
            headers = {
                    HEADER_ACCEPT_LANGUAGE
            })
    @HTTPProxy(host = "", port = "")
    String scanHotVideos();

    @Request(
            url = "{url}",
            headers = {
                    HEADER_ACCEPT_LANGUAGE
            }
    )
    @HTTPProxy(host = "", port = "")
    String getVideoDetail(@Var("url") String url);
}
