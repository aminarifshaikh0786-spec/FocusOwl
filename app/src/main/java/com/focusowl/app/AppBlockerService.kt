package com.focusowl.app

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast

class AppBlockerService : AccessibilityService() {

    // Apps that FocusOwl will block
    private val blockedApps = setOf(
        "com.google.android.youtube",
        "com.instagram.android",
        "com.whatsapp",
        "com.facebook.katana"
    )

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

        if (event == null) return

        val packageName = event.packageName?.toString() ?: return

        // Only block when a FocusOwl study session is active
        val prefs = getSharedPreferences("FocusOwl", MODE_PRIVATE)
        val focusActive = prefs.getBoolean("focus_active", false)

        if (focusActive && packageName in blockedApps) {

            Toast.makeText(
                this,
                "FocusOwl: App blocked during study session",
                Toast.LENGTH_SHORT
            ).show()

            // Send the user back to the Home screen
            performGlobalAction(GLOBAL_ACTION_HOME)
        }
    }

    override fun onInterrupt() {
        // Accessibility service interrupted
    }
}
