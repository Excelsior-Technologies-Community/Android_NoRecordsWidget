package com.ext.android_norecordswidget

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.norecordswidget.NoRecordsView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val noView = findViewById<NoRecordsView>(R.id.noRecordsView)
        noView.setTitle("No Orders Found")
        noView.setSubtitle("You have not placed any orders yet.")
        noView.showRetryButton(true)

        // Retry click
        noView.setOnRetryClick {
            Toast.makeText(this, "Retry Clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}