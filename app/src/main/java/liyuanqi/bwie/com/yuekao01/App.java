package liyuanqi.bwie.com.yuekao01;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
    }
}
