package com.appliedrec.verid3.common

import android.graphics.RectF
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GeometryExtensionTests {

    @Test
    fun testApplyMirrorMatrix() {
        val rect = RectF(10f, 10f, 110f, 210f)
        val width = 1000f
        val expectedRight = width - rect.left
        val expectedLeft = width - rect.right
        val matrix = horizontalMirrorMatrix(width)
        assertTrue(matrix.mapRect(rect))
        assertEquals(expectedRight, rect.right)
        assertEquals(expectedLeft, rect.left)
        assertEquals(10f, rect.top)
        assertEquals(210f, rect.bottom)
    }
}