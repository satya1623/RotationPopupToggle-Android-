package com.example.rotationtile;

import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

public class RotationTileService extends TileService {
    @Override public void onStartListening() { super.onStartListening(); refresh(); }
    private void refresh() {
        Tile tile = getQsTile();
        if (tile == null) return;
        tile.setLabel(getString(R.string.app_name));
        tile.setIcon(Icon.createWithResource(this, R.drawable.ic_rotation_suggestion));
        tile.setState(!RotationSetting.permitted(this) ? Tile.STATE_UNAVAILABLE : RotationSetting.enabled(this) ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
        tile.updateTile();
    }
    @Override public void onClick() {
        super.onClick();
        if (!RotationSetting.permitted(this)) {
            // On Android 14+, opening an Activity directly from a tile is restricted.
            // Show unavailable status and let the user launch the app manually.
            refresh();
            return;
        }
        RotationSetting.set(this, !RotationSetting.enabled(this));
        refresh();
    }
}
