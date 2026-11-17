package com.bumptech.glide;

import com.bumptech.glide.j;
import q1.a;

/* loaded from: classes.dex */
public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    private q1.c<? super TranscodeType> f6127i = (a.C0135a) q1.a.a();

    public final CHILD a() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    final q1.c<? super TranscodeType> b() {
        return this.f6127i;
    }

    public final Object clone() throws CloneNotSupportedException {
        try {
            return (j) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
