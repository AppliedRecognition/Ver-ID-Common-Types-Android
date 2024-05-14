package com.appliedrec.verid.common

data class FaceRecognitionTemplate(val data: ByteArray, val version: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FaceRecognitionTemplate) return false

        if (!data.contentEquals(other.data)) return false
        if (version != other.version) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + version
        return result
    }
}
