package com.start.testtask.global.base

import android.view.ViewGroup

class ZeroViewHolder (
        private val view: ViewGroup,
        private val refreshListener: () -> Unit = {}
) {

    /*private val res = view.resources

    init {
        view.refreshButton.setOnClickListener { refreshListener() }
    }

    fun showEmptyData() {
        view.titleTextView.text = res.getText(R.string.empty_data)
        view.descriptionTextView.text = res.getText(R.string.empty_data_description)
        view.visible(true)
    }

    fun showEmptyError(msg: String? = null) {
        view.titleTextView.text = res.getText(R.string.empty_error)
        view.descriptionTextView.text = msg ?: res.getText(R.string.empty_error_description)
        view.visible(true)
    }

    fun hide() {
        view.visible(false)
    }*/
}