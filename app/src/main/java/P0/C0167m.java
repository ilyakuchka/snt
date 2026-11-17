package P0;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import com.android.mmt.util.EditableListViewV2;

/* renamed from: P0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0167m extends EditableListViewV2 {
    public C0167m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void N1(boolean z4) {
        this.f5850N0 = z4;
    }

    @Override // android.view.View
    public final boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        return super.onKeyShortcut(i2, keyEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected final void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        if (this.f5850N0) {
            if (i5 == 0 || i5 == i2) {
                this.f5850N0 = false;
                return;
            }
            Log.v("MessageListView", "oldw is " + i5 + " w is " + i2);
        }
    }
}
