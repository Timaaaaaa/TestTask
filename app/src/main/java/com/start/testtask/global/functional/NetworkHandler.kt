package com.start.testtask.global.functional

import android.content.Context
import com.start.testtask.global.extension.networkInfo

class NetworkHandler(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnected
}