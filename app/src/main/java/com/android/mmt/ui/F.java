package com.android.mmt.ui;

import P0.C0158d;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.R;
import com.android.mmt.ui.C0269z;
import com.android.mmt.util.C0279k;
import com.android.mmt.util.EditableListViewV2;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import t.C0384b;
import x0.C0416c;

/* loaded from: classes.dex */
public final class F extends C0 implements EditableListViewV2.k, RecyclerView.r {

    /* renamed from: i, reason: collision with root package name */
    private Context f4787i;

    /* renamed from: j, reason: collision with root package name */
    private final LayoutInflater f4788j;

    /* renamed from: k, reason: collision with root package name */
    private b f4789k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4790l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4791m;

    /* renamed from: n, reason: collision with root package name */
    private HashSet<Long> f4792n;

    /* renamed from: o, reason: collision with root package name */
    private LongSparseArray<Long> f4793o;
    private boolean p;

    /* renamed from: q, reason: collision with root package name */
    private int f4794q;

    /* renamed from: r, reason: collision with root package name */
    private int f4795r;

    /* renamed from: s, reason: collision with root package name */
    private int f4796s;

    /* renamed from: t, reason: collision with root package name */
    private SparseIntArray f4797t;
    private long u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f4798v;

    /* renamed from: w, reason: collision with root package name */
    private C0279k.c f4799w;

    /* renamed from: x, reason: collision with root package name */
    private BroadcastReceiver f4800x;

