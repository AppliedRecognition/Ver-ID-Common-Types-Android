package com.appliedrec.verid3.common

interface FaceDetection {

    suspend fun detectFacesInImage(image: IImage, limit: Int): Array<Face>
}