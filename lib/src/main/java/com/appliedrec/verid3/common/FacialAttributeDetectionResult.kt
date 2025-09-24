package com.appliedrec.verid3.common

data class FacialAttributeDetectionResult<T>(
    val confidence: Float,
    val type: T
) {
    override fun toString(): String {
        return "${type.toString()}: %.02f".format(confidence)
    }
}
