package miuix.pickerwidget.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.android.mmt.R;
import com.android.mmt.ui.H;
import java.util.Locale;
import java.util.Objects;
import miuix.pickerwidget.widget.NumberPicker;
import t.C0384b;
import w3.C0409b;

/* loaded from: classes.dex */
public class DateTimePicker extends LinearLayout {

    /* renamed from: v, reason: collision with root package name */
    private static a f7180v;

    /* renamed from: w, reason: collision with root package name */
    private static final ThreadLocal<C3.a> f7181w = new ThreadLocal<>();

    /* renamed from: x, reason: collision with root package name */
    private static ThreadLocal<C3.a> f7182x = new ThreadLocal<>();

    /* renamed from: i, reason: collision with root package name */
    private NumberPicker f7183i;

    /* renamed from: j, reason: collision with root package name */
    private NumberPicker f7184j;

    /* renamed from: k, reason: collision with root package name */
    private NumberPicker f7185k;

    /* renamed from: l, reason: collision with root package name */
    private String[] f7186l;

    /* renamed from: m, reason: collision with root package name */
    private b f7187m;

    /* renamed from: n, reason: collision with root package name */
    private c f7188n;

    /* renamed from: o, reason: collision with root package name */
    private C3.a f7189o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private int f7190q;

    /* renamed from: r, reason: collision with root package name */
    private C3.a f7191r;

    /* renamed from: s, reason: collision with root package name */
    private C3.a f7192s;

    /* renamed from: t, reason: collision with root package name */
    String[] f7193t;
    private boolean u;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        protected Context f7194a;

        public a(Context context) {
            this.f7194a = context.getApplicationContext();
        }

