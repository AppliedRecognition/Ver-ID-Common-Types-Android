package com.appliedrec.verid3.common

abstract class FaceTemplate<V: FaceTemplateVersion<D>, D>(
    val version: V,
    val data: D
) {
    abstract override fun equals(other: Any?): Boolean
    abstract override fun hashCode(): Int
}
