package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import t.C0384b;

/* loaded from: classes.dex */
public abstract class a extends View {

    /* renamed from: i, reason: collision with root package name */
    protected int[] f3193i;

    /* renamed from: j, reason: collision with root package name */
    protected int f3194j;

    /* renamed from: k, reason: collision with root package name */
    protected Context f3195k;

    /* renamed from: l, reason: collision with root package name */
    protected s.b f3196l;

    /* renamed from: m, reason: collision with root package name */
    private String f3197m;

    public a(Context context) throws IllegalAccessException, IllegalArgumentException {
        super(context);
        this.f3193i = new int[32];
        this.f3195k = context;
        b(null);
    }

    private void a(String str) throws IllegalAccessException, IllegalArgumentException {
        Object objE;
        if (str == null || this.f3195k == null) {
            return;
        }
        String strTrim = str.trim();
        int iIntValue = 0;
        try {
            iIntValue = C0384b.class.getField(strTrim).getInt(null);
        } catch (Exception unused) {
        }
        if (iIntValue == 0) {
            iIntValue = this.f3195k.getResources().getIdentifier(strTrim, "id", this.f3195k.getPackageName());
        }
        if (iIntValue == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (objE = ((ConstraintLayout) getParent()).e(strTrim)) != null && (objE instanceof Integer)) {
            iIntValue = ((Integer) objE).intValue();
        }
        if (iIntValue != 0) {
            setTag(iIntValue, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private void c(String str) throws IllegalAccessException, IllegalArgumentException {
        if (str == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf == -1) {
                a(str.substring(i2));
                return;
            } else {
                a(str.substring(i2, iIndexOf));
                i2 = iIndexOf + 1;
            }
        }
    }

    protected void b(AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, Y1.a.f2111c0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == 9) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f3197m = string;
                    c(string);
                }
            }
        }
    }

    public final void d(int[] iArr) {
        this.f3194j = 0;
        for (int i2 : iArr) {
            setTag(i2, null);
        }
    }

    public void e() {
    }

    public void f(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            c(this.f3197m);
        }
        s.b bVar = this.f3196l;
        if (bVar == null) {
            return;
        }
        bVar.o0();
        for (int i2 = 0; i2 < this.f3194j; i2++) {
            View view = constraintLayout.f3123i.get(this.f3193i[i2]);
            if (view != null) {
                this.f3196l.n0(constraintLayout.g(view));
            }
        }
    }

    public final void g() {
        if (this.f3196l == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).f3178k0 = this.f3196l;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public final void setTag(int i2, Object obj) {
        int i4 = this.f3194j + 1;
        int[] iArr = this.f3193i;
        if (i4 > iArr.length) {
            this.f3193i = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f3193i;
        int i5 = this.f3194j;
        iArr2[i5] = i2;
        this.f3194j = i5 + 1;
    }

    public a(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        super(context, attributeSet);
        this.f3193i = new int[32];
        this.f3195k = context;
        b(attributeSet);
    }
}
