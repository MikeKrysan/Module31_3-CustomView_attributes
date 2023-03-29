package com.mikekrysan.module31_3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.GREEN
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

//1. в конструктор передаем параметр attributSet: AttributSet - в этом объекте содержатся все наши атрибуты, которые мы передаем через XML.
//2.Для того, чтобы эти параметры привязать к нашему View для начала создадим в папке values -> attr.xml
class CustomView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) : View(context, attributeSet) {

//    private var strokeWidthAttr = 0f
//    //3.Для того, чтобы привязать атрибуты из attr.xml к содержимому нашего кастомного View необходимо создать блок init и в нем получить наши атрибуты
//    init {
//        val attributes = context.theme.obtainStyledAttributes(attributeSet, R.styleable.CustomView, 0,0)
//
//        try {
//            //получаем значение и присваиваем его в нами созданную для этой цели переменную, типа float. Чтобы потом использовать в методе onDraw
//            strokeWidthAttr = attributes.getFloat(R.styleable.CustomView_stroke_width, 0F)  //здесь мы ищем наш атрибут и присваиваем его в нашу переменную
//        } finally {
//            attributes.recycle()
//        }
//    }

    private var strokePaint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.STROKE
        strokeWidth = 5f
        flags = Paint.ANTI_ALIAS_FLAG

    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(0f, 0f, width.toFloat(), height.toFloat(), strokePaint)
    }

    //создаем метод, который мы будем вызывать извне нашего класса и устанавливать новые параметры нашей краски
    fun setStroke(width: Float) {
        strokePaint = Paint().apply {
            color = Color.GREEN
            style = Paint.Style.STROKE
            strokeWidth = width
            flags = Paint.ANTI_ALIAS_FLAG
        }
        //метод из жизненнего цикла View, который заново вызовет метод onDraw() для перерисовки
        invalidate()
    }

}