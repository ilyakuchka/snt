package Q0;

import Q0.F;
import Q0.m;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ActivityC0219o;
import androidx.lifecycle.LiveData;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.ui.FlatMessageListActivity;
import com.android.mmt.ui.MmsTabActivity;
import com.android.mmt.util.C0287t;
import java.util.Objects;
import l0.C0345d;
import l0.InterfaceC0346e;
import miuix.appcompat.app.g;
import v0.C0401b;
import x0.C0414a;
import x0.C0416c;

/* loaded from: classes.dex */
public class m extends F {

    /* renamed from: J0, reason: collision with root package name */
    public static final /* synthetic */ int f1114J0 = 0;

    /* renamed from: G0, reason: collision with root package name */
    private c f1115G0;

    /* renamed from: H0, reason: collision with root package name */
    private miuix.appcompat.app.g f1116H0;

    /* renamed from: I0, reason: collision with root package name */
    private b f1117I0;

    private class a extends F.c {

        /* renamed from: Q0.m$a$a, reason: collision with other inner class name */
        final class RunnableC0033a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f1119i;

            RunnableC0033a(int i2) {
                this.f1119i = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BugleDatabase bugleDatabaseY = BugleDatabase.y();
                L0.a aVarT = bugleDatabaseY.x().t(-100L);
                if (aVarT == null && this.f1119i > 0) {
                    aVarT = new L0.a();
                    aVarT.z(-100L);
                }
                if (aVarT != null) {
                    aVarT.G(this.f1119i);
                    bugleDatabaseY.x().p(aVarT);
                }
            }
        }

        final class b implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f1120i;

