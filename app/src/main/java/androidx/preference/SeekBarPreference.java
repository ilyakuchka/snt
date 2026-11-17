package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;
import com.android.mmt.R;
import t.C0384b;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: W, reason: collision with root package name */
    int f3797W;

    /* renamed from: X, reason: collision with root package name */
    int f3798X;

    /* renamed from: Y, reason: collision with root package name */
    private int f3799Y;

    /* renamed from: Z, reason: collision with root package name */
    private int f3800Z;

    /* renamed from: a0, reason: collision with root package name */
    boolean f3801a0;

    /* renamed from: b0, reason: collision with root package name */
    SeekBar f3802b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f3803c0;

    /* renamed from: d0, reason: collision with root package name */
    boolean f3804d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f3805e0;

    /* renamed from: f0, reason: collision with root package name */
    boolean f3806f0;

    /* renamed from: g0, reason: collision with root package name */
    private SeekBar.OnSeekBarChangeListener f3807g0;

    /* renamed from: h0, reason: collision with root package name */
    private View.OnKeyListener f3808h0;

    final class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i2, boolean z4) {
            if (z4) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f3806f0 || !seekBarPreference.f3801a0) {
                    seekBarPreference.x0(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.y0(i2 + seekBarPreference2.f3798X);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f3801a0 = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f3801a0 = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f3798X != seekBarPreference.f3797W) {
                seekBarPreference.x0(seekBar);
            }
        }
    }

    final class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.f3804d0 && (i2 == 21 || i2 == 22)) || i2 == 23 || i2 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f3802b0;
            if (seekBar != null) {
                return seekBar.onKeyDown(i2, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle, 0);
        this.f3807g0 = new a();
        this.f3808h0 = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7885q, R.attr.seekBarPreferenceStyle, 0);
        this.f3798X = typedArrayObtainStyledAttributes.getInt(3, 0);
        int i5 = typedArrayObtainStyledAttributes.getInt(1, 100);
        int i6 = this.f3798X;
        i5 = i5 < i6 ? i6 : i5;
        if (i5 != this.f3799Y) {
            this.f3799Y = i5;
            H();
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(4, 0);
        if (i7 != this.f3800Z) {
            this.f3800Z = Math.min(this.f3799Y - this.f3798X, Math.abs(i7));
            H();
        }
        this.f3804d0 = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.f3805e0 = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.f3806f0 = typedArrayObtainStyledAttributes.getBoolean(6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void w0(int i2, boolean z4) {
        int i4 = this.f3798X;
        if (i2 < i4) {
            i2 = i4;
        }
        int i5 = this.f3799Y;
        if (i2 > i5) {
            i2 = i5;
        }
        if (i2 != this.f3797W) {
            this.f3797W = i2;
            y0(i2);
            Z(i2);
            if (z4) {
                H();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void N(h hVar) {
        super.N(hVar);
        hVar.f4055i.setOnKeyListener(this.f3808h0);
        this.f3802b0 = (SeekBar) hVar.B(R.id.seekbar);
        TextView textView = (TextView) hVar.B(R.id.seekbar_value);
        this.f3803c0 = textView;
        if (this.f3805e0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.f3803c0 = null;
        }
        SeekBar seekBar = this.f3802b0;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f3807g0);
        this.f3802b0.setMax(this.f3799Y - this.f3798X);
        int i2 = this.f3800Z;
        if (i2 != 0) {
            this.f3802b0.setKeyProgressIncrement(i2);
        } else {
            this.f3800Z = this.f3802b0.getKeyProgressIncrement();
        }
        this.f3802b0.setProgress(this.f3797W - this.f3798X);
        y0(this.f3797W);
        this.f3802b0.setEnabled(E());
    }

    @Override // androidx.preference.Preference
    protected final Object Q(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }

    @Override // androidx.preference.Preference
    protected final void U(Parcelable parcelable) {
        if (!parcelable.getClass().equals(c.class)) {
            super.U(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.U(cVar.getSuperState());
        this.f3797W = cVar.f3811i;
        this.f3798X = cVar.f3812j;
        this.f3799Y = cVar.f3813k;
        H();
    }

    @Override // androidx.preference.Preference
    protected final Parcelable V() {
        Parcelable parcelableV = super.V();
        if (F()) {
            return parcelableV;
        }
        c cVar = new c(parcelableV);
        cVar.f3811i = this.f3797W;
        cVar.f3812j = this.f3798X;
        cVar.f3813k = this.f3799Y;
        return cVar;
    }

    @Override // androidx.preference.Preference
    protected final void W(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        w0(u(((Integer) obj).intValue()), true);
    }

    final void x0(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.f3798X;
        if (progress != this.f3797W) {
            if (e(Integer.valueOf(progress))) {
                w0(progress, false);
            } else {
                seekBar.setProgress(this.f3797W - this.f3798X);
                y0(this.f3797W);
            }
        }
    }

    final void y0(int i2) {
        TextView textView = this.f3803c0;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
    }

    private static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        int f3811i;

        /* renamed from: j, reason: collision with root package name */
        int f3812j;

        /* renamed from: k, reason: collision with root package name */
        int f3813k;

        static class a implements Parcelable.Creator<c> {
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

        c(Parcel parcel) {
            super(parcel);
            this.f3811i = parcel.readInt();
            this.f3812j = parcel.readInt();
            this.f3813k = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3811i);
            parcel.writeInt(this.f3812j);
            parcel.writeInt(this.f3813k);
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle, 0);
    }
}
