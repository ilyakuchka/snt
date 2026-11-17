package G3;

import android.R;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.Y;
import androidx.core.view.o;
import androidx.preference.CheckBoxPreference;
import androidx.preference.DialogPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.SwitchPreference;
import androidx.preference.TwoStatePreference;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import s3.C0381a;
import y3.C0426a;

/* loaded from: classes.dex */
final class h extends androidx.preference.d {

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f215o;
    private static final int[] p;

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f216q;

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f217r;

    /* renamed from: s, reason: collision with root package name */
    private static final int[] f218s;

    /* renamed from: t, reason: collision with root package name */
    private static final int[] f219t;

    /* renamed from: i, reason: collision with root package name */
    private d[] f220i;

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView.g f221j;

    /* renamed from: k, reason: collision with root package name */
    private RecyclerView f222k;

    /* renamed from: l, reason: collision with root package name */
    private int f223l;

    /* renamed from: m, reason: collision with root package name */
    private int f224m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f225n;

    final class a extends RecyclerView.g {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void g() {
            h hVar = h.this;
            hVar.f220i = new d[hVar.j()];
        }
    }

    final class b extends androidx.core.view.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Preference f227a;

        b(Preference preference) {
            this.f227a = preference;
        }

        @Override // androidx.core.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.C(this.f227a.E());
            bVar.E(Switch.class.getName());
            bVar.D(((CheckBoxPreference) this.f227a).w0());
            bVar.I(this.f227a.toString());
        }
    }

    final class c extends androidx.core.view.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Preference f228a;

        c(Preference preference) {
            this.f228a = preference;
        }

        @Override // androidx.core.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.C(this.f228a.E());
            bVar.E(Switch.class.getName());
            bVar.D(((SwitchPreference) this.f228a).w0());
            bVar.I(this.f228a.toString());
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        int[] f229a;

        d() {
        }
    }

    static {
        int[] iArr = {R.attr.state_single, R.attr.state_first, R.attr.state_middle, R.attr.state_last, com.android.mmt.R.attr.state_no_title};
        f215o = iArr;
        Arrays.sort(iArr);
        p = new int[]{R.attr.state_single};
        f216q = new int[]{R.attr.state_first};
        f217r = new int[]{R.attr.state_middle};
        f218s = new int[]{R.attr.state_last};
        f219t = new int[]{com.android.mmt.R.attr.state_no_title};
    }

    public h(PreferenceGroup preferenceGroup) {
        super(preferenceGroup);
        this.f221j = new a();
        this.f223l = 0;
        this.f224m = 0;
        this.f225n = false;
        this.f220i = new d[j()];
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    @Override // androidx.preference.d, androidx.recyclerview.widget.RecyclerView.e
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(androidx.preference.h hVar, int i2) {
        int[] iArr;
        PreferenceGroup preferenceGroupS;
        I(i2).N(hVar);
        hVar.f4055i.setForceDarkAllowed(false);
        Preference preferenceI = I(i2);
        boolean z4 = preferenceI instanceof PreferenceCategory;
        if (z4) {
            TextView textView = (TextView) hVar.B(R.id.title);
            if (textView != null) {
                CharSequence charSequenceA = preferenceI.A();
                if (!TextUtils.isEmpty(charSequenceA)) {
                    textView.setContentDescription(((Object) charSequenceA) + preferenceI.i().getString(com.android.mmt.R.string.miuix_accessibility_title));
                }
            }
        } else if (preferenceI instanceof CheckBoxPreference) {
            View viewFindViewById = hVar.f4055i.findViewById(R.id.checkbox);
            if (viewFindViewById != null) {
                viewFindViewById.setImportantForAccessibility(2);
            }
            o.j(hVar.f4055i, new b(preferenceI));
        } else if (preferenceI instanceof SwitchPreference) {
            View viewB = hVar.B(R.id.switch_widget);
            if (viewB != null) {
                viewB.setImportantForAccessibility(2);
            }
            o.j(hVar.f4055i, new c(preferenceI));
        }
        if (i2 >= 0) {
            d[] dVarArr = this.f220i;
            if (i2 < dVarArr.length) {
                if (dVarArr[i2] == null) {
                    dVarArr[i2] = new d();
                }
                iArr = dVarArr[i2].f229a;
            } else {
                iArr = null;
            }
        }
        boolean z5 = true;
        if (iArr == null && (preferenceGroupS = preferenceI.s()) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < preferenceGroupS.A0(); i4++) {
                Preference preferenceZ0 = preferenceGroupS.z0(i4);
                if (preferenceZ0.G()) {
                    arrayList.add(preferenceZ0);
                }
            }
            if (!arrayList.isEmpty()) {
                int[] iArr2 = arrayList.size() == 1 ? p : preferenceI.compareTo((Preference) arrayList.get(0)) == 0 ? f216q : preferenceI.compareTo((Preference) arrayList.get(arrayList.size() - 1)) == 0 ? f218s : f217r;
                if ((preferenceI instanceof PreferenceCategory) && TextUtils.isEmpty(((PreferenceCategory) preferenceI).A())) {
                    int[] iArr3 = f219t;
                    int[] iArr4 = new int[iArr3.length + iArr2.length];
                    System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
                    System.arraycopy(iArr2, 0, iArr4, iArr3.length, iArr2.length);
                    iArr2 = iArr4;
                }
                d[] dVarArr2 = this.f220i;
                dVarArr2[i2].f229a = iArr2;
                Objects.requireNonNull(dVarArr2[i2]);
            }
        }
        int[] iArr5 = this.f220i[i2].f229a;
        Drawable background = hVar.f4055i.getBackground();
        if ((background instanceof LevelListDrawable) && z4) {
            background.setLevel(this.f225n ? this.f223l : 0);
            H3.a aVar = new H3.a(background.getCurrent());
            hVar.f4055i.setBackground(aVar);
            background = aVar;
        }
        if ((background instanceof StateListDrawable) && C0426a.b((StateListDrawable) background, f215o)) {
            H3.a aVar2 = new H3.a(background);
            hVar.f4055i.setBackground(aVar2);
            background = aVar2;
        }
        if (background instanceof H3.a) {
            H3.a aVar3 = (H3.a) background;
            if (iArr5 != null) {
                aVar3.c(iArr5);
            }
            Rect rect = new Rect();
            if (aVar3.getPadding(rect)) {
                int i5 = rect.left;
                int i6 = rect.right;
                rect.right = Y.b(this.f222k) ? i5 : i6;
                if (Y.b(this.f222k)) {
                    i5 = i6;
                }
                rect.left = i5;
                aVar3.setColorFilter(null);
                int i7 = rect.left;
                boolean z6 = this.f225n;
                hVar.f4055i.setPadding(i7 + (z6 ? this.f224m : 0), rect.top, rect.right + (z6 ? this.f224m : 0), rect.bottom);
            }
        }
        View viewFindViewById2 = hVar.f4055i.findViewById(com.android.mmt.R.id.arrow_right);
        if (viewFindViewById2 != null) {
            if (preferenceI.n() == null && preferenceI.l() == null && ((preferenceI.q() == null || (preferenceI instanceof TwoStatePreference)) && !(preferenceI instanceof DialogPreference))) {
                z5 = false;
            }
            viewFindViewById2.setVisibility(z5 ? 0 : 8);
        }
        C0381a.a((TextView) hVar.f4055i.findViewById(R.id.title));
    }

    protected final void O(int i2, int i4, boolean z4) {
        if (!S2.d.j(i2) || this.f223l == i2) {
            return;
        }
        this.f223l = i2;
        this.f224m = i4;
        this.f225n = z4;
        n();
    }

    @Override // androidx.preference.d, androidx.preference.Preference.c
    public final void f(Preference preference) {
        Preference preferenceA;
        super.f(preference);
        String strJ = preference.j();
        if (TextUtils.isEmpty(strJ) || (preferenceA = preference.x().a(strJ)) == null) {
            return;
        }
        if (!(preference instanceof PreferenceCategory)) {
            preference.r0(preference.E());
        } else if (preferenceA instanceof TwoStatePreference) {
            preference.r0(((TwoStatePreference) preferenceA).w0());
        } else {
            preference.r0(preferenceA.E());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void w(RecyclerView recyclerView) {
        D(this.f221j);
        this.f222k = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void z(RecyclerView recyclerView) {
        F(this.f221j);
        this.f222k = null;
    }
}
