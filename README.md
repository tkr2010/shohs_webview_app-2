Shohs WebView App
=================

This is a minimal Android Studio (Kotlin) app that opens https://shohs.ddns.net in a WebView.

How to build
------------
1. Install Android Studio (Arctic Fox or later recommended).
2. Open the project folder `shohs_webview_app` in Android Studio.
3. Let Gradle sync and download required components.
4. Connect a device or start an emulator, then Build > Run.

Notes
-----
- The app requests INTERNET permission.
- `android:usesCleartextTraffic="true"` is set in the manifest to allow HTTP if your site is not HTTPS.
- If you want an APK generated here, I cannot compile on this environment. Build in Android Studio to get the .apk.
