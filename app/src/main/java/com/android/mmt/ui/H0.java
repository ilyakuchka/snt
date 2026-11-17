package com.android.mmt.ui;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.android.mmt.R;
import com.android.mmt.ui.I0;
import com.android.mmt.ui.SlideshowActivity;
import java.util.ArrayList;
import java.util.Iterator;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public final /* synthetic */ class H0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4847i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ I0 f4848j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4849k;

    public /* synthetic */ H0(I0 i02, Drawable drawable) {
        this.f4848j = i02;
        this.f4849k = drawable;
    }

    public /* synthetic */ H0(SlideshowActivity.a.b.RunnableC0101a runnableC0101a, I0 i02) {
        this.f4849k = runnableC0101a;
        this.f4848j = i02;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f4847i) {
            case 0:
                I0 i02 = this.f4848j;
                Drawable drawable = (Drawable) this.f4849k;
                if (i02.f4856k != null && !((ArrayList) i02.f4856k).isEmpty()) {
                    Iterator it = ((ArrayList) i02.f4856k).iterator();
                    while (it.hasNext()) {
                        I0.b bVar = (I0.b) it.next();
                        Log.d("SimplePduPart", "update ui with listener: " + bVar);
                        bVar.a(drawable);
                    }
                    break;
                }
                break;
            default:
                SlideshowActivity.a.b.RunnableC0101a runnableC0101a = (SlideshowActivity.a.b.RunnableC0101a) this.f4849k;
                I0 i03 = this.f4848j;
                SlideshowActivity.a aVar = SlideshowActivity.a.this;
                String strZ = P0.r.z(SlideshowActivity.this, i03, aVar.f5441b);
                g.a aVar2 = new g.a(SlideshowActivity.this);
                aVar2.x(R.string.copy_to_sdcard);
                aVar2.h();
                if (strZ != null) {
                    aVar2.k(SlideshowActivity.this.getString(R.string.copy_to_sdcard_success, strZ));
                } else {
                    aVar2.j(R.string.copy_to_sdcard_fail);
                }
                aVar2.o(null);
                aVar2.A();
                break;
        }
    }
}
