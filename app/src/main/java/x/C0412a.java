package x;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import miuix.appcompat.internal.app.widget.SearchActionModeView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t.C0384b;

/* renamed from: x.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0412a {

    /* renamed from: x.a$a, reason: collision with other inner class name */
    public interface InterfaceC0143a {
    }

    /* renamed from: x.a$b */
    public static final class b implements InterfaceC0143a {

        /* renamed from: a, reason: collision with root package name */
        private final c[] f7996a;

        public b(c[] cVarArr) {
            this.f7996a = cVarArr;
        }

        public final c[] a() {
            return this.f7996a;
        }
    }

    /* renamed from: x.a$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f7997a;

        /* renamed from: b, reason: collision with root package name */
        private int f7998b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f7999c;
        private String d;

        /* renamed from: e, reason: collision with root package name */
        private int f8000e;

        /* renamed from: f, reason: collision with root package name */
        private int f8001f;

        public c(String str, int i2, boolean z4, String str2, int i4, int i5) {
            this.f7997a = str;
            this.f7998b = i2;
            this.f7999c = z4;
            this.d = str2;
            this.f8000e = i4;
            this.f8001f = i5;
        }

        public final int a() {
            return this.f8001f;
        }

        public final int b() {
            return this.f8000e;
        }

        public final String c() {
            return this.d;
        }

        public final int d() {
            return this.f7998b;
        }

        public final boolean e() {
            return this.f7999c;
        }
    }

    /* renamed from: x.a$d */
    public static final class d implements InterfaceC0143a {

        /* renamed from: a, reason: collision with root package name */
        private final C.e f8002a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8003b;

        /* renamed from: c, reason: collision with root package name */
        private final int f8004c;
        private final String d;

        public d(C.e eVar, int i2, int i4, String str) {
            this.f8002a = eVar;
            this.f8004c = i2;
            this.f8003b = i4;
            this.d = str;
        }

        public final int a() {
            return this.f8004c;
        }

        public final C.e b() {
            return this.f8002a;
        }

        public final String c() {
            return this.d;
        }

        public final int d() {
            return this.f8003b;
        }
    }

    public static InterfaceC0143a a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0384b.f7889v);
            String string = typedArrayObtainAttributes.getString(0);
            String string2 = typedArrayObtainAttributes.getString(4);
            String string3 = typedArrayObtainAttributes.getString(5);
            int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
            int integer = typedArrayObtainAttributes.getInteger(2, 1);
            int integer2 = typedArrayObtainAttributes.getInteger(3, 500);
            String string4 = typedArrayObtainAttributes.getString(6);
            typedArrayObtainAttributes.recycle();
            if (string != null && string2 != null && string3 != null) {
                while (xmlPullParser.next() != 3) {
                    c(xmlPullParser);
                }
                return new d(new C.e(string, string2, string3, b(resources, resourceId)), integer, integer2, string4);
            }
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0384b.f7890w);
                        int i2 = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(8) ? 8 : 1, SearchActionModeView.ANIMATION_DURATION);
                        boolean z4 = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(6) ? 6 : 2, 0);
                        int i4 = typedArrayObtainAttributes2.hasValue(9) ? 9 : 3;
                        String string5 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(7) ? 7 : 4);
                        int i5 = typedArrayObtainAttributes2.getInt(i4, 0);
                        int i6 = typedArrayObtainAttributes2.hasValue(5) ? 5 : 0;
                        int resourceId2 = typedArrayObtainAttributes2.getResourceId(i6, 0);
                        String string6 = typedArrayObtainAttributes2.getString(i6);
                        typedArrayObtainAttributes2.recycle();
                        while (xmlPullParser.next() != 3) {
                            c(xmlPullParser);
                        }
                        arrayList.add(new c(string6, i2, z4, string5, i5, resourceId2));
                    } else {
                        c(xmlPullParser);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
            }
        } else {
            c(xmlPullParser);
        }
        return null;
    }

    public static List<List<byte[]>> b(Resources resources, int i2) throws Resources.NotFoundException {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i4 = 0; i4 < typedArrayObtainTypedArray.length(); i4++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i4, 0);
                    if (resourceId != 0) {
                        arrayList.add(d(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(d(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static void c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List<byte[]> d(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
