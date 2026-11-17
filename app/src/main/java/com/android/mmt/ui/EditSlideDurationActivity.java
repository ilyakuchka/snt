package com.android.mmt.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public class EditSlideDurationActivity extends miuix.appcompat.app.h {

    public static class a extends DialogInterfaceOnCancelListenerC0216l {

        /* renamed from: r0, reason: collision with root package name */
        private EditText f4771r0;

        /* renamed from: s0, reason: collision with root package name */
        private int f4772s0;

        /* renamed from: t0, reason: collision with root package name */
        private int f4773t0;

        /* renamed from: u0, reason: collision with root package name */
        private Bundle f4774u0;

        /* renamed from: v0, reason: collision with root package name */
        private final View.OnKeyListener f4775v0 = new ViewOnKeyListenerC0093a();

        /* renamed from: w0, reason: collision with root package name */
        private final View.OnClickListener f4776w0 = new b();

        /* renamed from: com.android.mmt.ui.EditSlideDurationActivity$a$a, reason: collision with other inner class name */
        final class ViewOnKeyListenerC0093a implements View.OnKeyListener {
            ViewOnKeyListenerC0093a() {
            }

            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i2 == 23) {
                    a.this.i1();
                }
                return false;
            }
        }

        final class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.i1();
            }
        }

        private void j1(int i2) {
            this.f4771r0.requestFocus();
            this.f4771r0.selectAll();
            Toast.makeText(MmsApp.c(), i2, 0).show();
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l
        public final Dialog e1(Bundle bundle) {
            int intExtra;
            View viewInflate = LayoutInflater.from(x()).inflate(R.layout.edit_slide_duration, (ViewGroup) null, false);
            com.android.mmt.util.e0.i(x());
            if (bundle == null) {
                Intent intent = x().getIntent();
                this.f4772s0 = intent.getIntExtra("slide_index", 1);
                this.f4773t0 = intent.getIntExtra("slide_total", 1);
                intExtra = intent.getIntExtra("dur", 8);
            } else {
                Bundle bundle2 = bundle.getBundle("state");
                this.f4774u0 = bundle2;
                this.f4772s0 = bundle2.getInt("slide_index", 1);
                this.f4773t0 = this.f4774u0.getInt("slide_total", 1);
                intExtra = this.f4774u0.getInt("dur", 8);
            }
            ((TextView) viewInflate.findViewById(R.id.label)).setText(Q(R.string.duration_selector_title) + " " + (this.f4772s0 + 1) + "/" + this.f4773t0);
            EditText editText = (EditText) viewInflate.findViewById(R.id.text);
            this.f4771r0 = editText;
            editText.setText(String.valueOf(intExtra));
            EditText editText2 = this.f4771r0;
            editText2.setSelection(editText2.length());
            this.f4771r0.setOnKeyListener(this.f4775v0);
            ((Button) viewInflate.findViewById(R.id.done)).setOnClickListener(this.f4776w0);
            g.a aVar = new g.a(x());
            aVar.z(viewInflate);
            miuix.appcompat.app.g gVarA = aVar.a();
            gVarA.setOnCancelListener(this);
            return gVarA;
        }

        protected final void i1() {
            try {
                if (Integer.valueOf(this.f4771r0.getText().toString()).intValue() <= 0) {
                    j1(R.string.duration_zero);
                } else {
                    x().setResult(-1, new Intent(this.f4771r0.getText().toString()));
                    x().finish();
                }
            } catch (NumberFormatException unused) {
                j1(R.string.duration_not_a_number);
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

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
        public final void q0(Bundle bundle) throws NumberFormatException {
            int i2;
            super.q0(bundle);
            Bundle bundle2 = new Bundle();
            this.f4774u0 = bundle2;
            bundle2.putInt("slide_index", this.f4772s0);
            this.f4774u0.putInt("slide_total", this.f4773t0);
            try {
                i2 = Integer.parseInt(this.f4771r0.getText().toString());
            } catch (NumberFormatException unused) {
                i2 = 5;
            }
            this.f4774u0.putInt("dur", i2);
            bundle.putBundle("state", this.f4774u0);
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
        new a().h1(wVarU, "dialog");
    }
}
