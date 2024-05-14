package com.appliedrec.verid.commontypes

import android.graphics.Bitmap
import android.graphics.Color
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.appliedrec.verid.common.BitmapImage
import com.appliedrec.verid.common.Image
import com.appliedrec.verid.common.ImageFormat

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ImageTests {

    @Test
    fun testConvertBitmapToImage() {
        val bitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888)
        bitmap.setPixel(0, 0, Color.RED)
        bitmap.setPixel(1, 0, Color.GREEN)
        bitmap.setPixel(0, 1, Color.BLUE)
        bitmap.setPixel(1, 1, Color.WHITE)
        val bitmapImage = BitmapImage(bitmap)
        val image = bitmapImage.convertToImage()
        assertEquals(ImageFormat.BGRA, image.format)
        assertEquals(16, image.data.size)
        assertEquals(0xFF.toByte(), image.data[0])
        assertEquals(0x00.toByte(), image.data[1])
        assertEquals(0x00.toByte(), image.data[2])
        assertEquals(0xFF.toByte(), image.data[3])

        assertEquals(0x00.toByte(), image.data[4])
        assertEquals(0xFF.toByte(), image.data[5])
        assertEquals(0x00.toByte(), image.data[6])
        assertEquals(0xFF.toByte(), image.data[7])

        assertEquals(0x00.toByte(), image.data[8])
        assertEquals(0x00.toByte(), image.data[9])
        assertEquals(0xFF.toByte(), image.data[10])
        assertEquals(0xFF.toByte(), image.data[11])

        assertEquals(0xFF.toByte(), image.data[12])
        assertEquals(0xFF.toByte(), image.data[13])
        assertEquals(0xFF.toByte(), image.data[14])
        assertEquals(0xFF.toByte(), image.data[15])
    }

    @Test
    fun testConvertARGBImageToBitmap() {
        val data = byteArrayOf(
            0xFF.toByte(), 0xFF.toByte(), 0, 0,
            0xFF.toByte(), 0, 0xFF.toByte(), 0,
            0xFF.toByte(), 0, 0, 0xFF.toByte(),
            0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
        )
        val image = Image(data, 2, 2, 8, ImageFormat.ARGB)
        val bitmap = image.convertToBitmap()
        assertEquals(Color.RED, bitmap.getPixel(0, 0))
        assertEquals(Color.GREEN, bitmap.getPixel(1, 0))
        assertEquals(Color.BLUE, bitmap.getPixel(0, 1))
        assertEquals(Color.WHITE, bitmap.getPixel(1, 1))
    }

    @Test
    fun testConvertABGRImageToBitmap() {
        val data = byteArrayOf(
            0xFF.toByte(), 0, 0, 0xFF.toByte(),
            0xFF.toByte(), 0, 0xFF.toByte(), 0,
            0xFF.toByte(), 0xFF.toByte(), 0, 0,
            0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
        )
        val image = Image(data, 2, 2, 8, ImageFormat.ABGR)
        val bitmap = image.convertToBitmap()
        assertEquals(Color.RED, bitmap.getPixel(0, 0))
        assertEquals(Color.GREEN, bitmap.getPixel(1, 0))
        assertEquals(Color.BLUE, bitmap.getPixel(0, 1))
        assertEquals(Color.WHITE, bitmap.getPixel(1, 1))
    }

    @Test
    fun testConvertRGBAImageToBitmap() {
        val data = byteArrayOf(
            0xFF.toByte(), 0, 0, 0xFF.toByte(),
            0, 0xFF.toByte(), 0, 0xFF.toByte(),
            0, 0, 0xFF.toByte(), 0xFF.toByte(),
            0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
        )
        val image = Image(data, 2, 2, 8, ImageFormat.RGBA)
        val bitmap = image.convertToBitmap()
        assertEquals(Color.RED, bitmap.getPixel(0, 0))
        assertEquals(Color.GREEN, bitmap.getPixel(1, 0))
        assertEquals(Color.BLUE, bitmap.getPixel(0, 1))
        assertEquals(Color.WHITE, bitmap.getPixel(1, 1))
    }

    @Test
    fun testConvertBGRAImageToBitmap() {
        val data = byteArrayOf(
            0, 0, 0xFF.toByte(), 0xFF.toByte(),
            0, 0xFF.toByte(), 0, 0xFF.toByte(),
            0xFF.toByte(), 0, 0, 0xFF.toByte(),
            0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
        )
        val image = Image(data, 2, 2, 8, ImageFormat.BGRA)
        val bitmap = image.convertToBitmap()
        assertEquals(Color.RED, bitmap.getPixel(0, 0))
        assertEquals(Color.GREEN, bitmap.getPixel(1, 0))
        assertEquals(Color.BLUE, bitmap.getPixel(0, 1))
        assertEquals(Color.WHITE, bitmap.getPixel(1, 1))
    }

    @Test
    fun testConvertRGBImageToBitmap() {
        val data = byteArrayOf(
            0xFF.toByte(), 0, 0,
            0, 0xFF.toByte(), 0,
            0, 0, 0xFF.toByte(),
            0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
        )
        val image = Image(data, 2, 2, 6, ImageFormat.RGB)
        val bitmap = image.convertToBitmap()
        assertEquals(Color.RED, bitmap.getPixel(0, 0))
        assertEquals(Color.GREEN, bitmap.getPixel(1, 0))
        assertEquals(Color.BLUE, bitmap.getPixel(0, 1))
        assertEquals(Color.WHITE, bitmap.getPixel(1, 1))
    }

    @Test
    fun testConvertBGRImageToBitmap() {
        val data = byteArrayOf(
            0, 0, 0xFF.toByte(),
            0, 0xFF.toByte(), 0,
            0xFF.toByte(), 0, 0,
            0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
        )
        val image = Image(data, 2, 2, 8, ImageFormat.BGR)
        val bitmap = image.convertToBitmap()
        assertEquals(Color.RED, bitmap.getPixel(0, 0))
        assertEquals(Color.GREEN, bitmap.getPixel(1, 0))
        assertEquals(Color.BLUE, bitmap.getPixel(0, 1))
        assertEquals(Color.WHITE, bitmap.getPixel(1, 1))
    }

    @Test
    fun testConvertGrayscaleImageToBitmap() {
        val data = byteArrayOf(
            0xFF.toByte(),
            0xCC.toByte(),
            0x66.toByte(),
            0x00.toByte()
        )
        val image = Image(data, 2, 2, 2, ImageFormat.GRAYSCALE)
        val bitmap = image.convertToBitmap()
        assertEquals(Color.WHITE, bitmap.getPixel(0, 0))
        assertEquals(Color.rgb(0xCC, 0xCC, 0xCC), bitmap.getPixel(1, 0))
        assertEquals(Color.rgb(0x66, 0x66, 0x66), bitmap.getPixel(0, 1))
        assertEquals(Color.BLACK, bitmap.getPixel(1, 1))
    }
}