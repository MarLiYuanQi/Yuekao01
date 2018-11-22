package liyuanqi.bwie.com.yuekao01.prasenter;

import com.google.gson.Gson;

import java.util.List;

import liyuanqi.bwie.com.yuekao01.bean.JsonBeanPuBu;
import liyuanqi.bwie.com.yuekao01.jiekou.HttpInterface;
import liyuanqi.bwie.com.yuekao01.model.Okhttpurl;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class Presenterpubu {
    public Presenterpubu(PuBudata puBudata) {
        mPuBudata = puBudata;
    }
    public void listString(){
        String wz="http://www.xieast.com/api/news/news.php?type=top&page=1&tdsourcetag=s_pcqq_aiomsg";
        Okhttpurl.getmOkhttpurl().httpdata(wz, new HttpInterface<String>() {
            @Override
            public void datacg(String s) {
                JsonBeanPuBu jsonBeanPuBu = new Gson().fromJson(s, JsonBeanPuBu.class);
                mPuBudata.cg(jsonBeanPuBu.getData());
            }

            @Override
            public void datasb(Exception e) {
                mPuBudata.sb();
            }
        });
    }
    public interface PuBudata{
        void cg(List<JsonBeanPuBu.DataBean> list);
        void sb();
    }
    private PuBudata mPuBudata;
}
