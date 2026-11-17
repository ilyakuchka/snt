package P0;

import android.os.Handler;
import android.widget.ImageView;
import com.android.mmt.MmsApp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: c, reason: collision with root package name */
    private static t f951c;

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashMap<Long, ArrayList<ImageView>> f952a = new LinkedHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashMap<Long, Object> f953b = new LinkedHashMap<>(32);

    private t() {
        MmsApp.c().getApplicationContext();
        new Handler();
    }

    public static synchronized t d() {
        if (f951c == null) {
            f951c = new t();
        }
        return f951c;
    }

    public final void a(long j2, ImageView imageView) {
        synchronized (this.f952a) {
            ArrayList<ImageView> arrayList = this.f952a.get(Long.valueOf(j2));
            if (arrayList != null) {
                arrayList.remove(imageView);
            }
        }
    }

    public final void b(boolean z4) {
        synchronized (this.f952a) {
            this.f952a.clear();
        }
        if (z4) {
            this.f953b.clear();
        }
    }

    public final void c(long j2) {
        synchronized (this.f952a) {
            this.f952a.remove(Long.valueOf(j2));
        }
        this.f953b.remove(Long.valueOf(j2));
    }
}
