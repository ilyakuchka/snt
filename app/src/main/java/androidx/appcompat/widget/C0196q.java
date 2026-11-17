package androidx.appcompat.widget;

import G.a;
import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.c;

/* renamed from: androidx.appcompat.widget.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0196q implements a.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f3040a;

    C0196q(View view) {
        this.f3040a = view;
    }

    @Override // G.a.b
    public final boolean a(G.b bVar, int i2, Bundle bundle) {
        if ((i2 & 1) != 0) {
            try {
                bVar.d();
                InputContentInfo inputContentInfo = (InputContentInfo) bVar.e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
            } catch (Exception e2) {
                Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e2);
                return false;
            }
        }
        c.a aVar = new c.a(new ClipData(bVar.b(), new ClipData.Item(bVar.a())), 2);
        aVar.d(bVar.c());
        aVar.b(bundle);
        return androidx.core.view.o.h(this.f3040a, aVar.a()) == null;
    }
}
