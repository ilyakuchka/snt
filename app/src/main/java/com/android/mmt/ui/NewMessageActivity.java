package com.android.mmt.ui;

import P0.C0157c;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.ArrayMap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import c.C0227a;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.RowLayout;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.C0292y;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import miuix.appcompat.app.g;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public class NewMessageActivity extends P {
    private static C0415b x1 = new C0415b();
    public static final /* synthetic */ int y1 = 0;

    /* renamed from: O0, reason: collision with root package name */
    private ScrollView f5102O0;

    /* renamed from: P0, reason: collision with root package name */
    private RowLayout f5103P0;

    /* renamed from: Q0, reason: collision with root package name */
    private EditText f5104Q0;

    /* renamed from: R0, reason: collision with root package name */
    private TextView f5105R0;

    /* renamed from: S0, reason: collision with root package name */
    private TextView f5106S0;

    /* renamed from: T0, reason: collision with root package name */
    private TextView f5107T0;

    /* renamed from: U0, reason: collision with root package name */
    private ListView f5108U0;

    /* renamed from: V0, reason: collision with root package name */
    private View f5109V0;

    /* renamed from: W0, reason: collision with root package name */
    private View f5110W0;

    /* renamed from: X0, reason: collision with root package name */
    private RowLayout f5111X0;

    /* renamed from: Y0, reason: collision with root package name */
    private View f5112Y0;

    /* renamed from: Z0, reason: collision with root package name */
    private LinearLayout f5113Z0;

    /* renamed from: d1, reason: collision with root package name */
    private P0.u f5117d1;

    /* renamed from: e1, reason: collision with root package name */
    private int f5118e1;

    /* renamed from: f1, reason: collision with root package name */
    private int f5119f1;

    /* renamed from: g1, reason: collision with root package name */
    private int f5120g1;

    /* renamed from: h1, reason: collision with root package name */
    private int f5121h1;

    /* renamed from: i1, reason: collision with root package name */
    private boolean f5122i1;

    /* renamed from: k1, reason: collision with root package name */
    private ProgressDialog f5124k1;

    /* renamed from: l1, reason: collision with root package name */
    private AsyncTask<Void, Void, Void> f5125l1;

    /* renamed from: m1, reason: collision with root package name */
    private AsyncTask<Void, Void, Void> f5126m1;

    /* renamed from: n1, reason: collision with root package name */
    private AsyncTask<Void, Void, Boolean> f5127n1;

    /* renamed from: o1, reason: collision with root package name */
    private boolean f5128o1;

    /* renamed from: p1, reason: collision with root package name */
    private String f5129p1;

    /* renamed from: q1, reason: collision with root package name */
    private miuix.appcompat.app.g f5130q1;

    /* renamed from: r1, reason: collision with root package name */
    private miuix.appcompat.app.g f5131r1;

    /* renamed from: a1, reason: collision with root package name */
    private C0415b f5114a1 = new C0415b();

    /* renamed from: b1, reason: collision with root package name */
    private ArrayList<Integer> f5115b1 = new ArrayList<>();

    /* renamed from: c1, reason: collision with root package name */
    private ArrayList<String> f5116c1 = new ArrayList<>();

    /* renamed from: j1, reason: collision with root package name */
    private Map<C0414a, List<Uri>> f5123j1 = new ArrayMap();

    /* renamed from: s1, reason: collision with root package name */
    private Runnable f5132s1 = new l();

    /* renamed from: t1, reason: collision with root package name */
    private final View.OnKeyListener f5133t1 = new a();
    private final TextWatcher u1 = new d();
    protected Runnable v1 = new f();
    private Runnable w1 = new g();

    final class a implements View.OnKeyListener {
        a() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i2 != 67 || NewMessageActivity.this.f5104Q0.getSelectionEnd() != 0 || NewMessageActivity.this.f5114a1.isEmpty()) {
                return false;
            }
            NewMessageActivity newMessageActivity = NewMessageActivity.this;
            NewMessageActivity.C1(newMessageActivity, newMessageActivity.f5114a1.size() - 1);
            return true;
        }
    }

    final class b implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ C0414a f5135i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f5136j;

        b(C0414a c0414a, String str) {
            this.f5135i = c0414a;
            this.f5136j = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NewMessageActivity.this.f5103P0.removeView(view);
            NewMessageActivity.this.f5114a1.remove(this.f5135i);
            synchronized (NewMessageActivity.this.f5123j1) {
                ((ArrayMap) NewMessageActivity.this.f5123j1).remove(this.f5135i);
            }
            NewMessageActivity.this.o2();
            NewMessageActivity.this.f5116c1.remove(this.f5136j);
            NewMessageActivity.this.h2(this.f5135i, true);
            NewMessageActivity.this.W0();
            NewMessageActivity.this.r2();
        }
    }

    final class c implements View.OnLongClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f5138i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ C0414a f5139j;

        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Intent intent = new Intent("android.intent.action.VIEW", c.this.f5139j.f0());
                intent.setFlags(524288);
                NewMessageActivity.this.startActivity(intent);
            }
        }

        final class b implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f5142i;

            b(String str) {
                this.f5142i = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
                intent.putExtra(this.f5142i, c.this.f5138i);
                intent.setFlags(524288);
                NewMessageActivity.this.startActivity(intent);
            }
        }

        /* renamed from: com.android.mmt.ui.NewMessageActivity$c$c, reason: collision with other inner class name */
        final class RunnableC0097c implements Runnable {
            RunnableC0097c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ((ClipboardManager) NewMessageActivity.this.getSystemService("clipboard")).setText(c.this.f5138i);
                Toast.makeText(MmsApp.c(), R.string.context_menu_copy_notice, 0).show();
            }
        }

        c(String str, C0414a c0414a) {
            this.f5138i = str;
            this.f5139j = c0414a;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            C0157c c0157c = new C0157c(NewMessageActivity.this);
            c0157c.e(this.f5138i);
            NewMessageActivity newMessageActivity = NewMessageActivity.this;
            C0414a c0414a = this.f5139j;
            int i2 = NewMessageActivity.y1;
            Objects.requireNonNull(newMessageActivity);
            if (c0414a.L()) {
                c0157c.e(String.format("%s (%s)", this.f5138i, this.f5139j.U()));
                c0157c.b(R.string.menu_view_contact, new a());
            } else {
                String str = C0227a.c(this.f5138i) ? "phone" : S2.d.h(this.f5138i) ? "email" : null;
                if (str != null) {
                    c0157c.b(R.string.context_menu_add_contact, new b(str));
                }
            }
            c0157c.b(R.string.context_menu_copy, new RunnableC0097c());
            c0157c.f();
            return true;
        }
    }

    final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            String str = editable.toString() + '$';
            StringTokenizer stringTokenizer = new StringTokenizer(str, "\n\r\t,，;；");
            ArrayList arrayList = new ArrayList();
            while (stringTokenizer.hasMoreTokens()) {
                NewMessageActivity newMessageActivity = NewMessageActivity.this;
                String strNextToken = stringTokenizer.nextToken();
                int i2 = NewMessageActivity.y1;
                Objects.requireNonNull(newMessageActivity);
                arrayList.add(PhoneNumberUtils.replaceUnicodeDigits(strNextToken));
            }
            if (arrayList.size() > 1 || ((String) arrayList.get(0)).length() < str.length()) {
                String str2 = (String) arrayList.get(arrayList.size() - 1);
                String strSubstring = str2.substring(0, str2.length() - 1);
                int selectionEnd = NewMessageActivity.this.f5104Q0.getSelectionEnd() - (editable.length() - strSubstring.length());
                if (selectionEnd < 0) {
                    selectionEnd = 0;
                }
                NewMessageActivity.this.f5104Q0.setText(strSubstring);
                NewMessageActivity.this.f5117d1.b();
                NewMessageActivity.this.f5117d1.getFilter().filter(strSubstring);
                NewMessageActivity.this.f5104Q0.setSelection(selectionEnd);
                boolean z4 = false;
                for (int i4 = 0; i4 < arrayList.size() - 1; i4++) {
                    if (NewMessageActivity.y1(NewMessageActivity.this, (String) arrayList.get(i4)) && !z4) {
                        z4 = true;
                    }
                }
                if (z4) {
                    NewMessageActivity.this.s2();
                }
            } else {
                NewMessageActivity.this.f5117d1.b();
                NewMessageActivity.this.f5117d1.getFilter().filter(editable);
                if (NewMessageActivity.this.f5108U0 != null) {
                    NewMessageActivity.this.f5108U0.setSelection(0);
                }
            }
            NewMessageActivity.this.X0();
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            NewMessageActivity.this.onUserInteraction();
        }
    }

    final class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NewMessageActivity.this.C0();
            C0416c c0416cV = C0416c.v(NewMessageActivity.this.f5246Z.I());
            c0416cV.i0();
            Intent intentA = ComposeMessageRouterActivity.a(NewMessageActivity.this, c0416cV.I());
            intentA.putExtra("new_message_count", 1);
            intentA.putExtra("was_soft_keyboard_on", NewMessageActivity.this.f5250d0);
            intentA.addFlags(65536);
            ComposeMessageRouterActivity.e(NewMessageActivity.this, intentA);
            NewMessageActivity.this.finish();
            NewMessageActivity.this.overridePendingTransition(0, 0);
        }
    }

    final class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (NewMessageActivity.this.f5102O0.getVisibility() == 0) {
                NewMessageActivity.K1(NewMessageActivity.this);
            }
        }
    }

    final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NewMessageActivity.this.C0();
        }
    }

    final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NewMessageActivity.this.h1();
            NewMessageActivity.this.f5104Q0.requestFocus();
        }
    }

    final class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NewMessageActivity.this.f5113Z0.setVisibility(8);
            NewMessageActivity.this.f5102O0.setVisibility(0);
            NewMessageActivity.this.f5104Q0.requestFocus();
            NewMessageActivity.this.f5102O0.scrollTo(0, NewMessageActivity.this.f5103P0.getMeasuredHeight());
            NewMessageActivity.this.h1();
            NewMessageActivity newMessageActivity = NewMessageActivity.this;
            newMessageActivity.f5273y0.removeCallbacks(newMessageActivity.v1);
            newMessageActivity.f5273y0.postDelayed(newMessageActivity.v1, 2000L);
        }
    }

    final class j extends DataSetObserver {
        j() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            if (NewMessageActivity.this.f5104Q0.getText().length() > 0) {
                NewMessageActivity.this.f5110W0.setVisibility(0);
                NewMessageActivity.this.f5109V0.setVisibility(8);
            } else {
                NewMessageActivity.this.f5110W0.setVisibility(8);
                NewMessageActivity.this.f5109V0.setVisibility(0);
            }
            NewMessageActivity.a2(NewMessageActivity.this);
        }
    }

    final class k extends View.AccessibilityDelegate {
        k() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(EditText.class.getName());
            accessibilityNodeInfo.setFocusable(true);
            accessibilityNodeInfo.setClickable(true);
            accessibilityNodeInfo.setEditable(true);
        }
    }

    final class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.v("NewMessageActivity", "run mDrawContactPanelRunnable");
            int iA2 = NewMessageActivity.a2(NewMessageActivity.this);
            NewMessageActivity newMessageActivity = NewMessageActivity.this;
            if (!newMessageActivity.I0(newMessageActivity.f5102O0)) {
                NewMessageActivity.this.f5105R0.setVisibility(8);
                return;
            }
            NewMessageActivity.this.f5105R0.setText(NewMessageActivity.this.getBaseContext().getString(R.string.recipient_editor_count_format, Integer.valueOf(NewMessageActivity.this.p2())));
            if (iA2 > 2) {
                NewMessageActivity.this.f5105R0.setVisibility(0);
                NewMessageActivity.this.f5102O0.setVerticalScrollBarEnabled(true);
            } else {
                NewMessageActivity.this.f5105R0.setVisibility(8);
                NewMessageActivity.this.f5102O0.setVerticalScrollBarEnabled(false);
            }
        }
    }

    private class m implements DialogInterface.OnClickListener {
        m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    static class n extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<NewMessageActivity> f5153a;

        /* renamed from: b, reason: collision with root package name */
        private Map<C0414a, List<Uri>> f5154b;

        /* renamed from: c, reason: collision with root package name */
        private Parcelable[] f5155c;
        private Map<C0414a, List<Uri>> d;

        public n(NewMessageActivity newMessageActivity, Parcelable[] parcelableArr) {
            this.f5153a = new WeakReference<>(newMessageActivity);
            this.f5155c = parcelableArr;
            this.d = (ArrayMap) newMessageActivity.f5123j1;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        /* JADX WARN: Type inference failed for: r3v2, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        /* JADX WARN: Type inference failed for: r3v6, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        /* JADX WARN: Type inference failed for: r4v4, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        /* JADX WARN: Type inference failed for: r5v7, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        /* JADX WARN: Type inference failed for: r6v2, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        /* JADX WARN: Type inference failed for: r6v6, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        /* JADX WARN: Type inference failed for: r7v0, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        @Override // android.os.AsyncTask
        protected final Void doInBackground(Void[] voidArr) {
            List list;
            List list2;
            List arrayList;
            Parcelable[] parcelableArr = this.f5155c;
            if (parcelableArr != null && parcelableArr.length > 0 && this.d != null) {
                ArrayList arrayList2 = new ArrayList();
                Parcelable[] parcelableArr2 = this.f5155c;
                int length = parcelableArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Parcelable parcelable = parcelableArr2[i2];
                        if (isCancelled()) {
                            break;
                        }
                        Uri uri = (Uri) parcelable;
                        if ("tel".equals(uri.getScheme())) {
                            C0414a c0414aO = C0414a.O(uri.getSchemeSpecificPart());
                            synchronized (this.d) {
                                arrayList = (List) this.d.get(c0414aO);
                            }
                            if (arrayList == null) {
                                arrayList = new ArrayList(2);
                            }
                            arrayList.add(uri);
                            this.f5154b.put(c0414aO, arrayList);
                        } else if ("content".equals(uri.getScheme())) {
                            arrayList2.add(uri);
                        } else {
                            String schemeSpecificPart = uri.getSchemeSpecificPart();
                            if (C0292y.b(schemeSpecificPart)) {
                                C0414a c0414aO2 = C0414a.O(schemeSpecificPart);
                                synchronized (this.d) {
                                    list2 = this.d.containsKey(c0414aO2) ? (List) this.d.get(c0414aO2) : null;
                                }
                                this.f5154b.put(c0414aO2, list2);
                            } else {
                                continue;
                            }
                        }
                        i2++;
                    } else {
                        List<C0414a> listP = C0414a.P((Parcelable[]) arrayList2.toArray(new Parcelable[arrayList2.size()]));
                        if (!isCancelled() && listP != null) {
                            Iterator it = ((ArrayList) listP).iterator();
                            while (it.hasNext()) {
                                C0414a c0414a = (C0414a) it.next();
                                if (isCancelled()) {
                                    break;
                                }
                                synchronized (this.d) {
                                    list = this.d.containsKey(c0414a) ? (List) this.d.get(c0414a) : null;
                                }
                                this.f5154b.put(c0414a, list);
                            }
                        }
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        /* JADX WARN: Type inference failed for: r0v4, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        /* JADX WARN: Type inference failed for: r4v0, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
        @Override // android.os.AsyncTask
        protected final void onPostExecute(Void r6) {
            NewMessageActivity newMessageActivity = this.f5153a.get();
            if (newMessageActivity == null || newMessageActivity.isFinishing()) {
                return;
            }
            for (C0414a c0414a : this.f5154b.keySet()) {
                newMessageActivity.d2(c0414a, c0414a.W());
                synchronized (newMessageActivity.f5123j1) {
                    if (!((ArrayMap) newMessageActivity.f5123j1).containsKey(c0414a)) {
                        ((ArrayMap) newMessageActivity.f5123j1).put(c0414a, (List) this.f5154b.get(c0414a));
                    }
                }
            }
            this.f5154b.clear();
            this.f5154b = null;
            newMessageActivity.r2();
            if (newMessageActivity.f5106S0.getVisibility() == 0) {
                newMessageActivity.u2();
            }
            if (newMessageActivity.f5124k1 != null && newMessageActivity.f5124k1.isShowing()) {
                newMessageActivity.f5124k1.dismiss();
            }
            newMessageActivity.f5124k1 = null;
            newMessageActivity.f5125l1 = null;
            NewMessageActivity.S1(newMessageActivity);
        }

        @Override // android.os.AsyncTask
        protected final void onPreExecute() {
            NewMessageActivity newMessageActivity = this.f5153a.get();
            if (newMessageActivity != null && !newMessageActivity.isFinishing()) {
                if (newMessageActivity.f5124k1 == null) {
                    newMessageActivity.f5124k1 = new ProgressDialog(newMessageActivity);
                    newMessageActivity.f5124k1.setMessage(newMessageActivity.getText(R.string.adding_recipients));
                    newMessageActivity.f5124k1.setIndeterminate(true);
                    newMessageActivity.f5124k1.setCancelable(false);
                }
                if (newMessageActivity.f5124k1.isShowing()) {
                    newMessageActivity.f5124k1.dismiss();
                }
                newMessageActivity.f5124k1.show();
            }
            this.f5154b = new ArrayMap();
        }
    }

    static class o extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<NewMessageActivity> f5156a;

        o(NewMessageActivity newMessageActivity) {
            new HashSet();
            this.f5156a = new WeakReference<>(newMessageActivity);
        }

        @Override // android.os.AsyncTask
        protected final /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
            return null;
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Void r6) {
            boolean z4;
            NewMessageActivity newMessageActivity = this.f5156a.get();
            if (newMessageActivity == null || newMessageActivity.isFinishing()) {
                return;
            }
            Iterator<C0414a> it = NewMessageActivity.x1.iterator();
            while (true) {
                z4 = false;
                if (!it.hasNext()) {
                    break;
                }
                C0414a next = it.next();
                View viewInflate = newMessageActivity.getLayoutInflater().inflate(R.layout.recent_contact_item, (ViewGroup) newMessageActivity.f5111X0, false);
                TextView textView = (TextView) viewInflate.findViewById(R.id.recent_contact_name);
                if (newMessageActivity.f5114a1.contains(next)) {
                    textView.setEnabled(false);
                }
                textView.setText(next.U());
                textView.setOnClickListener(new v0(newMessageActivity, next));
                newMessageActivity.f5111X0.addView(viewInflate);
            }
            if (NewMessageActivity.x1.size() > 0 && newMessageActivity.f5104Q0.hasFocus()) {
                z4 = true;
            }
            NewMessageActivity.b2(newMessageActivity, z4);
        }
    }

    private class p implements DialogInterface.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        private final int f5157i;

        public p(int i2) {
            this.f5157i = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) throws ClassNotFoundException {
            NewMessageActivity.this.o0(this.f5157i);
            dialogInterface.dismiss();
        }
    }

    static class q extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        private C0415b f5159a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<NewMessageActivity> f5160b;

        public q(NewMessageActivity newMessageActivity) {
            this.f5160b = new WeakReference<>(newMessageActivity);
            this.f5159a = (C0415b) newMessageActivity.f5114a1.clone();
        }

        @Override // android.os.AsyncTask
        protected final Boolean doInBackground(Void[] voidArr) {
            C0415b c0415b = this.f5159a;
            boolean z4 = false;
            if (c0415b != null && !c0415b.isEmpty()) {
                Iterator<C0414a> it = this.f5159a.iterator();
                boolean z5 = false;
                while (true) {
                    if (!it.hasNext()) {
                        z4 = z5;
                        break;
                    }
                    C0414a next = it.next();
                    if (isCancelled()) {
                        break;
                    }
                    if (!next.L()) {
                        next.m0(true, true);
                        z5 = true;
                    }
                    if (isCancelled()) {
                        break;
                    }
                }
            }
            return Boolean.valueOf(z4);
        }

        @Override // android.os.AsyncTask
        protected final void onCancelled() {
            C0415b c0415b = this.f5159a;
            if (c0415b != null) {
                c0415b.clear();
            }
            this.f5159a = null;
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Boolean bool) {
            Boolean bool2 = bool;
            NewMessageActivity newMessageActivity = this.f5160b.get();
            if (newMessageActivity == null || !newMessageActivity.isFinishing()) {
                return;
            }
            newMessageActivity.f5127n1 = null;
            C0415b c0415b = this.f5159a;
            if (c0415b != null) {
                c0415b.clear();
            }
            this.f5159a = null;
            if (bool2.booleanValue()) {
                newMessageActivity.u2();
                newMessageActivity.t2();
            }
        }

        @Override // android.os.AsyncTask
        protected final void onPreExecute() {
        }
    }

    static void A1(NewMessageActivity newMessageActivity) {
        newMessageActivity.f5273y0.removeCallbacks(newMessageActivity.w1);
        newMessageActivity.f5273y0.postDelayed(newMessageActivity.w1, 10L);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
    static void C1(NewMessageActivity newMessageActivity, int i2) {
        C0414a c0414aRemove = newMessageActivity.f5114a1.remove(i2);
        if (c0414aRemove != null) {
            synchronized (newMessageActivity.f5123j1) {
                newMessageActivity.f5123j1.remove(c0414aRemove);
            }
        }
        newMessageActivity.f5116c1.remove(i2);
        newMessageActivity.r2();
        newMessageActivity.f5103P0.removeViewAt(i2);
        newMessageActivity.o2();
        newMessageActivity.h2(c0414aRemove, true);
        newMessageActivity.W0();
    }

    static void K1(NewMessageActivity newMessageActivity) {
        newMessageActivity.f5103P0.getChildCount();
    }

    static void S1(NewMessageActivity newMessageActivity) {
        if (newMessageActivity.f5114a1.isEmpty() || !newMessageActivity.I0(newMessageActivity.f5235N)) {
            return;
        }
        newMessageActivity.f5235N.requestFocus();
    }

    static void X1(NewMessageActivity newMessageActivity, C0414a c0414a) {
        Objects.requireNonNull(newMessageActivity);
        newMessageActivity.f2(c0414a, c0414a.W());
    }

    static int a2(NewMessageActivity newMessageActivity) {
        int iMin;
        int i2;
        int size = newMessageActivity.f5103P0.f5329k.size();
        if (newMessageActivity.f5117d1.getCount() <= 0 || newMessageActivity.f5104Q0.getText().length() <= 0) {
            ListView listView = newMessageActivity.f5108U0;
            if (listView != null) {
                listView.setVisibility(8);
            }
            newMessageActivity.f5221F.setVisibility(0);
            newMessageActivity.q2(true);
        } else {
            ViewStub viewStub = (ViewStub) newMessageActivity.findViewById(R.id.suggestion_list);
            if (viewStub != null) {
                ListView listView2 = (ListView) viewStub.inflate();
                newMessageActivity.f5108U0 = listView2;
                listView2.setAdapter((ListAdapter) newMessageActivity.f5117d1);
                newMessageActivity.f5108U0.setOnItemClickListener(new t0(newMessageActivity));
                newMessageActivity.f5108U0.setOnTouchListener(new u0(newMessageActivity));
            }
            newMessageActivity.f5108U0.setVisibility(0);
            newMessageActivity.f5221F.setVisibility(8);
            newMessageActivity.q2(false);
            size = 1;
        }
        if (newMessageActivity.f5102O0.getVisibility() != 0) {
            iMin = 1;
        } else {
            iMin = Math.min(size, newMessageActivity.f5211A ? 1 : 3);
            int measuredHeight = iMin > 0 ? newMessageActivity.f5128o1 ? newMessageActivity.f5104Q0.getLayoutParams().height * iMin : (newMessageActivity.f5104Q0.getMeasuredHeight() * iMin) + ((iMin - 1) * newMessageActivity.f5118e1) : 0;
            if (newMessageActivity.f5102O0.getMeasuredHeight() != measuredHeight) {
                Log.v("NewMessageActivity", "switchRecipientsRowView smoothScrollTo");
                newMessageActivity.f5102O0.getLayoutParams().height = measuredHeight;
                newMessageActivity.f5102O0.smoothScrollTo(0, measuredHeight);
                newMessageActivity.f5102O0.requestLayout();
            }
        }
        int i4 = newMessageActivity.f5119f1;
        if (iMin == 1) {
            ViewGroup.LayoutParams layoutParams = newMessageActivity.f5219E.getLayoutParams();
            i2 = newMessageActivity.f5119f1;
            layoutParams.height = i2;
        } else {
            if (iMin != 2) {
                if (iMin == 3) {
                    ViewGroup.LayoutParams layoutParams2 = newMessageActivity.f5219E.getLayoutParams();
                    i2 = newMessageActivity.f5121h1;
                    layoutParams2.height = i2;
                }
                newMessageActivity.e1(i4);
                return iMin;
            }
            ViewGroup.LayoutParams layoutParams3 = newMessageActivity.f5219E.getLayoutParams();
            i2 = newMessageActivity.f5120g1;
            layoutParams3.height = i2;
        }
        i4 = i2;
        newMessageActivity.e1(i4);
        return iMin;
    }

    static void b2(NewMessageActivity newMessageActivity, boolean z4) {
        if (newMessageActivity.f5112Y0.getVisibility() == 8 && z4) {
            newMessageActivity.f5112Y0.setVisibility(0);
        } else {
            if (newMessageActivity.f5112Y0.getVisibility() != 0 || z4) {
                return;
            }
            newMessageActivity.f5112Y0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(C0414a c0414a, String str) {
        if (this.f5114a1.indexOf(c0414a) != -1) {
            return;
        }
        this.f5116c1.add(str);
        this.f5114a1.add(c0414a);
        TextView textView = (TextView) getLayoutInflater().inflate(R.layout.recipient_view, (ViewGroup) null, false);
        if (c0414a.L()) {
            textView.setText(c0414a.U());
        } else {
            textView.setText(str);
        }
        textView.setOnClickListener(new b(c0414a, str));
        textView.setOnLongClickListener(new c(str, c0414a));
        this.f5103P0.addView(textView, r7.getChildCount() - 1, new RowLayout.a());
        Handler handler = this.f5273y0;
        if (handler != null) {
            handler.removeCallbacks(this.f5132s1);
            this.f5273y0.post(this.f5132s1);
        }
        h2(c0414a, false);
        W0();
    }

    private void e2() {
        Editable text = this.f5104Q0.getText();
        if (text.length() > 0) {
            this.f5104Q0.setText("");
            String strReplaceUnicodeDigits = PhoneNumberUtils.replaceUnicodeDigits(text.toString());
            C0414a c0414aO = C0414a.O(strReplaceUnicodeDigits);
            c0414aO.m0(false, false);
            if (f2(c0414aO, strReplaceUnicodeDigits)) {
                s2();
            }
        }
    }

    private boolean f2(C0414a c0414a, String str) {
        if (this.f5114a1.indexOf(c0414a) != -1) {
            return false;
        }
        boolean zIsEmpty = this.f5114a1.isEmpty();
        d2(c0414a, str);
        r2();
        if (!zIsEmpty) {
            return true;
        }
        X0();
        return true;
    }

    private boolean g2(C0414a c0414a) {
        return c0414a.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2(C0414a c0414a, boolean z4) {
        int childCount = this.f5111X0.getChildCount();
        for (int i2 = 0; i2 < childCount && i2 < x1.size(); i2++) {
            if (x1.get(i2) == c0414a) {
                TextView textView = (TextView) this.f5111X0.getChildAt(i2).findViewById(R.id.recent_contact_name);
                textView.setEnabled(z4);
                textView.setTextColor(getResources().getColor(z4 ? R.color.recipient_text_color : R.color.recent_recipient_checked_text_color));
                return;
            }
        }
    }

    private String i2(int i2) {
        C0414a c0414a = this.f5114a1.get(i2);
        return g2(c0414a) ? c0414a.U() : this.f5116c1.get(i2);
    }

    private ArrayList<String> j2() {
        ArrayList<String> arrayList = new ArrayList<>(this.f5116c1);
        if (k2()) {
            arrayList.add(this.f5104Q0.getText().toString());
        }
        C0415b c0415bK = C0415b.k(arrayList);
        if (!L2.a.a(c0415bK)) {
            arrayList = new ArrayList<>();
            Iterator<C0414a> it = c0415bK.iterator();
            while (it.hasNext()) {
                C0414a next = it.next();
                if (next != null) {
                    arrayList.add(next.W());
                }
            }
        }
        return arrayList;
    }

    private boolean k2() {
        return this.f5104Q0.getText().length() > 0;
    }

    private boolean m2(String str) {
        return this.f5241U.P() ? C0292y.e(str) != null : PhoneNumberUtils.isWellFormedSmsAddress(str) || S2.d.h(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(boolean z4) {
        if (z4) {
            this.f5252f0.x();
            h1();
        } else {
            e2();
            u2();
            this.f5102O0.setVisibility(8);
            this.f5113Z0.setVisibility(0);
        }
        o2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2() {
        Handler handler = this.f5273y0;
        if (handler == null) {
            Log.v("NewMessageActivity", "postDrawContactPanel mHandler is null");
        } else {
            handler.removeCallbacks(this.f5132s1);
            this.f5273y0.postDelayed(this.f5132s1, 10L);
        }
    }

    private void q2(boolean z4) {
        if (z4 && x1.size() > 0 && this.f5104Q0.hasFocus()) {
            this.f5112Y0.setVisibility(0);
        } else {
            this.f5112Y0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2() {
        boolean z4;
        this.f5241U.d0(j2());
        x0.j jVar = this.f5241U;
        Iterator<String> it = j2().iterator();
        while (true) {
            z4 = true;
            if (!it.hasNext()) {
                z4 = false;
                break;
            } else if (S2.d.h(it.next())) {
                break;
            }
        }
        jVar.V(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s2() {
        AsyncTask<Void, Void, Boolean> asyncTask = this.f5127n1;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        this.f5127n1 = null;
        if (isFinishing()) {
            Y1.a.k("updateCommitedRecipients is not resumed", new Object[0]);
            return;
        }
        q qVar = new q(this);
        this.f5127n1 = qVar;
        qVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2() {
        for (int i2 = 0; i2 < this.f5103P0.getChildCount() - 1; i2++) {
            ((TextView) this.f5103P0.getChildAt(i2)).setText(i2(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2() {
        int size = this.f5114a1.size();
        if (size == 0) {
            this.f5106S0.setText("");
            this.f5106S0.setAccessibilityDelegate(new k());
            this.f5107T0.setText("");
        } else {
            StringBuilder sb = new StringBuilder(i2(0));
            for (int i2 = 1; i2 < this.f5114a1.size(); i2++) {
                sb.append(", ");
                sb.append(i2(i2));
            }
            this.f5106S0.setText(sb);
            if (size > 1) {
                this.f5107T0.setVisibility(0);
                this.f5107T0.setText(getResources().getQuantityString(R.plurals.to_count, size, Integer.valueOf(size)));
            } else {
                this.f5107T0.setVisibility(8);
            }
        }
        this.f5106S0.setContentDescription(getString(R.string.recipient_label) + ((Object) this.f5106S0.getText()));
    }

    private void v2() {
        for (int i2 = 0; i2 < this.f5114a1.size(); i2++) {
            this.f5114a1.get(i2).s0(this.f5116c1.get(i2));
        }
    }

    static boolean y1(NewMessageActivity newMessageActivity, String str) {
        Objects.requireNonNull(newMessageActivity);
        C0414a c0414aO = C0414a.O(str);
        c0414aO.m0(false, false);
        return newMessageActivity.f2(c0414aO, str);
    }

    @Override // com.android.mmt.ui.P
    protected final void D0() throws Resources.NotFoundException {
        super.D0();
        View viewFindViewById = findViewById(R.id.add_recipient);
        this.f5109V0 = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        View viewFindViewById2 = findViewById(R.id.confirm_recipient);
        this.f5110W0 = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        this.f5102O0 = (ScrollView) findViewById(R.id.recipient_rows_scroller);
        RowLayout rowLayout = (RowLayout) findViewById(R.id.recipient_rows);
        this.f5103P0 = rowLayout;
        rowLayout.setOnClickListener(new h());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.recipients_viewer_linear);
        this.f5113Z0 = linearLayout;
        linearLayout.setOnClickListener(new i());
        this.f5105R0 = (TextView) findViewById(R.id.recipient_count);
        this.f5106S0 = (TextView) findViewById(R.id.recipients_viewer);
        this.f5107T0 = (TextView) findViewById(R.id.recipients_viewer_count);
        P0.u uVar = new P0.u(this);
        this.f5117d1 = uVar;
        uVar.registerDataSetObserver(new j());
        this.f5111X0 = (RowLayout) findViewById(R.id.recent_contact_grid);
        this.f5112Y0 = findViewById(R.id.ll_recent);
        if (C0287t.y()) {
            o1(this.q0);
        }
    }

    @Override // com.android.mmt.ui.P
    public final boolean G0() {
        if (!A0()) {
            return false;
        }
        int iP2 = p2();
        if (iP2 > 0 && iP2 <= k0.d.p()) {
            return C0287t.C();
        }
        return false;
    }

    @Override // com.android.mmt.ui.P
    protected final void L0() {
        if (C0287t.y()) {
            o1(this.q0);
        }
    }

    @Override // com.android.mmt.ui.P
    protected final void M0(C0415b c0415b) {
        u2();
        t2();
    }

    @Override // com.android.mmt.ui.P
    protected final void V0() {
        super.V0();
    }

    @Override // com.android.mmt.ui.P
    protected final void Z0(boolean z4) {
        if (l2()) {
            e2();
            v2();
            super.Z0(z4);
        }
    }

    @Override // com.android.mmt.ui.P
    public final void a1(int i2) throws ClassNotFoundException {
        boolean z4;
        e2();
        Iterator<String> it = j2().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!m2(next) && (k0.d.f() == null || !C0292y.a(next))) {
                z4 = true;
                break;
            }
        }
        z4 = false;
        if (!z4) {
            v2();
            o0(i2);
            return;
        }
        if (l2()) {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            Iterator<String> it2 = j2().iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!m2(next2)) {
                    if (sb.length() != 0) {
                        sb.append(',');
                    }
                    sb.append(next2);
                }
            }
            objArr[0] = sb.toString();
            String string = getString(R.string.has_invalid_recipient, objArr);
            g.a aVar = new g.a(this);
            aVar.h();
            aVar.y(string);
            aVar.j(R.string.invalid_recipient_message);
            aVar.t(R.string.try_to_send, new p(i2));
            aVar.m(R.string.no, new m());
            this.f5131r1 = aVar.a();
        } else {
            g.a aVar2 = new g.a(this);
            aVar2.h();
            aVar2.x(R.string.cannot_send_message);
            aVar2.j(R.string.cannot_send_message_reason);
            aVar2.t(R.string.yes, new m());
            this.f5131r1 = aVar2.a();
        }
        this.f5131r1.show();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Objects.requireNonNull(P0.G.b());
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.android.mmt.ui.P, x0.j.b
    public final void j() {
        super.j();
        if (isDestroyed()) {
            return;
        }
        runOnUiThread(new e());
    }

    @Override // com.android.mmt.ui.P, com.android.mmt.ui.SizeAwareLinearLayout.a
    public final void l() throws Resources.NotFoundException {
        super.l();
        if (this.f5128o1) {
            return;
        }
        Drawable drawable = getResources().getDrawable(R.drawable.recipient_view_bg_new);
        if (drawable != null) {
            Rect rect = new Rect();
            drawable.getPadding(rect);
            this.f5104Q0.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.recipient_row_padding) + Math.max(drawable.getIntrinsicHeight(), this.f5104Q0.getMeasuredHeight() + rect.bottom + rect.top);
        }
        this.f5128o1 = true;
    }

    public final boolean l2() {
        Iterator<String> it = j2().iterator();
        while (it.hasNext()) {
            if (m2(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
    @Override // com.android.mmt.ui.P, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, android.app.Activity
    protected final void onActivityResult(int i2, int i4, Intent intent) throws ClassNotFoundException {
        if (i2 != 0) {
            super.onActivityResult(i2, i4, intent);
        }
        if (i2 != 0) {
            return;
        }
        if (intent != null) {
            this.f5241U.l(this.f5246Z);
            while (this.f5115b1.size() > 0) {
                int iIntValue = this.f5115b1.remove(this.f5115b1.size() - 1).intValue();
                if (this.f5114a1.size() > iIntValue && iIntValue >= 0) {
                    C0414a c0414aRemove = this.f5114a1.remove(iIntValue);
                    if (c0414aRemove != null) {
                        synchronized (this.f5123j1) {
                            this.f5123j1.remove(c0414aRemove);
                        }
                    }
                    this.f5116c1.remove(iIntValue);
                    this.f5103P0.removeViewAt(iIntValue);
                    h2(c0414aRemove, true);
                }
            }
            if (this.f5114a1.size() == 0) {
                this.f5104Q0.setText("");
            }
            Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("com.android.contacts.extra.PHONE_URIS");
            int length = parcelableArrayExtra != null ? parcelableArrayExtra.length : 0;
            int iP = k0.d.p();
            if (iP == Integer.MAX_VALUE || length <= iP) {
                AsyncTask<Void, Void, Void> asyncTask = this.f5125l1;
                if (asyncTask != null) {
                    asyncTask.cancel(true);
                }
                n nVar = new n(this, parcelableArrayExtra);
                this.f5125l1 = nVar;
                nVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                g.a aVar = new g.a(this);
                aVar.x(R.string.pick_too_many_recipients);
                aVar.h();
                aVar.k(getString(R.string.too_many_recipients, Integer.valueOf(length), Integer.valueOf(iP)));
                aVar.t(android.R.string.ok, null);
                miuix.appcompat.app.g gVarA = aVar.a();
                this.f5130q1 = gVarA;
                gVarA.show();
            }
        }
        this.f5115b1.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.util.ArrayMap, java.util.Map<x0.a, java.util.List<android.net.Uri>>] */
    @Override // com.android.mmt.ui.P, android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        List list;
        int id = view.getId();
        if (id != R.id.add_recipient) {
            if (id == R.id.confirm_recipient) {
                e2();
                return;
            }
            if (id == R.id.send_button) {
                e2();
            }
            super.onClick(view);
            return;
        }
        e2();
        Intent intent = new Intent("com.android.contacts.action.GET_MULTIPLE_PHONES");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("vnd.android.cursor.dir/phone_v2");
        int i2 = P0.r.f937c;
        intent.setPackage("com.android.contacts");
        intent.putExtra("number_count", k0.d.p());
        intent.putExtra("com.android.contacts.extra.MAX_COUNT", k0.d.p());
        ArrayList arrayList = new ArrayList();
        this.f5115b1.clear();
        Iterator<C0414a> it = this.f5114a1.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            C0414a next = it.next();
            synchronized (this.f5123j1) {
                list = (List) this.f5123j1.get(next);
            }
            boolean z4 = true;
            if (list == null || list.size() <= 0) {
                int i5 = next.f8015b;
                if (i5 == 1) {
                    Uri uriA0 = next.a0();
                    if (arrayList.contains(uriA0)) {
                        z4 = false;
                    } else {
                        arrayList.add(uriA0);
                    }
                } else {
                    if (i5 == 2) {
                        Uri uriS = next.S();
                        if (!arrayList.contains(uriS)) {
                            arrayList.add(uriS);
                        }
                    }
                }
            } else {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add((Uri) it2.next());
                }
            }
            if (z4) {
                this.f5115b1.add(Integer.valueOf(i4));
            }
            i4++;
        }
        if (arrayList.size() > 0) {
            intent.putExtra("com.android.contacts.extra.PHONE_URIS", (Parcelable[]) arrayList.toArray(new Uri[arrayList.size()]));
        }
        startActivityForResult(intent, 0);
    }

    @Override // com.android.mmt.ui.P, P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected final void onCreate(Bundle bundle) throws Resources.NotFoundException, UnsupportedEncodingException {
        O0();
        super.onCreate(bundle);
        if ((getIntent().getFlags() & 1048576) != 0) {
            getIntent().replaceExtras((Bundle) null);
        }
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("is_from_blocked", false);
        String stringExtra = intent.getStringExtra("reply_address");
        getIntent().getStringExtra("suggestions");
        if (this.f5269w0.longValue() == -1) {
            Uri data = intent.getData();
            if (data == null) {
                String stringExtra2 = intent.getStringExtra("address");
                this.f5129p1 = stringExtra2;
                if (TextUtils.isEmpty(stringExtra2)) {
                    Y1.a.k("Creating an empty conversation", new Object[0]);
                    this.f5246Z = C0416c.m(this);
                } else {
                    this.f5246Z = C0416c.p(this, C0415b.l(this.f5129p1, true));
                }
            } else {
                Y1.a.k("Creating a conversation by uri", new Object[0]);
                this.f5246Z = C0416c.o(this, data);
            }
        } else {
            Y1.a.k("Creating a conversation by threadId %d", this.f5269w0);
            this.f5246Z = C0416c.n(this, this.f5269w0.longValue());
        }
        EditText editText = (EditText) findViewById(R.id.recipients_editor);
        this.f5104Q0 = editText;
        editText.addTextChangedListener(this.u1);
        this.f5104Q0.setOnKeyListener(this.f5133t1);
        this.f5104Q0.setOnFocusChangeListener(new s0(this));
        E0();
        if (booleanExtra) {
            this.f5246Z.d0(C0415b.l(stringExtra, false));
        }
        Iterator<C0414a> it = this.f5246Z.G().iterator();
        while (it.hasNext()) {
            C0414a next = it.next();
            d2(next, next.W());
        }
        m1();
        r2();
        u2();
        Resources resources = getResources();
        this.f5118e1 = resources.getDimensionPixelSize(R.dimen.recipient_row_padding);
        this.f5119f1 = resources.getDimensionPixelSize(R.dimen.contact_panel_height_new_message_one_row) + this.f5272y;
        this.f5120g1 = resources.getDimensionPixelSize(R.dimen.contact_panel_height_new_message_two_row) + this.f5272y;
        this.f5121h1 = resources.getDimensionPixelSize(R.dimen.contact_panel_height_new_message_three_row) + this.f5272y;
        n2(false);
    }

    @Override // com.android.mmt.ui.P, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        EditText editText = this.f5104Q0;
        if (editText != null) {
            editText.removeTextChangedListener(this.u1);
        }
        this.f5117d1.changeCursor(null);
        this.f5117d1.c();
        AsyncTask<Void, Void, Void> asyncTask = this.f5126m1;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f5126m1 = null;
        }
        AsyncTask<Void, Void, Void> asyncTask2 = this.f5125l1;
        if (asyncTask2 != null) {
            asyncTask2.cancel(true);
            this.f5125l1 = null;
        }
        AsyncTask<Void, Void, Boolean> asyncTask3 = this.f5127n1;
        if (asyncTask3 != null) {
            asyncTask3.cancel(true);
            this.f5127n1 = null;
        }
        C0415b c0415b = x1;
        if (c0415b != null) {
            c0415b.clear();
        }
        miuix.appcompat.app.g gVar = this.f5130q1;
        if (gVar != null && gVar.isShowing()) {
            this.f5130q1.dismiss();
        }
        miuix.appcompat.app.g gVar2 = this.f5131r1;
        if (gVar2 != null && gVar2.isShowing()) {
            this.f5131r1.dismiss();
        }
        super.onDestroy();
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.f5217D.a(null);
        }
        return super.onMenuItemSelected(i2, menuItem);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getWindow().setWindowAnimations(0);
        intent.addFlags(65536);
        try {
            startActivity(intent);
        } catch (Exception unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        w0();
        return true;
    }

    @Override // com.android.mmt.ui.P, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onStart() {
        super.onStart();
        if (this.f5122i1) {
            return;
        }
        this.f5122i1 = true;
        x1.clear();
        this.f5111X0.removeAllViews();
        o oVar = new o(this);
        this.f5126m1 = oVar;
        oVar.execute(new Void[0]);
    }

    @Override // com.android.mmt.ui.P, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onStop() {
        super.onStop();
        AsyncTask<Void, Void, Boolean> asyncTask = this.f5127n1;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        this.f5127n1 = null;
        AsyncTask<Void, Void, Void> asyncTask2 = this.f5125l1;
        if (asyncTask2 != null) {
            asyncTask2.cancel(true);
        }
        this.f5125l1 = null;
        ProgressDialog progressDialog = this.f5124k1;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f5124k1.dismiss();
        }
        this.f5124k1 = null;
    }

    @Override // com.android.mmt.ui.P, com.android.mmt.ui.SizeAwareLinearLayout.a
    public final void p(SizeAwareLinearLayout sizeAwareLinearLayout, int i2, int i4) {
        ((l) this.f5132s1).run();
        super.p(sizeAwareLinearLayout, i2, i4);
    }

    protected final int p2() {
        return k2() ? this.f5114a1.size() + 1 : this.f5114a1.size();
    }

    @Override // com.android.mmt.ui.P
    protected final boolean t1() {
        return !l2();
    }

    @Override // com.android.mmt.ui.P
    protected final void w0() {
        if (!this.f5241U.G() && this.f5269w0.longValue() > 0) {
            L0.b.a(this.f5269w0.longValue(), true);
        }
        super.w0();
    }

    @Override // com.android.mmt.ui.P
    protected final int x0() {
        return R.layout.new_message_activity;
    }

    @Override // com.android.mmt.ui.P
    protected final C0415b z0() {
        return this.f5114a1;
    }
}
