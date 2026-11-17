package com.android.mmt.ui;

import P0.ActivityC0156b;
import android.annotation.TargetApi;
import android.app.role.RoleManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.MessageQueue;
import android.provider.Telephony;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import b0.C0225b;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.C0291x;
import java.util.Objects;
import l0.C0345d;
import miuix.view.e;
import o0.RunnableC0359b;
import v0.C0401b;
import w.C0405a;

/* loaded from: classes.dex */
public class MmsTabActivity extends ActivityC0156b {

    /* renamed from: F, reason: collision with root package name */
    public static final /* synthetic */ int f5055F = 0;

    /* renamed from: B, reason: collision with root package name */
    private C0291x f5057B;

    /* renamed from: C, reason: collision with root package name */
    private C0225b f5058C;

    /* renamed from: w, reason: collision with root package name */
    private View f5062w;

    /* renamed from: x, reason: collision with root package name */
    private miuix.view.e f5063x;

    /* renamed from: y, reason: collision with root package name */
    private SearchFragment f5064y;

    /* renamed from: z, reason: collision with root package name */
    private Q0.z f5065z;

    /* renamed from: v, reason: collision with root package name */
    private boolean f5061v = false;

    /* renamed from: A, reason: collision with root package name */
    private boolean f5056A = true;

    /* renamed from: D, reason: collision with root package name */
    private e.a f5059D = new c();

    /* renamed from: E, reason: collision with root package name */
    private TextWatcher f5060E = new d();

    final class a implements MessageQueue.IdleHandler {
        a() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            if ("com.android.mmt".equals(Telephony.Sms.getDefaultSmsPackage(MmsApp.c()))) {
                return false;
            }
            try {
                MmsTabActivity.this.startActivityForResult(((RoleManager) MmsTabActivity.this.getSystemService(RoleManager.class)).createRequestRoleIntent("android.app.role.SMS"), 3);
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (MmsTabActivity.this.isDestroyed() || MmsTabActivity.this.isFinishing()) {
                return;
            }
            MmsTabActivity.P(MmsTabActivity.this);
        }
    }

    final class c implements e.a {

        final class a extends View.AccessibilityDelegate {
            a() {
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName(EditText.class.getName());
            }
        }