    final class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            F.this.I();
        }
    }

    public interface b {
    }

    private static class c extends RecyclerView.x {
        public c(View view) {
            super(view);
        }
    }

    public F(Context context) {
        super(null);
        this.f4790l = false;
        this.f4791m = false;
        this.f4792n = S2.d.l(new Long[0]);
        this.f4793o = new LongSparseArray<>();
        this.p = false;
        this.f4794q = 0;
        this.f4795r = 0;
        this.f4796s = 0;
        this.f4797t = new SparseIntArray();
        this.u = 0L;
        this.f4800x = new a();
        this.f4787i = context;
        this.f4788j = LayoutInflater.from(context);
    }

    public static ConversationListItem L(View view) {
        if (view instanceof ConversationListItem) {
            return (ConversationListItem) view;
        }
        if (view instanceof C0158d) {
            Objects.requireNonNull((C0158d) view);
        }
        return null;
    }

    private void Y(Cursor cursor) {
        if (this.f4798v) {
            this.f4797t.clear();
            if (cursor == null || cursor.getCount() == 0) {
                return;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            long timeInMillis = calendar.getTimeInMillis();
            long j2 = timeInMillis - 86400000;
            for (int i2 = 0; i2 < cursor.getCount(); i2++) {
                if (cursor.moveToPosition(i2)) {
                    long j4 = cursor.getLong(cursor.getColumnIndexOrThrow("date"));
                    int i4 = j4 >= timeInMillis ? 1 : j4 >= j2 ? 2 : 3;
                    if (this.f4797t.indexOfValue(i4) == -1) {
                        this.f4797t.put(i2, i4);
                    }
                    if (i4 == 3) {
                        break;
                    }
                } else {
                    Log.w("ConversationListAdapter", "cursor move to position: " + i2 + " failed");
                }
            }
            if (this.f4797t.size() == 1) {
                this.f4797t.clear();
            }
        }
    }

    @Override // com.android.mmt.ui.C0
    public final void H(RecyclerView.x xVar, Cursor cursor) throws Resources.NotFoundException {
        View view = xVar.f4055i;
        if (!(view instanceof ConversationListItem) && !(view instanceof C0158d)) {
            StringBuilder sbD = D2.e.d("Unexpected bound view: ");
            sbD.append(xVar.f4055i);
            Log.e("ConversationListAdapter", sbD.toString());
            return;
        }
        ConversationListItem conversationListItemL = L(view);
        conversationListItemL.setTag(R.id.avatar, Integer.valueOf(cursor.getPosition()));
        C0416c c0416cU = C0416c.u(this.f4787i, cursor);
        long jI = c0416cU.I();
        long jE = c0416cU.E();
        if (jE > 0 && this.u > jE && c0416cU.F()) {
            c0416cU.b0();
            c0416cU.c0(false);
        }
        c0416cU.a0(this.f4792n.contains(Long.valueOf(jI)));
        conversationListItemL.C();
        conversationListItemL.E(0);
        conversationListItemL.D(this.f4799w);
        if (((this.f4794q & 1) == 1) && jI == -100) {
            conversationListItemL.E(1);
        }
        this.f4797t.get(cursor.getPosition(), 0);
        this.f4797t.get(cursor.getPosition() + 1, 0);
        View view2 = xVar.f4055i;
        if (view2 instanceof C0158d) {
            Objects.requireNonNull((C0158d) view2);
        } else {
            conversationListItemL.r(c0416cU, this.f4790l, this.f4791m, this.f4795r, this.f4796s);
        }
    }

    @Override // com.android.mmt.ui.C0
    protected final void I() {
        b bVar;
        Cursor cursor = this.d;
        if (cursor == null || cursor.isClosed() || (bVar = this.f4789k) == null) {
            return;
        }
        C0269z.j jVar = (C0269z.j) bVar;
        C0269z.this.f5784F0.removeMessages(1003);
        C0269z.this.f5784F0.sendEmptyMessageDelayed(1003, 50L);
        Y(this.d);
    }

    public final void J() {
        this.f4790l = true;
    }

    public final void K() {
        this.f4790l = false;
        this.f4792n.clear();
        this.f4793o.clear();
    }

    public final boolean M(HashSet<Long> hashSet) {
        Iterator<Long> it = hashSet.iterator();
        while (it.hasNext()) {
            if (this.f4793o.indexOfKey(it.next().longValue()) < 0) {
                return false;
            }
        }
        return true;
    }

    public final void N() {
        C0384b.t(this.f4787i, this.f4800x, new IntentFilter("android.intent.action.DATE_CHANGED"));
    }

    public final void O(boolean z4) {
        this.f4791m = z4;
    }

    public final void P(HashSet<Long> hashSet) {
        this.f4792n = hashSet;
    }

    public final void Q(boolean z4) {
        this.p = z4;
    }

    public final void R(b bVar) {
        this.f4789k = bVar;
    }

    public final void S(C0279k.c cVar) {
        this.f4799w = cVar;
    }

    public final void T(int i2) {
        this.f4794q = i2;
    }

    public final void U(int i2) {
        this.f4795r = i2;
    }

    public final void V(int i2) {
        this.f4796s = i2;
    }

    public final void W() {
        this.u = System.currentTimeMillis();
    }

    public final void X() {
        this.f4787i.unregisterReceiver(this.f4800x);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void a(RecyclerView.x xVar) {
        ConversationListItem conversationListItemL = L(xVar.f4055i);
        if (conversationListItemL != null) {
            conversationListItemL.F();
        }
    }

    @Override // com.android.mmt.util.EditableListViewV2.k
    public final boolean c(int i2) {
        int columnIndex;
        Cursor cursor = this.d;
        return cursor == null || (columnIndex = cursor.getColumnIndex("_id")) == -1 || !this.d.moveToPosition(i2) || this.d.getLong(columnIndex) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.mmt.util.EditableListViewV2.k
    public final int d() {
        boolean z4 = this.p;
        int i2 = this.f4794q;
        int i4 = z4;
        while (i2 > 0) {
            i2 &= i2 - 1;
            i4++;
        }
        return i4;
    }

    @Override // com.android.mmt.ui.C0, com.android.mmt.ui.G.a
    public final void e(Cursor cursor) {
        super.e(cursor);
        Y(cursor);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int l(int i2) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final RecyclerView.x y(ViewGroup viewGroup, int i2) {
        return new c(this.f4788j.inflate(R.layout.conversation_list_item, viewGroup, false));
    }

    public F(Context context, Cursor cursor, boolean z4, boolean z5) {
        super(null);
        this.f4790l = false;
        this.f4791m = false;
        this.f4792n = S2.d.l(new Long[0]);
        this.f4793o = new LongSparseArray<>();
        this.p = false;
        this.f4794q = 0;
        this.f4795r = 0;
        this.f4796s = 0;
        this.f4797t = new SparseIntArray();
        this.u = 0L;
        this.f4800x = new a();
        this.f4787i = context;
        this.f4788j = LayoutInflater.from(context);
        this.p = true;
        this.f4798v = true;
    }
}
