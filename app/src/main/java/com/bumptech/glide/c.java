package com.bumptech.glide;

import W0.j;
import W0.l;
import Y0.m;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import c1.a;
import c1.b;
import c1.c;
import c1.d;
import c1.e;
import c1.j;
import c1.s;
import c1.t;
import c1.u;
import c1.v;
import c1.w;
import c1.x;
import com.bumptech.glide.load.ImageHeaderParser;
import d1.a;
import d1.b;
import d1.c;
import d1.d;
import d1.e;
import d1.f;
import f1.C0304b;
import f1.n;
import f1.s;
import f1.u;
import f1.v;
import g1.a;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k1.C0342b;
import k1.C0343c;
import l1.k;

/* loaded from: classes.dex */
public final class c implements ComponentCallbacks2 {

    /* renamed from: r, reason: collision with root package name */
    private static volatile c f6061r;

    /* renamed from: s, reason: collision with root package name */
    private static volatile boolean f6062s;

    /* renamed from: i, reason: collision with root package name */
    private final Z0.d f6063i;

    /* renamed from: j, reason: collision with root package name */
    private final a1.i f6064j;

    /* renamed from: k, reason: collision with root package name */
    private final e f6065k;

    /* renamed from: l, reason: collision with root package name */
    private final g f6066l;

    /* renamed from: m, reason: collision with root package name */
    private final Z0.b f6067m;

    /* renamed from: n, reason: collision with root package name */
    private final k f6068n;

    /* renamed from: o, reason: collision with root package name */
    private final l1.d f6069o;
    private final List<i> p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private final a f6070q;

    public interface a {
        o1.e a();
    }

