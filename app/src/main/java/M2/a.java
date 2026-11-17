package M2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class a {
    public static NetworkCapabilities a(boolean z4, int i2) throws NoSuchFieldException {
        Field declaredField;
        NetworkRequest.Builder builderAddCapability = new NetworkRequest.Builder().addTransportType(0).addCapability(0);
        if (z4) {
            builderAddCapability.setNetworkSpecifier(String.valueOf(i2));
        }
        Class<NetworkRequest> superclass = NetworkRequest.class;
        while (true) {
            if (superclass == null) {
                declaredField = null;
                break;
            }
            try {
                declaredField = superclass.getDeclaredField("networkCapabilities");
                break;
            } catch (NoSuchFieldException e2) {
                try {
                    superclass = superclass.getSuperclass();
                    e2.toString();
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
        }
        return (NetworkCapabilities) declaredField.get(builderAddCapability.build());
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 4) {
            return str;
        }
        StringBuilder sb = new StringBuilder(16);
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                if (strArrSplit[i2].length() > 3) {
                    return str;
                }
                sb.append(Integer.parseInt(strArrSplit[i2]));
                if (i2 < 3) {
                    sb.append('.');
                }
            } catch (NumberFormatException unused) {
                return str;
            }
        }
        return sb.toString();
    }
}
