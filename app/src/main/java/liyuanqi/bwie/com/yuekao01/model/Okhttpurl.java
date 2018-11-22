package liyuanqi.bwie.com.yuekao01.model;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.Map;

import liyuanqi.bwie.com.yuekao01.LoggingInterceptor;
import liyuanqi.bwie.com.yuekao01.jiekou.HttpInterface;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttpurl {
    private static volatile Okhttpurl mOkhttpurl;
    static OkHttpClient okHttpClient;
    private static Handler mHandler;

    private Okhttpurl() {
        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        okHttpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
         mHandler= new Handler(Looper.getMainLooper());
    }
    public static Okhttpurl getmOkhttpurl(){
        if (mOkhttpurl==null){
            synchronized (Okhttpurl.class){
                if (mOkhttpurl==null){
                    mOkhttpurl=new Okhttpurl();
                }
            }
        }
        return mOkhttpurl;
    }
    public static void httpdata(String wang, final HttpInterface<String> httpInterface){
        Request request = new Request.Builder().url(wang).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpInterface.datasb(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String stringx = response.body().string();
                mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            httpInterface.datacg(stringx);
                        }
                    });
            }
        });
    }
    public void doPost(String url, Map<String,String> map, final HttpInterface<String> httpInterface){
        //创建FormBody对象,把表单添加到FormBody
        FormBody.Builder builder = new FormBody.Builder();
        //集合对象不为null的情况下
        if (map != null){
            for(String key: map.keySet()){
                builder.add(key,map.get(key));
            }
        }

        FormBody formBody = builder.build();

        //创建Request对象
        Request request = new Request.Builder()
                .post(formBody)
                .url(url)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                    //切换到主线程
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            httpInterface.datasb(e);
                        }
                    });
                }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response !=null && response.isSuccessful()){
                    final String json = response.body().string();

                        //切换到主线程
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                httpInterface.datacg(json);
                            }
                        });
                    }
                }

        });

    }
}
