package f3;

import java.util.Objects;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final g f6244a;

    static {
        g gVar = null;
        try {
            gVar = (g) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (gVar == null) {
            gVar = new g();
        }
        f6244a = gVar;
    }

    public static String a(d dVar) {
        Objects.requireNonNull(f6244a);
        String string = dVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
