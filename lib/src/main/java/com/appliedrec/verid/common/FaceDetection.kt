package com.appliedrec.verid.common

interface FaceDetection {

    fun detectFacesInImage(image: Image, limit: Int): Array<Face>
}