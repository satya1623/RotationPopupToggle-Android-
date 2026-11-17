# Rotation Popup Toggle — Android

Works for **Oneplus Realme Oppo** and other android os as well you just have to find a way to grant adb permission

Got fed up with Android's rotation suggestion popup appearing over my keyboard, with no option to reposition it. So I built **Rotation Popup Toggle**, a lightweight Java Android app that lets users enable or disable rotation suggestions directly from Quick Settings.



<img width="400" height="147" alt="1776373907377356803" src="https://github.com/user-attachments/assets/7b120bc5-bc95-4d34-acf6-84adba6e589c" />



## Features
- Enable or disable rotation suggestions from Quick Settings.
- Lightweight 
- No unnecessary background services.
- Simple ON/OFF toggle.

## Setup & Usage

1. Download and install the APK from **Releases**.
2. Open **Developer Options** on your phone.
3. Enable **USB Debugging**.
4. Disable **Permission Monitoring** in developer options (depends on your phone model).
5. Connect your phone to your PC and FORCE STOP installed app once (Rotation Popup Toggle apk)
6. Open ADB and run:

   `adb shell pm grant com.example.rotationtile android.permission.WRITE_SECURE_SETTINGS`

7. Add **Rotation Popup Toggle** to your Quick Settings panel.
8. Tap the tile to enable or disable rotation suggestions.

## How It Works

- **ON:** Rotation suggestion popup is enabled.
- **OFF:** Rotation suggestion popup is disabled.

## Compatibility

- Android 7.0 and above.
- Requires `WRITE_SECURE_SETTINGS` permission.
- Some manufacturers restrict ADB permission grants.

## License

Licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.
