package com.android.mmt.ui;

import P0.C0162h;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.R;
import com.android.mmt.ui.C0247i0;
import com.android.mmt.util.AbstractHandlerC0272d;
import com.android.mmt.util.BackgroundCleaner;
import f0.C0303b;
import java.util.Objects;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public class K extends RecyclerView.e<C0162h> implements BackgroundCleaner.c {

    /* renamed from: c, reason: collision with root package name */
    protected LayoutInflater f4868c;
    protected Context d;

    /* renamed from: f, reason: collision with root package name */
    private Uri f4870f;

    /* renamed from: h, reason: collision with root package name */
    protected c f4871h;

    /* renamed from: k, reason: collision with root package name */
    private float f4874k;

    /* renamed from: n, reason: collision with root package name */
    private Cursor f4877n;

    /* renamed from: o, reason: collision with root package name */
    private e f4878o;

    /* renamed from: q, reason: collision with root package name */
    private int f4879q;

    /* renamed from: l, reason: collision with root package name */
    private Handler f4875l = new Handler();

    /* renamed from: m, reason: collision with root package name */
    private boolean f4876m = false;

    /* renamed from: e, reason: collision with root package name */
    private String f4869e = "BookmarkListAdapter";
    private int g = R.layout.bookmark_list_item;

    /* renamed from: i, reason: collision with root package name */
    private C0247i0.c f4872i = new C0247i0.c();

    /* renamed from: j, reason: collision with root package name */
    private final LruCache<Long, C0243g0> f4873j = new LruCache<>(500);
    private d p = new d();

    final class a implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ MessageListItem f4880i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f4881j;

        a(MessageListItem messageListItem, int i2) {
            this.f4880i = messageListItem;
            this.f4881j = i2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ((C0252l) K.this.f4878o).g1(this.f4880i, this.f4881j);
        }
    }

    final class b implements View.OnLongClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f4883i;

        b(int i2, MessageListItem messageListItem) {
            this.f4883i = i2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            K.this.f4879q = this.f4883i;
            Objects.requireNonNull(K.this.f4878o);
            return false;
        }
    }

    protected final class c extends AbstractHandlerC0272d {
        public c(ContentResolver contentResolver) {
            super(contentResolver);
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void b(int i2, Object obj, int i4) {
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void c(int i2, Object obj, Cursor cursor) {
            if (i2 != 1001) {
                return;
            }
            if (K.this.f4876m) {
                if (cursor != null) {
                    cursor.close();
                }
                Log.v(K.this.f4869e, "query cursor close for stop");
            } else {
                K.this.Q(cursor);
                if (K.this.f4878o != null) {
                    ((C0252l) K.this.f4878o).h1(cursor == null || cursor.getCount() == 0);
                }
            }
        }
    }

    private class d extends ContentObserver {
        public d() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z4) {
            K.this.N();
        }
    }

    public interface e {
    }

    public K(Context context, Uri uri) {
        this.d = context;
        this.f4870f = uri;
        this.f4871h = new c(context.getContentResolver());
        this.f4868c = (LayoutInflater) context.getSystemService("layout_inflater");
        BackgroundCleaner.j().k(this);
    }

    public final C0243g0 K(Cursor cursor) {
        C0415b c0415bG;
        String string = cursor.getString(this.f4872i.f5635a);
        C0243g0 c0243g0 = this.f4873j.get(Long.valueOf(P0.r.i(string, cursor.getLong(this.f4872i.f5636b))));
        if (c0243g0 != null) {
            return c0243g0;
        }
        if (!((cursor.isClosed() || cursor.isBeforeFirst() || cursor.isAfterLast()) ? false : true)) {
            return c0243g0;
        }
        try {
            C0243g0 c0243g02 = new C0243g0(this.d, string, cursor, this.f4872i, 0L, null, 4, true);
            if (c0243g02.U() && c0243g02.e() == null) {
                c0243g02.f0((!c0243g02.U() || c0243g02.e() != null || (c0415bG = C0416c.v(c0243g02.H()).G()) == null || c0415bG.size() <= 0) ? null : c0415bG.get(0));
            }
            this.f4873j.put(Long.valueOf(P0.r.i(c0243g02.I(), c0243g02.z())), c0243g02);
            return c0243g02;
        } catch (C0303b e2) {
            Log.e(this.f4869e, e2.getMessage() == null ? "Caught MmsException" : e2.getMessage());
            return null;
        }
    }

    public final C0243g0 L(int i2) {
        Cursor cursor = this.f4877n;
        if (cursor == null || cursor.isClosed() || this.f4877n.getCount() == 0) {
            return null;
        }
        this.f4877n.moveToPosition(i2);
        return K(this.f4877n);
    }

    public final int M() {
        return this.f4879q;
    }

    public final void N() {
        this.f4876m = false;
        this.f4871h.a(1001);
        try {
            this.f4871h.f(1001, null, this.f4870f, C0247i0.M, "locked=1", " date DESC");
        } catch (SQLiteException e2) {
            com.android.mmt.util.O.a(this.d, e2);
        }
    }

    public void O(C0162h c0162h, int i2) {
        C0243g0 c0243g0K = K(this.f4877n);
        MessageListItem messageListItemB = c0162h.B();
        messageListItemB.L(c0243g0K, false, false, false, null, null);
        messageListItemB.M(this.f4874k);
        if (this.f4878o != null) {
            messageListItemB.setOnClickListener(new a(messageListItemB, i2));
            messageListItemB.setOnLongClickListener(new b(i2, messageListItemB));
        }
    }

    public C0162h P(ViewGroup viewGroup, int i2) {
        C0243g0 c0243g0K = K(this.f4877n);
        MessageListItem messageListItem = (MessageListItem) this.f4868c.inflate(this.g, viewGroup, false);
        messageListItem.q(c0243g0K);
        messageListItem.f4927E = this.f4875l;
        return new C0162h(messageListItem);
    }

    public final void Q(Cursor cursor) {
        Cursor cursor2 = this.f4877n;
        if (cursor2 == cursor) {
            cursor2 = null;
        } else {
            this.f4877n = cursor;
            if (cursor != null) {
                cursor.registerContentObserver(this.p);
                n();
            }
        }
        if (cursor2 != null) {
            cursor2.unregisterContentObserver(this.p);
            cursor2.close();
        }
        this.f4873j.evictAll();
    }

    public final void R(e eVar) {
        this.f4878o = eVar;
    }

    public final void S(float f4) {
        this.f4874k = f4;
    }

    public final void T() {
        this.f4876m = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void a(RecyclerView.x xVar) {
        C0162h c0162h = (C0162h) xVar;
        if (this.f4878o == null || c0162h.B() == null) {
            return;
        }
        c0162h.B().R();
    }

    @Override // com.android.mmt.util.BackgroundCleaner.c
    public final void b() {
        this.f4873j.evictAll();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int j() {
        Cursor cursor = this.f4877n;
        if (cursor == null || cursor.isClosed()) {
            return 0;
        }
        return this.f4877n.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int l(int i2) {
        this.f4877n.moveToPosition(i2);
        Objects.requireNonNull(K(this.f4877n));
        return 0;
    }
}
