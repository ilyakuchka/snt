package com.android.mmt.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: classes.dex */
public final class r extends com.bumptech.glide.i {
    public r(com.bumptech.glide.c cVar, l1.g gVar, l1.l lVar, Context context) {
        super(cVar, gVar, lVar, context);
    }

    @Override // com.bumptech.glide.i
    public final com.bumptech.glide.h m() {
        return (C0285q) super.m();
    }

    @Override // com.bumptech.glide.i
    public final com.bumptech.glide.h n() {
        return (C0285q) l(Drawable.class);
    }

    @Override // com.bumptech.glide.i
    public final com.bumptech.glide.h r(Uri uri) {
        return (C0285q) super.r(uri);
    }

    @Override // com.bumptech.glide.i
    protected final void s(o1.e eVar) {
        if (eVar instanceof C0284p) {
            super.s(eVar);
        } else {
            super.s(new C0284p().a0(eVar));
        }
    }

    @Override // com.bumptech.glide.i
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final <ResourceType> C0285q<ResourceType> l(Class<ResourceType> cls) {
        return new C0285q<>(this.f6114i, this, cls, this.f6115j);
    }
}