        public String a(int i2, int i4, int i5) {
            C3.a aVar = (C3.a) DateTimePicker.f7182x.get();
            if (aVar == null) {
                aVar = new C3.a();
                DateTimePicker.f7182x.set(aVar);
            }
            aVar.z(1, i2);
            aVar.z(5, i4);
            aVar.z(9, i5);
            if (!Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage())) {
                return C3.c.a(this.f7194a, aVar.r(), 13696);
            }
            String strA = C3.c.a(this.f7194a, aVar.r(), 4480);
            return strA.replace(" ", "") + " " + C3.c.a(this.f7194a, aVar.r(), 9216);
        }
    }

    public static class b extends a {
        public b(Context context) {
            super(context);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // miuix.pickerwidget.widget.DateTimePicker.a
        public final String a(int i2, int i4, int i5) {
            C3.a aVar = (C3.a) DateTimePicker.f7182x.get();
            if (aVar == null) {
                aVar = new C3.a();
                DateTimePicker.f7182x.set(aVar);
            }
            aVar.z(1, i2);
            aVar.z(5, i4);
            aVar.z(9, i5);
            Context context = this.f7194a;
            String string = context.getString(R.string.fmt_chinese_date);
            StringBuilder sb = (StringBuilder) ((C0409b.f) C0409b.c()).a();
            aVar.n(context, sb, string);
            String string2 = sb.toString();
            ((C0409b.f) C0409b.c()).d(sb);
            return string2;
        }
    }

    public interface c {
    }

    private class d implements NumberPicker.f {
        d() {
        }

        @Override // miuix.pickerwidget.widget.NumberPicker.f
        public final void a(NumberPicker numberPicker, int i2, int i4) {
            if (numberPicker == DateTimePicker.this.f7183i) {
                DateTimePicker.this.f7189o.d(12, ((numberPicker.C() - DateTimePicker.this.f7190q) + 5) % 5 != 1 ? -1 : 1);
                DateTimePicker.this.f7190q = numberPicker.C();
            } else if (numberPicker == DateTimePicker.this.f7184j) {
                DateTimePicker.this.f7189o.z(18, DateTimePicker.this.f7184j.C());
            } else if (numberPicker == DateTimePicker.this.f7185k) {
                DateTimePicker.this.f7189o.z(20, DateTimePicker.this.f7185k.C() * DateTimePicker.this.p);
            }
            DateTimePicker.this.o();
            DateTimePicker.this.y(false);
            DateTimePicker.this.z();
            DateTimePicker.this.A();
            DateTimePicker.this.sendAccessibilityEvent(4);
            if (DateTimePicker.this.f7188n != null) {
                ((H) DateTimePicker.this.f7188n).o(DateTimePicker.this.s());
            }
        }
    }

    public DateTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.dateTimePickerStyle);
        this.p = 1;
        this.f7191r = null;
        this.f7192s = null;
        this.f7193t = null;
        boolean z4 = false;
        this.u = false;
        f7180v = new a(getContext());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.miuix_appcompat_date_time_picker, (ViewGroup) this, true);
        d dVar = new d();
        C3.a aVar = new C3.a();
        this.f7189o = aVar;
        n(aVar, true);
        ThreadLocal<C3.a> threadLocal = f7181w;
        C3.a aVar2 = threadLocal.get();
        if (aVar2 == null) {
            aVar2 = new C3.a();
            threadLocal.set(aVar2);
        }
        aVar2.A(0L);
        this.f7183i = (NumberPicker) findViewById(R.id.day);
        this.f7184j = (NumberPicker) findViewById(R.id.hour);
        this.f7185k = (NumberPicker) findViewById(R.id.minute);
        this.f7183i.T(dVar);
        this.f7183i.P();
        this.f7184j.T(dVar);
        this.f7185k.T(dVar);
        this.f7185k.R(0);
        this.f7185k.Q(59);
        this.f7184j.O(NumberPicker.f7198E0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7873b, R.attr.dateTimePickerStyle, 0);
        this.u = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        Resources resources = getResources();
        boolean z5 = resources.getConfiguration().getLayoutDirection() == 1;
        boolean zStartsWith = resources.getString(R.string.fmt_time_12hour_minute).startsWith("h");
        if ((zStartsWith && z5) || (!zStartsWith && !z5)) {
            z4 = true;
        }
        if (z4) {
            ViewGroup viewGroup = (ViewGroup) this.f7184j.getParent();
            viewGroup.removeView(this.f7184j);
            viewGroup.addView(this.f7184j, viewGroup.getChildCount());
        }
        o();
        y(true);
        z();
        A();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        boolean z4;
        C3.a aVar = this.f7192s;
        if (aVar != null && q(this.f7189o, aVar) == 0 && this.f7189o.o(18) == this.f7192s.o(18)) {
            int iO = this.f7192s.o(20);
            this.f7185k.R(0);
            this.f7185k.Q(iO / this.p);
            this.f7185k.W(false);
            z4 = true;
        } else {
            z4 = false;
        }
        C3.a aVar2 = this.f7191r;
        if (aVar2 != null && q(this.f7189o, aVar2) == 0 && this.f7189o.o(18) == this.f7191r.o(18)) {
            this.f7185k.R(this.f7191r.o(20) / this.p);
            this.f7185k.W(false);
            z4 = true;
        }
        if (!z4) {
            p(this.f7185k, (60 / this.p) - 1);
            this.f7185k.R(0);
            this.f7185k.Q((60 / this.p) - 1);
            this.f7185k.W(true);
        }
        int iZ = (this.f7185k.z() - this.f7185k.A()) + 1;
        String[] strArr = this.f7186l;
        if (strArr == null || strArr.length != iZ) {
            this.f7186l = new String[iZ];
            for (int i2 = 0; i2 < iZ; i2++) {
                String[] strArr2 = this.f7186l;
                NumberPicker.c cVar = NumberPicker.f7198E0;
                int iA = (this.f7185k.A() + i2) * this.p;
                Objects.requireNonNull((NumberPicker.e) cVar);
                strArr2[i2] = D3.a.a(2, iA);
            }
            this.f7185k.N(this.f7186l);
        }
        this.f7185k.U(this.f7189o.o(20) / this.p);
    }

    private void n(C3.a aVar, boolean z4) {
        aVar.z(22, 0);
        aVar.z(21, 0);
        int iO = aVar.o(20);
        int i2 = this.p;
        int i4 = iO % i2;
        if (i4 != 0) {
            if (z4) {
                aVar.d(20, i2 - i4);
            } else {
                aVar.d(20, -i4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        C3.a aVar = this.f7191r;
        if (aVar != null && aVar.r() > this.f7189o.r()) {
            this.f7189o.A(this.f7191r.r());
        }
        C3.a aVar2 = this.f7192s;
        if (aVar2 == null || aVar2.r() >= this.f7189o.r()) {
            return;
        }
        this.f7189o.A(this.f7192s.r());
    }

    private void p(NumberPicker numberPicker, int i2) {
        String[] strArrX = numberPicker.x();
        if (strArrX == null || strArrX.length >= i2 + 0 + 1) {
            return;
        }
        numberPicker.N(null);
    }

    private int q(C3.a aVar, C3.a aVar2) {
        C3.a aVar3 = (C3.a) aVar.clone();
        C3.a aVar4 = (C3.a) aVar2.clone();
        aVar3.z(18, 0);
        aVar3.z(20, 0);
        aVar3.z(21, 0);
        aVar3.z(22, 0);
        aVar4.z(18, 0);
        aVar4.z(20, 0);
        aVar4.z(21, 0);
        aVar4.z(22, 0);
        return (int) (((((aVar3.r() / 1000) / 60) / 60) / 24) - ((((aVar4.r() / 1000) / 60) / 60) / 24));
    }

    private String r(int i2, int i4, int i5) {
        a aVar = f7180v;
        if (this.u) {
            if (this.f7187m == null) {
                this.f7187m = new b(getContext());
            }
            aVar = this.f7187m;
        }
        return aVar.a(i2, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z4) {
        String[] strArr;
        C3.a aVar = this.f7191r;
        int iQ = aVar == null ? Integer.MAX_VALUE : q(this.f7189o, aVar);
        C3.a aVar2 = this.f7192s;
        int iQ2 = aVar2 != null ? q(aVar2, this.f7189o) : Integer.MAX_VALUE;
        if (iQ > 1 || iQ2 > 1) {
            p(this.f7183i, 4);
            this.f7183i.R(0);
            this.f7183i.Q(4);
            if (iQ <= 1) {
                this.f7183i.U(iQ);
                this.f7190q = iQ;
                this.f7183i.W(false);
            }
            if (iQ2 <= 1) {
                int i2 = 4 - iQ2;
                this.f7190q = i2;
                this.f7183i.U(i2);
                this.f7183i.W(false);
            }
            if (iQ > 1 && iQ2 > 1) {
                this.f7183i.W(true);
            }
        } else {
            int iQ3 = q(this.f7192s, this.f7191r);
            p(this.f7183i, iQ3);
            this.f7183i.R(0);
            this.f7183i.Q(iQ3);
            this.f7183i.U(iQ);
            this.f7190q = iQ;
            this.f7183i.W(false);
        }
        int iZ = (this.f7183i.z() - this.f7183i.A()) + 1;
        if (z4 || (strArr = this.f7193t) == null || strArr.length != iZ) {
            this.f7193t = new String[iZ];
        }
        int iC = this.f7183i.C();
        ThreadLocal<C3.a> threadLocal = f7181w;
        C3.a aVar3 = threadLocal.get();
        if (aVar3 == null) {
            aVar3 = new C3.a();
            threadLocal.set(aVar3);
        }
        aVar3.A(this.f7189o.r());
        this.f7193t[iC] = r(aVar3.o(1), aVar3.o(5), aVar3.o(9));
        for (int i4 = 1; i4 <= 2; i4++) {
            aVar3.d(12, 1);
            int i5 = (iC + i4) % 5;
            String[] strArr2 = this.f7193t;
            if (i5 >= strArr2.length) {
                break;
            }
            strArr2[i5] = r(aVar3.o(1), aVar3.o(5), aVar3.o(9));
        }
        aVar3.A(this.f7189o.r());
        for (int i6 = 1; i6 <= 2; i6++) {
            aVar3.d(12, -1);
            int i7 = ((iC - i6) + 5) % 5;
            String[] strArr3 = this.f7193t;
            if (i7 >= strArr3.length) {
                break;
            }
            strArr3[i7] = r(aVar3.o(1), aVar3.o(5), aVar3.o(9));
        }
        this.f7183i.N(this.f7193t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        boolean z4;
        C3.a aVar = this.f7192s;
        if (aVar == null || q(this.f7189o, aVar) != 0) {
            z4 = false;
        } else {
            this.f7184j.Q(this.f7192s.o(18));
            this.f7184j.W(false);
            z4 = true;
        }
        C3.a aVar2 = this.f7191r;
        if (aVar2 != null && q(this.f7189o, aVar2) == 0) {
            this.f7184j.R(this.f7191r.o(18));
            this.f7184j.W(false);
            z4 = true;
        }
        if (!z4) {
            this.f7184j.R(0);
            this.f7184j.Q(23);
            this.f7184j.W(true);
        }
        this.f7184j.U(this.f7189o.o(18));
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(DateTimePicker.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DateTimePicker.class.getName());
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(C3.c.a(getContext(), this.f7189o.r(), 1420));
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        x(eVar.a());
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        return new e(super.onSaveInstanceState(), s());
    }

    public final long s() {
        return this.f7189o.r();
    }

    public final void t(long j2) {
        if (j2 <= 0) {
            this.f7192s = null;
        } else {
            C3.a aVar = new C3.a();
            this.f7192s = aVar;
            aVar.A(j2);
            n(this.f7192s, false);
            C3.a aVar2 = this.f7191r;
            if (aVar2 != null && aVar2.r() > this.f7192s.r()) {
                this.f7192s.A(this.f7191r.r());
            }
        }
        o();
        y(true);
        z();
        A();
    }

    public final void u(long j2) {
        if (j2 <= 0) {
            this.f7191r = null;
        } else {
            C3.a aVar = new C3.a();
            this.f7191r = aVar;
            aVar.A(j2);
            if (this.f7191r.o(21) != 0 || this.f7191r.o(22) != 0) {
                this.f7191r.d(20, 1);
            }
            n(this.f7191r, true);
            C3.a aVar2 = this.f7192s;
            if (aVar2 != null && aVar2.r() < this.f7191r.r()) {
                this.f7191r.A(this.f7192s.r());
            }
        }
        o();
        y(true);
        z();
        A();
    }

    public final void v() {
        if (this.p == 1) {
            return;
        }
        this.p = 1;
        n(this.f7189o, true);
        o();
        A();
    }

    public final void w(c cVar) {
        this.f7188n = cVar;
    }

    public final void x(long j2) {
        this.f7189o.A(j2);
        n(this.f7189o, true);
        o();
        y(true);
        z();
        A();
    }

    private static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        private long f7196i;

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

        public e(Parcelable parcelable, long j2) {
            super(parcelable);
            this.f7196i = j2;
        }

        public final long a() {
            return this.f7196i;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f7196i);
        }

        public e(Parcel parcel) {
            super(parcel);
            this.f7196i = parcel.readLong();
        }
    }
}
