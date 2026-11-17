package miuix.appcompat.internal.app.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m3.AbstractC0350b;
import m3.C0351c;
import miuix.appcompat.internal.app.widget.c;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.view.HapticCompat;
import n3.AbstractC0355a;
import n3.AbstractC0356b;
import t3.C0388c;
import u3.MenuItemC0392a;
import z3.C0431a;
import z3.C0432b;

/* loaded from: classes.dex */
public class ActionBarContextView extends miuix.appcompat.internal.app.widget.c implements i {

    /* renamed from: A, reason: collision with root package name */
    private MenuItemC0392a f6723A;

    /* renamed from: B, reason: collision with root package name */
    private MenuItemC0392a f6724B;

    /* renamed from: C, reason: collision with root package name */
    private WeakReference<ActionMode> f6725C;

    /* renamed from: D, reason: collision with root package name */
    private m3.d f6726D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f6727E;

    /* renamed from: F, reason: collision with root package name */
    private int f6728F;

    /* renamed from: G, reason: collision with root package name */
    private List<miuix.view.a> f6729G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f6730H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f6731I;

    /* renamed from: J, reason: collision with root package name */
    private View.OnClickListener f6732J;

    /* renamed from: K, reason: collision with root package name */
    private int f6733K;
    private TextView L;
    private c.a M;

    /* renamed from: N, reason: collision with root package name */
    private c.a f6734N;

    /* renamed from: O, reason: collision with root package name */
    private TextView f6735O;
    private FrameLayout P;

    /* renamed from: Q, reason: collision with root package name */
    private int f6736Q;

    /* renamed from: R, reason: collision with root package name */
    private int f6737R;

    /* renamed from: S, reason: collision with root package name */
    private ActionBarView f6738S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f6739T;

    /* renamed from: U, reason: collision with root package name */
    private boolean f6740U;

    /* renamed from: V, reason: collision with root package name */
    private Scroller f6741V;

    /* renamed from: W, reason: collision with root package name */
    private Runnable f6742W;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f6743s;

    /* renamed from: t, reason: collision with root package name */
    private LinearLayout f6744t;
    private Button u;

    /* renamed from: v, reason: collision with root package name */
    private Button f6745v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f6746w;

