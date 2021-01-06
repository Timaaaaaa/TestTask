package com.start.testtask.global.utils

import com.start.testtask.global.system.ResourceManager


class ErrorHandler(private val resourceManager: ResourceManager) {

    fun proceed(error: Throwable, messageListener: (String) -> Unit = {}) {
        //messageListener(error.errorMessage(resourceManager))
    }
}