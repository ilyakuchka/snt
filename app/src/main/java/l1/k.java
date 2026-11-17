package l1;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.ActivityC0219o;
import androidx.fragment.app.E;
import androidx.fragment.app.w;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class k implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    private static final b f6532f = new a();

    /* renamed from: a, reason: collision with root package name */
    private volatile com.bumptech.glide.i f6533a;

    /* renamed from: b, reason: collision with root package name */
    final Map<FragmentManager, j> f6534b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final Map<w, n> f6535c = new HashMap();
    private final Handler d;

    /* renamed from: e, reason: collision with root package name */
    private final b f6536e;

    final class a implements b {
        a() {
        }

        @Override // l1.k.b
        public final com.bumptech.glide.i a(com.bumptech.glide.c cVar, g gVar, l lVar, Context context) {
            return new com.bumptech.glide.i(cVar, gVar, lVar, context);
        }
    }

    public interface b {
        com.bumptech.glide.i a(com.bumptech.glide.c cVar, g gVar, l lVar, Context context);
    }

    public k(b bVar) {
        new Bundle();
        this.f6536e = bVar == null ? f6532f : bVar;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    private static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashMap, java.util.Map<android.app.FragmentManager, l1.j>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.HashMap, java.util.Map<android.app.FragmentManager, l1.j>] */
    private j d(FragmentManager fragmentManager, boolean z4) {
        j jVar = (j) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (jVar == null && (jVar = (j) this.f6534b.get(fragmentManager)) == null) {
            jVar = new j();
            jVar.e();
            if (z4) {
                jVar.a().d();
            }
            this.f6534b.put(fragmentManager, jVar);
            fragmentManager.beginTransaction().add(jVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return jVar;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.HashMap, java.util.Map<androidx.fragment.app.w, l1.n>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.HashMap, java.util.Map<androidx.fragment.app.w, l1.n>] */
    private n f(w wVar, boolean z4) {
        n nVar = (n) wVar.T("com.bumptech.glide.manager");
        if (nVar == null && (nVar = (n) this.f6535c.get(wVar)) == null) {
            nVar = new n();
            nVar.h1();
            if (z4) {
                nVar.c1().d();
            }
            this.f6535c.put(wVar, nVar);
            E eF = wVar.f();
            eF.c(nVar);
            eF.h();
            this.d.obtainMessage(2, wVar).sendToTarget();
        }
        return nVar;
    }

    private static boolean g(Context context) {
        Activity activityA = a(context);
        return activityA == null || !activityA.isFinishing();
    }

    public final com.bumptech.glide.i b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (s1.j.h() && !(context instanceof Application)) {
            if (context instanceof ActivityC0219o) {
                ActivityC0219o activityC0219o = (ActivityC0219o) context;
                if (s1.j.g()) {
                    return b(activityC0219o.getApplicationContext());
                }
                if (activityC0219o.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                n nVarF = f(activityC0219o.u(), g(activityC0219o));
                com.bumptech.glide.i iVarE1 = nVarF.e1();
                if (iVarE1 != null) {
                    return iVarE1;
                }
                com.bumptech.glide.i iVarA = this.f6536e.a(com.bumptech.glide.c.c(activityC0219o), nVarF.c1(), nVarF.f1(), activityC0219o);
                nVarF.i1(iVarA);
                return iVarA;
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (s1.j.g()) {
                    return b(activity.getApplicationContext());
                }
                if (activity.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                j jVarD = d(activity.getFragmentManager(), g(activity));
                com.bumptech.glide.i iVarB = jVarD.b();
                if (iVarB != null) {
                    return iVarB;
                }
                com.bumptech.glide.i iVarA2 = this.f6536e.a(com.bumptech.glide.c.c(activity), jVarD.a(), jVarD.c(), activity);
                jVarD.f(iVarA2);
                return iVarA2;
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.f6533a == null) {
            synchronized (this) {
                if (this.f6533a == null) {
                    this.f6533a = this.f6536e.a(com.bumptech.glide.c.c(context.getApplicationContext()), new l1.b(), new l1.b(), context.getApplicationContext());
                }
            }
        }
        return this.f6533a;
    }

    @Deprecated
    final j c(Activity activity) {
        return d(activity.getFragmentManager(), g(activity));
    }

    final n e(Context context, w wVar) {
        return f(wVar, g(context));
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.HashMap, java.util.Map<android.app.FragmentManager, l1.j>] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.HashMap, java.util.Map<androidx.fragment.app.w, l1.n>] */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        Object objRemove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z4 = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            objRemove = this.f6534b.remove(obj);
        } else {
            if (i2 != 2) {
                z4 = false;
                obj2 = null;
                if (z4 && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z4;
            }
            obj = (w) message.obj;
            objRemove = this.f6535c.remove(obj);
        }
        obj3 = objRemove;
        obj2 = obj;
        if (z4) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z4;
    }
}
