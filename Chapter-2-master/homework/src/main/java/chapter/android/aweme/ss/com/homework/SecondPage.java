package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        Intent intent = getIntent();
        int num = intent.getIntExtra("num",0);
        TextView numview = findViewById(R.id.num_text);
        numview.setText("这是第"+num+"个界面.\n");

    }
}
