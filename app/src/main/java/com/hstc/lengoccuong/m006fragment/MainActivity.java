package com.hstc.lengoccuong.m006fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FirstFragment mFirstFragment;
    private SecondFragment mSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initFragment();

        //showFirstFragment();

        showFirstFragment2();
    }

    private void showFirstFragment() {
        getSupportFragmentManager().beginTransaction().show(mFirstFragment).hide(mSecondFragment).commit();
    }
    private void showSecondFragment() {
        getSupportFragmentManager().beginTransaction().show(mSecondFragment).hide(mFirstFragment)
                .addToBackStack(null).commit();
    }

    private void initFragment() {

        mFirstFragment = new FirstFragment();
        mFirstFragment.setListener(new FirstFragment.OnClickButtonListener() {
            @Override
            public void clickButton() {
                showSecondFragment();
            }
        });
        mSecondFragment = new SecondFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.ln_main,mFirstFragment,FirstFragment.class.getName())
                .add(R.id.ln_main,mSecondFragment,SecondFragment.class.getName())
                .commit();
    }


    private void showFirstFragment2(){
        if(mFirstFragment==null){
            mFirstFragment = new FirstFragment();
            mFirstFragment.setListener(new FirstFragment.OnClickButtonListener() {
                @Override
                public void clickButton() {
                    showSecondFragment2();
                }
            });

        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ln_main,mFirstFragment,FirstFragment.class.getName())
                .commit();
    }
    private void showSecondFragment2(){
        if(mSecondFragment==null){
            mSecondFragment = new SecondFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.anim_left_in,R.anim.anim_left_out,R.anim.anim_right_in,R.anim.anim_right_out)
                .replace(R.id.ln_main,mSecondFragment,SecondFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }
}
