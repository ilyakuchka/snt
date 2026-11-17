package U2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.h;
import com.android.mmt.R;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public final class a {
    private static ExecutorService d = Executors.newCachedThreadPool();

    /* renamed from: e, reason: collision with root package name */
    private static E.d<b> f1703e = new E.d<>(10);

    /* renamed from: a, reason: collision with root package name */
    private LayoutInflater f1704a;

    /* renamed from: b, reason: collision with root package name */
    private c f1705b;

    /* renamed from: c, reason: collision with root package name */
    private Future<?> f1706c;

    /* renamed from: U2.a$a, reason: collision with other inner class name */
    private static class C0042a extends LayoutInflater {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f1707a = {"android.widget.", "android.webkit.", "android.app."};

        C0042a(Context context) {
            super(context);
            if (context instanceof h) {
                Object objZ = ((h) context).z();
                if (objZ instanceof LayoutInflater.Factory2) {
                    setFactory2((LayoutInflater.Factory2) objZ);
                }
            }
        }

        @Override // android.view.LayoutInflater
        public final LayoutInflater cloneInContext(Context context) {
            return new C0042a(context);
        }

        @Override // android.view.LayoutInflater
        protected final View onCreateView(String str, AttributeSet attributeSet) throws InflateException, ClassNotFoundException {
            View viewCreateView;
            String[] strArr = f1707a;
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    viewCreateView = createView(str, strArr[i2], attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (viewCreateView != null) {
                    return viewCreateView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        a f1708a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f1709b;

        /* renamed from: c, reason: collision with root package name */
        int f1710c;
        View d;

        /* renamed from: e, reason: collision with root package name */
        d f1711e;

        /* renamed from: f, reason: collision with root package name */
        CountDownLatch f1712f;

        b() {
        }
    }

    private class c implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private b f1713i;

        /* renamed from: j, reason: collision with root package name */
        private volatile boolean f1714j;

        public c(b bVar) {
            this.f1713i = bVar;
        }

        public final boolean a() {
            return this.f1714j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1714j = true;
            try {
                b bVar = this.f1713i;
                LayoutInflater layoutInflater = bVar.f1708a.f1704a;
                b bVar2 = this.f1713i;
                bVar.d = layoutInflater.inflate(bVar2.f1710c, bVar2.f1709b, false);
            } catch (RuntimeException e2) {
                Log.w("AsyncLayoutInflaterPlus", "Failed to inflate resource in the background! Retrying on the UI thread", e2);
            }
            b bVar3 = this.f1713i;
            ((U2.b) bVar3.f1711e).f1716a.f1719b = bVar3.d;
            bVar3.f1712f.countDown();
            a.this.e(bVar3);
        }
    }

    public interface d {
    }

    public a(Context context) {
        this.f1704a = new C0042a(context);
    }

    public final void b() {
        this.f1706c.cancel(true);
    }

    public final void c(ViewGroup viewGroup, CountDownLatch countDownLatch, d dVar) {
        b bVarB = f1703e.b();
        if (bVarB == null) {
            bVarB = new b();
        }
        bVarB.f1708a = this;
        bVarB.f1710c = R.layout.message_list_item_bubble;
        bVarB.f1709b = viewGroup;
        bVarB.f1711e = dVar;
        bVarB.f1712f = countDownLatch;
        c cVar = new c(bVarB);
        this.f1705b = cVar;
        this.f1706c = d.submit(cVar);
    }

    public final boolean d() {
        return this.f1705b.a();
    }

    public final void e(b bVar) {
        bVar.f1711e = null;
        bVar.f1708a = null;
        bVar.f1709b = null;
        bVar.f1710c = 0;
        bVar.d = null;
        f1703e.a(bVar);
    }
}
