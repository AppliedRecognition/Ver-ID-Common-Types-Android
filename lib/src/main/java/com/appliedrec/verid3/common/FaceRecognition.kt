package com.appliedrec.verid3.common

interface FaceRecognition<V: FaceTemplateVersion<D>, D> : SuspendingCloseable {

    val version: V

    val defaultThreshold: Float

    suspend fun createFaceRecognitionTemplates(faces: List<Face>, image: IImage): List<FaceTemplate<V, D>>

    suspend fun compareFaceRecognitionTemplates(faceRecognitionTemplates: List<FaceTemplate<V,D>>, template: FaceTemplate<V,D>): FloatArray
}