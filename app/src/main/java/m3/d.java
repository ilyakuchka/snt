package m3;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private List<C0351c> f6596a = new LinkedList();

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.LinkedList, java.util.List<m3.c>] */
    public final void a() {
        if (this.f6596a.isEmpty()) {
            return;
        }
        for (C0351c c0351c : this.f6596a) {
            if (c0351c != null) {
                c0351c.d();
            }
        }
        this.f6596a.clear();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.LinkedList, java.util.List<m3.c>] */
    public final void b() {
        if (this.f6596a.isEmpty()) {
            return;
        }
        for (C0351c c0351c : this.f6596a) {
            if (c0351c != null) {
                c0351c.q();
            }
        }
        this.f6596a.clear();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedList, java.util.List<m3.c>] */
    public final void c(C0351c c0351c) {
        this.f6596a.add(c0351c);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.LinkedList, java.util.List<m3.c>] */
    public final void d(C0351c... c0351cArr) {
        for (C0351c c0351c : c0351cArr) {
            if (c0351c != null) {
                this.f6596a.add(c0351c);
            }
        }
    }

    public final void e() {
        if (this.f6596a.isEmpty()) {
            return;
        }
        for (C0351c c0351c : this.f6596a) {
            if (c0351c != null) {
                c0351c.n();
            }
        }
    }
}
