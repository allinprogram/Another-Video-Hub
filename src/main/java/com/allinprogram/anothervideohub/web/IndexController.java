package com.allinprogram.anothervideohub.web;

import com.allinprogram.anothervideohub.component.NineOneComponent;
import com.allinprogram.anothervideohub.model.Video;
import com.allinprogram.anothervideohub.web.model.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * IndexController
 *
 * @author AllinProgram
 * @since 2022-04-29 20:06 星期五
 */
@Controller
public class IndexController {

    String staticHtml = "[{\"authorName\":\"Mrtow\",\"collectAmount\":2659,\"duration\":\"05:29\",\"previewPicture\":\"https://i.91p30.com/thumb/634091.jpg\",\"publishTime\":\"25小时前\",\"videoName\":\"[原创] 接她下班 直接在她公司楼道干她\",\"viewAmount\":131004},{\"authorName\":\"sm980629\",\"collectAmount\":2727,\"duration\":\"07:06\",\"previewPicture\":\"https://i.91p30.com/thumb/633350.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"疯狂输出大二舞蹈生\",\"viewAmount\":131674},{\"authorName\":\"91探花泽泽\",\"collectAmount\":2271,\"duration\":\"42:28\",\"previewPicture\":\"https://i.91p30.com/thumb/633415.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"我滴妈也，极品反差小姐姐！这要是谁的女朋友，一辈子不愁性福\",\"viewAmount\":143970},{\"authorName\":\"小巨\",\"collectAmount\":1857,\"duration\":\"10:14\",\"previewPicture\":\"https://i.91p30.com/thumb/633598.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"[原创] 酸奶+鞭子调教F奶豹纹女郎，我又秒射了！开头认证\",\"viewAmount\":167458},{\"authorName\":\"wh106461\",\"collectAmount\":1852,\"duration\":\"05:10\",\"previewPicture\":\"https://i.91p30.com/thumb/633637.jpg\",\"publishTime\":\"45小时前\",\"videoName\":\"骚货喝酒后性瘾发作，舔硬了自己坐上来，骚叫连连，往期更精彩\",\"viewAmount\":144417},{\"authorName\":\"rourou0\",\"collectAmount\":1296,\"duration\":\"13:43\",\"previewPicture\":\"https://i.91p30.com/thumb/633621.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"[原创] 厉害啊，这谁能忍得住！完整版分享，请多多支持\",\"viewAmount\":156088},{\"authorName\":\"wh106461\",\"collectAmount\":1558,\"duration\":\"04:13\",\"previewPicture\":\"https://i.91p30.com/thumb/633784.jpg\",\"publishTime\":\"37小时前\",\"videoName\":\"[原创] 首次微露脸，女上位自己动，被打巴掌兴奋到高潮，往期更精彩\",\"viewAmount\":95757},{\"authorName\":\"美少女杀手\",\"collectAmount\":1551,\"duration\":\"06:15\",\"previewPicture\":\"https://i.91p30.com/thumb/633602.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"[原创] 露脸JKE奶反差已更新点我主页观看\",\"viewAmount\":94278},{\"authorName\":\"yshrfjf\",\"collectAmount\":1508,\"duration\":\"06:09\",\"previewPicture\":\"https://i.91p30.com/thumb/633604.jpg\",\"publishTime\":\"46小时前\",\"videoName\":\"极品大奶女友在家被操的满嘴骚话\",\"viewAmount\":83359},{\"authorName\":\"wer248077126\",\"collectAmount\":955,\"duration\":\"35:37\",\"previewPicture\":\"https://i.91p30.com/thumb/633531.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"[原创] （已更新）真实异性SPA在矜持的女人被男技师按着都会被操\",\"viewAmount\":141960},{\"authorName\":\"布隆的爱\",\"collectAmount\":1303,\"duration\":\"56:02\",\"previewPicture\":\"https://i.91p30.com/thumb/633641.jpg\",\"publishTime\":\"39小时前\",\"videoName\":\"真实良家开房偷情，女人的性欲也很烈阿\",\"viewAmount\":85084},{\"authorName\":\"jeremychang\",\"collectAmount\":1267,\"duration\":\"02:05\",\"previewPicture\":\"https://i.91p30.com/thumb/633530.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"女生高潮的样子\",\"viewAmount\":93475},{\"authorName\":\"零度雪碧冰红茶\",\"collectAmount\":1596,\"duration\":\"01:01\",\"previewPicture\":\"https://i.91p30.com/thumb/633438.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"科尔沁艺术学院当老师的外围嫩模被命令不许叫\",\"viewAmount\":55557},{\"authorName\":\"91探花小满\",\"collectAmount\":1053,\"duration\":\"13:47\",\"previewPicture\":\"https://i.91p30.com/thumb/633332.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"露脸极品女同事被操的嗷嗷叫！背着她男人偷情\",\"viewAmount\":87552},{\"authorName\":\"91探花泽泽\",\"collectAmount\":1042,\"duration\":\"40:47\",\"previewPicture\":\"https://i.91p30.com/thumb/633456.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"非常有气质的短发小姐姐，操起来得劲儿！\",\"viewAmount\":85469},{\"authorName\":\"eric_1111\",\"collectAmount\":1069,\"duration\":\"00:53\",\"previewPicture\":\"https://i.91p30.com/thumb/633704.jpg\",\"publishTime\":\"39小时前\",\"videoName\":\"楼道内口交，纯欲天花板\",\"viewAmount\":49242},{\"authorName\":\"狮子座Walker\",\"collectAmount\":801,\"duration\":\"03:18\",\"previewPicture\":\"https://i.91p30.com/thumb/633490.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"[原创] 91独发，“主页已更新”肛交，把屁眼操烂，电话一直在响，太兴奋\",\"viewAmount\":79126},{\"authorName\":\"你的白月光\",\"collectAmount\":888,\"duration\":\"07:01\",\"previewPicture\":\"https://i.91p30.com/thumb/633519.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"[原创] 大鸡巴爆操女蜘蛛侠后续（有口的画面 必撸精品）\",\"viewAmount\":73330},{\"authorName\":\"Chinaawesom\",\"collectAmount\":740,\"duration\":\"10:37\",\"previewPicture\":\"https://i.91p30.com/thumb/633526.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"[原创] 邻居少妇没锁门，忍不住偷摸操醒！太刺激了！片尾原创认证\",\"viewAmount\":93486},{\"authorName\":\"huyang369\",\"collectAmount\":816,\"duration\":\"11:10\",\"previewPicture\":\"https://i.91p30.com/thumb/633635.jpg\",\"publishTime\":\"46小时前\",\"videoName\":\"[原创] 这也操的太猛了，我都不想交换了\",\"viewAmount\":73084},{\"authorName\":\"91探花泽泽\",\"collectAmount\":730,\"duration\":\"51:12\",\"previewPicture\":\"https://i.91p30.com/thumb/633449.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"不懂怜香惜玉，只懂发泄兽欲，约炮就是这样\",\"viewAmount\":76201},{\"authorName\":\"Timepasserby\",\"collectAmount\":834,\"duration\":\"14:33\",\"previewPicture\":\"https://i.91p30.com/thumb/633495.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"[原创] 很性感的丝袜美腿妹子被操烂了\",\"viewAmount\":48340},{\"authorName\":\"91探花花总\",\"collectAmount\":670,\"duration\":\"36:01\",\"previewPicture\":\"https://i.91p30.com/thumb/633326.jpg\",\"publishTime\":\"2天前\",\"videoName\":\"约良家极品深夜清纯美腿女神，抬腿侧入娇喘喊不要\",\"viewAmount\":66634},{\"authorName\":\"91探花泽泽\",\"collectAmount\":572,\"duration\":\"34:43\",\"previewPicture\":\"https://i.91p30.com/thumb/633923.jpg\",\"publishTime\":\"30小时前\",\"videoName\":\"这种长相就是欠操的主\",\"viewAmount\":63348}]";
    @Autowired
    private NineOneComponent nineOneComponent;

    @GetMapping({""})
    public String getVideoList(@RequestParam(value = "c", required = false) String classify, @RequestParam(required = false) Integer pageIndex, Model model) {
        // TODO FOT TEST
//        List<Video> videoList = JSON.parseArray(staticHtml, Video.class);
        List<Video> videoList = nineOneComponent.findVideoDetailList(classify, pageIndex);

        model.addAttribute("currentPageInfo", PageInfo.buildPageInfo(classify, pageIndex));
        model.addAttribute("videoList", videoList);

        return "index";
    }

    @GetMapping("play")
    public String getVideoDetail(@RequestParam String viewKey, Model model) {
        String videoDirectUrl = nineOneComponent.findVideoDirectUrl(viewKey);

        model.addAttribute("currentPageInfo", PageInfo.buildPageInfo("play", null));
        model.addAttribute("videoDirectUrl", videoDirectUrl);

        return "play";
    }
}
