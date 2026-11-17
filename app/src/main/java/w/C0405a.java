package w;

import android.content.Context;
import android.os.Process;

/* renamed from: w.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0405a {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f7978a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f7979b = 0;

    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }
}
