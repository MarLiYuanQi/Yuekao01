package liyuanqi.bwie.com.yuekao01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import liyuanqi.bwie.com.yuekao01.adapter.Leftadapter;
import liyuanqi.bwie.com.yuekao01.adapter.Reighadapter;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanLeft;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanReigh;
import liyuanqi.bwie.com.yuekao01.prasenter.PresenterLeft;
import liyuanqi.bwie.com.yuekao01.prasenter.PresenterReigh;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class Framfenlei extends Fragment implements PresenterLeft.Leftdata, PresenterReigh.Reghdata {
    private RecyclerView left_rlv;
    PresenterLeft presenterLeft;
    Leftadapter leftadapter;
    PresenterReigh presenterReigh;
    Reighadapter reighadapter;
    RecyclerView reigh_rlv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fenlei, null);
        initView(view);
        presenterLeft.listString();
        leftadapter.getLeftdchick(new Leftadapter.Leftchick() {
            @Override
            public void leftdianji(int position) {
                presenterReigh.listString(position);
                Toast.makeText(getActivity(),position+"",Toast.LENGTH_SHORT).show();
            }
        });
        reighadapter.getLeftdchick(new Reighadapter.Reighchick() {
            @Override
            public void reighdianji() {
                Intent intent=new Intent(getActivity(),ShangPinActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initView(View view) {
        left_rlv = (RecyclerView) view.findViewById(R.id.left_rlv);
        reigh_rlv = (RecyclerView) view.findViewById(R.id.reigh_rlv);
        left_rlv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        reigh_rlv.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        presenterLeft = new PresenterLeft(this);
        leftadapter = new Leftadapter(getActivity());
        left_rlv.setAdapter(leftadapter);
       presenterReigh = new PresenterReigh(this);
         reighadapter = new Reighadapter(getActivity());
        reigh_rlv.setAdapter(reighadapter);

    }

    @Override
    public void cg(List<JsonBeanLeft.DataBean> list) {
        leftadapter.datalist(list);
    }

    @Override
    public void sb() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterLeft=null;
    }

    @Override
    public void reghcg(List<JsonBeanReigh.DataBean> list) {
        reighadapter.datalist(list);
    }

    @Override
    public void reghsb() {

    }
}
