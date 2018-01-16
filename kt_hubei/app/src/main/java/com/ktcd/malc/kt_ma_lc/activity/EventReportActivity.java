package com.ktcd.malc.kt_ma_lc.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.adapter.FileTypeAdapter;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.bean.LoginBean;
import com.ktcd.malc.kt_ma_lc.dialog.MyAlertDialog;
import com.ktcd.malc.kt_ma_lc.model.ItemAddressInfo;
import com.ktcd.malc.kt_ma_lc.model.ItemEventInfoResponse;
import com.ktcd.malc.kt_ma_lc.model.ItemFileTypeInfo;
import com.ktcd.malc.kt_ma_lc.responseparam.EventUpRespose;
import com.ktcd.malc.kt_ma_lc.videolib.SmallVideoRecordingActivity;
import com.ktcd.malc.kt_ma_lc.view.bottomnavigationbar.utils.AudioRecoderUtils;
import com.ktcd.malc.kt_ma_lc.view.bottomnavigationbar.utils.TimeUtils;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
import com.ktcd.malc.utilslibrary.tools.FileUtils;
import com.ktcd.malc.utilslibrary.tools.LogUtils;
import com.ktcd.malc.utilslibrary.tools.StringUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

import static com.ktcd.malc.kt_ma_lc.videolib.SmallVideoRecordingActivity.VIDEOINFO;
import static it.sephiroth.android.library.imagezoom.ImageViewTouchBase.LOG_TAG;

public class EventReportActivity extends ToolbarActivity {

    @BindView(R.id.tv_loc)
    TextView tvLoc;
    @BindView(R.id.lin_selector_img)
    LinearLayout linSelectorImg;
    @BindView(R.id.lin_selector_voice)
    LinearLayout linSelectorVoice;
    @BindView(R.id.lin_selector_video)
    LinearLayout linSelectorVideo;
    @BindView(R.id.lin_select_files)
    LinearLayout linSelectFiles;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private FileTypeAdapter mFileTypeAdapter;
    //所有文件
    private List<ItemFileTypeInfo> mItemFileTypeInfoList;
    //图片文件
    private ArrayList<ItemFileTypeInfo> mItemFilePicInfoList;


    private MediaRecorder mMediaRecorder;

    private MyAlertDialog alertDialog;
    private AudioRecoderUtils mAudioRecoderUtils;
    private ImageView mImageView;
    private TextView mTextView;

    private String mRecorderPath;
    private ItemAddressInfo mItemAddressInfo;

    private ItemEventInfoResponse.RowsBean mRowBean;

