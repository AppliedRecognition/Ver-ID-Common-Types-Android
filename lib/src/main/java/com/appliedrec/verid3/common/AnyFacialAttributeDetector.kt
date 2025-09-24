package com.appliedrec.verid3.common

class AnyFacialAttributeDetector(
    private val detectFunc: suspend (Face, Image) -> AnyFacialAttributeDetectionResult?,
    private val getThreshold: () -> Float,
    private val setThreshold: (Float) -> Unit
) {
    var confidenceThreshold: Float
        get() = getThreshold()
        set(value) = setThreshold(value)

    suspend fun detect(face: Face, image: Image): AnyFacialAttributeDetectionResult? {
        return detectFunc(face, image)
    }
}