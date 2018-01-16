package com.ktcd.malc.utilslibrary.tools;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import android.view.View;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import java.io.File;

/**
 * @author amos_bo 284285624@qq.com
 * @version V1.0
 * @Title: newzowee127
 * @Package com.zowee.roadbusiness.utils
 * @Description: 图片加载工具
 * @date 2016/12/8 11:07
 */
public class LoadImageUtils {

    /**
     * 最基本的加载图片 isCanReLoad 是否重新加载
     */
    public static void loadImagofBase(View view, String url, boolean isCanReLoad) {

        if (view instanceof SimpleDraweeView) {
            Uri uri = Uri.parse(url);
            if (isCanReLoad) {
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        //加载图片的地址
                        .setUri(uri)
                        //设置点击重试是否开启
                        .setTapToRetryEnabled(true)
                        //设置旧的Controller
                        .setOldController(((SimpleDraweeView) view).getController()).build();
                ((SimpleDraweeView) view).setController(controller);
            } else {
                ((SimpleDraweeView) view).setImageURI(uri);
            }
        } else {
            throw new IllegalArgumentException("控件类型不匹配");
        }
    }

    /**
     * @author:amos_bo 284285624@qq.com
     * @date:2016/12/12 15:59
     * @changeinfo:(修改说明)
     * @version V1.0
     * @Description:设置指定宽高图片，带进度条
     * @param:a 参数述
     * @return:a返回类型
    * @throws:
     */
    public static void loadImagofWAndH(View view,String url,int width,int height){
    //对Bitmap进行后处理
    Postprocessor redMeshPostprocessor = new BasePostprocessor() {
        @Override
        public String getName() {
            return "redMeshPostprocessor";
        }
        @Override
        public void process(Bitmap bitmap) {
            for (int x = 0; x < bitmap.getWidth(); x+=2) {
                for (int y = 0; y < bitmap.getHeight(); y+=2) {
                    bitmap.setPixel(x, y, Color.RED);
                }
            }
        }
    };
    ImageRequest imageRequest = ImageRequestBuilder
            .newBuilderWithSource(Uri.parse(url))
            .setProgressiveRenderingEnabled(true)
            //重新设置图片尺寸
            .setResizeOptions(new ResizeOptions(width, height))
            .setAutoRotateEnabled(true)
            .setPostprocessor(redMeshPostprocessor)
            .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder().setImageRequest(imageRequest).setOldController(((SimpleDraweeView) view).getController()).build();
        ((SimpleDraweeView) view).setController(controller);
}





    /**
     * 最基本的加载图片 失败成功回调处理
     */
    public static void loadImagofBase(View view, String url, BaseControllerListener BaseControllerListener) {
        if (view instanceof SimpleDraweeView) {
            Uri uri = Uri.parse(url);
            DraweeController controller = Fresco.newDraweeControllerBuilder().setControllerListener(BaseControllerListener).setUri(uri).build();
            ((SimpleDraweeView) view).setController(controller);
        } else {
            throw new IllegalArgumentException("控件类型不匹配");
        }
    }
    //备用
    public static void init(final Context context, int cacheSizeInM){
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(context)
                .setMaxCacheSize(cacheSizeInM*1024*1024)//最大缓存
                .setBaseDirectoryName("zowee")//子目录
                .setBaseDirectoryPathSupplier(new Supplier<File>() {
                    @Override
                    public File get() {
                        return context.getCacheDir();//还是推荐缓存到应用本身的缓存文件夹,这样卸载时能自动清除,其他清理软件也能扫描出来
                    }
                })
                .build();
               ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
                .setMainDiskCacheConfig(diskCacheConfig)
                .setDownsampleEnabled(true)
                //Downsampling，要不要向下采样,它处理图片的速度比常规的裁剪scaling更快，
                // 并且同时支持PNG，JPG以及WEP格式的图片，非常强大,与ResizeOptions配合使用
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                //如果不是重量级图片应用,就用这个省点内存吧.默认是RGB_888
                .build();
        Fresco.initialize(context, config);
    }



    /**
     * 初始化图片加载库
     */
    public static void initLoadImageUtils(Application application) {                                                                        //向下采样
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(application).setProgressiveJpegConfig(new SimpleProgressiveJpegConfig()).setDownsampleEnabled(true).build();
        Fresco.initialize(application, config);
        //以下代码为配置JPEG加载显示清晰度以及扫描频率
//        ProgressiveJpegConfig mProgressiveJpegConfig = new ProgressiveJpegConfig() {
//            @Override
//            public int getNextScanNumberToDecode(int scanNumber) {
//                return scanNumber + 2;
//            }
//            public QualityInfo getQualityInfo(int scanNumber) {
//                boolean isGoodEnough = (scanNumber >= 5);
//                return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
//            }
//        };
    }

    /**
     * 加载渐进式JPEG图默认采样率
     */
    public static void loadImagofJpegByDefault(View view, String url) {
        if (view instanceof SimpleDraweeView) {
            Uri uri = Uri.parse(url);
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).build();

            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder().setImageRequest(request).setOldController(((SimpleDraweeView) view).getController()).build();
            ((SimpleDraweeView) view).setController(controller);
        } else {
            throw new IllegalArgumentException("控件类型不匹配");
        }
    }

    /**
     * 先显示低分辨率图然后显示高分辨率图
     */
    public static void loadImagofFirstLowNextHigh(View view, String lowResUrl, String highResUrl) {
        if (view instanceof SimpleDraweeView) {
            Uri lowResUri = Uri.parse(lowResUrl);
            Uri highResUri = Uri.parse(highResUrl);
            DraweeController controller = Fresco.newDraweeControllerBuilder().setLowResImageRequest(ImageRequest.fromUri(lowResUri)).setImageRequest(ImageRequest.fromUri(highResUri)).setOldController(((SimpleDraweeView) view).getController()).build();
            ((SimpleDraweeView) view).setController(controller);
        } else {
            throw new IllegalArgumentException("控件类型不匹配");
        }
    }

    /**
     * 将图片剪裁为圆形
     */
    public static Bitmap createCircleImage(Bitmap source,int d) {
       // int length = source.getWidth() < source.getHeight() ? source.getWidth() : source.getHeight();
        int length=d;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(length, length, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        canvas.drawCircle(length / 2, length / 2, length / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }


}

