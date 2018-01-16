package com.ktcd.malc.kt_ma_lc.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.applicatoin.KtkjMaLcApplication;
import com.ktcd.malc.kt_ma_lc.bean.LoginBean;
//import com.ktcd.malc.kt_ma_lc.client.ServiceManager;
import com.ktcd.malc.kt_ma_lc.bean.LoginCookei;
import com.ktcd.malc.kt_ma_lc.client.ServiceManager;
import com.ktcd.malc.kt_ma_lc.dialog.MyAlertDialog;
//import com.ktcd.malc.kt_ma_lc.xmppim.MyImManager;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.PathUrl;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
import com.ktcd.malc.utilslibrary.tools.FileUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/6/26.
 */

public class LoginActivity extends ToolbarActivity {
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_delete)
    ImageView loginDelete;
    @BindView(R.id.tv_ipsetting)
    TextView tvipsetting;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_sub)
    Button loginSub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setToolbarColor(ContextCompat.getColor(this, R.color.assist_5));
        setTitle("账号登陆");
        setTitleColorRes(R.color.black);
        setTitleTextSize(18);
        setNavigationIcon(null);
//        addText("忘记密码", ContextCompat.getColor(this, R.color.blue), 14, new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ToastUtils.showMessage(mContext, "跳转页面");
//            }
//        });
    }

    @OnClick({R.id.login_delete, R.id.tv_ipsetting, R.id.login_sub})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_delete:
                loginUsername.setText(null);
                break;
            case R.id.tv_ipsetting:
                final MyAlertDialog alertDialog = new MyAlertDialog.Builder(this)
                        .setContentView(R.layout.dialog_ipconfig)
                        .fullWidth().show();
                //操作特有的对象 getview()  ListView等
                final EditText etDataIP = alertDialog.getView(R.id.et_data_ip);
                final EditText etDataPort = alertDialog.getView(R.id.et_data_port1);
                final EditText etPicPort = alertDialog.getView(R.id.et_pic_port1);
                String[] data = ConfigUtils.getAppDataIP(mContext).split(",");
                etDataIP.setText(data[0]);
                etDataPort.setText(data[1]);
                etPicPort.setText(data[2]);
                //dialog去操作点击事件
                alertDialog.setOnClickListener(R.id.bt_ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!TextUtils.isEmpty(etDataIP.getText().toString().trim())) {
                            if (!TextUtils.isEmpty(etDataPort.getText().toString().trim()) && etDataPort.getText().toString().trim().length() > 1) {
                                if (!TextUtils.isEmpty(etPicPort.getText().toString().trim()) && etPicPort.getText().toString().trim().length() > 1) {
                                    ConfigUtils.setAppDataIP(mContext, etDataIP.getText().toString().trim()+","+etDataPort.getText().toString().trim()+","+etPicPort.getText().toString().trim());
                                    alertDialog.dismiss();
                                } else {
                                    ToastUtils.showMessage(mContext, "图片端口格式不对");
                                }
                            } else {
                                ToastUtils.showMessage(mContext, "端口格式不对");
                            }
                        } else {
                            ToastUtils.showMessage(mContext, "IP不能为空");
                        }
                    }
                });
                break;
            case R.id.login_sub:
                String name = loginUsername.getText().toString().trim();
                String password = loginPassword.getText().toString().trim();
//                if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(password)) {
//                    Map<String, String> map = new HashMap<>();
//                    map.put("cpLoginName", name);
//                    map.put("cpLoginPwd", password);
//                    final ProgressDialog pDialog = ProgressDialog
//                            .show(this, "请稍等", "正在加载数据...");
//                    MyRetrofit.StartQueryNet(mContext, false, ApiPathUrl.ACTION_LOGIN, map, new ResponseCallBack<LoginBean.DataBean>() {
//                        @Override
//                        protected void onLoad(Disposable d) {
//                            pDialog.show();
//                        }
//
//                        @Override
//                        protected void onError(KtkjError error) {
//                            ToastUtils.showMessage(mContext, error.msg);
//                            pDialog.dismiss();
//                        }
//
//                        @Override
//                        protected void onSuccess(LoginBean.DataBean result) {
////                            MyImManager.register(mContext,result.getCpLoginName(), result.getCpName(), result.getCpLoginPwd());
//                            pDialog.dismiss();
//                            if (result != null) {
//                                setNavigationIcon(R.mipmap.home_return);
//                                Bundle bundle = new Bundle();
//                                ConfigUtils.setUserID(mContext, result.getCpId());
//                                ConfigUtils.setUserLogin(mContext, true);
//                                //启动推送
//                            ServiceManager serviceManager = new ServiceManager(KtkjMaLcApplication.getInstance());
//                            serviceManager.setNotificationIcon(R.mipmap.ic_launcher);
//                            serviceManager.startService();
////                                if (!ConfigUtils.getIsRegisted(mContext)) {
////                                    MyImManager.register(mContext, result.getCpLoginName(), result.getCpLoginPwd(), result.getCpName());
////                                }
//                                FileUtils.saveObject(mContext, "LoginBean.DataBean", result);
//                                bundle.putSerializable("data", result);
//                                startActivity(HomeTabActivity.class, bundle);
//                                finish();
//                            }
//                        }
//                    });
//                }else{
//                    ToastUtils.showMessage(mContext, "用户名和密码不能为空");
//                }
                textLog();
                break;
                default:
                    break;
        }
    }

    @Override
    public void onBackPressed() {
        KtkjMaLcApplication.getInstance().exitApp();
    }


    private void textLog(){

        Map<String,String> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
//        MyRetrofit.StartQueryNetByAllPath(mContext,true, "http://192.168.0.200:5555/uaa/login", map, new ResponseCallBack<LoginCookei>() {
        MyRetrofit.StartQueryNetByAllPath(mContext,true, "http://lgrjian.gicp.net:12787/uaa/login", map, new ResponseCallBack<LoginCookei>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {
                startActivity(HomeTabActivity.class, new Bundle());
                finish();
            }

            @Override
            protected void onSuccess(LoginCookei result) {
                startActivity(HomeTabActivity.class, new Bundle());
                finish();
            }
        });

    }




}
