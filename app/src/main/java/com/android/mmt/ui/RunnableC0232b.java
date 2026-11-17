package com.android.mmt.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.android.mmt.R;

/* renamed from: com.android.mmt.ui.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0232b implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ x0.j f5545i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ C0230a f5546j;

    /* renamed from: com.android.mmt.ui.b$a */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(RunnableC0232b.this.f5546j.f5506a, RunnableC0232b.this.f5546j.f5506a.getString(R.string.fail_to_view_attachment), 0).show();
        }
    }

    /* renamed from: com.android.mmt.ui.b$b, reason: collision with other inner class name */
    final class RunnableC0105b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Intent f5548i;

        RunnableC0105b(Intent intent) {
            this.f5548i = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                RunnableC0232b.this.f5546j.f5506a.startActivity(this.f5548i);
            } catch (ActivityNotFoundException unused) {
                this.f5548i.setPackage("");
                RunnableC0232b.this.f5546j.f5506a.startActivity(this.f5548i);
            }
        }
    }

    RunnableC0232b(C0230a c0230a, x0.j jVar) {
        this.f5546j = c0230a;
        this.f5545i = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        G0.k kVarT;
        if (this.f5545i.Q(false) == null) {
            Log.w("AttachmentProcessor", " persist fail!");
            this.f5546j.f5506a.runOnUiThread(new a());
            return;
        }
        G0.p pVarU = this.f5545i.u();
        if (pVarU == null || pVarU.size() == 0) {
            return;
        }
        G0.o oVar = pVarU.get(0);
        Intent intent = new Intent("android.intent.action.VIEW");
        G0.k kVarV = null;
        if (oVar.A()) {
            kVarV = oVar.v();
            str = P0.r.b(this.f5546j.f5506a) ? "com.google.android.apps.photos" : "com.google.android.apps.photosgo";
            intent.putExtra("com.miui.gallery.extra.preview_single_item", true);
        } else {
            if (oVar.C()) {
                kVarT = oVar.y();
            } else if (oVar.z()) {
                kVarT = oVar.t();
            } else {
                str = null;
            }
            kVarV = kVarT;
            str = null;
        }
        if (kVarV == null) {
            return;
        }
        intent.addFlags(1);
        intent.setDataAndType(kVarV.u(), kVarV.p());
        String strT = kVarV.t();
        if (!TextUtils.isEmpty(strT)) {
            intent.putExtra("display_name", strT);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        this.f5546j.f5506a.runOnUiThread(new RunnableC0105b(intent));
    }
}
