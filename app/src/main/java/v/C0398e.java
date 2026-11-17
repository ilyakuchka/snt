package v;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* renamed from: v.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0398e {

    /* renamed from: a, reason: collision with root package name */
    final Bundle f7924a;

    /* renamed from: b, reason: collision with root package name */
    private IconCompat f7925b;

    /* renamed from: c, reason: collision with root package name */
    private final l[] f7926c;
    private final l[] d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7927e;

    /* renamed from: f, reason: collision with root package name */
    boolean f7928f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f7929h;

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public int f7930i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f7931j;

    /* renamed from: k, reason: collision with root package name */
    public PendingIntent f7932k;

    /* renamed from: v.e$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final IconCompat f7933a;

        /* renamed from: b, reason: collision with root package name */
        private final CharSequence f7934b;

        /* renamed from: c, reason: collision with root package name */
        private final PendingIntent f7935c;
        private boolean d;

        /* renamed from: e, reason: collision with root package name */
        private final Bundle f7936e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f7937f;

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            IconCompat iconCompatA = i2 == 0 ? null : IconCompat.a(i2);
            Bundle bundle = new Bundle();
            this.d = true;
            this.f7937f = true;
            this.f7933a = iconCompatA;
            this.f7934b = g.c(charSequence);
            this.f7935c = pendingIntent;
            this.f7936e = bundle;
            this.d = true;
            this.f7937f = true;
        }

        public final C0398e a() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            l[] lVarArr = arrayList.isEmpty() ? null : (l[]) arrayList.toArray(new l[arrayList.size()]);
            return new C0398e(this.f7933a, this.f7934b, this.f7935c, this.f7936e, arrayList2.isEmpty() ? null : (l[]) arrayList2.toArray(new l[arrayList2.size()]), lVarArr, this.d, 0, this.f7937f, false);
        }
    }

    C0398e(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, l[] lVarArr, l[] lVarArr2, boolean z4, int i2, boolean z5, boolean z6) {
        this.f7928f = true;
        this.f7925b = iconCompat;
        if (iconCompat != null && iconCompat.c() == 2) {
            this.f7930i = iconCompat.b();
        }
        this.f7931j = g.c(charSequence);
        this.f7932k = pendingIntent;
        this.f7924a = bundle == null ? new Bundle() : bundle;
        this.f7926c = lVarArr;
        this.d = lVarArr2;
        this.f7927e = z4;
        this.g = i2;
        this.f7928f = z5;
        this.f7929h = z6;
    }

    public final boolean a() {
        return this.f7927e;
    }

    public final IconCompat b() {
        int i2;
        if (this.f7925b == null && (i2 = this.f7930i) != 0) {
            this.f7925b = IconCompat.a(i2);
        }
        return this.f7925b;
    }

    public final l[] c() {
        return this.f7926c;
    }

    public final int d() {
        return this.g;
    }

    public final boolean e() {
        return this.f7929h;
    }
}
