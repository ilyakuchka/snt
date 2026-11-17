package v;

import android.app.Notification;

/* renamed from: v.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0399f extends h {

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f7938b;

    @Override // v.h
    public final void a(InterfaceC0397d interfaceC0397d) {
        new Notification.BigTextStyle(((i) interfaceC0397d).b()).setBigContentTitle(null).bigText(this.f7938b);
    }

    public final C0399f b(CharSequence charSequence) {
        this.f7938b = g.c(charSequence);
        return this;
    }
}
