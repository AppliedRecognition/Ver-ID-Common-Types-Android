package com.appliedrec.verid.commontypes

import android.graphics.Matrix
import android.graphics.RectF
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.appliedrec.verid.common.EulerAngle
import com.appliedrec.verid.common.Face
import com.appliedrec.verid.common.aspectRatio
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FaceTests {

    @Test
    fun testChangeFaceAspectRatio() {
        val bounds = RectF(20f, 30f, 300f, 300f)
        val angle = EulerAngle<Float>(-1.2f, 3.3f, 0.1f)
        val face = Face(bounds, angle, 10f, emptyArray())
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
        val face = Face(bounds, angle, 10f, emptyArray())
        face.applyMatrix(matrix)
        assertEquals(40f, face.bounds.left)
        assertEquals(60f, face.bounds.top)
        assertEquals(600f, face.bounds.right)
        assertEquals(600f, face.bounds.bottom)
    }
}