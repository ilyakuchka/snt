package com.android.mmt.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.mmt.R;
import f0.C0303b;
import g0.C0318n;
import miuix.appcompat.app.g;

/* renamed from: com.android.mmt.util.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0273e {

    /* renamed from: com.android.mmt.util.e$a */
    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f5959i;

        a(Context context) {
            this.f5959i = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(this.f5959i, R.string.compressing, 0).show();
        }
    }

    /* renamed from: com.android.mmt.util.e$b */
    final class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f5960i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Uri f5961j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Handler f5962k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Runnable f5963l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ InterfaceC0107e f5964m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ boolean f5965n;

        /* renamed from: com.android.mmt.util.e$b$a */
        final class a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ C0318n f5966i;

            a(C0318n c0318n) {
                this.f5966i = c0318n;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                bVar.f5964m.a(this.f5966i, bVar.f5965n);
            }
        }

        b(Context context, Uri uri, Handler handler, Runnable runnable, InterfaceC0107e interfaceC0107e, boolean z4) {
            this.f5960i = context;
            this.f5961j = uri;
            this.f5962k = handler;
            this.f5963l = runnable;
            this.f5964m = interfaceC0107e;
            this.f5965n = z4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0318n c0318nD;
            try {
                try {
                    P0.M m2 = new P0.M(this.f5960i, this.f5961j);
                    int i2 = k0.d.i();
                    int iH = k0.d.h();
                    if (m2.c() > m2.g()) {
                        iH = i2;
                        i2 = iH;
                    }
                    c0318nD = m2.d(i2, iH, k0.d.j() - 5000);
                } catch (C0303b e2) {
                    e2.printStackTrace();
                    this.f5962k.removeCallbacks(this.f5963l);
                    c0318nD = null;
                }
                this.f5962k.post(new a(c0318nD));
            } finally {
                this.f5962k.removeCallbacks(this.f5963l);
            }
        }
    }

    /* renamed from: com.android.mmt.util.e$c */
    final class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Drawable f5968i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ImageView f5969j;

        c(Drawable drawable, ImageView imageView) {
            this.f5968i = drawable;
            this.f5969j = imageView;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ((AnimationDrawable) this.f5968i).start();
            this.f5969j.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* renamed from: com.android.mmt.util.e$d */
    final class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -1) {
                dialogInterface.dismiss();
            }
        }
    }

    /* renamed from: com.android.mmt.util.e$e, reason: collision with other inner class name */
    public interface InterfaceC0107e {
        void a(C0318n c0318n, boolean z4);
    }

    public static void a(Context context, Uri uri, Handler handler, InterfaceC0107e interfaceC0107e, boolean z4) {
        a aVar = new a(context);
        handler.postDelayed(aVar, 1000L);
        Q2.c.a(new b(context, uri, handler, aVar, interfaceC0107e, z4));
    }

    public static void b(Context context) {
        d(context, 104, "audio/*", true);
    }

    public static void c(Context context) {
        d(context, 100, "image/*", false);
    }

    private static void d(Context context, int i2, String str, boolean z4) {
        if (context instanceof Activity) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType(str);
            if (z4) {
                intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
            }
            ((Activity) context).startActivityForResult(intent, i2);
        }
    }

    public static void e(Context context) {
        d(context, 102, "video/*", true);
    }

    public static void f(ImageView imageView, Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.getViewTreeObserver().addOnPreDrawListener(new c(drawable, imageView));
        }
    }

    public static void g(Context context, String str, String str2) {
        g.a aVar = new g.a(context);
        aVar.f();
        aVar.y(str);
        aVar.k(str2);
        aVar.t(android.R.string.ok, new d());
        if (!(context instanceof Activity)) {
            aVar.A();
        } else {
            if (((Activity) context).isDestroyed()) {
                return;
            }
            aVar.A();
        }
    }
}
