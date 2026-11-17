package miuix.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.widget.P;
import androidx.appcompat.widget.Y;
import com.android.mmt.R;
import i.C0333a;
import java.lang.reflect.Field;
import miuix.appcompat.app.g;
import miuix.view.HapticCompat;
import o0.RunnableC0359b;
import q3.C0367a;
import w3.C0408a;
import w3.C0411d;

/* loaded from: classes.dex */
public class Spinner extends android.widget.Spinner {

    /* renamed from: s, reason: collision with root package name */
    private static Field f7077s;

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f7078t = 0;

    /* renamed from: i, reason: collision with root package name */
    private final Context f7079i;

    /* renamed from: j, reason: collision with root package name */
    private SpinnerAdapter f7080j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f7081k;

    /* renamed from: l, reason: collision with root package name */
    private h f7082l;

    /* renamed from: m, reason: collision with root package name */
    int f7083m;

    /* renamed from: n, reason: collision with root package name */
    int f7084n;

    /* renamed from: o, reason: collision with root package name */
    int f7085o;
    private float p;

    /* renamed from: q, reason: collision with root package name */
    private float f7086q;

    /* renamed from: r, reason: collision with root package name */
    final Rect f7087r;

    final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (!Spinner.this.f7082l.isShowing()) {
                Spinner spinner = Spinner.this;
                spinner.getLocationInWindow(new int[2]);
                spinner.e(r1[0], r1[1]);
            }
            ViewTreeObserver viewTreeObserver = Spinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b implements h, DialogInterface.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        miuix.appcompat.app.g f7089i;

        /* renamed from: j, reason: collision with root package name */
        private ListAdapter f7090j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f7091k;

