package com.appliedrec.verid.common

interface FaceRecognition {

    fun createFaceRecognitionTemplates(faces: Array<Face>, image: Image): Array<FaceRecognitionTemplate>

    fun compareFaceRecognitionTemplates(faceRecognitionTemplates: Array<FaceRecognitionTemplate>, template: FaceRecognitionTemplate): Float
}