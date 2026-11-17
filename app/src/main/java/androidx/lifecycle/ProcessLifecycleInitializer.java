package androidx.lifecycle;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements X.a<k> {
    @Override // X.a
    public final List<Class<? extends X.a<?>>> a() {
        return Collections.emptyList();
    }

    @Override // X.a
    public final k b(Context context) {
        if (!androidx.startup.a.c(context).d()) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        h.a(context);
        r.k(context);
        return r.j();
    }
}
