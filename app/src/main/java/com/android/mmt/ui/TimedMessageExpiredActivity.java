package com.android.mmt.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.ActivityC0219o;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l;
import com.android.mmt.R;
import com.android.mmt.transaction.SendMessageService;
import com.android.mmt.util.C0287t;
import java.util.ArrayList;
import java.util.Objects;
import miuix.appcompat.app.g;
import t.C0384b;

/* loaded from: classes.dex */
public class TimedMessageExpiredActivity extends miuix.appcompat.app.h {

    public static class a extends DialogInterfaceOnCancelListenerC0216l {

        /* renamed from: r0, reason: collision with root package name */
        private TextView f5476r0;

        /* renamed from: s0, reason: collision with root package name */
        private MessageListView f5477s0;

        /* renamed from: t0, reason: collision with root package name */
        private Button f5478t0;

        /* renamed from: u0, reason: collision with root package name */
        private J f5479u0;

        /* renamed from: v0, reason: collision with root package name */
        private BroadcastReceiver f5480v0 = new C0102a();

        /* renamed from: w0, reason: collision with root package name */
        private final AdapterView.OnItemClickListener f5481w0 = new c();

        /* renamed from: x0, reason: collision with root package name */
        private final View.OnClickListener f5482x0 = new d();

        /* renamed from: y0, reason: collision with root package name */
        private final View.OnClickListener f5483y0 = new e();

