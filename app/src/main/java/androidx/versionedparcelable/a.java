package androidx.versionedparcelable;

import a0.InterfaceC0179a;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import q.C0365a;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final C0365a<String, Method> f4299a;

    /* renamed from: b, reason: collision with root package name */
    protected final C0365a<String, Method> f4300b;

    /* renamed from: c, reason: collision with root package name */
    protected final C0365a<String, Class> f4301c;

    public a(C0365a<String, Method> c0365a, C0365a<String, Method> c0365a2, C0365a<String, Class> c0365a3) {
        this.f4299a = c0365a;
        this.f4300b = c0365a2;
        this.f4301c = c0365a3;
    }

    private Class c(Class<? extends InterfaceC0179a> cls) throws ClassNotFoundException {
        Class orDefault = this.f4301c.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f4301c.put(cls.getName(), cls2);
        return cls2;
    }

    private Method d(String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Method orDefault = this.f4299a.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f4299a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method orDefault = this.f4300b.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, a.class);
        this.f4300b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public final void A(CharSequence charSequence, int i2) {
        u(i2);
        z(charSequence);
    }

    protected abstract void B(int i2);

    public final void C(int i2, int i4) {
        u(i4);
        B(i2);
    }

    protected abstract void D(Parcelable parcelable);

    public final void E(Parcelable parcelable, int i2) {
        u(i2);
        D(parcelable);
    }

    protected abstract void F(String str);

    public final void G(String str, int i2) {
        u(i2);
        F(str);
    }

    public final void H(InterfaceC0179a interfaceC0179a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        u(1);
        I(interfaceC0179a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void I(InterfaceC0179a interfaceC0179a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (interfaceC0179a == null) {
            F(null);
            return;
        }
        try {
            F(c(interfaceC0179a.getClass()).getName());
            a aVarB = b();
            try {
                e(interfaceC0179a.getClass()).invoke(null, interfaceC0179a, aVarB);
                aVarB.a();
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
            } catch (InvocationTargetException e6) {
                if (!(e6.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
                }
                throw ((RuntimeException) e6.getCause());
            }
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException(interfaceC0179a.getClass().getSimpleName() + " does not have a Parcelizer", e7);
        }
    }

    protected abstract void a();

    protected abstract a b();

    protected abstract boolean f();

    public final boolean g(boolean z4, int i2) {
        return !l(i2) ? z4 : f();
    }

    protected abstract byte[] h();

    public final byte[] i(byte[] bArr) {
        return !l(2) ? bArr : h();
    }

    protected abstract CharSequence j();

    public final CharSequence k(CharSequence charSequence, int i2) {
        return !l(i2) ? charSequence : j();
    }

    protected abstract boolean l(int i2);

    protected abstract int m();

    public final int n(int i2, int i4) {
        return !l(i4) ? i2 : m();
    }

    protected abstract <T extends Parcelable> T o();

    public final <T extends Parcelable> T p(T t2, int i2) {
        return !l(i2) ? t2 : (T) o();
    }

    protected abstract String q();

    public final String r(String str, int i2) {
        return !l(i2) ? str : q();
    }

    protected final <T extends InterfaceC0179a> T s() {
        String strQ = q();
        if (strQ == null) {
            return null;
        }
        try {
            return (T) d(strQ).invoke(null, b());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }

    public final InterfaceC0179a t(InterfaceC0179a interfaceC0179a) {
        return !l(1) ? interfaceC0179a : s();
    }

    protected abstract void u(int i2);

    protected abstract void v(boolean z4);

    public final void w(boolean z4, int i2) {
        u(i2);
        v(z4);
    }

    protected abstract void x(byte[] bArr);

    public final void y(byte[] bArr) {
        u(2);
        x(bArr);
    }

    protected abstract void z(CharSequence charSequence);
}
