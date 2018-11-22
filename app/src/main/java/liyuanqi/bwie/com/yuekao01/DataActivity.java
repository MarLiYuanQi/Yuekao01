package liyuanqi.bwie.com.yuekao01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class DataActivity extends AppCompatActivity {
    private FrameLayout frams;
    private RadioButton shouye;
    private RadioButton wode;
    private RadioGroup groups;
    FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tow);
        initView();
        //创建事务
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frams,new FramPuBu());
        fragmentTransaction.commit();
        groups.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.shouye:
                        FragmentTransaction fragmentTransaction1 = supportFragmentManager.beginTransaction();
                        fragmentTransaction1.replace(R.id.frams,new FramPuBu());
                        fragmentTransaction1.commit();
                        break;
                    case R.id.fenlei:
                        FragmentTransaction fragmentTransaction2 = supportFragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.frams,new Framfenlei());
                        fragmentTransaction2.commit();
                        break;
                }
            }
        });

    }



    //初始化控件
    private void initView() {
        frams = (FrameLayout) findViewById(R.id.frams);
        shouye = (RadioButton) findViewById(R.id.shouye);
        wode = (RadioButton) findViewById(R.id.fenlei);
        groups = (RadioGroup) findViewById(R.id.groups);

    }

}
