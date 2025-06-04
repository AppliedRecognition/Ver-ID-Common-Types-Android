# Ver-ID Common Types for Android

This library defines types that are common to various parts of the Ver-ID face detection and recognition SDK

## Purpose

The purpose of this library is to make different parts of the Ver-ID SDK interoperable and to reduce the number of dependencies needed for a given task. For example, the library defines a face detection interface. All face detection implementations available to the Ver-ID SDK conform to this interface. This makes it easy to swap the face detection for a different implementation that may be better suited for the particular use case.

## Essential types

- [`Image`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid3/common/Image.kt)<br>
Abstraction of an image type. This type is used by face detection and face recognition. The `Image` implements the `IImage` interface.
- [`IImage`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid3/common/IImage.kt)<br>
Image interface used in face detection and recognition
- [`Face`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid3/common/Face.kt)<br>
Represents a face detected in an `Image` by `FaceDetection`. This type is supplied along with `Image` to `FaceRecognition` to generate a `FaceRecognitionTemplate`.
- [`RecognizableFace`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid3/common/RecognizableFace.kt)<br>
Contains `Face` and its corresponding generic face template.
- [`FaceDetection`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid3/common/FaceDetection.kt)<br>
Face detection interface adopted by classes that detect faces in images.
- [`FaceRecognition`](https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android/blob/main/lib/src/main/java/com/appliedrec/verid3/common/FaceRecognition.kt)<br>
Face recognition interface adopted by classes that extract and compare face recognition templates.
