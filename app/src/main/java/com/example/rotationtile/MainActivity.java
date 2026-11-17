package com.example.rotationtile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView status;
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        int p = (int)(24 * getResources().getDisplayMetrics().density);
        layout.setPadding(p,p,p,p);
        status = new TextView(this);
        status.setTextSize(18);
        layout.addView(status);
        Button toggle = new Button(this);
        toggle.setText("Toggle rotation popup");
        layout.addView(toggle);
        toggle.setOnClickListener(v -> {
            boolean ok = RotationSetting.set(this, !RotationSetting.enabled(this));
            showStatus(ok ? "Updated. " : "Could not update setting. ");
        });
        TextView help = new TextView(this);
        help.setText("One-time PC command after installation:\n\nadb shell pm grant com.example.rotationtile android.permission.WRITE_SECURE_SETTINGS\n\nThen edit Quick Settings and add the Rotation Popup tile. If the grant fails, your firmware may block this method.");
        layout.addView(help);
        setContentView(layout);
    }
    @Override protected void onResume() { super.onResume(); showStatus(""); }
    private void showStatus(String prefix) {
        status.setText(prefix + (RotationSetting.permitted(this) ? "Rotation popup: " + (RotationSetting.enabled(this) ? "ON" : "OFF") : "ADB permission required"));
    }
}
