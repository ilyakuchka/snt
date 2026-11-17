package com.android.mmt.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l;
import com.android.mmt.R;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public class ConfirmRateLimitActivity extends miuix.appcompat.app.h {

    /* renamed from: v, reason: collision with root package name */
    private a f4710v;

    public static class a extends DialogInterfaceOnCancelListenerC0216l {

        /* renamed from: r0, reason: collision with root package name */
        private long f4711r0;

        /* renamed from: s0, reason: collision with root package name */
        private Handler f4712s0;

        /* renamed from: t0, reason: collision with root package name */
        private Runnable f4713t0;

        /* renamed from: com.android.mmt.ui.ConfirmRateLimitActivity$a$a, reason: collision with other inner class name */
        final class ViewOnClickListenerC0092a implements View.OnClickListener {
            ViewOnClickListenerC0092a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.j1(true);
            }
        }

        final class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.j1(false);
            }
        }

        final class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.j1(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j1(boolean z4) {
            Intent intent = new Intent("com.android.mmt.RATE_LIMIT_CONFIRMED");
            intent.putExtra("answer", z4);
            x().sendBroadcast(intent);
            x().finish();
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l
        public final Dialog e1(Bundle bundle) {
            View viewInflate = LayoutInflater.from(x()).inflate(R.layout.confirm_rate_limit_activity, (ViewGroup) null, false);
            ((Button) viewInflate.findViewById(R.id.btn_yes)).setOnClickListener(new ViewOnClickListenerC0092a());
            ((Button) viewInflate.findViewById(R.id.btn_no)).setOnClickListener(new b());
            this.f4712s0 = new Handler();
            this.f4713t0 = new c();
            this.f4711r0 = System.currentTimeMillis();
            g.a aVar = new g.a(x());
            aVar.z(viewInflate);
            return aVar.a();
        }

        @Override // androidx.fragment.app.Fragment
        public final void n0() {
            super.n0();
            Handler handler = this.f4712s0;
            if (handler != null) {
                handler.removeCallbacks(this.f4713t0);
            }
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            if (x().isFinishing()) {
                return;
            }
            x().finish();
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            if (x().isFinishing()) {
                return;
            }
            x().finish();
        }

        @Override // androidx.fragment.app.Fragment
        public final void p0() {
            super.p0();
            long jCurrentTimeMillis = (this.f4711r0 - System.currentTimeMillis()) + 19500;
            if (jCurrentTimeMillis <= 0) {
                j1(false);
                return;
            }
            Handler handler = this.f4712s0;
            if (handler != null) {
                handler.postDelayed(this.f4713t0, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.fragment.app.w wVarU = u();
        a aVar = (a) wVarU.T("dialog");
        androidx.fragment.app.E eF = wVarU.f();
        if (aVar != null) {
            eF.n(aVar);
            eF.h();
        }
        a aVar2 = new a();
        this.f4710v = aVar2;
        aVar2.h1(wVarU, "dialog");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        a aVar;
        if (i2 == 4 && keyEvent.getRepeatCount() == 0 && (aVar = this.f4710v) != null) {
            aVar.j1(false);
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
