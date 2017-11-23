package com.example.android.sciencealert;

import android.support.v4.app.Fragment;


public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return MainFragment.newInstance("http://www.sciencealert.com");
    }

    @Override
    public void onBackPressed(){

        MainFragment fragment =(MainFragment) getSupportFragmentManager().
                findFragmentById(R.id.fragment_container);

        if(fragment.canGoBackvalue()){
            fragment.goBack();
        }else{
            super.onBackPressed();
        }



    }
}
