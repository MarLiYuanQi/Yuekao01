package liyuanqi.bwie.com.yuekao01.prasenter;

import com.google.gson.Gson;

import java.util.List;

import liyuanqi.bwie.com.yuekao01.bean.JsonBeanLeft;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanPuBu;
import liyuanqi.bwie.com.yuekao01.jiekou.HttpInterface;
import liyuanqi.bwie.com.yuekao01.model.Okhttpurl;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class PresenterLeft {
    public PresenterLeft(Leftdata puBudata) {
        mPuBudata = puBudata;
    }
    public void listString(){
        String wz="http://www.zhaoapi.cn/product/getCatagory";
        Okhttpurl.getmOkhttpurl().httpdata(wz, new HttpInterface<String>() {
            @Override
            public void datacg(String s) {
                JsonBeanLeft jsonBeanleft = new Gson().fromJson(s, JsonBeanLeft.class);
                mPuBudata.cg(jsonBeanleft.getData());
            }

            @Override
            public void datasb(Exception e) {
                mPuBudata.sb();
            }
        });
    }
    public interface Leftdata{
        void cg(List<JsonBeanLeft.DataBean> list);
        void sb();
    }
    private Leftdata mPuBudata;
}
