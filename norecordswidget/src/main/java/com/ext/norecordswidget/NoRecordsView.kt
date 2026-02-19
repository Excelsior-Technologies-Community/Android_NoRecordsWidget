package com.ext.norecordswidget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class NoRecordsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val icon: ImageView
    private val title: TextView
    private val subtitle: TextView
    private val retryButton: Button

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.widget_no_records, this, true)

        icon = findViewById(R.id.noRecordsIcon)
        title = findViewById(R.id.noRecordsTitle)
        subtitle = findViewById(R.id.noRecordsSubtitle)
        retryButton = findViewById(R.id.retryButton)
    }

    fun setTitle(text: String) {
        title.text = text
    }

    fun setSubtitle(text: String) {
        subtitle.text = text
    }

    fun showRetryButton(show: Boolean) {
        retryButton.visibility = if (show) VISIBLE else GONE
    }

    fun setOnRetryClick(listener: () -> Unit) {
        retryButton.setOnClickListener {
            listener()
        }
    }
}
