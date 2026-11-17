package W;

import V.c;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

/* loaded from: classes.dex */
final class b implements V.c {

    /* renamed from: i, reason: collision with root package name */
    private final Context f1773i;

    /* renamed from: j, reason: collision with root package name */
    private final String f1774j;

    /* renamed from: k, reason: collision with root package name */
    private final c.a f1775k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f1776l;

    /* renamed from: m, reason: collision with root package name */
    private final Object f1777m = new Object();

    /* renamed from: n, reason: collision with root package name */
    private a f1778n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1779o;

    static class a extends SQLiteOpenHelper {

        /* renamed from: i, reason: collision with root package name */
        final W.a[] f1780i;

        /* renamed from: j, reason: collision with root package name */
        final c.a f1781j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f1782k;

        /* renamed from: W.b$a$a, reason: collision with other inner class name */
        final class C0045a implements DatabaseErrorHandler {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c.a f1783a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ W.a[] f1784b;

            C0045a(c.a aVar, W.a[] aVarArr) {
                this.f1783a = aVar;
                this.f1784b = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.f1783a.c(a.H(this.f1784b, sQLiteDatabase));
            }
        }

        a(Context context, String str, W.a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.f1740a, new C0045a(aVar, aVarArr));
            this.f1781j = aVar;
            this.f1780i = aVarArr;
        }

        static W.a H(W.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            W.a aVar = aVarArr[0];
            if (aVar == null || !aVar.f(sQLiteDatabase)) {
                aVarArr[0] = new W.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        final synchronized V.b I() {
            this.f1782k = false;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!this.f1782k) {
                return f(writableDatabase);
            }
            close();
            return I();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final synchronized void close() {
            super.close();
            this.f1780i[0] = null;
        }

        final W.a f(SQLiteDatabase sQLiteDatabase) {
            return H(this.f1780i, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
            c.a aVar = this.f1781j;
            f(sQLiteDatabase);
            aVar.b();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f1781j.d(f(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i4) {
            this.f1782k = true;
            this.f1781j.e(f(sQLiteDatabase), i2, i4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f1782k) {
                return;
            }
            this.f1781j.f(f(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i4) {
            this.f1782k = true;
            this.f1781j.g(f(sQLiteDatabase), i2, i4);
        }
    }

    b(Context context, String str, c.a aVar, boolean z4) {
        this.f1773i = context;
        this.f1774j = str;
        this.f1775k = aVar;
        this.f1776l = z4;
    }

    private a f() {
        a aVar;
        synchronized (this.f1777m) {
            if (this.f1778n == null) {
                W.a[] aVarArr = new W.a[1];
                if (this.f1774j == null || !this.f1776l) {
                    this.f1778n = new a(this.f1773i, this.f1774j, aVarArr, this.f1775k);
                } else {
                    this.f1778n = new a(this.f1773i, new File(this.f1773i.getNoBackupFilesDir(), this.f1774j).getAbsolutePath(), aVarArr, this.f1775k);
                }
                this.f1778n.setWriteAheadLoggingEnabled(this.f1779o);
            }
            aVar = this.f1778n;
        }
        return aVar;
    }

    @Override // V.c
    public final V.b T() {
        return f().I();
    }

    @Override // V.c, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        f().close();
    }

    @Override // V.c
    public final String getDatabaseName() {
        return this.f1774j;
    }

    @Override // V.c
    public final void setWriteAheadLoggingEnabled(boolean z4) {
        synchronized (this.f1777m) {
            a aVar = this.f1778n;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z4);
            }
            this.f1779o = z4;
        }
    }
}
