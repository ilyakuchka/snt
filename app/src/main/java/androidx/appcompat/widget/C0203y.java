package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.appcompat.widget.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0203y {

    /* renamed from: k, reason: collision with root package name */
    private static final RectF f3090k = new RectF();

    /* renamed from: l, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> f3091l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Field> f3092m = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final TextView f3098h;

    /* renamed from: i, reason: collision with root package name */
    private final Context f3099i;

    /* renamed from: a, reason: collision with root package name */
    private int f3093a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3094b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f3095c = -1.0f;
    private float d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f3096e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f3097f = new int[0];
    private boolean g = false;

    /* renamed from: j, reason: collision with root package name */
    private final b f3100j = new b();

    /* renamed from: androidx.appcompat.widget.y$a */
    private static class a extends c {
        a() {
        }
    }

    /* renamed from: androidx.appcompat.widget.y$b */
    private static class b extends a {
        b() {
        }
    }

    /* renamed from: androidx.appcompat.widget.y$c */
    private static class c {
        c() {
        }
    }

    C0203y(TextView textView) {
        this.f3098h = textView;
        this.f3099i = textView.getContext();
    }

    private int[] a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        return iArr2;
    }

    private boolean h() {
        if (j() && this.f3093a == 1) {
            if (!this.g || this.f3097f.length == 0) {
                int iFloor = ((int) Math.floor((this.f3096e - this.d) / this.f3095c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i2 = 0; i2 < iFloor; i2++) {
                    iArr[i2] = Math.round((i2 * this.f3095c) + this.d);
                }
                this.f3097f = a(iArr);
            }
            this.f3094b = true;
        } else {
            this.f3094b = false;
        }
        return this.f3094b;
    }

    private boolean i() {
        boolean z4 = this.f3097f.length > 0;
        this.g = z4;
        if (z4) {
            this.f3093a = 1;
            this.d = r0[0];
            this.f3096e = r0[r1 - 1];
            this.f3095c = -1.0f;
        }
        return z4;
    }

    private boolean j() {
        return !(this.f3098h instanceof C0188i);
    }

    private void k(float f4, float f5, float f6) throws IllegalArgumentException {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f4 + "px) is less or equal to (0px)");
        }
        if (f5 <= f4) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f5 + "px) is less or equal to minimum auto-size text size (" + f4 + "px)");
        }
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f6 + "px) is less or equal to (0px)");
        }
        this.f3093a = 1;
        this.d = f4;
        this.f3096e = f5;
        this.f3095c = f6;
        this.g = false;
    }

    final int b() {
        return Math.round(this.f3096e);
    }

    final int c() {
        return Math.round(this.d);
    }

    final int d() {
        return Math.round(this.f3095c);
    }

    final int[] e() {
        return this.f3097f;
    }

    final int f() {
        return this.f3093a;
    }

    final void g(AttributeSet attributeSet, int i2) throws Resources.NotFoundException, IllegalArgumentException {
        int resourceId;
        Context context = this.f3099i;
        int[] iArr = Y1.a.f2121n;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        TextView textView = this.f3098h;
        androidx.core.view.o.i(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i2);
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            this.f3093a = typedArrayObtainStyledAttributes.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(4) ? typedArrayObtainStyledAttributes.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(2) ? typedArrayObtainStyledAttributes.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(1) ? typedArrayObtainStyledAttributes.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(3) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr2 = new int[length];
            if (length > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr2[i4] = typedArrayObtainTypedArray.getDimensionPixelSize(i4, -1);
                }
                this.f3097f = a(iArr2);
                i();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!j()) {
            this.f3093a = 0;
            return;
        }
        if (this.f3093a == 1) {
            if (!this.g) {
                DisplayMetrics displayMetrics = this.f3099i.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                k(dimension2, dimension3, dimension);
            }
            h();
        }
    }
}
