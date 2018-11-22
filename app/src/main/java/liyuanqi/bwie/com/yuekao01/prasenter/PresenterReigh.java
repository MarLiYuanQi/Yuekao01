package liyuanqi.bwie.com.yuekao01.prasenter;

import com.google.gson.Gson;

import java.util.List;

import liyuanqi.bwie.com.yuekao01.bean.JsonBeanLeft;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanReigh;
import liyuanqi.bwie.com.yuekao01.jiekou.HttpInterface;
import liyuanqi.bwie.com.yuekao01.model.Okhttpurl;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class PresenterReigh {
    public PresenterReigh(Reghdata puBudata) {
        mPuBudata = puBudata;
    }
    public void listString(int cid){
        String wz="http://www.zhaoapi.cn/product/getProductCatagory?cid="+cid;
        Okhttpurl.getmOkhttpurl().httpdata(wz, new HttpInterface<String>() {
            @Override
            public void datacg(String s) {
                JsonBeanReigh jsonBeanreigh = new Gson().fromJson(s, JsonBeanReigh.class);
                mPuBudata.reghcg(jsonBeanreigh.getData());
            }

            @Override
            public void datasb(Exception e) {
                mPuBudata.reghsb();
            }
        });
    }
    public interface Reghdata{
        void reghcg(List<JsonBeanReigh.DataBean> list);
        void reghsb();
    }
    private Reghdata mPuBudata;
}