            b(int i2) {
                this.f1120i = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BugleDatabase bugleDatabaseY = BugleDatabase.y();
                L0.a aVarT = bugleDatabaseY.x().t(-103L);
                if (aVarT != null) {
                    aVarT.G(this.f1120i);
                    bugleDatabaseY.x().E(aVarT);
                }
            }
        }

        public a(ContentResolver contentResolver) {
            super(m.this, contentResolver);
        }

        @Override // Q0.q.l, com.android.mmt.util.AbstractHandlerC0272d
        protected final void c(int i2, Object obj, Cursor cursor) throws Resources.NotFoundException {
            super.c(i2, obj, cursor);
            Log.v("CommonConversation", "onQueryComplete token is " + i2);
            if (i2 == 1901) {
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            Q2.c.a(new b(cursor.getInt(0)));
                        }
                        return;
                    } finally {
                    }
                }
                return;
            }
            if (i2 == 1903) {
                ((b) m.this.q1()).l(false);
            } else if (i2 == 1904 && cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        Q2.c.a(new RunnableC0033a(cursor.getInt(0)));
                    }
                } finally {
                }
            }
        }
    }

    public class b extends F.d {
        private androidx.lifecycle.o<Boolean> d;

        /* renamed from: e, reason: collision with root package name */
        private androidx.lifecycle.o<String> f1121e;

        /* renamed from: f, reason: collision with root package name */
        private androidx.lifecycle.o<Boolean> f1122f;

        public b() {
            super(m.this);
            this.d = new androidx.lifecycle.o<>(Boolean.valueOf(com.android.mmt.util.C.c(MmsApp.c())));
            this.f1121e = new androidx.lifecycle.o<>(com.android.mmt.util.C.a(MmsApp.c()));
            this.f1122f = new androidx.lifecycle.o<>(Boolean.FALSE);
        }

        @Override // Q0.q.m
        public final void d() {
        }

        @Override // Q0.F.d, Q0.q.m
        public final void e() {
            g();
            l(true);
        }

        @Override // Q0.F.d
        public final LiveData f() {
            return this.f1080b;
        }

        @Override // Q0.F.d
        public final void g() {
            int i2 = com.android.mmt.util.C.d(m.this.B()) ? 8 : 0;
            StringBuilder sbC = C2.c.c("updatePlaceHolderType: ", i2, " | ");
            sbC.append(this.f1080b.e());
            Log.d("CommonConversation", sbC.toString());
            if (this.f1080b.e().intValue() != i2) {
                this.f1080b.n(Integer.valueOf(i2));
            }
        }

        public final LiveData<Boolean> i() {
            return this.f1122f;
        }

        public final LiveData<String> j() {
            return this.f1121e;
        }

        public final LiveData<Boolean> k() {
            return this.d;
        }

        public final void l(boolean z4) {
            if (z4) {
                C0416c.g0(m.this.f1139n0);
                return;
            }
            boolean zC = com.android.mmt.util.C.c(MmsApp.c());
            if (Boolean.compare(this.d.e().booleanValue(), zC) != 0) {
                this.d.n(Boolean.valueOf(zC));
            }
            String strA = com.android.mmt.util.C.a(MmsApp.c());
            if (TextUtils.equals(this.f1121e.e(), strA)) {
                return;
            }
            this.f1121e.n(strA);
        }

        public final void m() {
            boolean zC = C0287t.C();
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) m.this.B().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                zC = false;
            }
            if (Boolean.compare(this.f1122f.e().booleanValue(), zC) != 0) {
                this.f1122f.n(Boolean.valueOf(zC));
            }
        }
    }

    public static void G1(m mVar) {
        c cVar = mVar.f1115G0;
        if (cVar != null) {
            m.this.f1138m0.b0(1);
            mVar.f1115G0.d();
        }
    }

    public static void I1(m mVar, Boolean bool) {
        NetworkInfo activeNetworkInfo;
        Objects.requireNonNull(mVar);
        if (bool.booleanValue()) {
            ActivityC0219o activityC0219oX = mVar.x();
            if (Settings.System.getInt(activityC0219oX.getContentResolver(), "mms_upload_old_msg_state", 0) == 1 && C0287t.C() && (activeNetworkInfo = ((ConnectivityManager) activityC0219oX.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                String string = Settings.System.getString(activityC0219oX.getContentResolver(), "mms_upload_old_msg_accounts");
                miuix.appcompat.app.g gVar = mVar.f1116H0;
                if (gVar != null && gVar.isShowing()) {
                    mVar.f1116H0.dismiss();
                }
                g.a aVar = new g.a(activityC0219oX);
                aVar.x(R.string.found_old_messages_title);
                aVar.k(mVar.R(R.string.found_old_messages, string, null));
                aVar.h();
                aVar.c(true);
                aVar.t(R.string.yes, new k(activityC0219oX));
                aVar.m(R.string.no, new l(activityC0219oX));
                mVar.f1116H0 = aVar.A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // Q0.F, Q0.q
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public final F.d q1() {
        if (this.f1117I0 == null) {
            this.f1117I0 = new b();
        }
        return this.f1117I0;
    }

    @Override // Q0.z, Q0.q, androidx.fragment.app.Fragment
    public final View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f1139n0 == null) {
            this.f1139n0 = new a(B().getContentResolver());
        }
        C0345d.c().m(new InterfaceC0346e() { // from class: Q0.j
            @Override // l0.InterfaceC0346e
            public final void a() {
                m.G1(this.f1111a);
            }
        });
        return super.g0(layoutInflater, viewGroup, bundle);
    }

    @Override // Q0.F, Q0.z, Q0.q
    protected final void j1() {
        super.j1();
        if (this.f1115G0 == null) {
            this.f1115G0 = new c();
        }
        c cVar = this.f1115G0;
        cVar.d();
        cVar.e(((b) m.this.q1()).k().e().booleanValue());
        final int i2 = 0;
        ((b) q1()).k().g(this, new androidx.lifecycle.p(this) { // from class: Q0.h

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m f1108b;

            {
                this.f1108b = this;
            }

            @Override // androidx.lifecycle.p
            public final void a(Object obj) {
                switch (i2) {
                    case 0:
                        this.f1108b.f1115G0.e(((Boolean) obj).booleanValue());
                        break;
                    case 1:
                        m mVar = this.f1108b;
                        mVar.f1115G0.e(((m.b) mVar.q1()).k().e().booleanValue());
                        break;
                    default:
                        m.I1(this.f1108b, (Boolean) obj);
                        break;
                }
            }
        });
        final int i4 = 1;
        ((b) q1()).j().g(this, new androidx.lifecycle.p(this) { // from class: Q0.h

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m f1108b;

            {
                this.f1108b = this;
            }

            @Override // androidx.lifecycle.p
            public final void a(Object obj) {
                switch (i4) {
                    case 0:
                        this.f1108b.f1115G0.e(((Boolean) obj).booleanValue());
                        break;
                    case 1:
                        m mVar = this.f1108b;
                        mVar.f1115G0.e(((m.b) mVar.q1()).k().e().booleanValue());
                        break;
                    default:
                        m.I1(this.f1108b, (Boolean) obj);
                        break;
                }
            }
        });
        final int i5 = 2;
        ((b) q1()).i().g(this, new androidx.lifecycle.p(this) { // from class: Q0.h

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m f1108b;

            {
                this.f1108b = this;
            }

            @Override // androidx.lifecycle.p
            public final void a(Object obj) {
                switch (i5) {
                    case 0:
                        this.f1108b.f1115G0.e(((Boolean) obj).booleanValue());
                        break;
                    case 1:
                        m mVar = this.f1108b;
                        mVar.f1115G0.e(((m.b) mVar.q1()).k().e().booleanValue());
                        break;
                    default:
                        m.I1(this.f1108b, (Boolean) obj);
                        break;
                }
            }
        });
    }

    @Override // Q0.F, Q0.q
    protected final void l1() {
        super.l1();
    }

    @Override // Q0.q
    protected final int m1() {
        if (n1() != null) {
            return n1().f();
        }
        return 0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void n0() {
        super.n0();
    }

    @Override // Q0.F, Q0.q, androidx.fragment.app.Fragment
    public final void p0() {
        super.p0();
    }

    @Override // Q0.F, Q0.q, androidx.fragment.app.Fragment
    public final void r0() {
        super.r0();
        if (x() instanceof MmsTabActivity) {
            ((b) q1()).m();
        }
        if (x() instanceof MmsTabActivity) {
            C0414a.K();
        }
        this.f1115G0.d();
    }

    @Override // Q0.F, Q0.q, androidx.fragment.app.Fragment
    public final void s0() {
        super.s0();
    }

    @Override // Q0.q
    protected final void u1(int i2) {
        if (i2 == 0) {
            this.f1115G0.c();
            x1(true);
        }
    }

    @Override // Q0.q
    public final void v1() {
    }

    @Override // Q0.q
    protected final void x1(boolean z4) {
        if (com.android.mmt.util.C.c(B())) {
            super.x1(false);
        } else {
            super.x1(z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c {

        /* renamed from: a, reason: collision with root package name */
        private View f1123a;

        /* renamed from: b, reason: collision with root package name */
        private ViewGroup f1124b;

        final class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m mVar = m.this;
                ActivityC0219o activityC0219oX = mVar.x();
                int i2 = FlatMessageListActivity.f4821w;
                Intent intent = new Intent(activityC0219oX, (Class<?>) FlatMessageListActivity.class);
                intent.putExtra("fragment", "bookmark");
                mVar.b1(intent);
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (m.this.f1138m0.b0(1) == this.f1124b) {
                m.this.f1138m0.d0(1);
            }
            ViewGroup viewGroup = this.f1124b;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                this.f1124b = null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 15, instructions: 29 */
        public final void d() {
            Log.i("api-ad", "start show ads");
            if (m.this.f1143t0 == 0) {
                return;
            }
            if (!(!TextUtils.equals(C0401b.f(), "00000000-0000-0000-0000-000000000000"))) {
                Log.i("api-ad", "GAID has been deleted");
                J0.b.e(7);
            } else if (!C0401b.j()) {
                J0.b.e(6);
                Log.i("api-ad", "remote ad switch close");
            } else {
                if (C0401b.d(MmsApp.c())) {
                    return;
                }
                Log.i("api-ad", "switch has been closed");
                J0.b.e(2);
            }
            if (0 == 0) {
                c();
                m mVar = m.this;
                mVar.x1(mVar.f1143t0 == 0);
            } else if (m.this.x() == null || C0345d.c().f()) {
            }
        }

        public final void e(boolean z4) {
            if (!z4) {
                if (m.this.f1138m0.b0(2) == this.f1123a) {
                    m.this.f1138m0.d0(2);
                }
                m.this.n1().k();
                return;
            }
            if (this.f1123a == null) {
                View viewInflate = m.this.x().getLayoutInflater().inflate(R.layout.conversation_list_item_bookmark, (ViewGroup) m.this.f1136k0, false);
                this.f1123a = viewInflate;
                viewInflate.setOnClickListener(new a());
            }
            View viewB0 = m.this.f1138m0.b0(2);
            View view = this.f1123a;
            if (viewB0 != view) {
                m.this.f1138m0.Z(2, view);
                m.this.n1().k();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
        public static void a(c cVar) {
        }
    }
}
