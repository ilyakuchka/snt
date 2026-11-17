package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.widget.C0187h;
import com.android.mmt.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import w.C0405a;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: i, reason: collision with root package name */
    private static L f2796i;

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<Context, q.h<ColorStateList>> f2798a;

    /* renamed from: b, reason: collision with root package name */
    private q.g<String, b> f2799b;

    /* renamed from: c, reason: collision with root package name */
    private q.h<String> f2800c;
    private final WeakHashMap<Context, q.e<WeakReference<Drawable.ConstantState>>> d = new WeakHashMap<>(0);

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f2801e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2802f;
    private c g;

    /* renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f2795h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    private static final a f2797j = new a();

    private static class a extends q.f<Integer, PorterDuffColorFilter> {
        public a() {
            super(6);
        }
    }

    private interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        q.e<WeakReference<Drawable.ConstantState>> eVar = this.d.get(context);
        if (eVar == null) {
            eVar = new q.e<>();
            this.d.put(context, eVar);
        }
        eVar.e(j2, new WeakReference<>(constantState));
        return true;
    }

    private Drawable b(Context context, int i2) throws Resources.NotFoundException {
        if (this.f2801e == null) {
            this.f2801e = new TypedValue();
        }
        TypedValue typedValue = this.f2801e;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable drawableD = d(context, j2);
        if (drawableD != null) {
            return drawableD;
        }
        c cVar = this.g;
        Drawable drawableC = cVar == null ? null : ((C0187h.a) cVar).c(this, context, i2);
        if (drawableC != null) {
            drawableC.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, j2, drawableC);
        }
        return drawableC;
    }

    public static synchronized L c() {
        if (f2796i == null) {
            f2796i = new L();
        }
        return f2796i;
    }

    private synchronized Drawable d(Context context, long j2) {
        q.e<WeakReference<Drawable.ConstantState>> eVar = this.d.get(context);
        if (eVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceD = eVar.d(j2, null);
        if (weakReferenceD != null) {
            Drawable.ConstantState constantState = weakReferenceD.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            eVar.f(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter g(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterB;
        a aVar = f2797j;
        Objects.requireNonNull(aVar);
        int i4 = (i2 + 31) * 31;
        porterDuffColorFilterB = aVar.b(Integer.valueOf(mode.hashCode() + i4));
        if (porterDuffColorFilterB == null) {
            porterDuffColorFilterB = new PorterDuffColorFilter(i2, mode);
            Objects.requireNonNull(aVar);
            aVar.c(Integer.valueOf(mode.hashCode() + i4), porterDuffColorFilterB);
        }
        return porterDuffColorFilterB;
    }

    private Drawable i(Context context, int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        q.g<String, b> gVar = this.f2799b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        q.h<String> hVar = this.f2800c;
        if (hVar != null) {
            String strE = hVar.e(i2, null);
            if ("appcompat_skip_skip".equals(strE) || (strE != null && this.f2799b.getOrDefault(strE, null) == null)) {
                return null;
            }
        } else {
            this.f2800c = new q.h<>();
        }
        if (this.f2801e == null) {
            this.f2801e = new TypedValue();
        }
        TypedValue typedValue = this.f2801e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long j2 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable drawableD = d(context, j2);
        if (drawableD != null) {
            return drawableD;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f2800c.a(i2, name);
                b orDefault = this.f2799b.getOrDefault(name, null);
                if (orDefault != null) {
                    drawableD = orDefault.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableD != null) {
                    drawableD.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, j2, drawableD);
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (drawableD == null) {
            this.f2800c.a(i2, "appcompat_skip_skip");
        }
        return drawableD;
    }

    private Drawable l(Context context, int i2, boolean z4, Drawable drawable) {
        ColorStateList colorStateListH = h(context, i2);
        PorterDuff.Mode mode = null;
        if (colorStateListH == null) {
            c cVar = this.g;
            if (cVar != null && ((C0187h.a) cVar).g(context, i2, drawable)) {
                return drawable;
            }
            c cVar2 = this.g;
            if ((cVar2 != null && ((C0187h.a) cVar2).h(context, i2, drawable)) || !z4) {
                return drawable;
            }
            return null;
        }
        if (C.a(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setTintList(colorStateListH);
        if (this.g != null && i2 == R.drawable.abc_switch_thumb_material) {
            mode = PorterDuff.Mode.MULTIPLY;
        }
        if (mode == null) {
            return drawable;
        }
        drawable.setTintMode(mode);
        return drawable;
    }

    static void m(Drawable drawable, S s2, int[] iArr) {
        if (C.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z4 = s2.d;
        if (!z4 && !s2.f2817c) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterG = null;
        ColorStateList colorStateList = z4 ? s2.f2815a : null;
        PorterDuff.Mode mode = s2.f2817c ? s2.f2816b : f2795h;
        if (colorStateList != null && mode != null) {
            porterDuffColorFilterG = g(colorStateList.getColorForState(iArr, 0), mode);
        }
        drawable.setColorFilter(porterDuffColorFilterG);
    }

    public final synchronized Drawable e(Context context, int i2) {
        return f(context, i2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r0 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final synchronized Drawable f(Context context, int i2, boolean z4) {
        Drawable drawableI;
        if (!this.f2802f) {
            boolean z5 = true;
            this.f2802f = true;
            Drawable drawableE = e(context, R.drawable.abc_vector_test);
            if (drawableE != null) {
                if (!(drawableE instanceof Z.b) && !"android.graphics.drawable.VectorDrawable".equals(drawableE.getClass().getName())) {
                    z5 = false;
                }
            }
            this.f2802f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
        drawableI = i(context, i2);
        if (drawableI == null) {
            drawableI = b(context, i2);
        }
        if (drawableI == null) {
            int i4 = C0405a.f7979b;
            drawableI = context.getDrawable(i2);
        }
        if (drawableI != null) {
            drawableI = l(context, i2, z4, drawableI);
        }
        if (drawableI != null) {
            Rect rect = C.f2715a;
        }
        return drawableI;
    }

    final synchronized ColorStateList h(Context context, int i2) {
        ColorStateList colorStateListE;
        q.h<ColorStateList> hVar;
        WeakHashMap<Context, q.h<ColorStateList>> weakHashMap = this.f2798a;
        ColorStateList colorStateListE2 = null;
        colorStateListE = (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) ? null : hVar.e(i2, null);
        if (colorStateListE == null) {
            c cVar = this.g;
            if (cVar != null) {
                colorStateListE2 = ((C0187h.a) cVar).e(context, i2);
            }
            if (colorStateListE2 != null) {
                if (this.f2798a == null) {
                    this.f2798a = new WeakHashMap<>();
                }
                q.h<ColorStateList> hVar2 = this.f2798a.get(context);
                if (hVar2 == null) {
                    hVar2 = new q.h<>();
                    this.f2798a.put(context, hVar2);
                }
                hVar2.a(i2, colorStateListE2);
            }
            colorStateListE = colorStateListE2;
        }
        return colorStateListE;
    }

    public final synchronized void j(Context context) {
        q.e<WeakReference<Drawable.ConstantState>> eVar = this.d.get(context);
        if (eVar != null) {
            eVar.a();
        }
    }

    public final synchronized void k(c cVar) {
        this.g = cVar;
    }
}
