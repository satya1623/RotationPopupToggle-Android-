# Rotation Popup Toggle Quick Settings Tile (Java)

Got fed up with Android's rotation suggestion popup appearing over my keyboard, with no option to reposition it. So I built **Rotation Popup Toggle**, a lightweight Java Android app that lets users enable or disable rotation suggestions directly from Quick Settings.

## Setup & Usage

Open this folder as a project in Android Studio. Allow Gradle sync. Build > Build APK(s), then install the debug APK.

### One-time ADB grant from a connected PC:

```sh
adb shell pm grant com.example.rotationtile android.permission.WRITE_SECURE_SETTINGS
```

Open Quick Settings > Edit and add **Rotation Popup Toggle**. Tap to toggle the `Settings.Secure` key `show_rotation_suggestions` (1/0).

If the ADB grant returns `SecurityException`, the phone's firmware may block this permission. The app cannot bypass it without a different privileged mechanism. OEM firmware may ignore this setting, and tiles may be cached until panel reopening.

## License

[MIT License](LICENSE)
