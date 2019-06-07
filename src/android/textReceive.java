package com.preet.textreceive;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.Toast;
import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

/**
 * This class echoes a string called from JavaScript.
 */
public class textReceive extends CordovaPlugin {

    private CallbackContext cb;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.cb = callbackContext;
        if (action.equals("listenForTextIntents")) {
            Intent intent = this.cordova.getActivity().getIntent();
            String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
            String message = args.getString(0);
            if (sharedText != null) {
                intent.removeExtra(Intent.EXTRA_TEXT);
                this.cb.success(sharedText);
            } else {
                this.cb.error("Text is null");
            }
            return true;
        }
        return false;
    }

    @Override
    public void onNewIntent(Intent intent) {
        String action = intent.getAction();
        String type = intent.getType();
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            if (this.cb != null) {
                intent.removeExtra(Intent.EXTRA_TEXT);
                this.cb.success(sharedText);
            } else {
                this.cb.error("Textis null 2");
            }
        }
    }

    private void t(String msg) {
        Context context = this.cordova.getActivity().getApplicationContext();
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
