package z0;

import Z3.b;
import java.util.ArrayList;

/* renamed from: z0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0428a implements b {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<C0148a> f8162a;

    /* renamed from: b, reason: collision with root package name */
    private b f8163b;

    /* renamed from: z0.a$a, reason: collision with other inner class name */
    static class C0148a {

        /* renamed from: a, reason: collision with root package name */
        final String f8164a;

        /* renamed from: b, reason: collision with root package name */
        final Z3.a f8165b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f8166c = false;

        C0148a(String str, Z3.a aVar) {
            this.f8164a = str;
            this.f8165b = aVar;
        }
    }

    public C0428a(b bVar) {
        this.f8163b = bVar;
    }

    @Override // Z3.b
    public final void v(String str, Z3.a aVar) {
        if (str.equals("")) {
            return;
        }
        if (this.f8162a != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f8162a.size()) {
                    break;
                }
                C0148a c0148a = this.f8162a.get(i2);
                if (!c0148a.f8166c && c0148a.f8165b == aVar && c0148a.f8164a.equals(str)) {
                    this.f8162a.remove(i2);
                    break;
                }
                i2++;
            }
        }
        if (this.f8162a == null) {
            this.f8162a = new ArrayList<>();
        }
        this.f8162a.add(new C0148a(str, aVar));
    }
}
