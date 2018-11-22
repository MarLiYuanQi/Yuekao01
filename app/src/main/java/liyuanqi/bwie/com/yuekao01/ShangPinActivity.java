package liyuanqi.bwie.com.yuekao01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import liyuanqi.bwie.com.yuekao01.adapter.ShangPinadapter;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanShangPin;
import liyuanqi.bwie.com.yuekao01.prasenter.PresenterShangPin;

/**
 * date:2018/11/22
 * author:理元旗(ynkj)
 * function:
 */
public class ShangPinActivity extends AppCompatActivity implements PresenterShangPin.Leftdata {
    private RecyclerView shangpin_rlv;
    ShangPinadapter shangPinadapter;
    PresenterShangPin presenterShangPin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shangpin);
        initView();

        presenterShangPin.listString();
        shangPinadapter.getLeftdchick(new ShangPinadapter.Shangpinchick() {
            @Override
            public void leftdianji() {
                Intent intent=new Intent(ShangPinActivity.this,GouWuActivity.class);
                startActivity(intent);
                Toast.makeText(ShangPinActivity.this,"点击成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        shangpin_rlv = (RecyclerView) findViewById(R.id.shangpin_rlv);
        shangpin_rlv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        shangPinadapter = new ShangPinadapter(this);
        presenterShangPin = new PresenterShangPin(this);
        shangpin_rlv.setAdapter(shangPinadapter);

    }

    @Override
    public void cg(List<JsonBeanShangPin.DataBean> list) {
        shangPinadapter.datalist(list);
    }

    @Override
    public void sb() {

    }
}
