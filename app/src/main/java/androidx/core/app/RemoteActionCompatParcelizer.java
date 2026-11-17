package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f3278a = (IconCompat) aVar.t(remoteActionCompat.f3278a);
        remoteActionCompat.f3279b = aVar.k(remoteActionCompat.f3279b, 2);
        remoteActionCompat.f3280c = aVar.k(remoteActionCompat.f3280c, 3);
        remoteActionCompat.d = (PendingIntent) aVar.p(remoteActionCompat.d, 4);
        remoteActionCompat.f3281e = aVar.g(remoteActionCompat.f3281e, 5);
        remoteActionCompat.f3282f = aVar.g(remoteActionCompat.f3282f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Objects.requireNonNull(aVar);
        aVar.H(remoteActionCompat.f3278a);
        aVar.A(remoteActionCompat.f3279b, 2);
        aVar.A(remoteActionCompat.f3280c, 3);
        aVar.E(remoteActionCompat.d, 4);
        aVar.w(remoteActionCompat.f3281e, 5);
        aVar.w(remoteActionCompat.f3282f, 6);
    }
}
