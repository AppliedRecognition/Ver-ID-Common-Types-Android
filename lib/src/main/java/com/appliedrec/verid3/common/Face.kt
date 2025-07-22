package com.appliedrec.verid3.common

import android.graphics.Matrix
import android.graphics.PointF
import android.graphics.RectF

data class Face(
    val bounds: RectF,
    val angle: EulerAngle<Float>,
    val quality: Float,
    val landmarks: Array<PointF>,
    val leftEye: PointF,
    val rightEye: PointF,
    val noseTip: PointF? = null,
    val mouthCentre: PointF? = null,
    val mouthLeftCorner: PointF? = null,
    val mouthRightCorner: PointF? = null
) {

    companion object {}

    var faceAspectRatio: Float
        get() = this.bounds.aspectRatio
        set(aspectRatio) {
            val faceBounds = this.bounds
            val faceAspectRatio = faceBounds.width() / faceBounds.height()
            if (faceAspectRatio > aspectRatio) {
                val newHeight = faceBounds.width() / aspectRatio
                faceBounds.top = faceBounds.centerY() - newHeight / 2
                faceBounds.bottom = faceBounds.top + newHeight
            } else {
                val newWidth = faceBounds.height() * aspectRatio
                faceBounds.left = faceBounds.centerX() - newWidth / 2
                faceBounds.right = faceBounds.left + newWidth
            }
            this.bounds.left = faceBounds.left
            this.bounds.top = faceBounds.top
            this.bounds.right = faceBounds.right
            this.bounds.bottom = faceBounds.bottom
        }

    fun applyingMatrix(matrix: Matrix): Face {
        val faceBounds = RectF()
        matrix.mapRect(faceBounds, this.bounds)
        val landmarks = this.landmarks.flatMap { listOf(it.x, it.y) }.toFloatArray()
        matrix.mapPoints(landmarks)
        val landmarkPoints = landmarks.toList().chunked(2).map { PointF(it[0], it[1]) }.toTypedArray()
        val leftEye = floatArrayOf(this.leftEye.x, this.leftEye.y)
        matrix.mapPoints(leftEye)
        val rightEye = floatArrayOf(this.rightEye.x, this.leftEye.y)
        matrix.mapPoints(rightEye)
        val noseTip = this.noseTip?.let { floatArrayOf(it.x, it.y) }
        noseTip?.let { matrix.mapPoints(it) }
        val mouthCentre = this.mouthCentre?.let { floatArrayOf(it.x, it.y) }
        mouthCentre?.let { matrix.mapPoints(it) }
        val mouthLeftCorner = this.mouthLeftCorner?.let { floatArrayOf(it.x, it.y) }
        mouthLeftCorner?.let { matrix.mapPoints(it) }
        val mouthRightCorner = this.mouthRightCorner?.let { floatArrayOf(it.x, it.y) }
        mouthRightCorner?.let { matrix.mapPoints(it) }
        return Face(
            faceBounds,
            this.angle,
            this.quality,
            landmarkPoints,
            PointF(leftEye[0], leftEye[1]),
            PointF(rightEye[0], rightEye[1]),
            noseTip?.let { PointF(it[0], it[1]) },
            mouthCentre?.let { PointF(it[0], it[1]) },
            mouthLeftCorner?.let { PointF(it[0], it[1]) },
            mouthRightCorner?.let { PointF(it[0], it[1]) }
        )
    }

    fun applyMatrix(matrix: Matrix) {
        val newFace = this.applyingMatrix(matrix)
        this.bounds.left = newFace.bounds.left
        this.bounds.top = newFace.bounds.top
        this.bounds.right = newFace.bounds.right
        this.bounds.bottom = newFace.bounds.bottom
        for (i in this.landmarks.indices) {
            this.landmarks[i] = newFace.landmarks[i]
        }
        this.leftEye.x = newFace.leftEye.x
        this.leftEye.y = newFace.leftEye.y
        this.rightEye.x = newFace.rightEye.x
        this.rightEye.y = newFace.rightEye.y
        this.noseTip?.let { thisNoseTip ->
            newFace.noseTip?.let { newNoseTip ->
                thisNoseTip.x = newNoseTip.x
                thisNoseTip.y = newNoseTip.y
            }
        }
        this.mouthCentre?.let { thisMouthCentre ->
            newFace.mouthCentre?.let { newMouthCentre ->
                thisMouthCentre.x = newMouthCentre.x
                thisMouthCentre.y = newMouthCentre.y
            }
        }
        this.mouthLeftCorner?.let { thisMouthLeftCorner ->
            newFace.mouthLeftCorner?.let { newMouthLeftCorner ->
                thisMouthLeftCorner.x = newMouthLeftCorner.x
                thisMouthLeftCorner.y = newMouthLeftCorner.y
            }
        }
        this.mouthRightCorner?.let { thisMouthRightCorner ->
            newFace.mouthRightCorner?.let { newMouthRightCorner ->
                thisMouthRightCorner.x = newMouthRightCorner.x
                thisMouthRightCorner.y = newMouthRightCorner.y
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Face) return false

        if (bounds != other.bounds) return false
        if (angle != other.angle) return false
        if (quality != other.quality) return false
        if (!landmarks.contentEquals(other.landmarks)) return false
        if (leftEye != other.leftEye) return false
        if (rightEye != other.rightEye) return false
        if (noseTip != other.noseTip) return false
        if (mouthCentre != other.mouthCentre) return false
        if (mouthLeftCorner != other.mouthLeftCorner) return false
        if (mouthRightCorner != other.mouthRightCorner) return false
        return true
    }

    override fun hashCode(): Int {
        var result = bounds.hashCode()
        result = 31 * result + angle.hashCode()
        result = 31 * result + quality.hashCode()
        result = 31 * result + landmarks.contentHashCode()
        result = 31 * result + leftEye.hashCode()
        result = 31 * result + rightEye.hashCode()
        result = 31 * result + (noseTip?.hashCode() ?: 0)
        result = 31 * result + (mouthCentre?.hashCode() ?: 0)
        result = 31 * result + (mouthLeftCorner?.hashCode() ?: 0)
        result = 31 * result + (mouthRightCorner?.hashCode() ?: 0)
        return result
    }
}
