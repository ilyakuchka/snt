package com.android.mmt.ui;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.mmt.R;
import x0.C0414a;

/* loaded from: classes.dex */
public class StatusReportActivity extends miuix.appcompat.app.h implements LoaderManager.LoaderCallbacks<Cursor> {

    /* renamed from: y, reason: collision with root package name */
    private static final String[] f5449y = {"_id", "address", "delivery_status"};

    /* renamed from: v, reason: collision with root package name */
    private a f5450v;

    /* renamed from: w, reason: collision with root package name */
    private long f5451w;

    /* renamed from: x, reason: collision with root package name */
    private ListView f5452x;

    private class a extends CursorAdapter {

        /* renamed from: a, reason: collision with root package name */
        private LayoutInflater f5453a;

        public a(Context context) {
            super(context, (Cursor) null, false);
            this.f5453a = LayoutInflater.from(context);
        }

        @Override // android.widget.CursorAdapter
        public final void bindView(View view, Context context, Cursor cursor) {
            String string = cursor.getString(1);
            int i2 = cursor.getInt(2);
            C0414a c0414aO = C0414a.O(string);
            c0414aO.m0(false, false);
            TextView textView = (TextView) view.findViewById(R.id.name);
            TextView textView2 = (TextView) view.findViewById(R.id.status);
            String strN = P0.r.n(context, i2);
            textView.setText(c0414aO.U());
            textView2.setText(strN);
        }

        @Override // android.widget.CursorAdapter
        public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            return this.f5453a.inflate(R.layout.mms_status_report, viewGroup, false);
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            StatusReportActivity.this.getLoaderManager().restartLoader(0, null, StatusReportActivity.this);
            super.notifyDataSetChanged();
        }

        @Override // android.widget.CursorAdapter
        protected final void onContentChanged() {
            StatusReportActivity.this.getLoaderManager().restartLoader(0, null, StatusReportActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        K().n(getString(R.string.pref_title_delivery_reports));
        setContentView(R.layout.status_report_list_layout);
        long longExtra = intent.getLongExtra("extra_msgID", -1L);
        this.f5451w = longExtra;
        if (longExtra < 0) {
            finish();
            return;
        }
        this.f5450v = new a(this);
        ListView listView = (ListView) findViewById(android.R.id.list);
        this.f5452x = listView;
        listView.setAdapter((ListAdapter) this.f5450v);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public final Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        return new CursorLoader(this, Uri.withAppendedPath(Telephony.Mms.REPORT_STATUS_URI, String.valueOf(this.f5451w)), f5449y, null, null, null);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        a aVar = this.f5450v;
        if (aVar != null) {
            aVar.changeCursor(null);
        }
        this.f5452x.setAdapter((ListAdapter) null);
        super.onDestroy();
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public final void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f5450v.swapCursor(cursor);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public final void onLoaderReset(Loader<Cursor> loader) {
        this.f5450v.swapCursor(null);
    }
}
