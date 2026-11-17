package M0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.util.Log;
import com.android.mmt.storage.bugle.BugleDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import t.C0384b;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private Context f576b;

    /* renamed from: f, reason: collision with root package name */
    private RunnableScheduledFuture f579f;

    /* renamed from: a, reason: collision with root package name */
    private List<c> f575a = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f578e = new AtomicBoolean(false);
    private Runnable g = new a();

    /* renamed from: c, reason: collision with root package name */
    private M0.a f577c = new M0.a();
    private i d = new i();

    final class a implements Runnable {

        /* renamed from: M0.e$a$a, reason: collision with other inner class name */
        final class RunnableC0019a implements Runnable {
            RunnableC0019a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                e.a(e.this);
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            N0.a.a(new RunnableC0019a());
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [boolean] */
    static void a(e eVar) {
        if (eVar.f578e.get()) {
            return;
        }
        Log.d("SyncManagerImpl_flag", "sync start");
        eVar.f578e.compareAndSet(false, true);
        boolean zB = f.b();
        Log.d("SyncManagerImpl_flag", "sync thread " + zB);
        Uri.Builder builderAppendQueryParameter = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter("simple", "true");
        ?? F2 = K0.b.a().f();
        if (F2 > 0) {
            builderAppendQueryParameter.appendQueryParameter("placeholder", String.valueOf(F2 == true ? 1 : 0));
        }
        Context context = eVar.f576b;
        Cursor cursorS = C0384b.s(context, context.getContentResolver(), builderAppendQueryParameter.build(), g.f583a, null, "date DESC");
        eVar.d.a(cursorS);
        if (cursorS == null || cursorS.getCount() <= 0) {
            Objects.requireNonNull(eVar.f577c);
            N0.a.a(new b());
        } else {
            while (cursorS.moveToNext()) {
                L0.a aVar = new L0.a();
                aVar.z(cursorS.getInt(cursorS.getColumnIndexOrThrow("_id")));
                aVar.s(cursorS.getLong(cursorS.getColumnIndexOrThrow("date")));
                aVar.A(cursorS.getInt(cursorS.getColumnIndexOrThrow("message_count")));
                aVar.C(cursorS.getString(cursorS.getColumnIndexOrThrow("snippet")));
                aVar.D(cursorS.getInt(cursorS.getColumnIndexOrThrow("snippet_cs")));
                aVar.B(cursorS.getInt(cursorS.getColumnIndexOrThrow("read")));
                aVar.F(cursorS.getInt(cursorS.getColumnIndexOrThrow("type")));
                aVar.u(cursorS.getInt(cursorS.getColumnIndexOrThrow("error")));
                aVar.v(cursorS.getInt(cursorS.getColumnIndexOrThrow("has_attachment")));
                Iterator<c> it = eVar.f575a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                eVar.f577c.b(zB, aVar);
            }
        }
        Context context2 = eVar.f576b;
        Cursor cursorS2 = C0384b.s(context2, context2.getContentResolver(), Telephony.MmsSms.CONTENT_DRAFT_URI, new String[]{"thread_id"}, null, null);
        if (cursorS2 != null) {
            if (cursorS2.getCount() > 0) {
                ArrayList arrayList = new ArrayList(cursorS2.getCount());
                while (cursorS2.moveToNext()) {
                    arrayList.add(Long.valueOf(cursorS2.getLong(0)));
                }
                BugleDatabase.y().x().G(arrayList);
            }
            cursorS2.close();
        }
        Log.d("SyncManagerImpl_flag", "sync thread done");
        eVar.f577c.e();
        eVar.f577c.d();
        Log.d("SyncManagerImpl_flag", "sync done");
        if (f.b()) {
            f.c(System.currentTimeMillis());
            Log.d("SyncManagerImpl_flag", "first classify finish");
        }
        eVar.f578e.compareAndSet(true, false);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedList, java.util.List<M0.c>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.LinkedList, java.util.List<M0.c>] */
    public final void b(c cVar) {
        if (this.f575a.contains(cVar)) {
            return;
        }
        this.f575a.add(cVar);
    }

    public final void c(Context context) {
        this.f576b = context;
    }

    public final boolean d() {
        return this.f578e.get();
    }

    public final void e(boolean z4) {
        M0.a aVar = this.f577c;
        if (aVar != null) {
            aVar.c(z4);
        }
    }

    public final void f(long j2) {
        if (this.f578e.get()) {
            return;
        }
        N0.a.b(this.f579f);
        this.f579f = (RunnableScheduledFuture) N0.a.c(this.g, j2);
    }
}
