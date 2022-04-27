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
public interface NineOneClient {

    String HEADER_ACCEPT_LANGUAGE = "Accept-Language: zh-CN,zh;";

    @Request(
            url = "{url}",
            headers = {
                    HEADER_ACCEPT_LANGUAGE
            }
    )
    @HTTPProxy(host = "{host}", port = "{port}")
    String get(@Var("host")String proxyHost, @Var("port")int port, @Var("url") String url);
}
