package l;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.C;
import androidx.appcompat.widget.U;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    static final Class<?>[] f6471e;

    /* renamed from: f, reason: collision with root package name */
    static final Class<?>[] f6472f;

    /* renamed from: a, reason: collision with root package name */
    final Object[] f6473a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f6474b;

    /* renamed from: c, reason: collision with root package name */
    Context f6475c;
    private Object d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: k, reason: collision with root package name */
        private static final Class<?>[] f6476k = {MenuItem.class};

        /* renamed from: i, reason: collision with root package name */
        private Object f6477i;

        /* renamed from: j, reason: collision with root package name */
        private Method f6478j;

        public a(Object obj, String str) {
            this.f6477i = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f6478j = cls.getMethod(str, f6476k);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f6478j.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f6478j.invoke(this.f6477i, menuItem)).booleanValue();
                }
                this.f6478j.invoke(this.f6477i, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class b {

        /* renamed from: A, reason: collision with root package name */
        private CharSequence f6479A;

        /* renamed from: B, reason: collision with root package name */
        private CharSequence f6480B;

        /* renamed from: a, reason: collision with root package name */
        private Menu f6484a;

        /* renamed from: h, reason: collision with root package name */
        private boolean f6489h;

        /* renamed from: i, reason: collision with root package name */
        private int f6490i;

        /* renamed from: j, reason: collision with root package name */
        private int f6491j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f6492k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f6493l;

        /* renamed from: m, reason: collision with root package name */
        private int f6494m;

        /* renamed from: n, reason: collision with root package name */
        private char f6495n;

        /* renamed from: o, reason: collision with root package name */
        private int f6496o;
        private char p;

        /* renamed from: q, reason: collision with root package name */
        private int f6497q;

        /* renamed from: r, reason: collision with root package name */
        private int f6498r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f6499s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f6500t;
        private boolean u;

        /* renamed from: v, reason: collision with root package name */
        private int f6501v;

        /* renamed from: w, reason: collision with root package name */
        private int f6502w;

        /* renamed from: x, reason: collision with root package name */
        private String f6503x;

        /* renamed from: y, reason: collision with root package name */
        private String f6504y;

        /* renamed from: z, reason: collision with root package name */
        androidx.core.view.b f6505z;

        /* renamed from: C, reason: collision with root package name */
        private ColorStateList f6481C = null;

        /* renamed from: D, reason: collision with root package name */
        private PorterDuff.Mode f6482D = null;

        /* renamed from: b, reason: collision with root package name */
        private int f6485b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f6486c = 0;
        private int d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f6487e = 0;

        /* renamed from: f, reason: collision with root package name */
        private boolean f6488f = true;
        private boolean g = true;

        public b(Menu menu) {
            this.f6484a = menu;
        }

        private <T> T d(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f6475c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void h(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z4 = false;
            menuItem.setChecked(this.f6499s).setVisible(this.f6500t).setEnabled(this.u).setCheckable(this.f6498r >= 1).setTitleCondensed(this.f6493l).setIcon(this.f6494m);
            int i2 = this.f6501v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.f6504y != null) {
                if (g.this.f6475c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f6504y));
            }
            if (this.f6498r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.h) {
                    ((androidx.appcompat.view.menu.h) menuItem).r(true);
                } else if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).h();
                }
            }
            String str = this.f6503x;
            if (str != null) {
                menuItem.setActionView((View) d(str, g.f6471e, g.this.f6473a));
                z4 = true;
            }
            int i4 = this.f6502w;
            if (i4 > 0) {
                if (z4) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i4);
                }
            }
            androidx.core.view.b bVar = this.f6505z;
            if (bVar != null) {
                if (menuItem instanceof A.b) {
                    ((A.b) menuItem).a(bVar);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.f6479A;
            boolean z5 = menuItem instanceof A.b;
            if (z5) {
                ((A.b) menuItem).setContentDescription(charSequence);
            } else {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.f6480B;
            if (z5) {
                ((A.b) menuItem).setTooltipText(charSequence2);
            } else {
                menuItem.setTooltipText(charSequence2);
            }
            char c2 = this.f6495n;
            int i5 = this.f6496o;
            if (z5) {
                ((A.b) menuItem).setAlphabeticShortcut(c2, i5);
            } else {
                menuItem.setAlphabeticShortcut(c2, i5);
            }
            char c4 = this.p;
            int i6 = this.f6497q;
            if (z5) {
                ((A.b) menuItem).setNumericShortcut(c4, i6);
            } else {
                menuItem.setNumericShortcut(c4, i6);
            }
            PorterDuff.Mode mode = this.f6482D;
            if (mode != null) {
                if (z5) {
                    ((A.b) menuItem).setIconTintMode(mode);
                } else {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.f6481C;
            if (colorStateList != null) {
                if (z5) {
                    ((A.b) menuItem).setIconTintList(colorStateList);
                } else {
                    menuItem.setIconTintList(colorStateList);
                }
            }
        }

        public final void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f6489h = true;
            h(this.f6484a.add(this.f6485b, this.f6490i, this.f6491j, this.f6492k));
        }

        public final SubMenu b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f6489h = true;
            SubMenu subMenuAddSubMenu = this.f6484a.addSubMenu(this.f6485b, this.f6490i, this.f6491j, this.f6492k);
            h(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final boolean c() {
            return this.f6489h;
        }

        public final void e(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f6475c.obtainStyledAttributes(attributeSet, Y1.a.f2126t);
            this.f6485b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
            this.f6486c = typedArrayObtainStyledAttributes.getInt(3, 0);
            this.d = typedArrayObtainStyledAttributes.getInt(4, 0);
            this.f6487e = typedArrayObtainStyledAttributes.getInt(5, 0);
            this.f6488f = typedArrayObtainStyledAttributes.getBoolean(2, true);
            this.g = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public final void f(AttributeSet attributeSet) {
            U uT = U.t(g.this.f6475c, attributeSet, Y1.a.u);
            this.f6490i = uT.m(2, 0);
            this.f6491j = (uT.j(5, this.f6486c) & MenuBuilder.CATEGORY_MASK) | (uT.j(6, this.d) & MenuBuilder.USER_MASK);
            this.f6492k = uT.o(7);
            this.f6493l = uT.o(8);
            this.f6494m = uT.m(0, 0);
            String strN = uT.n(9);
            this.f6495n = strN == null ? (char) 0 : strN.charAt(0);
            this.f6496o = uT.j(16, 4096);
            String strN2 = uT.n(10);
            this.p = strN2 == null ? (char) 0 : strN2.charAt(0);
            this.f6497q = uT.j(20, 4096);
            if (uT.r(11)) {
                this.f6498r = uT.a(11, false) ? 1 : 0;
            } else {
                this.f6498r = this.f6487e;
            }
            this.f6499s = uT.a(3, false);
            this.f6500t = uT.a(4, this.f6488f);
            this.u = uT.a(1, this.g);
            this.f6501v = uT.j(21, -1);
            this.f6504y = uT.n(12);
            this.f6502w = uT.m(13, 0);
            this.f6503x = uT.n(15);
            String strN3 = uT.n(14);
            boolean z4 = strN3 != null;
            if (z4 && this.f6502w == 0 && this.f6503x == null) {
                this.f6505z = (androidx.core.view.b) d(strN3, g.f6472f, g.this.f6474b);
            } else {
                if (z4) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f6505z = null;
            }
            this.f6479A = uT.o(17);
            this.f6480B = uT.o(22);
            if (uT.r(19)) {
                this.f6482D = C.c(uT.j(19, -1), this.f6482D);
            } else {
                this.f6482D = null;
            }
            if (uT.r(18)) {
                this.f6481C = uT.c(18);
            } else {
                this.f6481C = null;
            }
            uT.v();
            this.f6489h = false;
        }

        public final void g() {
            this.f6485b = 0;
            this.f6486c = 0;
            this.d = 0;
            this.f6487e = 0;
            this.f6488f = true;
            this.g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f6471e = clsArr;
        f6472f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f6475c = context;
        Object[] objArr = {context};
        this.f6473a = objArr;
        this.f6474b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException(D2.e.c("Expecting menu, got ", name));
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z4 = false;
        boolean z5 = false;
        while (!z4) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z5 && name2.equals(str)) {
                        str = null;
                        z5 = false;
                    } else if (name2.equals("group")) {
                        bVar.g();
                    } else if (name2.equals("item")) {
                        if (!bVar.c()) {
                            androidx.core.view.b bVar2 = bVar.f6505z;
                            if (bVar2 == null || !bVar2.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z4 = true;
                    }
                }
            } else if (!z5) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.e(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z5 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    final Object b() {
        if (this.d == null) {
            this.d = a(this.f6475c);
        }
        return this.d;
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i2, Menu menu) {
        if (!(menu instanceof A.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f6475c.getResources().getLayout(i2);
                    c(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e4) {
                throw new InflateException("Error inflating menu XML", e4);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
