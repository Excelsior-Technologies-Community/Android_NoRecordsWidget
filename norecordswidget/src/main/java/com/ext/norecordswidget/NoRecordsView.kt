package com.ext.norecordswidget

import android.content.Context
import android.graphics.Color
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

        // Load Custom Attributes
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.NoRecordsView
            )

            // Title Text
            val titleText = typedArray.getString(R.styleable.NoRecordsView_titleText)
            titleText?.let { text ->
                title.text = text
            }

            // Subtitle Text
            val subtitleText =
                typedArray.getString(R.styleable.NoRecordsView_subtitleText)
            subtitleText?.let { text ->
                subtitle.text = text
            }

            // Icon Source
            val iconRes =
                typedArray.getResourceId(R.styleable.NoRecordsView_iconSrc, -1)
            if (iconRes != -1) {
                icon.setImageResource(iconRes)
            }

            // Show Retry Button
            val showRetry =
                typedArray.getBoolean(R.styleable.NoRecordsView_showRetryButton, false)
            retryButton.visibility = if (showRetry) VISIBLE else GONE

            // Retry Button Text
            val retryText =
                typedArray.getString(R.styleable.NoRecordsView_retryButtonText)
            retryText?.let { text ->
                retryButton.text = text
            }

            // Retry Button Background Color
            val retryBgColor =
                typedArray.getColor(
                    R.styleable.NoRecordsView_retryButtonBgColor,
                    Color.GRAY
                )
            retryButton.setBackgroundColor(retryBgColor)

            typedArray.recycle()
        }
    }

    // Public Functions

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
