package y3;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import j.C0335a;
import java.util.Arrays;

/* renamed from: y3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0426a extends C0335a {

    /* renamed from: j, reason: collision with root package name */
    private int[] f8160j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f8161k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0426a(Drawable drawable) {
        super(drawable);
        int[] state = drawable.getState();
        this.f8160j = new int[0];
        this.f8161k = new int[0];
        c(state);
    }

    public static boolean b(StateListDrawable stateListDrawable, int[] iArr) {
        int stateCount = stateListDrawable.getStateCount();
        for (int i2 = 0; i2 < stateCount; i2++) {
            for (int i4 : stateListDrawable.getStateSet(i2)) {
                if (Arrays.binarySearch(iArr, i4) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean c(int[] iArr) {
        if (Arrays.equals(iArr, this.f8160j)) {
            return false;
        }
        this.f8160j = iArr;
        int[] iArr2 = this.f8161k;
        int[] iArr3 = new int[iArr2.length + iArr.length];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return super.setState(iArr3);
    }

    @Override // j.C0335a, android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (Arrays.equals(iArr, this.f8161k)) {
            return false;
        }
        this.f8161k = iArr;
        int[] iArr2 = this.f8160j;
        int[] iArr3 = new int[iArr.length + iArr2.length];
        System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        System.arraycopy(iArr, 0, iArr3, iArr2.length, iArr.length);
        return super.setState(iArr3);
    }
}
