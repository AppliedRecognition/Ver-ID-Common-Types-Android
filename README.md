# Ver-ID Common Types for Android

This library defines types that are common to various parts of the Ver-ID face detection and recognition SDK

## Purpose

The purpose of this library is to make different parts of the Ver-ID SDK interoperable and to reduce the number of dependencies needed for a given task. For example, the library defines a face detection interface. All face detection implementations available to the Ver-ID SDK conform to this interface. This makes it easy to swap the face detection for a different implementation that may be better suited for the particular use case.

## Essential types

- [`Image`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid/common/Image.kt)<br>
Abstraction of an image type. This type is used by face detection and face recognition. The `Image` implements the `ImageConvertible` interface.
- [`ImageConvertible`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid/common/ImageConvertible.kt)<br>
Interface that defines methods to convert to [Image](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid/common/Image.kt) and to Android Bitmap
- [`BitmapImage`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid/common/BitmapImage.kt)<br>
`ImageConvertible` implementation that accepts Android Bitmap in its constructor.
- [`Face`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid/common/Face.kt)<br>
Represents a face detected in an `Image` by `FaceDetection`. This type is supplied along with `Image` to `FaceRecognition` to generate a `FaceRecognitionTemplate`.
- [`FaceRecognitionTemplate`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid/common/FaceRecognitionTemplate.kt)<br>
Template that is used by `FaceRecognition` for face comparisons.
- [`RecognizableFace`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid/common/RecognizableFace.kt)<br>
Contains `Face` and its corresponding `FaceRecognitionTemplate`.
- [`FaceDetection`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid/common/FaceDetection.kt)<br>
Face detection interface adopted by classes that detect faces in images.
- [`FaceRecognition`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid/common/FaceRecognition.kt)<br>
Face recognition interface adopted by classes that extract and compare `FaceRecognitionTemplate`s.
