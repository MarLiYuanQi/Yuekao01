package liyuanqi.bwie.com.yuekao01;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MediaType;

public class MainActivity extends AppCompatActivity {

    private TextView bwei;
    private ProgressBar pressbar;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (pressbar.getProgress()<100){
                int pres=pressbar.getProgress();
                pressbar.setProgress(pres+10);
            }else {
                Toast.makeText(MainActivity.this,"进度结束",Toast.LENGTH_SHORT).show();
            }
            handler.sendEmptyMessageDelayed(0,1000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bwei = (TextView) findViewById(R.id.bwei);
        pressbar = (ProgressBar) findViewById(R.id.pressbar);
        pressbar.incrementProgressBy(1);
        pressbar.setIndeterminate(true);
        pressbar.setMax(100);
       // handler.sendEmptyMessageDelayed(0,1000);
        AnimatorSet animatorSet=new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(bwei, "scaleX", new float[]{1f, 3f});
        scaleX.setDuration(2000);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(bwei, "alpha", new float[]{1.0f, 0.8f});
        alpha.setDuration(2000);
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(bwei, "rotationX", new float[]{0f, 360f});
        rotationX.setDuration(2000);
        animatorSet.playTogether(scaleX,alpha,rotationX);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent=new Intent(MainActivity.this,DataActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
