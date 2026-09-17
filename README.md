# FocusOwl Android App

This project wraps the FocusOwl web MVP in a real Android application shell.

## What works

- Native Android launcher app
- Full-screen FocusOwl UI
- Study timer and result flow
- Local session history
- Android camera permission
- WebView camera access
- Browser-side desk/object AI when the model loads
- Portrait phone layout

## Open in Android Studio

1. Install Android Studio.
2. Open this `FocusOwl_Android` folder.
3. Let Android Studio sync Gradle dependencies.
4. Connect an Android phone with USB debugging enabled, or create an emulator.
5. Press **Run**.
6. To create an APK: **Build → Build App Bundle(s) / APK(s) → Build APK(s)**.

The generated debug APK is normally under:

`app/build/outputs/apk/debug/app-debug.apk`

## Important production step

The current UI is packaged inside WebView so we can get from the prototype to an installable APK quickly.

For a production release, the next version should move the critical Android capabilities to native code:
- app usage monitoring
- distraction detection
- notifications
- optional app/site blocking using Android-supported APIs
- foreground service where justified
- robust on-device AI model bundled in the APK
- encrypted account/cloud sync if desired

The browser prototype cannot reliably block arbitrary Android apps by itself.

## AI privacy

The current desk verification analyzes the camera feed in the WebView. It does not send the captured frame to a FocusOwl backend. The object model is loaded from a CDN in this MVP; a production release should bundle a compatible on-device model to reduce dependency on network access.
