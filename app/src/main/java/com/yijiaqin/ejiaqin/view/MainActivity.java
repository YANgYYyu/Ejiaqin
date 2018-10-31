package com.yijiaqin.ejiaqin.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Base64;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.drawView.PersonInfoActivity;
import com.yijiaqin.ejiaqin.util.CacheUtils;
import com.yijiaqin.ejiaqin.util.DateUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 作者：平塔岛象龟
 * <p>
 * 邮箱：454941261@qq.com
 * <p>
 * 创建日期：2018/4/2
 * <p>
 * 文件描述:主activity
 * <p>
 * 备注:里面嵌套了4个fragment，第一个fragment里又嵌套了3个fragment
 */


// TODO: 2018/9/18 换成github上的开源库
public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private LinearLayout mTabShouye;
    private LinearLayout mTabJia;
    private LinearLayout mTabMianduimian;
    private LinearLayout mTabXinyuanqiang;

    private ImageButton mImgShouye;
    private ImageButton mImgJia;
    private ImageButton mImgMianduimian;
    private ImageButton mImgXinyuanqiang;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;


    private DrawerLayout drawerLayout;  //侧滑栏
    private ImageView actionbar_img;    //唤出侧滑栏的图标
    private ImageView touxiang_iv;  //侧滑栏里面的头像
    //    private EditText sign_et;   //签名
    private Button btn_left1, btn_left2, btn_left3, btn_left4, btn_left5, btn_left6;    //侧滑栏的按钮

    private static final int CAMERA_REQUEST_CODE = 1;   //拍照
    private static final int GALLERY_REQUEST_CODE = 2;  //相册
    private static final int CROP_REQUEST_CODE = 3;     //裁剪页

    private int i = 0;    //点击侧边栏的小头像弹出侧边栏时，根据i来切换对应底部栏的图片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
//      初始化试图
        initView();
//       初始化点击事件
        initEvent();


//        fragment的切换
        setSelect(0);
