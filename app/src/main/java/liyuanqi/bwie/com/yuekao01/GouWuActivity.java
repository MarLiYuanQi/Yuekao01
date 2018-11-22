package liyuanqi.bwie.com.yuekao01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.List;

import liyuanqi.bwie.com.yuekao01.adapter.GouWuadapter;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanGouwu;
import liyuanqi.bwie.com.yuekao01.prasenter.PresenterGouWu;

/**
 * date:2018/11/22
 * author:理元旗(ynkj)
 * function:
 */
public class GouWuActivity extends AppCompatActivity implements View.OnClickListener, PresenterGouWu.Leftdata {

    private ExpandableListView elsv;
    private CheckBox quanxuan;
    private TextView zongjia;
    private Button jiesuan;
    PresenterGouWu presenterGouWu;
    GouWuadapter gouWuadapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gouwu);
        initView();
        initdibu();
        presenterGouWu.listString();
        gouWuadapter.getGouwuchick(new GouWuadapter.Gouwuchick() {
            @Override
            public void shangjia(int groupPosition) {
                boolean b = gouWuadapter.shangpinquanbuxuanzhong(groupPosition);
                gouWuadapter.shangjiaxuanzhong(groupPosition,!b);
                gouWuadapter.notifyDataSetChanged();
                initdibu();
            }

            @Override
            public void shangpin(int groupPosition, int childPosition) {
                gouWuadapter.dangeshangpinxuanzhong(groupPosition,childPosition);
                gouWuadapter.notifyDataSetChanged();
                initdibu();
            }

            @Override
            public void jiajian(int groupPosition, int childPosition, int nums) {
                gouWuadapter.jiajiangengxin(groupPosition,childPosition,nums);
                gouWuadapter.notifyDataSetChanged();
                initdibu();
            }
        });
        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean quanbuxuanzhong = gouWuadapter.quanbuxuanzhong();
                gouWuadapter.quanxuandianji(!quanbuxuanzhong);
                gouWuadapter.notifyDataSetChanged();
                initdibu();
            }
        });
    }

    private void initdibu() {
        float zongjiaya = gouWuadapter.zongjiaya();
        zongjia.setText(zongjiaya+"");
        int zongshu = gouWuadapter.zongshu();
        jiesuan.setText("结算（"+zongshu+"）");
    }


    private void initView() {
        elsv = (ExpandableListView) findViewById(R.id.elsv);
        quanxuan = (CheckBox) findViewById(R.id.quanxuan);
        zongjia = (TextView) findViewById(R.id.zongjia);
        jiesuan = (Button) findViewById(R.id.jiesuan);
         presenterGouWu = new PresenterGouWu(this);
         gouWuadapter = new GouWuadapter(this);
         elsv.setAdapter(gouWuadapter);
        jiesuan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jiesuan:

                break;
        }
    }

    @Override
    public void cg(List<JsonBeanGouwu.DataBean> list) {
            gouWuadapter.datalist(list);
    }

    @Override
    public void sb() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterGouWu=null;
    }
}
