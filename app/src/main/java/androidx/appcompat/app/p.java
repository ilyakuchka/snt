package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0183d;
import androidx.appcompat.widget.C0185f;
import androidx.appcompat.widget.C0188i;
import androidx.appcompat.widget.C0190k;
import androidx.appcompat.widget.C0192m;
import androidx.appcompat.widget.C0195p;
import androidx.appcompat.widget.C0199u;
import androidx.appcompat.widget.C0204z;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f2410b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f2411c = {R.attr.onClick};
    private static final String[] d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e, reason: collision with root package name */
    private static final q.g<String, Constructor<? extends View>> f2412e = new q.g<>();

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f2413a = new Object[2];

    private static class a implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        private final View f2414i;

        /* renamed from: j, reason: collision with root package name */
        private final String f2415j;

        /* renamed from: k, reason: collision with root package name */
        private Method f2416k;

        /* renamed from: l, reason: collision with root package name */
        private Context f2417l;

        public a(View view, String str) {
            this.f2414i = view;
            this.f2415j = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            String string;
            Method method;
            if (this.f2416k == null) {
                Context context = this.f2414i.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.f2415j, View.class)) != null) {
                            this.f2416k = method;
                            this.f2417l = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                int id = this.f2414i.getId();
                if (id == -1) {
                    string = "";
                } else {
                    StringBuilder sbD = D2.e.d(" with id '");
                    sbD.append(this.f2414i.getContext().getResources().getResourceEntryName(id));
                    sbD.append("'");
                    string = sbD.toString();
                }
                StringBuilder sbD2 = D2.e.d("Could not find method ");
                sbD2.append(this.f2415j);
                sbD2.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                sbD2.append(this.f2414i.getClass());
                sbD2.append(string);
                throw new IllegalStateException(sbD2.toString());
            }
            try {
                this.f2416k.invoke(this.f2417l, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException("Could not execute method for android:onClick", e4);
            }
        }
    }

    private View b(Context context, String str, String str2) throws InflateException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String str3;
        q.g<String, Constructor<? extends View>> gVar = f2412e;
        Constructor<? extends View> orDefault = gVar.getOrDefault(str, null);
        if (orDefault == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            orDefault = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f2410b);
            gVar.put(str, orDefault);
        }
        orDefault.setAccessible(true);
        return orDefault.newInstance(this.f2413a);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        View c0195p;
        char c2 = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2086D, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        Context dVar = (resourceId == 0 || ((context instanceof l.d) && ((l.d) context).b() == resourceId)) ? context : new l.d(context, resourceId);
        Objects.requireNonNull(str);
        switch (str.hashCode()) {
            case -1946472170:
                if (!str.equals("RatingBar")) {
                    c2 = 65535;
                    break;
                } else {
                    c2 = 0;
                    break;
                }
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 3;
                    break;
                }
                break;
            case -937446323:
                if (!str.equals("ImageButton")) {
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = '\r';
                    break;
                }
                break;
        }
        View view2 = null;
        switch (c2) {
            case 0:
                c0195p = new C0195p(dVar, attributeSet);
                break;
            case 1:
                c0195p = new C0185f(dVar, attributeSet);
                break;
            case 2:
                c0195p = new C0192m(dVar, attributeSet);
                break;
            case 3:
                c0195p = new AppCompatTextView(dVar, attributeSet);
                break;
            case 4:
                c0195p = new C0190k(dVar, attributeSet, com.android.mmt.R.attr.imageButtonStyle);
                break;
            case 5:
                c0195p = new androidx.appcompat.widget.r(dVar, attributeSet);
                break;
            case 6:
                c0195p = new C0199u(dVar, attributeSet);
                break;
            case 7:
                c0195p = new AppCompatRadioButton(dVar, attributeSet);
                break;
            case '\b':
                c0195p = new C0204z(dVar, attributeSet);
                break;
            case '\t':
                c0195p = new AppCompatImageView(dVar, attributeSet);
                break;
            case '\n':
                c0195p = new C0183d(dVar, attributeSet);
                break;
            case 11:
                c0195p = new AppCompatCheckBox(dVar, attributeSet);
                break;
            case '\f':
                c0195p = new C0188i(dVar, attributeSet);
                break;
            case '\r':
                c0195p = new AppCompatButton(dVar, attributeSet);
                break;
            default:
                c0195p = null;
                break;
        }
        if (c0195p == null && context != dVar) {
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                Object[] objArr = this.f2413a;
                objArr[0] = dVar;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = d;
                        if (i2 < 3) {
                            View viewB = b(dVar, str, strArr[i2]);
                            if (viewB != null) {
                                Object[] objArr2 = this.f2413a;
                                objArr2[0] = null;
                                objArr2[1] = null;
                                view2 = viewB;
                            } else {
                                i2++;
                            }
                        }
                    }
                } else {
                    View viewB2 = b(dVar, str, null);
                    Object[] objArr3 = this.f2413a;
                    objArr3[0] = null;
                    objArr3[1] = null;
                    view2 = viewB2;
                }
            } catch (Exception unused) {
            } finally {
                Object[] objArr4 = this.f2413a;
                objArr4[0] = null;
                objArr4[1] = null;
            }
            c0195p = view2;
        }
        if (c0195p != null) {
            Context context2 = c0195p.getContext();
            if (context2 instanceof ContextWrapper) {
                int i4 = androidx.core.view.o.d;
                if (c0195p.hasOnClickListeners()) {
                    TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, f2411c);
                    String string = typedArrayObtainStyledAttributes2.getString(0);
                    if (string != null) {
                        c0195p.setOnClickListener(new a(c0195p, string));
                    }
                    typedArrayObtainStyledAttributes2.recycle();
                }
            }
        }
        return c0195p;
    }
}
