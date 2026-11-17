package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import i.C0333a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import x.C0412a;

/* loaded from: classes.dex */
public final class U {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2944a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f2945b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f2946c;

    private U(Context context, TypedArray typedArray) {
        this.f2944a = context;
        this.f2945b = typedArray;
    }

    public static U s(Context context, int i2, int[] iArr) {
        return new U(context, context.obtainStyledAttributes(i2, iArr));
    }

    public static U t(Context context, AttributeSet attributeSet, int[] iArr) {
        return new U(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static U u(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i4) {
        return new U(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i4));
    }

    public final boolean a(int i2, boolean z4) {
        return this.f2945b.getBoolean(i2, z4);
    }

    public final int b() {
        return this.f2945b.getColor(0, 0);
    }

    public final ColorStateList c(int i2) {
        int resourceId;
        if (this.f2945b.hasValue(i2) && (resourceId = this.f2945b.getResourceId(i2, 0)) != 0) {
            Context context = this.f2944a;
            int i4 = C0333a.f6334b;
            ColorStateList colorStateList = context.getColorStateList(resourceId);
            if (colorStateList != null) {
                return colorStateList;
            }
        }
        return this.f2945b.getColorStateList(i2);
    }

    public final int d(int i2, int i4) {
        return this.f2945b.getDimensionPixelOffset(i2, i4);
    }

    public final int e(int i2, int i4) {
        return this.f2945b.getDimensionPixelSize(i2, i4);
    }

    public final Drawable f(int i2) {
        int resourceId;
        return (!this.f2945b.hasValue(i2) || (resourceId = this.f2945b.getResourceId(i2, 0)) == 0) ? this.f2945b.getDrawable(i2) : C0333a.a(this.f2944a, resourceId);
    }

    public final Drawable g(int i2) {
        int resourceId;
        if (!this.f2945b.hasValue(i2) || (resourceId = this.f2945b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return C0187h.b().d(this.f2944a, resourceId);
    }

    public final float h() {
        return this.f2945b.getFloat(4, -1.0f);
    }

    public final Typeface i(int i2, int i4, x.d dVar) throws Resources.NotFoundException {
        int resourceId = this.f2945b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f2946c == null) {
            this.f2946c = new TypedValue();
        }
        Context context = this.f2944a;
        TypedValue typedValue = this.f2946c;
        if (context.isRestricted()) {
            return null;
        }
        Resources resources = context.getResources();
        resources.getValue(resourceId, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            StringBuilder sbD = D2.e.d("Resource \"");
            sbD.append(resources.getResourceName(resourceId));
            sbD.append("\" (");
            sbD.append(Integer.toHexString(resourceId));
            sbD.append(") is not a Font: ");
            sbD.append(typedValue);
            throw new Resources.NotFoundException(sbD.toString());
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            dVar.a();
            return null;
        }
        Typeface typefaceE = y.c.e(resources, resourceId, i4);
        if (typefaceE != null) {
            dVar.b(typefaceE);
            return typefaceE;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceC = y.c.c(resources, resourceId, i4);
                if (typefaceC != null) {
                    dVar.b(typefaceC);
                } else {
                    dVar.a();
                }
                return typefaceC;
            }
            C0412a.InterfaceC0143a interfaceC0143aA = C0412a.a(resources.getXml(resourceId), resources);
            if (interfaceC0143aA != null) {
                return y.c.b(context, interfaceC0143aA, resources, resourceId, i4, dVar);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            dVar.a();
            return null;
        } catch (IOException e2) {
            Log.e("ResourcesCompat", "Failed to read xml resource " + string, e2);
            dVar.a();
            return null;
        } catch (XmlPullParserException e4) {
            Log.e("ResourcesCompat", "Failed to parse xml resource " + string, e4);
            dVar.a();
            return null;
        }
    }

    public final int j(int i2, int i4) {
        return this.f2945b.getInt(i2, i4);
    }

    public final int k(int i2, int i4) {
        return this.f2945b.getInteger(i2, i4);
    }

    public final int l(int i2, int i4) {
        return this.f2945b.getLayoutDimension(i2, i4);
    }

    public final int m(int i2, int i4) {
        return this.f2945b.getResourceId(i2, i4);
    }

    public final String n(int i2) {
        return this.f2945b.getString(i2);
    }

    public final CharSequence o(int i2) {
        return this.f2945b.getText(i2);
    }

    public final CharSequence[] p() {
        return this.f2945b.getTextArray(0);
    }

    public final TypedArray q() {
        return this.f2945b;
    }

    public final boolean r(int i2) {
        return this.f2945b.hasValue(i2);
    }

    public final void v() {
        this.f2945b.recycle();
    }
}
