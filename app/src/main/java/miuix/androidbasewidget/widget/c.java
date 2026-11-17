package miuix.androidbasewidget.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public final class c extends b {

    public static abstract class a {
        public a(Context context, AttributeSet attributeSet) {
        }

        protected abstract Drawable[] getWidgetDrawables();

        protected void onAttached(c cVar) {
        }

        protected void onDetached() {
        }

        protected abstract void onPopulateNodeForVirtualView(int i2, F.b bVar);

        protected abstract void onWidgetClick(int i2);
    }
}
