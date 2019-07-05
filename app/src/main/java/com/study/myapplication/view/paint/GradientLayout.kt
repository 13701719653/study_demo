package com.study.myapplication.view.paint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.study.myapplication.R

/**
 * Created by xwg on 2019/7/2.
 * describe TODO
 *
 */

class GradientLayout: View{
//    View(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes
    constructor(context: Context,attrs:AttributeSet,defstyleAttr:Int):super(context,attrs,defstyleAttr){init() }
    constructor(context: Context,attrs:AttributeSet):super(context,attrs){init() }
    private val paint : Paint by lazy{
           Paint()
            }
    private val mBitmap :Bitmap by lazy{
        BitmapFactory.decodeResource(resources, R.mipmap.img_test)
    }
    constructor(context: Context) : super(context) {
       init()
    }

    private fun init() {
        paint.color= Color.RED
        paint.setARGB(255,255,255,0)
        paint.apply {
//            color=Color.RED
//            setARGB(255,255,255,0)
//            alpha = 200//设置不透明度,范围0-255
            isAntiAlias=true//抗锯齿
            style=Paint.Style.FILL//描边效果
//            strokeWidth=4f//描边宽度
//            strokeCap= Paint.Cap.ROUND//画笔结尾的时候形状这里设置圆形
//            strokeJoin= Paint.Join.MITER//拐角风格  //miter是锐角相交 还有圆角相交,直线相交
//            shader = SweepGradient(200f,200f,Color.BLUE,Color.RED)//设置环形渲染器
//            xfermode = PorterDuffXfermode(PorterDuff.Mode.DARKEN)//设置图层混合模式
//            colorFilter = LightingColorFilter(0x00ffff,0x000000)//设置颜色过滤器
//            isFilterBitmap=true//设置双线性过滤
//            maskFilter = BlurMaskFilter(10f,BlurMaskFilter.Blur.NORMAL)//设置画笔这招滤镜,传入度数和样式
//            textScaleX= 2f//设置文本缩放倍数
//            textSize=38f
//            textAlign= Paint.Align.LEFT//对其方式
//            isUnderlineText= true//设置下划线
//
//
//            val temp= "谢伟光在学习安卓进阶技术"
//            val rect = Rect()
//            getTextBounds(temp,0,temp.length,rect)//测量文本大小,将文本大小信息存放在rect中
//           val textWidth = measureText(temp)
//            val textMetrics = fontMetrics



        }
    }
    lateinit var shader:Shader
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        /**
         * 线性渲染,LinearGradient(float x0, float y0, float x1, float y1, @NonNull @ColorInt int colors[],
        @Nullable float positions[], @NonNull TileMode tile)
         (x0,y0) 渐变起始坐标
         (x1,y1)渐变结束坐标
         color0 渐变开始点颜色,16进制的颜色表示,必须带有透明度
         color1,渐变结束颜色
         colors渐变数组
         positions 位置数组,position的取值范围[0,1],作用是置顶某个位置的颜色值,如果null,渐变就是线性变化
         title:用于指定控件区域大于指定的渐变区域是,空白区域的颜色填充方式
         */
        shader= LinearGradient(0f,0f,500f,500f ,
                intArrayOf(Color.RED,Color.BLUE,Color.GREEN), floatArrayOf(0f,0.7f,1f),Shader.TileMode.REPEAT)
        paint.shader = shader
//        canvas?.drawCircle(250f,250f,250f,paint)
        canvas?.drawRect(0f,0f,1000f,1000f,paint)


        /**环形渲染
         *RadialGradient(float centerX, float centerY, float radius,
        @NonNull @ColorInt int colors[], @Nullable float stops[],
        @NonNull TileMode tileMode)
         centerX centerY 辐射中心的坐标
         radius 辐射半径
         centerColor 辐射中心的颜色
         edgeColor 辐射边缘的颜色
        colors 渐变颜色数组
        stoops 渐变位置数组,类似扫描的positions数组 取[0,1],中心为0,半径到达位置为1.0f
         titleMode 未覆盖意外的填充颜色模式
         */
//        shader= RadialGradient(250f,250f,250f,
//                intArrayOf(Color.GREEN,Color.YELLOW,Color.RED),null,Shader.TileMode.CLAMP)
//        paint.  shader = shader
//        canvas?.drawCircle(250f,250f,250f,paint)

        /**
         * 扫描渲染
         * /**
         * A Shader that draws a sweep gradient around a center point.
         *
         * @param cx       渐变中心的坐标
         * @param cy       渐变中心的坐标
         * @param color0   渐变开始结束颜色
         * @param color1   The color to use at the end of the sweep
        */
         */
//        shader= SweepGradient(250f,250f,Color.RED,Color.GREEN)
//        paint.shader=shader
//        canvas?.drawCircle(250f,250f,250f,paint)

        /**
         * 位图渲染
         *  Call this to create a new shader that will draw with a bitmap.
         *
         * @param bitmap 构造BitmapShader使用的bitmap
         * @param tileX 水平方向的TileMode
         * @param tileY 垂直方向的TileMode
         * REPEAT 绘制区域超过渲染区域的部分,重复排版
         * CLAMP 绘制区域超过渲染区域的部分,重复最后一个像素拉伸排版
         * MIRROR 绘制区域超过渲染区域的部分 镜像翻转排版
         */
//        shader= BitmapShader(mBitmap,Shader.TileMode.MIRROR,Shader.TileMode.MIRROR)
//        paint.shader=shader
//        canvas?.drawCircle(250f,250f,250f,paint)
//        canvas?.drawRect(0f,0f,mBitmap.width.toFloat(),mBitmap.height.toFloat(),paint)
//        canvas?.drawRect(0f,0f,500f,500f,paint)

        /**
         * 组合渲染
         *ComposeShader(@NonNull Shader shaderA, @NonNull Shader shaderB,@NonNull PorterDuff.Mode mode)
         *  ComposeShader(@NonNull Shader shaderA, @NonNull Shader shaderB, @NonNull Xfermode mode) {
         * @param shaderA  要混合的2种shader
         * @param shaderB  要混合的2种shader
         * @param PorterDuff.Mode mode     组合2中shader颜色的模式
         * @param Xfermode   mode  组合2中shader颜色的模式
         *
         */

        val bitmapShader = BitmapShader(mBitmap,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT)
        val linearGradient = LinearGradient(0f,0f,1000f,1600f , intArrayOf(Color.RED,Color.GREEN,Color.BLUE),null,Shader.TileMode.MIRROR )
        shader= ComposeShader(bitmapShader,linearGradient,PorterDuff.Mode.MULTIPLY)
        paint.shader=shader
        canvas?.drawCircle(250f,250f,250f,paint)
    }

}