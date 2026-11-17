package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.android.mmt.util.MmsGlideModule;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import l1.k;

/* loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* renamed from: a, reason: collision with root package name */
    private final MmsGlideModule f6060a = new MmsGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.android.mmt.util.MmsGlideModule");
        }
    }

    @Override // m1.c
    public final void a() {
        Objects.requireNonNull(this.f6060a);
    }

    @Override // m1.a
    public final void b(Context context, d dVar) {
        this.f6060a.b(context, dVar);
    }

    @Override // m1.a
    public final boolean c() {
        Objects.requireNonNull(this.f6060a);
        return false;
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public final Set<Class<?>> d() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    final k.b e() {
        return new a();
    }
}
