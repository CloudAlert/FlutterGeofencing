// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package eu.cloudalert.plugins.geofencing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class GeofencingRebootBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        //if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {

        Log.e("GEOFENCING REBOOT", "Setting boot completed marker!")
        // Write a bootreceivedmarker to sharedprefs
        context.getSharedPreferences("FlutterSharedPreferences", Context.MODE_PRIVATE)
            .edit()
            .putBoolean(GeofencingPlugin.BOOTCOMPLETED_RECEIVED_MARKER, true)
            .apply()


        Log.e("GEOFENCING REBOOT", "Reregistering geofences!")
            GeofencingPlugin.reRegisterAfterReboot(context)
        //}
    }
}
