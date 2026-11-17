package com.android.mmt.ui;

import android.database.Cursor;
import android.widget.Filter;
import java.util.Objects;

/* loaded from: classes.dex */
final class G extends Filter {

    /* renamed from: a, reason: collision with root package name */
    a f4823a;

    interface a {
        void e(Cursor cursor);
    }

    G(a aVar) {
        this.f4823a = aVar;
    }

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        Cursor cursor = (Cursor) obj;
        Objects.requireNonNull((C0) this.f4823a);
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.widget.Filter
    protected final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursor = ((C0) this.f4823a).d;
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursor != null) {
            filterResults.count = cursor.getCount();
            filterResults.values = cursor;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.f4823a;
        Cursor cursor = ((C0) aVar).d;
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        aVar.e((Cursor) obj);
    }
}
