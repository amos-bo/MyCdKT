package com.ktcd.malc.kt_ma_lc.DateManager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ktcd.malc.kt_ma_lc.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Administrator on 2017/11/9.
 */

public class SmallRiverDateUtils {

     public  interface  DeletListener{
         void deletOk();
     }
  public static View setSmallRiverDate(final Context context, AllPointDataBean datePoint, final DeletListener deletListener){
      LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
      View Root=inflater.inflate(R.layout.freglaout_dgpoint, null, false);
      ((TextView)Root.findViewById(R.id.tv_work_name)).setText(""+datePoint.getResponsibleName());
      ((TextView)Root.findViewById(R.id.tv_work_phone)).setText(""+datePoint.getResponsibleMobilePhone());
      ((TextView)Root.findViewById(R.id.tv_link_name)).setText(""+datePoint.getContactName());
      ((TextView)Root.findViewById(R.id.tv_link_phone)).setText(""+datePoint.getContactTelephone());
      ((TextView)Root.findViewById(R.id.tv_reiver_nummber)).setText(""+datePoint.getCode());
      ((TextView)Root.findViewById(R.id.tv_reiver_loc)).setText(""+datePoint.getRiverSourcePosition());
      ((TextView)Root.findViewById(R.id.tv_reiver_length)).setText(""+datePoint.getLength());
      ((TextView)Root.findViewById(R.id.tv_reiver_source)).setText(""+datePoint.getCrossBorder());
      ((TextView)Root.findViewById(R.id.tv_reiver_gps)).setText(""+datePoint.getRiverSourceLatitude()+","+datePoint.getRiverSourceLongitude());
      ((TextView)Root.findViewById(R.id.tv_reiver_dateloc)).setText(""+datePoint.getDataSource());
      ((TextView)Root.findViewById(R.id.tv_reiver_dep)).setText(""+datePoint.getDepartmentCode());
      ((ImageButton)Root.findViewById(R.id.imgbt_delete)).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              deletListener.deletOk();
          }
      });
      return Root;
  }
    public static View setSmallRiverDateWebView(final Context context,String UrlPath,AllPointDataBean datePoint, final DeletListener deletListener){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View Root=inflater.inflate(R.layout.freglaout_dgpointwebview, null, false);
        final WebView mWebView=(WebView)Root.findViewById(R.id.webview);
        //解决点击链接跳转浏览器问题
        mWebView.setWebViewClient(new WebViewClient());
        //js支持
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        //允许访问assets目录
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(true);
        //设置WebView排版算法, 实现单列显示, 不允许横向移动
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        //添加数据
        JsSupport jsSupport = new JsSupport(context);
        Gson gson = new Gson();
        WebViewAllPointDataBean mDate=new WebViewAllPointDataBean();
        mDate.Type=datePoint.getSubclass();
        mDate.data=datePoint;
        String json = gson.toJson(mDate);
        Log.e("xb", "addJson: json => " + json);
        jsSupport.setJson(json);
        //END
        //添加js交互接口, 并指明js中对象的调用名称
        mWebView.addJavascriptInterface(jsSupport, "weichat");
        mWebView.loadUrl(UrlPath);
//        mWebView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mWebView.loadUrl("javascript:myFunction()");
//            }
//        },5000);
        ((ImageButton)Root.findViewById(R.id.imgbt_delete)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletListener.deletOk();
            }
        });
        return Root;
    }

    public static View setMoreDateWebView(final Context context,String UrlPath,AllDataToWeb alldatatoweb, final DeletListener deletListener){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View Root=inflater.inflate(R.layout.freglaout_dgpointwebviewmore, null, false);
        final WebView mWebView=(WebView)Root.findViewById(R.id.webview);
        //解决点击链接跳转浏览器问题
        mWebView.setWebViewClient(new WebViewClient());
        //js支持
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        //允许访问assets目录
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(true);
        //设置WebView排版算法, 实现单列显示, 不允许横向移动
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        //添加数据
        JsSupport jsSupport = new JsSupport(context);
        Gson gson = new Gson();
        String json = gson.toJson(alldatatoweb);
        jsSupport.setJson(json);
        //END
        //添加js交互接口, 并指明js中对象的调用名称
        mWebView.addJavascriptInterface(jsSupport, "weichat");
        mWebView.loadUrl(UrlPath);
        ((ImageButton)Root.findViewById(R.id.imgbt_delete)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletListener.deletOk();
            }
        });
        return Root;
    }
}
