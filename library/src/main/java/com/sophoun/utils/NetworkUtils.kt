package com.sophoun.utils

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.ResponseBody
import java.io.File
import java.io.FileOutputStream

object NetworkUtils {
    fun isNetworkConnected(context: Context): Boolean {
        val networkService = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = networkService.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    /**
     * Save response body to specific file with progressing callback
     * @param filePath Path of file that store the response body
     * @param responseBody Response body from network call
     * @param progress Progressing percent callback
     */
    fun saveResponseBodyToFile(filePath: String, responseBody: ResponseBody, progress: (percent: Long) -> Unit) {
        responseBody.let { body ->
            File(filePath).let { file ->
                val outputStream = FileOutputStream(file)
                body.source().also {
                    val buffer = ByteArray(4096)
                    var totalBytesRead = 0L
                    while (true) {
                        val byteRead = it.read(buffer)
                        if (byteRead < 0) {
                            break
                        }
                        outputStream.write(buffer, 0, byteRead)
                        // Downloading progress in percent
                        totalBytesRead += byteRead
                        val percent = (totalBytesRead * 100 ) / body.contentLength()
                        progress(percent)
                    }
                }
                outputStream.flush()
                outputStream.close()
            }
        }
    }
}