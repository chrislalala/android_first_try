package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import chapter.android.aweme.ss.com.homework.R;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    private TextView CountView;
    private LinearLayout Total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout);
        CountView = findViewById(R.id.textView);
        Total = findViewById(R.id.total);
        int count = getAllChildViewCount(Total);
        CountView.setText("页面总共有"+count+"个view.\n");
    }

    public int getAllChildViewCount(View view) {
        //todo 补全你的代码
        int viewCount = 0;
        if(null == view)
            return  0;
        if(view instanceof ViewGroup){
            for(int i = 0;i < ((ViewGroup) view).getChildCount();i++){
                View child = ((ViewGroup) view).getChildAt(i);
                if(child instanceof  ViewGroup){
                    viewCount += getAllChildViewCount(((ViewGroup)view).getChildAt(i));
                }
                else{
                    viewCount++;
                }
            }
        }
        else{
            viewCount ++;
        }
        return  viewCount;
    }
}
