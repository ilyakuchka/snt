package U2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.mmt.R;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import q.h;

/* loaded from: classes.dex */
public final class c {
    private static h<LinkedList<c>> g = new h<>();

    /* renamed from: h, reason: collision with root package name */
    private static Object f1717h = new Object();

    /* renamed from: a, reason: collision with root package name */
    private int f1718a;

    /* renamed from: b, reason: collision with root package name */
    private volatile View f1719b;

    /* renamed from: c, reason: collision with root package name */
    private Context f1720c;
    private ViewGroup d;

    /* renamed from: e, reason: collision with root package name */
    private CountDownLatch f1721e = new CountDownLatch(1);

    /* renamed from: f, reason: collision with root package name */
    private a f1722f;

    private c(Context context) {
        this.f1720c = context;
    }

    public static void b(int i2) {
        g.i(i2);
    }

    public static c c(Context context, ViewGroup viewGroup) {
        synchronized (f1717h) {
            if (g.e(R.layout.message_list_item_bubble, null) == null || g.e(R.layout.message_list_item_bubble, null).size() <= 0) {
                c cVar = new c(context);
                cVar.f1719b = LayoutInflater.from(context).inflate(R.layout.message_list_item_bubble, viewGroup, false);
                return cVar;
            }
            c cVarRemoveFirst = g.e(R.layout.message_list_item_bubble, null).removeFirst();
            if (g.e(R.layout.message_list_item_bubble, null).size() == 0) {
                g.i(R.layout.message_list_item_bubble);
            }
            return cVarRemoveFirst;
        }
    }

    public static void e(Context context, ViewGroup viewGroup, int i2) {
        for (int i4 = 0; i4 < i2; i4++) {
            c cVar = new c(context);
            cVar.d = viewGroup;
            cVar.f1718a = R.layout.message_list_item_bubble;
            synchronized (f1717h) {
                LinkedList<c> linkedListE = g.e(R.layout.message_list_item_bubble, null);
                if (linkedListE == null) {
                    LinkedList<c> linkedList = new LinkedList<>();
                    linkedList.add(cVar);
                    g.a(cVar.f1718a, linkedList);
                } else {
                    linkedListE.add(cVar);
                }
            }
            b bVar = new b(cVar);
            a aVar = new a(cVar.f1720c);
            cVar.f1722f = aVar;
            aVar.c(viewGroup, cVar.f1721e, bVar);
        }
    }

    public final View d() throws InterruptedException {
        if (this.f1719b == null && !this.f1722f.d()) {
            this.f1722f.b();
            this.f1719b = LayoutInflater.from(this.f1720c).inflate(this.f1718a, this.d, false);
        } else if (this.f1719b == null) {
            try {
                this.f1721e.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (this.f1719b == null) {
                this.f1719b = LayoutInflater.from(this.f1720c).inflate(this.f1718a, this.d, false);
            }
        }
        return this.f1719b;
    }
}
