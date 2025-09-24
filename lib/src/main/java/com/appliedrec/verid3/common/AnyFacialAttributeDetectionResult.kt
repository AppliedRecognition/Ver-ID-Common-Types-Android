package com.appliedrec.verid3.common

data class AnyFacialAttributeDetectionResult(
    val confidence: Float,
    val typeDescription: String
) {
    override fun toString(): String {
        return "$typeDescription: %.2f".format(confidence)
    }
}
