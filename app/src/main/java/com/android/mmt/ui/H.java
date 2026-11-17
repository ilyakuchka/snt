package com.android.mmt.ui;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.mmt.MmsApp;
import com.android.mmt.ui.E0;
import com.android.mmt.ui.P;
import java.util.Objects;
import miuix.pickerwidget.widget.DateTimePicker;

/* loaded from: classes.dex */
public final class H extends miuix.appcompat.app.g implements DateTimePicker.c {

    /* renamed from: l, reason: collision with root package name */
    private Context f4842l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f4843m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f4844n;

    /* renamed from: o, reason: collision with root package name */
    private DateTimePicker f4845o;
    private long p;

    /* renamed from: q, reason: collision with root package name */
    private a f4846q;

    public interface a {
    }

    public H(Context context) {
        super(context);
        this.f4842l = context;
        k(-1, context.getText(R.string.ok));
        k(-2, this.f4842l.getText(R.string.cancel));
        setCanceledOnTouchOutside(true);
        View viewInflate = LayoutInflater.from(this.f4842l).inflate(com.android.mmt.R.layout.datetime_picker_dialog, (ViewGroup) null);
        l(viewInflate);
        this.f4844n = (TextView) viewInflate.findViewById(com.android.mmt.R.id.datetime);
        this.f4845o = (DateTimePicker) viewInflate.findViewById(com.android.mmt.R.id.time_picker);
        TextView textView = (TextView) viewInflate.findViewById(com.android.mmt.R.id.title);
        this.f4843m = textView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.topMargin = 0;
        this.f4843m.setLayoutParams(layoutParams);
        this.f4843m.setText(com.android.mmt.R.string.title_timed_message_dialog);
        this.f4845o.w(this);
        this.f4845o.v();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = System.currentTimeMillis() + 315360000000L;
        this.f4845o.u(jCurrentTimeMillis);
        this.f4845o.t(jCurrentTimeMillis2);
    }

    public static /* synthetic */ void m(H h2) {
        a aVar = h2.f4846q;
        if (aVar != null) {
            ((P.n) aVar).a();
        }
    }

    public static void n(H h2) {
        if (h2.p < System.currentTimeMillis()) {
            Toast.makeText(MmsApp.c(), h2.f4842l.getString(com.android.mmt.R.string.error_timed_msg), 0).show();
            return;
        }
        a aVar = h2.f4846q;
        if (aVar != null) {
            long jS = h2.f4845o.s();
            P.n nVar = (P.n) aVar;
            P.this.f5225H.setClickable(true);
            if (jS != -1) {
                P.this.f5241U.b0(jS);
                P.this.f5225H.setVisibility(0);
                P p = P.this;
                String strT = p.f5241U.t(p, jS);
                P.this.f5241U.c0(strT);
                P.this.f5225H.setText(strT);
            }
            P.this.W0();
        }
        h2.dismiss();
    }

    public final void o(long j2) {
        this.p = j2;
        this.f4844n.setText(DateUtils.formatDateTime(this.f4842l, j2, 98455));
    }

    @Override // android.app.Dialog
    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    public final void p(a aVar) {
        this.f4846q = aVar;
    }

    public final void q(long j2) {
        this.p = j2;
        this.f4845o.x(j2);
        this.f4844n.setText(DateUtils.formatDateTime(this.f4842l, this.p, 98455));
    }

    @Override // miuix.appcompat.app.g, androidx.appcompat.app.o, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        this.f4843m.setText(charSequence);
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
        final int i2 = 0;
        e(-1).setOnClickListener(new View.OnClickListener() { // from class: P0.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        com.android.mmt.ui.H.n((com.android.mmt.ui.H) this);
                        return;
                    case 1:
                        ((com.android.mmt.ui.H) this).dismiss();
                        return;
                    default:
                        E0 e02 = (E0) this;
                        int i4 = E0.f4766P0;
                        Objects.requireNonNull(e02);
                        throw null;
                }
            }
        });
        final int i4 = 1;
        e(-2).setOnClickListener(new View.OnClickListener() { // from class: P0.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        com.android.mmt.ui.H.n((com.android.mmt.ui.H) this);
                        return;
                    case 1:
                        ((com.android.mmt.ui.H) this).dismiss();
                        return;
                    default:
                        E0 e02 = (E0) this;
                        int i42 = E0.f4766P0;
                        Objects.requireNonNull(e02);
                        throw null;
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: P0.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                com.android.mmt.ui.H.m(this.f917i);
            }
        });
    }

    @Override // androidx.appcompat.app.o, android.app.Dialog
    public final void setTitle(int i2) {
        this.f4843m.setText(i2);
    }
}
