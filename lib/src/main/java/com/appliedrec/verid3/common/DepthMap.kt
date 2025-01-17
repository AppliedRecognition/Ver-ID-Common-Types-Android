package com.appliedrec.verid3.common

import android.graphics.PointF

data class DepthMap(
    val data: ByteArray,
    val width: Int,
    val height: Int,
    val bytesPerRow: Int,
    val bitsPerPixel: Int,
    val principalPoint: PointF,
    val focalLength: PointF,
    val lensDistortionLookupTable: FloatArray,
    val lensDistortionCenter: PointF
) {

    override fun equals(other: Any?): Boolean {
        if (other !is DepthMap) return false
        return this.data.contentEquals(other.data)
                &&this.width == other.width
                && this.height == other.height
                && this.bytesPerRow == other.bytesPerRow
                && this.bitsPerPixel == other.bitsPerPixel
                && this.lensDistortionLookupTable.contentEquals(other.lensDistortionLookupTable)
                && this.principalPoint == other.principalPoint
                && this.focalLength == other.focalLength
                && this.lensDistortionCenter == other.lensDistortionCenter
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + width
        result = 31 * result + height
        result = 31 * result + bytesPerRow
        result = 31 * result + bitsPerPixel
        result = result * 31 + lensDistortionLookupTable.contentHashCode()
        result = result * 31 + principalPoint.hashCode()
        result = result * 31 + focalLength.hashCode()
        result = result * 31 + lensDistortionCenter.hashCode()
        return result
    }
}
