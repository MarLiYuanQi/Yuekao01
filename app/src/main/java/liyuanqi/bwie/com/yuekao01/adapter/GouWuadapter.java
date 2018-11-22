package liyuanqi.bwie.com.yuekao01.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import liyuanqi.bwie.com.yuekao01.R;
import liyuanqi.bwie.com.yuekao01.bean.JsonBeanGouwu;
import liyuanqi.bwie.com.yuekao01.view.AddDeleteView;

/**
 * date:2018/11/22
 * author:理元旗(ynkj)
 * function:
 */
public class GouWuadapter extends BaseExpandableListAdapter {
    private Context context;
    private List<JsonBeanGouwu.DataBean> mlist;

    public GouWuadapter(Context context) {
        this.context = context;
        mlist = new ArrayList<>();
    }

    public void datalist(List<JsonBeanGouwu.DataBean> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return mlist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mlist.get(groupPosition).getList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mlist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mlist.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;
        if (convertView == null) {
            holder = new GroupViewHolder();
            convertView = View.inflate(context, R.layout.groupshuju, null);
            holder.groupchick = convertView.findViewById(R.id.groupchick);
            holder.groupname = convertView.findViewById(R.id.groupname);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        holder.groupname.setText(mlist.get(groupPosition).getSellerName());
        boolean shangpinquanbuxuanzhong = shangpinquanbuxuanzhong(groupPosition);
        holder.groupchick.setChecked(shangpinquanbuxuanzhong);
        holder.groupchick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGouwuchick.shangjia(groupPosition);
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder;
        if (convertView == null) {
            holder = new ChildViewHolder();
            convertView = View.inflate(context, R.layout.childshuju, null);
            holder.child_chick = convertView.findViewById(R.id.child_chick);
            holder.imgtu = convertView.findViewById(R.id.imgtu);
            holder.titles = convertView.findViewById(R.id.titles);
            holder.prices = convertView.findViewById(R.id.prices);
            holder.zhuhe = convertView.findViewById(R.id.zhuhe);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder)  convertView.getTag();
        }
        JsonBeanGouwu.DataBean.ListBean listBean = mlist.get(groupPosition).getList().get(childPosition);
        holder.child_chick.setChecked(listBean.getSelected()==1);
        holder.titles.setText(listBean.getTitle());

        String[] split = listBean.getImages().split("!");
        ImageLoader.getInstance().displayImage(split[0],holder.imgtu);

        holder.prices.setText(listBean.getPrice()+"");
        holder.zhuhe.setNumberss(listBean.getNum());
        holder.child_chick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGouwuchick.shangpin(groupPosition,childPosition);
            }
        });
        holder.zhuhe.getonAddDelete(new AddDeleteView.onAddDelete() {
            @Override
            public void isnumberss(int nums) {
                mGouwuchick.jiajian(groupPosition,childPosition,nums);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public boolean shangpinquanbuxuanzhong(int groupPosition){
        List<JsonBeanGouwu.DataBean.ListBean> list = mlist.get(groupPosition).getList();
        for (int j=0;j<list.size();j++){
            if (list.get(j).getSelected()==0){
                return false;
            }
        }
        return true;
    }
    public void shangjiaxuanzhong(int groupPosition,boolean isselect){
        List<JsonBeanGouwu.DataBean.ListBean> list = mlist.get(groupPosition).getList();
        for (int j=0;j<list.size();j++){
           list.get(j).setSelected(isselect?1:0);


        }

    }
    public void dangeshangpinxuanzhong(int groupPosition, int childPosition){
        JsonBeanGouwu.DataBean.ListBean listBean = mlist.get(groupPosition).getList().get(childPosition);
        listBean.setSelected(listBean.getSelected()==0?1:0);
    }
    public boolean quanbuxuanzhong(){

        for (int j=0;j<mlist.size();j++){
            List<JsonBeanGouwu.DataBean.ListBean> list = mlist.get(j).getList();
            for (int x=0;x<list.size();x++){
                if (list.get(x).getSelected()==0){
                    return false;
                }
            }
        }
        return true;
    }
    public int zongshu(){
        int  numberd=0;
        for (int j=0;j<mlist.size();j++){
            List<JsonBeanGouwu.DataBean.ListBean> list = mlist.get(j).getList();
            for (int x=0;x<list.size();x++){
                if (list.get(x).getSelected()==1){
                    numberd+=list.get(x).getNum();
                }

            }
        }
        return numberd;
    }
    public float zongjiaya(){
        float  zjia=0;
        for (int j=0;j<mlist.size();j++){
            List<JsonBeanGouwu.DataBean.ListBean> list = mlist.get(j).getList();
            for (int x=0;x<list.size();x++){
                if (list.get(x).getSelected()==1){
                    zjia+=list.get(x).getNum()*list.get(x).getPrice();
                }

            }
        }
        return zjia;
    }
    public void quanxuandianji(boolean isselect){

        for (int j=0;j<mlist.size();j++){
            List<JsonBeanGouwu.DataBean.ListBean> list = mlist.get(j).getList();
            for (int x=0;x<list.size();x++){
                list.get(x).setSelected(isselect?1:0);
            }
        }

    }
    public void jiajiangengxin(int groupPosition, int childPosition,int nums){
        JsonBeanGouwu.DataBean.ListBean listBean = mlist.get(groupPosition).getList().get(childPosition);
        listBean.setNum(nums);
    }


    class GroupViewHolder {
        CheckBox groupchick;
        TextView groupname;
    }

    public  class ChildViewHolder {

        public CheckBox child_chick;
        public ImageView imgtu;
        public TextView titles;
        public TextView prices;
        public AddDeleteView zhuhe;



    }
    public interface Gouwuchick{
        void shangjia(int groupPosition);
        void shangpin(int groupPosition, int childPosition);
        void jiajian(int groupPosition, int childPosition,int nums);
    }
    private Gouwuchick mGouwuchick;
    public void getGouwuchick(Gouwuchick gouwuchick){
        mGouwuchick=gouwuchick;
    }
}
