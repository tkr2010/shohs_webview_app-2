package com.example.shohs

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout

import android.widget.LinearLayout
import android.widget.FrameLayout
import android.widget.Toast

import androidx.core.view.isVisible

import android.widget.RelativeLayout
import android.widget.TextView
import android.view.Gravity
import android.graphics.Color

import androidx.appcompat.widget.Toolbar

import android.webkit.WebResourceRequest
import android.os.Build
import android.net.Uri

import android.view.ViewGroup
import androidx.core.content.ContextCompat

import android.widget.ImageButton
import android.view.LayoutInflater

import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.appcompat.app.AlertDialog

import android.content.pm.PackageManager

import kotlinx.coroutines.*

import androidx.appcompat.app.ActionBar

import android.view.KeyEvent

import android.view.inputmethod.EditorInfo
import android.widget.EditText

import androidx.constraintlayout.widget.ConstraintSet

import android.content.Intent

import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        val progress = findViewById<ProgressBar>(R.id.progressBar)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }
        }
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                progress.progress = newProgress
                progress.isVisible = newProgress < 100
            }
        }

        val ws: WebSettings = webView.settings
        ws.javaScriptEnabled = true
        ws.domStorageEnabled = true
        ws.useWideViewPort = true
        ws.loadWithOverviewMode = true

        // Load the target site
        webView.loadUrl("https://shohs.ddns.net")
    }

    override fun onBackPressed() {
        if (this::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
