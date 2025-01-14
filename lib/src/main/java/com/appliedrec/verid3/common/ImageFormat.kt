package com.appliedrec.verid3.common

enum class ImageFormat {
    /// RGB – red, gree, blue
    RGB,
    /// BRG – blue, green, red
    BGR,
    /// ARGB – alpha, red, green, blue
    ARGB,
    /// BGRA – blue, green, red, alpha
    BGRA,
    /// ABGR – alpha, blue, green, red
    ABGR,
    /// RGBA – red, green, blue, alpha
    RGBA,
    /// Grayscale
    GRAYSCALE;

    val bitsPerPixel: Int
        get() {
            return when (this) {
                ARGB, BGRA, ABGR, RGBA -> 32
                RGB, BGR -> 24
                else -> 8
            }
        }

    val bytesPerPixel: Int
        get() = this.bitsPerPixel / 8
}