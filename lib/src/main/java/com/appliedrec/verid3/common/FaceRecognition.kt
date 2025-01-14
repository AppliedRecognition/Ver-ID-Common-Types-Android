package com.appliedrec.verid3.common

interface FaceRecognition<T> {

    suspend fun createFaceRecognitionTemplates(faces: Array<Face>, image: IImage): Array<T>

    suspend fun compareFaceRecognitionTemplates(faceRecognitionTemplates: Array<T>, template: T): FloatArray
}