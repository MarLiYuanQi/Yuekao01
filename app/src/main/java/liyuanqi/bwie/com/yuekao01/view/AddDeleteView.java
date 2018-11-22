package liyuanqi.bwie.com.yuekao01.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import liyuanqi.bwie.com.yuekao01.R;

/**
 * date:2018/11/22
 * author:理元旗(ynkj)
 * function:
 */
public class AddDeleteView extends LinearLayout implements View.OnClickListener {
    private TextView jian;
    private TextView numberx;
    private TextView jia;
    private int numberss=1;
    public AddDeleteView(Context context) {
        this(context, null);
    }

    public AddDeleteView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddDeleteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = inflate(context, R.layout.jiajian, this);
        jia = view.findViewById(R.id.jia);
        jian = view.findViewById(R.id.jian);
        numberx = view.findViewById(R.id.numberx);
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jia:
                if (numberss>=0){
                    numberss++;
                    numberx.setText(numberss+"");
                    mOnAddDelete.isnumberss(numberss);
                }
                break;
            case R.id.jian:
                if (numberss<=10000&&numberss>=1){
                    numberss--;
                    numberx.setText(numberss+"");
                    mOnAddDelete.isnumberss(numberss);
                }
                break;
        }
    }
    public int getNumberss(){
        return numberss;
    }
    public   void setNumberss(int num){
        this.numberss=num;
        numberx.setText(num+"");
    }
    public interface onAddDelete{
        void isnumberss(int nums);
    }
    private onAddDelete mOnAddDelete;
    public void getonAddDelete(onAddDelete onAddDelete){
        mOnAddDelete=onAddDelete;
    }
}
