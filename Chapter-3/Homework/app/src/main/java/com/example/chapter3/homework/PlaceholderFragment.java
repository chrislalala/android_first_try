package com.example.chapter3.homework;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {
    ListView listView;
    LottieAnimationView animationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        listView = (ListView) view.findViewById(R.id.list_numbers);
        listView.setAdapter(new ListBaseAdapter());
        listView.setDivider(null);
        listView.setAlpha(0f);//列表先看不到
        listView.setVisibility(View.VISIBLE);//先看不见

        animationView = view.findViewById(R.id.animation_view);
        animationView.playAnimation();
        animationView.setAlpha(1f);
        animationView.setVisibility(View.VISIBLE);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {

                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                listView.animate()
                        .alpha(1f);
                animationView.animate()
                             .alpha(0f);

            }
        }, 5000);
    }
}
