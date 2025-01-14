package com.appliedrec.verid3.common

import android.graphics.Matrix
import android.graphics.RectF

val RectF.aspectRatio: Float
    get() = this.width() / this.height()

fun horizontalMirrorMatrix(width: Float): Matrix {
    val matrix = Matrix()
    matrix.setScale(-1f, 1f)
    matrix.postTranslate(width, 0f)
    return matrix
}