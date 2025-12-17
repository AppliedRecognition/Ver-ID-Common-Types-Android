package com.appliedrec.verid3.common

import android.graphics.Matrix
import android.graphics.PointF
import android.graphics.RectF
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.appliedrec.verid3.common.EulerAngle
import com.appliedrec.verid3.common.Face
import com.appliedrec.verid3.common.aspectRatio
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FaceTests {

    @Test
    fun testChangeFaceAspectRatio() {
        val bounds = RectF(20f, 30f, 300f, 300f)
        val angle = EulerAngle<Float>(-1.2f, 3.3f, 0.1f)
        val leftEye = PointF(110f, 150f)
        val rightEye = PointF(210f, 150f)
        val face = Face(bounds, angle, 10f, emptyArray(), leftEye, rightEye)
        val aspectRatio = 4f/5f
        face.faceAspectRatio = aspectRatio
        assertEquals(aspectRatio, face.bounds.aspectRatio)
    }

    @Test
    fun testApplyMatrixToFace() {
        val matrix = Matrix()
        matrix.setScale(2f, 2f)
        val bounds = RectF(20f, 30f, 300f, 300f)
        val angle = EulerAngle<Float>(-1.2f, 3.3f, 0.1f)
        val leftEye = PointF(110f, 150f)
        val rightEye = PointF(210f, 150f)
        val face = Face(bounds, angle, 10f, emptyArray(), leftEye, rightEye)
        face.applyMatrix(matrix)
        assertEquals(40f, face.bounds.left)
        assertEquals(60f, face.bounds.top)
        assertEquals(600f, face.bounds.right)
        assertEquals(600f, face.bounds.bottom)
        assertEquals(220f, face.leftEye.x)
        assertEquals(300f, face.leftEye.y)
        assertEquals(420f, face.rightEye.x)
        assertEquals(300f, face.rightEye.y)
    }

    @Test
    fun testCalculateBoundsFromLandmarks() {
        val bounds = RectF(20f, 30f, 300f, 300f)
        val angle = EulerAngle<Float>(-1.2f, 3.3f, 0.1f)
        val leftEye = PointF(110f, 150f)
        val rightEye = PointF(210f, 150f)
        val face = Face(bounds, angle, 10f, emptyArray(), leftEye, rightEye)
        val normalized = face.normalizingBounds()
        assertEquals(9.967087f, normalized.bounds.left, 0.01f)
        assertEquals(-12.535645f, normalized.bounds.top, 0.01f)
        assertEquals(310.0329f, normalized.bounds.right, 0.01f)
        assertEquals(362.54663f, normalized.bounds.bottom, 0.01f)
    }
}