package com.example.android.sciencealert;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by shrung_bhatt on 23/11/17.
 */
public class MainFragment extends Fragment {

    private static final String ARG_URL = "science_alert_url";

    private String mUrl;
    private WebView mWebView;

    public static MainFragment newInstance(String url){
        Bundle args = new Bundle();
        args.putString(ARG_URL,url);

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);

        mUrl = getArguments().getString(ARG_URL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_main,container,false);

        mWebView = v.findViewById(R.id.webView_container);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                return false;
            }
        });
        mWebView.loadUrl(mUrl);

        return v;
    }

    public boolean canGoBackvalue(){
        return mWebView.canGoBack();
    }

    public void goBack(){
        mWebView.goBack();
    }





}