package com.appliedrec.verid.common

import android.graphics.Bitmap

interface ImageConvertible {

    fun convertToImage(): Image

    fun convertToBitmap(): Bitmap
}