package G3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ActivityC0219o;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.R;

/* loaded from: classes.dex */
public abstract class g extends androidx.preference.c {

    /* renamed from: k0, reason: collision with root package name */
    private h f211k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f212l0 = 0;

    /* renamed from: m0, reason: collision with root package name */
    private int f213m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f214n0;

    @Override // androidx.preference.c, androidx.preference.g.a
    public final void f(Preference preference) {
        DialogInterfaceOnCancelListenerC0216l eVar;
        c.d dVar = x() instanceof c.d ? (c.d) x() : null;
        if ((dVar == null || !dVar.a()) && E().T("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                String strO = preference.o();
                eVar = new b();
                Bundle bundle = new Bundle(1);
                bundle.putString("key", strO);
                eVar.R0(bundle);
            } else if (preference instanceof ListPreference) {
                String strO2 = preference.o();
                eVar = new d();
                Bundle bundle2 = new Bundle(1);
                bundle2.putString("key", strO2);
                eVar.R0(bundle2);
            } else {
                if (!(preference instanceof MultiSelectListPreference)) {
                    StringBuilder sbD = D2.e.d("Cannot display dialog for an unknown Preference type: ");
                    sbD.append(preference.getClass().getSimpleName());
                    sbD.append(". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                    throw new IllegalArgumentException(sbD.toString());
                }
                String strO3 = preference.o();
                eVar = new e();
                Bundle bundle3 = new Bundle(1);
                bundle3.putString("key", strO3);
                eVar.R0(bundle3);
            }
            eVar.Z0(this);
            eVar.h1(E(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    @Override // androidx.preference.c
    protected final RecyclerView.e f1(PreferenceScreen preferenceScreen) {
        h hVar = new h(preferenceScreen);
        this.f211k0 = hVar;
        hVar.O(this.f212l0, this.f213m0, this.f214n0);
        return this.f211k0;
    }

    @Override // androidx.preference.c, androidx.fragment.app.Fragment
    public View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ActivityC0219o activityC0219oX = x();
        if (activityC0219oX instanceof miuix.appcompat.app.h) {
            miuix.appcompat.app.h hVar = (miuix.appcompat.app.h) activityC0219oX;
            int iL = hVar.L();
            int dimensionPixelSize = 0;
            this.f214n0 = iL != 0;
            if (S2.d.j(iL) && this.f212l0 != iL) {
                this.f212l0 = iL;
                Context contextB = B();
                if (iL == 1) {
                    dimensionPixelSize = contextB.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_two_state_extra_padding_horizontal_small);
                } else if (iL == 2) {
                    dimensionPixelSize = contextB.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_two_state_extra_padding_horizontal_large);
                } else if (iL == 3) {
                    dimensionPixelSize = contextB.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_two_state_extra_padding_horizontal_huge);
                }
                this.f213m0 = dimensionPixelSize;
            }
            hVar.M();
        }
        return super.g0(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.preference.c
    public final RecyclerView h1(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        RecyclerView recyclerView = (RecyclerView) layoutInflater.inflate(R.layout.miuix_preference_recyclerview, viewGroup, false);
        B();
        recyclerView.u0(new LinearLayoutManager());
        return recyclerView;
    }

    @Override // androidx.preference.c, androidx.preference.g.c
    public boolean j(Preference preference) {
        return super.j(preference);
    }
}
