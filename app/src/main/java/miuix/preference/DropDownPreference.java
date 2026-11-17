package miuix.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.preference.Preference;
import androidx.preference.h;
import com.android.mmt.R;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import miuix.appcompat.widget.Spinner;
import p3.C0364a;
import q3.C0367a;

/* loaded from: classes.dex */
public class DropDownPreference extends Preference {

    /* renamed from: f0, reason: collision with root package name */
    private static final Class<?>[] f7340f0 = {Context.class, AttributeSet.class};

    /* renamed from: W, reason: collision with root package name */
    private C0367a f7341W;

    /* renamed from: X, reason: collision with root package name */
    private ArrayAdapter f7342X;

    /* renamed from: Y, reason: collision with root package name */
    private String f7343Y;

    /* renamed from: Z, reason: collision with root package name */
    private boolean f7344Z;

    /* renamed from: a0, reason: collision with root package name */
    private Spinner f7345a0;

    /* renamed from: b0, reason: collision with root package name */
    private CharSequence[] f7346b0;

    /* renamed from: c0, reason: collision with root package name */
    private CharSequence[] f7347c0;

    /* renamed from: d0, reason: collision with root package name */
    private Handler f7348d0;

    /* renamed from: e0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f7349e0;

    final class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: miuix.preference.DropDownPreference$a$a, reason: collision with other inner class name */
        final class RunnableC0125a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f7351i;

