package com.android.mmt.util;

import android.graphics.HardwareRenderer;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.lifecycle.g;
import com.android.mmt.MmsApp;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import x0.C0414a;
import x0.C0416c;

/* loaded from: classes.dex */
public class BackgroundCleaner implements androidx.lifecycle.j {

    /* renamed from: a, reason: collision with root package name */
    private final List<WeakReference<c>> f5839a;

    /* renamed from: b, reason: collision with root package name */
    private CountDownTimer f5840b;

    private static class b extends CountDownTimer {
        public b() {
            super(110000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Log.i("BackgroundCleaner", "Background cleaner executes");
            C0414a.o0();
            com.bumptech.glide.c.c(MmsApp.c()).b();
            C0416c.l();
            Iterator it = ((CopyOnWriteArrayList) d.f5841a.f5839a).iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                c cVar = (c) weakReference.get();
                if (cVar == null) {
                    ((CopyOnWriteArrayList) d.f5841a.f5839a).remove(weakReference);
                } else {
                    cVar.b();
                }
            }
            try {
                Object[] objArr = {80};
                try {
                    Method declaredMethod = HardwareRenderer.class.getDeclaredMethod("trimMemory", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(null, objArr);
                } catch (Exception e2) {
                    Log.e("ReflectUtil", "Failed to call static method:trimMemory", e2);
                }
            } catch (Exception e4) {
                Log.e("BackgroundCleaner", "cleanGraphicsCache error, ", e4);
            }
            d.f5841a.f5840b = null;
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j2) {
        }
    }

    public interface c {
        void b();
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final BackgroundCleaner f5841a = new BackgroundCleaner();
    }

    public static BackgroundCleaner j() {
        return d.f5841a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<java.lang.ref.WeakReference<com.android.mmt.util.BackgroundCleaner$c>>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<java.lang.ref.WeakReference<com.android.mmt.util.BackgroundCleaner$c>>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List<java.lang.ref.WeakReference<com.android.mmt.util.BackgroundCleaner$c>>, java.util.concurrent.CopyOnWriteArrayList] */
    public final void k(c cVar) {
        if (cVar == null) {
            return;
        }
        Iterator it = this.f5839a.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            c cVar2 = (c) weakReference.get();
            if (cVar2 == null) {
                this.f5839a.remove(weakReference);
            } else if (cVar2 == cVar) {
                return;
            }
        }
        this.f5839a.add(new WeakReference(cVar));
    }

    @androidx.lifecycle.q(g.b.ON_STOP)
    public void onEnterBackground() {
        b bVar = new b();
        this.f5840b = bVar;
        bVar.start();
    }

    @androidx.lifecycle.q(g.b.ON_START)
    public void onEnterForeground() {
        CountDownTimer countDownTimer = this.f5840b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f5840b = null;
        }
    }

    private BackgroundCleaner() {
        this.f5839a = new CopyOnWriteArrayList();
    }
}
