package com.ktcd.malc.baselayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author amos_bo 284285624@qq.com
 * @version V1.0
 * @Title: newzowee127
 * @Package com.zowee.roadbusiness.adapter
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2016/12/12 16:51
 */
public abstract class SimpleRecyclerAdapter<T,S extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<S>{

    protected OnItemClickListener mOnItemClickListener;
    protected  Context mContext;
    protected  List<T> mList;
    protected  int mLayoutId;
    protected  Constructor mConstructor;

    public void setOnItemClickListener(OnItemClickListener l){
        mOnItemClickListener=l;
    }

    public SimpleRecyclerAdapter(Context context,int layoutId){
         this.mContext=context;
         this.mLayoutId=layoutId;
        try {
            this.mConstructor=initGenericClass().getDeclaredConstructor(View.class);
            this.mConstructor.setAccessible(true);
        }catch (Exception e){
            throw new IllegalArgumentException("泛型错误");
        }

     }


    @Override
    public void onBindViewHolder(S holder, int position){
        convert(holder,mList.get(position),position);
    }

    protected abstract void convert(final S holder, T t, final int position);

    @Override
    public S onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            View itemView = LayoutInflater.from(mContext).inflate(mLayoutId, parent,
                false);
            return (S)mConstructor.newInstance(itemView);
        } catch (Exception e) {
            throw new IllegalArgumentException("泛型错误");
        }
    }


    @Override
    public int getItemCount() {
        return   mList!=null ? mList.size():0;
    }

    /** 设置数据源-数组*/
    public void setList( T[] list){

        ArrayList<T> arrayList = new ArrayList<T>(list.length);
        for (T t : list) {
            arrayList.add(t);
        }
        setList(arrayList);
    }

    /**设置数据源-List*/
    public void setList(List<T> list) {
        this.mList = list;
    }

    /**获取数据源-List*/
    public List<T> getList() {
        return mList;
    }


    /**
     * 获取position位置的数据
     *
     * @param position
     * @return
     */
    public T getItem(int position) {

        return mList == null ? null : mList.get(position);
    }

    public void addAll(List<T> list) {

        int positionStart =0;
        if(mList == null) {
            mList = list;
        } else {
            positionStart += mList.size();
            mList.addAll(list);
        }
        notifyItemRangeInserted(positionStart, list.size());
    }

    public void add(T item) {

        if(mList == null) {
            mList = new ArrayList<>(1);
        }
        int size = 0;
        mList.add(item);
        notifyDataSetChanged();
    }
    /**添加到某一个位置**/
    public void add(T item, int position) {

        if(mList == null) {
            mList = new ArrayList<>();
        }
        mList.add(position, item);
        notifyItemInserted(position);
    }

    public void update(T item) {

        if(mList == null) {
            mList = new ArrayList<>();
        }
        int idx = mList.indexOf(item);
        if (idx < 0) {
            add(item);
        } else {
            mList.set(idx, item);
            notifyItemChanged(idx);
        }
    }

    public void update(T item , int position) {

        if(mList == null) {
            mList = new ArrayList<>();
        }
        mList.set(position, item);
        notifyItemChanged(position);
    }

    public void reset(List<T> list) {

        mList = list;
        notifyDataSetChanged();
    }

    @SuppressWarnings("unchecked")
    protected final Class<T> initGenericClass() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (params != null && params.length > 1 && params[1] instanceof Class<?>) {
            return (Class<T>) params[1];
        } else {
            throw new IllegalArgumentException("泛型错误");
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
}
