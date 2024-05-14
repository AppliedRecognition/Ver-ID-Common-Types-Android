package com.appliedrec.verid.common

import android.graphics.Bitmap
import java.nio.ByteBuffer

data class Image(val data: ByteArray, val width: Int, val height: Int, val bytesPerRow: Int, val format: ImageFormat): ImageConvertible {

    override fun convertToImage(): Image {
        return this
    }

    override fun convertToBitmap(): Bitmap {
        val bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888)
        val buffer = ByteBuffer.wrap(this.rgba)
        bitmap.copyPixelsFromBuffer(buffer)
        return bitmap
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Image) return false

        if (!data.contentEquals(other.data)) return false
        if (width != other.width) return false
        if (height != other.height) return false
        if (bytesPerRow != other.bytesPerRow) return false
        if (format != other.format) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + width
        result = 31 * result + height
        result = 31 * result + bytesPerRow
        result = 31 * result + format.hashCode()
        return result
    }

    private val rgba: ByteArray
        get() {
            when (this.format) {
                ImageFormat.RGBA -> return this.data
                ImageFormat.BGRA -> {
                    val newData = this.data.toMutableList()
                    for (i in newData.indices step 4) {
                        newData[i] = newData[i + 2].also { newData[i + 2] = newData[i] }
                    }
                    return newData.toByteArray()
                }
                ImageFormat.ARGB -> {
                    val newData = this.data.toMutableList()
                    for (i in newData.indices step 4) {
                        newData[i] = this.data[i + 1]
                        newData[i + 1] = this.data[i + 2]
                        newData[i + 2] = this.data[i + 3]
                        newData[i + 3] = this.data[i]
                    }
                    return newData.toByteArray()
                }
                ImageFormat.ABGR -> {
                    val newData = this.data.toMutableList()
                    for (i in newData.indices step 4) {
                        newData[i] = this.data[i + 3]
                        newData[i + 1] = this.data[i + 2]
                        newData[i + 2] = this.data[i + 1]
                        newData[i + 3] = this.data[i]
                    }
                    return newData.toByteArray()
                }
                ImageFormat.RGB -> {
                    val newData = ByteArray(this.width * this.height * 4)
                    var j = 0
                    for (i in this.data.indices step 3) {
                        newData[j++] = this.data[i]
                        newData[j++] = this.data[i + 1]
                        newData[j++] = this.data[i + 2]
                        newData[j++] = 0xFF.toByte()
                    }
                    return newData
                }
                ImageFormat.BGR -> {
                    val newData = ByteArray(this.width * this.height * 4)
                    var j = 0
                    for (i in this.data.indices step 3) {
                        newData[j++] = this.data[i + 2]
                        newData[j++] = this.data[i + 1]
                        newData[j++] = this.data[i]
                        newData[j++] = 0xFF.toByte()
                    }
                    return newData
                }
                ImageFormat.GRAYSCALE -> {
                    val newData = ByteArray(this.width * this.height * 4)
                    var j = 0
                    for (i in this.data.indices) {
                        newData[j++] = this.data[i]
                        newData[j++] = this.data[i]
                        newData[j++] = this.data[i]
                        newData[j++] = 0xFF.toByte()
                    }
                    return newData
                }
            }
        }
}
