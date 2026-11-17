package C;

import C.j;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    static final q.f<String, Typeface> f28a = new q.f<>(16);

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadPoolExecutor f29b;

    /* renamed from: c, reason: collision with root package name */
    static final Object f30c;
    static final q.g<String, ArrayList<E.a<b>>> d;

    final class a implements Callable<b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f31a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f32b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f33c;
        final /* synthetic */ int d;

        a(String str, Context context, e eVar, int i2) {
            this.f31a = str;
            this.f32b = context;
            this.f33c = eVar;
            this.d = i2;
        }

        @Override // java.util.concurrent.Callable
        public final b call() throws Exception {
            return f.b(this.f31a, this.f32b, this.f33c, this.d);
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new k());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f29b = threadPoolExecutor;
        f30c = new Object();
        d = new q.g<>();
    }

    private static String a(e eVar, int i2) {
        return eVar.b() + "-" + i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static b b(String str, Context context, e eVar, int i2) {
        int i4;
        Typeface typefaceB = f28a.b(str);
        if (typefaceB != null) {
            return new b(typefaceB);
        }
        try {
            j.a aVarA = d.a(context, eVar);
            int i5 = 1;
            if (aVarA.b() != 0) {
                i4 = aVarA.b() != 1 ? -3 : -2;
            } else {
                j.b[] bVarArrA = aVarA.a();
                if (bVarArrA == null || bVarArrA.length == 0) {
                    i4 = i5;
                } else {
                    for (j.b bVar : bVarArrA) {
                        int iA = bVar.a();
                        if (iA != 0) {
                            if (iA >= 0) {
                                i4 = iA;
                            }
                        }
                    }
                    i5 = 0;
                    i4 = i5;
                }
            }
            if (i4 != 0) {
                return new b(i4);
            }
            Typeface typefaceA = y.c.a(context, aVarA.a(), i2);
            if (typefaceA == null) {
                return new b(-3);
            }
            f28a.c(str, typefaceA);
            return new b(typefaceA);
        } catch (PackageManager.NameNotFoundException unused) {
            return new b(-1);
        }
    }

    static Typeface c(Context context, e eVar, int i2, c cVar) {
        String strA = a(eVar, i2);
        Typeface typefaceB = f28a.b(strA);
        if (typefaceB != null) {
            cVar.a(new b(typefaceB));
            return typefaceB;
        }
        g gVar = new g(cVar);
        synchronized (f30c) {
            q.g<String, ArrayList<E.a<b>>> gVar2 = d;
            ArrayList<E.a<b>> orDefault = gVar2.getOrDefault(strA, null);
            if (orDefault != null) {
                orDefault.add(gVar);
                return null;
            }
            ArrayList<E.a<b>> arrayList = new ArrayList<>();
            arrayList.add(gVar);
            gVar2.put(strA, arrayList);
            h hVar = new h(strA, context, eVar, i2);
            f29b.execute(new l(Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler(), hVar, new i(strA)));
            return null;
        }
    }

    static Typeface d(Context context, e eVar, c cVar, int i2, int i4) throws InterruptedException {
        String strA = a(eVar, i2);
        Typeface typefaceB = f28a.b(strA);
        if (typefaceB != null) {
            cVar.a(new b(typefaceB));
            return typefaceB;
        }
        if (i4 == -1) {
            b bVarB = b(strA, context, eVar, i2);
            cVar.a(bVarB);
            return bVarB.f34a;
        }
        try {
            try {
                try {
                    b bVar = (b) f29b.submit(new a(strA, context, eVar, i2)).get(i4, TimeUnit.MILLISECONDS);
                    cVar.a(bVar);
                    return bVar.f34a;
                } catch (TimeoutException unused) {
                    throw new InterruptedException("timeout");
                }
            } catch (InterruptedException e2) {
                throw e2;
            } catch (ExecutionException e4) {
                throw new RuntimeException(e4);
            }
        } catch (InterruptedException unused2) {
            cVar.a(new b(-3));
            return null;
        }
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f34a;

        /* renamed from: b, reason: collision with root package name */
        final int f35b;

        b(int i2) {
            this.f34a = null;
            this.f35b = i2;
        }

        @SuppressLint({"WrongConstant"})
        b(Typeface typeface) {
            this.f34a = typeface;
            this.f35b = 0;
        }
    }
}
