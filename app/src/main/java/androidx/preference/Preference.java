package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.o;
import androidx.preference.g;
import com.android.mmt.R;
import i.C0333a;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import t.C0384b;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: A, reason: collision with root package name */
    private boolean f3749A;

    /* renamed from: B, reason: collision with root package name */
    private String f3750B;

    /* renamed from: C, reason: collision with root package name */
    private Object f3751C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f3752D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f3753E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f3754F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f3755G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f3756H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f3757I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f3758J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f3759K;
    private boolean L;
    private boolean M;

    /* renamed from: N, reason: collision with root package name */
    private int f3760N;

    /* renamed from: O, reason: collision with root package name */
    private int f3761O;
    private c P;

    /* renamed from: Q, reason: collision with root package name */
    private List<Preference> f3762Q;

    /* renamed from: R, reason: collision with root package name */
    private PreferenceGroup f3763R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f3764S;

    /* renamed from: T, reason: collision with root package name */
    private f f3765T;

    /* renamed from: U, reason: collision with root package name */
    private g f3766U;

    /* renamed from: V, reason: collision with root package name */
    private final View.OnClickListener f3767V;

    /* renamed from: i, reason: collision with root package name */
    private Context f3768i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.preference.g f3769j;

    /* renamed from: k, reason: collision with root package name */
    private long f3770k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3771l;

    /* renamed from: m, reason: collision with root package name */
    private d f3772m;

    /* renamed from: n, reason: collision with root package name */
    private e f3773n;

    /* renamed from: o, reason: collision with root package name */
    private int f3774o;
    private CharSequence p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f3775q;

    /* renamed from: r, reason: collision with root package name */
    private int f3776r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f3777s;

    /* renamed from: t, reason: collision with root package name */
    private String f3778t;
    private Intent u;

    /* renamed from: v, reason: collision with root package name */
    private String f3779v;

    /* renamed from: w, reason: collision with root package name */
    private Bundle f3780w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f3781x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f3782y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f3783z;

    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Preference.this.X(view);
        }
    }

    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        static class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final b[] newArray(int i2) {
                return new b[i2];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    interface c {
        void f(Preference preference);
    }

    public interface d {
        boolean b(Preference preference, Object obj);
    }

    public interface e {
        boolean k(Preference preference);
    }

    private static class f implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* renamed from: i, reason: collision with root package name */
        private final Preference f3785i;

        f(Preference preference) {
            this.f3785i = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence charSequenceY = this.f3785i.y();
            if (!this.f3785i.D() || TextUtils.isEmpty(charSequenceY)) {
                return;
            }
            contextMenu.setHeaderTitle(charSequenceY);
            contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardManager clipboardManager = (ClipboardManager) this.f3785i.i().getSystemService("clipboard");
            CharSequence charSequenceY = this.f3785i.y();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceY));
            Toast.makeText(this.f3785i.i(), this.f3785i.i().getString(R.string.preference_copied, charSequenceY), 0).show();
            return true;
        }
    }

    public interface g<T extends Preference> {
        CharSequence a(T t2);
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, int i4) {
        this.f3774o = Integer.MAX_VALUE;
        this.f3781x = true;
        this.f3782y = true;
        this.f3749A = true;
        this.f3752D = true;
        this.f3753E = true;
        this.f3754F = true;
        this.f3755G = true;
        this.f3756H = true;
        this.f3758J = true;
        this.M = true;
        this.f3760N = R.layout.preference;
        this.f3767V = new a();
        this.f3768i = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7882m, i2, i4);
        this.f3776r = x.e.c(typedArrayObtainStyledAttributes);
        this.f3778t = x.e.d(typedArrayObtainStyledAttributes, 26, 6);
        CharSequence text = typedArrayObtainStyledAttributes.getText(34);
        this.p = text == null ? typedArrayObtainStyledAttributes.getText(4) : text;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(33);
        this.f3775q = text2 == null ? typedArrayObtainStyledAttributes.getText(7) : text2;
        this.f3774o = typedArrayObtainStyledAttributes.getInt(28, typedArrayObtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        this.f3779v = x.e.d(typedArrayObtainStyledAttributes, 22, 13);
        this.f3760N = typedArrayObtainStyledAttributes.getResourceId(27, typedArrayObtainStyledAttributes.getResourceId(3, R.layout.preference));
        this.f3761O = typedArrayObtainStyledAttributes.getResourceId(35, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        this.f3781x = typedArrayObtainStyledAttributes.getBoolean(21, typedArrayObtainStyledAttributes.getBoolean(2, true));
        this.f3782y = typedArrayObtainStyledAttributes.getBoolean(30, typedArrayObtainStyledAttributes.getBoolean(5, true));
        this.f3749A = typedArrayObtainStyledAttributes.getBoolean(29, typedArrayObtainStyledAttributes.getBoolean(1, true));
        this.f3750B = x.e.d(typedArrayObtainStyledAttributes, 19, 10);
        this.f3755G = typedArrayObtainStyledAttributes.getBoolean(16, typedArrayObtainStyledAttributes.getBoolean(16, this.f3782y));
        this.f3756H = typedArrayObtainStyledAttributes.getBoolean(17, typedArrayObtainStyledAttributes.getBoolean(17, this.f3782y));
        if (typedArrayObtainStyledAttributes.hasValue(18)) {
            this.f3751C = Q(typedArrayObtainStyledAttributes, 18);
        } else if (typedArrayObtainStyledAttributes.hasValue(11)) {
            this.f3751C = Q(typedArrayObtainStyledAttributes, 11);
        }
        this.M = typedArrayObtainStyledAttributes.getBoolean(31, typedArrayObtainStyledAttributes.getBoolean(12, true));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(32);
        this.f3757I = zHasValue;
        if (zHasValue) {
            this.f3758J = typedArrayObtainStyledAttributes.getBoolean(32, typedArrayObtainStyledAttributes.getBoolean(14, true));
        }
        this.f3759K = typedArrayObtainStyledAttributes.getBoolean(24, typedArrayObtainStyledAttributes.getBoolean(15, false));
        this.f3754F = typedArrayObtainStyledAttributes.getBoolean(25, typedArrayObtainStyledAttributes.getBoolean(25, true));
        this.L = typedArrayObtainStyledAttributes.getBoolean(20, typedArrayObtainStyledAttributes.getBoolean(20, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void e0(View view, boolean z4) {
        view.setEnabled(z4);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return;
            } else {
                e0(viewGroup.getChildAt(childCount), z4);
            }
        }
    }

    private void u0(SharedPreferences.Editor editor) {
        if (this.f3769j.p()) {
            editor.apply();
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    private void v0() {
        ?? r02;
        String str = this.f3750B;
        if (str != null) {
            androidx.preference.g gVar = this.f3769j;
            Preference preferenceA = gVar == null ? null : gVar.a(str);
            if (preferenceA == null || (r02 = preferenceA.f3762Q) == 0) {
                return;
            }
            r02.remove(this);
        }
    }

    public final CharSequence A() {
        return this.p;
    }

    public final int B() {
        return this.f3761O;
    }

    public final boolean C() {
        return !TextUtils.isEmpty(this.f3778t);
    }

    public final boolean D() {
        return this.L;
    }

    public boolean E() {
        return this.f3781x && this.f3752D && this.f3753E;
    }

    public final boolean F() {
        return this.f3749A;
    }

    public final boolean G() {
        return this.f3754F;
    }

    protected void H() {
        c cVar = this.P;
        if (cVar != null) {
            cVar.f(this);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    public void I(boolean z4) {
        ?? r4 = this.f3762Q;
        if (r4 == 0) {
            return;
        }
        int size = r4.size();
        for (int i2 = 0; i2 < size; i2++) {
            Preference preference = (Preference) r4.get(i2);
            if (preference.f3752D == z4) {
                preference.f3752D = !z4;
                preference.I(preference.s0());
                preference.H();
            }
        }
    }

    protected final void J() {
        c cVar = this.P;
        if (cVar != null) {
            ((androidx.preference.d) cVar).L();
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    public void K() {
        if (TextUtils.isEmpty(this.f3750B)) {
            return;
        }
        String str = this.f3750B;
        androidx.preference.g gVar = this.f3769j;
        Preference preferenceA = gVar == null ? null : gVar.a(str);
        if (preferenceA == null) {
            StringBuilder sbD = D2.e.d("Dependency \"");
            sbD.append(this.f3750B);
            sbD.append("\" not found for preference \"");
            sbD.append(this.f3778t);
            sbD.append("\" (title: \"");
            sbD.append((Object) this.p);
            sbD.append("\"");
            throw new IllegalStateException(sbD.toString());
        }
        if (preferenceA.f3762Q == null) {
            preferenceA.f3762Q = new ArrayList();
        }
        preferenceA.f3762Q.add(this);
        boolean zS0 = preferenceA.s0();
        if (this.f3752D == zS0) {
            this.f3752D = !zS0;
            I(s0());
            H();
        }
    }

    protected final void L(androidx.preference.g gVar) {
        this.f3769j = gVar;
        if (!this.f3771l) {
            this.f3770k = gVar.f();
        }
        if (t0()) {
            androidx.preference.g gVar2 = this.f3769j;
            if ((gVar2 != null ? gVar2.j() : null).contains(this.f3778t)) {
                W(null);
                return;
            }
        }
        Object obj = this.f3751C;
        if (obj != null) {
            W(obj);
        }
    }

    protected final void M(androidx.preference.g gVar, long j2) {
        this.f3770k = j2;
        this.f3771l = true;
        try {
            L(gVar);
        } finally {
            this.f3771l = false;
        }
    }

    public void N(h hVar) {
        Integer numValueOf;
        View view = hVar.f4055i;
        view.setOnClickListener(this.f3767V);
        view.setId(0);
        TextView textView = (TextView) hVar.B(android.R.id.summary);
        if (textView != null) {
            CharSequence charSequenceY = y();
            if (TextUtils.isEmpty(charSequenceY)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceY);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) hVar.B(android.R.id.title);
        if (textView2 != null) {
            CharSequence charSequence = this.p;
            if (TextUtils.isEmpty(charSequence)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
                if (this.f3757I) {
                    textView2.setSingleLine(this.f3758J);
                }
                if (!this.f3782y && E() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) hVar.B(android.R.id.icon);
        if (imageView != null) {
            int i2 = this.f3776r;
            if (i2 != 0 || this.f3777s != null) {
                if (this.f3777s == null) {
                    this.f3777s = C0333a.a(this.f3768i, i2);
                }
                Drawable drawable = this.f3777s;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f3777s != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.f3759K ? 4 : 8);
            }
        }
        View viewB = hVar.B(R.id.icon_frame);
        if (viewB == null) {
            viewB = hVar.B(android.R.id.icon_frame);
        }
        if (viewB != null) {
            if (this.f3777s != null) {
                viewB.setVisibility(0);
            } else {
                viewB.setVisibility(this.f3759K ? 4 : 8);
            }
        }
        if (this.M) {
            e0(view, E());
        } else {
            e0(view, true);
        }
        boolean z4 = this.f3782y;
        view.setFocusable(z4);
        view.setClickable(z4);
        hVar.E(this.f3755G);
        hVar.F(this.f3756H);
        boolean z5 = this.L;
        if (z5 && this.f3765T == null) {
            this.f3765T = new f(this);
        }
        view.setOnCreateContextMenuListener(z5 ? this.f3765T : null);
        view.setLongClickable(z5);
        if (!z5 || z4) {
            return;
        }
        int i4 = o.d;
        view.setBackground(null);
    }

    protected void O() {
    }

    public void P() {
        v0();
    }

    protected Object Q(TypedArray typedArray, int i2) {
        return null;
    }

    @Deprecated
    public void R() {
    }

    public final void S(boolean z4) {
        if (this.f3753E == z4) {
            this.f3753E = !z4;
            I(s0());
            H();
        }
    }

    protected final void T() {
        v0();
    }

    protected void U(Parcelable parcelable) {
        this.f3764S = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected Parcelable V() {
        this.f3764S = true;
        return AbsSavedState.EMPTY_STATE;
    }

    protected void W(Object obj) {
    }

    protected void X(View view) {
        Intent intent;
        g.c cVarH;
        if (E() && this.f3782y) {
            O();
            e eVar = this.f3773n;
            if (eVar == null || !eVar.k(this)) {
                androidx.preference.g gVar = this.f3769j;
                if ((gVar == null || (cVarH = gVar.h()) == null || !cVarH.j(this)) && (intent = this.u) != null) {
                    this.f3768i.startActivity(intent);
                }
            }
        }
    }

    protected final boolean Y(boolean z4) {
        if (!t0()) {
            return false;
        }
        if (z4 == t(!z4)) {
            return true;
        }
        SharedPreferences.Editor editorE = this.f3769j.e();
        editorE.putBoolean(this.f3778t, z4);
        u0(editorE);
        return true;
    }

    protected final boolean Z(int i2) {
        if (!t0()) {
            return false;
        }
        if (i2 == u(~i2)) {
            return true;
        }
        SharedPreferences.Editor editorE = this.f3769j.e();
        editorE.putInt(this.f3778t, i2);
        u0(editorE);
        return true;
    }

    protected final boolean a0(String str) {
        if (!t0()) {
            return false;
        }
        if (TextUtils.equals(str, v(null))) {
            return true;
        }
        SharedPreferences.Editor editorE = this.f3769j.e();
        editorE.putString(this.f3778t, str);
        u0(editorE);
        return true;
    }

    public final boolean b0(Set<String> set) {
        if (!t0()) {
            return false;
        }
        if (set.equals(w(null))) {
            return true;
        }
        SharedPreferences.Editor editorE = this.f3769j.e();
        editorE.putStringSet(this.f3778t, set);
        u0(editorE);
        return true;
    }

    public final void c0(Object obj) {
        this.f3751C = obj;
    }

    final void d(PreferenceGroup preferenceGroup) {
        if (preferenceGroup != null && this.f3763R != null) {
            throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
        }
        this.f3763R = preferenceGroup;
    }

    public final void d0(boolean z4) {
        if (this.f3781x != z4) {
            this.f3781x = z4;
            I(s0());
            H();
        }
    }

    public final boolean e(Object obj) {
        d dVar = this.f3772m;
        return dVar == null || dVar.b(this, obj);
    }

    @Override // java.lang.Comparable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final int compareTo(Preference preference) {
        int i2 = this.f3774o;
        int i4 = preference.f3774o;
        if (i2 != i4) {
            return i2 - i4;
        }
        CharSequence charSequence = this.p;
        CharSequence charSequence2 = preference.p;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.p.toString());
    }

    public final void f0() {
        Drawable drawableA = C0333a.a(this.f3768i, R.drawable.ic_arrow_down_24dp);
        if (this.f3777s != drawableA) {
            this.f3777s = drawableA;
            this.f3776r = 0;
            H();
        }
        this.f3776r = R.drawable.ic_arrow_down_24dp;
    }

    void g(Bundle bundle) {
        Parcelable parcelable;
        if (!C() || (parcelable = bundle.getParcelable(this.f3778t)) == null) {
            return;
        }
        this.f3764S = false;
        U(parcelable);
        if (!this.f3764S) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    public final void g0(Intent intent) {
        this.u = intent;
    }

    void h(Bundle bundle) {
        if (C()) {
            this.f3764S = false;
            Parcelable parcelableV = V();
            if (!this.f3764S) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableV != null) {
                bundle.putParcelable(this.f3778t, parcelableV);
            }
        }
    }

    public final void h0(String str) {
        this.f3778t = str;
        if (!this.f3783z || C()) {
            return;
        }
        if (TextUtils.isEmpty(this.f3778t)) {
            throw new IllegalStateException("Preference does not have a key assigned.");
        }
        this.f3783z = true;
    }

    public final Context i() {
        return this.f3768i;
    }

    public final void i0(int i2) {
        this.f3760N = i2;
    }

    public final String j() {
        return this.f3750B;
    }

    final void j0(c cVar) {
        this.P = cVar;
    }

    public final Bundle k() {
        if (this.f3780w == null) {
            this.f3780w = new Bundle();
        }
        return this.f3780w;
    }

    public final void k0(d dVar) {
        this.f3772m = dVar;
    }

    public final String l() {
        return this.f3779v;
    }

    public final void l0(e eVar) {
        this.f3773n = eVar;
    }

    long m() {
        return this.f3770k;
    }

    public final void m0(int i2) {
        if (i2 != this.f3774o) {
            this.f3774o = i2;
            J();
        }
    }

    public final Intent n() {
        return this.u;
    }

    public final void n0() {
        this.f3749A = true;
    }

    public final String o() {
        return this.f3778t;
    }

    public final void o0(CharSequence charSequence) {
        if (this.f3766U != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.f3775q, charSequence)) {
            return;
        }
        this.f3775q = charSequence;
        H();
    }

    public final int p() {
        return this.f3760N;
    }

    public final void p0(g gVar) {
        this.f3766U = gVar;
        H();
    }

    public final e q() {
        return this.f3773n;
    }

    public final void q0(int i2) {
        String string = this.f3768i.getString(i2);
        if ((string != null || this.p == null) && (string == null || string.equals(this.p))) {
            return;
        }
        this.p = string;
        H();
    }

    public final int r() {
        return this.f3774o;
    }

    public final void r0(boolean z4) {
        if (this.f3754F != z4) {
            this.f3754F = z4;
            c cVar = this.P;
            if (cVar != null) {
                ((androidx.preference.d) cVar).L();
            }
        }
    }

    public final PreferenceGroup s() {
        return this.f3763R;
    }

    public boolean s0() {
        return !E();
    }

    protected final boolean t(boolean z4) {
        return !t0() ? z4 : this.f3769j.j().getBoolean(this.f3778t, z4);
    }

    protected final boolean t0() {
        return this.f3769j != null && this.f3749A && C();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.p;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence charSequenceY = y();
        if (!TextUtils.isEmpty(charSequenceY)) {
            sb.append(charSequenceY);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    protected final int u(int i2) {
        return !t0() ? i2 : this.f3769j.j().getInt(this.f3778t, i2);
    }

    protected final String v(String str) {
        return !t0() ? str : this.f3769j.j().getString(this.f3778t, str);
    }

    public final Set<String> w(Set<String> set) {
        return !t0() ? set : this.f3769j.j().getStringSet(this.f3778t, set);
    }

    public final androidx.preference.g x() {
        return this.f3769j;
    }

    public CharSequence y() {
        g gVar = this.f3766U;
        return gVar != null ? gVar.a(this) : this.f3775q;
    }

    public final g z() {
        return this.f3766U;
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, x.e.a(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