    c(Context context, m mVar, a1.i iVar, Z0.d dVar, Z0.b bVar, k kVar, l1.d dVar2, a aVar, Map map, List list) {
        this.f6063i = dVar;
        this.f6067m = bVar;
        this.f6064j = iVar;
        this.f6068n = kVar;
        this.f6069o = dVar2;
        this.f6070q = aVar;
        Resources resources = context.getResources();
        g gVar = new g();
        this.f6066l = gVar;
        gVar.o(new f1.i());
        gVar.o(new n());
        List<ImageHeaderParser> listF = gVar.f();
        j1.a aVar2 = new j1.a(context, listF, dVar, bVar);
        V0.j<ParcelFileDescriptor, Bitmap> jVarF = v.f(dVar);
        f1.k kVar2 = new f1.k(gVar.f(), resources.getDisplayMetrics(), dVar, bVar);
        f1.f fVar = new f1.f(kVar2, 0);
        s sVar = new s(kVar2, bVar);
        h1.d dVar3 = new h1.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar4 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        f1.c cVar2 = new f1.c(bVar);
        k1.a aVar4 = new k1.a();
        p2.c cVar3 = new p2.c(3);
        ContentResolver contentResolver = context.getContentResolver();
        gVar.a(ByteBuffer.class, new p2.c(1));
        gVar.a(InputStream.class, new t(bVar));
        gVar.e("Bitmap", ByteBuffer.class, Bitmap.class, fVar);
        gVar.e("Bitmap", InputStream.class, Bitmap.class, sVar);
        gVar.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new f1.f(kVar2, 1));
        gVar.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, jVarF);
        gVar.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, v.c(dVar));
        gVar.d(Bitmap.class, Bitmap.class, v.a.b());
        gVar.e("Bitmap", Bitmap.class, Bitmap.class, new u());
        gVar.b(Bitmap.class, cVar2);
        gVar.e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new f1.a(resources, fVar));
        gVar.e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new f1.a(resources, sVar));
        gVar.e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new f1.a(resources, jVarF));
        gVar.b(BitmapDrawable.class, new C0304b(dVar, cVar2));
        gVar.e("Gif", InputStream.class, j1.c.class, new j1.i(listF, aVar2, bVar));
        gVar.e("Gif", ByteBuffer.class, j1.c.class, aVar2);
        gVar.b(j1.c.class, new p2.c(2));
        gVar.d(U0.a.class, U0.a.class, v.a.b());
        gVar.e("Bitmap", U0.a.class, Bitmap.class, new j1.g(dVar));
        gVar.e("legacy_append", Uri.class, Drawable.class, dVar3);
        gVar.e("legacy_append", Uri.class, Bitmap.class, new f1.a(dVar3, dVar));
        gVar.n(new a.C0110a());
        gVar.d(File.class, ByteBuffer.class, new c.b());
        gVar.d(File.class, InputStream.class, new e.C0085e());
        gVar.e("legacy_append", File.class, File.class, new i1.a());
        gVar.d(File.class, ParcelFileDescriptor.class, new e.b());
        gVar.d(File.class, File.class, v.a.b());
        gVar.n(new j.a(bVar));
        gVar.n(new l.a());
        Class cls = Integer.TYPE;
        gVar.d(cls, InputStream.class, cVar);
        gVar.d(cls, ParcelFileDescriptor.class, bVar2);
        gVar.d(Integer.class, InputStream.class, cVar);
        gVar.d(Integer.class, ParcelFileDescriptor.class, bVar2);
        gVar.d(Integer.class, Uri.class, dVar4);
        gVar.d(cls, AssetFileDescriptor.class, aVar3);
        gVar.d(Integer.class, AssetFileDescriptor.class, aVar3);
        gVar.d(cls, Uri.class, dVar4);
        gVar.d(String.class, InputStream.class, new d.c());
        gVar.d(Uri.class, InputStream.class, new d.c());
        gVar.d(String.class, InputStream.class, new u.c());
        gVar.d(String.class, ParcelFileDescriptor.class, new u.b());
        gVar.d(String.class, AssetFileDescriptor.class, new u.a());
        gVar.d(Uri.class, InputStream.class, new b.a());
        gVar.d(Uri.class, InputStream.class, new a.c(context.getAssets()));
        gVar.d(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets()));
        gVar.d(Uri.class, InputStream.class, new c.a(context));
        gVar.d(Uri.class, InputStream.class, new d.a(context));
        gVar.d(Uri.class, InputStream.class, new e.c(context));
        gVar.d(Uri.class, ParcelFileDescriptor.class, new e.b(context));
        gVar.d(Uri.class, InputStream.class, new w.d(contentResolver));
        gVar.d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver));
        gVar.d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver));
        gVar.d(Uri.class, InputStream.class, new x.a());
        gVar.d(URL.class, InputStream.class, new f.a());
        gVar.d(Uri.class, File.class, new j.a(context));
        gVar.d(c1.f.class, InputStream.class, new a.C0109a());
        gVar.d(byte[].class, ByteBuffer.class, new b.a());
        gVar.d(byte[].class, InputStream.class, new b.d());
        gVar.d(Uri.class, Uri.class, v.a.b());
        gVar.d(Drawable.class, Drawable.class, v.a.b());
        gVar.e("legacy_append", Drawable.class, Drawable.class, new h1.e());
        gVar.p(Bitmap.class, BitmapDrawable.class, new C0342b(resources));
        gVar.p(Bitmap.class, byte[].class, aVar4);
        gVar.p(Drawable.class, byte[].class, new C0343c(dVar, aVar4, cVar3));
        gVar.p(j1.c.class, byte[].class, cVar3);
        V0.j<ByteBuffer, Bitmap> jVarD = f1.v.d(dVar);
        gVar.c(ByteBuffer.class, Bitmap.class, jVarD);
        gVar.c(ByteBuffer.class, BitmapDrawable.class, new f1.a(resources, jVarD));
        this.f6065k = new e(context, bVar, gVar, new p2.c(4), aVar, map, list, mVar);
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) throws PackageManager.NameNotFoundException {
        if (f6062s) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f6062s = true;
        d dVar = new d();
        Context applicationContext = context.getApplicationContext();
        List<m1.b> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listEmptyList = new m1.d(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> setD = generatedAppGlideModule.d();
            Iterator<m1.b> it = listEmptyList.iterator();
            while (it.hasNext()) {
                m1.b next = it.next();
                if (setD.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (m1.b bVar : listEmptyList) {
                StringBuilder sbD = D2.e.d("Discovered GlideModule from manifest: ");
                sbD.append(bVar.getClass());
                Log.d("Glide", sbD.toString());
            }
        }
        dVar.d(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator<m1.b> it2 = listEmptyList.iterator();
        while (it2.hasNext()) {
            it2.next().a(applicationContext, dVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, dVar);
        }
        c cVarA = dVar.a(applicationContext);
        for (m1.b bVar2 : listEmptyList) {
            try {
                bVar2.b();
            } catch (AbstractMethodError e2) {
                StringBuilder sbD2 = D2.e.d("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                sbD2.append(bVar2.getClass().getName());
                throw new IllegalStateException(sbD2.toString(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a();
        }
        applicationContext.registerComponentCallbacks(cVarA);
        f6061r = cVarA;
        f6062s = false;
    }

    public static c c(Context context) {
        if (f6061r == null) {
            GeneratedAppGlideModule generatedAppGlideModule = null;
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
            } catch (IllegalAccessException e2) {
                m(e2);
                throw null;
            } catch (InstantiationException e4) {
                m(e4);
                throw null;
            } catch (NoSuchMethodException e5) {
                m(e5);
                throw null;
            } catch (InvocationTargetException e6) {
                m(e6);
                throw null;
            }
            synchronized (c.class) {
                if (f6061r == null) {
                    a(context, generatedAppGlideModule);
                }
            }
        }
        return f6061r;
    }

    private static void m(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static i o(Context context) {
        Objects.requireNonNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).f6068n.b(context);
    }

    public final void b() {
        s1.j.a();
        ((s1.g) this.f6064j).a();
        this.f6063i.b();
        this.f6067m.b();
    }

    public final Z0.b d() {
        return this.f6067m;
    }

    public final Z0.d e() {
        return this.f6063i;
    }

    final l1.d f() {
        return this.f6069o;
    }

    public final Context g() {
        return this.f6065k.getBaseContext();
    }

    final e h() {
        return this.f6065k;
    }

    public final g i() {
        return this.f6066l;
    }

    public final k j() {
        return this.f6068n;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<com.bumptech.glide.i>] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<com.bumptech.glide.i>] */
    final void k(i iVar) {
        synchronized (this.p) {
            if (this.p.contains(iVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.p.add(iVar);
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<com.bumptech.glide.i>] */
    final boolean l(p1.f<?> fVar) {
        synchronized (this.p) {
            Iterator it = this.p.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).u(fVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<com.bumptech.glide.i>] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<com.bumptech.glide.i>] */
    final void n(i iVar) {
        synchronized (this.p) {
            if (!this.p.contains(iVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.p.remove(iVar);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<com.bumptech.glide.i>] */
    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        s1.j.a();
        Iterator it = this.p.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull((i) it.next());
        }
        ((a1.h) this.f6064j).j(i2);
        this.f6063i.a(i2);
        this.f6067m.a(i2);
    }
}
