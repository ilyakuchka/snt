package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import f.AbstractC0300a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private Random f2244a = new Random();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, String> f2245b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final Map<String, Integer> f2246c = new HashMap();
    private final Map<String, C0054c> d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    ArrayList<String> f2247e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    final transient Map<String, b<?>> f2248f = new HashMap();
    final Map<String, Object> g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    final Bundle f2249h = new Bundle();

    final class a extends O.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2250a;

        a(String str) {
            this.f2250a = str;
        }

        @Override // O.d
        public final void h() {
            c.this.f(this.f2250a);
        }
    }

    private static class b<O> {

        /* renamed from: a, reason: collision with root package name */
        final androidx.activity.result.b<O> f2252a;

        /* renamed from: b, reason: collision with root package name */
        final AbstractC0300a<?, O> f2253b;

        b(androidx.activity.result.b<O> bVar, AbstractC0300a<?, O> abstractC0300a) {
            this.f2252a = bVar;
            this.f2253b = abstractC0300a;
        }
    }

    /* renamed from: androidx.activity.result.c$c, reason: collision with other inner class name */
    private static class C0054c {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    private void a(int i2, String str) {
        this.f2245b.put(Integer.valueOf(i2), str);
        this.f2246c.put(str, Integer.valueOf(i2));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.HashMap, java.util.Map<java.lang.String, androidx.activity.result.c$b<?>>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    public final boolean b(int i2, int i4, Intent intent) {
        androidx.activity.result.b<O> bVar;
        String str = (String) this.f2245b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        this.f2247e.remove(str);
        b bVar2 = (b) this.f2248f.get(str);
        if (bVar2 != null && (bVar = bVar2.f2252a) != 0) {
            bVar.a(bVar2.f2253b.a(i4, intent));
            return true;
        }
        this.g.remove(str);
        this.f2249h.putParcelable(str, new androidx.activity.result.a(i4, intent));
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    public final void c(Bundle bundle) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f2247e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f2244a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f2249h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
            String str = stringArrayList.get(i2);
            if (this.f2246c.containsKey(str)) {
                Integer num = (Integer) this.f2246c.remove(str);
                if (!this.f2249h.containsKey(str)) {
                    this.f2245b.remove(num);
                }
            }
            a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    public final void d(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f2246c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f2246c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f2247e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f2249h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f2244a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.HashMap, java.util.Map<java.lang.String, androidx.activity.result.c$b<?>>] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.String>] */
    public final <I, O> O.d e(String str, AbstractC0300a<I, O> abstractC0300a, androidx.activity.result.b<O> bVar) {
        int i2;
        Integer num = (Integer) this.f2246c.get(str);
        if (num != null) {
            num.intValue();
        } else {
            int iNextInt = this.f2244a.nextInt(2147418112);
            while (true) {
                i2 = iNextInt + 65536;
                if (!this.f2245b.containsKey(Integer.valueOf(i2))) {
                    break;
                }
                iNextInt = this.f2244a.nextInt(2147418112);
            }
            a(i2, str);
        }
        this.f2248f.put(str, new b(bVar, abstractC0300a));
        if (this.g.containsKey(str)) {
            Object obj = this.g.get(str);
            this.g.remove(str);
            bVar.a(obj);
        }
        androidx.activity.result.a aVar = (androidx.activity.result.a) this.f2249h.getParcelable(str);
        if (aVar != null) {
            this.f2249h.remove(str);
            bVar.a(abstractC0300a.a(aVar.b(), aVar.a()));
        }
        return new a(str);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.HashMap, java.util.Map<java.lang.String, androidx.activity.result.c$b<?>>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.HashMap, java.util.Map<java.lang.String, androidx.activity.result.c$c>] */
    final void f(String str) {
        Integer num;
        if (!this.f2247e.contains(str) && (num = (Integer) this.f2246c.remove(str)) != null) {
            this.f2245b.remove(num);
        }
        this.f2248f.remove(str);
        if (this.g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.g.get(str));
            this.g.remove(str);
        }
        if (this.f2249h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f2249h.getParcelable(str));
            this.f2249h.remove(str);
        }
        if (((C0054c) this.d.get(str)) != null) {
            throw null;
        }
    }
}
