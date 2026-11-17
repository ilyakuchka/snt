package com.android.mmt.ui;

import android.app.Activity;
import android.content.Context;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.R;
import com.android.mmt.ui.r;
import com.android.mmt.util.BackgroundCleaner;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.EditableListViewV2;
import f0.C0303b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import r0.C0376a;

/* renamed from: com.android.mmt.ui.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0247i0 extends C0 implements EditableListViewV2.i, EditableListViewV2.k, BackgroundCleaner.c {
    public static final String[] M = {"transport_type", "_id", "thread_id", "address", "body", "date", "date_sent", "read", "type", "status", "locked", "error_code", "ct_cls", "msg_box", "st", "sub", "sub_cs", "m_type", "d_rpt", "rr", "err_type", "m_size", "exp", "sub_id", "creator"};

    /* renamed from: N, reason: collision with root package name */
    static final String[] f5605N = {"transport_type", "_id", "thread_id", "address", "body", "date", "date_sent", "read", "type", "status", "locked", "error_code", "ct_cls", "msg_box", "st", "sub", "sub_cs", "m_type", "d_rpt", "rr", "err_type", "m_size", "exp", "sub_id", "creator"};

    /* renamed from: A, reason: collision with root package name */
    private String f5606A;

    /* renamed from: B, reason: collision with root package name */
    private long f5607B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f5608C;

    /* renamed from: D, reason: collision with root package name */
    private float f5609D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f5610E;

    /* renamed from: F, reason: collision with root package name */
    private int f5611F;

    /* renamed from: G, reason: collision with root package name */
    private C0376a f5612G;

    /* renamed from: H, reason: collision with root package name */
    private P2.a f5613H;

    /* renamed from: I, reason: collision with root package name */
    private e f5614I;

    /* renamed from: J, reason: collision with root package name */
    private Handler f5615J;

    /* renamed from: K, reason: collision with root package name */
    private Runnable f5616K;
    private d L;

    /* renamed from: i, reason: collision with root package name */
    protected LayoutInflater f5617i;

    /* renamed from: j, reason: collision with root package name */
    private final LruCache<Long, C0243g0> f5618j;

    /* renamed from: k, reason: collision with root package name */
    private R2.a f5619k;

    /* renamed from: l, reason: collision with root package name */
    private final c f5620l;

    /* renamed from: m, reason: collision with root package name */
    private f f5621m;

    /* renamed from: n, reason: collision with root package name */
    private Handler f5622n;

    /* renamed from: o, reason: collision with root package name */
    private Context f5623o;
    private O0 p;

    /* renamed from: q, reason: collision with root package name */
    private String f5624q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5625r;

    /* renamed from: s, reason: collision with root package name */
    private int f5626s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f5627t;
    private boolean u;

    /* renamed from: v, reason: collision with root package name */
    private long f5628v;

    /* renamed from: w, reason: collision with root package name */
    private String f5629w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f5630x;

    /* renamed from: y, reason: collision with root package name */
    private HashSet<Long> f5631y;

    /* renamed from: z, reason: collision with root package name */
    private String f5632z;

    /* renamed from: com.android.mmt.ui.i0$a */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0247i0.this.U();
        }
    }

    /* renamed from: com.android.mmt.ui.i0$b */
    final class b implements d {
        b() {
        }

        @Override // com.android.mmt.ui.C0247i0.d
        public final C0243g0 a(int i2) {
            C0247i0 c0247i0 = C0247i0.this;
            return C0247i0.J(c0247i0, c0247i0.d);
        }

        @Override // com.android.mmt.ui.C0247i0.d
        public final C0243g0 b(int i2) {
            C0243g0 c0243g0J;
            if (C0247i0.this.d.moveToPrevious()) {
                C0247i0 c0247i0 = C0247i0.this;
                c0243g0J = C0247i0.J(c0247i0, c0247i0.d);
            } else {
                c0243g0J = null;
            }
            C0247i0.this.d.moveToNext();
            return c0243g0J;
        }

        @Override // com.android.mmt.ui.C0247i0.d
        public final C0243g0 c(int i2) {
            C0243g0 c0243g0J;
            if (C0247i0.this.d.moveToNext()) {
                C0247i0 c0247i0 = C0247i0.this;
                c0243g0J = C0247i0.J(c0247i0, c0247i0.d);
            } else {
                c0243g0J = null;
            }
            C0247i0.this.d.moveToPrevious();
            return c0243g0J;
        }
    }

    /* renamed from: com.android.mmt.ui.i0$d */
    public interface d {
        C0243g0 a(int i2);

        C0243g0 b(int i2);

        C0243g0 c(int i2);
    }

    /* renamed from: com.android.mmt.ui.i0$e */
    private static class e {
        public e(C0247i0 c0247i0) {
            new WeakReference(c0247i0);
        }
    }

    /* renamed from: com.android.mmt.ui.i0$f */
    public interface f {
    }

    /* renamed from: com.android.mmt.ui.i0$g */
    static class g extends RecyclerView.x {
        public g(View view) {
            super(view);
        }
    }

    public C0247i0(Context context, Cursor cursor, RecyclerView recyclerView) {
        this(context, cursor, recyclerView, false, false, 0L, null, null, 0L);
        this.f5624q = "LIST";
        this.f5625r = false;
        this.f5626s = 0;
    }

    static C0243g0 J(C0247i0 c0247i0, Cursor cursor) {
        return c0247i0.O(cursor, true);
    }

    private C0243g0 O(Cursor cursor, boolean z4) {
        return P(cursor.getString(this.f5620l.f5635a), cursor.getLong(this.f5620l.f5636b), cursor, z4);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int R(String str, boolean z4, int i2, d dVar, int i4) {
        C0243g0 c0243g0A = dVar.a(i4);
        if (c0243g0A == null) {
            return -1;
        }
        if (c0243g0A.s() == -1) {
            C0243g0 c0243g0B = dVar.b(i4);
            C0243g0 c0243g0C = dVar.c(i4);
            boolean z5 = !z4;
            boolean z6 = true;
            if (c0243g0B != null) {
                long jQ = c0243g0A.q() - c0243g0B.q();
                if (!z4 || C0287t.q(c0243g0A.E()) != C0287t.q(c0243g0B.E()) || jQ >= 600000) {
                    z5 = true;
                }
                if (c0243g0C != null) {
                    long jQ2 = c0243g0C.q() - c0243g0A.q();
                    if (z4 && jQ2 < 20000 && C0287t.q(c0243g0C.E()) == C0287t.q(c0243g0A.E())) {
                        if (c0243g0C.V() == c0243g0A.V()) {
                            z6 = false;
                        }
                    }
                }
                c0243g0A.K(str, z5, i2, z6);
            }
        }
        return c0243g0A.s();
    }

    @Override // com.android.mmt.ui.C0
    public final void H(RecyclerView.x xVar, Cursor cursor) {
        boolean zContains = this.f5630x ? this.f5631y.contains(Long.valueOf(P0.r.i(cursor.getString(this.f5620l.f5635a), cursor.getLong(this.f5620l.f5636b)))) : false;
        C0243g0 c0243g0O = O(cursor, true);
        j();
        cursor.getPosition();
        Objects.requireNonNull(c0243g0O);
        String str = P0.r.i(c0243g0O.I(), c0243g0O.z()) == this.f5607B ? this.f5606A : null;
        MessageListItem messageListItem = (MessageListItem) xVar.f4055i;
        Objects.requireNonNull(messageListItem);
        messageListItem.L(c0243g0O, this.f5630x, zContains, this.f5610E, this.f5632z, str);
        float f4 = this.f5609D;
        if (f4 != 0.0f) {
            ((MessageListItem) xVar.f4055i).M(f4);
        }
        cursor.getPosition();
    }

    @Override // com.android.mmt.ui.C0
    protected final void I() {
        f fVar;
        r.c cVar;
        r rVar;
        Handler handler;
        Cursor cursor = this.d;
        if (cursor == null || cursor.isClosed() || (fVar = this.f5621m) == null || (handler = (rVar = r.this).f5273y0) == null) {
            return;
        }
        handler.removeCallbacks(rVar.f5691D1);
        r rVar2 = r.this;
        rVar2.f5273y0.postDelayed(rVar2.f5691D1, 50L);
    }

    public final void K() {
        this.f5630x = true;
    }

    public final void L() {
        this.f5630x = false;
        this.f5631y = S2.d.l(new Long[0]);
    }

    public final C0376a M() {
        return this.f5612G;
    }

    public final C0243g0 N(int i2) {
        Cursor cursor = (Cursor) G(i2);
        if (cursor == null || cursor.isBeforeFirst() || cursor.isAfterLast()) {
            return null;
        }
        return O(cursor, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0243g0 P(String str, long j2, Cursor cursor, boolean z4) {
        C0243g0 c0243g0;
        long jI = P0.r.i(str, j2);
        C0243g0 c0243g02 = this.f5618j.get(Long.valueOf(jI));
        if (c0243g02 == null) {
            if (cursor != null) {
                if ((cursor.isClosed() || cursor.isBeforeFirst() || cursor.isAfterLast()) ? false : true) {
                    try {
                        int i2 = this.f5608C ? 8 : 0;
                        c0243g0 = new C0243g0(this.f5623o, str, cursor, this.f5620l, this.f5628v, this.f5629w, (this.u || this.f5627t) ? i2 | 2 : i2, z4);
                    } catch (C0303b e2) {
                        e = e2;
                        c0243g0 = null;
                    }
                    try {
                        new WeakReference(this.f5614I);
                    } catch (C0303b e4) {
                        e = e4;
                        Log.e("MessageListAdapter", "createCachedMessageItem :", e);
                        c0243g02 = c0243g0;
                        if (c0243g02 != null) {
                        }
                    }
                    c0243g02 = c0243g0;
                } else {
                    c0243g02 = null;
                }
                if (c0243g02 != null) {
                    Log.e("MessageListAdapter", "getCachedMessageItem: " + jI + " null");
                    return null;
                }
                this.f5618j.put(Long.valueOf(jI), c0243g02);
            }
        } else if (z4) {
            Log.e("MessageListAdapter", "getCachedMessageItem: " + jI + " createItemExtra");
            c0243g02.c();
        }
        return c0243g02;
    }

    public final List<C0243g0> Q(Set<Integer> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(O((Cursor) G(it.next().intValue()), false));
        }
        return arrayList;
    }

    public final long S(Cursor cursor) {
        C0243g0 c0243g0 = null;
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToLast()) {
            C0243g0 c0243g0O = O(cursor, true);
            if (c0243g0O == null || c0243g0O.i() != 1 || !"sms".equals(c0243g0O.I())) {
                int i2 = 5;
                while (true) {
                    if (cursor.moveToPrevious() && i2 > 0) {
                        i2--;
                        C0243g0 c0243g0O2 = O(cursor, true);
                        if (c0243g0O2 != null && c0243g0O2.i() == 1 && "sms".equals(c0243g0O2.I())) {
                            c0243g0 = c0243g0O2;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                c0243g0 = c0243g0O;
            }
        }
        if (c0243g0 != null) {
            return c0243g0.z();
        }
        return -1L;
    }

    public final void T(String str, boolean z4, int i2) {
        this.f5624q = str;
        this.f5625r = z4;
        this.f5626s = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void U() {
        f fVar = this.f5621m;
        if (fVar == null) {
            LruCache<Long, C0243g0> lruCache = this.f5618j;
            if (lruCache != null) {
                lruCache.evictAll();
            }
        } else {
            MessageListPullViewV2 messageListPullViewV2 = r.this.f5694P0;
            if (messageListPullViewV2 != null ? messageListPullViewV2.H1() : false) {
                Log.v("MessageListAdapter", "hold cache item");
            }
        }
        n();
        f fVar2 = this.f5621m;
        if (fVar2 != null) {
            r.this.f5701W0 = true;
        }
    }

    public final void V() {
        Handler handler = this.f5615J;
        if (handler != null) {
            handler.removeCallbacks(this.f5616K);
        }
        Handler handler2 = this.f5622n;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        R2.a aVar = this.f5619k;
        if (aVar != null) {
            aVar.a();
        }
        U2.c.b(R.layout.message_list_item_bubble);
        this.f5614I = null;
    }

    public final void W(int i2) {
        this.f5611F = i2;
    }

    public final void X(boolean z4) {
        this.f5610E = z4;
    }

    public final void Y(HashSet<Long> hashSet) {
        this.f5631y = hashSet;
    }

    public final void Z() {
        this.f5608C = false;
    }

    public final void a0(Handler handler) {
        this.f5622n = handler;
    }

    @Override // com.android.mmt.util.BackgroundCleaner.c
    public final void b() {
        this.f5618j.evictAll();
        R2.a aVar = this.f5619k;
        if (aVar != null) {
            aVar.a();
        }
        U2.c.b(R.layout.message_list_item_bubble);
    }

    public final void b0(f fVar) {
        this.f5621m = fVar;
    }

    @Override // com.android.mmt.util.EditableListViewV2.k
    public final boolean c(int i2) {
        return O((Cursor) G(i2), false) != null;
    }

    public final void c0(float f4) {
        this.f5609D = f4;
    }

    @Override // com.android.mmt.util.EditableListViewV2.k
    public final int d() {
        return -1;
    }

    public final void d0(String str) {
        this.f5629w = str;
    }

    @Override // com.android.mmt.ui.C0, com.android.mmt.ui.G.a
    public final void e(Cursor cursor) {
        super.e(cursor);
        this.f5613H.d();
        U();
    }

    @Override // com.android.mmt.util.EditableListViewV2.i
    public final long h(int i2) {
        Cursor cursor = (Cursor) G(i2);
        return P0.r.i(cursor.getString(this.f5620l.f5635a), cursor.getLong(this.f5620l.f5636b));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int l(int i2) {
        CursorWindow window;
        Cursor cursor = this.d;
        int i4 = i2 - 1;
        if (i4 < 0) {
            i4 = 0;
        }
        if (cursor instanceof CursorWrapper) {
            Cursor wrappedCursor = ((CursorWrapper) cursor).getWrappedCursor();
            if ((wrappedCursor instanceof AbstractWindowedCursor) && (window = ((AbstractWindowedCursor) wrappedCursor).getWindow()) != null && i4 < window.getStartPosition()) {
                int i5 = i4 - 1000;
                wrappedCursor.moveToPosition(i5 >= 0 ? i5 : 0);
            }
        }
        this.d.moveToPosition(i2);
        return R(this.f5624q, this.f5625r, this.f5626s, this.L, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final RecyclerView.x y(ViewGroup viewGroup, int i2) {
        C0243g0 c0243g0O = O(this.d, true);
        MessageListItem messageListItem = c0243g0O.S() ? (MessageListItem) this.f5617i.inflate(R.layout.message_list_item_list, viewGroup, false) : (MessageListItem) U2.c.c(this.f5623o, viewGroup).d();
        Objects.requireNonNull(messageListItem);
        messageListItem.q(c0243g0O);
        messageListItem.f4927E = this.f5622n;
        O0 o02 = this.p;
        o02.i(messageListItem.G(o02, this.f5611F));
        return new g(messageListItem);
    }

    public C0247i0(Context context, Cursor cursor, RecyclerView recyclerView, boolean z4, boolean z5, long j2, String str, String str2, long j4) {
        super(cursor);
        this.f5630x = false;
        this.f5631y = S2.d.l(new Long[0]);
        this.f5611F = 0;
        this.f5612G = new C0376a();
        this.f5615J = new Handler(Looper.getMainLooper());
        this.f5616K = new a();
        this.L = new b();
        this.f5619k = new R2.a();
        this.f5623o = context;
        this.f5632z = str;
        this.f5606A = str2;
        this.f5607B = j4;
        this.f5617i = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f5618j = new LruCache<>(500);
        if (z4) {
            this.f5620l = new c();
        } else {
            this.f5620l = new c(cursor, true);
        }
        this.f5627t = z5;
        this.u = false;
        this.f5628v = j2;
        recyclerView.v0(new C0245h0());
        this.p = (O0) recyclerView;
        this.f5613H = new P2.a((Activity) this.f5623o);
        BackgroundCleaner.j().k(this);
        this.f5614I = new e(this);
        new WeakReference(this);
        Context context2 = this.f5623o;
        Cursor cursor2 = this.d;
        U2.c.e(context2, recyclerView, (cursor2 == null || cursor2.getCount() < 16) ? 10 : 16);
    }

    /* renamed from: com.android.mmt.ui.i0$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f5635a;

        /* renamed from: b, reason: collision with root package name */
        public int f5636b;

        /* renamed from: c, reason: collision with root package name */
        public int f5637c;
        public int d;

        /* renamed from: e, reason: collision with root package name */
        public int f5638e;

        /* renamed from: f, reason: collision with root package name */
        public int f5639f;
        public int g;

        /* renamed from: h, reason: collision with root package name */
        public int f5640h;

        /* renamed from: i, reason: collision with root package name */
        public int f5641i;

        /* renamed from: j, reason: collision with root package name */
        public int f5642j;

        /* renamed from: k, reason: collision with root package name */
        public int f5643k;

        /* renamed from: l, reason: collision with root package name */
        public int f5644l;

        /* renamed from: m, reason: collision with root package name */
        public int f5645m;

        /* renamed from: n, reason: collision with root package name */
        public int f5646n;

        /* renamed from: o, reason: collision with root package name */
        public int f5647o;
        public int p;

        /* renamed from: q, reason: collision with root package name */
        public int f5648q;

        /* renamed from: r, reason: collision with root package name */
        public int f5649r;

        /* renamed from: s, reason: collision with root package name */
        public int f5650s;

        /* renamed from: t, reason: collision with root package name */
        public int f5651t;
        public int u;

        /* renamed from: v, reason: collision with root package name */
        public int f5652v;

        /* renamed from: w, reason: collision with root package name */
        public int f5653w;

        /* renamed from: x, reason: collision with root package name */
        public int f5654x;

        public c() {
            this.f5635a = 0;
            this.f5636b = 1;
            this.f5637c = 2;
            this.d = 3;
            this.f5638e = 4;
            this.f5639f = 5;
            this.g = 6;
            this.f5640h = 8;
            this.f5641i = 9;
            this.f5642j = 10;
            this.f5643k = 11;
            this.f5644l = 15;
            this.f5645m = 16;
            this.f5646n = 5;
            this.f5647o = 6;
            this.p = 17;
            this.f5648q = 13;
            this.f5649r = 20;
            this.f5650s = 10;
            this.f5651t = 12;
            this.u = 21;
            this.f5652v = 22;
            this.f5653w = 23;
            this.f5654x = 14;
        }

        public c(Cursor cursor, boolean z4) throws IllegalArgumentException {
            try {
                this.f5635a = cursor.getColumnIndexOrThrow("transport_type");
            } catch (IllegalArgumentException e2) {
                if (z4) {
                    Log.w("colsMap", e2.getMessage());
                }
            }
            try {
                this.f5636b = cursor.getColumnIndexOrThrow("_id");
            } catch (IllegalArgumentException e4) {
                if (z4) {
                    Log.w("colsMap", e4.getMessage());
                }
            }
            try {
                this.f5637c = cursor.getColumnIndexOrThrow("thread_id");
            } catch (IllegalArgumentException e5) {
                if (z4) {
                    Log.w("colsMap", e5.getMessage());
                }
            }
            try {
                this.d = cursor.getColumnIndexOrThrow("address");
            } catch (IllegalArgumentException e6) {
                if (z4) {
                    Log.w("colsMap", e6.getMessage());
                }
            }
            try {
                this.f5638e = cursor.getColumnIndexOrThrow("body");
            } catch (IllegalArgumentException e7) {
                if (z4) {
                    Log.w("colsMap", e7.getMessage());
                }
            }
            try {
                this.f5639f = cursor.getColumnIndexOrThrow("date");
            } catch (IllegalArgumentException e8) {
                if (z4) {
                    Log.w("colsMap", e8.getMessage());
                }
            }
            try {
                this.g = cursor.getColumnIndexOrThrow("date_sent");
            } catch (IllegalArgumentException e9) {
                if (z4) {
                    Log.w("colsMap", e9.getMessage());
                }
            }
            try {
                this.f5640h = cursor.getColumnIndexOrThrow("type");
            } catch (IllegalArgumentException e10) {
                if (z4) {
                    Log.w("colsMap", e10.getMessage());
                }
            }
            try {
                this.f5641i = cursor.getColumnIndexOrThrow("status");
            } catch (IllegalArgumentException e11) {
                if (z4) {
                    Log.w("colsMap", e11.getMessage());
                }
            }
            try {
                this.f5642j = cursor.getColumnIndexOrThrow("locked");
            } catch (IllegalArgumentException e12) {
                if (z4) {
                    Log.w("colsMap", e12.getMessage());
                }
            }
            try {
                this.f5643k = cursor.getColumnIndexOrThrow("error_code");
            } catch (IllegalArgumentException e13) {
                if (z4) {
                    Log.w("colsMap", e13.getMessage());
                }
            }
            try {
                this.f5644l = cursor.getColumnIndexOrThrow("sub");
            } catch (IllegalArgumentException e14) {
                if (z4) {
                    Log.w("colsMap", e14.getMessage());
                }
            }
            try {
                this.f5645m = cursor.getColumnIndexOrThrow("sub_cs");
            } catch (IllegalArgumentException e15) {
                if (z4) {
                    Log.w("colsMap", e15.getMessage());
                }
            }
            this.f5646n = this.f5639f;
            this.f5647o = this.g;
            try {
                this.p = cursor.getColumnIndexOrThrow("m_type");
            } catch (IllegalArgumentException e16) {
                if (z4) {
                    Log.w("colsMap", e16.getMessage());
                }
            }
            try {
                this.f5648q = cursor.getColumnIndexOrThrow("msg_box");
            } catch (IllegalArgumentException e17) {
                Log.w("colsMap", e17.getMessage());
            }
            try {
                cursor.getColumnIndexOrThrow("d_rpt");
            } catch (IllegalArgumentException e18) {
                if (z4) {
                    Log.w("colsMap", e18.getMessage());
                }
            }
            try {
                cursor.getColumnIndexOrThrow("rr");
            } catch (IllegalArgumentException e19) {
                if (z4) {
                    Log.w("colsMap", e19.getMessage());
                }
            }
            try {
                this.f5649r = cursor.getColumnIndexOrThrow("err_type");
            } catch (IllegalArgumentException e20) {
                if (z4) {
                    Log.w("colsMap", e20.getMessage());
                }
            }
            this.f5650s = this.f5642j;
            try {
                this.f5651t = cursor.getColumnIndexOrThrow("ct_l");
            } catch (IllegalArgumentException e21) {
                Log.w("colsMap", e21.getMessage());
            }
            try {
                this.u = cursor.getColumnIndexOrThrow("m_size");
            } catch (IllegalArgumentException e22) {
                if (z4) {
                    Log.w("colsMap", e22.getMessage());
                }
            }
            try {
                this.f5652v = cursor.getColumnIndexOrThrow("exp");
            } catch (IllegalArgumentException e23) {
                if (z4) {
                    Log.w("colsMap", e23.getMessage());
                }
            }
            try {
                this.f5653w = cursor.getColumnIndexOrThrow("sub_id");
            } catch (IllegalArgumentException e24) {
                if (z4) {
                    Log.w("colsMap", e24.getMessage());
                }
            }
            try {
                this.f5654x = cursor.getColumnIndexOrThrow("st");
            } catch (IllegalArgumentException e25) {
                if (z4) {
                    Log.w("colsMap", e25.getMessage());
                }
            }
        }
    }
}
