package com.hstc.lengoccuong.m006fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private View rootView;
    private Button btnShowSecondFrg;
    private OnClickButtonListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_first,container,false);
        initView();
        return rootView;
    }

    public void setListener(OnClickButtonListener listener) {
        this.listener = listener;
    }

    private void initView() {
        btnShowSecondFrg = rootView.findViewById(R.id.show_second);
        btnShowSecondFrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.clickButton();
            }
        });
    }

    public interface OnClickButtonListener{
        void clickButton();
    }
}
