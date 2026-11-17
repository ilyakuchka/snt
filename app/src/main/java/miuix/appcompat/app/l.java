package miuix.appcompat.app;

import android.content.Context;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

/* loaded from: classes.dex */
public interface l {
    boolean g(Menu menu);

    Context i();

    View o(LayoutInflater layoutInflater);

    void onActionModeFinished(ActionMode actionMode);

    void onActionModeStarted(ActionMode actionMode);

    boolean onCreatePanelMenu(int i2, Menu menu);

    void s();
}
