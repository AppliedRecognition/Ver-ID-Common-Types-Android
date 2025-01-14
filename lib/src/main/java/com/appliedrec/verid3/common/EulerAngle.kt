package com.appliedrec.verid3.common

data class EulerAngle<T>(val yaw: T, val pitch: T, val roll: T) where T : Number, T: Comparable<T>