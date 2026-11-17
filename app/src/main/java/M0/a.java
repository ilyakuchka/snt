package M0;

import android.util.Log;
import com.android.mmt.storage.bugle.BugleDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Long, L0.a> f564a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f565b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private PriorityBlockingQueue<L0.a> f566c;
    private b d;

    /* renamed from: M0.a$a, reason: collision with other inner class name */
    final class C0018a implements Comparator<L0.a> {
        C0018a() {
        }

        @Override // java.util.Comparator
        public final int compare(L0.a aVar, L0.a aVar2) {
            return aVar.b() > aVar2.b() ? -1 : 1;
        }
    }

    private class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private AtomicBoolean f567i = new AtomicBoolean(false);

        /* renamed from: j, reason: collision with root package name */
        private AtomicBoolean f568j = new AtomicBoolean(true);

        /* renamed from: k, reason: collision with root package name */
        private List<L0.a> f569k = Collections.synchronizedList(new ArrayList());

        /* renamed from: l, reason: collision with root package name */
        private PriorityBlockingQueue f570l;

        public b(PriorityBlockingQueue priorityBlockingQueue) {
            this.f570l = priorityBlockingQueue;
        }

        private boolean a(List<L0.a> list) {
            if (list.size() == 0) {
                return false;
            }
            StringBuilder sbD = D2.e.d("batchIO: ");
            sbD.append(list.size());
            Log.d("BugleIoControl_flag", sbD.toString());
            BugleDatabase.y().x().H((L0.a[]) list.toArray(new L0.a[0]));
            return true;
        }

        public final boolean b() {
            return this.f567i.get();
        }

        public final void c(boolean z4) {
            this.f568j.compareAndSet(!z4, z4);
        }

        public final void d() {
            this.f567i.compareAndSet(false, true);
        }

        public final void e() {
            StringBuilder sbD = D2.e.d("IoWorker stop: ");
            sbD.append(this.f569k.size());
            Log.d("BugleIoControl", sbD.toString());
            if (b()) {
                this.f567i.compareAndSet(true, false);
            }
            if (a(new ArrayList(this.f569k))) {
                this.f569k.clear();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (this.f567i.get()) {
                if (this.f568j.get()) {
                    try {
                        L0.a aVar = (L0.a) this.f570l.poll(2L, TimeUnit.SECONDS);
                        if (aVar == null) {
                            e();
                        } else {
                            this.f569k.add(aVar);
                            int size = this.f569k.size();
                            Objects.requireNonNull(a.this);
                            if (size >= 60 && a(new ArrayList(this.f569k))) {
                                this.f569k.clear();
                            }
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public a() {
        this.f564a = new ConcurrentHashMap<>();
        this.f564a = new ConcurrentHashMap<>();
        PriorityBlockingQueue<L0.a> priorityBlockingQueue = new PriorityBlockingQueue<>(11, new C0018a());
        this.f566c = priorityBlockingQueue;
        this.d = new b(priorityBlockingQueue);
    }

    private void a() {
        if (this.d.b()) {
            return;
        }
        this.d.d();
        N0.a.d(this.d);
    }

    public final void b(boolean z4, L0.a aVar) {
        StringBuilder sbD = D2.e.d("insertConversation: ");
        sbD.append(aVar.f());
        sbD.append(" |  | ");
        sbD.append(this.f565b.get());
        sbD.append(" | ");
        sbD.append(z4);
        Log.d("BugleIoControl", sbD.toString());
        if (this.f564a.containsKey(Long.valueOf(aVar.f()))) {
            L0.a aVarA = L0.c.a(this.f564a.get(Long.valueOf(aVar.f())), aVar);
            if (aVarA != null) {
                this.f564a.put(Long.valueOf(aVar.f()), aVarA);
            }
        } else {
            this.f564a.put(Long.valueOf(aVar.f()), aVar);
        }
        if (z4) {
            a();
            if (this.f565b.get()) {
                this.f566c.add(aVar);
                a();
                return;
            }
            if (aVar.f() > 0) {
                BugleDatabase.y().x().H(aVar);
            }
            if (this.f564a.size() >= 60) {
                this.f565b.compareAndSet(false, true);
                this.f566c.clear();
            }
        }
    }

    public final void c(boolean z4) {
        this.d.c(z4);
    }

    public final void d() {
        StringBuilder sbD = D2.e.d("submit: ");
        sbD.append(Thread.currentThread().getId());
        sbD.append(" | ");
        sbD.append(this.f566c.size());
        Log.d("BugleIoControl", sbD.toString());
        if (this.d.b()) {
            this.d.e();
        }
        if (this.f566c.size() > 0) {
            BugleDatabase.y().x().H((L0.a[]) this.f566c.toArray(new L0.a[0]));
            this.f566c.clear();
        }
        BugleDatabase.y().x().I();
        this.f564a.clear();
    }

    public final void e() {
        a();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        StringBuilder sbD = D2.e.d("synchronizeConversation all: ");
        sbD.append(this.f564a.size());
        Log.d("BugleIoControl", sbD.toString());
        new ArrayList();
        Log.d("BugleIoControl", "synchronizeConversation common: " + this.f564a.size());
        for (L0.a aVar : this.f564a.values()) {
            StringBuilder sbD2 = D2.e.d("synchronizeConversation: ");
            sbD2.append(aVar.f());
            sbD2.append(" | ");
            sbD2.append(aVar.g());
            Log.d("BugleIoControl", sbD2.toString());
            this.f566c.add(aVar);
            a();
            hashSet.add(Long.valueOf(aVar.f()));
            if (aVar.k() > 0) {
                hashSet.add(-103L);
            }
        }
        this.f564a.clear();
        Log.d("BugleIoControl", "synchronizeConversation threads: " + hashSet.size() + " | " + hashSet2.size());
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            this.f566c.addAll(L0.b.a(((Long) it.next()).longValue(), false));
        }
    }
}
