package com.ayuan.graphicsprocessing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //显示原图
        ImageView iv_a = (ImageView) findViewById(R.id.iv_a);
        //显示副本
        ImageView iv_aa = (ImageView) findViewById(R.id.iv_aa);

        //1.先把a.png图片转换成bitmap 显示到iv_a上
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a);
        iv_a.setImageBitmap(bitmap);

        //创建原图的副本
        //3.创建一个模板 相当于创建了一个大小和原图的图但是什么都没有
        Bitmap copy = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //4.创建一个可以编辑的类
        Paint paint = new Paint();
        //5.创建一个用于编辑的画板
        Canvas canvas = new Canvas(copy);
        //创建矩阵对象
        Matrix matrix = new Matrix();
        //-------------------------------------------------------------------------旋转
        /**
         * degerss:需要旋转的角度
         * px:旋转的中点的横坐标
         * py:旋转中心点的纵坐标
         */
        //matrix.setRotate(20, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        //-------------------------------------------------------------------------缩放
        /**
         * sx:缩放比例
         * sy缩放比例
         */
        //matrix.setScale(0.5f, 0.5f);
        //--------------------------------------------------------------------------平移
        /**
         * dx:x轴平移的距离
         * dy:y轴平移的距离
         */
        //matrix.setTranslate(15, 0);
        //-------------------------------------------------------------------------镜面
        //setScale和setTranslate方法一起勇士setTranslate方法需要改成postTranslate方法（参数一样）
        //matrix.setScale(-1.0f, 1);
        //post的方法是再上一次修改的基础上再进行修改  set的方法每次操作都会最新的也就是说图片会重置为操作前的样子在进行变换
        //matrix.postTranslate(bitmap.getWidth(), 0);
        //-------------------------------------------------------------------------倒影
        matrix.setScale(1.0f, -1.0f);
        matrix.postTranslate(0, bitmap.getHeight());
        //6.开始创建副本
        canvas.drawBitmap(bitmap, matrix, paint);
        //.把copy显示到控件上
        iv_aa.setImageBitmap(copy);
    }
}
