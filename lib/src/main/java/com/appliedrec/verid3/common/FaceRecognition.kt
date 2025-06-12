package com.appliedrec.verid3.common

interface FaceRecognition<V: FaceTemplateVersion, D> {

    val version: V

    suspend fun createFaceRecognitionTemplates(faces: Array<Face>, image: IImage): Array<FaceTemplate<V, D>>

    suspend fun compareFaceRecognitionTemplates(faceRecognitionTemplates: Array<FaceTemplate<V,D>>, template: FaceTemplate<V,D>): FloatArray
}