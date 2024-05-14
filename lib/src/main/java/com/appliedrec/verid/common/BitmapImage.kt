package com.appliedrec.verid.common

import android.graphics.Bitmap
import java.nio.ByteBuffer

class BitmapImage(private val bitmap: Bitmap): ImageConvertible {

    override fun convertToImage(): Image {
        if (bitmap.config == Bitmap.Config.ARGB_8888) {
            val data = ByteArray(bitmap.byteCount)
            val buffer: ByteBuffer = ByteBuffer.wrap(data)
            bitmap.copyPixelsToBuffer(buffer)
            return Image(data, bitmap.width, bitmap.height, bitmap.rowBytes, ImageFormat.BGRA)
        } else if (bitmap.config == Bitmap.Config.ALPHA_8) {
            val data = ByteArray(bitmap.byteCount)
            val buffer: ByteBuffer = ByteBuffer.wrap(data)
            bitmap.copyPixelsToBuffer(buffer)
            return Image(data, bitmap.width, bitmap.height, bitmap.rowBytes, ImageFormat.GRAYSCALE)
        } else {
            throw Error("Only ARGB_8888 or ALPHA_8 bitmaps are supported")
        }
    }

    override fun convertToBitmap(): Bitmap {
        return bitmap
    }

}