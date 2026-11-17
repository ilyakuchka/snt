package V;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public interface c extends Closeable {

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1740a;

        public a(int i2) {
            this.f1740a = i2;
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e2) {
                Log.w("SupportSQLite", "delete failed: ", e2);
            }
        }

        public abstract void b();

        public final void c(V.b bVar) {
            StringBuilder sbD = D2.e.d("Corruption reported by sqlite on database: ");
            sbD.append(bVar.getPath());
            Log.e("SupportSQLite", sbD.toString());
            if (!bVar.isOpen()) {
                a(bVar.getPath());
                return;
            }
            List<Pair<String, String>> listN = null;
            try {
                try {
                    listN = bVar.n();
                } finally {
                    if (listN != null) {
                        Iterator<Pair<String, String>> it = listN.iterator();
                        while (it.hasNext()) {
                            a((String) it.next().second);
                        }
                    } else {
                        a(bVar.getPath());
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                bVar.close();
            } catch (IOException unused2) {
            }
        }

        public abstract void d(V.b bVar);

        public abstract void e(V.b bVar, int i2, int i4);

        public abstract void f(V.b bVar);

        public abstract void g(V.b bVar, int i2, int i4);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f1741a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1742b;

        /* renamed from: c, reason: collision with root package name */
        public final a f1743c;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            Context f1744a;

            /* renamed from: b, reason: collision with root package name */
            String f1745b;

            /* renamed from: c, reason: collision with root package name */
            a f1746c;

            a(Context context) {
                this.f1744a = context;
            }

            public final b a() {
                a aVar = this.f1746c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                Context context = this.f1744a;
                if (context != null) {
                    return new b(context, this.f1745b, aVar);
                }
                throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            }

            public final a b(a aVar) {
                this.f1746c = aVar;
                return this;
            }

            public final a c(String str) {
                this.f1745b = str;
                return this;
            }
        }

        b(Context context, String str, a aVar) {
            this.f1741a = context;
            this.f1742b = str;
            this.f1743c = aVar;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    /* renamed from: V.c$c, reason: collision with other inner class name */
    public interface InterfaceC0043c {
    }

    V.b T();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z4);
}
