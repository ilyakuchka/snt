package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;
import t.C0384b;

/* loaded from: classes.dex */
final class u implements LayoutInflater.Factory2 {

    /* renamed from: i, reason: collision with root package name */
    final w f3583i;

    final class a implements View.OnAttachStateChangeListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ C f3584i;

        a(C c2) {
            this.f3584i = c2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f3584i.k();
            this.f3584i.l();
            N.l((ViewGroup) fragmentK.f3418O.getParent(), u.this.f3583i).i();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    u(w wVar) {
        this.f3583i = wVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        C cI;
        if (C0221q.class.getName().equals(str)) {
            return new C0221q(context, attributeSet, this.f3583i);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7875e);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !C0222s.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentS = resourceId != -1 ? this.f3583i.S(resourceId) : null;
        if (fragmentS == null && string != null) {
            fragmentS = this.f3583i.T(string);
        }
        if (fragmentS == null && id != -1) {
            fragmentS = this.f3583i.S(id);
        }
        if (fragmentS == null) {
            fragmentS = this.f3583i.Y().a(context.getClassLoader(), attributeValue);
            fragmentS.f3441v = true;
            fragmentS.f3410E = resourceId != 0 ? resourceId : id;
            fragmentS.f3411F = id;
            fragmentS.f3412G = string;
            fragmentS.f3442w = true;
            w wVar = this.f3583i;
            fragmentS.f3406A = wVar;
            fragmentS.f3407B = wVar.a0();
            Objects.requireNonNull(this.f3583i.a0());
            fragmentS.m0();
            cI = this.f3583i.b(fragmentS);
            if (w.k0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentS + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentS.f3442w) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentS.f3442w = true;
            w wVar2 = this.f3583i;
            fragmentS.f3406A = wVar2;
            fragmentS.f3407B = wVar2.a0();
            Objects.requireNonNull(this.f3583i.a0());
            fragmentS.m0();
            cI = this.f3583i.i(fragmentS);
            if (w.k0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentS + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        fragmentS.f3417N = (ViewGroup) view;
        cI.l();
        cI.j();
        View view2 = fragmentS.f3418O;
        if (view2 == null) {
            throw new IllegalStateException(C2.c.a("Fragment ", attributeValue, " did not create a view."));
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentS.f3418O.getTag() == null) {
            fragmentS.f3418O.setTag(string);
        }
        fragmentS.f3418O.addOnAttachStateChangeListener(new a(cI));
        return fragmentS.f3418O;
    }
}
