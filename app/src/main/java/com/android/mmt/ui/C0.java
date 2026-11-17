package com.android.mmt.ui;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.ui.G;

/* loaded from: classes.dex */
public abstract class C0 extends RecyclerView.e implements Filterable, G.a {

    /* renamed from: c, reason: collision with root package name */
    protected boolean f4689c;
    protected Cursor d;

    /* renamed from: e, reason: collision with root package name */
    protected int f4690e;

    /* renamed from: f, reason: collision with root package name */
    protected a f4691f;
    protected DataSetObserver g;

    /* renamed from: h, reason: collision with root package name */
    protected G f4692h;

    private class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z4) {
            C0.this.I();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            C0 c02 = C0.this;
            c02.f4689c = true;
            c02.n();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            C0 c02 = C0.this;
            c02.f4689c = false;
            c02.n();
        }
    }

    public C0(Cursor cursor) {
        boolean z4 = cursor != null;
        this.d = cursor;
        this.f4689c = z4;
        this.f4690e = z4 ? cursor.getColumnIndexOrThrow("_id") : -1;
        this.f4691f = new a();
        this.g = new b();
        if (z4) {
            a aVar = this.f4691f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
        E(true);
    }

    public final Object G(int i2) {
        Cursor cursor;
        if (!this.f4689c || (cursor = this.d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.d;
    }

    public abstract void H(RecyclerView.x xVar, Cursor cursor);

    protected abstract void I();

    @Override // com.android.mmt.ui.G.a
    public void e(Cursor cursor) {
        Cursor cursor2 = this.d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.f4691f;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.g;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.d = cursor;
            if (cursor != null) {
                a aVar2 = this.f4691f;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.g;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f4690e = cursor.getColumnIndexOrThrow("_id");
                this.f4689c = true;
                n();
            } else {
                this.f4690e = -1;
                this.f4689c = false;
                n();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f4692h == null) {
            this.f4692h = new G(this);
        }
        return this.f4692h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int j() {
        Cursor cursor;
        if (!this.f4689c || (cursor = this.d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final long k(int i2) {
        Cursor cursor;
        if (this.f4689c && (cursor = this.d) != null && cursor.moveToPosition(i2)) {
            return this.d.getLong(this.f4690e);
        }
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void x(RecyclerView.x xVar, int i2) {
        if (!this.f4689c) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.d.moveToPosition(i2)) {
            throw new IllegalStateException(D2.e.b("couldn't move cursor to position ", i2));
        }
        H(xVar, this.d);
    }
}
