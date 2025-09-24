package com.appliedrec.verid3.common

interface FacialAttributeDetection<T> {
    var confidenceThreshold: Float
    suspend fun detect(face: Face, image: Image): FacialAttributeDetectionResult<T>?
}

val <T> FacialAttributeDetection<T>.typeErased: AnyFacialAttributeDetector
    get() = AnyFacialAttributeDetector(
        detectFunc = { face, image ->
            this.detect(face, image)?.let { result ->
                AnyFacialAttributeDetectionResult(
                    confidence = result.confidence,
                    typeDescription = result.type.toString()
                )
            }
        },
        getThreshold = { this.confidenceThreshold },
        setThreshold = { this.confidenceThreshold = it }
    )