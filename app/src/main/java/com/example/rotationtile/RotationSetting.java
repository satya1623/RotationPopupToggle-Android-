package com.example.rotationtile;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;

public final class RotationSetting {
    private RotationSetting() {}
    public static boolean permitted(Context c) {
        return c.checkSelfPermission("android.permission.WRITE_SECURE_SETTINGS") == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean enabled(Context c) {
        return Settings.Secure.getInt(c.getContentResolver(), "show_rotation_suggestions", 1) != 0;
    }
    public static boolean set(Context c, boolean enabled) {
        if (!permitted(c)) return false;
        try { return Settings.Secure.putInt(c.getContentResolver(), "show_rotation_suggestions", enabled ? 1 : 0); }
        catch (SecurityException e) { return false; }
    }
}
