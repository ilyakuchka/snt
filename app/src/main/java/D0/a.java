package D0;

import Q2.c;
import S2.e;
import android.database.ContentObserver;
import android.os.Handler;
import com.android.mmt.MmsApp;
import com.android.mmt.storage.bugle.BugleDatabase;
import java.util.ArrayList;
import x0.C0416c;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static ContentObserver f78a = new b(e.a());

    /* renamed from: D0.a$a, reason: collision with other inner class name */
    final class RunnableC0002a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f79i;

        RunnableC0002a(long j2) {
            this.f79i = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(this.f79i));
            BugleDatabase.y().x().s(arrayList);
            if (this.f79i == -103) {
                C0416c.V(MmsApp.c(), 1);
                BugleDatabase.y().x().I();
            }
        }
    }

    final class b extends ContentObserver {
        b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z4) {
            super.onChange(z4);
            if (a.f78a != null) {
                MmsApp.c().getContentResolver().unregisterContentObserver(a.f78a);
            }
        }
    }

    public static void a(long j2) {
        c.a(new RunnableC0002a(j2));
    }
}
