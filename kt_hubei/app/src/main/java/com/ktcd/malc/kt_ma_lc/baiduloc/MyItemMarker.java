package com.ktcd.malc.kt_ma_lc.baiduloc;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.baiduloc.clusterutil.clustering.ClusterItem;

/**
 * Created by Administrator on 2017/10/23.
 */

public class MyItemMarker implements ClusterItem {
    private final LatLng mPosition;

    public MyItemMarker(LatLng latLng) {
        mPosition = latLng;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    @Override
    public BitmapDescriptor getBitmapDescriptor() {
        return BitmapDescriptorFactory
                .fromResource(R.drawable.anim_loading_view);
    }

}