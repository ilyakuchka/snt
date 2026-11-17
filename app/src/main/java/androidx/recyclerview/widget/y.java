package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
final class y {

    /* renamed from: a, reason: collision with root package name */
    final b f4266a;

    /* renamed from: b, reason: collision with root package name */
    a f4267b = new a();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f4268a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f4269b;

        /* renamed from: c, reason: collision with root package name */
        int f4270c;
        int d;

        /* renamed from: e, reason: collision with root package name */
        int f4271e;

        a() {
        }

        final void a(int i2) {
            this.f4268a = i2 | this.f4268a;
        }

        final boolean b() {
            int i2 = this.f4268a;
            if ((i2 & 7) != 0 && (i2 & (c(this.d, this.f4269b) << 0)) == 0) {
                return false;
            }
            int i4 = this.f4268a;
            if ((i4 & 112) != 0 && (i4 & (c(this.d, this.f4270c) << 4)) == 0) {
                return false;
            }
            int i5 = this.f4268a;
            if ((i5 & 1792) != 0 && (i5 & (c(this.f4271e, this.f4269b) << 8)) == 0) {
                return false;
            }
            int i6 = this.f4268a;
            return (i6 & 28672) == 0 || ((c(this.f4271e, this.f4270c) << 12) & i6) != 0;
        }

        final int c(int i2, int i4) {
            if (i2 > i4) {
                return 1;
            }
            return i2 == i4 ? 2 : 4;
        }
    }

    interface b {
        View a(int i2);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    y(b bVar) {
        this.f4266a = bVar;
    }

    final View a(int i2, int i4, int i5, int i6) {
        int iC = this.f4266a.c();
        int iB = this.f4266a.b();
        int i7 = i4 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i4) {
            View viewA = this.f4266a.a(i2);
            int iE = this.f4266a.e(viewA);
            int iD = this.f4266a.d(viewA);
            a aVar = this.f4267b;
            aVar.f4269b = iC;
            aVar.f4270c = iB;
            aVar.d = iE;
            aVar.f4271e = iD;
            if (i5 != 0) {
                aVar.f4268a = 0;
                aVar.a(i5);
                if (this.f4267b.b()) {
                    return viewA;
                }
            }
            if (i6 != 0) {
                a aVar2 = this.f4267b;
                aVar2.f4268a = 0;
                aVar2.a(i6);
                if (this.f4267b.b()) {
                    view = viewA;
                }
            }
            i2 += i7;
        }
        return view;
    }

    final boolean b(View view) {
        a aVar = this.f4267b;
        int iC = this.f4266a.c();
        int iB = this.f4266a.b();
        int iE = this.f4266a.e(view);
        int iD = this.f4266a.d(view);
        aVar.f4269b = iC;
        aVar.f4270c = iB;
        aVar.d = iE;
        aVar.f4271e = iD;
        a aVar2 = this.f4267b;
        aVar2.f4268a = 0;
        aVar2.a(24579);
        return this.f4267b.b();
    }
}
