package miuix.appcompat.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import miuix.appcompat.app.f;

/* loaded from: classes.dex */
public class DialogRootView extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private a f7074i;

    public interface a {
    }

    public DialogRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(a aVar) {
        this.f7074i = aVar;
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a aVar = this.f7074i;
        if (aVar != null) {
            ((f) aVar).a(configuration);
        }
    }
}
