package com.appliedrec.verid3.common

import android.graphics.Bitmap
import kotlin.jvm.Throws

interface IImage {
    val data: ByteArray
    val width: Int
    val height: Int
    val bytesPerRow: Int
    val format: ImageFormat
}