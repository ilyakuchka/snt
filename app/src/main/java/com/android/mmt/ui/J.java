package com.android.mmt.ui;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.C0247i0;
import com.android.mmt.util.AbstractHandlerC0272d;
import f0.C0303b;
import java.util.LinkedHashMap;
import java.util.Map;
import t0.C0385a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public final class J extends CursorAdapter {

    /* renamed from: i, reason: collision with root package name */
    public static final Uri f4859i = C0385a.b.d;

    /* renamed from: a, reason: collision with root package name */
    private LayoutInflater f4860a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4861b;

    /* renamed from: c, reason: collision with root package name */
    private b f4862c;
    private C0247i0.c d;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashMap<Long, C0243g0> f4863e;

    /* renamed from: f, reason: collision with root package name */
    private SparseBooleanArray f4864f;
    private Handler g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4865h;

    final class a extends LinkedHashMap<Long, C0243g0> {
        a() {
            super(10, 1.0f, true);
        }

        @Override // java.util.LinkedHashMap
        protected final boolean removeEldestEntry(Map.Entry<Long, C0243g0> entry) {
            return size() > 50;
        }
    }

    private final class b extends AbstractHandlerC0272d {
        public b(ContentResolver contentResolver) {
            super(contentResolver);
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        @SuppressLint({"LongLogTag"})
        protected final void c(int i2, Object obj, Cursor cursor) {
            if (i2 != 1001) {
                return;
            }
            if (!J.this.f4865h) {
                J.this.changeCursor(cursor);
                return;
            }
            if (cursor != null) {
                cursor.close();
            }
            Log.v("ExpiredTimedMessageListAdapter", "query cursor close for stop");
        }
    }

    public J(Context context) {
        super(context, null);
        this.g = new Handler();
        this.f4865h = false;
        this.f4861b = context;
        this.f4862c = new b(context.getContentResolver());
        this.d = new C0247i0.c();
        this.f4860a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f4863e = new a();
    }

    @Override // android.widget.CursorAdapter
    public final void bindView(View view, Context context, Cursor cursor) {
        if (view instanceof MessageListItem) {
            C0243g0 c0243g0D = d(cursor);
            ((MessageListItem) view).L(c0243g0D, false, false, false, null, null);
            TextView textView = (TextView) view.findViewById(R.id.message_recipient);
            StringBuilder sb = new StringBuilder();
            sb.append(P0.r.r(this.f4861b, c0243g0D.m(), true));
            sb.append(" ");
            sb.append(context.getString(R.string.timed_message_to));
            sb.append(" ");
            C0416c c0416cV = C0416c.v(c0243g0D.H());
            c0416cV.Q(false, false);
            C0415b c0415bG = c0416cV.G();
            for (int i2 = 0; i2 < c0415bG.size() && i2 < 3; i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                sb.append(c0415bG.get(i2).U());
            }
            if (c0415bG.size() > 3) {
                sb.append(context.getResources().getQuantityString(R.plurals.timed_message_in_total, c0415bG.size(), Integer.valueOf(c0415bG.size())));
            }
            textView.setText(sb.toString());
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.timed_checkbox);
            int position = cursor.getPosition();
            SparseBooleanArray sparseBooleanArray = this.f4864f;
            checkBox.setChecked(sparseBooleanArray != null ? sparseBooleanArray.get(position) : false);
        }
    }

    public final C0243g0 c(int i2) {
        Cursor cursor = (Cursor) getItem(i2);
        if (cursor == null) {
            return null;
        }
        return d(cursor);
    }

    public final C0243g0 d(Cursor cursor) {
        String string = cursor.getString(this.d.f5635a);
        C0243g0 c0243g0 = this.f4863e.get(Long.valueOf(P0.r.i(string, cursor.getLong(this.d.f5636b))));
        if (c0243g0 == null) {
            if ((cursor.isClosed() || cursor.isBeforeFirst() || cursor.isAfterLast()) ? false : true) {
                try {
                    c0243g0 = new C0243g0(this.f4861b, string, cursor, this.d, 4);
                    this.f4863e.put(Long.valueOf(P0.r.i(c0243g0.I(), c0243g0.z())), c0243g0);
                } catch (C0303b e2) {
                    Log.e("ExpiredTimedMessageListAdapter", e2.getMessage() == null ? "Caught MmsException" : e2.getMessage());
                    return null;
                }
            }
        }
        return c0243g0;
    }

    public final void e() {
        this.f4865h = false;
        this.f4862c.a(1001);
        try {
            this.f4862c.f(1001, null, Uri.withAppendedPath(f4859i, Long.toString(MmsApp.e())), C0247i0.M, null, null);
        } catch (SQLiteException e2) {
            com.android.mmt.util.O.a(this.f4861b, e2);
        }
    }

    public final void f(SparseBooleanArray sparseBooleanArray) {
        this.f4864f = sparseBooleanArray;
    }

    public final void g() {
        this.f4865h = true;
    }

    @Override // android.widget.CursorAdapter
    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        C0243g0 c0243g0D = d(cursor);
        MessageListItem messageListItem = (MessageListItem) this.f4860a.inflate(R.layout.expired_timed_message, viewGroup, false);
        messageListItem.q(c0243g0D);
        messageListItem.f4927E = this.g;
        return messageListItem;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f4863e.clear();
    }
}
