package liyuanqi.bwie.com.yuekao01.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import liyuanqi.bwie.com.yuekao01.R;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanLeft;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanPuBu;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class Leftadapter extends RecyclerView.Adapter<Leftadapter.MyViewHolder>{
    private Context context;
    private List<JsonBeanLeft.DataBean> mList;

    public Leftadapter(Context context) {
        this.context = context;
        mList=new ArrayList<>();
    }
    public void datalist(List<JsonBeanLeft.DataBean> list) {
        this.mList=list;
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.leftshuju, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.texts.setText(mList.get(position).getName());
        holder.texts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeftchick.leftdianji(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView texts;
        public MyViewHolder(View itemView) {
            super(itemView);
             texts = itemView.findViewById(R.id.left_text);
        }
    }
    public interface Leftchick{
        void leftdianji(int position);
    }
    private  Leftchick mLeftchick;
    public void getLeftdchick(Leftchick leftchick){
        mLeftchick=leftchick;
    }
}
