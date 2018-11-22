package liyuanqi.bwie.com.yuekao01.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

import liyuanqi.bwie.com.yuekao01.R;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanPuBu;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class PuBuadapter extends RecyclerView.Adapter<PuBuadapter.MyViewHolder>{
    private Context context;
    private List<JsonBeanPuBu.DataBean> mList;

    public PuBuadapter(Context context) {
        this.context = context;
        mList=new ArrayList<>();
    }
    public void datalist(List<JsonBeanPuBu.DataBean> list) {
        this.mList=list;
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.pubushuju, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(mList.get(position).getThumbnail_pic_s(),holder.img);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
             img = itemView.findViewById(R.id.img);
        }
    }
}
