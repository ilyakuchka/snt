package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.e;
import i.C0333a;

/* renamed from: androidx.appcompat.widget.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0199u extends Spinner {

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f3048q = {R.attr.spinnerMode};

    /* renamed from: i, reason: collision with root package name */
    private final C0184e f3049i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f3050j;

    /* renamed from: k, reason: collision with root package name */
    private F f3051k;

    /* renamed from: l, reason: collision with root package name */
    private SpinnerAdapter f3052l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f3053m;

    /* renamed from: n, reason: collision with root package name */
    private f f3054n;

    /* renamed from: o, reason: collision with root package name */
    int f3055o;
    final Rect p;

    /* renamed from: androidx.appcompat.widget.u$a */
    final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (!C0199u.this.b().isShowing()) {
                C0199u.this.c();
            }
            ViewTreeObserver viewTreeObserver = C0199u.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.u$b */
    class b implements f, DialogInterface.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        androidx.appcompat.app.e f3057i;

        /* renamed from: j, reason: collision with root package name */
        private ListAdapter f3058j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f3059k;

        b() {
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final CharSequence a() {
            return this.f3059k;
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void b(CharSequence charSequence) {
            this.f3059k = charSequence;
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void c(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void d(int i2, int i4) {
            if (this.f3058j == null) {
                return;
            }
            e.a aVar = new e.a(C0199u.this.getPopupContext());
            CharSequence charSequence = this.f3059k;
            if (charSequence != null) {
                aVar.m(charSequence);
            }
            aVar.k(this.f3058j, C0199u.this.getSelectedItemPosition(), this);
            androidx.appcompat.app.e eVarA = aVar.a();
            this.f3057i = eVarA;
            ListView listViewE = eVarA.e();
            listViewE.setTextDirection(i2);
            listViewE.setTextAlignment(i4);
            this.f3057i.show();
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void dismiss() {
            androidx.appcompat.app.e eVar = this.f3057i;
            if (eVar != null) {
                eVar.dismiss();
                this.f3057i = null;
            }
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final boolean isShowing() {
            androidx.appcompat.app.e eVar = this.f3057i;
            if (eVar != null) {
                return eVar.isShowing();
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            C0199u.this.setSelection(i2);
            if (C0199u.this.getOnItemClickListener() != null) {
                C0199u.this.performItemClick(null, i2, this.f3058j.getItemId(i2));
            }
            androidx.appcompat.app.e eVar = this.f3057i;
            if (eVar != null) {
                eVar.dismiss();
                this.f3057i = null;
            }
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void setAdapter(ListAdapter listAdapter) {
            this.f3058j = listAdapter;
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void setHorizontalOffset(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void setVerticalOffset(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }
    }

    /* renamed from: androidx.appcompat.widget.u$c */
    private static class c implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f3061a;

        /* renamed from: b, reason: collision with root package name */
        private ListAdapter f3062b;

        public c(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f3061a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f3062b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof P) {
                    P p = (P) spinnerAdapter;
                    if (p.getDropDownViewTheme() == null) {
                        p.a();
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f3062b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.f3061a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f3061a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f3061a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f3061a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f3061a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f3062b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f3061a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f3061a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.u$d */
    class d extends I implements f {

        /* renamed from: H, reason: collision with root package name */
        private CharSequence f3063H;

        /* renamed from: I, reason: collision with root package name */
        ListAdapter f3064I;

        /* renamed from: J, reason: collision with root package name */
        private final Rect f3065J;

        /* renamed from: K, reason: collision with root package name */
        private int f3066K;

        /* renamed from: androidx.appcompat.widget.u$d$a */
        final class a implements ViewTreeObserver.OnGlobalLayoutListener {
            a() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                d dVar = d.this;
                if (!dVar.w(C0199u.this)) {
                    d.this.dismiss();
                } else {
                    d.this.v();
                    d.this.f();
                }
            }
        }

        /* renamed from: androidx.appcompat.widget.u$d$b */
        final class b implements PopupWindow.OnDismissListener {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f3068i;

            b(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f3068i = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ViewTreeObserver viewTreeObserver = C0199u.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f3068i);
                }
            }
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, com.android.mmt.R.attr.spinnerStyle, 0);
            this.f3065J = new Rect();
            l(C0199u.this);
            r();
            t(new C0200v(this));
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final CharSequence a() {
            return this.f3063H;
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void b(CharSequence charSequence) {
            this.f3063H = charSequence;
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void c(int i2) {
            this.f3066K = i2;
        }

        @Override // androidx.appcompat.widget.C0199u.f
        public final void d(int i2, int i4) {
            ViewTreeObserver viewTreeObserver;
            boolean zIsShowing = isShowing();
            v();
            q();
            f();
            D d = this.f2771k;
            d.setChoiceMode(1);
            d.setTextDirection(i2);
            d.setTextAlignment(i4);
            int selectedItemPosition = C0199u.this.getSelectedItemPosition();
            D d2 = this.f2771k;
            if (isShowing() && d2 != null) {
                d2.c(false);
                d2.setSelection(selectedItemPosition);
                if (d2.getChoiceMode() != 0) {
                    d2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (zIsShowing || (viewTreeObserver = C0199u.this.getViewTreeObserver()) == null) {
                return;
            }
            a aVar = new a();
            viewTreeObserver.addOnGlobalLayoutListener(aVar);
            s(new b(aVar));
        }

        @Override // androidx.appcompat.widget.I, androidx.appcompat.widget.C0199u.f
        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.f3064I = listAdapter;
        }

        final void v() {
            Drawable background = getBackground();
            int i2 = 0;
            if (background != null) {
                background.getPadding(C0199u.this.p);
                i2 = Y.b(C0199u.this) ? C0199u.this.p.right : -C0199u.this.p.left;
            } else {
                Rect rect = C0199u.this.p;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = C0199u.this.getPaddingLeft();
            int paddingRight = C0199u.this.getPaddingRight();
            int width = C0199u.this.getWidth();
            C0199u c0199u = C0199u.this;
            int i4 = c0199u.f3055o;
            if (i4 == -2) {
                int iA = c0199u.a((SpinnerAdapter) this.f3064I, getBackground());
                int i5 = C0199u.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = C0199u.this.p;
                int i6 = (i5 - rect2.left) - rect2.right;
                if (iA > i6) {
                    iA = i6;
                }
                n(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i4 == -1) {
                n((width - paddingLeft) - paddingRight);
            } else {
                n(i4);
            }
            setHorizontalOffset(Y.b(C0199u.this) ? (((width - paddingRight) - j()) - this.f3066K) + i2 : paddingLeft + this.f3066K + i2);
        }

        final boolean w(View view) {
            int i2 = androidx.core.view.o.d;
            return view.isAttachedToWindow() && view.getGlobalVisibleRect(this.f3065J);
        }
    }

    /* renamed from: androidx.appcompat.widget.u$e */
    static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        boolean f3070i;

        /* renamed from: androidx.appcompat.widget.u$e$a */
        final class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final e[] newArray(int i2) {
                return new e[i2];
            }
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f3070i ? (byte) 1 : (byte) 0);
        }

        e(Parcel parcel) {
            super(parcel);
            this.f3070i = parcel.readByte() != 0;
        }
    }

    /* renamed from: androidx.appcompat.widget.u$f */
    interface f {
        CharSequence a();

        void b(CharSequence charSequence);

        void c(int i2);

        void d(int i2, int i4);

        void dismiss();

        Drawable getBackground();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i2);

        void setVerticalOffset(int i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0199u(Context context, AttributeSet attributeSet) throws Throwable {
        Exception e2;
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] charSequenceArrP;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, com.android.mmt.R.attr.spinnerStyle);
        this.p = new Rect();
        O.a(this, getContext());
        U u = U.u(context, attributeSet, Y1.a.f2131z, com.android.mmt.R.attr.spinnerStyle, 0);
        this.f3049i = new C0184e(this);
        int iM = u.m(6, 0);
        if (iM != 0) {
            this.f3050j = new l.d(context, iM);
        } else {
            this.f3050j = context;
        }
        TypedArray typedArray = null;
        int i2 = -1;
        try {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3048q, com.android.mmt.R.attr.spinnerStyle, 0);
            try {
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(0)) {
                        i2 = typedArrayObtainStyledAttributes.getInt(0, 0);
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e2);
                    if (typedArrayObtainStyledAttributes != null) {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                    if (i2 != 0) {
                    }
                    charSequenceArrP = u.p();
                    if (charSequenceArrP != null) {
                    }
                    u.v();
                    this.f3053m = true;
                    spinnerAdapter = this.f3052l;
                    if (spinnerAdapter != null) {
                    }
                    this.f3049i.d(attributeSet, com.android.mmt.R.attr.spinnerStyle);
                }
            } catch (Throwable th) {
                th = th;
                typedArray = typedArrayObtainStyledAttributes;
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th;
            }
        } catch (Exception e5) {
            e2 = e5;
            typedArrayObtainStyledAttributes = null;
        } catch (Throwable th2) {
            th = th2;
            if (typedArray != null) {
            }
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (i2 != 0) {
            b bVar = new b();
            this.f3054n = bVar;
            bVar.b(u.n(2));
        } else if (i2 == 1) {
            d dVar = new d(this.f3050j, attributeSet);
            U u2 = U.u(this.f3050j, attributeSet, Y1.a.f2131z, com.android.mmt.R.attr.spinnerStyle, 0);
            this.f3055o = u2.l(3, -2);
            dVar.f2768G.setBackgroundDrawable(u2.f(1));
            dVar.b(u.n(2));
            u2.v();
            this.f3054n = dVar;
            this.f3051k = new C0198t(this, this, dVar);
        }
        charSequenceArrP = u.p();
        if (charSequenceArrP != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrP);
            arrayAdapter.setDropDownViewResource(com.android.mmt.R.layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        u.v();
        this.f3053m = true;
        spinnerAdapter = this.f3052l;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f3052l = null;
        }
        this.f3049i.d(attributeSet, com.android.mmt.R.attr.spinnerStyle);
    }

    final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.p);
        Rect rect = this.p;
        return iMax2 + rect.left + rect.right;
    }

    final f b() {
        return this.f3054n;
    }

    final void c() {
        this.f3054n.d(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        C0184e c0184e = this.f3049i;
        if (c0184e != null) {
            c0184e.a();
        }
    }

    @Override // android.widget.Spinner
    public final int getDropDownHorizontalOffset() {
        f fVar = this.f3054n;
        return fVar != null ? fVar.getHorizontalOffset() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public final int getDropDownVerticalOffset() {
        f fVar = this.f3054n;
        return fVar != null ? fVar.getVerticalOffset() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public final int getDropDownWidth() {
        return this.f3054n != null ? this.f3055o : super.getDropDownWidth();
    }

    @Override // android.widget.Spinner
    public final Drawable getPopupBackground() {
        f fVar = this.f3054n;
        return fVar != null ? fVar.getBackground() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public final Context getPopupContext() {
        return this.f3050j;
    }

    @Override // android.widget.Spinner
    public final CharSequence getPrompt() {
        f fVar = this.f3054n;
        return fVar != null ? fVar.a() : super.getPrompt();
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.f3054n;
        if (fVar == null || !fVar.isShowing()) {
            return;
        }
        this.f3054n.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected final void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        if (this.f3054n == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        if (!eVar.f3070i || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new a());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        f fVar = this.f3054n;
        eVar.f3070i = fVar != null && fVar.isShowing();
        return eVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        F f4 = this.f3051k;
        if (f4 == null || !f4.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        f fVar = this.f3054n;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.isShowing()) {
            return true;
        }
        c();
        return true;
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0184e c0184e = this.f3049i;
        if (c0184e != null) {
            c0184e.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0184e c0184e = this.f3049i;
        if (c0184e != null) {
            c0184e.f(i2);
        }
    }

    @Override // android.widget.Spinner
    public final void setDropDownHorizontalOffset(int i2) {
        f fVar = this.f3054n;
        if (fVar == null) {
            super.setDropDownHorizontalOffset(i2);
        } else {
            fVar.c(i2);
            this.f3054n.setHorizontalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public final void setDropDownVerticalOffset(int i2) {
        f fVar = this.f3054n;
        if (fVar != null) {
            fVar.setVerticalOffset(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public final void setDropDownWidth(int i2) {
        if (this.f3054n != null) {
            this.f3055o = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public final void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.f3054n;
        if (fVar != null) {
            fVar.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public final void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(C0333a.a(this.f3050j, i2));
    }

    @Override // android.widget.Spinner
    public final void setPrompt(CharSequence charSequence) {
        f fVar = this.f3054n;
        if (fVar != null) {
            fVar.b(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f3053m) {
            this.f3052l = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f3054n != null) {
            Context context = this.f3050j;
            if (context == null) {
                context = getContext();
            }
            this.f3054n.setAdapter(new c(spinnerAdapter, context.getTheme()));
        }
    }
}
