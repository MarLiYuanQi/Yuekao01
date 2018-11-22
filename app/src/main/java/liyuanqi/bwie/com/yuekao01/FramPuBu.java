package liyuanqi.bwie.com.yuekao01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import liyuanqi.bwie.com.yuekao01.adapter.PuBuadapter;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanPuBu;
import liyuanqi.bwie.com.yuekao01.prasenter.Presenterpubu;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class FramPuBu extends Fragment implements Presenterpubu.PuBudata {
    private RecyclerView rlv;
    Presenterpubu presenterpubu;
    PuBuadapter puBuadapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.pubu, null);
        initView(view);
        presenterpubu.listString();
        return view;
    }

    private void initView(View view) {
        rlv = (RecyclerView) view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        presenterpubu = new Presenterpubu(this);
         puBuadapter = new PuBuadapter(getActivity());
         rlv.setAdapter(puBuadapter);
    }

    @Override
    public void cg(List<JsonBeanPuBu.DataBean> list) {
        puBuadapter.datalist(list);
    }

    @Override
    public void sb() {
        Toast.makeText(getActivity(),"数据请求失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        puBuadapter=null;
    }
}
