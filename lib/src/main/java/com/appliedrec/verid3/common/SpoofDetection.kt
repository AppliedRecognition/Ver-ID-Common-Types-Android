package com.appliedrec.verid3.common

import android.graphics.RectF

interface SpoofDetection : SuspendingCloseable {

    val confidenceThreshold: Float
        get() = 0.5f

    suspend fun detectSpoofInImage(image: IImage, regionOfInterest: RectF?): Float

    suspend fun isImageSpoofed(image: IImage, regionOfInterest: RectF?): Boolean {
        return detectSpoofInImage(image, regionOfInterest) >= confidenceThreshold
    }
}