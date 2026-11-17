package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.appcompat.widget.C0199u;

/* renamed from: androidx.appcompat.widget.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0198t extends F {

    /* renamed from: r, reason: collision with root package name */
    final /* synthetic */ C0199u.d f3046r;

    /* renamed from: s, reason: collision with root package name */
    final /* synthetic */ C0199u f3047s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0198t(C0199u c0199u, View view, C0199u.d dVar) {
        super(view);
        this.f3047s = c0199u;
        this.f3046r = dVar;
    }

    @Override // androidx.appcompat.widget.F
    public final m.b b() {
        return this.f3046r;
    }

    @Override // androidx.appcompat.widget.F
    @SuppressLint({"SyntheticAccessor"})
    public final boolean c() {
        if (this.f3047s.b().isShowing()) {
            return true;
        }
        this.f3047s.c();
        return true;
    }
}