//        初始化第一个fragment
        initData();

    }

    private void initEvent() {
//        底部栏
        mTabShouye.setOnClickListener(this);
        mTabJia.setOnClickListener(this);
        mTabMianduimian.setOnClickListener(this);
        mTabXinyuanqiang.setOnClickListener(this);

//      标题的头像
        actionbar_img.setOnClickListener(this);
//        侧滑栏里面的头像
        touxiang_iv.setOnClickListener(this);
//        侧滑栏里的点击item
        btn_left1.setOnClickListener(this);
        btn_left2.setOnClickListener(this);
        btn_left3.setOnClickListener(this);
        btn_left4.setOnClickListener(this);
        btn_left5.setOnClickListener(this);
        btn_left6.setOnClickListener(this);
    }

    private void initView() {
//        底部栏里的每一个子项
        mTabShouye = (LinearLayout) findViewById(R.id.id_tab_shouye);
        mTabJia = (LinearLayout) findViewById(R.id.id_tab_jia);
        mTabMianduimian = (LinearLayout) findViewById(R.id.id_tab_mianduimian);
        mTabXinyuanqiang = (LinearLayout) findViewById(R.id.id_tab_xinyuanqiang);
//        底部栏里的每一个子项的图片
        mImgShouye = (ImageButton) findViewById(R.id.id_tab_shouye_img);
        mImgJia = (ImageButton) findViewById(R.id.id_tab_jia_img);
        mImgMianduimian = (ImageButton) findViewById(R.id.id_tab_mianduimian_img);
        mImgXinyuanqiang = (ImageButton) findViewById(R.id.id_tab_xinyuanqiang_img);
//      侧滑栏
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionbar_img = (ImageView) findViewById(R.id.actionbar_img);

        touxiang_iv = (ImageView) findViewById(R.id.touxiang_iv);
        //      拿到SharedPreferences里保存的图片数据，进行解码    todo 无法读取图片
        String pic = (String) CacheUtils.getString(MainActivity.this, CacheUtils.PIC_URI);
        if (pic != null) {
            byte[] bytes = android.util.Base64.decode(pic.getBytes(), 1);
            touxiang_iv.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
        }

        btn_left1 = (Button) findViewById(R.id.btn_left1);
        btn_left2 = (Button) findViewById(R.id.btn_left2);
        btn_left3 = (Button) findViewById(R.id.btn_left3);
        btn_left4 = (Button) findViewById(R.id.btn_left4);
        btn_left5 = (Button) findViewById(R.id.btn_left5);
        btn_left6 = (Button) findViewById(R.id.btn_left6);

    }

    /**
     * 切换activity里的fragment，默认为0，即第一个
     *
     * @param i 切换的fragment的序号
     */
    public void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        switch (i) {
            case 0:
                Fragment homeFragment = new com.yijiaqin.ejiaqin.fragement.HomeFragment();
                transaction.replace(R.id.id_content, homeFragment);
                mImgShouye.setImageResource(R.mipmap.shouye_pressed);
                transaction.commit();
                break;
            case 1:
                Fragment jiaFragment = new com.yijiaqin.ejiaqin.fragement.JiaFragment();
                transaction.replace(R.id.id_content, jiaFragment);
                mImgJia.setImageResource(R.mipmap.jia_pressed);
                transaction.commit();
                break;
            case 2:
                Fragment mianduimianFragment = new com.yijiaqin.ejiaqin.fragement.MianDuiMianFragment();
                transaction.replace(R.id.id_content, mianduimianFragment);
                mImgMianduimian.setImageResource(R.mipmap.mianduimian_pressed);
                transaction.commit();
                break;
            case 3:
                Fragment xinyuanqiangFragment = new com.yijiaqin.ejiaqin.fragement.XinYuanQiangFragment();
                transaction.replace(R.id.id_content, xinyuanqiangFragment);
                mImgXinyuanqiang.setImageResource(R.mipmap.xinyuanqiang_pressed);
                transaction.commit();
                break;
            default:
                break;
        }
    }

    //    隐藏对应的fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
        if (mTab04 != null) {
            transaction.hide(mTab04);
        }
    }

    //    初始化第一个fragment
    private void initData() {
        addFragmentToStack(new com.yijiaqin.ejiaqin.fragement.HomeFragment());
    }

    private void addFragmentToStack(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.id_content, fragment).commit();
    }


    //  对底部栏按钮进行监听，切换到对应fragment
    public void onClick(View v) {
        resetImgs();
        switch (v.getId()) {
            case R.id.id_tab_shouye:
                setSelect(0);
                i = 0;
                break;
            case R.id.id_tab_jia:
                setSelect(1);
                i = 1;
                break;
            case R.id.id_tab_mianduimian:
                setSelect(2);
                i = 2;
                break;
            case R.id.id_tab_xinyuanqiang:
                setSelect(3);
                i = 3;
                break;
            case R.id.actionbar_img:
                drawerLayout.openDrawer(Gravity.START);
                switch (i) {
                    case 0:
                        mImgShouye.setImageResource(R.mipmap.shouye_pressed);
                        break;
                    case 1:
                        mImgJia.setImageResource(R.mipmap.jia_pressed);
                        break;
                    case 2:
                        mImgMianduimian.setImageResource(R.mipmap.mianduimian_pressed);
                        break;
                    case 3:
                        mImgXinyuanqiang.setImageResource(R.mipmap.xinyuanqiang_pressed);
                        break;
                }
                break;
            case R.id.touxiang_iv:
                touxiang_iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view = getLayoutInflater().inflate(R.layout.my_dialog, null);

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.MyDialog);
                        builder.setView(view);
                        final AlertDialog alertDialog = builder.create();
                        alertDialog.setCanceledOnTouchOutside(true);      //设置弹出框失去焦点是否隐藏,即点击屏蔽其它地方是否隐藏
                        alertDialog.show();
                        Button camera = (Button) view.findViewById(R.id.dialog_camera_btn);
                        camera.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(intent, CAMERA_REQUEST_CODE);
                            }
                        });
                        Button gallery = (Button) view.findViewById(R.id.dialog_gallery_btn);
                        gallery.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/*");
                                startActivityForResult(intent, GALLERY_REQUEST_CODE);
                            }
                        });
                    }
                });
                break;
            case R.id.btn_left1:
                startActivity(new Intent(MainActivity.this, PersonInfoActivity.class));
                break;
            default:
                break;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelect(i);
    }

    /**
     * 切换图片正常颜色
     */
    private void resetImgs() {
        mImgShouye.setImageResource(R.mipmap.shouye_normal);
        mImgJia.setImageResource(R.mipmap.jia_normal);
        mImgMianduimian.setImageResource(R.mipmap.mianduimian_normal);
        mImgXinyuanqiang.setImageResource(R.mipmap.xinyuanqiang_normal);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (data == null) {
                return;
            } else {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap bitmap = extras.getParcelable("data");
                    touxiang_iv.setImageBitmap(bitmap);
//                    todo 裁剪图片有问题，要添加这个
//                    Uri uri = saveBitmap(bitmap);
//                    startImageZoom(uri);
                }
            }
        } else if (requestCode == GALLERY_REQUEST_CODE) {
            if (data == null) {
                return;
            }
            Uri uri = data.getData();
            InputStream inputStream = null;
            try {
                inputStream = getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            touxiang_iv.setImageBitmap(bitmap);
//                Uri fileUri = convertUri(uri);
//                startImageZoom(fileUri);
        } else if (requestCode == CROP_REQUEST_CODE) {
            if (data == null) {
                return;
            }
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap bitmap = extras.getParcelable("data");
//                把剪切过的图片通过编码，保存在SharedPreferences
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, bos);
                String imageBase64 = Base64.encodeToString(bos.toByteArray(), Base64.DEFAULT);
                CacheUtils.putString(MainActivity.this, CacheUtils.PIC_URI, imageBase64);
                touxiang_iv.setImageBitmap(bitmap);
//                sendImg(bitmap); 这里应该是把bitmap上传到服务器，但是没有。。
                /**
                 * 将图片上传到服务器
                 * @param bitmap    要上传的图片
                 * 将传入的bitmap进行Base64编码，在服务端那里惊醒解码
                 * 利用AsyncHttpClient框架将编码后的字符上传
                 * 在php服务器中进行接受并解码，保存在服务器中
                 */
//                private void sendImg(Bitmap bitmap){
//                    ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
//                    /**
//                     * 压缩图片
//                     * 第一个参数指定输出的文件格式
//                     * 第二个参数是压缩比例
//                     * 第三个参数是压缩后的流大小
//                     */
//                    bitmap.compress(Bitmap.CompressFormat.PNG,60,arrayOutputStream);
//                    byte[] bytes = arrayOutputStream.toByteArray();
////        将bitmap进行Base64编码
//                    String img = new String(Base64.encode(bytes,Base64.DEFAULT));
//                    AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
//                    RequestParams params = new RequestParams();
//                    params.add("img",img);
////        todo 这里是通过post上传数据，有些问题
//        asyncHttpClient.post("http://url", params ,new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int i, Header[] headers, byte[] bytes) {
//
//            }
//
//            @Override
//            public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {
//
//            }
//        })

/*  服务端php源码
<?php

$filename = "images/".$_POST['userName'];

$file = fopen($filename.".jpg","w");

$date = base64_decode($_POST['img']);

fwrite($file,$date);

fclose($file);

?>

* */
            }
        }
    }


    //    把content类型uri转换成file类型的uri,中间把图片保存在了SD卡中，同时拿到了路径
    private Uri convertUri(Uri uri) {
        InputStream inputStream = null;
        try {
            inputStream = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return saveBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //    把bitmap保存在SD卡中，并返回该路径
    private Uri saveBitmap(Bitmap bitmap) {
//        保存到的文件夹路径
        File tmpDir = new File(Environment.getExternalStorageDirectory() + "/DCIM/com.hzywl.ShareUmbrella");
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }
//      图片+图片名完整的路径
        File img = new File(tmpDir.getAbsolutePath() + "/" + DateUtil.getStrTime(String.valueOf(System.currentTimeMillis())) + ".png");
        try {
            FileOutputStream fos = new FileOutputStream(img);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.flush();
            fos.close();
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //    调用系统裁剪工具进行裁剪，传入的uri为file类型
    private void startImageZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 120);
        intent.putExtra("outputY", 120);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_REQUEST_CODE);
    }
}
