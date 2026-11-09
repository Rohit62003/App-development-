package com.example.webviewapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val web = findViewById<WebView>(R.id.webapp)
        webviewSetup(web)
    }
        @SuppressLint("SetJavaScriptEnabled")
        private fun webviewSetup(a: WebView) {
            a.webViewClient = WebViewClient()

            a.apply {
                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true
                loadUrl("https://github.com/Rohit62003")
            }
        }
    }


