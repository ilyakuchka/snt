package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* renamed from: t.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0383a extends androidx.constraintlayout.widget.a {

    /* renamed from: n, reason: collision with root package name */
    private int f7870n;

    /* renamed from: o, reason: collision with root package name */
    private int f7871o;
    private s.b p;

    public C0383a(Context context) {
        super(context);
        setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.a
    protected final void b(AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        super.b(attributeSet);
        this.p = new s.b();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, Y1.a.f2111c0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == 6) {
                    k(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == 5) {
                    this.p.q0(typedArrayObtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f3196l = this.p;
        g();
    }

    public final boolean h() {
        return this.p.p0();
    }

    public final int i() {
        return this.f7870n;
    }

    public final void j(boolean z4) {
        this.p.q0(z4);
    }

    public final void k(int i2) {
        this.f7870n = i2;
        this.f7871o = i2;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
            int i4 = this.f7870n;
            if (i4 == 5) {
                this.f7871o = 1;
            } else if (i4 == 6) {
                this.f7871o = 0;
            }
        } else {
            int i5 = this.f7870n;
            if (i5 == 5) {
                this.f7871o = 0;
            } else if (i5 == 6) {
                this.f7871o = 1;
            }
        }
        this.p.r0(this.f7871o);
    }
}