    public static void StartEventReportActivity(Context context, ItemEventInfoResponse.RowsBean rowsBean, ItemAddressInfo itemaddressinfo) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA_ADRESS", itemaddressinfo);
        bundle.putSerializable("DATA_INFO", rowsBean);
        Intent intent = new Intent(context, EventReportActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_report);
        ButterKnife.bind(this);
        initView();
        initData();
        //TODO 知乎控件bug修复
        File destDir = new File(Environment.getExternalStorageDirectory()+"/Pictures");
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
    }

    private void initView() {
        setTitle("事件上报");

        alertDialog = new MyAlertDialog.Builder(this).setContentView(R.layout.dialog_voice).fullWidth().create();
        mImageView = alertDialog.getView(R.id.iv_recording_icon);
        mTextView = alertDialog.getView(R.id.tv_recording_time);

        mAudioRecoderUtils = new AudioRecoderUtils();
        //录音回调
        mAudioRecoderUtils.setOnAudioStatusUpdateListener(new AudioRecoderUtils.OnAudioStatusUpdateListener() {
            //录音中....db为声音分贝，time为录音时长
            @Override
            public void onUpdate(double db, long time) {
                mImageView.getDrawable().setLevel((int) (3000 + 6000 * db / 100));
                mTextView.setText(TimeUtils.long2String(time));
            }

            //录音结束，filePath为保存路径
            @Override
            public void onStop(String filePath) {
                mTextView.setText(TimeUtils.long2String(0));
                mRecorderPath = filePath;
                ItemFileTypeInfo itemFileTypeInfo = new ItemFileTypeInfo();
                itemFileTypeInfo.Type = 3;
                itemFileTypeInfo.pathUrl = mRecorderPath;
                mItemFileTypeInfoList.add(itemFileTypeInfo);
                mFileTypeAdapter.notifyDataSetChanged();
            }
        });

        linSelectorVoice.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
//                        mRecorderPath = startVoice();
                        alertDialog.show();

                        mAudioRecoderUtils.startRecord();
                        break;
                    case MotionEvent.ACTION_UP:
//                        stopVoice();
//                        ItemFileTypeInfo itemFileTypeInfo = new ItemFileTypeInfo();
//                        itemFileTypeInfo.Type = 3;
//                        itemFileTypeInfo.pathUrl = mRecorderPath;
//                        mItemFileTypeInfoList.add(itemFileTypeInfo);
//                        mFileTypeAdapter.notifyDataSetChanged();

                        mAudioRecoderUtils.stopRecord();        //结束录音（保存录音文件）
//                        mAudioRecoderUtils.cancelRecord();    //取消录音（不保存录音文件）
                        alertDialog.dismiss();
                        break;
                }
                return true;
            }
        });
        recyclerview.setLayoutManager(new GridLayoutManager(mContext, 3));
        mFileTypeAdapter = new FileTypeAdapter(mContext);
        mFileTypeAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (mItemFileTypeInfoList.get(position).Type == 2) {
                    Intent intents = new Intent(Intent.ACTION_VIEW);
                    intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intents.setDataAndType(Uri.parse(mItemFileTypeInfoList.get(position).lowPath), "video/*");
                    startActivity(intents);
                } else if (mItemFileTypeInfoList.get(position).Type == 1) {
                    if (mItemFilePicInfoList.size() < 1) {
                        for (ItemFileTypeInfo item : mItemFileTypeInfoList) {
                            if (item.Type == 1) {
                                mItemFilePicInfoList.add(item);
                            }
                        }
                    }
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    ImageCheckListActivity.StartImagesCheckActivity(mContext, mItemFilePicInfoList, mItemFilePicInfoList.indexOf(mItemFileTypeInfoList.get(position)), rect);
                } else {
                    try {
                        MediaPlayer mPlayer = new MediaPlayer();
                        mPlayer.reset();
                        mPlayer.setDataSource(mItemFileTypeInfoList.get(position).pathUrl);
                        mPlayer.prepare();
                        mPlayer.start();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "播放失败");
                    }
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mFileTypeAdapter.setFileDeleteListener(new FileTypeAdapter.FileDeleteListener() {
            @Override
            public void isDeleted(View view, int postion) {
                mItemFileTypeInfoList.remove(postion);
                mFileTypeAdapter.notifyDataSetChanged();
            }
        });
        addText("上报", ContextCompat.getColor(mContext, R.color.blue), 18, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateToNet();
            }
        });
    }

    private void initData() {
        mRowBean = (ItemEventInfoResponse.RowsBean) getIntent().getExtras().getSerializable("DATA_INFO");
        mItemAddressInfo = (ItemAddressInfo) getIntent().getExtras().getSerializable("DATA_ADRESS");
        mItemFileTypeInfoList = new ArrayList<>();
        mItemFilePicInfoList = new ArrayList<>();
        mFileTypeAdapter.setList(mItemFileTypeInfoList);
        recyclerview.setAdapter(mFileTypeAdapter);
        if (!StringUtils.isEmpty(mItemAddressInfo.Address)) {
            tvLoc.setText("" + mItemAddressInfo.Address);
        }else{
            tvLoc.setText("获取详细地址失败");
        }
    }


    @OnClick({R.id.lin_selector_img, R.id.lin_selector_voice, R.id.lin_selector_video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_selector_img:
                Matisse.from(EventReportActivity.this)
                        .choose(MimeType.ofAll())
                        .theme(R.style.Matisse_Dracula)
                        .countable(true)
                        .maxSelectable(9)
                        .capture(true)
                        .captureStrategy(new CaptureStrategy(true, "com.ktcd.malc.kt_ma_lc.fileprovider"))
                        .imageEngine(new GlideEngine())
                        .forResult(23);
                break;
//            case R.id.lin_selector_voice:
//                mRecorderPath=startVoice();
//                break;
            case R.id.lin_selector_video:
                startActivityForResult(SmallVideoRecordingActivity.class, 24);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
            switch (requestCode) {
                case 23:
                    for (String uri : Matisse.obtainPathResult(data)) {
                        ItemFileTypeInfo itemFileTypeInfo = new ItemFileTypeInfo();
                        itemFileTypeInfo.Type = 1;
                        itemFileTypeInfo.pathUrl = uri;
                        File file=new File(uri);
                        Log.e("xb","大小："+file.length());
                        mItemFileTypeInfoList.add(itemFileTypeInfo);
                    }
                    mFileTypeAdapter.notifyDataSetChanged();
                    break;
                case 24:
                    ItemFileTypeInfo itemFileTypeInfo = new ItemFileTypeInfo();
                    itemFileTypeInfo.Type = 2;
                    itemFileTypeInfo.lowPath = ((ItemFileTypeInfo) data.getExtras().getSerializable(VIDEOINFO)).pathUrl;
                    if (!StringUtils.isEmpty(itemFileTypeInfo.lowPath)) {
                        MediaMetadataRetriever media = new MediaMetadataRetriever();
                        media.setDataSource(itemFileTypeInfo.lowPath);
                        Bitmap bitmap = media.getFrameAtTime();
                        itemFileTypeInfo.pathUrl = FileUtils.savaBitmap("Zowee", SystemClock.currentThreadTimeMillis() + ".jpg", bitmap);
                    }
                    LogUtils.e("xb", "路径: " + itemFileTypeInfo.pathUrl);
                    mItemFileTypeInfoList.add(itemFileTypeInfo);
                    mFileTypeAdapter.notifyDataSetChanged();
            }
    }


    private String startVoice() {
        // 设置录音保存路径
        String mFileName = Environment.getExternalStorageDirectory() + "/Zowee/" + SystemClock.currentThreadTimeMillis() + ".amr";
        String state = Environment.getExternalStorageState();
        if (!state.equals(Environment.MEDIA_MOUNTED)) {
            Log.i(LOG_TAG, "SD Card is not mounted,It is  " + state + ".");
        }
        File directory = new File(mFileName).getParentFile();
        if (!directory.exists() && !directory.mkdirs()) {
            Log.i(LOG_TAG, "Path to file could not be created");
        }
        ToastUtils.showMessage(mContext, "按住开始录音");
        mMediaRecorder = new MediaRecorder();
        mMediaRecorder.reset();
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        mMediaRecorder.setOutputFile(mFileName);
        try {
            mMediaRecorder.prepare();
            mMediaRecorder.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
        return mFileName;
    }

    private void stopVoice() {
        if (mMediaRecorder != null) {
            try {
                ToastUtils.showMessage(mContext, "录音完成");
                Thread.sleep(500);
                mMediaRecorder.stop();
                mMediaRecorder.release();
                mMediaRecorder = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateToNet() {
        final Map<String, String> map = new HashMap<>();
        map.put("eventInfo.eiId", "" + mRowBean.getEiId());
        map.put("ediTile", "" + mRowBean.getEiName());
        map.put("ediDescription", "" + etRemark.getText().toString());
        map.put("ediLongtitude", "" + mItemAddressInfo.LONG);
        map.put("cpLattitude", "" + mItemAddressInfo.LAT);
        map.put("ediAddress", "" + mItemAddressInfo.Address);
        map.put("userid", "" + ConfigUtils.getUserID(mContext));
        LoginBean.DataBean dataBean = (LoginBean.DataBean) FileUtils.getObject(mContext, "LoginBean.DataBean");
        map.put("ediCpName", "" + dataBean.getCpName());
        List<String> Filepaths = new ArrayList<>();
        for (ItemFileTypeInfo item : mItemFileTypeInfoList) {
            if (item.Type != 2) {
                Filepaths.add(item.pathUrl);
            } else {
                Filepaths.add(item.lowPath);
            }
        }
        final ProgressDialog pDialog = ProgressDialog
                .show(this, "请稍等", "正在提交数据...");
        MyRetrofit.StartUpLoadFilesAndJsonObj(mContext, ApiPathUrl.ACTION_ADDINFORMATIONFEEDBACK, map, Filepaths, new ResponseCallBack<EventUpRespose>() {
            @Override
            protected void onLoad(Disposable d) {
                pDialog.show();
            }

            @Override
            protected void onError(KtkjError error) {
                pDialog.dismiss();
                ToastUtils.showMessage(mContext,error.msg);
            }

            @Override
            protected void onSuccess(EventUpRespose result) {
                ToastUtils.showMessage(mContext, "上报成功");
                pDialog.dismiss();
                finish();
            }
        });

    }
}
