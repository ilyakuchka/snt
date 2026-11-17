package com.android.mmt.util;

import android.widget.ImageView;
import com.android.mmt.R;

/* renamed from: com.android.mmt.util.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0291x {

    /* renamed from: a, reason: collision with root package name */
    private miuix.appcompat.app.h f6051a;

    /* renamed from: b, reason: collision with root package name */
    private miuix.appcompat.app.b f6052b;

    public C0291x(miuix.appcompat.app.h hVar, miuix.appcompat.app.b bVar) {
        this.f6051a = hVar;
        this.f6052b = bVar;
    }

    public final void b() {
        ImageView imageView = new ImageView(this.f6051a);
        if (e0.h()) {
            imageView.setBackgroundResource(R.drawable.miuix_appcompat_icon_settings_dark);
        } else {
            imageView.setBackgroundResource(R.drawable.miuix_appcompat_icon_settings_light);
        }
        imageView.setContentDescription(this.f6051a.getResources().getString(R.string.menu_preferences));
        imageView.setOnClickListener(new ViewOnClickListenerC0290w(this));
        this.f6052b.t(imageView);
    }

    public final void c() {
        if (this.f6052b.r()) {
            this.f6051a.u();
        }
        miuix.appcompat.app.b bVar = this.f6052b;
        bVar.h(bVar.a() | 8);
        this.f6052b.k(0);
    }
}
