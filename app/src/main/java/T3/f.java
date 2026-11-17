package T3;

import L3.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class f extends h {
    public static final a d = new a();

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f1636e;

    public static final class a {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    static {
        Integer numValueOf;
        int i2;
        int i4;
        int i5;
        String property = System.getProperty("java.specification.version");
        boolean z4 = true;
        if (property == null) {
            numValueOf = null;
            break;
        }
        i3.a.c(10);
        int length = property.length();
        if (length != 0) {
            char cCharAt = property.charAt(0);
            int i6 = -2147483647;
            if (f3.c.e(cCharAt, 48) < 0) {
                if (length != 1) {
                    if (cCharAt == '-') {
                        i6 = Integer.MIN_VALUE;
                        i2 = 1;
                    } else if (cCharAt == '+') {
                        i4 = 1;
                        i2 = 0;
                        int i7 = 0;
                        int i8 = -59652323;
                        while (i4 < length) {
                            int iDigit = Character.digit((int) property.charAt(i4), 10);
                            if (iDigit >= 0 && ((i7 >= i8 || (i8 == -59652323 && i7 >= (i8 = i6 / 10))) && (i5 = i7 * 10) >= i6 + iDigit)) {
                                i7 = i5 - iDigit;
                                i4++;
                            }
                        }
                        numValueOf = i2 == 0 ? Integer.valueOf(i7) : Integer.valueOf(-i7);
                    }
                }
                numValueOf = null;
                break;
            } else {
                i2 = 0;
            }
            i4 = i2;
            int i72 = 0;
            int i82 = -59652323;
            while (i4 < length) {
            }
            if (i2 == 0) {
            }
        }
        if (numValueOf == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
            } catch (NoSuchMethodException unused) {
            }
        } else if (numValueOf.intValue() < 9) {
            z4 = false;
        }
        f1636e = z4;
    }

    @Override // T3.h
    public final void e(SSLSocket sSLSocket, String str, List<x> list) {
        f3.c.d(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        Object[] array = ((ArrayList) h.f1639a.a(list)).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        sSLParameters.setApplicationProtocols((String[]) array);
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // T3.h
    public final String f(SSLSocket sSLSocket) {
        String applicationProtocol;
        try {
            applicationProtocol = sSLSocket.getApplicationProtocol();
        } catch (UnsupportedOperationException unused) {
        }
        if (applicationProtocol == null ? true : f3.c.a(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }
}
