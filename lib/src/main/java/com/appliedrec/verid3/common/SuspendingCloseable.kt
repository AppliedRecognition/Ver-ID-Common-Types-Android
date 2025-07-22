package com.appliedrec.verid3.common

interface SuspendingCloseable {

    suspend fun close() {}
}

suspend inline fun <T : SuspendingCloseable, R> T.use(block: suspend (T) -> R): R {
    try {
        return block(this)
    } finally {
        close()
    }
}