    /* renamed from: x, reason: collision with root package name */
    private int f6747x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f6748y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f6749z;

    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MenuItemC0392a menuItemC0392a = view.getId() == 16908313 ? ActionBarContextView.this.f6723A : ActionBarContextView.this.f6724B;
            C0388c c0388c = (C0388c) ActionBarContextView.this.f6725C.get();
            if (c0388c != null) {
                c0388c.onMenuItemSelected((MenuBuilder) c0388c.getMenu(), menuItemC0392a);
            }
            HapticCompat.performHapticFeedback(view, miuix.view.c.f7455c);
        }
    }

    final class b extends AbstractC0355a<ActionBarOverlayLayout> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ miuix.appcompat.internal.view.menu.action.c f6751b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f6752c;
        final /* synthetic */ int d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f6753e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f6754f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(miuix.appcompat.internal.view.menu.action.c cVar, float f4, int i2, boolean z4, int i4, int i5) {
            super("");
            this.f6751b = cVar;
            this.f6752c = f4;
            this.d = i2;
            this.f6753e = z4;
            this.f6754f = i4;
            this.g = i5;
        }

        @Override // n3.AbstractC0355a
        public final /* bridge */ /* synthetic */ float a(ActionBarOverlayLayout actionBarOverlayLayout) {
            return 0.0f;
        }

        @Override // n3.AbstractC0355a
        public final void b(ActionBarOverlayLayout actionBarOverlayLayout, float f4) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = actionBarOverlayLayout;
            miuix.appcompat.internal.view.menu.action.c cVar = this.f6751b;
            if (cVar != null) {
                cVar.setTranslationY((this.f6752c + this.d) - f4);
            }
            actionBarOverlayLayout2.f((int) f4);
            if (!ActionBarContextView.this.f6731I) {
                ActionBarContextView.this.G(this.f6753e);
                ActionBarContextView.this.f6731I = true;
            } else {
                int i2 = this.f6754f;
                int i4 = this.g;
                ActionBarContextView.this.H(this.f6753e, i2 == i4 ? 1.0f : (f4 - i4) / (i2 - i4));
            }
        }
    }

    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActionBarContextView.this.f6741V.computeScrollOffset()) {
                ActionBarContextView actionBarContextView = ActionBarContextView.this;
                actionBarContextView.f6736Q = actionBarContextView.f6741V.getCurrY() - ActionBarContextView.this.f6737R;
                ActionBarContextView.this.requestLayout();
                if (!ActionBarContextView.this.f6741V.isFinished()) {
                    ActionBarContextView.this.postOnAnimation(this);
                    return;
                }
                if (ActionBarContextView.this.f6741V.getCurrY() == ActionBarContextView.this.f6737R) {
                    ActionBarContextView.this.j(0, false);
                    return;
                }
                if (ActionBarContextView.this.f6741V.getCurrY() == ActionBarContextView.this.P.getMeasuredHeight() + ActionBarContextView.this.f6737R) {
                    ActionBarContextView.this.j(1, false);
                }
            }
        }
    }

    protected class d implements AbstractC0350b.InterfaceC0118b {

        /* renamed from: a, reason: collision with root package name */
        boolean f6757a;

        public d(boolean z4) {
            this.f6757a = z4;
        }

        @Override // m3.AbstractC0350b.InterfaceC0118b
        public final void a() {
            miuix.appcompat.internal.view.menu.action.c cVar;
            ActionBarContextView.this.Q(false);
            ActionBarContextView.this.f6731I = false;
            ActionBarContextView.this.F(this.f6757a);
            if (ActionBarContextView.this.f6728F == 2) {
                ActionBarContextView.this.killMode();
            }
            ActionBarContextView.this.f6728F = 0;
            ActionBarContextView.this.f6726D = null;
            ActionBarContextView.this.setVisibility(this.f6757a ? 0 : 8);
            ActionBarContextView actionBarContextView = ActionBarContextView.this;
            if (actionBarContextView.f6933k == null || (cVar = actionBarContextView.f6931i) == null) {
                return;
            }
            cVar.setVisibility(this.f6757a ? 0 : 8);
        }
    }

    private static class e extends View.BaseSavedState {
        public static final Parcelable.ClassLoaderCreator<e> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f6759i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f6760j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f6761k;

        /* renamed from: l, reason: collision with root package name */
        public int f6762l;

        final class a implements Parcelable.ClassLoaderCreator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new e[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f6761k ? 1 : 0);
            TextUtils.writeToParcel(this.f6759i, parcel, 0);
            TextUtils.writeToParcel(this.f6760j, parcel, 0);
            parcel.writeInt(this.f6762l);
        }

        e(Parcel parcel) {
            super(parcel);
            this.f6761k = parcel.readInt() != 0;
            this.f6759i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f6760j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f6762l = parcel.readInt();
        }

        e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6761k = parcel.readInt() != 0;
            this.f6759i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f6760j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f6762l = parcel.readInt();
        }
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        this.f6749z = true;
        this.f6732J = new a();
        this.M = new c.a();
        this.f6734N = new c.a();
        this.f6739T = false;
        this.f6740U = false;
        this.f6742W = new c();
        this.f6741V = new Scroller(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.P = frameLayout;
        frameLayout.setId(com.android.mmt.R.id.action_bar_movable_container);
        this.P.setPaddingRelative(context.getResources().getDimensionPixelOffset(com.android.mmt.R.dimen.miuix_appcompat_action_bar_title_horizontal_padding), context.getResources().getDimensionPixelOffset(com.android.mmt.R.dimen.miuix_appcompat_action_bar_title_top_padding), context.getResources().getDimensionPixelOffset(com.android.mmt.R.dimen.miuix_appcompat_action_bar_title_horizontal_padding), context.getResources().getDimensionPixelOffset(com.android.mmt.R.dimen.miuix_appcompat_action_bar_title_bottom_padding));
        this.P.setVisibility(0);
        this.f6734N.b(this.P);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2100U, R.attr.actionModeStyle, 0);
        setBackground(typedArrayObtainStyledAttributes.getDrawable(0));
        this.f6747x = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f6733K = typedArrayObtainStyledAttributes.getResourceId(9, 0);
        this.f6936n = typedArrayObtainStyledAttributes.getLayoutDimension(1, 0);
        this.f6748y = typedArrayObtainStyledAttributes.getDrawable(4);
        this.f6723A = new MenuItemC0392a(context, R.id.button1, context.getString(R.string.cancel));
        this.f6724B = new MenuItemC0392a(context, R.id.button2, context.getString(com.android.mmt.R.string.miuix_appcompat_action_mode_select_all));
        this.f6749z = typedArrayObtainStyledAttributes.getBoolean(5, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private C0351c B(View view, float f4, float f5, float f6) {
        C0351c c0351c = new C0351c(view, AbstractC0356b.g, f6);
        c0351c.l(f5);
        c0351c.p().e(f4);
        c0351c.p().c(0.9f);
        c0351c.i(0.00390625f);
        return c0351c;
    }

    private void I(boolean z4) {
        miuix.appcompat.internal.view.menu.action.c cVar;
        F(z4);
        setVisibility(z4 ? 0 : 8);
        if (this.f6933k == null || (cVar = this.f6931i) == null) {
            return;
        }
        cVar.setVisibility(z4 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z4) {
        ActionBarContainer actionBarContainer = this.f6933k;
        if (actionBarContainer != null) {
            ((ActionBarOverlayLayout) actionBarContainer.getParent()).u(z4);
        }
    }

    public final CharSequence A() {
        return this.f6743s;
    }

    protected final void C() {
        if (this.f6744t == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.android.mmt.R.layout.miuix_appcompat_action_mode_title_item, (ViewGroup) this, false);
            this.f6744t = linearLayout;
            this.u = (Button) linearLayout.findViewById(R.id.button1);
            this.f6745v = (Button) this.f6744t.findViewById(R.id.button2);
            Button button = this.u;
            if (button != null) {
                button.setOnClickListener(this.f6732J);
            }
            Button button2 = this.f6745v;
            if (button2 != null) {
                button2.setOnClickListener(this.f6732J);
            }
            TextView textView = (TextView) this.f6744t.findViewById(R.id.title);
            this.f6746w = textView;
            if (this.f6747x != 0) {
                textView.setTextAppearance(getContext(), this.f6747x);
            }
            TextView textView2 = new TextView(getContext());
            this.L = textView2;
            if (this.f6733K != 0) {
                textView2.setTextAppearance(getContext(), this.f6733K);
            }
        }
        this.f6746w.setText(this.f6743s);
        this.L.setText(this.f6743s);
        TextView textView3 = this.f6746w;
        this.f6735O = textView3;
        this.M.b(textView3);
        boolean z4 = !TextUtils.isEmpty(this.f6743s);
        this.f6744t.setVisibility(z4 ? 0 : 8);
        this.L.setVisibility(z4 ? 0 : 8);
        if (this.f6744t.getParent() == null) {
            addView(this.f6744t);
        }
        if (this.L.getParent() == null) {
            this.P.addView(this.L);
        }
        if (this.P.getParent() == null) {
            addView(this.P);
        }
        int i2 = this.p;
        if (i2 == 0) {
            this.M.f(1.0f, 0);
            this.f6734N.f(0.0f, 0);
        } else if (i2 == 1) {
            this.M.f(0.0f, 20);
            this.f6734N.f(1.0f, 0);
        }
    }

    protected final void D(boolean z4) {
        setAlpha(z4 ? 1.0f : 0.0f);
        if (!this.f6934l) {
            I(z4);
            return;
        }
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f6933k.getParent();
        int iE = this.f6931i.e();
        this.f6931i.setTranslationY(z4 ? 0.0f : iE);
        if (!z4) {
            iE = 0;
        }
        actionBarOverlayLayout.f(iE);
        this.f6931i.setAlpha(z4 ? 1.0f : 0.0f);
        I(z4);
    }

    protected final m3.d E(boolean z4) {
        float f4;
        float f5;
        int i2;
        int i4;
        miuix.appcompat.internal.view.menu.action.c cVar;
        m3.d dVar;
        if (z4 == this.f6730H && this.f6726D != null) {
            return new m3.d();
        }
        this.f6730H = z4;
        miuix.appcompat.internal.view.menu.action.c cVar2 = this.f6931i;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) getParent().getParent();
        int iE = cVar2 == null ? 0 : cVar2.e();
        float translationY = cVar2 == null ? 0.0f : cVar2.getTranslationY();
        if (z4) {
            f5 = 0.0f;
            f4 = 1.0f;
            i4 = 0;
            i2 = iE;
        } else {
            f4 = 0.0f;
            f5 = 1.0f;
            i2 = 0;
            i4 = iE;
        }
        m3.d dVar2 = new m3.d();
        C0351c c0351cB = B(this, z4 ? 322.27f : 986.96f, f5, f4);
        c0351cB.k(z4 ? 50L : 0L);
        dVar2.c(c0351cB);
        setAlpha(f5);
        if (!this.f6934l) {
            c0351cB.b(new d(z4));
            this.f6726D = dVar2;
            return dVar2;
        }
        this.f6731I = false;
        int i5 = z4 ? 100 : 0;
        float f6 = z4 ? 438.65f : 986.96f;
        float f7 = f5;
        int i6 = i2;
        int i7 = i4;
        float f8 = f4;
        C0351c c0351c = new C0351c(actionBarOverlayLayout, new b(cVar2, translationY, iE, z4, i6, i7), i6);
        float f9 = i7;
        c0351c.l(f9);
        c0351c.p().e(f6);
        c0351c.p().c(0.9f);
        long j2 = i5;
        c0351c.k(j2);
        c0351c.b(new d(z4));
        if (cVar2 != null) {
            float f10 = (translationY + iE) - f9;
            cVar = cVar2;
            cVar.setTranslationY(f10);
        } else {
            cVar = cVar2;
        }
        actionBarOverlayLayout.f(i7);
        if (cVar != null) {
            C0351c c0351cB2 = B(cVar, f6, f7, f8);
            c0351cB2.k(j2);
            cVar.setAlpha(f7);
            C0351c[] c0351cArr = {c0351c, c0351cB2};
            dVar = dVar2;
            dVar.d(c0351cArr);
        } else {
            dVar = dVar2;
            dVar.c(c0351c);
        }
        this.f6726D = dVar;
        return dVar;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<miuix.view.a>] */
    public final void F(boolean z4) {
        ?? r12 = this.f6729G;
        if (r12 == 0) {
            return;
        }
        Iterator it = r12.iterator();
        while (it.hasNext()) {
            ((miuix.view.a) it.next()).g(z4);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<miuix.view.a>] */
    public final void G(boolean z4) {
        ?? r12 = this.f6729G;
        if (r12 == 0) {
            return;
        }
        Iterator it = r12.iterator();
        while (it.hasNext()) {
            ((miuix.view.a) it.next()).a(z4);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<miuix.view.a>] */
    public final void H(boolean z4, float f4) {
        ?? r12 = this.f6729G;
        if (r12 == 0) {
            return;
        }
        Iterator it = r12.iterator();
        while (it.hasNext()) {
            ((miuix.view.a) it.next()).f(z4, f4);
        }
    }

    public final void J(int i2, int[] iArr, int[] iArr2) {
        if (i2 <= 0 || getHeight() <= this.f6737R) {
            return;
        }
        int height = getHeight() - i2;
        int i4 = this.f6736Q;
        int i5 = this.f6737R;
        if (height >= i5) {
            this.f6736Q = i4 - i2;
            iArr[1] = iArr[1] + i2;
        } else {
            int height2 = i5 - getHeight();
            this.f6736Q = 0;
            iArr[1] = iArr[1] + (-height2);
        }
        int i6 = this.f6736Q;
        if (i6 != i4) {
            iArr2[1] = i4 - i6;
            requestLayout();
        }
    }

    public final void K(int i2, int[] iArr, int[] iArr2) {
        if (i2 < 0) {
            if (getHeight() < this.P.getMeasuredHeight() + this.f6737R) {
                int i4 = this.f6736Q;
                if (getHeight() - i2 <= this.P.getMeasuredHeight() + this.f6737R) {
                    this.f6736Q -= i2;
                    iArr[1] = iArr[1] + i2;
                } else {
                    int measuredHeight = (this.P.getMeasuredHeight() + this.f6737R) - getHeight();
                    this.f6736Q = this.P.getMeasuredHeight();
                    iArr[1] = iArr[1] + (-measuredHeight);
                }
                int i5 = this.f6736Q;
                if (i5 != i4) {
                    iArr2[1] = i4 - i5;
                    requestLayout();
                }
            }
        }
    }

    public final void L(int i2) {
        if (i2 == 0) {
            this.f6739T = true;
        } else {
            this.f6740U = true;
        }
        if (!this.f6741V.isFinished()) {
            this.f6741V.forceFinished(true);
        }
        super.j(2, false);
    }

    public final boolean M() {
        if (getContext().getResources().getConfiguration().orientation != 2) {
            return super.c();
        }
        getContext();
        int i2 = C0432b.f8169a;
        return false;
    }

    public final void N() {
        boolean z4;
        if (this.f6739T) {
            this.f6739T = false;
            z4 = !this.f6740U;
        } else {
            if (this.f6740U) {
                this.f6740U = false;
            }
        }
        if (z4) {
            if (getHeight() == this.f6737R) {
                super.j(0, false);
                return;
            }
            if (getHeight() == this.P.getMeasuredHeight() + this.f6737R && this.f6736Q == this.P.getMeasuredHeight()) {
                super.j(1, false);
                return;
            }
            if (getHeight() > (this.P.getMeasuredHeight() / 2) + this.f6737R) {
                this.f6741V.startScroll(0, getHeight(), 0, (this.P.getMeasuredHeight() + this.f6737R) - getHeight());
            } else {
                this.f6741V.startScroll(0, getHeight(), 0, this.f6737R - getHeight());
            }
            postOnAnimation(this.f6742W);
        }
    }

    public final void O(ActionBarView actionBarView) {
        this.f6738S = actionBarView;
    }

    public final void P(int i2, int i4) {
        C();
        if (i2 == 16908313) {
            Button button = this.u;
            if (button != null) {
                button.setVisibility((TextUtils.isEmpty("") && i4 == 0) ? 8 : 0);
                this.u.setText("");
                this.u.setBackgroundResource(i4);
            }
            this.f6723A.setTitle("");
        } else if (i2 == 16908314) {
            Button button2 = this.f6745v;
            if (button2 != null) {
                button2.setVisibility((TextUtils.isEmpty("") && i4 == 0) ? 8 : 0);
                this.f6745v.setText("");
                this.f6745v.setBackgroundResource(i4);
            }
            this.f6724B.setTitle("");
        }
        if (!TextUtils.isEmpty("") || i4 == 0) {
            return;
        }
        Button button3 = i2 == 16908313 ? this.u : i2 == 16908314 ? this.f6745v : null;
        if (button3 == null) {
            return;
        }
        if (com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_cancel_light == i4 || com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_cancel_dark == i4) {
            button3.setContentDescription(getResources().getString(com.android.mmt.R.string.miuix_appcompat_cancel_description));
            return;
        }
        if (com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_confirm_light == i4 || com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_confirm_dark == i4) {
            button3.setContentDescription(getResources().getString(com.android.mmt.R.string.miuix_appcompat_confirm_description));
            return;
        }
        if (com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_select_all_light == i4 || com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_select_all_dark == i4) {
            button3.setContentDescription(getResources().getString(com.android.mmt.R.string.miuix_appcompat_select_all_description));
            return;
        }
        if (com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_light == i4 || com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_dark == i4) {
            button3.setContentDescription(getResources().getString(com.android.mmt.R.string.miuix_appcompat_deselect_all_description));
        } else if (com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_delete_light == i4 || com.android.mmt.R.drawable.miuix_appcompat_action_mode_title_button_delete_dark == i4) {
            button3.setContentDescription(getResources().getString(com.android.mmt.R.string.miuix_appcompat_delete_description));
        }
    }

    public final void R(ActionBarContainer actionBarContainer) {
        this.f6933k = actionBarContainer;
    }

    public final void S(boolean z4) {
        this.f6935m = z4;
    }

    public final void T(CharSequence charSequence) {
        this.f6743s = charSequence;
        C();
    }

    @Override // miuix.appcompat.internal.app.widget.c
    final int a() {
        return R.attr.actionModeStyle;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<miuix.view.a>] */
    @Override // miuix.appcompat.internal.app.widget.i
    public final void addAnimationListener(miuix.view.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f6729G == null) {
            this.f6729G = new ArrayList();
        }
        this.f6729G.add(aVar);
    }

    @Override // miuix.appcompat.internal.app.widget.i
    public final void animateToVisibility(boolean z4) {
        m3.d dVar = this.f6726D;
        if (dVar != null) {
            dVar.a();
            this.f6726D = null;
        }
        Q(false);
        Q(this.f6749z);
        if (!z4) {
            if (this.f6749z) {
                E(false).e();
                return;
            } else {
                D(false);
                return;
            }
        }
        if (!this.f6749z) {
            D(true);
        } else {
            setVisibility(0);
            this.f6727E = true;
        }
    }

    @Override // miuix.appcompat.internal.app.widget.i
    public final void closeMode() {
        m3.d dVar = this.f6726D;
        if (dVar != null) {
            dVar.b();
            this.f6726D = null;
        }
        Q(false);
        this.f6728F = 2;
    }

    @Override // miuix.appcompat.internal.app.widget.c
    protected final void f(int i2, int i4) {
        if (i2 == 2) {
            this.f6736Q = 0;
            if (!this.f6741V.isFinished()) {
                this.f6741V.forceFinished(true);
            }
        }
        if (i4 != 0) {
            this.P.setVisibility(0);
        }
        if (i4 == 0) {
            this.P.setVisibility(8);
        } else {
            this.f6736Q = getHeight() - this.f6737R;
        }
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // miuix.appcompat.internal.app.widget.c
    public final void i(int i2) {
        super.j(0, false);
    }

    @Override // miuix.appcompat.internal.app.widget.i
    public final void initForMode(ActionMode actionMode) {
        if (this.f6725C != null) {
            m3.d dVar = this.f6726D;
            if (dVar != null) {
                dVar.a();
                this.f6726D = null;
            }
            Q(false);
            killMode();
        }
        C();
        this.f6725C = new WeakReference<>(actionMode);
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        if (bVar != null) {
            bVar.k(false);
        }
        Object parent = getParent();
        while (true) {
            View view = (View) parent;
            if (view instanceof ActionBarOverlayLayout) {
                miuix.appcompat.internal.view.menu.action.b bVar2 = new miuix.appcompat.internal.view.menu.action.b(getContext(), (ActionBarOverlayLayout) view, com.android.mmt.R.layout.miuix_appcompat_action_mode_menu_item_layout);
                this.f6932j = bVar2;
                bVar2.q();
                this.f6932j.p();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
                if (!this.f6934l) {
                    menuBuilder.addMenuPresenter(this.f6932j);
                    miuix.appcompat.internal.view.menu.action.c cVar = (miuix.appcompat.internal.view.menu.action.c) this.f6932j.getMenuView(this);
                    this.f6931i = cVar;
                    cVar.setBackground(null);
                    addView(this.f6931i, layoutParams);
                    return;
                }
                this.f6932j.r(getContext().getResources().getDisplayMetrics().widthPixels);
                layoutParams.width = -1;
                layoutParams.height = -2;
                layoutParams.gravity = 80;
                menuBuilder.addMenuPresenter(this.f6932j);
                miuix.appcompat.internal.view.menu.action.c cVar2 = (miuix.appcompat.internal.view.menu.action.c) this.f6932j.getMenuView(this);
                this.f6931i = cVar2;
                cVar2.setBackground(this.f6748y);
                this.f6933k.addView(this.f6931i, layoutParams);
                return;
            }
            if (!(view.getParent() instanceof View)) {
                throw new IllegalStateException("ActionBarOverlayLayout not found");
            }
            parent = view.getParent();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<miuix.view.a>] */
    @Override // miuix.appcompat.internal.app.widget.i
    public final void killMode() {
        removeAllViews();
        ?? r02 = this.f6729G;
        if (r02 != 0) {
            r02.clear();
            this.f6729G = null;
        }
        ActionBarContainer actionBarContainer = this.f6933k;
        if (actionBarContainer != null) {
            actionBarContainer.removeView(this.f6931i);
        }
        this.f6931i = null;
        this.f6725C = null;
    }

    @Override // miuix.appcompat.internal.app.widget.c
    public final void l(boolean z4) {
        if (this.f6934l != z4) {
            if (this.f6932j != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
                if (z4) {
                    this.f6932j.r(getContext().getResources().getDisplayMetrics().widthPixels);
                    layoutParams.width = -1;
                    layoutParams.height = -2;
                    getContext();
                    int i2 = C0432b.f8169a;
                    layoutParams.gravity = 80;
                    miuix.appcompat.internal.view.menu.action.c cVar = (miuix.appcompat.internal.view.menu.action.c) this.f6932j.getMenuView(this);
                    this.f6931i = cVar;
                    cVar.setBackground(this.f6748y);
                    ViewGroup viewGroup = (ViewGroup) this.f6931i.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f6931i);
                    }
                    this.f6933k.addView(this.f6931i, layoutParams);
                } else {
                    miuix.appcompat.internal.view.menu.action.c cVar2 = (miuix.appcompat.internal.view.menu.action.c) this.f6932j.getMenuView(this);
                    this.f6931i = cVar2;
                    cVar2.setBackground(null);
                    ViewGroup viewGroup2 = (ViewGroup) this.f6931i.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.f6931i);
                    }
                    addView(this.f6931i, layoutParams);
                }
            }
            this.f6934l = z4;
        }
    }

    @Override // miuix.appcompat.internal.app.widget.c
    public final boolean m() {
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        return bVar != null && bVar.s();
    }

    @Override // miuix.appcompat.internal.app.widget.c, android.view.View
    protected final void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.android.mmt.R.dimen.miuix_appcompat_action_bar_title_horizontal_padding);
        this.P.setPaddingRelative(dimensionPixelOffset, getResources().getDimensionPixelOffset(com.android.mmt.R.dimen.miuix_appcompat_action_bar_title_top_padding), dimensionPixelOffset, getResources().getDimensionPixelOffset(com.android.mmt.R.dimen.miuix_appcompat_action_bar_title_bottom_padding));
        setPaddingRelative(C0431a.d(getContext(), com.android.mmt.R.attr.actionBarPaddingStart), getPaddingTop(), C0431a.d(getContext(), com.android.mmt.R.attr.actionBarPaddingEnd), getPaddingBottom());
        TextView textView = this.f6746w;
        if (textView != null) {
            textView.setTextAppearance(getContext(), this.f6747x);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        if (bVar != null) {
            bVar.k(false);
            this.f6932j.l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f7  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int i7;
        int measuredHeight;
        int i8;
        int i9;
        int paddingStart;
        int measuredHeight2;
        int i10;
        LinearLayout linearLayout;
        int paddingEnd;
        miuix.appcompat.internal.view.menu.action.c cVar;
        FrameLayout frameLayout;
        int i11;
        int i12 = this.p;
        if (i12 == 2) {
            measuredHeight = this.f6736Q;
        } else {
            if (i12 != 1) {
                i7 = 0;
                i8 = i6 - i4;
                i9 = i8 - i7;
                paddingStart = getPaddingStart();
                measuredHeight2 = this.f6744t.getMeasuredHeight();
                i10 = (((i6 - i7) - i4) - measuredHeight2) / 2;
                linearLayout = this.f6744t;
                if (linearLayout != null && linearLayout.getVisibility() != 8) {
                    g(this.f6744t, paddingStart, i10, measuredHeight2, false);
                }
                paddingEnd = (i5 - i2) - getPaddingEnd();
                cVar = this.f6931i;
                if (cVar != null && cVar.getParent() == this) {
                    h(this.f6931i, paddingEnd);
                }
                if (this.f6727E) {
                    this.f6728F = 1;
                    E(true).e();
                    this.f6727E = false;
                }
                frameLayout = this.P;
                if (frameLayout != null && frameLayout.getVisibility() == 0 && this.p != 0) {
                    FrameLayout frameLayout2 = this.P;
                    frameLayout2.layout(i2, i8 - frameLayout2.getMeasuredHeight(), i5, i8);
                    int measuredWidth = !(getLayoutDirection() != 1) ? i5 - this.P.getMeasuredWidth() : i2;
                    Rect rect = new Rect();
                    rect.set(measuredWidth, this.P.getMeasuredHeight() - (i8 - i9), this.P.getMeasuredWidth() + measuredWidth, this.P.getMeasuredHeight());
                    this.P.setClipBounds(rect);
                }
                float fMin = 1.0f - Math.min(1.0f, ((this.P.getMeasuredHeight() - i7) / this.P.getMeasuredHeight()) * 3.0f);
                i11 = this.p;
                if (i11 != 2) {
                    if (fMin > 0.0f) {
                        this.M.a(0.0f, 20, this.f6738S.f6862r0);
                    } else {
                        this.M.a(1.0f, 0, this.f6738S.q0);
                    }
                    this.f6734N.a(fMin, 0, null);
                    return;
                }
                if (i11 == 1) {
                    this.M.a(0.0f, 20, this.f6738S.f6862r0);
                    this.f6734N.a(1.0f, 0, null);
                    return;
                } else {
                    if (i11 == 0) {
                        this.M.a(1.0f, 0, this.f6738S.q0);
                        this.f6734N.a(0.0f, 0, null);
                        return;
                    }
                    return;
                }
            }
            measuredHeight = this.P.getMeasuredHeight();
        }
        i7 = measuredHeight;
        i8 = i6 - i4;
        i9 = i8 - i7;
        paddingStart = getPaddingStart();
        measuredHeight2 = this.f6744t.getMeasuredHeight();
        i10 = (((i6 - i7) - i4) - measuredHeight2) / 2;
        linearLayout = this.f6744t;
        if (linearLayout != null) {
            g(this.f6744t, paddingStart, i10, measuredHeight2, false);
        }
        paddingEnd = (i5 - i2) - getPaddingEnd();
        cVar = this.f6931i;
        if (cVar != null) {
            h(this.f6931i, paddingEnd);
        }
        if (this.f6727E) {
        }
        frameLayout = this.P;
        if (frameLayout != null) {
            FrameLayout frameLayout22 = this.P;
            frameLayout22.layout(i2, i8 - frameLayout22.getMeasuredHeight(), i5, i8);
            if (!(getLayoutDirection() != 1)) {
            }
            Rect rect2 = new Rect();
            rect2.set(measuredWidth, this.P.getMeasuredHeight() - (i8 - i9), this.P.getMeasuredWidth() + measuredWidth, this.P.getMeasuredHeight());
            this.P.setClipBounds(rect2);
        }
        float fMin2 = 1.0f - Math.min(1.0f, ((this.P.getMeasuredHeight() - i7) / this.P.getMeasuredHeight()) * 3.0f);
        i11 = this.p;
        if (i11 != 2) {
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        int measuredHeight;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.f6936n;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i4);
        }
        ActionBarView actionBarView = this.f6738S;
        if (actionBarView != null) {
            size2 = actionBarView.f6877z0;
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2 - paddingBottom, Integer.MIN_VALUE);
        miuix.appcompat.internal.view.menu.action.c cVar = this.f6931i;
        if (cVar == null || cVar.getParent() != this) {
            measuredHeight = 0;
        } else {
            paddingLeft = d(this.f6931i, paddingLeft, iMakeMeasureSpec, 0);
            measuredHeight = this.f6931i.getMeasuredHeight() + 0;
        }
        LinearLayout linearLayout = this.f6744t;
        if (linearLayout != null && linearLayout.getVisibility() != 8) {
            this.f6744t.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), iMakeMeasureSpec);
            measuredHeight += this.f6744t.getMeasuredHeight();
            TextView textView = this.f6746w;
            textView.setVisibility((!super.c() && super.b() == 0) || (textView.getPaint().measureText(this.f6743s.toString()) > ((float) this.f6746w.getMeasuredWidth()) ? 1 : (textView.getPaint().measureText(this.f6743s.toString()) == ((float) this.f6746w.getMeasuredWidth()) ? 0 : -1)) <= 0 ? 0 : 4);
        }
        if (size2 <= 0) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                int measuredHeight2 = getChildAt(i6).getMeasuredHeight() + paddingBottom;
                if (measuredHeight2 > i5) {
                    i5 = measuredHeight2;
                }
            }
            setMeasuredDimension(size, i5 > 0 ? 0 + i5 : 0);
            return;
        }
        this.f6737R = measuredHeight > 0 ? size2 + 0 : 0;
        this.P.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int i7 = this.p;
        if (i7 == 2) {
            setMeasuredDimension(size, this.f6737R + this.f6736Q);
        } else if (i7 == 1) {
            setMeasuredDimension(size, this.P.getMeasuredHeight() + this.f6737R);
        } else {
            setMeasuredDimension(size, this.f6737R);
        }
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.f6743s = eVar.f6759i;
        C();
        CharSequence charSequence = eVar.f6760j;
        C();
        Button button = this.f6745v;
        if (button != null) {
            button.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
            this.f6745v.setText(charSequence);
        }
        this.f6724B.setTitle(charSequence);
        if (eVar.f6761k) {
            post(new miuix.appcompat.internal.app.widget.a(this));
        }
        super.j(eVar.f6762l, false);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        eVar.f6761k = bVar != null && bVar.m();
        eVar.f6759i = this.f6743s;
        Button button = this.f6745v;
        if (button != null) {
            eVar.f6760j = button.getText();
        }
        int i2 = this.p;
        if (i2 == 2) {
            eVar.f6762l = 0;
        } else {
            eVar.f6762l = i2;
        }
        return eVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }
}
