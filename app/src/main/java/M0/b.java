package M0;

import com.android.mmt.storage.bugle.BugleDatabase;

/* loaded from: classes.dex */
final class b implements Runnable {
    b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        BugleDatabase.y().d();
    }
}