            RunnableC0125a(String str) {
                this.f7351i = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f7351i.equals(DropDownPreference.this.B0()) || !DropDownPreference.this.e(this.f7351i)) {
                    return;
                }
                DropDownPreference.this.C0(this.f7351i);
            }
        }

        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (i2 >= 0) {
                DropDownPreference.this.f7348d0.post(new RunnableC0125a((String) DropDownPreference.this.f7347c0[i2]));
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DropDownPreference.this.f7341W.notifyDataSetChanged();
        }
    }

    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DropDownPreference.this.f7345a0.setOnItemSelectedListener(DropDownPreference.this.f7349e0);
        }
    }

    final class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                DropDownPreference.this.f7345a0.d(view);
                DropDownPreference.this.f7345a0.c(rawX, rawY);
            }
            return true;
        }
    }

    private static class e extends C0364a {

        /* renamed from: e, reason: collision with root package name */
        private CharSequence[] f7356e;

        e(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
            int[] iArr;
            super(context);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2110c, R.attr.dropdownPreferenceStyle, 0);
            this.f7587a = x.e.e(typedArrayObtainStyledAttributes, 1, 0);
            this.f7356e = x.e.e(typedArrayObtainStyledAttributes, 4, 0);
            this.f7588b = x.e.e(typedArrayObtainStyledAttributes, 3, 0);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, -1);
            typedArrayObtainStyledAttributes.recycle();
            if (resourceId > 0) {
                TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(resourceId);
                iArr = new int[typedArrayObtainTypedArray.length()];
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    iArr[i2] = typedArrayObtainTypedArray.getResourceId(i2, 0);
                }
                typedArrayObtainTypedArray.recycle();
            } else {
                iArr = null;
            }
            c(iArr);
        }

        public final CharSequence[] d() {
            return this.f7356e;
        }
    }

    private static class f implements C0367a.c {

        /* renamed from: a, reason: collision with root package name */
        private DropDownPreference f7357a;

        public f(DropDownPreference dropDownPreference) {
            this.f7357a = dropDownPreference;
        }

        @Override // q3.C0367a.c
        public final boolean a(int i2) {
            return TextUtils.equals(this.f7357a.B0(), this.f7357a.f7347c0[i2]);
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle, 0);
    }

    public final String B0() {
        return this.f7343Y;
    }

    public final void C0(String str) {
        boolean z4 = !TextUtils.equals(this.f7343Y, str);
        if (z4 || !this.f7344Z) {
            this.f7343Y = str;
            this.f7344Z = true;
            a0(str);
            if (z4) {
                H();
            }
        }
    }

    @Override // androidx.preference.Preference
    protected final void H() {
        super.H();
        if (this.f7341W != null) {
            this.f7348d0.post(new b());
        }
    }

    @Override // androidx.preference.Preference
    public final void N(h hVar) {
        if (this.f7341W.getCount() > 0) {
            Spinner spinner = (Spinner) hVar.B(R.id.spinner);
            this.f7345a0 = spinner;
            spinner.setImportantForAccessibility(2);
            Spinner spinner2 = this.f7345a0;
            int i2 = 0;
            spinner2.setClickable(false);
            spinner2.setLongClickable(false);
            spinner2.setContextClickable(false);
            this.f7345a0.setAdapter((SpinnerAdapter) this.f7341W);
            this.f7345a0.setOnItemSelectedListener(null);
            Spinner spinner3 = this.f7345a0;
            String str = this.f7343Y;
            if (this.f7347c0 != null) {
                while (true) {
                    CharSequence[] charSequenceArr = this.f7347c0;
                    if (i2 >= charSequenceArr.length) {
                        break;
                    } else if (TextUtils.equals(charSequenceArr[i2], str)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                spinner3.setSelection(i2);
                this.f7345a0.post(new c());
                Objects.requireNonNull(this.f7345a0);
                hVar.f4055i.setOnTouchListener(new d());
            } else {
                i2 = -1;
                spinner3.setSelection(i2);
                this.f7345a0.post(new c());
                Objects.requireNonNull(this.f7345a0);
                hVar.f4055i.setOnTouchListener(new d());
            }
        }
        super.N(hVar);
    }

    @Override // androidx.preference.Preference
    protected final Object Q(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    @Override // androidx.preference.Preference
    protected final void U(Parcelable parcelable) {
        if (!parcelable.getClass().equals(g.class)) {
            super.U(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.U(gVar.getSuperState());
        C0(gVar.f7358i);
    }

    @Override // androidx.preference.Preference
    protected final Parcelable V() {
        Parcelable parcelableV = super.V();
        if (F()) {
            return parcelableV;
        }
        g gVar = new g(parcelableV);
        gVar.f7358i = this.f7343Y;
        return gVar;
    }

    @Override // androidx.preference.Preference
    protected final void W(Object obj) {
        C0(v((String) obj));
    }

    @Override // androidx.preference.Preference
    protected final void X(View view) {
        Spinner spinner = this.f7345a0;
        if (spinner != null) {
            spinner.performClick();
            Log.d("DropDownPreference", "trigger from perform click");
        }
    }

    private static class g extends Preference.b {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        String f7358i;

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

        g(Parcel parcel) {
            super(parcel);
            this.f7358i = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f7358i);
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DropDownPreference(Context context, AttributeSet attributeSet, int i2, int i4) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, R.attr.dropdownPreferenceStyle, 0);
        this.f7348d0 = new Handler();
        this.f7349e0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2110c, R.attr.dropdownPreferenceStyle, 0);
        String string = typedArrayObtainStyledAttributes.getString(0);
        typedArrayObtainStyledAttributes.recycle();
        if (TextUtils.isEmpty(string)) {
            this.f7342X = new e(context, attributeSet);
        } else {
            try {
                Constructor constructor = context.getClassLoader().loadClass(string).asSubclass(ArrayAdapter.class).getConstructor(f7340f0);
                Object[] objArr = {context, attributeSet};
                constructor.setAccessible(true);
                this.f7342X = (ArrayAdapter) constructor.newInstance(objArr);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException(D2.e.c("Can't find Adapter: ", string), e2);
            } catch (IllegalAccessException e4) {
                throw new IllegalStateException(D2.e.c("Can't access non-public constructor ", string), e4);
            } catch (InstantiationException | InvocationTargetException e5) {
                throw new IllegalStateException(D2.e.c("Could not instantiate the Adapter: ", string), e5);
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException(D2.e.c("Error creating Adapter ", string), e6);
            }
        }
        this.f7341W = new C0367a(i(), this.f7342X, new f(this));
        ArrayAdapter arrayAdapter = this.f7342X;
        if (arrayAdapter instanceof e) {
            this.f7346b0 = ((e) arrayAdapter).b();
            this.f7347c0 = ((e) this.f7342X).d();
            Objects.requireNonNull((e) this.f7342X);
        } else {
            int count = arrayAdapter.getCount();
            this.f7346b0 = new CharSequence[this.f7342X.getCount()];
            for (int i5 = 0; i5 < count; i5++) {
                this.f7346b0[i5] = this.f7342X.getItem(i5).toString();
            }
            this.f7347c0 = this.f7346b0;
        }
    }
}