        final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MmsTabActivity.this.f5064y = null;
            }
        }

        c() {
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (MmsTabActivity.this.f5064y == null) {
                MmsTabActivity.U(MmsTabActivity.this, true, false, true);
            }
            View viewT = MmsTabActivity.this.f5065z.T();
            miuix.view.e eVar = (miuix.view.e) actionMode;
            eVar.h(MmsTabActivity.this.f5062w);
            eVar.c(viewT);
            eVar.e(MmsTabActivity.this.f5064y.T());
            EditText editTextB = eVar.b();
            if (editTextB != null) {
                editTextB.setAccessibilityDelegate(new a());
                editTextB.setContentDescription("");
                editTextB.setHint(MmsTabActivity.this.getResources().getString(R.string.search_hint));
                MmsTabActivity mmsTabActivity = MmsTabActivity.this;
                int i2 = C0405a.f7979b;
                editTextB.setHintTextColor(mmsTabActivity.getColor(R.color.miuix_appcompat_transparent));
                editTextB.addTextChangedListener(MmsTabActivity.this.f5060E);
            }
            MmsTabActivity.X(MmsTabActivity.this);
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            ((miuix.view.e) actionMode).b().removeTextChangedListener(MmsTabActivity.this.f5060E);
            if (MmsTabActivity.this.f5063x == null) {
                Log.v("MmsTabActivity", "onDestroyActionMode mSearchActionMode is null");
                return;
            }
            MmsTabActivity.this.f5063x = null;
            if (MmsTabActivity.this.f5064y != null) {
                MmsTabActivity.U(MmsTabActivity.this, false, true, false);
            }
            S2.e.a().post(new b());
            if (MmsTabActivity.this.f5065z != null) {
                MmsTabActivity.this.f5065z.B1(false);
            }
            MmsTabActivity.this.onBackPressed();
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }
    }

    final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            String string = charSequence != null ? charSequence.toString() : null;
            if (MmsTabActivity.this.f5064y == null) {
                return;
            }
            if (!TextUtils.isEmpty(string)) {
                if (MmsTabActivity.this.f5064y.X()) {
                    MmsTabActivity.U(MmsTabActivity.this, false, false, true);
                }
                MmsTabActivity.this.f5064y.h1(string);
            } else {
                if (MmsTabActivity.this.f5064y.X()) {
                    return;
                }
                MmsTabActivity.U(MmsTabActivity.this, false, false, false);
                MmsTabActivity.this.f5064y.i1();
            }
        }
    }

    @TargetApi(11)
    private class e implements ActionMode.Callback {

        /* renamed from: a, reason: collision with root package name */
        private ActionMode.Callback f5071a;

        public e(ActionMode.Callback callback) {
            this.f5071a = callback;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f5071a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f5071a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.f5071a.onDestroyActionMode(actionMode);
            C0225b unused = MmsTabActivity.this.f5058C;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (MmsTabActivity.this.f5058C == null) {
                View viewFindViewById = MmsTabActivity.this.getWindow().findViewById(R.id.view_pager);
                if (viewFindViewById instanceof C0225b) {
                    MmsTabActivity.this.f5058C = (C0225b) viewFindViewById;
                }
            }
            return this.f5071a.onPrepareActionMode(actionMode, menu);
        }
    }

    static void P(MmsTabActivity mmsTabActivity) {
        androidx.fragment.app.w wVarU = mmsTabActivity.u();
        androidx.fragment.app.E eF = wVarU.f();
        Q0.m mVar = new Q0.m();
        mmsTabActivity.f5065z = mVar;
        eF.o(android.R.id.content, mVar, "CommonConversation");
        SearchFragment searchFragment = (SearchFragment) wVarU.T("SearchFragment");
        mmsTabActivity.f5064y = searchFragment;
        if (searchFragment != null) {
            Log.v("MmsTabActivity", "onCreate remove seach fragment");
            eF.n(mmsTabActivity.f5064y);
        }
        eF.h();
        mmsTabActivity.f5064y = null;
    }

    static void U(MmsTabActivity mmsTabActivity, boolean z4, boolean z5, boolean z6) {
        androidx.fragment.app.w wVarU = mmsTabActivity.u();
        androidx.fragment.app.E eF = wVarU.f();
        if (z4) {
            SearchFragment searchFragment = (SearchFragment) wVarU.T("SearchFragment");
            mmsTabActivity.f5064y = searchFragment;
            if (searchFragment == null) {
                SearchFragment searchFragment2 = new SearchFragment();
                mmsTabActivity.f5064y = searchFragment2;
                eF.b(android.R.id.content, searchFragment2, "SearchFragment");
            }
            eF.l(mmsTabActivity.f5064y);
        } else if (z5) {
            eF.n(mmsTabActivity.f5064y);
        } else if (z6) {
            eF.p(mmsTabActivity.f5064y);
        } else {
            eF.l(mmsTabActivity.f5064y);
        }
        eF.h();
        wVarU.P();
    }

    static void X(MmsTabActivity mmsTabActivity) {
        if (!mmsTabActivity.f5061v) {
            mmsTabActivity.f5061v = true;
        }
    }

    public final boolean a0() {
        return this.f5061v;
    }

    public final void b0(View view) {
        if (this.f5063x == null) {
            this.f5062w = view;
            this.f5063x = (miuix.view.e) startActionMode(this.f5059D);
        }
    }

    @Override // android.app.Activity
    public final void finish() {
        if (isTaskRoot()) {
            moveTaskToBack(false);
        } else {
            super.finish();
        }
    }

    @Override // miuix.appcompat.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        boolean z4 = this.f5061v;
        if (!z4) {
            super.onBackPressed();
            return;
        }
        if (z4) {
            this.f5061v = false;
            ((d) this.f5060E).onTextChanged(null, 0, 0, 0);
        }
        Object obj = this.f5063x;
        if (obj instanceof ActionMode) {
            ((ActionMode) obj).finish();
        }
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public final void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
        Q0.z zVar = this.f5065z;
        if (zVar != null) {
            zVar.s1(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mms_main_screen);
        N();
        if (bundle != null) {
            androidx.fragment.app.w wVarU = u();
            N2.a aVar = (N2.a) wVarU.T("notify_password");
            if (aVar != null) {
                androidx.fragment.app.E eF = wVarU.f();
                eF.n(aVar);
                eF.g();
            }
            Fragment fragmentT = wVarU.T("CommonConversation");
            if (fragmentT != null) {
                androidx.fragment.app.E eF2 = wVarU.f();
                eF2.n(fragmentT);
                eF2.h();
                wVarU.P();
            }
        }
        C0291x c0291x = new C0291x(this, K());
        this.f5057B = c0291x;
        c0291x.b();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        this.f5063x = null;
        C0291x c0291x = this.f5057B;
        if (c0291x != null) {
            Objects.requireNonNull(c0291x);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super.onKeyDown(i2, keyEvent);
        }
        com.android.mmt.util.C.e(this);
        return true;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onResume() {
        super.onResume();
        if (!this.f5056A) {
            NewMessagePopupActivity.z();
            return;
        }
        this.f5056A = false;
        this.f5057B.c();
        S2.e.a().post(new b());
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onStart() {
        super.onStart();
        C0287t.N(false);
        S2.e.a().post(new I(this, 3));
        S2.a.a().addIdleHandler(new a());
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new RunnableC0359b(MmsApp.c(), 0));
        int i2 = C0401b.d(MmsApp.c()) ? 1 : 2;
        J0.b bVar = new J0.b(0);
        bVar.d("adv_setting", i2);
        bVar.b();
        if (C0401b.c() == 1) {
            Log.i("api-ad", "ad show type 1, start load ads all");
            C0345d.c().i();
        } else if (C0401b.c() == 0 && MmsApp.f4464t) {
            Log.i("api-ad", "ad show type 0, start load ads cold launch");
            C0345d.c().i();
        }
    }

    @Override // miuix.appcompat.app.h, android.app.Activity, android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return callback instanceof e.a ? super.onWindowStartingActionMode(callback) : super.onWindowStartingActionMode(new e(callback));
    }
}
