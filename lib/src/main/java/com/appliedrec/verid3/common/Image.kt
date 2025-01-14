package com.appliedrec.verid3.common

data class Image(override val data: ByteArray, override val width: Int, override val height: Int, override val bytesPerRow: Int, override val format: ImageFormat): IImage {
    companion object {}
//    companion object {
//        @JvmStatic
//        @Throws(IllegalArgumentException::class)
//        fun fromBitmap(bitmap: Bitmap): Image {
//            if (bitmap.config == Bitmap.Config.ARGB_8888) {
//                val data = ByteArray(bitmap.byteCount)
//                val buffer: ByteBuffer = ByteBuffer.wrap(data)
//                bitmap.copyPixelsToBuffer(buffer)
//                return Image(data, bitmap.width, bitmap.height, bitmap.rowBytes, ImageFormat.RGBA)
//            } else if (bitmap.config == Bitmap.Config.ALPHA_8) {
//                val data = ByteArray(bitmap.byteCount)
//                val buffer: ByteBuffer = ByteBuffer.wrap(data)
//                bitmap.copyPixelsToBuffer(buffer)
//                return Image(data, bitmap.width, bitmap.height, bitmap.rowBytes, ImageFormat.GRAYSCALE)
//            } else {
//                throw IllegalArgumentException("Only ARGB_8888 or ALPHA_8 bitmaps are supported")
//            }
//        }
//    }
//
//    override fun toBitmap(): Bitmap {
//        val bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888)
//        val buffer = ByteBuffer.wrap(this.rgba)
//        bitmap.copyPixelsFromBuffer(buffer)
//        return bitmap
//    }

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

//    private val rgba: ByteArray
//        get() {
//            when (this.format) {
//                ImageFormat.RGBA -> return this.data
//                ImageFormat.BGRA -> {
//                    val newData = this.data.toMutableList()
//                    for (i in newData.indices step 4) {
//                        newData[i] = newData[i + 2].also { newData[i + 2] = newData[i] }
//                    }
//                    return newData.toByteArray()
//                }
//                ImageFormat.ARGB -> {
//                    val newData = this.data.toMutableList()
//                    for (i in newData.indices step 4) {
//                        newData[i] = this.data[i + 1]
//                        newData[i + 1] = this.data[i + 2]
//                        newData[i + 2] = this.data[i + 3]
//                        newData[i + 3] = this.data[i]
//                    }
//                    return newData.toByteArray()
//                }
//                ImageFormat.ABGR -> {
//                    val newData = this.data.toMutableList()
//                    for (i in newData.indices step 4) {
//                        newData[i] = this.data[i + 3]
//                        newData[i + 1] = this.data[i + 2]
//                        newData[i + 2] = this.data[i + 1]
//                        newData[i + 3] = this.data[i]
//                    }
//                    return newData.toByteArray()
//                }
//                ImageFormat.RGB -> {
//                    val newData = ByteArray(this.width * this.height * 4)
//                    var j = 0
//                    for (i in this.data.indices step 3) {
//                        newData[j++] = this.data[i]
//                        newData[j++] = this.data[i + 1]
//                        newData[j++] = this.data[i + 2]
//                        newData[j++] = 0xFF.toByte()
//                    }
//                    return newData
//                }
//                ImageFormat.BGR -> {
//                    val newData = ByteArray(this.width * this.height * 4)
//                    var j = 0
//                    for (i in this.data.indices step 3) {
//                        newData[j++] = this.data[i + 2]
//                        newData[j++] = this.data[i + 1]
//                        newData[j++] = this.data[i]
//                        newData[j++] = 0xFF.toByte()
//                    }
//                    return newData
//                }
//                ImageFormat.GRAYSCALE -> {
//                    val newData = ByteArray(this.width * this.height * 4)
//                    var j = 0
//                    for (i in this.data.indices) {
//                        newData[j++] = this.data[i]
//                        newData[j++] = this.data[i]
//                        newData[j++] = this.data[i]
//                        newData[j++] = 0xFF.toByte()
//                    }
//                    return newData
//                }
//            }
//        }
}
