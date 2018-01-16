package com.ktcd.malc.utilslibrary.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * @author amos_bo 284285624@qq.com
 * @version V1.0
 * @Title: Roadbusiness
 * @Package com.zowee.roadbusiness.utils
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2016/12/8 15:03
 */
public class FileUtils {

    /**
     * pathUrl 路径
     */
    public static void savaBitmap(String pathUrl, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        try {
            File file = new File( pathUrl );
            BufferedOutputStream bos = new BufferedOutputStream( new
                    FileOutputStream( file ) );
            bitmap.compress( Bitmap.CompressFormat.JPEG, 100, bos );
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Bitmap getBitMapByPath(String path) {

        String rootPath = Environment.getExternalStorageDirectory() + "/" +
                "ktcd"+File.separator+path;
        File mFile = new File( rootPath );
        //若该文件存在
        if (mFile.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile( rootPath );
            return bitmap;
        } else {
            return null;
        }
    }

    /**
     * @param fileName 名字
     * @param dirPath  文件夹名字
     * @throws IOException
     */
    public static String savaBitmap(String dirPath, String fileName, Bitmap
            bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            String path = Environment.getExternalStorageDirectory() + "/" +
                    dirPath;
            File folderFile = new File( path );
            if (!folderFile.exists()) {
                folderFile.mkdir();
            }
            File file = new File( path + File.separator + fileName );
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream( file );
            bitmap.compress( Bitmap.CompressFormat.JPEG, 100, fos );
            fos.flush();
            fos.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getRealFilePath(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null) data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals( scheme )) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals( scheme )) {
            Cursor cursor = context.getContentResolver().query( uri, new
                    String[]{MediaStore.Images.ImageColumns.DATA}, null,
                    null, null );
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex( MediaStore.Images
                            .ImageColumns.DATA );
                    if (index > -1) {
                        data = cursor.getString( index );
                    }
                }
                cursor.close();
            }
        }
        return data;
    }
    /*
 * @function 从本地读取保存的对象
 *
 * @author D-light
 *
 * @time 2014-07-23
 *
 * @param String name
 *
 * @return Object
 */
    public static Object getObject(Context context, String name) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = context.openFileInput(name);
            ois = new ObjectInputStream(fis);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            // 这里是读取文件产生异常
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 读取产生异常，返回null
        return null;
    }


    /**
     * @function 将一个对象保存到本地
     * @author D-light
     * @time 2014-07-23
     * @param String name
     * @return
     * @return void
     */
    public static void saveObject(Context context, String name, Object object){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = context.openFileOutput(name, Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
            //这里是保存文件产生异常
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    //fos流关闭异常
                    e.printStackTrace();
                }
            }
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    //oos流关闭异常
                    e.printStackTrace();
                }
            }
        }
    }
}
