package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.core.util.SystemProperties;
import s.C0379a;
import s.d;
import s.e;
import s.f;
import s.h;
import s.k;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    SparseArray<View> f3123i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<androidx.constraintlayout.widget.a> f3124j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList<e> f3125k;

    /* renamed from: l, reason: collision with root package name */
    f f3126l;

    /* renamed from: m, reason: collision with root package name */
    private int f3127m;

    /* renamed from: n, reason: collision with root package name */
    private int f3128n;

    /* renamed from: o, reason: collision with root package name */
    private int f3129o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3130q;

    /* renamed from: r, reason: collision with root package name */
    private int f3131r;

    /* renamed from: s, reason: collision with root package name */
    private b f3132s;

    /* renamed from: t, reason: collision with root package name */
    private int f3133t;
    private HashMap<String, Integer> u;

    /* renamed from: v, reason: collision with root package name */
    private int f3134v;

    /* renamed from: w, reason: collision with root package name */
    private int f3135w;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3123i = new SparseArray<>();
        this.f3124j = new ArrayList<>(4);
        this.f3125k = new ArrayList<>(100);
        this.f3126l = new f();
        this.f3127m = 0;
        this.f3128n = 0;
        this.f3129o = Integer.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
        this.f3130q = true;
        this.f3131r = 7;
        this.f3132s = null;
        this.f3133t = -1;
        this.u = new HashMap<>();
        this.f3134v = -1;
        this.f3135w = -1;
        this.f3126l.I(this);
        this.f3123i.put(getId(), this);
        this.f3132s = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, Y1.a.f2111c0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == 3) {
                    this.f3127m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3127m);
                } else if (index == 4) {
                    this.f3128n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3128n);
                } else if (index == 1) {
                    this.f3129o = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3129o);
                } else if (index == 2) {
                    this.p = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.p);
                } else if (index == 59) {
                    this.f3131r = typedArrayObtainStyledAttributes.getInt(index, this.f3131r);
                } else if (index == 8) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        b bVar = new b();
                        this.f3132s = bVar;
                        bVar.j(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.f3132s = null;
                    }
                    this.f3133t = resourceId;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f3126l.B0(this.f3131r);
    }

    private final e f(int i2) {
        if (i2 == 0) {
            return this.f3126l;
        }
        View viewFindViewById = this.f3123i.get(i2);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i2)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f3126l;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((a) viewFindViewById.getLayoutParams()).f3178k0;
    }

    private void k() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof d) {
                ((d) childAt).b();
            }
        }
        int size = this.f3124j.size();
        if (size > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                Objects.requireNonNull(this.f3124j.get(i4));
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final a generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i4 = Integer.parseInt(strArrSplit[0]);
                        int i5 = Integer.parseInt(strArrSplit[1]);
                        int i6 = Integer.parseInt(strArrSplit[2]);
                        int i7 = (int) ((i4 / 1080.0f) * width);
                        int i8 = (int) ((i5 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(MenuBuilder.CATEGORY_MASK);
                        float f4 = i7;
                        float f5 = i8;
                        float f6 = i7 + ((int) ((i6 / 1080.0f) * width));
                        canvas.drawLine(f4, f5, f6, f5, paint);
                        float f7 = i8 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f6, f5, f6, f7, paint);
                        canvas.drawLine(f6, f7, f4, f7, paint);
                        canvas.drawLine(f4, f7, f4, f5, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f4, f5, f6, f7, paint);
                        canvas.drawLine(f4, f7, f6, f5, paint);
                    }
                }
            }
        }
    }

    public final Object e(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.u;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.u.get(str);
    }

    public final e g(View view) {
        if (view == this) {
            return this.f3126l;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).f3178k0;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public final void h() {
        this.f3132s = null;
    }

    public final void i(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.u == null) {
                this.u = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.u.put(strSubstring, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    protected final void j() {
        this.f3126l.o0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        View viewA;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            a aVar = (a) childAt.getLayoutParams();
            e eVar = aVar.f3178k0;
            if ((childAt.getVisibility() != 8 || aVar.f3156X || aVar.f3157Y || zIsInEditMode) && !aVar.f3158Z) {
                int iL = eVar.l();
                int iM = eVar.m();
                int iV = eVar.v() + iL;
                int iN = eVar.n() + iM;
                childAt.layout(iL, iM, iV, iN);
                if ((childAt instanceof d) && (viewA = ((d) childAt).a()) != null) {
                    viewA.setVisibility(0);
                    viewA.layout(iL, iM, iV, iN);
                }
            }
        }
        int size = this.f3124j.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f3124j.get(i8).e();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x07b4  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x07e8  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x07f0  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0818  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x08ab  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x08f7  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x090e  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x097b  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x09cd  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x09d5  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x09ec  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x0bcf  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0c05  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0c0e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onMeasure(int i2, int i4) throws Resources.NotFoundException, NumberFormatException {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        d.a aVar;
        int i11;
        int i12;
        boolean z4;
        boolean z5;
        int i13;
        int i14;
        boolean z6;
        boolean z7;
        int i15;
        int i16;
        boolean z8;
        boolean z9;
        boolean z10;
        int baseline;
        int i17;
        int i18;
        int childMeasureSpec;
        int childMeasureSpec2;
        boolean z11;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int size;
        int i26;
        boolean z12;
        int i27;
        int i28;
        int baseline2;
        int i29;
        int i30;
        d.a aVar2;
        int i31;
        int i32;
        boolean z13;
        boolean z14;
        int childMeasureSpec3;
        boolean z15;
        boolean z16;
        int childMeasureSpec4;
        int childMeasureSpec5;
        int baseline3;
        int i33;
        int i34;
        boolean z17;
        boolean z18;
        int baseline4;
        boolean z19;
        int i35;
        int i36;
        int i37;
        int i38;
        float f4;
        int i39;
        int i40;
        int i41;
        a aVar3;
        e eVar;
        int i42;
        int i43;
        d.a aVar4;
        int i44;
        e eVarF;
        e eVarF2;
        e eVarF3;
        e eVarF4;
        e eVar2;
        d.a aVar5;
        int i45;
        int i46;
        int i47;
        int i48;
        ConstraintLayout constraintLayout = this;
        d.a aVar6 = d.a.TOP;
        d.a aVar7 = d.a.LEFT;
        d.a aVar8 = d.a.BOTTOM;
        d.a aVar9 = d.a.RIGHT;
        System.currentTimeMillis();
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size3 = View.MeasureSpec.getSize(i4);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        constraintLayout.f3126l.j0(paddingLeft);
        constraintLayout.f3126l.k0(paddingTop);
        constraintLayout.f3126l.U(constraintLayout.f3129o);
        constraintLayout.f3126l.T(constraintLayout.p);
        constraintLayout.f3126l.C0(getLayoutDirection() == 1);
        int mode3 = View.MeasureSpec.getMode(i2);
        int size4 = View.MeasureSpec.getSize(i2);
        int mode4 = View.MeasureSpec.getMode(i4);
        int size5 = View.MeasureSpec.getSize(i4);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        getLayoutParams();
        if (mode3 != Integer.MIN_VALUE) {
            if (mode3 != 0) {
                i5 = 1073741824;
                if (mode3 != 1073741824) {
                    i6 = 1;
                } else {
                    size4 = Math.min(constraintLayout.f3129o, size4) - paddingRight;
                    i6 = 1;
                }
            } else {
                i5 = 1073741824;
                i6 = 2;
            }
            size4 = 0;
        } else {
            i5 = 1073741824;
            i6 = 2;
        }
        if (mode4 != Integer.MIN_VALUE) {
            if (mode4 == 0) {
                i7 = 2;
            } else if (mode4 != i5) {
                i7 = 1;
            } else {
                size5 = Math.min(constraintLayout.p, size5) - paddingBottom;
                i7 = 1;
            }
            size5 = 0;
        } else {
            i7 = 2;
        }
        constraintLayout.f3126l.W(0);
        constraintLayout.f3126l.V(0);
        constraintLayout.f3126l.Q(i6);
        constraintLayout.f3126l.g0(size4);
        constraintLayout.f3126l.c0(i7);
        constraintLayout.f3126l.M(size5);
        constraintLayout.f3126l.W((constraintLayout.f3127m - getPaddingLeft()) - getPaddingRight());
        constraintLayout.f3126l.V((constraintLayout.f3128n - getPaddingTop()) - getPaddingBottom());
        int iV = constraintLayout.f3126l.v();
        int iN = constraintLayout.f3126l.n();
        if (constraintLayout.f3130q) {
            constraintLayout.f3130q = false;
            int childCount = getChildCount();
            int i49 = 0;
            while (true) {
                if (i49 >= childCount) {
                    z19 = false;
                    break;
                } else {
                    if (constraintLayout.getChildAt(i49).isLayoutRequested()) {
                        z19 = true;
                        break;
                    }
                    i49++;
                }
            }
            if (z19) {
                constraintLayout.f3125k.clear();
                boolean zIsInEditMode = isInEditMode();
                int childCount2 = getChildCount();
                if (zIsInEditMode) {
                    int i50 = 0;
                    while (i50 < childCount2) {
                        View childAt = constraintLayout.getChildAt(i50);
                        try {
                            String resourceName = getResources().getResourceName(childAt.getId());
                            constraintLayout.i(resourceName, Integer.valueOf(childAt.getId()));
                            int iIndexOf = resourceName.indexOf(47);
                            i48 = paddingTop;
                            if (iIndexOf != -1) {
                                try {
                                    resourceName = resourceName.substring(iIndexOf + 1);
                                } catch (Resources.NotFoundException unused) {
                                }
                            }
                            constraintLayout.f(childAt.getId()).J(resourceName);
                        } catch (Resources.NotFoundException unused2) {
                            i48 = paddingTop;
                        }
                        i50++;
                        paddingTop = i48;
                    }
                }
                int i51 = paddingTop;
                for (int i52 = 0; i52 < childCount2; i52++) {
                    e eVarG = constraintLayout.g(constraintLayout.getChildAt(i52));
                    if (eVarG != null) {
                        eVarG.D();
                    }
                }
                if (constraintLayout.f3133t != -1) {
                    for (int i53 = 0; i53 < childCount2; i53++) {
                        View childAt2 = constraintLayout.getChildAt(i53);
                        if (childAt2.getId() == constraintLayout.f3133t && (childAt2 instanceof c)) {
                            c cVar = (c) childAt2;
                            if (cVar.f3266i == null) {
                                cVar.f3266i = new b();
                            }
                            cVar.f3266i.e(cVar);
                            constraintLayout.f3132s = cVar.f3266i;
                        }
                    }
                }
                b bVar = constraintLayout.f3132s;
                if (bVar != null) {
                    bVar.b(constraintLayout);
                }
                constraintLayout.f3126l.q0();
                int size6 = constraintLayout.f3124j.size();
                if (size6 > 0) {
                    for (int i54 = 0; i54 < size6; i54++) {
                        constraintLayout.f3124j.get(i54).f(constraintLayout);
                    }
                }
                for (int i55 = 0; i55 < childCount2; i55++) {
                    View childAt3 = constraintLayout.getChildAt(i55);
                    if (childAt3 instanceof d) {
                        ((d) childAt3).c(constraintLayout);
                    }
                }
                int i56 = 0;
                while (i56 < childCount2) {
                    View childAt4 = constraintLayout.getChildAt(i56);
                    e eVarG2 = constraintLayout.g(childAt4);
                    if (eVarG2 == null) {
                        i35 = childCount2;
                    } else {
                        a aVar10 = (a) childAt4.getLayoutParams();
                        aVar10.a();
                        if (zIsInEditMode) {
                            try {
                                i35 = childCount2;
                                try {
                                    String resourceName2 = getResources().getResourceName(childAt4.getId());
                                    constraintLayout.i(resourceName2, Integer.valueOf(childAt4.getId()));
                                    constraintLayout.f(childAt4.getId()).J(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                                } catch (Resources.NotFoundException unused3) {
                                }
                            } catch (Resources.NotFoundException unused4) {
                            }
                            eVarG2.f0(childAt4.getVisibility());
                            if (aVar10.f3158Z) {
                                eVarG2.f0(8);
                            }
                            eVarG2.I(childAt4);
                            constraintLayout.f3126l.n0(eVarG2);
                            if (aVar10.f3154V || !aVar10.f3153U) {
                                constraintLayout.f3125k.add(eVarG2);
                            }
                            if (!aVar10.f3156X) {
                                h hVar = (h) eVarG2;
                                int i57 = aVar10.f3172h0;
                                int i58 = aVar10.f3174i0;
                                float f5 = aVar10.f3176j0;
                                if (f5 != -1.0f) {
                                    hVar.p0(f5);
                                } else if (i57 != -1) {
                                    hVar.n0(i57);
                                } else if (i58 != -1) {
                                    hVar.o0(i58);
                                }
                            } else if (aVar10.d != -1 || aVar10.f3166e != -1 || aVar10.f3168f != -1 || aVar10.g != -1 || aVar10.f3183q != -1 || aVar10.p != -1 || aVar10.f3184r != -1 || aVar10.f3185s != -1 || aVar10.f3171h != -1 || aVar10.f3173i != -1 || aVar10.f3175j != -1 || aVar10.f3177k != -1 || aVar10.f3179l != -1 || aVar10.P != -1 || aVar10.f3149Q != -1 || aVar10.f3180m != -1 || ((ViewGroup.MarginLayoutParams) aVar10).width == -1 || ((ViewGroup.MarginLayoutParams) aVar10).height == -1) {
                                int i59 = aVar10.f3160a0;
                                int i60 = aVar10.f3162b0;
                                int i61 = aVar10.f3164c0;
                                int i62 = aVar10.f3165d0;
                                int i63 = size3;
                                int i64 = aVar10.f3167e0;
                                i36 = iV;
                                int i65 = aVar10.f3169f0;
                                i37 = iN;
                                float f6 = aVar10.f3170g0;
                                int i66 = aVar10.f3180m;
                                i38 = paddingLeft;
                                if (i66 != -1) {
                                    e eVarF5 = constraintLayout.f(i66);
                                    if (eVarF5 != null) {
                                        eVarG2.e(eVarF5, aVar10.f3182o, aVar10.f3181n);
                                    }
                                    aVar3 = aVar10;
                                    eVar2 = eVarG2;
                                    aVar5 = aVar8;
                                    i39 = i51;
                                    i40 = i35;
                                    i41 = i63;
                                    i45 = 1;
                                    i44 = -1;
                                    i42 = i56;
                                } else {
                                    if (i59 != -1) {
                                        e eVarF6 = constraintLayout.f(i59);
                                        if (eVarF6 != null) {
                                            i40 = i35;
                                            i42 = i56;
                                            i43 = i61;
                                            aVar4 = aVar8;
                                            f4 = f6;
                                            aVar3 = aVar10;
                                            i44 = -1;
                                            i39 = i51;
                                            eVar = eVarG2;
                                            i41 = i63;
                                            eVarG2.y(aVar7, eVarF6, aVar7, ((ViewGroup.MarginLayoutParams) aVar10).leftMargin, i64);
                                        } else {
                                            f4 = f6;
                                            i39 = i51;
                                            i40 = i35;
                                            i41 = i63;
                                            aVar3 = aVar10;
                                            eVar = eVarG2;
                                            i42 = i56;
                                            i43 = i61;
                                            aVar4 = aVar8;
                                            i44 = -1;
                                        }
                                    } else {
                                        f4 = f6;
                                        i39 = i51;
                                        i40 = i35;
                                        i41 = i63;
                                        aVar3 = aVar10;
                                        eVar = eVarG2;
                                        i42 = i56;
                                        i43 = i61;
                                        aVar4 = aVar8;
                                        i44 = -1;
                                        if (i60 != -1 && (eVarF = constraintLayout.f(i60)) != null) {
                                            eVar.y(aVar7, eVarF, aVar9, ((ViewGroup.MarginLayoutParams) aVar3).leftMargin, i64);
                                        }
                                    }
                                    if (i43 != i44) {
                                        e eVarF7 = constraintLayout.f(i43);
                                        if (eVarF7 != null) {
                                            eVar.y(aVar9, eVarF7, aVar7, ((ViewGroup.MarginLayoutParams) aVar3).rightMargin, i65);
                                        }
                                    } else if (i62 != i44 && (eVarF2 = constraintLayout.f(i62)) != null) {
                                        eVar.y(aVar9, eVarF2, aVar9, ((ViewGroup.MarginLayoutParams) aVar3).rightMargin, i65);
                                    }
                                    int i67 = aVar3.f3171h;
                                    if (i67 != i44) {
                                        e eVarF8 = constraintLayout.f(i67);
                                        if (eVarF8 != null) {
                                            eVar.y(aVar6, eVarF8, aVar6, ((ViewGroup.MarginLayoutParams) aVar3).topMargin, aVar3.u);
                                        }
                                    } else {
                                        int i68 = aVar3.f3173i;
                                        if (i68 != i44 && (eVarF3 = constraintLayout.f(i68)) != null) {
                                            eVar.y(aVar6, eVarF3, aVar4, ((ViewGroup.MarginLayoutParams) aVar3).topMargin, aVar3.u);
                                        }
                                    }
                                    int i69 = aVar3.f3175j;
                                    if (i69 != i44) {
                                        e eVarF9 = constraintLayout.f(i69);
                                        if (eVarF9 != null) {
                                            eVar.y(aVar4, eVarF9, aVar6, ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin, aVar3.f3188w);
                                        }
                                    } else {
                                        int i70 = aVar3.f3177k;
                                        if (i70 != i44 && (eVarF4 = constraintLayout.f(i70)) != null) {
                                            eVar.y(aVar4, eVarF4, aVar4, ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin, aVar3.f3188w);
                                        }
                                    }
                                    int i71 = aVar3.f3179l;
                                    if (i71 != i44) {
                                        View view = constraintLayout.f3123i.get(i71);
                                        e eVarF10 = constraintLayout.f(aVar3.f3179l);
                                        if (eVarF10 == null || view == null || !(view.getLayoutParams() instanceof a)) {
                                            eVar2 = eVar;
                                            aVar5 = aVar4;
                                            i45 = 1;
                                        } else {
                                            a aVar11 = (a) view.getLayoutParams();
                                            i45 = 1;
                                            aVar3.f3155W = true;
                                            aVar11.f3155W = true;
                                            d.a aVar12 = d.a.BASELINE;
                                            eVar2 = eVar;
                                            eVar2.g(aVar12).a(eVarF10.g(aVar12), 0, -1, 2, 0, true);
                                            eVar2.g(aVar6).i();
                                            aVar5 = aVar4;
                                            eVar2.g(aVar5).i();
                                        }
                                        if (f4 >= 0.0f && f4 != 0.5f) {
                                            eVar2.N(f4);
                                        }
                                        float f7 = aVar3.f3136A;
                                        if (f7 >= 0.0f && f7 != 0.5f) {
                                            eVar2.Z(f7);
                                        }
                                    }
                                }
                                if (zIsInEditMode && ((i47 = aVar3.P) != i44 || aVar3.f3149Q != i44)) {
                                    eVar2.Y(i47, aVar3.f3149Q);
                                }
                                if (aVar3.f3153U) {
                                    i46 = 4;
                                    eVar2.Q(i45);
                                    eVar2.g0(((ViewGroup.MarginLayoutParams) aVar3).width);
                                } else if (((ViewGroup.MarginLayoutParams) aVar3).width == i44) {
                                    i46 = 4;
                                    eVar2.Q(4);
                                    eVar2.g(aVar7).f7724e = ((ViewGroup.MarginLayoutParams) aVar3).leftMargin;
                                    eVar2.g(aVar9).f7724e = ((ViewGroup.MarginLayoutParams) aVar3).rightMargin;
                                } else {
                                    i46 = 4;
                                    eVar2.Q(3);
                                    eVar2.g0(0);
                                }
                                if (aVar3.f3154V) {
                                    eVar2.c0(i45);
                                    eVar2.M(((ViewGroup.MarginLayoutParams) aVar3).height);
                                } else if (((ViewGroup.MarginLayoutParams) aVar3).height == i44) {
                                    eVar2.c0(i46);
                                    eVar2.g(aVar6).f7724e = ((ViewGroup.MarginLayoutParams) aVar3).topMargin;
                                    eVar2.g(aVar5).f7724e = ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin;
                                } else {
                                    eVar2.c0(3);
                                    eVar2.M(0);
                                }
                                String str = aVar3.f3137B;
                                if (str != null) {
                                    eVar2.K(str);
                                }
                                eVar2.S(aVar3.f3139D);
                                eVar2.e0(aVar3.f3140E);
                                eVar2.O(aVar3.f3141F);
                                eVar2.a0(aVar3.f3142G);
                                eVar2.R(aVar3.f3143H, aVar3.f3145J, aVar3.L, aVar3.f3147N);
                                eVar2.d0(aVar3.f3144I, aVar3.f3146K, aVar3.M, aVar3.f3148O);
                            }
                        } else {
                            i35 = childCount2;
                            eVarG2.f0(childAt4.getVisibility());
                            if (aVar10.f3158Z) {
                            }
                            eVarG2.I(childAt4);
                            constraintLayout.f3126l.n0(eVarG2);
                            if (aVar10.f3154V) {
                                constraintLayout.f3125k.add(eVarG2);
                                if (!aVar10.f3156X) {
                                }
                            }
                        }
                        i56 = i42 + 1;
                        aVar8 = aVar5;
                        i51 = i39;
                        childCount2 = i40;
                        iV = i36;
                        iN = i37;
                        paddingLeft = i38;
                        size3 = i41;
                    }
                    i38 = paddingLeft;
                    i41 = size3;
                    aVar5 = aVar8;
                    i36 = iV;
                    i37 = iN;
                    i39 = i51;
                    i40 = i35;
                    i42 = i56;
                    i56 = i42 + 1;
                    aVar8 = aVar5;
                    i51 = i39;
                    childCount2 = i40;
                    iV = i36;
                    iN = i37;
                    paddingLeft = i38;
                    size3 = i41;
                }
                i9 = paddingLeft;
                i10 = size3;
                aVar = aVar8;
                i11 = iV;
                i12 = iN;
                i8 = i51;
            } else {
                i8 = paddingTop;
                i9 = paddingLeft;
                i10 = size3;
                aVar = aVar8;
                i11 = iV;
                i12 = iN;
            }
            z4 = true;
            z5 = true;
        } else {
            i8 = paddingTop;
            i9 = paddingLeft;
            i10 = size3;
            aVar = aVar8;
            i11 = iV;
            i12 = iN;
            z4 = true;
            z5 = false;
        }
        boolean z20 = (constraintLayout.f3131r & 8) == 8 ? z4 : false;
        if (z20) {
            constraintLayout.f3126l.z0();
            int i72 = i11;
            int i73 = i12;
            constraintLayout.f3126l.x0(i72, i73);
            int paddingBottom2 = getPaddingBottom() + getPaddingTop();
            int paddingRight2 = getPaddingRight() + getPaddingLeft();
            int childCount3 = getChildCount();
            int i74 = 0;
            while (i74 < childCount3) {
                View childAt5 = constraintLayout.getChildAt(i74);
                int i75 = i73;
                if (childAt5.getVisibility() == 8) {
                    i34 = i8;
                    z17 = z20;
                    z18 = z5;
                    i33 = i72;
                } else {
                    a aVar13 = (a) childAt5.getLayoutParams();
                    e eVar3 = aVar13.f3178k0;
                    i33 = i72;
                    if (aVar13.f3156X || aVar13.f3157Y) {
                        i34 = i8;
                        z17 = z20;
                        z18 = z5;
                    } else {
                        eVar3.f0(childAt5.getVisibility());
                        int i76 = ((ViewGroup.MarginLayoutParams) aVar13).width;
                        z17 = z20;
                        int i77 = ((ViewGroup.MarginLayoutParams) aVar13).height;
                        if (i76 == 0 || i77 == 0) {
                            i34 = i8;
                            z18 = z5;
                            eVar3.r().c();
                            eVar3.q().c();
                        } else {
                            i34 = i8;
                            z18 = z5;
                            boolean z21 = i76 == -2;
                            int childMeasureSpec6 = ViewGroup.getChildMeasureSpec(i2, paddingRight2, i76);
                            boolean z22 = i77 == -2;
                            childAt5.measure(childMeasureSpec6, ViewGroup.getChildMeasureSpec(i4, paddingBottom2, i77));
                            int measuredWidth = childAt5.getMeasuredWidth();
                            int measuredHeight = childAt5.getMeasuredHeight();
                            eVar3.g0(measuredWidth);
                            eVar3.M(measuredHeight);
                            if (z21) {
                                eVar3.i0(measuredWidth);
                            }
                            if (z22) {
                                eVar3.h0(measuredHeight);
                            }
                            if (aVar13.f3155W && (baseline4 = childAt5.getBaseline()) != -1) {
                                eVar3.H(baseline4);
                            }
                            if (aVar13.f3153U && aVar13.f3154V) {
                                eVar3.r().g(measuredWidth);
                                eVar3.q().g(measuredHeight);
                            }
                        }
                        i74++;
                        z20 = z17;
                        i8 = i34;
                        z5 = z18;
                        i72 = i33;
                        i73 = i75;
                    }
                }
                i74++;
                z20 = z17;
                i8 = i34;
                z5 = z18;
                i72 = i33;
                i73 = i75;
            }
            i14 = i8;
            z6 = z20;
            z7 = z5;
            i11 = i72;
            i12 = i73;
            int i78 = i4;
            constraintLayout.f3126l.D0();
            i15 = i78;
            int i79 = 0;
            while (i79 < childCount3) {
                View childAt6 = constraintLayout.getChildAt(i79);
                if (childAt6.getVisibility() == 8) {
                    i30 = childCount3;
                    aVar2 = aVar6;
                    int i80 = i78;
                    i31 = i15;
                    i32 = i80;
                } else {
                    a aVar14 = (a) childAt6.getLayoutParams();
                    e eVar4 = aVar14.f3178k0;
                    if (!aVar14.f3156X && !aVar14.f3157Y) {
                        eVar4.f0(childAt6.getVisibility());
                        int i81 = ((ViewGroup.MarginLayoutParams) aVar14).width;
                        int i82 = ((ViewGroup.MarginLayoutParams) aVar14).height;
                        if (i81 == 0 || i82 == 0) {
                            k kVarD = eVar4.g(aVar7).d();
                            k kVarD2 = eVar4.g(aVar9).d();
                            boolean z23 = (eVar4.g(aVar7).g() == null || eVar4.g(aVar9).g() == null) ? false : true;
                            k kVarD3 = eVar4.g(aVar6).d();
                            k kVarD4 = eVar4.g(aVar).d();
                            boolean z24 = (eVar4.g(aVar6).g() == null || eVar4.g(aVar).g() == null) ? false : true;
                            if (i81 != 0 || i82 != 0 || !z23 || !z24) {
                                i30 = childCount3;
                                boolean z25 = constraintLayout.f3126l.o() != 2;
                                boolean z26 = constraintLayout.f3126l.t() != 2;
                                if (!z25) {
                                    eVar4.r().c();
                                }
                                if (!z26) {
                                    eVar4.q().c();
                                }
                                if (i81 != 0) {
                                    z13 = z25;
                                    aVar2 = aVar6;
                                    i32 = i4;
                                    if (i81 == -1) {
                                        childMeasureSpec3 = ViewGroup.getChildMeasureSpec(i2, paddingRight2, -1);
                                        z14 = false;
                                        if (i82 == 0) {
                                        }
                                    } else {
                                        z14 = i81 == -2;
                                        childMeasureSpec3 = ViewGroup.getChildMeasureSpec(i2, paddingRight2, i81);
                                        if (i82 == 0) {
                                        }
                                    }
                                } else if (z25 && eVar4.C() && z23 && kVarD.d() && kVarD2.d()) {
                                    int iJ = (int) (kVarD2.j() - kVarD.j());
                                    eVar4.r().g(iJ);
                                    z13 = z25;
                                    i32 = i4;
                                    aVar2 = aVar6;
                                    childMeasureSpec3 = ViewGroup.getChildMeasureSpec(i2, paddingRight2, iJ);
                                    z14 = false;
                                    if (i82 == 0) {
                                    }
                                } else {
                                    i32 = i4;
                                    aVar2 = aVar6;
                                    childMeasureSpec3 = ViewGroup.getChildMeasureSpec(i2, paddingRight2, -2);
                                    z14 = true;
                                    z13 = false;
                                    if (i82 == 0) {
                                        z15 = z26;
                                        if (i82 == -1) {
                                            childMeasureSpec5 = ViewGroup.getChildMeasureSpec(i32, paddingBottom2, -1);
                                            childMeasureSpec4 = childMeasureSpec5;
                                            z16 = false;
                                            childAt6.measure(childMeasureSpec3, childMeasureSpec4);
                                            int measuredWidth2 = childAt6.getMeasuredWidth();
                                            int measuredHeight2 = childAt6.getMeasuredHeight();
                                            eVar4.g0(measuredWidth2);
                                            eVar4.M(measuredHeight2);
                                            if (z14) {
                                            }
                                            if (z16) {
                                            }
                                            if (z13) {
                                            }
                                            if (z15) {
                                            }
                                            if (aVar14.f3155W) {
                                            }
                                            i31 = i32;
                                        } else {
                                            z16 = i82 == -2;
                                            childMeasureSpec4 = ViewGroup.getChildMeasureSpec(i32, paddingBottom2, i82);
                                            childAt6.measure(childMeasureSpec3, childMeasureSpec4);
                                            int measuredWidth22 = childAt6.getMeasuredWidth();
                                            int measuredHeight22 = childAt6.getMeasuredHeight();
                                            eVar4.g0(measuredWidth22);
                                            eVar4.M(measuredHeight22);
                                            if (z14) {
                                            }
                                            if (z16) {
                                            }
                                            if (z13) {
                                            }
                                            if (z15) {
                                            }
                                            if (aVar14.f3155W) {
                                            }
                                            i31 = i32;
                                        }
                                    } else if (z26 && eVar4.B() && z24 && kVarD3.d() && kVarD4.d()) {
                                        int iJ2 = (int) (kVarD4.j() - kVarD3.j());
                                        z15 = z26;
                                        eVar4.q().g(iJ2);
                                        childMeasureSpec5 = ViewGroup.getChildMeasureSpec(i32, paddingBottom2, iJ2);
                                        childMeasureSpec4 = childMeasureSpec5;
                                        z16 = false;
                                        childAt6.measure(childMeasureSpec3, childMeasureSpec4);
                                        int measuredWidth222 = childAt6.getMeasuredWidth();
                                        int measuredHeight222 = childAt6.getMeasuredHeight();
                                        eVar4.g0(measuredWidth222);
                                        eVar4.M(measuredHeight222);
                                        if (z14) {
                                        }
                                        if (z16) {
                                        }
                                        if (z13) {
                                        }
                                        if (z15) {
                                        }
                                        if (aVar14.f3155W) {
                                            eVar4.H(baseline3);
                                        }
                                        i31 = i32;
                                    } else {
                                        childMeasureSpec4 = ViewGroup.getChildMeasureSpec(i32, paddingBottom2, -2);
                                        z16 = true;
                                        z15 = false;
                                        childAt6.measure(childMeasureSpec3, childMeasureSpec4);
                                        int measuredWidth2222 = childAt6.getMeasuredWidth();
                                        int measuredHeight2222 = childAt6.getMeasuredHeight();
                                        eVar4.g0(measuredWidth2222);
                                        eVar4.M(measuredHeight2222);
                                        if (z14) {
                                            eVar4.i0(measuredWidth2222);
                                        }
                                        if (z16) {
                                            eVar4.h0(measuredHeight2222);
                                        }
                                        if (z13) {
                                            eVar4.r().f();
                                        } else {
                                            eVar4.r().g(measuredWidth2222);
                                        }
                                        if (z15) {
                                            eVar4.q().f();
                                        } else {
                                            eVar4.q().g(measuredHeight2222);
                                        }
                                        if (aVar14.f3155W && (baseline3 = childAt6.getBaseline()) != -1) {
                                            eVar4.H(baseline3);
                                        }
                                        i31 = i32;
                                    }
                                }
                            }
                        }
                    }
                }
                i79++;
                aVar6 = aVar2;
                childCount3 = i30;
                int i83 = i31;
                i78 = i32;
                i15 = i83;
            }
            i13 = i2;
        } else {
            i13 = i2;
            i14 = i8;
            z6 = z20;
            z7 = z5;
            i15 = i4;
            int paddingBottom3 = getPaddingBottom() + getPaddingTop();
            int paddingRight3 = getPaddingRight() + getPaddingLeft();
            int i84 = 0;
            for (int childCount4 = getChildCount(); i84 < childCount4; childCount4 = i16) {
                View childAt7 = constraintLayout.getChildAt(i84);
                if (childAt7.getVisibility() == 8) {
                    i16 = childCount4;
                } else {
                    a aVar15 = (a) childAt7.getLayoutParams();
                    e eVar5 = aVar15.f3178k0;
                    if (!aVar15.f3156X && !aVar15.f3157Y) {
                        eVar5.f0(childAt7.getVisibility());
                        int measuredWidth3 = ((ViewGroup.MarginLayoutParams) aVar15).width;
                        int measuredHeight3 = ((ViewGroup.MarginLayoutParams) aVar15).height;
                        boolean z27 = aVar15.f3153U;
                        if (z27 || (z11 = aVar15.f3154V)) {
                            i16 = childCount4;
                        } else {
                            if (z27) {
                                i16 = childCount4;
                                i19 = 1;
                            } else {
                                i16 = childCount4;
                                i19 = 1;
                                if (aVar15.f3143H != 1) {
                                }
                            }
                            if (measuredWidth3 != -1 && (z11 || (aVar15.f3144I != i19 && measuredHeight3 != -1))) {
                                z8 = false;
                            }
                            if (z8) {
                                z9 = false;
                                z10 = false;
                            } else {
                                if (measuredWidth3 == 0) {
                                    i17 = -2;
                                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i13, paddingRight3, -2);
                                    i18 = -1;
                                    z10 = true;
                                } else {
                                    i17 = -2;
                                    i18 = -1;
                                    if (measuredWidth3 == -1) {
                                        childMeasureSpec = ViewGroup.getChildMeasureSpec(i13, paddingRight3, -1);
                                        z10 = false;
                                    } else {
                                        z10 = measuredWidth3 == -2;
                                        childMeasureSpec = ViewGroup.getChildMeasureSpec(i13, paddingRight3, measuredWidth3);
                                    }
                                }
                                if (measuredHeight3 == 0) {
                                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i15, paddingBottom3, i17);
                                    z9 = true;
                                } else if (measuredHeight3 == i18) {
                                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i15, paddingBottom3, i18);
                                    z9 = false;
                                } else {
                                    z9 = measuredHeight3 == i17;
                                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i15, paddingBottom3, measuredHeight3);
                                }
                                childAt7.measure(childMeasureSpec, childMeasureSpec2);
                                measuredWidth3 = childAt7.getMeasuredWidth();
                                measuredHeight3 = childAt7.getMeasuredHeight();
                            }
                            eVar5.g0(measuredWidth3);
                            eVar5.M(measuredHeight3);
                            if (z10) {
                                eVar5.i0(measuredWidth3);
                            }
                            if (z9) {
                                eVar5.h0(measuredHeight3);
                            }
                            if (!aVar15.f3155W && (baseline = childAt7.getBaseline()) != -1) {
                                eVar5.H(baseline);
                            }
                        }
                        z8 = true;
                        if (z8) {
                        }
                        eVar5.g0(measuredWidth3);
                        eVar5.M(measuredHeight3);
                        if (z10) {
                        }
                        if (z9) {
                        }
                        if (!aVar15.f3155W) {
                        }
                    }
                }
                i84++;
            }
        }
        k();
        if (getChildCount() > 0 && z7) {
            C0379a.a(constraintLayout.f3126l);
        }
        f fVar = constraintLayout.f3126l;
        if (fVar.f7795r0) {
            if (fVar.f7796s0) {
                i22 = mode;
                if (i22 == Integer.MIN_VALUE) {
                    int i85 = fVar.f7798u0;
                    i21 = size2;
                    if (i85 < i21) {
                        fVar.g0(i85);
                    }
                    constraintLayout.f3126l.Q(1);
                } else {
                    i21 = size2;
                }
            } else {
                i21 = size2;
                i22 = mode;
            }
            f fVar2 = constraintLayout.f3126l;
            if (fVar2.f7797t0) {
                i20 = mode2;
                if (i20 == Integer.MIN_VALUE) {
                    int i86 = fVar2.f7799v0;
                    i23 = i10;
                    if (i86 < i23) {
                        fVar2.M(i86);
                    }
                    constraintLayout.f3126l.c0(1);
                }
                if ((constraintLayout.f3131r & 32) != 32) {
                    int iV2 = constraintLayout.f3126l.v();
                    int iN2 = constraintLayout.f3126l.n();
                    if (constraintLayout.f3134v != iV2) {
                        i29 = 1073741824;
                        if (i22 == 1073741824) {
                            C0379a.f(constraintLayout.f3126l.q0, 0, iV2);
                        }
                    } else {
                        i29 = 1073741824;
                    }
                    if (constraintLayout.f3135w != iN2 && i20 == i29) {
                        C0379a.f(constraintLayout.f3126l.q0, 1, iN2);
                    }
                    f fVar3 = constraintLayout.f3126l;
                    if (!fVar3.f7796s0 || fVar3.f7798u0 <= i21) {
                        i25 = 0;
                    } else {
                        i25 = 0;
                        C0379a.f(fVar3.q0, 0, i21);
                    }
                    f fVar4 = constraintLayout.f3126l;
                    if (!fVar4.f7797t0 || fVar4.f7799v0 <= i23) {
                        i24 = 1;
                    } else {
                        i24 = 1;
                        C0379a.f(fVar4.q0, 1, i23);
                    }
                } else {
                    i24 = 1;
                    i25 = 0;
                }
                if (getChildCount() > 0) {
                    j();
                }
                size = constraintLayout.f3125k.size();
                int paddingBottom4 = getPaddingBottom() + i14;
                int paddingRight4 = getPaddingRight() + i9;
                if (size <= 0) {
                    int i87 = constraintLayout.f3126l.o() == 2 ? i24 : i25;
                    int i88 = constraintLayout.f3126l.t() == 2 ? i24 : i25;
                    int iMax = Math.max(constraintLayout.f3126l.v(), constraintLayout.f3127m);
                    int iMax2 = Math.max(constraintLayout.f3126l.n(), constraintLayout.f3128n);
                    int iCombineMeasuredStates = i25;
                    int i89 = iCombineMeasuredStates;
                    int iMax3 = iMax;
                    int i90 = i89;
                    while (i89 < size) {
                        e eVar6 = constraintLayout.f3125k.get(i89);
                        int i91 = size;
                        View view2 = (View) eVar6.j();
                        if (view2 == null) {
                            i27 = i90;
                        } else {
                            a aVar16 = (a) view2.getLayoutParams();
                            i27 = i90;
                            if (!aVar16.f3157Y && !aVar16.f3156X) {
                                i28 = i89;
                                if (view2.getVisibility() != 8 && (!z6 || !eVar6.r().d() || !eVar6.q().d())) {
                                    int i92 = ((ViewGroup.MarginLayoutParams) aVar16).width;
                                    int childMeasureSpec7 = (i92 == -2 && aVar16.f3153U) ? ViewGroup.getChildMeasureSpec(i13, paddingRight4, i92) : View.MeasureSpec.makeMeasureSpec(eVar6.v(), 1073741824);
                                    int i93 = ((ViewGroup.MarginLayoutParams) aVar16).height;
                                    view2.measure(childMeasureSpec7, (i93 == -2 && aVar16.f3154V) ? ViewGroup.getChildMeasureSpec(i15, paddingBottom4, i93) : View.MeasureSpec.makeMeasureSpec(eVar6.n(), 1073741824));
                                    int measuredWidth4 = view2.getMeasuredWidth();
                                    int measuredHeight4 = view2.getMeasuredHeight();
                                    if (measuredWidth4 != eVar6.v()) {
                                        eVar6.g0(measuredWidth4);
                                        if (z6) {
                                            eVar6.r().g(measuredWidth4);
                                        }
                                        if (i87 != 0 && eVar6.s() > iMax3) {
                                            iMax3 = Math.max(iMax3, eVar6.g(aVar9).c() + eVar6.s());
                                        }
                                        i27 = 1;
                                    }
                                    if (measuredHeight4 != eVar6.n()) {
                                        eVar6.M(measuredHeight4);
                                        if (z6) {
                                            eVar6.q().g(measuredHeight4);
                                        }
                                        if (i88 != 0 && eVar6.i() > iMax2) {
                                            iMax2 = Math.max(iMax2, eVar6.g(aVar).c() + eVar6.i());
                                        }
                                        i27 = 1;
                                    }
                                    if (aVar16.f3155W && (baseline2 = view2.getBaseline()) != -1 && baseline2 != eVar6.h()) {
                                        eVar6.H(baseline2);
                                        i27 = 1;
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
                                }
                                i90 = i27;
                                i89 = i28 + 1;
                                constraintLayout = this;
                                i13 = i2;
                                size = i91;
                            }
                            i90 = i27;
                            i89 = i28 + 1;
                            constraintLayout = this;
                            i13 = i2;
                            size = i91;
                        }
                        i28 = i89;
                        i90 = i27;
                        i89 = i28 + 1;
                        constraintLayout = this;
                        i13 = i2;
                        size = i91;
                    }
                    int i94 = size;
                    constraintLayout = this;
                    if (i90 != 0) {
                        constraintLayout.f3126l.g0(i11);
                        constraintLayout.f3126l.M(i12);
                        if (z6) {
                            constraintLayout.f3126l.D0();
                        }
                        j();
                        if (constraintLayout.f3126l.v() < iMax3) {
                            constraintLayout.f3126l.g0(iMax3);
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (constraintLayout.f3126l.n() < iMax2) {
                            constraintLayout.f3126l.M(iMax2);
                            z12 = true;
                        }
                        if (z12) {
                            j();
                        }
                    }
                    for (int i95 = 0; i95 < i94; i95++) {
                        e eVar7 = constraintLayout.f3125k.get(i95);
                        View view3 = (View) eVar7.j();
                        if (view3 != null && (view3.getMeasuredWidth() != eVar7.v() || view3.getMeasuredHeight() != eVar7.n())) {
                            if (eVar7.u() != 8) {
                                view3.measure(View.MeasureSpec.makeMeasureSpec(eVar7.v(), 1073741824), View.MeasureSpec.makeMeasureSpec(eVar7.n(), 1073741824));
                            }
                        }
                    }
                    i26 = iCombineMeasuredStates;
                } else {
                    i26 = 0;
                }
                int iV3 = constraintLayout.f3126l.v() + paddingRight4;
                int iN3 = constraintLayout.f3126l.n() + paddingBottom4;
                int iResolveSizeAndState = View.resolveSizeAndState(iV3, i2, i26);
                int iResolveSizeAndState2 = View.resolveSizeAndState(iN3, i15, i26 << 16) & 16777215;
                int iMin = Math.min(constraintLayout.f3129o, iResolveSizeAndState & 16777215);
                int iMin2 = Math.min(constraintLayout.p, iResolveSizeAndState2);
                if (constraintLayout.f3126l.v0()) {
                    iMin |= 16777216;
                }
                if (constraintLayout.f3126l.u0()) {
                    iMin2 |= 16777216;
                }
                constraintLayout.setMeasuredDimension(iMin, iMin2);
                constraintLayout.f3134v = iMin;
                constraintLayout.f3135w = iMin2;
            }
            i20 = mode2;
        } else {
            i20 = mode2;
            i21 = size2;
            i22 = mode;
        }
        i23 = i10;
        if ((constraintLayout.f3131r & 32) != 32) {
        }
        if (getChildCount() > 0) {
        }
        size = constraintLayout.f3125k.size();
        int paddingBottom42 = getPaddingBottom() + i14;
        int paddingRight42 = getPaddingRight() + i9;
        if (size <= 0) {
        }
        int iV32 = constraintLayout.f3126l.v() + paddingRight42;
        int iN32 = constraintLayout.f3126l.n() + paddingBottom42;
        int iResolveSizeAndState3 = View.resolveSizeAndState(iV32, i2, i26);
        int iResolveSizeAndState22 = View.resolveSizeAndState(iN32, i15, i26 << 16) & 16777215;
        int iMin3 = Math.min(constraintLayout.f3129o, iResolveSizeAndState3 & 16777215);
        int iMin22 = Math.min(constraintLayout.p, iResolveSizeAndState22);
        if (constraintLayout.f3126l.v0()) {
        }
        if (constraintLayout.f3126l.u0()) {
        }
        constraintLayout.setMeasuredDimension(iMin3, iMin22);
        constraintLayout.f3134v = iMin3;
        constraintLayout.f3135w = iMin22;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        e eVarG = g(view);
        if ((view instanceof Guideline) && !(eVarG instanceof h)) {
            a aVar = (a) view.getLayoutParams();
            h hVar = new h();
            aVar.f3178k0 = hVar;
            aVar.f3156X = true;
            hVar.q0(aVar.f3150R);
        }
        if (view instanceof androidx.constraintlayout.widget.a) {
            androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) view;
            aVar2.g();
            ((a) view.getLayoutParams()).f3157Y = true;
            if (!this.f3124j.contains(aVar2)) {
                this.f3124j.add(aVar2);
            }
        }
        this.f3123i.put(view.getId(), view);
        this.f3130q = true;
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f3123i.remove(view.getId());
        e eVarG = g(view);
        this.f3126l.p0(eVarG);
        this.f3124j.remove(view);
        this.f3125k.remove(eVarG);
        this.f3130q = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        this.f3130q = true;
        this.f3134v = -1;
        this.f3135w = -1;
    }

    @Override // android.view.View
    public final void setId(int i2) {
        this.f3123i.remove(getId());
        super.setId(i2);
        this.f3123i.put(getId(), this);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: A, reason: collision with root package name */
        public float f3136A;

        /* renamed from: B, reason: collision with root package name */
        public String f3137B;

        /* renamed from: C, reason: collision with root package name */
        int f3138C;

        /* renamed from: D, reason: collision with root package name */
        public float f3139D;

        /* renamed from: E, reason: collision with root package name */
        public float f3140E;

        /* renamed from: F, reason: collision with root package name */
        public int f3141F;

        /* renamed from: G, reason: collision with root package name */
        public int f3142G;

        /* renamed from: H, reason: collision with root package name */
        public int f3143H;

        /* renamed from: I, reason: collision with root package name */
        public int f3144I;

        /* renamed from: J, reason: collision with root package name */
        public int f3145J;

        /* renamed from: K, reason: collision with root package name */
        public int f3146K;
        public int L;
        public int M;

        /* renamed from: N, reason: collision with root package name */
        public float f3147N;

        /* renamed from: O, reason: collision with root package name */
        public float f3148O;
        public int P;

        /* renamed from: Q, reason: collision with root package name */
        public int f3149Q;

        /* renamed from: R, reason: collision with root package name */
        public int f3150R;

        /* renamed from: S, reason: collision with root package name */
        public boolean f3151S;

        /* renamed from: T, reason: collision with root package name */
        public boolean f3152T;

        /* renamed from: U, reason: collision with root package name */
        boolean f3153U;

        /* renamed from: V, reason: collision with root package name */
        boolean f3154V;

        /* renamed from: W, reason: collision with root package name */
        boolean f3155W;

        /* renamed from: X, reason: collision with root package name */
        boolean f3156X;

        /* renamed from: Y, reason: collision with root package name */
        boolean f3157Y;

        /* renamed from: Z, reason: collision with root package name */
        boolean f3158Z;

        /* renamed from: a, reason: collision with root package name */
        public int f3159a;

        /* renamed from: a0, reason: collision with root package name */
        int f3160a0;

        /* renamed from: b, reason: collision with root package name */
        public int f3161b;

        /* renamed from: b0, reason: collision with root package name */
        int f3162b0;

        /* renamed from: c, reason: collision with root package name */
        public float f3163c;

        /* renamed from: c0, reason: collision with root package name */
        int f3164c0;
        public int d;

        /* renamed from: d0, reason: collision with root package name */
        int f3165d0;

        /* renamed from: e, reason: collision with root package name */
        public int f3166e;

        /* renamed from: e0, reason: collision with root package name */
        int f3167e0;

        /* renamed from: f, reason: collision with root package name */
        public int f3168f;

        /* renamed from: f0, reason: collision with root package name */
        int f3169f0;
        public int g;

        /* renamed from: g0, reason: collision with root package name */
        float f3170g0;

        /* renamed from: h, reason: collision with root package name */
        public int f3171h;

        /* renamed from: h0, reason: collision with root package name */
        int f3172h0;

        /* renamed from: i, reason: collision with root package name */
        public int f3173i;

        /* renamed from: i0, reason: collision with root package name */
        int f3174i0;

        /* renamed from: j, reason: collision with root package name */
        public int f3175j;

        /* renamed from: j0, reason: collision with root package name */
        float f3176j0;

        /* renamed from: k, reason: collision with root package name */
        public int f3177k;

        /* renamed from: k0, reason: collision with root package name */
        e f3178k0;

        /* renamed from: l, reason: collision with root package name */
        public int f3179l;

        /* renamed from: m, reason: collision with root package name */
        public int f3180m;

        /* renamed from: n, reason: collision with root package name */
        public int f3181n;

        /* renamed from: o, reason: collision with root package name */
        public float f3182o;
        public int p;

        /* renamed from: q, reason: collision with root package name */
        public int f3183q;

        /* renamed from: r, reason: collision with root package name */
        public int f3184r;

        /* renamed from: s, reason: collision with root package name */
        public int f3185s;

        /* renamed from: t, reason: collision with root package name */
        public int f3186t;
        public int u;

        /* renamed from: v, reason: collision with root package name */
        public int f3187v;

        /* renamed from: w, reason: collision with root package name */
        public int f3188w;

        /* renamed from: x, reason: collision with root package name */
        public int f3189x;

        /* renamed from: y, reason: collision with root package name */
        public int f3190y;

        /* renamed from: z, reason: collision with root package name */
        public float f3191z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        private static class C0060a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f3192a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f3192a = sparseIntArray;
                sparseIntArray.append(34, 8);
                sparseIntArray.append(35, 9);
                sparseIntArray.append(37, 10);
                sparseIntArray.append(38, 11);
                sparseIntArray.append(43, 12);
                sparseIntArray.append(42, 13);
                sparseIntArray.append(16, 14);
                sparseIntArray.append(15, 15);
                sparseIntArray.append(13, 16);
                sparseIntArray.append(17, 2);
                sparseIntArray.append(19, 3);
                sparseIntArray.append(18, 4);
                sparseIntArray.append(51, 49);
                sparseIntArray.append(52, 50);
                sparseIntArray.append(23, 5);
                sparseIntArray.append(24, 6);
                sparseIntArray.append(25, 7);
                sparseIntArray.append(0, 1);
                sparseIntArray.append(39, 17);
                sparseIntArray.append(40, 18);
                sparseIntArray.append(22, 19);
                sparseIntArray.append(21, 20);
                sparseIntArray.append(55, 21);
                sparseIntArray.append(58, 22);
                sparseIntArray.append(56, 23);
                sparseIntArray.append(53, 24);
                sparseIntArray.append(57, 25);
                sparseIntArray.append(54, 26);
                sparseIntArray.append(30, 29);
                sparseIntArray.append(44, 30);
                sparseIntArray.append(20, 44);
                sparseIntArray.append(32, 45);
                sparseIntArray.append(46, 46);
                sparseIntArray.append(31, 47);
                sparseIntArray.append(45, 48);
                sparseIntArray.append(11, 27);
                sparseIntArray.append(10, 28);
                sparseIntArray.append(47, 31);
                sparseIntArray.append(26, 32);
                sparseIntArray.append(49, 33);
                sparseIntArray.append(48, 34);
                sparseIntArray.append(50, 35);
                sparseIntArray.append(28, 36);
                sparseIntArray.append(27, 37);
                sparseIntArray.append(29, 38);
                sparseIntArray.append(33, 39);
                sparseIntArray.append(41, 40);
                sparseIntArray.append(36, 41);
                sparseIntArray.append(14, 42);
                sparseIntArray.append(12, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) throws NumberFormatException {
            int i2;
            super(context, attributeSet);
            this.f3159a = -1;
            this.f3161b = -1;
            this.f3163c = -1.0f;
            this.d = -1;
            this.f3166e = -1;
            this.f3168f = -1;
            this.g = -1;
            this.f3171h = -1;
            this.f3173i = -1;
            this.f3175j = -1;
            this.f3177k = -1;
            this.f3179l = -1;
            this.f3180m = -1;
            this.f3181n = 0;
            this.f3182o = 0.0f;
            this.p = -1;
            this.f3183q = -1;
            this.f3184r = -1;
            this.f3185s = -1;
            this.f3186t = -1;
            this.u = -1;
            this.f3187v = -1;
            this.f3188w = -1;
            this.f3189x = -1;
            this.f3190y = -1;
            this.f3191z = 0.5f;
            this.f3136A = 0.5f;
            this.f3137B = null;
            this.f3138C = 1;
            this.f3139D = -1.0f;
            this.f3140E = -1.0f;
            this.f3141F = 0;
            this.f3142G = 0;
            this.f3143H = 0;
            this.f3144I = 0;
            this.f3145J = 0;
            this.f3146K = 0;
            this.L = 0;
            this.M = 0;
            this.f3147N = 1.0f;
            this.f3148O = 1.0f;
            this.P = -1;
            this.f3149Q = -1;
            this.f3150R = -1;
            this.f3151S = false;
            this.f3152T = false;
            this.f3153U = true;
            this.f3154V = true;
            this.f3155W = false;
            this.f3156X = false;
            this.f3157Y = false;
            this.f3158Z = false;
            this.f3160a0 = -1;
            this.f3162b0 = -1;
            this.f3164c0 = -1;
            this.f3165d0 = -1;
            this.f3167e0 = -1;
            this.f3169f0 = -1;
            this.f3170g0 = 0.5f;
            this.f3178k0 = new e();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2111c0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i4);
                int i5 = C0060a.f3192a.get(index);
                switch (i5) {
                    case 1:
                        this.f3150R = typedArrayObtainStyledAttributes.getInt(index, this.f3150R);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f3180m);
                        this.f3180m = resourceId;
                        if (resourceId == -1) {
                            this.f3180m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f3181n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3181n);
                        break;
                    case 4:
                        float f4 = typedArrayObtainStyledAttributes.getFloat(index, this.f3182o) % 360.0f;
                        this.f3182o = f4;
                        if (f4 < 0.0f) {
                            this.f3182o = (360.0f - f4) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f3159a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3159a);
                        break;
                    case 6:
                        this.f3161b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3161b);
                        break;
                    case 7:
                        this.f3163c = typedArrayObtainStyledAttributes.getFloat(index, this.f3163c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.d);
                        this.d = resourceId2;
                        if (resourceId2 == -1) {
                            this.d = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3166e);
                        this.f3166e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f3166e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3168f);
                        this.f3168f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f3168f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.g);
                        this.g = resourceId5;
                        if (resourceId5 == -1) {
                            this.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3171h);
                        this.f3171h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f3171h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3173i);
                        this.f3173i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f3173i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3175j);
                        this.f3175j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f3175j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3177k);
                        this.f3177k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f3177k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case MenuBuilder.CATEGORY_SHIFT /* 16 */:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3179l);
                        this.f3179l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f3179l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3183q);
                        this.f3183q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f3183q = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3184r);
                        this.f3184r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f3184r = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3185s);
                        this.f3185s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f3185s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f3186t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3186t);
                        break;
                    case 22:
                        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.f3187v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3187v);
                        break;
                    case 24:
                        this.f3188w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3188w);
                        break;
                    case 25:
                        this.f3189x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3189x);
                        break;
                    case 26:
                        this.f3190y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3190y);
                        break;
                    case 27:
                        this.f3151S = typedArrayObtainStyledAttributes.getBoolean(index, this.f3151S);
                        break;
                    case 28:
                        this.f3152T = typedArrayObtainStyledAttributes.getBoolean(index, this.f3152T);
                        break;
                    case 29:
                        this.f3191z = typedArrayObtainStyledAttributes.getFloat(index, this.f3191z);
                        break;
                    case 30:
                        this.f3136A = typedArrayObtainStyledAttributes.getFloat(index, this.f3136A);
                        break;
                    case SystemProperties.PROP_NAME_MAX /* 31 */:
                        int i6 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f3143H = i6;
                        if (i6 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i7 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f3144I = i7;
                        if (i7 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.f3145J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3145J);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f3145J) == -2) {
                                this.f3145J = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f3147N = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f3147N));
                        break;
                    case 36:
                        try {
                            this.f3146K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3146K);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f3146K) == -2) {
                                this.f3146K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.f3148O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f3148O));
                        break;
                    default:
                        switch (i5) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.f3137B = string;
                                this.f3138C = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.f3137B.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String strSubstring = this.f3137B.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.f3138C = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.f3138C = 1;
                                        }
                                        i2 = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.f3137B.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.f3137B.substring(i2);
                                        if (strSubstring2.length() > 0) {
                                            Float.parseFloat(strSubstring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String strSubstring3 = this.f3137B.substring(i2, iIndexOf2);
                                        String strSubstring4 = this.f3137B.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                                            break;
                                        } else {
                                            try {
                                                float f5 = Float.parseFloat(strSubstring3);
                                                float f6 = Float.parseFloat(strSubstring4);
                                                if (f5 <= 0.0f || f6 <= 0.0f) {
                                                    break;
                                                } else if (this.f3138C == 1) {
                                                    Math.abs(f6 / f5);
                                                    break;
                                                } else {
                                                    Math.abs(f5 / f6);
                                                    break;
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    break;
                                }
                            case 45:
                                this.f3139D = typedArrayObtainStyledAttributes.getFloat(index, this.f3139D);
                                break;
                            case 46:
                                this.f3140E = typedArrayObtainStyledAttributes.getFloat(index, this.f3140E);
                                break;
                            case 47:
                                this.f3141F = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f3142G = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.P = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.P);
                                break;
                            case 50:
                                this.f3149Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3149Q);
                                break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public final void a() {
            this.f3156X = false;
            this.f3153U = true;
            this.f3154V = true;
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == -2 && this.f3151S) {
                this.f3153U = false;
                this.f3143H = 1;
            }
            int i4 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i4 == -2 && this.f3152T) {
                this.f3154V = false;
                this.f3144I = 1;
            }
            if (i2 == 0 || i2 == -1) {
                this.f3153U = false;
                if (i2 == 0 && this.f3143H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f3151S = true;
                }
            }
            if (i4 == 0 || i4 == -1) {
                this.f3154V = false;
                if (i4 == 0 && this.f3144I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f3152T = true;
                }
            }
            if (this.f3163c == -1.0f && this.f3159a == -1 && this.f3161b == -1) {
                return;
            }
            this.f3156X = true;
            this.f3153U = true;
            this.f3154V = true;
            if (!(this.f3178k0 instanceof h)) {
                this.f3178k0 = new h();
            }
            ((h) this.f3178k0).q0(this.f3150R);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0080  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void resolveLayoutDirection(int i2) {
            int i4;
            int i5;
            int i6;
            int i7;
            float f4;
            int i8 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i2);
            this.f3164c0 = -1;
            this.f3165d0 = -1;
            this.f3160a0 = -1;
            this.f3162b0 = -1;
            this.f3167e0 = this.f3186t;
            this.f3169f0 = this.f3187v;
            this.f3170g0 = this.f3191z;
            this.f3172h0 = this.f3159a;
            this.f3174i0 = this.f3161b;
            this.f3176j0 = this.f3163c;
            boolean z4 = false;
            if (1 == getLayoutDirection()) {
                int i10 = this.p;
                if (i10 != -1) {
                    this.f3164c0 = i10;
                } else {
                    int i11 = this.f3183q;
                    if (i11 != -1) {
                        this.f3165d0 = i11;
                    }
                    i4 = this.f3184r;
                    if (i4 != -1) {
                        this.f3162b0 = i4;
                        z4 = true;
                    }
                    i5 = this.f3185s;
                    if (i5 != -1) {
                        this.f3160a0 = i5;
                        z4 = true;
                    }
                    i6 = this.f3189x;
                    if (i6 != -1) {
                        this.f3169f0 = i6;
                    }
                    i7 = this.f3190y;
                    if (i7 != -1) {
                        this.f3167e0 = i7;
                    }
                    if (z4) {
                        this.f3170g0 = 1.0f - this.f3191z;
                    }
                    if (this.f3156X && this.f3150R == 1) {
                        f4 = this.f3163c;
                        if (f4 == -1.0f) {
                            this.f3176j0 = 1.0f - f4;
                            this.f3172h0 = -1;
                            this.f3174i0 = -1;
                        } else {
                            int i12 = this.f3159a;
                            if (i12 != -1) {
                                this.f3174i0 = i12;
                                this.f3172h0 = -1;
                                this.f3176j0 = -1.0f;
                            } else {
                                int i13 = this.f3161b;
                                if (i13 != -1) {
                                    this.f3172h0 = i13;
                                    this.f3174i0 = -1;
                                    this.f3176j0 = -1.0f;
                                }
                            }
                        }
                    }
                }
                z4 = true;
                i4 = this.f3184r;
                if (i4 != -1) {
                }
                i5 = this.f3185s;
                if (i5 != -1) {
                }
                i6 = this.f3189x;
                if (i6 != -1) {
                }
                i7 = this.f3190y;
                if (i7 != -1) {
                }
                if (z4) {
                }
                if (this.f3156X) {
                    f4 = this.f3163c;
                    if (f4 == -1.0f) {
                    }
                }
            } else {
                int i14 = this.p;
                if (i14 != -1) {
                    this.f3162b0 = i14;
                }
                int i15 = this.f3183q;
                if (i15 != -1) {
                    this.f3160a0 = i15;
                }
                int i16 = this.f3184r;
                if (i16 != -1) {
                    this.f3164c0 = i16;
                }
                int i17 = this.f3185s;
                if (i17 != -1) {
                    this.f3165d0 = i17;
                }
                int i18 = this.f3189x;
                if (i18 != -1) {
                    this.f3167e0 = i18;
                }
                int i19 = this.f3190y;
                if (i19 != -1) {
                    this.f3169f0 = i19;
                }
            }
            if (this.f3184r == -1 && this.f3185s == -1 && this.f3183q == -1 && this.p == -1) {
                int i20 = this.f3168f;
                if (i20 != -1) {
                    this.f3164c0 = i20;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i9 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                    }
                } else {
                    int i21 = this.g;
                    if (i21 != -1) {
                        this.f3165d0 = i21;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i9 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                        }
                    }
                }
                int i22 = this.d;
                if (i22 != -1) {
                    this.f3160a0 = i22;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                    return;
                }
                int i23 = this.f3166e;
                if (i23 != -1) {
                    this.f3162b0 = i23;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                }
            }
        }

        public a() {
            super(-2, -2);
            this.f3159a = -1;
            this.f3161b = -1;
            this.f3163c = -1.0f;
            this.d = -1;
            this.f3166e = -1;
            this.f3168f = -1;
            this.g = -1;
            this.f3171h = -1;
            this.f3173i = -1;
            this.f3175j = -1;
            this.f3177k = -1;
            this.f3179l = -1;
            this.f3180m = -1;
            this.f3181n = 0;
            this.f3182o = 0.0f;
            this.p = -1;
            this.f3183q = -1;
            this.f3184r = -1;
            this.f3185s = -1;
            this.f3186t = -1;
            this.u = -1;
            this.f3187v = -1;
            this.f3188w = -1;
            this.f3189x = -1;
            this.f3190y = -1;
            this.f3191z = 0.5f;
            this.f3136A = 0.5f;
            this.f3137B = null;
            this.f3138C = 1;
            this.f3139D = -1.0f;
            this.f3140E = -1.0f;
            this.f3141F = 0;
            this.f3142G = 0;
            this.f3143H = 0;
            this.f3144I = 0;
            this.f3145J = 0;
            this.f3146K = 0;
            this.L = 0;
            this.M = 0;
            this.f3147N = 1.0f;
            this.f3148O = 1.0f;
            this.P = -1;
            this.f3149Q = -1;
            this.f3150R = -1;
            this.f3151S = false;
            this.f3152T = false;
            this.f3153U = true;
            this.f3154V = true;
            this.f3155W = false;
            this.f3156X = false;
            this.f3157Y = false;
            this.f3158Z = false;
            this.f3160a0 = -1;
            this.f3162b0 = -1;
            this.f3164c0 = -1;
            this.f3165d0 = -1;
            this.f3167e0 = -1;
            this.f3169f0 = -1;
            this.f3170g0 = 0.5f;
            this.f3178k0 = new e();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3159a = -1;
            this.f3161b = -1;
            this.f3163c = -1.0f;
            this.d = -1;
            this.f3166e = -1;
            this.f3168f = -1;
            this.g = -1;
            this.f3171h = -1;
            this.f3173i = -1;
            this.f3175j = -1;
            this.f3177k = -1;
            this.f3179l = -1;
            this.f3180m = -1;
            this.f3181n = 0;
            this.f3182o = 0.0f;
            this.p = -1;
            this.f3183q = -1;
            this.f3184r = -1;
            this.f3185s = -1;
            this.f3186t = -1;
            this.u = -1;
            this.f3187v = -1;
            this.f3188w = -1;
            this.f3189x = -1;
            this.f3190y = -1;
            this.f3191z = 0.5f;
            this.f3136A = 0.5f;
            this.f3137B = null;
            this.f3138C = 1;
            this.f3139D = -1.0f;
            this.f3140E = -1.0f;
            this.f3141F = 0;
            this.f3142G = 0;
            this.f3143H = 0;
            this.f3144I = 0;
            this.f3145J = 0;
            this.f3146K = 0;
            this.L = 0;
            this.M = 0;
            this.f3147N = 1.0f;
            this.f3148O = 1.0f;
            this.P = -1;
            this.f3149Q = -1;
            this.f3150R = -1;
            this.f3151S = false;
            this.f3152T = false;
            this.f3153U = true;
            this.f3154V = true;
            this.f3155W = false;
            this.f3156X = false;
            this.f3157Y = false;
            this.f3158Z = false;
            this.f3160a0 = -1;
            this.f3162b0 = -1;
            this.f3164c0 = -1;
            this.f3165d0 = -1;
            this.f3167e0 = -1;
            this.f3169f0 = -1;
            this.f3170g0 = 0.5f;
            this.f3178k0 = new e();
        }
    }
}
