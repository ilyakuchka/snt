package com.android.mmt;

import D2.e;
import P0.r;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import com.android.mmt.ui.ComposeMessageRouterActivity;
import g0.C0309e;
import g0.C0319o;
import x0.C0416c;

/* loaded from: classes.dex */
public class SuggestionsProvider extends ContentProvider {

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f4477i = {"suggest_text_1", "suggest_text_2", "suggest_icon_1", "suggest_intent_action", "suggest_intent_data", "suggest_shortcut_id", "suggest_text_date"};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f4478j = {3, 3, 0, 3, 3, 3, 3};

    private class a extends CursorWrapper {

        /* renamed from: i, reason: collision with root package name */
        private final int f4479i;

        /* renamed from: j, reason: collision with root package name */
        private final int f4480j;

        /* renamed from: k, reason: collision with root package name */
        private final int f4481k;

        /* renamed from: l, reason: collision with root package name */
        private final int f4482l;

        /* renamed from: m, reason: collision with root package name */
        private final int f4483m;

        /* renamed from: n, reason: collision with root package name */
        private final int f4484n;

        /* renamed from: o, reason: collision with root package name */
        private final String f4485o;
        private Cursor p;

        public a(Cursor cursor, String str) {
            super(cursor);
            this.p = cursor;
            this.f4479i = cursor.getColumnIndex("thread_id");
            this.f4480j = cursor.getColumnIndex("body");
            this.f4481k = cursor.getColumnIndex("sub");
            this.f4482l = cursor.getColumnIndex("_id");
            this.f4483m = cursor.getColumnIndex("date");
            this.f4484n = cursor.getColumnIndex("type");
            this.f4485o = str.split(" +")[0];
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
            throw new IllegalArgumentException(e.b("Wrong data type for column ", i2));
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final byte[] getBlob(int i2) {
            throw new IllegalArgumentException(e.b("Wrong data type for column ", i2));
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final int getColumnCount() {
            String[] unused = SuggestionsProvider.f4477i;
            return 7;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final int getColumnIndex(String str) {
            int i2 = 0;
            while (true) {
                String[] unused = SuggestionsProvider.f4477i;
                if (i2 >= 7) {
                    return -1;
                }
                if (SuggestionsProvider.f4477i[i2].equals(str)) {
                    return i2;
                }
                i2++;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
            int columnIndex = getColumnIndex(str);
            if (columnIndex != -1) {
                return columnIndex;
            }
            throw new IllegalArgumentException(e.c("Cannot find column ", str));
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final String getColumnName(int i2) {
            return SuggestionsProvider.f4477i[i2];
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final String[] getColumnNames() {
            return (String[]) SuggestionsProvider.f4477i.clone();
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final int getCount() {
            return this.p.getCount();
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final double getDouble(int i2) {
            throw new IllegalArgumentException(e.b("Wrong data type for column ", i2));
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final float getFloat(int i2) {
            throw new IllegalArgumentException(e.b("Wrong data type for column ", i2));
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final int getInt(int i2) {
            throw new IllegalArgumentException(e.b("Wrong data type for column ", i2));
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final long getLong(int i2) {
            throw new IllegalArgumentException(e.b("Wrong data type for column ", i2));
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final short getShort(int i2) {
            throw new IllegalArgumentException(e.b("Wrong data type for column ", i2));
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final String getString(int i2) {
            if (getColumnName(i2).equals("suggest_text_1")) {
                C0416c c0416cV = C0416c.v(this.p.getLong(this.f4479i));
                c0416cV.Q(true, false);
                return c0416cV.y();
            }
            if (getColumnName(i2).equals("suggest_text_2")) {
                String string = this.p.getString(this.f4481k);
                return r.u(string != null ? !TextUtils.isEmpty(string) ? new C0309e(106, C0319o.d(string)).f() : "" : this.p.getString(this.f4480j), this.f4485o, 20, 5);
            }
            String string2 = null;
            if (getColumnName(i2).equals("suggest_icon_1")) {
                return null;
            }
            if (getColumnName(i2).equals("suggest_intent_action")) {
                return "android.intent.action.VIEW";
            }
            if (!getColumnName(i2).equals("suggest_intent_data")) {
                if (getColumnName(i2).equals("suggest_shortcut_id")) {
                    return "_-1";
                }
                if ("suggest_text_date".equals(getColumnName(i2))) {
                    return String.valueOf(this.p.getLong(this.f4483m));
                }
                throw new IllegalArgumentException(e.b("Invalid column index ", i2));
            }
            long j2 = this.p.getLong(this.f4479i);
            long j4 = this.p.getLong(this.f4482l);
            String string3 = this.p.getString(this.f4484n);
            if (j4 < 0) {
                string2 = this.p.getString(this.f4480j);
                j4 = -j4;
            }
            String string4 = ComposeMessageRouterActivity.b(j2, r.i(string3, j4), this.f4485o, string2).toString();
            Y1.a.d("dataUri = %s", string4);
            return string4;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final int getType(int i2) {
            return SuggestionsProvider.f4478j[i2];
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public final boolean isNull(int i2) {
            return SuggestionsProvider.f4478j[i2] == 0;
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String strTrim = strArr2[0].trim();
        return TextUtils.isEmpty(strTrim) ? new MatrixCursor(f4477i) : new a(getContext().getContentResolver().query(Telephony.MmsSms.SEARCH_URI.buildUpon().appendQueryParameter("pattern", strArr2[0]).build(), null, null, null, null), strTrim);
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
