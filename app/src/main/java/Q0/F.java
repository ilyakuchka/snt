package Q0;

import Q0.q;
import Q0.z;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.ContentResolver;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.util.c0;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class F extends z {

    /* renamed from: F0, reason: collision with root package name */
    public static final /* synthetic */ int f1070F0 = 0;

    /* renamed from: A0, reason: collision with root package name */
    private OnAccountsUpdateListener f1071A0;

    /* renamed from: B0, reason: collision with root package name */
    private long f1072B0;

    /* renamed from: C0, reason: collision with root package name */
    private Handler f1073C0;

    /* renamed from: D0, reason: collision with root package name */
    private boolean f1074D0 = true;

    /* renamed from: E0, reason: collision with root package name */
    private boolean f1075E0 = true;

    /* renamed from: y0, reason: collision with root package name */
    private d f1076y0;

    /* renamed from: z0, reason: collision with root package name */
    protected View f1077z0;

    final class a implements OnAccountsUpdateListener {
        a() {
        }

        @Override // android.accounts.OnAccountsUpdateListener
        public final void onAccountsUpdated(Account[] accountArr) {
            F.this.q1().h();
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            F.this.f1077z0.setEnabled(false);
        }
    }

    protected class c extends q.l {
        public c(F f4, ContentResolver contentResolver) {
            super(contentResolver);
        }
    }

    protected class d extends z.c {

        /* renamed from: b, reason: collision with root package name */
        protected androidx.lifecycle.o<Integer> f1080b;

        /* renamed from: c, reason: collision with root package name */
        protected androidx.lifecycle.o<Boolean> f1081c;

        public d(F f4) {
            super(f4);
            this.f1080b = new androidx.lifecycle.o<>(0);
            this.f1081c = new androidx.lifecycle.o<>(Boolean.FALSE);
            h();
        }

        @Override // Q0.q.m
        public void e() {
            g();
        }

        public LiveData<Integer> f() {
            return this.f1080b;
        }

        public void g() {
        }

        public void h() {
            MmsApp.c();
            if (Boolean.compare(this.f1081c.e().booleanValue(), false) != 0) {
                this.f1081c.n(false);
            }
        }
    }

    public static void C1(F f4, N.i iVar) {
        Objects.requireNonNull(f4);
        StringBuilder sb = new StringBuilder();
        sb.append("PageList change size is : ");
        sb.append(iVar == null ? 0 : iVar.size());
        Log.d("TabConversationF", sb.toString());
        if (System.currentTimeMillis() - f4.f1072B0 < 500 && D0.b.f80a) {
            f4.f1136k0.y0(0);
            D0.b.f80a = false;
        }
        f4.f1138m0.I(iVar);
        if (f4.f1073C0 == null) {
            f4.f1073C0 = new D(f4);
        }
        if (f4.f1073C0.hasMessages(1)) {
            f4.f1073C0.removeMessages(1);
        }
        f4.f1073C0.sendEmptyMessageDelayed(1, f4.f1074D0 ? 100L : 500L);
        iVar.size();
    }

    @Override // Q0.z
    protected final void A1() {
        super.A1();
    }

    @Override // Q0.z
    public final void B1(boolean z4) {
        if (z4) {
            this.f1077z0.setVisibility(8);
        } else {
            this.f1077z0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // Q0.q
    /* renamed from: F1 */
    public d q1() {
        if (this.f1076y0 == null) {
            this.f1076y0 = new d(this);
        }
        return this.f1076y0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void e0(Bundle bundle) {
        super.e0(bundle);
        this.f1141r0 = false;
    }

    @Override // Q0.q, androidx.fragment.app.Fragment
    public final void i0() {
        if (this.f1071A0 != null) {
            AccountManager.get(MmsApp.c()).removeOnAccountsUpdatedListener(this.f1071A0);
        }
        super.i0();
    }

    @Override // Q0.z, Q0.q
    protected void j1() {
        super.j1();
        View viewFindViewById = this.f1134i0.findViewById(R.id.fab);
        this.f1077z0 = viewFindViewById;
        viewFindViewById.setOnClickListener(new E(this));
    }

    @Override // Q0.q
    protected void l1() {
        if (this.f1071A0 == null) {
            this.f1071A0 = new a();
        }
        if (c0.a(MmsApp.c())) {
            Y1.a.d("sms function disabled, disable floating button", new Object[0]);
            S2.e.a().post(new b());
        }
    }

    @Override // Q0.q, androidx.fragment.app.Fragment
    public void p0() {
        super.p0();
        this.f1072B0 = System.currentTimeMillis();
    }

    @Override // Q0.z, Q0.q
    protected final int p1() {
        return R.layout.fragment_conversation_tab;
    }

    @Override // Q0.q, androidx.fragment.app.Fragment
    public void r0() {
        super.r0();
    }

    @Override // Q0.q
    protected final void r1() {
        q1().f().g(this, new C(this, 0));
    }

    @Override // Q0.q, androidx.fragment.app.Fragment
    public void s0() {
        super.s0();
    }

    @Override // Q0.q
    public final void t1(boolean z4) {
        if (z4) {
            this.f1077z0.setVisibility(8);
        } else {
            this.f1077z0.setVisibility(0);
        }
    }

    @Override // Q0.q
    protected final void y1() {
        super.A1();
        if (!this.f1075E0) {
            this.f1138m0.n();
        }
        this.f1075E0 = false;
    }
}
