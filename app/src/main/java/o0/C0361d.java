package o0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* renamed from: o0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0361d {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f7515a = new HashSet(Arrays.asList("ES", "FR", "DE", "IT", "PL", "CZ", "GR", "GB", "UA", "PT", "BE", "HU", "AT", "CH", "IE", "RO", "SK", "FI", "SE", "HR", "BG", "RS", "LT", "LV", "SI", "BA", "AL", "ME", "MK", "NL", "CY", "DK", "EE", "IS", "LI", "LU", "MT", "NO"));

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    public static boolean a() {
        return f7515a.contains(C0360c.a());
    }
}
