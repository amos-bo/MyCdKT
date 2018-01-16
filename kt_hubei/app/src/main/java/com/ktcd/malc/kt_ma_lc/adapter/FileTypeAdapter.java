package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.model.ItemFileTypeInfo;

import butterknife.BindView;

/**
 * 创建时间 2016/12/30.
 * 创建人： ${xiangbo}
 * 作用：
 * 备注：事件列表
 */

public class FileTypeAdapter extends SimpleRecyclerAdapter<ItemFileTypeInfo, FileTypeAdapter.MyHolder> {

    private FileDeleteListener mFileDeleteListener;

    private boolean mIsShow = true;

    public FileTypeAdapter(Context context) {
        super(context, R.layout.item_file_type);
    }

    @Override
    protected void convert(MyHolder holder, ItemFileTypeInfo s, final int position) {
        if (s == null || holder == null)
            return;
        if (s.Type == 2) {
            //视频
            if (s.pathUrl.startsWith("http")){
                holder.imgType.setImageURI(Uri.parse(s.pathUrl));
            }else{
                holder.imgType.setImageURI(Uri.parse("file://" + s.pathUrl));
            }
            holder.imgPaly.setVisibility(View.VISIBLE);
            holder.imgVoice.setVisibility(View.GONE);
        } else {
            holder.imgPaly.setVisibility(View.GONE);
            holder.imgVoice.setVisibility(View.GONE);
            if (s.Type == 1) {
                //图片
                if (s.pathUrl.startsWith("http")){
                    holder.imgType.setImageURI(Uri.parse(s.pathUrl));
                }else {
                    holder.imgType.setImageURI(Uri.parse("file://" + s.pathUrl));
                }
            } else {
                //语音
                holder.imgVoice.setVisibility(View.VISIBLE);
                holder.imgType.setVisibility(View.GONE);
                holder.imgVoice.setBackgroundResource(R.mipmap.img_voice_3);
            }
        }
        if (mIsShow) {
            holder.imgDelete.setVisibility(View.VISIBLE);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mFileDeleteListener != null) {
                        mFileDeleteListener.isDeleted(view, position);
                    }
                }
            });
        } else {
            holder.imgDelete.setVisibility(View.GONE);
        }
        holder.itemRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view, position);
            }
        });

    }

    /***
     * 删除监听
     * @param fileDeleteListener
     */
    public void setFileDeleteListener(FileDeleteListener fileDeleteListener) {
        this.mFileDeleteListener = fileDeleteListener;
    }

    /***
     * 是否显示删除控件
     * @param
     */
    public void setFileDeleteIsShow(boolean isShow) {
        this.mIsShow = isShow;
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.img_type)
        SimpleDraweeView imgType;
        @BindView(R.id.img_paly)
        ImageView imgPaly;
        @BindView(R.id.img_delete)
        ImageView imgDelete;
        @BindView(R.id.item_root)
        FrameLayout itemRoot;
        @BindView(R.id.img_voice)
        ImageView imgVoice;

        MyHolder(View itemView) {
            super(itemView);
        }
    }

    public interface FileDeleteListener {
        void isDeleted(View view, int postion);
    }

}
