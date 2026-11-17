package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mmt.R;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends G implements l.c {

    /* renamed from: e0, reason: collision with root package name */
    public static final /* synthetic */ int f2818e0 = 0;

    /* renamed from: A, reason: collision with root package name */
    private final View f2819A;

    /* renamed from: B, reason: collision with root package name */
    final ImageView f2820B;

    /* renamed from: C, reason: collision with root package name */
    final ImageView f2821C;

    /* renamed from: D, reason: collision with root package name */
    final ImageView f2822D;

    /* renamed from: E, reason: collision with root package name */
    final ImageView f2823E;

    /* renamed from: F, reason: collision with root package name */
    private final View f2824F;

    /* renamed from: G, reason: collision with root package name */
    private l f2825G;

    /* renamed from: H, reason: collision with root package name */
    private Rect f2826H;

    /* renamed from: I, reason: collision with root package name */
    private Rect f2827I;

    /* renamed from: J, reason: collision with root package name */
    private int[] f2828J;

    /* renamed from: K, reason: collision with root package name */
    private int[] f2829K;
    private final ImageView L;
    private final Drawable M;

    /* renamed from: N, reason: collision with root package name */
    private final CharSequence f2830N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f2831O;
    private boolean P;

    /* renamed from: Q, reason: collision with root package name */
    private CharSequence f2832Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f2833R;

    /* renamed from: S, reason: collision with root package name */
    private int f2834S;

    /* renamed from: T, reason: collision with root package name */
    private String f2835T;

    /* renamed from: U, reason: collision with root package name */
    private CharSequence f2836U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f2837V;

    /* renamed from: W, reason: collision with root package name */
    private int f2838W;

    /* renamed from: a0, reason: collision with root package name */
    private final Runnable f2839a0;

    /* renamed from: b0, reason: collision with root package name */
    private Runnable f2840b0;

    /* renamed from: c0, reason: collision with root package name */
    View.OnKeyListener f2841c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextWatcher f2842d0;

    /* renamed from: x, reason: collision with root package name */
    final SearchAutoComplete f2843x;

    /* renamed from: y, reason: collision with root package name */
    private final View f2844y;

    /* renamed from: z, reason: collision with root package name */
    private final View f2845z;

    public static class SearchAutoComplete extends C0183d {

        /* renamed from: l, reason: collision with root package name */
        private int f2846l;

        /* renamed from: m, reason: collision with root package name */
        private SearchView f2847m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f2848n;

        /* renamed from: o, reason: collision with root package name */
        final Runnable f2849o;

        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, R.attr.autoCompleteTextViewStyle);
            this.f2849o = new a();
            this.f2846l = getThreshold();
        }

        final void a(boolean z4) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z4) {
                this.f2848n = false;
                removeCallbacks(this.f2849o);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f2848n = true;
                    return;
                }
                this.f2848n = false;
                removeCallbacks(this.f2849o);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        final void b(SearchView searchView) {
            this.f2847m = searchView;
        }

        final void c() {
            if (this.f2848n) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f2848n = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f2846l <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.C0183d, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2848n) {
                removeCallbacks(this.f2849o);
                post(this.f2849o);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected final void onFinishInflate() {
            super.onFinishInflate();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i4 = configuration.screenHeightDp;
            setMinWidth((int) TypedValue.applyDimension(1, (i2 < 960 || i4 < 720 || configuration.orientation != 2) ? (i2 >= 600 || (i2 >= 640 && i4 >= 480)) ? 192 : 160 : 256, displayMetrics));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected final void onFocusChanged(boolean z4, int i2, Rect rect) {
            super.onFocusChanged(z4, i2, rect);
            this.f2847m.t();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2847m.clearFocus();
                        a(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z4) {
            super.onWindowFocusChanged(z4);
            if (z4 && this.f2847m.hasFocus() && getVisibility() == 0) {
                this.f2848n = true;
                Context context = getContext();
                int i2 = SearchView.f2818e0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    setInputMethodMode(1);
                    if (enoughToFilter()) {
                        showDropDown();
                    }
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected final void replaceText(CharSequence charSequence) {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f2846l = i2;
        }
    }

    final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            SearchView.this.s(charSequence);
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SearchView.this.v();
        }
    }

    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Objects.requireNonNull(SearchView.this);
        }
    }

    final class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z4) {
            Objects.requireNonNull(SearchView.this);
        }
    }

    final class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            SearchView.this.o();
        }
    }

    final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f2820B) {
                searchView.q();
                return;
            }
            if (view == searchView.f2822D) {
                searchView.p();
                return;
            }
            if (view == searchView.f2821C) {
                searchView.r();
                return;
            }
            if (view == searchView.f2823E) {
                Objects.requireNonNull(searchView);
                return;
            }
            SearchAutoComplete searchAutoComplete = searchView.f2843x;
            if (view == searchAutoComplete) {
                searchAutoComplete.refreshAutoCompleteResults();
            }
        }
    }

    final class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            Objects.requireNonNull(SearchView.this);
            return false;
        }
    }

    final class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            SearchView.this.r();
            return true;
        }
    }

    final class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Objects.requireNonNull(SearchView.this);
            throw null;
        }
    }

    final class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            SearchView.this.f2843x.getText();
            throw null;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    static class k extends I.a {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: k, reason: collision with root package name */
        boolean f2861k;

        final class a implements Parcelable.ClassLoaderCreator<k> {
            a() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final k createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new k(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new k[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new k(parcel, null);
            }
        }

        k(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            StringBuilder sbD = D2.e.d("SearchView.SavedState{");
            sbD.append(Integer.toHexString(System.identityHashCode(this)));
            sbD.append(" isIconified=");
            sbD.append(this.f2861k);
            sbD.append("}");
            return sbD.toString();
        }

        @Override // I.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f2861k));
        }

        public k(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2861k = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    private static class l extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final View f2862a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f2863b;

        /* renamed from: c, reason: collision with root package name */
        private final Rect f2864c;
        private final Rect d;

        /* renamed from: e, reason: collision with root package name */
        private final int f2865e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f2866f;

        public l(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f2865e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f2863b = new Rect();
            this.d = new Rect();
            this.f2864c = new Rect();
            a(rect, rect2);
            this.f2862a = view;
        }

        public final void a(Rect rect, Rect rect2) {
            this.f2863b.set(rect);
            this.d.set(rect);
            Rect rect3 = this.d;
            int i2 = this.f2865e;
            rect3.inset(-i2, -i2);
            this.f2864c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z4;
            boolean z5;
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z6 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z5 = this.f2866f;
                    if (z5 && !this.d.contains(x2, y2)) {
                        z6 = z5;
                        z4 = false;
                    }
                } else {
                    if (action == 3) {
                        z5 = this.f2866f;
                        this.f2866f = false;
                    }
                    z4 = true;
                    z6 = false;
                }
                z6 = z5;
                z4 = true;
            } else if (this.f2863b.contains(x2, y2)) {
                this.f2866f = true;
                z4 = true;
            } else {
                z4 = true;
                z6 = false;
            }
            if (!z6) {
                return false;
            }
            if (!z4 || this.f2864c.contains(x2, y2)) {
                Rect rect = this.f2864c;
                motionEvent.setLocation(x2 - rect.left, y2 - rect.top);
            } else {
                motionEvent.setLocation(this.f2862a.getWidth() / 2, this.f2862a.getHeight() / 2);
            }
            return this.f2862a.dispatchTouchEvent(motionEvent);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private void u() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f2843x.getText());
        if (!z5 && (!this.f2831O || this.f2837V)) {
            z4 = false;
        }
        this.f2822D.setVisibility(z4 ? 0 : 8);
        Drawable drawable = this.f2822D.getDrawable();
        if (drawable != null) {
            drawable.setState(z5 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void w() {
        CharSequence charSequence = this.f2832Q;
        if (charSequence == null) {
            charSequence = this.f2830N;
        }
        SearchAutoComplete searchAutoComplete = this.f2843x;
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.f2831O && this.M != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            this.M.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.M), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            charSequence = spannableStringBuilder;
        }
        searchAutoComplete.setHint(charSequence);
    }

    private void x(boolean z4) {
        this.P = z4;
        int i2 = z4 ? 0 : 8;
        TextUtils.isEmpty(this.f2843x.getText());
        this.f2820B.setVisibility(i2);
        this.f2821C.setVisibility(8);
        this.f2844y.setVisibility(z4 ? 8 : 0);
        this.L.setVisibility((this.L.getDrawable() == null || this.f2831O) ? 8 : 0);
        u();
        this.f2823E.setVisibility(8);
        this.f2819A.setVisibility(8);
    }

    @Override // l.c
    public final void c() {
        if (this.f2837V) {
            return;
        }
        this.f2837V = true;
        int imeOptions = this.f2843x.getImeOptions();
        this.f2838W = imeOptions;
        this.f2843x.setImeOptions(imeOptions | 33554432);
        this.f2843x.setText("");
        x(false);
        this.f2843x.requestFocus();
        this.f2843x.a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f2833R = true;
        super.clearFocus();
        this.f2843x.clearFocus();
        this.f2843x.a(false);
        this.f2833R = false;
    }

    @Override // l.c
    public final void d() {
        this.f2843x.setText("");
        SearchAutoComplete searchAutoComplete = this.f2843x;
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f2836U = "";
        clearFocus();
        x(true);
        this.f2843x.setImeOptions(this.f2838W);
        this.f2837V = false;
    }

    final void o() {
        if (this.f2824F.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f2845z.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = Y.b(this);
            int dimensionPixelSize = this.f2831O ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) : 0;
            this.f2843x.getDropDownBackground().getPadding(rect);
            this.f2843x.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f2843x.setDropDownWidth((((this.f2824F.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        removeCallbacks(this.f2839a0);
        post(this.f2840b0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.G, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        if (z4) {
            SearchAutoComplete searchAutoComplete = this.f2843x;
            Rect rect = this.f2826H;
            searchAutoComplete.getLocationInWindow(this.f2828J);
            getLocationInWindow(this.f2829K);
            int[] iArr = this.f2828J;
            int i7 = iArr[1];
            int[] iArr2 = this.f2829K;
            int i8 = i7 - iArr2[1];
            int i9 = iArr[0] - iArr2[0];
            rect.set(i9, i8, searchAutoComplete.getWidth() + i9, searchAutoComplete.getHeight() + i8);
            Rect rect2 = this.f2827I;
            Rect rect3 = this.f2826H;
            rect2.set(rect3.left, 0, rect3.right, i6 - i4);
            l lVar = this.f2825G;
            if (lVar != null) {
                lVar.a(this.f2827I, this.f2826H);
                return;
            }
            l lVar2 = new l(this.f2827I, this.f2826H, this.f2843x);
            this.f2825G = lVar2;
            setTouchDelegate(lVar2);
        }
    }

    @Override // androidx.appcompat.widget.G, android.view.View
    protected final void onMeasure(int i2, int i4) throws Resources.NotFoundException {
        int i5;
        if (this.P) {
            super.onMeasure(i2, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i6 = this.f2834S;
            size = i6 > 0 ? Math.min(i6, size) : Math.min(getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width), size);
        } else if (mode == 0) {
            size = this.f2834S;
            if (size <= 0) {
                size = getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
            }
        } else if (mode == 1073741824 && (i5 = this.f2834S) > 0) {
            size = Math.min(i5, size);
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height), size2);
        } else if (mode2 == 0) {
            size2 = getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof k)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.a());
        x(kVar.f2861k);
        requestLayout();
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        k kVar = new k(super.onSaveInstanceState());
        kVar.f2861k = this.P;
        return kVar;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        post(this.f2839a0);
    }

    final void p() {
        if (!TextUtils.isEmpty(this.f2843x.getText())) {
            this.f2843x.setText("");
            this.f2843x.requestFocus();
            this.f2843x.a(true);
        } else if (this.f2831O) {
            clearFocus();
            x(true);
        }
    }

    final void q() {
        x(false);
        this.f2843x.requestFocus();
        this.f2843x.a(true);
    }

    final void r() {
        Editable text = this.f2843x.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        this.f2843x.a(false);
        this.f2843x.dismissDropDown();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i2, Rect rect) {
        if (this.f2833R || !isFocusable()) {
            return false;
        }
        if (this.P) {
            return super.requestFocus(i2, rect);
        }
        boolean zRequestFocus = this.f2843x.requestFocus(i2, rect);
        if (zRequestFocus) {
            x(false);
        }
        return zRequestFocus;
    }

    final void s(CharSequence charSequence) {
        Editable text = this.f2843x.getText();
        this.f2836U = text;
        TextUtils.isEmpty(text);
        this.f2821C.setVisibility(8);
        this.f2823E.setVisibility(8);
        u();
        this.f2819A.setVisibility(8);
        this.f2835T = charSequence.toString();
    }

    final void t() {
        x(this.P);
        post(this.f2839a0);
        if (this.f2843x.hasFocus()) {
            this.f2843x.refreshAutoCompleteResults();
        }
    }

    final void v() {
        int[] iArr = this.f2843x.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f2845z.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2819A.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2826H = new Rect();
        this.f2827I = new Rect();
        this.f2828J = new int[2];
        this.f2829K = new int[2];
        this.f2839a0 = new b();
        this.f2840b0 = new c();
        new WeakHashMap();
        f fVar = new f();
        this.f2841c0 = new g();
        h hVar = new h();
        i iVar = new i();
        j jVar = new j();
        this.f2842d0 = new a();
        U u = U.u(context, attributeSet, Y1.a.f2130y, i2, 0);
        LayoutInflater.from(context).inflate(u.m(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f2843x = searchAutoComplete;
        searchAutoComplete.b(this);
        this.f2844y = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.f2845z = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.f2819A = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f2820B = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f2821C = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f2822D = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f2823E = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.L = imageView5;
        Drawable drawableF = u.f(10);
        int i4 = androidx.core.view.o.d;
        viewFindViewById.setBackground(drawableF);
        viewFindViewById2.setBackground(u.f(14));
        imageView.setImageDrawable(u.f(13));
        imageView2.setImageDrawable(u.f(7));
        imageView3.setImageDrawable(u.f(4));
        imageView4.setImageDrawable(u.f(16));
        imageView5.setImageDrawable(u.f(13));
        this.M = u.f(12);
        imageView.setTooltipText(getResources().getString(R.string.abc_searchview_description_search));
        u.m(15, R.layout.abc_search_dropdown_item_icons_2line);
        u.m(5, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f2842d0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f2841c0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        boolean zA = u.a(8, true);
        if (this.f2831O != zA) {
            this.f2831O = zA;
            x(zA);
            w();
        }
        int iE = u.e(1, -1);
        if (iE != -1) {
            this.f2834S = iE;
            requestLayout();
        }
        this.f2830N = u.o(6);
        this.f2832Q = u.o(11);
        int iJ = u.j(3, -1);
        if (iJ != -1) {
            searchAutoComplete.setImeOptions(iJ);
        }
        int iJ2 = u.j(2, -1);
        if (iJ2 != -1) {
            searchAutoComplete.setInputType(iJ2);
        }
        setFocusable(u.a(0, true));
        u.v();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        new Intent("android.speech.action.RECOGNIZE_SPEECH").addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f2824F = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        x(this.f2831O);
        w();
    }
}
