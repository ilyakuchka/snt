package com.android.mmt.ui;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.C0269z;
import com.android.mmt.ui.O0;
import com.android.mmt.util.EditableListViewV2;
import java.util.ArrayList;
import java.util.List;
import x0.C0416c;

/* loaded from: classes.dex */
public class E0 extends C0269z {

    /* renamed from: P0, reason: collision with root package name */
    public static final /* synthetic */ int f4766P0 = 0;

    /* renamed from: M0, reason: collision with root package name */
    private List<Integer> f4767M0 = new ArrayList(4);

    /* renamed from: N0, reason: collision with root package name */
    private List<String> f4768N0 = new ArrayList(4);

    /* renamed from: O0, reason: collision with root package name */
    public int f4769O0;

    final class a extends C0269z.l {
        a(E0 e02) {
            super();
        }
    }

    final class b implements O0.d {
        b() {
        }

        @Override // com.android.mmt.ui.O0.d
        public final void a(RecyclerView recyclerView, View view, int i2) {
            E0 e02 = E0.this;
            long jI = C0416c.u(E0.this.f5790c0, (Cursor) e02.f5797j0.G(i2 - e02.f5795h0.N0())).I();
            Log.d("ServiceProviderConversationFragment", "onListItemClick: pos=" + i2 + ", view=" + view + ", tid=" + jI);
            E0.this.b1(ComposeMessageRouterActivity.a(E0.this.f5790c0, jI));
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList, java.util.List<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    public E0() {
        this.f4769O0 = 1;
        this.f4767M0.add(1);
        this.f4767M0.add(2);
        Application applicationC = MmsApp.c();
        this.f4768N0.add(applicationC.getString(R.string.sp_category_all));
        this.f4768N0.add(applicationC.getString(R.string.sp_category_bank));
        this.f4769O0 = 1;
    }

    @Override // com.android.mmt.ui.C0269z
    protected final void D1(Context context) {
        this.p0 = false;
        F f4 = this.f5797j0;
        if (f4 != null) {
            f4.Q(false);
            this.f5797j0.T(this.f5807v0);
        }
    }

    @Override // com.android.mmt.ui.C0269z
    protected final void F1() {
        C0416c.V(this.f5790c0.getApplicationContext(), this.f4769O0);
    }

    @Override // com.android.mmt.ui.C0269z
    protected final void H1(boolean z4) {
        try {
            this.f5798k0.a(1701);
            C0416c.f0(this.f5798k0);
        } catch (SQLiteException e2) {
            com.android.mmt.util.O.a(this.f5790c0, e2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void f0() {
    }

    @Override // com.android.mmt.ui.C0269z, androidx.fragment.app.Fragment
    public final View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5790c0 = x();
        this.f5798k0 = new C0269z.m(this.f5790c0.getContentResolver());
        this.f5791d0 = layoutInflater.inflate(R.layout.conversation_list_screen_other, viewGroup, false);
        B();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        this.f5799l0 = linearLayoutManager;
        linearLayoutManager.q1(1);
        EditableListViewV2 editableListViewV2 = (EditableListViewV2) this.f5791d0.findViewById(android.R.id.list);
        this.f5795h0 = editableListViewV2;
        editableListViewV2.setOnKeyListener(this.f5787I0);
        this.f5795h0.u0(this.f5799l0);
        this.f5795h0.K1(new a(this));
        F f4 = new F(this.f5790c0);
        this.f5797j0 = f4;
        this.f5795h0.p0(f4);
        this.f5795h0.v0(this.f5797j0);
        this.f5795h0.U0(new b());
        E1();
        return this.f5791d0;
    }
}