        /* renamed from: com.android.mmt.ui.TimedMessageExpiredActivity$a$a, reason: collision with other inner class name */
        final class C0102a extends BroadcastReceiver {
            C0102a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("com.miui.fullscreen_state_change".equals(action)) {
                    if ("toHome".equals(intent.getStringExtra("state"))) {
                        a.i1(a.this, false);
                        a.this.x().finish();
                        a.this.x().overridePendingTransition(0, 0);
                        return;
                    }
                    return;
                }
                if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) && "homekey".equals(intent.getStringExtra("reason"))) {
                    a.i1(a.this, false);
                    a.this.x().finish();
                }
            }
        }

        final class b extends DataSetObserver {
            b() {
            }

            @Override // android.database.DataSetObserver
            public final void onChanged() {
                if (a.this.f5479u0.getCount() == 0) {
                    a.this.x().finish();
                } else {
                    a.this.f5476r0.setText(a.this.N().getQuantityString(R.plurals.timed_message_expired_title, a.this.f5479u0.getCount(), Integer.valueOf(a.this.f5479u0.getCount())));
                }
            }
        }

        final class c implements AdapterView.OnItemClickListener {
            c() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) throws Resources.NotFoundException {
                if (a.this.f5479u0.c(i2) == null || view == null) {
                    return;
                }
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.timed_checkbox);
                if (a.this.f5477s0.isItemChecked(i2)) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                a.this.f5479u0.f(a.this.f5477s0.getCheckedItemPositions());
                int checkedItemCount = a.this.f5477s0.getCheckedItemCount();
                String string = a.this.N().getString(R.string.resent_message);
                if (checkedItemCount == 0) {
                    a.this.f5478t0.setText(string);
                    a.this.f5478t0.setEnabled(false);
                    return;
                }
                a.this.f5478t0.setText(string + "(" + checkedItemCount + ")");
                a.this.f5478t0.setEnabled(true);
            }
        }

        final class d implements View.OnClickListener {
            d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.n1(a.this);
                a.i1(a.this, true);
                a.this.x().finish();
            }
        }

        final class e implements View.OnClickListener {
            e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.i1(a.this, false);
                a.this.x().finish();
            }
        }

        static void i1(a aVar, boolean z4) {
            Objects.requireNonNull(aVar);
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < aVar.f5479u0.getCount(); i2++) {
                C0243g0 c0243g0C = aVar.f5479u0.c(i2);
                if (c0243g0C != null && (!z4 || !aVar.f5477s0.isItemChecked(i2))) {
                    if (c0243g0C.U()) {
                        arrayList2.add(String.valueOf(c0243g0C.z()));
                    } else {
                        arrayList.add(String.valueOf(c0243g0C.z()));
                    }
                }
            }
            if (arrayList2.size() > 0 || arrayList.size() > 0) {
                ActivityC0219o activityC0219oX = aVar.x();
                int i4 = SendMessageService.f4514k;
                Intent intent = new Intent(activityC0219oX, (Class<?>) SendMessageService.class);
                intent.setAction("com.android.mmt.transaction.MARK_FAIL_BACKGROUND");
                intent.putStringArrayListExtra("extra_mms_msg_ids", arrayList2);
                intent.putStringArrayListExtra("extra_sms_msg_ids", arrayList);
                activityC0219oX.startService(intent);
            }
        }

        static void n1(a aVar) {
            C0243g0 c0243g0C;
            Objects.requireNonNull(aVar);
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            for (int i2 = 0; i2 < aVar.f5479u0.getCount(); i2++) {
                if (aVar.f5477s0.isItemChecked(i2) && (c0243g0C = aVar.f5479u0.c(i2)) != null) {
                    if (c0243g0C.U()) {
                        arrayList.add(String.valueOf(c0243g0C.z()));
                    } else {
                        arrayList2.add(String.valueOf(c0243g0C.z()));
                        arrayList3.add(Long.valueOf(c0243g0C.E()));
                    }
                }
            }
            if (arrayList2.size() > 0) {
                int iP = C0287t.p(arrayList3);
                ActivityC0219o activityC0219oX = aVar.x();
                int i4 = SendMessageService.f4514k;
                Intent intent = new Intent(activityC0219oX, (Class<?>) SendMessageService.class);
                intent.setAction("com.android.sms.transaction.RESEND_SMS_BACKGROUND");
                intent.putStringArrayListExtra("extra_sms_msg_ids", arrayList2);
                intent.putExtra("slot_id", iP);
                activityC0219oX.startService(intent);
            }
            if (arrayList.size() > 0) {
                ActivityC0219o activityC0219oX2 = aVar.x();
                int i5 = SendMessageService.f4514k;
                Intent intent2 = new Intent(activityC0219oX2, (Class<?>) SendMessageService.class);
                intent2.setAction("com.android.mmt.transaction.RESEND_MMS_BACKGROUND");
                intent2.putStringArrayListExtra("extra_mms_msg_ids", arrayList);
                activityC0219oX2.startService(intent2);
            }
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l
        public final Dialog e1(Bundle bundle) {
            View viewInflate = LayoutInflater.from(x()).inflate(R.layout.timed_message_expired_activity, (ViewGroup) null, false);
            this.f5479u0 = new J(x());
            this.f5476r0 = (TextView) viewInflate.findViewById(R.id.timed_message_expired_title);
            MessageListView messageListView = (MessageListView) viewInflate.findViewById(android.R.id.list);
            this.f5477s0 = messageListView;
            messageListView.setChoiceMode(2);
            this.f5477s0.setAdapter((ListAdapter) this.f5479u0);
            this.f5477s0.setOnItemClickListener(this.f5481w0);
            this.f5479u0.e();
            this.f5479u0.registerDataSetObserver(new b());
            viewInflate.findViewById(R.id.close).setOnClickListener(this.f5483y0);
            Button button = (Button) viewInflate.findViewById(R.id.resend);
            this.f5478t0 = button;
            button.setEnabled(false);
            this.f5478t0.setOnClickListener(this.f5482x0);
            IntentFilter intentFilter = new IntentFilter("com.miui.fullscreen_state_change");
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            C0384b.t(x(), this.f5480v0, intentFilter);
            g.a aVar = new g.a(x());
            aVar.z(viewInflate);
            return aVar.a();
        }

        @Override // androidx.fragment.app.Fragment
        public final void h0() {
            this.f5479u0.g();
            this.f5479u0.changeCursor(null);
            x().unregisterReceiver(this.f5480v0);
            super.h0();
        }
    }

    @Override // miuix.appcompat.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.android.mmt.util.e0.i(this);
        setFinishOnTouchOutside(false);
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
