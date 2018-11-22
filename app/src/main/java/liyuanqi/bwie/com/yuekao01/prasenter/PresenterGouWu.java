package liyuanqi.bwie.com.yuekao01.prasenter;

import com.google.gson.Gson;

import java.util.List;

import liyuanqi.bwie.com.yuekao01.bean.JsonBeanGouwu;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanLeft;
import liyuanqi.bwie.com.yuekao01.jiekou.HttpInterface;
import liyuanqi.bwie.com.yuekao01.model.Okhttpurl;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class PresenterGouWu {
    public PresenterGouWu(Leftdata puBudata) {
        mPuBudata = puBudata;
    }
    public void listString(){
        String wz="http://www.zhaoapi.cn/product/getCarts?uid=71&source=1.0.1";
        Okhttpurl.getmOkhttpurl().httpdata(wz, new HttpInterface<String>() {
            @Override
            public void datacg(String s) {
                JsonBeanGouwu jsonBeangouwu = new Gson().fromJson(s, JsonBeanGouwu.class);
                mPuBudata.cg(jsonBeangouwu.getData());
            }

            @Override
            public void datasb(Exception e) {
                mPuBudata.sb();
            }
        });
    }
    public interface Leftdata{
        void cg(List<JsonBeanGouwu.DataBean> list);
        void sb();
    }
    private Leftdata mPuBudata;
}
