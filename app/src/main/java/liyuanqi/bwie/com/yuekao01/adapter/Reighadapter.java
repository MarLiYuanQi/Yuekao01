package liyuanqi.bwie.com.yuekao01.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import liyuanqi.bwie.com.yuekao01.R;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanPuBu;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanReigh;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class Reighadapter extends RecyclerView.Adapter<Reighadapter.MyViewHolder>{
    private Context context;
    private List<JsonBeanReigh.DataBean> mList;

    public Reighadapter(Context context) {
        this.context = context;
        mList=new ArrayList<>();
    }
    public void datalist(List<JsonBeanReigh.DataBean> list) {
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
        ImageLoader.getInstance().displayImage(mList.get(position).getList().get(position).getIcon(),holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mReighchick.reighdianji();
            }
        });
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
    public interface Reighchick{
        void reighdianji();
    }
    private Reighchick mReighchick;
    public void getLeftdchick(Reighchick reighchick){
        mReighchick=reighchick;
    }
}
