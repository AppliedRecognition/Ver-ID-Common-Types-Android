package com.appliedrec.verid3.common

import android.graphics.RectF

interface SpoofDetection {

    suspend fun detectSpoofInImage(image: IImage, regionOfInterest: RectF?): Float
}