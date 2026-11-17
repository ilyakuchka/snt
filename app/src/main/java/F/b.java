package F;

import F.d;
import android.R;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import miuix.appcompat.internal.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f113a;

    /* renamed from: b, reason: collision with root package name */
    public int f114b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f115c = -1;

    public static class a {
        public static final a d;

        /* renamed from: e, reason: collision with root package name */
        public static final a f116e;

        /* renamed from: f, reason: collision with root package name */
        public static final a f117f;
        public static final a g;

        /* renamed from: h, reason: collision with root package name */
        public static final a f118h;

        /* renamed from: i, reason: collision with root package name */
        public static final a f119i;

        /* renamed from: a, reason: collision with root package name */
        final Object f120a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<? extends d.a> f121b;

        /* renamed from: c, reason: collision with root package name */
        protected final F.d f122c;

        static {
            new a(null, 1, null);
            new a(null, 2, null);
            new a(null, 4, null);
            new a(null, 8, null);
            d = new a(null, 16, null);
            new a(null, 32, null);
            new a(null, 64, null);
            new a(null, 128, null);
            new a(null, 256, d.b.class);
            new a(null, 512, d.b.class);
            new a(null, 1024, d.c.class);
            new a(null, 2048, d.c.class);
            f116e = new a(null, 4096, null);
            f117f = new a(null, 8192, null);
            new a(null, 16384, null);
            new a(null, 32768, null);
            new a(null, 65536, null);
            new a(null, 131072, d.g.class);
            new a(null, 262144, null);
            new a(null, 524288, null);
            new a(null, 1048576, null);
            new a(null, 2097152, d.h.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, d.e.class);
            g = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null);
            f118h = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null);
            f119i = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, d.f.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, d.C0006d.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, R.id.accessibilityActionPressAndHold, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, R.id.accessibilityActionImeEnter, null);
        }

        public a(int i2) {
            this(null, i2, null);
        }

        public final int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f120a).getId();
        }

        public final boolean b(View view) {
            if (this.f122c == null) {
                return false;
            }
            Class<? extends d.a> cls = this.f121b;
            if (cls != null) {
                try {
                    Objects.requireNonNull(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e2) {
                    Class<? extends d.a> cls2 = this.f121b;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e2);
                }
            }
            return this.f122c.a();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f120a;
            return obj2 == null ? aVar.f120a == null : obj2.equals(aVar.f120a);
        }

        public final int hashCode() {
            Object obj = this.f120a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        a(Object obj, int i2, Class cls) {
            this.f122c = null;
            if (obj == null) {
                this.f120a = new AccessibilityNodeInfo.AccessibilityAction(i2, null);
            } else {
                this.f120a = obj;
            }
            this.f121b = cls;
        }
    }

    /* renamed from: F.b$b, reason: collision with other inner class name */
    public static class C0004b {

        /* renamed from: a, reason: collision with root package name */
        final Object f123a;

        C0004b(Object obj) {
            this.f123a = obj;
        }

        public static C0004b a(int i2, int i4) {
            return new C0004b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i4, false, 0));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final Object f124a;

        c(Object obj) {
            this.f124a = obj;
        }

        public static c a(int i2, int i4, int i5, int i6, boolean z4) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i4, i5, i6, z4, false));
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        final Object f125a;

        d(Object obj) {
            this.f125a = obj;
        }

        public static d a(float f4, float f5) {
            return new d(AccessibilityNodeInfo.RangeInfo.obtain(0, -1.0f, f4, f5));
        }
    }

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f113a = accessibilityNodeInfo;
    }

    public static b a0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    private List<Integer> d(String str) {
        ArrayList<Integer> integerArrayList = this.f113a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f113a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String e(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case MenuBuilder.CATEGORY_SHIFT /* 16 */:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionImeEnter:
                return "ACTION_IME_ENTER";
            default:
                switch (i2) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static ClickableSpan[] k(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static b t() {
        return new b(AccessibilityNodeInfo.obtain());
    }

    public static b u(b bVar) {
        return new b(AccessibilityNodeInfo.obtain(bVar.f113a));
    }

    public static b v(View view) {
        return new b(AccessibilityNodeInfo.obtain(view));
    }

    @Deprecated
    public final void A(Rect rect) {
        this.f113a.setBoundsInParent(rect);
    }

    public final void B(Rect rect) {
        this.f113a.setBoundsInScreen(rect);
    }

    public final void C(boolean z4) {
        this.f113a.setCheckable(z4);
    }

    public final void D(boolean z4) {
        this.f113a.setChecked(z4);
    }

    public final void E(CharSequence charSequence) {
        this.f113a.setClassName(charSequence);
    }

    public final void F(boolean z4) {
        this.f113a.setClickable(z4);
    }

    public final void G(Object obj) {
        this.f113a.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) ((C0004b) obj).f123a);
    }

    public final void H(Object obj) {
        this.f113a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f124a);
    }

    public final void I(CharSequence charSequence) {
        this.f113a.setContentDescription(charSequence);
    }

    public final void J() {
        this.f113a.setEnabled(true);
    }

    public final void K() {
        this.f113a.setFocusable(true);
    }

    public final void L(boolean z4) {
        this.f113a.setFocused(z4);
    }

    public final void M(boolean z4) {
        this.f113a.setHeading(z4);
    }

    public final void N(CharSequence charSequence) {
        this.f113a.setPackageName(charSequence);
    }

    public final void O(CharSequence charSequence) {
        this.f113a.setPaneTitle(charSequence);
    }

    public final void P(View view) {
        this.f114b = -1;
        this.f113a.setParent(view);
    }

    public final void Q(View view) {
        this.f114b = -1;
        this.f113a.setParent(view, -1);
    }

    public final void R(d dVar) {
        this.f113a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) dVar.f125a);
    }

    public final void S(CharSequence charSequence) {
        this.f113a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public final void T(boolean z4) {
        this.f113a.setScreenReaderFocusable(z4);
    }

    public final void U(boolean z4) {
        this.f113a.setScrollable(z4);
    }

    public final void V(boolean z4) {
        this.f113a.setSelected(z4);
    }

    public final void W(View view, int i2) {
        this.f115c = i2;
        this.f113a.setSource(view, i2);
    }

    public final void X(CharSequence charSequence) {
        this.f113a.setStateDescription(charSequence);
    }

    public final void Y() {
        this.f113a.setVisibleToUser(true);
    }

    public final AccessibilityNodeInfo Z() {
        return this.f113a;
    }

    public final void a(int i2) {
        this.f113a.addAction(i2);
    }

    public final void b(a aVar) {
        this.f113a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f120a);
    }

    public final void c(View view, int i2) {
        this.f113a.addChild(view, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f113a;
        if (accessibilityNodeInfo == null) {
            if (bVar.f113a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(bVar.f113a)) {
            return false;
        }
        return this.f115c == bVar.f115c && this.f114b == bVar.f114b;
    }

    public final int f() {
        return this.f113a.getActions();
    }

    @Deprecated
    public final void g(Rect rect) {
        this.f113a.getBoundsInParent(rect);
    }

    public final void h(Rect rect) {
        this.f113a.getBoundsInScreen(rect);
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f113a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final int i() {
        return this.f113a.getChildCount();
    }

    public final CharSequence j() {
        return this.f113a.getClassName();
    }

    public final CharSequence l() {
        return this.f113a.getContentDescription();
    }

    public final Bundle m() {
        return this.f113a.getExtras();
    }

    public final CharSequence n() {
        if (!(!d("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty())) {
            return this.f113a.getText();
        }
        List<Integer> listD = d("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listD2 = d("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listD3 = d("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listD4 = d("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f113a.getText(), 0, this.f113a.getText().length()));
        for (int i2 = 0; i2 < listD.size(); i2++) {
            spannableString.setSpan(new F.a(listD4.get(i2).intValue(), this, m().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listD.get(i2).intValue(), listD2.get(i2).intValue(), listD3.get(i2).intValue());
        }
        return spannableString;
    }

    public final boolean o() {
        return this.f113a.isChecked();
    }

    public final boolean p() {
        return this.f113a.isEnabled();
    }

    public final boolean q() {
        return this.f113a.isFocusable();
    }

    public final boolean r() {
        return this.f113a.isPassword();
    }

    public final boolean s() {
        return this.f113a.isScrollable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.ArrayList] */
    public final String toString() {
        ?? EmptyList;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        g(rect);
        sb.append("; boundsInParent: " + rect);
        this.f113a.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(this.f113a.getPackageName());
        sb.append("; className: ");
        sb.append(this.f113a.getClassName());
        sb.append("; text: ");
        sb.append(n());
        sb.append("; contentDescription: ");
        sb.append(l());
        sb.append("; viewId: ");
        sb.append(this.f113a.getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(this.f113a.isCheckable());
        sb.append("; checked: ");
        sb.append(this.f113a.isChecked());
        sb.append("; focusable: ");
        sb.append(this.f113a.isFocusable());
        sb.append("; focused: ");
        sb.append(this.f113a.isFocused());
        sb.append("; selected: ");
        sb.append(this.f113a.isSelected());
        sb.append("; clickable: ");
        sb.append(this.f113a.isClickable());
        sb.append("; longClickable: ");
        sb.append(this.f113a.isLongClickable());
        sb.append("; enabled: ");
        sb.append(this.f113a.isEnabled());
        sb.append("; password: ");
        sb.append(this.f113a.isPassword());
        sb.append("; scrollable: " + this.f113a.isScrollable());
        sb.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f113a.getActionList();
        if (actionList != null) {
            EmptyList = new ArrayList();
            int size = actionList.size();
            for (int i2 = 0; i2 < size; i2++) {
                EmptyList.add(new a(actionList.get(i2), 0, null));
            }
        } else {
            EmptyList = Collections.emptyList();
        }
        for (int i4 = 0; i4 < EmptyList.size(); i4++) {
            a aVar = (a) EmptyList.get(i4);
            String strE = e(((AccessibilityNodeInfo.AccessibilityAction) aVar.f120a).getId());
            if (strE.equals("ACTION_UNKNOWN") && ((AccessibilityNodeInfo.AccessibilityAction) aVar.f120a).getLabel() != null) {
                strE = ((AccessibilityNodeInfo.AccessibilityAction) aVar.f120a).getLabel().toString();
            }
            sb.append(strE);
            if (i4 != EmptyList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final boolean w(int i2, Bundle bundle) {
        return this.f113a.performAction(i2, bundle);
    }

    public final void x() {
        this.f113a.recycle();
    }

    public final boolean y(a aVar) {
        return this.f113a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f120a);
    }

    public final void z(boolean z4) {
        this.f113a.setAccessibilityFocused(z4);
    }
}
