package com.yijiaqin.ejiaqin.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;

/**
 * 作者：平塔岛象龟
 *
 * 邮箱：454941261@qq.com
 *
 * 创建日期：2018/4/9
 *
 * 文件描述:drawable转化为byte
 *
 * 备注:
 */

public class DrawableToBytes {

    public  static synchronized  byte[] drawableToByte(Drawable drawable) {
        if (drawable != null) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            int size = bitmap.getWidth() * bitmap.getHeight() * 4;
            // 创建一个字节数组输出流,流的大小为size
            ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
            // 设置位图的压缩格式，质量为100%，并放入字节数组输出流中
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            // 将字节数组输出流转化为字节数组byte[]
            byte[] imagedata = baos.toByteArray();
            return imagedata;
        }
        return null;
    }

}
