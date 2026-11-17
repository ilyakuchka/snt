package miuix.pickerwidget.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.android.mmt.R;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes.dex */
public class TimePicker extends FrameLayout {

    /* renamed from: r, reason: collision with root package name */
    private static final b f7277r = new a();

    /* renamed from: i, reason: collision with root package name */
    private boolean f7278i;

    /* renamed from: j, reason: collision with root package name */
    private final NumberPicker f7279j;

    /* renamed from: k, reason: collision with root package name */
    private final NumberPicker f7280k;

    /* renamed from: l, reason: collision with root package name */
    private final NumberPicker f7281l;

    /* renamed from: m, reason: collision with root package name */
    private final Button f7282m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7283n;

    /* renamed from: o, reason: collision with root package name */
    private b f7284o;
    private C3.a p;

    /* renamed from: q, reason: collision with root package name */
    private Locale f7285q;

    final class a implements b {
        a() {
        }
    }

    public interface b {
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f7283n = true;
        i(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.miuix_appcompat_time_picker, (ViewGroup) this, true);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.hour);
        this.f7279j = numberPicker;
        numberPicker.T(new miuix.pickerwidget.widget.c(this));
        ((EditText) numberPicker.findViewById(R.id.number_picker_input)).setImeOptions(5);
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.minute);
        this.f7280k = numberPicker2;
        numberPicker2.R(0);
        numberPicker2.Q(59);
        numberPicker2.S();
        numberPicker2.O(NumberPicker.f7198E0);
        numberPicker2.T(new d(this));
        ((EditText) numberPicker2.findViewById(R.id.number_picker_input)).setImeOptions(5);
        View viewFindViewById = findViewById(R.id.amPm);
        if (viewFindViewById instanceof Button) {
            this.f7281l = null;
            Button button = (Button) viewFindViewById;
            this.f7282m = button;
            button.setOnClickListener(new e(this));
        } else {
            this.f7282m = null;
            NumberPicker numberPicker3 = (NumberPicker) viewFindViewById;
            this.f7281l = numberPicker3;
            numberPicker3.R(0);
            numberPicker3.Q(1);
            numberPicker3.N(C3.b.m(getContext()).b());
            numberPicker3.T(new f(this));
            ((EditText) numberPicker3.findViewById(R.id.number_picker_input)).setImeOptions(6);
        }
        boolean zStartsWith = getContext().getString(R.string.fmt_time_12hour_pm).startsWith("a");
        if (getResources().getConfiguration().getLayoutDirection() == 1 ? !zStartsWith : zStartsWith) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.timePickerLayout);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(viewFindViewById, 0);
        }
        numberPicker.R(1);
        numberPicker.Q(12);
        numberPicker.O(null);
        k();
        this.f7284o = f7277r;
        h(Integer.valueOf(this.p.o(18)));
        j(Integer.valueOf(this.p.o(20)));
        if (!isEnabled()) {
            setEnabled(false);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        sendAccessibilityEvent(4);
        b bVar = this.f7284o;
        if (bVar != null) {
            e().intValue();
            f().intValue();
            Objects.requireNonNull(bVar);
        }
    }

    private void i(Locale locale) {
        if (locale.equals(this.f7285q)) {
            return;
        }
        this.f7285q = locale;
        if (this.p == null) {
            this.p = new C3.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        int i2 = !this.f7278i ? 1 : 0;
        NumberPicker numberPicker = this.f7281l;
        if (numberPicker != null) {
            numberPicker.U(i2);
            this.f7281l.setVisibility(0);
        } else {
            this.f7282m.setText(C3.b.m(getContext()).b()[i2]);
            this.f7282m.setVisibility(0);
        }
        sendAccessibilityEvent(4);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public final Integer e() {
        int iC = this.f7279j.C();
        return this.f7278i ? Integer.valueOf(iC % 12) : Integer.valueOf((iC % 12) + 12);
    }

    public final Integer f() {
        return Integer.valueOf(this.f7280k.C());
    }

    @Override // android.view.View
    public final int getBaseline() {
        return this.f7279j.getBaseline();
    }

    public final void h(Integer num) {
        if (num == null || num.equals(e())) {
            return;
        }
        if (num.intValue() >= 12) {
            this.f7278i = false;
            if (num.intValue() > 12) {
                num = Integer.valueOf(num.intValue() - 12);
            }
        } else {
            this.f7278i = true;
            if (num.intValue() == 0) {
                num = 12;
            }
        }
        k();
        this.f7279j.U(num.intValue());
        g();
    }

    @Override // android.view.View
    public final boolean isEnabled() {
        return this.f7283n;
    }

    public final void j(Integer num) {
        if (num.equals(f())) {
            return;
        }
        this.f7280k.U(num.intValue());
        g();
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(configuration.locale);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TimePicker.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.p.z(18, e().intValue());
        this.p.z(20, f().intValue());
        accessibilityEvent.getText().add(C3.c.a(getContext(), this.p.r(), 28));
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        h(Integer.valueOf(cVar.a()));
        j(Integer.valueOf(cVar.b()));
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        return new c(super.onSaveInstanceState(), e().intValue(), f().intValue());
    }

    @Override // android.view.View
    public final void setEnabled(boolean z4) {
        if (this.f7283n == z4) {
            return;
        }
        super.setEnabled(z4);
        this.f7280k.setEnabled(z4);
        this.f7279j.setEnabled(z4);
        NumberPicker numberPicker = this.f7281l;
        if (numberPicker != null) {
            numberPicker.setEnabled(z4);
        } else {
            this.f7282m.setEnabled(z4);
        }
        this.f7283n = z4;
    }

    private static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        private final int f7286i;

        /* renamed from: j, reason: collision with root package name */
        private final int f7287j;

        final class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final c[] newArray(int i2) {
                return new c[i2];
            }
        }

        c(Parcelable parcelable, int i2, int i4) {
            super(parcelable);
            this.f7286i = i2;
            this.f7287j = i4;
        }

        public final int a() {
            return this.f7286i;
        }

        public final int b() {
            return this.f7287j;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f7286i);
            parcel.writeInt(this.f7287j);
        }

        c(Parcel parcel) {
            super(parcel);
            this.f7286i = parcel.readInt();
            this.f7287j = parcel.readInt();
        }
    }
}
