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
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanShangPin;

/**
 * date:2018/11/21
 * author:理元旗(ynkj)
 * function:
 */
public class ShangPinadapter extends RecyclerView.Adapter<ShangPinadapter.MyViewHolder>{
    private Context context;
    private List<JsonBeanShangPin.DataBean> mList;

    public ShangPinadapter(Context context) {
        this.context = context;
        mList=new ArrayList<>();
    }
    public void datalist(List<JsonBeanShangPin.DataBean> list) {
        this.mList=list;
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.shangpinshuju, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.texts.setText(mList.get(position).getSubhead());
        String[] split = mList.get(position).getImages().split("!");
        ImageLoader.getInstance().displayImage(split[0],holder.imgs);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView texts;
        ImageView imgs;
        public MyViewHolder(View itemView) {
            super(itemView);
             texts = itemView.findViewById(R.id.shangpin_text);
            imgs = itemView.findViewById(R.id.shangpin_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mShangpinchick.leftdianji();
                }
            });
        }
    }
    public interface Shangpinchick{
        void leftdianji();
    }
    private  Shangpinchick mShangpinchick;
    public void getLeftdchick(Shangpinchick shangpinchick){
        mShangpinchick=shangpinchick;
    }
}
