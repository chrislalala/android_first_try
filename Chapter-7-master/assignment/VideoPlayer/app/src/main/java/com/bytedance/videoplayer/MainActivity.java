package com.bytedance.videoplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.VideoView;
import android.widget.MediaController;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       videoView = findViewById(R.id.V_video);
       videoView.setVideoPath(getVideoPath(R.raw.bytedance));

       MediaController mediaController=new MediaController(this); //视频的控制器
       videoView.setMediaController(mediaController);
       mediaController.setMediaPlayer(videoView);
       videoView.requestFocus();
       videoView.start();

    }

    private String getVideoPath(int resId) {
        return "android.resource://" + this.getPackageName() + "/" + resId;
    }
}
