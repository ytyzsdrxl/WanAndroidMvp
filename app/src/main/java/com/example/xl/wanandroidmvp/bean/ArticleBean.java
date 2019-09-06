package com.example.xl.wanandroidmvp.bean;

import java.util.List;

public class ArticleBean {


    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"谷歌开发者 ","chapterId":471,"chapterName":"10.0（Q）","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":8835,"link":"https://www.jianshu.com/p/6b0ac3bd1641","niceDate":"14小时前","origin":"","prefix":"","projectLink":"","publishTime":1565011202000,"superChapterId":453,"superChapterName":"版本适配","tags":[],"title":"Android Q 文本新功能","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>如果说泛型在编译器会被擦除；<\/p>\r\n<p>那么我们在还能做类似的写法：<\/p>\r\n<pre><code>HttpUtils.doGet(url,new CallBack&lt;List&lt;User&gt; users){\r\n    void onSuccess(List&lt;User&gt; users);\r\n}\r\n<\/code><\/pre><p>我们声明的<code>List&lt;User&gt;<\/code>可以在运行时，正确的获取到该泛型类型，并利用Gson等正确的转为实际的对象。<\/p>\r\n<p>这是为什么呢？<\/p>","envelopePic":"","fresh":false,"id":8821,"link":"https://www.wanandroid.com/wenda/show/8821","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564919080000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 大家应该都有泛型在编译期会被擦除的概念，那么为什么我们在运行时还能读取到呢？ 3/3","type":0,"userId":2,"visible":1,"zan":4},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8831,"link":"https://www.jianshu.com/p/133adedd8860","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918942000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（五），EngineJob与DecodeJob代码详细加载过程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8830,"link":"https://www.jianshu.com/p/0bfd1295d158","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918926000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（四），DecodeJob执行过程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8829,"link":"https://www.jianshu.com/p/586a8abdc627","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918911000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（三），Engine加载资源过程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8828,"link":"https://www.jianshu.com/p/3b3f6ec91984","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918893000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（二），基本加载类图介绍","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8827,"link":"https://www.jianshu.com/p/5c1572469ad1","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918873000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（一），基本加载代码流程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"jarrod-chen","chapterId":252,"chapterName":"奇怪的Bug","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8826,"link":"https://jarrod-chen.github.io/2019/07/31/ViewPager%E5%8A%A8%E6%80%81%E6%9B%B4%E6%94%B9Fragment/","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1564837818000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"从源码解析ViewPager动态更改Fragment的实现","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"cc1over","chapterId":230,"chapterName":"打包","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8825,"link":"https://cc1over.github.io/2019/07/31/%E5%A4%9A%E6%B8%A0%E9%81%93%E6%89%93%E5%8C%85%E6%96%B9%E6%A1%88%E8%B0%83%E7%A0%94%E6%80%9D%E8%80%83/","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1564836567000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"多渠道打包方案调研思考","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"MannaYang","chapterId":97,"chapterName":"音视频","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8824,"link":"https://juejin.im/post/5d42d4946fb9a06ae439d46b","niceDate":"2019-08-02","origin":"","prefix":"","projectLink":"","publishTime":1564713410000,"superChapterId":97,"superChapterName":"多媒体技术","tags":[],"title":"Android 基于MediaCodec+MediaMuxer实现音视频录制合成","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" coder-pig","chapterId":74,"chapterName":"反编译","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8823,"link":"https://juejin.im/post/5d42f440e51d4561e53538b6","niceDate":"2019-08-02","origin":"","prefix":"","projectLink":"","publishTime":1564712761000,"superChapterId":74,"superChapterName":"热门专题","tags":[],"title":"忘了他吧！我偷别人APP的代码养你","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"西瓜技术团队","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8822,"link":"https://mp.weixin.qq.com/s/ZHisCVjO_ZrtvvEWBYUQFQ","niceDate":"2019-08-01","origin":"","prefix":"","projectLink":"","publishTime":1564667263000,"superChapterId":74,"superChapterName":"热门专题","tags":[],"title":"西瓜视频apk瘦身之 Java access 方法删除","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>很多时候我们开发项目的时候，都需要抓包，很多情况下即使是Https也能正常抓包正常。<\/p>\r\n<p>那么问题来了：<\/p>\r\n<ol>\r\n<li>抓包的原理是？<\/li>\r\n<li>任何Https的 <strong>app<\/strong> 都能抓的到吗？<\/li>\r\n<li>如果不能，哪些情况下可以抓取，哪些情况下抓取不到？<\/li>\r\n<\/ol>","envelopePic":"","fresh":false,"id":8812,"link":"https://www.wanandroid.com/wenda/show/8812","niceDate":"2019-08-01","origin":"","prefix":"","projectLink":"","publishTime":1564667071000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 app https 抓包，一定能抓到吗？","type":0,"userId":2,"visible":1,"zan":7},{"apkLink":"","author":"张小fanfan","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8820,"link":"https://juejin.im/post/5d3eb7325188255d7a07582b","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564588657000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android 换肤那些事儿， Resource包装流 ？AssetManager替换流？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 杨充","chapterId":121,"chapterName":"ViewPager","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8819,"link":"https://juejin.im/post/5d401cabf265da03a53a12fe","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564588596000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"PagerAdapter深度解析和实践优化","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8818,"link":"https://mp.weixin.qq.com/s/2TTXt5virr2vMNZRlzIT3w","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564588566000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"如何开发一款高性能的 gradle transform","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"全世界_Coder","chapterId":481,"chapterName":"DNS","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8817,"link":"https://juejin.im/post/5d40eae66fb9a06b2442f898","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564588391000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"网络优化篇-从DNS开始","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Rouse","chapterId":480,"chapterName":"Paging","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8816,"link":"https://juejin.im/post/5d40cbb3f265da03c4286b19","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564586027000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"Paging在RecyclerView中的应用，有这一篇就够了","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"齐翊","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8815,"link":"https://juejin.im/post/5d3fdc3af265da03c02bdbde","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564581142000,"superChapterId":99,"superChapterName":"自定义控件","tags":[],"title":"Android侧滑原来可以这么优雅","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Aleyn.","chapterId":251,"chapterName":"OpenCV","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8814,"link":"https://blog.csdn.net/qq_36875339/article/details/97127908","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564576645000,"superChapterId":74,"superChapterName":"热门专题","tags":[],"title":"移动端车牌识别OCR,结合OpenCV","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":343,"size":20,"total":6849}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":"谷歌开发者 ","chapterId":471,"chapterName":"10.0（Q）","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":8835,"link":"https://www.jianshu.com/p/6b0ac3bd1641","niceDate":"14小时前","origin":"","prefix":"","projectLink":"","publishTime":1565011202000,"superChapterId":453,"superChapterName":"版本适配","tags":[],"title":"Android Q 文本新功能","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>如果说泛型在编译器会被擦除；<\/p>\r\n<p>那么我们在还能做类似的写法：<\/p>\r\n<pre><code>HttpUtils.doGet(url,new CallBack&lt;List&lt;User&gt; users){\r\n    void onSuccess(List&lt;User&gt; users);\r\n}\r\n<\/code><\/pre><p>我们声明的<code>List&lt;User&gt;<\/code>可以在运行时，正确的获取到该泛型类型，并利用Gson等正确的转为实际的对象。<\/p>\r\n<p>这是为什么呢？<\/p>","envelopePic":"","fresh":false,"id":8821,"link":"https://www.wanandroid.com/wenda/show/8821","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564919080000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 大家应该都有泛型在编译期会被擦除的概念，那么为什么我们在运行时还能读取到呢？ 3/3","type":0,"userId":2,"visible":1,"zan":4},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8831,"link":"https://www.jianshu.com/p/133adedd8860","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918942000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（五），EngineJob与DecodeJob代码详细加载过程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8830,"link":"https://www.jianshu.com/p/0bfd1295d158","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918926000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（四），DecodeJob执行过程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8829,"link":"https://www.jianshu.com/p/586a8abdc627","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918911000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（三），Engine加载资源过程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8828,"link":"https://www.jianshu.com/p/3b3f6ec91984","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918893000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（二），基本加载类图介绍","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CarlosLuo","chapterId":468,"chapterName":"Glide","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8827,"link":"https://www.jianshu.com/p/5c1572469ad1","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1564918873000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Glide源码分析（一），基本加载代码流程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"jarrod-chen","chapterId":252,"chapterName":"奇怪的Bug","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8826,"link":"https://jarrod-chen.github.io/2019/07/31/ViewPager%E5%8A%A8%E6%80%81%E6%9B%B4%E6%94%B9Fragment/","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1564837818000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"从源码解析ViewPager动态更改Fragment的实现","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"cc1over","chapterId":230,"chapterName":"打包","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8825,"link":"https://cc1over.github.io/2019/07/31/%E5%A4%9A%E6%B8%A0%E9%81%93%E6%89%93%E5%8C%85%E6%96%B9%E6%A1%88%E8%B0%83%E7%A0%94%E6%80%9D%E8%80%83/","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1564836567000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"多渠道打包方案调研思考","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"MannaYang","chapterId":97,"chapterName":"音视频","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8824,"link":"https://juejin.im/post/5d42d4946fb9a06ae439d46b","niceDate":"2019-08-02","origin":"","prefix":"","projectLink":"","publishTime":1564713410000,"superChapterId":97,"superChapterName":"多媒体技术","tags":[],"title":"Android 基于MediaCodec+MediaMuxer实现音视频录制合成","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" coder-pig","chapterId":74,"chapterName":"反编译","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8823,"link":"https://juejin.im/post/5d42f440e51d4561e53538b6","niceDate":"2019-08-02","origin":"","prefix":"","projectLink":"","publishTime":1564712761000,"superChapterId":74,"superChapterName":"热门专题","tags":[],"title":"忘了他吧！我偷别人APP的代码养你","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"西瓜技术团队","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8822,"link":"https://mp.weixin.qq.com/s/ZHisCVjO_ZrtvvEWBYUQFQ","niceDate":"2019-08-01","origin":"","prefix":"","projectLink":"","publishTime":1564667263000,"superChapterId":74,"superChapterName":"热门专题","tags":[],"title":"西瓜视频apk瘦身之 Java access 方法删除","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>很多时候我们开发项目的时候，都需要抓包，很多情况下即使是Https也能正常抓包正常。<\/p>\r\n<p>那么问题来了：<\/p>\r\n<ol>\r\n<li>抓包的原理是？<\/li>\r\n<li>任何Https的 <strong>app<\/strong> 都能抓的到吗？<\/li>\r\n<li>如果不能，哪些情况下可以抓取，哪些情况下抓取不到？<\/li>\r\n<\/ol>","envelopePic":"","fresh":false,"id":8812,"link":"https://www.wanandroid.com/wenda/show/8812","niceDate":"2019-08-01","origin":"","prefix":"","projectLink":"","publishTime":1564667071000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 app https 抓包，一定能抓到吗？","type":0,"userId":2,"visible":1,"zan":7},{"apkLink":"","author":"张小fanfan","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8820,"link":"https://juejin.im/post/5d3eb7325188255d7a07582b","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564588657000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android 换肤那些事儿， Resource包装流 ？AssetManager替换流？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 杨充","chapterId":121,"chapterName":"ViewPager","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8819,"link":"https://juejin.im/post/5d401cabf265da03a53a12fe","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564588596000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"PagerAdapter深度解析和实践优化","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8818,"link":"https://mp.weixin.qq.com/s/2TTXt5virr2vMNZRlzIT3w","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564588566000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"如何开发一款高性能的 gradle transform","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"全世界_Coder","chapterId":481,"chapterName":"DNS","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8817,"link":"https://juejin.im/post/5d40eae66fb9a06b2442f898","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564588391000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"网络优化篇-从DNS开始","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Rouse","chapterId":480,"chapterName":"Paging","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8816,"link":"https://juejin.im/post/5d40cbb3f265da03c4286b19","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564586027000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"Paging在RecyclerView中的应用，有这一篇就够了","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"齐翊","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8815,"link":"https://juejin.im/post/5d3fdc3af265da03c02bdbde","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564581142000,"superChapterId":99,"superChapterName":"自定义控件","tags":[],"title":"Android侧滑原来可以这么优雅","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Aleyn.","chapterId":251,"chapterName":"OpenCV","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8814,"link":"https://blog.csdn.net/qq_36875339/article/details/97127908","niceDate":"2019-07-31","origin":"","prefix":"","projectLink":"","publishTime":1564576645000,"superChapterId":74,"superChapterName":"热门专题","tags":[],"title":"移动端车牌识别OCR,结合OpenCV","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 343
         * size : 20
         * total : 6849
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * author : 谷歌开发者
             * chapterId : 471
             * chapterName : 10.0（Q）
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : true
             * id : 8835
             * link : https://www.jianshu.com/p/6b0ac3bd1641
             * niceDate : 14小时前
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1565011202000
             * superChapterId : 453
             * superChapterName : 版本适配
             * tags : []
             * title : Android Q 文本新功能
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
