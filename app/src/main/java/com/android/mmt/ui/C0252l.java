package com.android.mmt.ui;

import P0.InterfaceC0164j;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.R;
import com.android.mmt.ui.K;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import miuix.appcompat.app.g;

/* renamed from: com.android.mmt.ui.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0252l extends miuix.appcompat.app.j implements InterfaceC0164j, K.e {

    /* renamed from: f0, reason: collision with root package name */
    private C0254m f5661f0;

    /* renamed from: g0, reason: collision with root package name */
    private a f5662g0;

    /* renamed from: h0, reason: collision with root package name */
    private miuix.appcompat.app.h f5663h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f5664i0;

    /* renamed from: j0, reason: collision with root package name */
    private RecyclerView f5665j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f5666k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f5667l0 = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.android.mmt.ui.l$a */
    class a {

        /* renamed from: a, reason: collision with root package name */
        private C0243g0 f5668a;

        a() {
        }

        public final void b() {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.f5668a);
            P0.r.c(C0252l.this.f5663h0, arrayList);
        }

        public final void c() {
            miuix.appcompat.app.h hVar = C0252l.this.f5663h0;
            C0243g0[] c0243g0Arr = {this.f5668a};
            ArrayList arrayList = new ArrayList(6);
            Collections.addAll(arrayList, c0243g0Arr);
            P0.r.f(hVar, arrayList);
        }

        public final String d() {
            return this.f5668a.g();
        }

        public final void e() {
            Intent intent = new Intent();
            if (this.f5668a.U() && this.f5668a.P()) {
                intent.putExtra("msg_uri", this.f5668a.v());
                intent.putExtra("subject", this.f5668a.F());
            } else {
                String strG = this.f5668a.g();
                if (strG == null) {
                    strG = "";
                }
                intent.putExtra("android.intent.extra.shortcut.NAME", strG);
            }
            PickerActivity pickerActivity = (PickerActivity) C0252l.this.f5663h0;
            pickerActivity.setResult(-1, intent);
            pickerActivity.finish();
        }

        public final void f(C0243g0 c0243g0) {
            this.f5668a = c0243g0;
        }

        public final void g() {
            long jH = this.f5668a.H();
            Intent intentA = ComposeMessageRouterActivity.a(C0252l.this.f5663h0, jH);
            intentA.setData(ComposeMessageRouterActivity.b(jH, P0.r.i(this.f5668a.I(), this.f5668a.z()), null, null));
            ComposeMessageRouterActivity.e(C0252l.this.f5663h0, intentA);
        }
    }

    @Override // P0.InterfaceC0164j
    public final void d(float f4) {
        C0254m c0254m = this.f5661f0;
        if (c0254m != null) {
            c0254m.S(f4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean d0(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            if (this.f5662g0.f5668a.f() == 0) {
                i1(new String[]{"android.permission.READ_MEDIA_AUDIO"});
            } else if (this.f5662g0.f5668a.f() == 1) {
                i1(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"});
            } else if (this.f5662g0.f5668a.f() == 2) {
                i1(new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"});
            } else {
                i1(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
            }
            return true;
        }
        if (itemId == 1) {
            this.f5662g0.b();
            return true;
        }
        if (itemId == 2) {
            this.f5662g0.c();
            return true;
        }
        if (itemId == 3) {
            this.f5662g0.g();
            return true;
        }
        if (itemId != 4) {
            return false;
        }
        a aVar = this.f5662g0;
        g.a aVar2 = new g.a(C0252l.this.f5663h0);
        aVar2.x(R.string.delete_bookmark);
        aVar2.j(R.string.bookmark_confirm_delete_message);
        aVar2.h();
        aVar2.c(true);
        aVar2.t(R.string.yes, new DialogInterfaceOnClickListenerC0248j(aVar));
        aVar2.m(R.string.no, null);
        aVar2.A();
        return true;
    }

    @Override // miuix.appcompat.app.j, androidx.fragment.app.Fragment
    public final void e0(Bundle bundle) {
        super.e0(bundle);
        d1();
    }

    public final void g1(MessageListItem messageListItem, int i2) {
        if (i2 < 0) {
            return;
        }
        C0243g0 c0243g0L = this.f5661f0.L(i2);
        if (c0243g0L == null) {
            Log.w("BookmarkFragment", "messageItem is null");
            return;
        }
        this.f5662g0.f(c0243g0L);
        if (this.f5667l0) {
            this.f5662g0.e();
        } else {
            if (messageListItem.getParent() == null || !(messageListItem instanceof BookmarkListItem)) {
                return;
            }
            this.f5662g0.g();
        }
    }

    public final void h1(boolean z4) {
        this.f5666k0.setVisibility(z4 ? 0 : 8);
    }

    @Override // miuix.appcompat.app.j, androidx.fragment.app.Fragment
    public final void i0() {
        C0254m c0254m = this.f5661f0;
        if (c0254m != null) {
            c0254m.Q(null);
        }
        super.i0();
    }

    public final void i1(String[] strArr) {
        miuix.appcompat.app.h hVar = this.f5663h0;
        if (!O2.a.a()) {
            strArr = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        if (com.android.mmt.util.A.k(hVar, strArr, 1029)) {
            return;
        }
        a aVar = this.f5662g0;
        Objects.requireNonNull(aVar);
        new AsyncTaskC0250k(aVar, C0252l.this.x()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    @Override // miuix.appcompat.app.j, miuix.appcompat.app.l
    public final View o(LayoutInflater layoutInflater) {
        this.f5664i0 = layoutInflater.inflate(R.layout.bookmark, (ViewGroup) null);
        miuix.appcompat.app.h hVarC1 = c1();
        this.f5663h0 = hVarC1;
        hVarC1.setTitle(R.string.bookmark_list_title);
        if (this.f5663h0 instanceof PickerActivity) {
            this.f5667l0 = true;
        }
        this.f5662g0 = new a();
        C0254m c0254m = new C0254m(this.f5663h0);
        this.f5661f0 = c0254m;
        c0254m.R(this);
        this.f5665j0 = (RecyclerView) this.f5664i0.findViewById(android.R.id.list);
        B();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.q1(1);
        this.f5665j0.u0(linearLayoutManager);
        this.f5665j0.p0(this.f5661f0);
        this.f5665j0.setOnCreateContextMenuListener(this);
        this.f5666k0 = this.f5664i0.findViewById(R.id.empty);
        T0();
        return this.f5664i0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void o0(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1029) {
            com.android.mmt.util.A.c(x(), strArr);
            for (int i4 : iArr) {
                if (i4 != 0) {
                    return;
                }
            }
            a aVar = this.f5662g0;
            Objects.requireNonNull(aVar);
            new AsyncTaskC0250k(aVar, C0252l.this.x()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (this.f5667l0) {
            return;
        }
        C0243g0 c0243g0L = this.f5661f0.L(this.f5661f0.M());
        if (c0243g0L == null) {
            return;
        }
        this.f5662g0.f(c0243g0L);
        contextMenu.setHeaderTitle(this.f5662g0.d());
        if (c0243g0L.U() && (c0243g0L.w() == 2 || c0243g0L.w() == 3 || c0243g0L.w() == 4 || c0243g0L.w() == 6)) {
            contextMenu.add(0, 0, 0, c0243g0L.U() && c0243g0L.w() == 6 ? N().getString(R.string.copy_to_sdcard) : N().getString(R.string.save));
        }
        contextMenu.add(0, 1, 0, N().getString(R.string.copy_message_text));
        contextMenu.add(0, 2, 0, N().getString(R.string.menu_forward));
        contextMenu.add(0, 4, 0, N().getString(R.string.delete_bookmark));
        if (c0243g0L.U() && !c0243g0L.J()) {
            contextMenu.removeItem(1);
        }
        if (c0243g0L.U() && c0243g0L.w() == 6) {
            contextMenu.removeItem(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void r0() {
        super.r0();
        this.f5661f0.N();
        P0.G.b().e(this, this.f5663h0);
        P0.G.b().g();
    }

    @Override // miuix.appcompat.app.j, androidx.fragment.app.Fragment
    public final void s0() {
        C0254m c0254m = this.f5661f0;
        if (c0254m != null) {
            c0254m.T();
        }
        super.s0();
        P0.G.a(this);
    }
}