        b() {
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final CharSequence a() {
            return this.f7091k;
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void b(CharSequence charSequence) {
            this.f7091k = charSequence;
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void c(int i2) {
            Log.e("Spinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void d(int i2, int i4, float f4) {
            if (this.f7090j == null) {
                return;
            }
            g.a aVar = new g.a(Spinner.this.getPopupContext());
            CharSequence charSequence = this.f7091k;
            if (charSequence != null) {
                aVar.y(charSequence);
            }
            aVar.v(this.f7090j, Spinner.this.getSelectedItemPosition(), this);
            aVar.q(new miuix.appcompat.widget.a(this));
            miuix.appcompat.app.g gVarA = aVar.a();
            this.f7089i = gVarA;
            ListView listViewF = gVarA.f();
            listViewF.setTextDirection(i2);
            listViewF.setTextAlignment(i4);
            this.f7089i.show();
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void dismiss() {
            miuix.appcompat.app.g gVar = this.f7089i;
            if (gVar != null) {
                gVar.dismiss();
                this.f7089i = null;
            }
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final Drawable getBackground() {
            return null;
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final int getHorizontalOffset() {
            return 0;
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final int getVerticalOffset() {
            return 0;
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final boolean isShowing() {
            miuix.appcompat.app.g gVar = this.f7089i;
            return gVar != null && gVar.isShowing();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            Spinner.this.setSelection(i2);
            HapticCompat.performHapticFeedback(Spinner.this, miuix.view.c.f7462l);
            if (Spinner.this.getOnItemClickListener() != null) {
                Spinner.this.performItemClick(null, i2, this.f7090j.getItemId(i2));
            }
            dismiss();
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void setAdapter(ListAdapter listAdapter) {
            this.f7090j = listAdapter;
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void setBackgroundDrawable(Drawable drawable) {
            Log.e("Spinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void setHorizontalOffset(int i2) {
            Log.e("Spinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void setVerticalOffset(int i2) {
            Log.e("Spinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }
    }

    private static class c extends d {
        c(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            super(spinnerAdapter, theme);
        }
    }

    private static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f7093a;

        /* renamed from: b, reason: collision with root package name */
        private ListAdapter f7094b;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f7093a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f7094b = (ListAdapter) spinnerAdapter;
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
            ListAdapter listAdapter = this.f7094b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.f7093a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f7093a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f7093a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f7093a;
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
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View dropDownView = getDropDownView(i2, view, viewGroup);
            SpinnerAdapter spinnerAdapter = this.f7093a;
            if (spinnerAdapter instanceof C0367a) {
                ((C0367a) spinnerAdapter).c(dropDownView, i2);
            } else if (spinnerAdapter instanceof ArrayAdapter) {
                dropDownView.setAccessibilityDelegate(new miuix.appcompat.widget.b());
            }
            return dropDownView;
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f7093a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f7094b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f7093a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f7093a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private static class e extends d {
        e(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            super(spinnerAdapter, theme);
        }

        @Override // miuix.appcompat.widget.Spinner.d, android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i2, view, viewGroup);
            z3.d.b(view2, i2, getCount());
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class f extends miuix.internal.widget.d implements h {

        /* renamed from: i, reason: collision with root package name */
        private CharSequence f7095i;

        /* renamed from: j, reason: collision with root package name */
        ListAdapter f7096j;

        /* renamed from: k, reason: collision with root package name */
        private int f7097k;

        /* renamed from: l, reason: collision with root package name */
        private int f7098l;

        /* renamed from: m, reason: collision with root package name */
        private int f7099m;

        public f(Context context) {
            super(context);
            new Rect();
            this.f7099m = -1;
            this.f7098l = context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_context_menu_window_margin_screen);
            setDropDownGravity(8388659);
            setOnItemClickListener(new miuix.appcompat.widget.c(this));
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final CharSequence a() {
            return this.f7095i;
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void b(CharSequence charSequence) {
            this.f7095i = charSequence;
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void c(int i2) {
            this.f7097k = i2;
        }

        @Override // miuix.appcompat.widget.Spinner.h
        public final void d(int i2, int i4, float f4) {
            int i5;
            int measuredHeight;
            SpinnerAdapter spinnerAdapter;
            boolean zIsShowing = isShowing();
            Drawable background = getBackground();
            int iMax = 0;
            if (background != null) {
                background.getPadding(Spinner.this.f7087r);
                i5 = Y.b(Spinner.this) ? Spinner.this.f7087r.right : -Spinner.this.f7087r.left;
            } else {
                Rect rect = Spinner.this.f7087r;
                rect.right = 0;
                rect.left = 0;
                i5 = 0;
            }
            int paddingLeft = Spinner.this.getPaddingLeft();
            int paddingRight = Spinner.this.getPaddingRight();
            int width = Spinner.this.getWidth();
            Spinner spinner = Spinner.this;
            int i6 = spinner.f7083m;
            if (i6 == -2) {
                SpinnerAdapter spinnerAdapter2 = (SpinnerAdapter) this.f7096j;
                Drawable background2 = getBackground();
                if (spinnerAdapter2 != null) {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(spinner.getMeasuredWidth(), 0);
                    int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(spinner.getMeasuredHeight(), 0);
                    int iMax2 = Math.max(0, spinner.getSelectedItemPosition());
                    int iMin = Math.min(spinnerAdapter2.getCount(), iMax2 + 15);
                    int iMax3 = Math.max(0, iMax2 - (15 - (iMin - iMax2)));
                    int i7 = 0;
                    View view = null;
                    while (iMax3 < iMin) {
                        int i8 = iMin;
                        int itemViewType = spinnerAdapter2.getItemViewType(iMax3);
                        if (itemViewType != i7) {
                            i7 = itemViewType;
                            view = null;
                        }
                        view = spinnerAdapter2.getView(iMax3, view, spinner);
                        if (view.getLayoutParams() == null) {
                            spinnerAdapter = spinnerAdapter2;
                            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                        } else {
                            spinnerAdapter = spinnerAdapter2;
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        iMax = Math.max(iMax, view.getMeasuredWidth());
                        iMax3++;
                        iMin = i8;
                        spinnerAdapter2 = spinnerAdapter;
                    }
                    if (background2 != null) {
                        background2.getPadding(spinner.f7087r);
                        Rect rect2 = spinner.f7087r;
                        iMax += rect2.left + rect2.right;
                    }
                }
                int i9 = Spinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = Spinner.this.f7087r;
                int i10 = (i9 - rect3.left) - rect3.right;
                int i11 = this.f7098l * 2;
                int i12 = i10 - i11;
                if (iMax > i12) {
                    iMax = i12;
                }
                setContentWidth(Math.max(iMax, ((width - paddingLeft) - paddingRight) - i11));
            } else if (i6 == -1) {
                setContentWidth(((width - paddingLeft) - paddingRight) - (this.f7098l * 2));
            } else {
                setContentWidth(i6);
            }
            setHorizontalOffset(Y.b(Spinner.this) ? (((width - paddingRight) - getWidth()) - this.f7097k) + i5 : paddingLeft + this.f7097k + i5);
            setInputMethodMode(2);
            if (prepareShow(Spinner.this, null)) {
                Spinner spinner2 = Spinner.this;
                int[] iArr = new int[2];
                spinner2.getLocationInWindow(iArr);
                int i13 = (int) f4;
                int i14 = iArr[1];
                View rootView = spinner2.getRootView();
                rootView.getLocationInWindow(iArr);
                int i15 = iArr[1];
                int i16 = iArr[0];
                boolean z4 = i13 <= rootView.getWidth() / 2;
                int i17 = this.f7099m;
                if (i17 != -1) {
                    i13 = i17;
                }
                int width2 = i13 + this.f7098l;
                if (!z4 || getWidth() + width2 + this.f7098l >= rootView.getWidth()) {
                    width2 = ((rootView.getWidth() - this.f7098l) - getWidth()) + i16;
                }
                int i18 = i14 - i15;
                if (getListView() != null) {
                    ListAdapter adapter = getListView().getAdapter();
                    measuredHeight = 0;
                    for (int i19 = 0; i19 < adapter.getCount(); i19++) {
                        View view2 = adapter.getView(i19, null, getListView());
                        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        measuredHeight += view2.getMeasuredHeight();
                    }
                } else {
                    this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight = this.mContentView.getMeasuredHeight() + 0;
                }
                float f5 = measuredHeight;
                float height = i18 - (f5 / 2.0f);
                if (height < rootView.getHeight() * 0.1f) {
                    height = rootView.getHeight() * 0.1f;
                }
                if (height + f5 > rootView.getHeight() * 0.9f) {
                    height = (rootView.getHeight() * 0.9f) - f5;
                }
                if (height < rootView.getHeight() * 0.1f) {
                    height = rootView.getHeight() * 0.1f;
                    setHeight((int) (rootView.getHeight() * 0.79999995f));
                }
                float f6 = height + i15;
                if (isShowing()) {
                    update(width2, (int) f6, getWidth(), getHeight());
                } else {
                    showAtLocation(spinner2, 0, width2, (int) f6);
                    miuix.internal.widget.d.changeWindowBackground(this.mRootView.getRootView());
                }
            }
            ListView listView = getListView();
            listView.setChoiceMode(1);
            listView.setTextDirection(i2);
            listView.setTextAlignment(i4);
            int selectedItemPosition = Spinner.this.getSelectedItemPosition();
            listView.setSelection(selectedItemPosition);
            listView.setItemChecked(selectedItemPosition, true);
            if (zIsShowing) {
                return;
            }
            setOnDismissListener(new miuix.appcompat.widget.d(this));
        }

        public final void h(int i2) {
            this.f7099m = i2;
        }

        @Override // miuix.internal.widget.d, miuix.appcompat.widget.Spinner.h
        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.f7096j = listAdapter;
        }

        @Override // miuix.internal.widget.d
        public final void setContentWidth(int i2) {
            super.setContentWidth(Math.max(Math.min(i2, Spinner.this.f7085o), Spinner.this.f7084n));
        }
    }

    static class g extends View.BaseSavedState {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        boolean f7101i;

        final class a implements Parcelable.Creator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final g[] newArray(int i2) {
                return new g[i2];
            }
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f7101i ? (byte) 1 : (byte) 0);
        }

        g(Parcel parcel) {
            super(parcel);
            this.f7101i = parcel.readByte() != 0;
        }
    }

    private interface h {
        CharSequence a();

        void b(CharSequence charSequence);

        void c(int i2);

        void d(int i2, int i4, float f4);

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

    static {
        try {
            Field declaredField = android.widget.Spinner.class.getDeclaredField("mForwardingListener");
            f7077s = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.e("Spinner", "static initializer: ", e2);
        }
    }

    public Spinner(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        super(context, attributeSet, R.attr.miuiSpinnerStyle);
        this.f7087r = new Rect();
        int[] iArr = Y1.a.f2107a0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.miuiSpinnerStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.f7079i = new l.d(context, resourceId);
        } else {
            this.f7079i = context;
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(7, 0);
        if (i2 == 0) {
            b bVar = new b();
            this.f7082l = bVar;
            bVar.b(typedArrayObtainStyledAttributes.getString(2));
        } else if (i2 == 1) {
            f fVar = new f(this.f7079i);
            TypedArray typedArrayObtainStyledAttributes2 = this.f7079i.obtainStyledAttributes(attributeSet, iArr, R.attr.miuiSpinnerStyle, 0);
            this.f7083m = typedArrayObtainStyledAttributes2.getLayoutDimension(3, -2);
            this.f7084n = typedArrayObtainStyledAttributes2.getLayoutDimension(5, -2);
            this.f7085o = typedArrayObtainStyledAttributes2.getLayoutDimension(4, -2);
            int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(1, 0);
            if (resourceId2 != 0) {
                setPopupBackgroundResource(resourceId2);
            } else {
                fVar.setBackgroundDrawable(typedArrayObtainStyledAttributes2.getDrawable(1));
            }
            fVar.b(typedArrayObtainStyledAttributes.getString(2));
            typedArrayObtainStyledAttributes2.recycle();
            this.f7082l = fVar;
            Field field = f7077s;
            if (field != null) {
                try {
                    field.set(this, null);
                } catch (IllegalAccessException e2) {
                    Log.e("Spinner", "makeSupperForwardingListenerInvalid: ", e2);
                }
            }
        }
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.miuix_appcompat_simple_spinner_layout, android.R.id.text1, textArray);
            arrayAdapter.setDropDownViewResource(R.layout.miuix_appcompat_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f7081k = true;
        SpinnerAdapter spinnerAdapter = this.f7080j;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f7080j = null;
        }
        setForceDarkAllowed(false);
    }

    public static void a(Spinner spinner) {
        h hVar = spinner.f7082l;
        if (hVar != null && hVar.isShowing() && (spinner.f7082l instanceof f)) {
            if (C0408a.b(spinner.f7079i)) {
                spinner.f7082l.dismiss();
            } else {
                Point pointB = C0411d.b(spinner.getPopupContext());
                spinner.e(pointB.x * spinner.p, pointB.y * spinner.f7086q);
            }
        }
    }

    public final boolean c(float f4, float f5) {
        Point pointB = C0411d.b(getPopupContext());
        this.p = f4 / pointB.x;
        this.f7086q = f5 / pointB.y;
        sendAccessibilityEvent(1);
        h hVar = this.f7082l;
        if (hVar == null) {
            return super.performClick();
        }
        if ((hVar instanceof f) && ((f) hVar).getHeight() > 0) {
            ((f) this.f7082l).setHeight(-2);
            ((f) this.f7082l).setWidth(-2);
        }
        if (!this.f7082l.isShowing()) {
            e(f4, f5);
            HapticCompat.performHapticFeedback(this, miuix.view.c.f7462l);
        }
        return true;
    }

    public final void d(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        h hVar = this.f7082l;
        if (hVar instanceof f) {
            ((f) hVar).h(i2);
        }
    }

    final void e(float f4, float f5) {
        this.f7082l.d(getTextDirection(), getTextAlignment(), f4);
    }

    @Override // android.widget.Spinner
    public final int getDropDownHorizontalOffset() {
        h hVar = this.f7082l;
        return hVar != null ? hVar.getHorizontalOffset() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public final int getDropDownVerticalOffset() {
        h hVar = this.f7082l;
        return hVar != null ? hVar.getVerticalOffset() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public final int getDropDownWidth() {
        return this.f7082l != null ? this.f7083m : super.getDropDownWidth();
    }

    @Override // android.widget.Spinner
    public final Drawable getPopupBackground() {
        h hVar = this.f7082l;
        return hVar != null ? hVar.getBackground() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public final Context getPopupContext() {
        return this.f7079i;
    }

    @Override // android.widget.Spinner
    public final CharSequence getPrompt() {
        h hVar = this.f7082l;
        return hVar != null ? hVar.a() : super.getPrompt();
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        post(new RunnableC0359b(this, 5));
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f7082l;
        if (hVar == null || !hVar.isShowing()) {
            return;
        }
        this.f7082l.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected final void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        if (this.f7082l == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        SpinnerAdapter adapter = getAdapter();
        Drawable background = getBackground();
        int i5 = 0;
        if (adapter != null && adapter.getCount() != 0) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
            View view = adapter.getView(Math.max(0, getSelectedItemPosition()), null, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int iMax = Math.max(0, view.getMeasuredWidth());
            if (background != null) {
                background.getPadding(this.f7087r);
                Rect rect = this.f7087r;
                i5 = rect.left + rect.right + iMax;
            } else {
                i5 = iMax;
            }
        }
        setMeasuredDimension(Math.min(Math.min(measuredWidth, i5), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        if (!gVar.f7101i || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new a());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        h hVar = this.f7082l;
        gVar.f7101i = hVar != null && hVar.isShowing();
        return gVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        getLocationInWindow(new int[2]);
        return c(r0[0], r0[1]);
    }

    @Override // android.widget.Spinner
    public final void setDropDownHorizontalOffset(int i2) {
        h hVar = this.f7082l;
        if (hVar == null) {
            super.setDropDownHorizontalOffset(i2);
        } else {
            hVar.c(i2);
            this.f7082l.setHorizontalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public final void setDropDownVerticalOffset(int i2) {
        h hVar = this.f7082l;
        if (hVar != null) {
            hVar.setVerticalOffset(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public final void setDropDownWidth(int i2) {
        if (this.f7082l != null) {
            this.f7083m = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public final void setPopupBackgroundDrawable(Drawable drawable) {
        h hVar = this.f7082l;
        if (hVar != null) {
            hVar.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public final void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(C0333a.a(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public final void setPrompt(CharSequence charSequence) {
        h hVar = this.f7082l;
        if (hVar != null) {
            hVar.b(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f7081k) {
            this.f7080j = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        h hVar = this.f7082l;
        if (hVar instanceof b) {
            hVar.setAdapter(new c(spinnerAdapter, getPopupContext().getTheme()));
        } else if (hVar instanceof f) {
            hVar.setAdapter(new e(spinnerAdapter, getPopupContext().getTheme()));
        }
    }
}
