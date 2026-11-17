package androidx.fragment.app;

import B.a;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0207c;

/* renamed from: androidx.fragment.app.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0211g implements a.InterfaceC0000a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f3529a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewGroup f3530b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0207c.b f3531c;

    C0211g(View view, ViewGroup viewGroup, C0207c.b bVar) {
        this.f3529a = view;
        this.f3530b = viewGroup;
        this.f3531c = bVar;
    }

    @Override // B.a.InterfaceC0000a
    public final void a() {
        this.f3529a.clearAnimation();
        this.f3530b.endViewTransition(this.f3529a);
        this.f3531c.a();
    }
}
