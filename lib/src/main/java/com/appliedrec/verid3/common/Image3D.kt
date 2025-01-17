package com.appliedrec.verid3.common

data class Image3D(val image: Image, val depthMap: DepthMap?) : IImage {

    constructor(
        data: ByteArray,
        width: Int,
        height: Int,
        bytesPerRow: Int,
        depthMap: DepthMap?
    ) : this(Image(data, width, height, bytesPerRow, ImageFormat.RGBA), depthMap)

    override val data: ByteArray
        get() = this.image.data

    override val width: Int
        get() = this.image.width

    override val height: Int
        get() = this.image.height

    override val bytesPerRow: Int
        get() = this.image.bytesPerRow

    override val format: ImageFormat
        get() = this.image.format

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Image3D) return false
        if (image != other.image) return false
        if (depthMap != other.depthMap) return false
        return true
    }

    override fun hashCode(): Int {
        var result = image.hashCode()
        result = 31 * result + (depthMap?.hashCode() ?: 0)
        return result
    }
}
