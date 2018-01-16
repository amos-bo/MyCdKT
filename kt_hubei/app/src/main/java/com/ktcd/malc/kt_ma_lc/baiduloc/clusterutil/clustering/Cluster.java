/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.ktcd.malc.kt_ma_lc.baiduloc.clusterutil.clustering;


import com.baidu.mapapi.model.LatLng;

import java.util.Collection;

/**
 * A collection of ClusterItems that are nearby each other.
 */
public interface Cluster<T extends com.ktcd.malc.kt_ma_lc.baiduloc.clusterutil.clustering.ClusterItem> {
    public LatLng getPosition();

    Collection<T> getItems();

    int getSize();
}