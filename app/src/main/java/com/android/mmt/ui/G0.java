package com.android.mmt.ui;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.drm.DrmManagerClient;
import android.net.Uri;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.android.mmt.MmsApp;
import f0.C0303b;
import g0.C0309e;
import g0.C0319o;
import j0.C0337b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public final class G0 {

    /* renamed from: o, reason: collision with root package name */
    private static final String[] f4824o = {"_id", "chset", "cd", "cid", "cl", "ct", "fn", "name", "text"};

    /* renamed from: a, reason: collision with root package name */
    private Context f4825a;

    /* renamed from: b, reason: collision with root package name */
    private ContentResolver f4826b;

    /* renamed from: e, reason: collision with root package name */
    private Uri f4828e;

    /* renamed from: f, reason: collision with root package name */
    private long f4829f;
    private Integer g;

    /* renamed from: k, reason: collision with root package name */
    private I0 f4833k;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<P0.E> f4834l;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<String> f4835m;

    /* renamed from: c, reason: collision with root package name */
    private int f4827c = -1;
    private boolean d = false;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, I0> f4830h = new ArrayMap();

    /* renamed from: i, reason: collision with root package name */
    private Map<String, I0> f4831i = new ArrayMap();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<I0> f4832j = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    private G0.j f4836n = new G0.j();

    private class a extends DefaultHandler {

        /* renamed from: b, reason: collision with root package name */
        private P0.E f4838b;

        /* renamed from: c, reason: collision with root package name */
        private ArrayList<I0> f4839c;

        /* renamed from: a, reason: collision with root package name */
        private boolean f4837a = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f4841f = false;
        private int d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f4840e = 0;

        public a(ArrayList<I0> arrayList) {
            this.f4839c = (ArrayList) arrayList.clone();
            G0.this.f4835m = new ArrayList();
        }

        public final ArrayList<I0> a() {
            return this.f4839c;
        }

        public final boolean b() {
            return this.d > 1 || this.f4840e > 1 || G0.this.f4834l.size() > 1;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void characters(char[] cArr, int i2, int i4) {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void endElement(String str, String str2, String str3) throws SAXException {
            if (!"par".equals(str2)) {
                if ("hide".equals(str2)) {
                    this.f4841f = false;
                    return;
                }
                return;
            }
            this.f4837a = false;
            P0.E e2 = this.f4838b;
            if (e2 != null) {
                if (e2.d() != 0 && !this.f4838b.f()) {
                    G0.this.f4834l.add(this.f4838b);
                }
                this.f4838b = null;
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException, NumberFormatException {
            int iY;
            if ("hide".equals(str2)) {
                this.f4841f = true;
                return;
            }
            if (this.f4841f) {
                String value = attributes.getValue("src");
                if (TextUtils.isEmpty(value)) {
                    return;
                }
                G0.this.f4835m.add(value);
                for (int size = this.f4839c.size() - 1; size >= 0; size--) {
                    if (value.equals(this.f4839c.get(size).C())) {
                        this.f4839c.remove(size);
                    }
                }
                return;
            }
            if ("par".equals(str2)) {
                this.f4837a = true;
                this.f4838b = new P0.E();
                return;
            }
            if (this.f4837a) {
                String value2 = attributes.getValue("src");
                if ((G0.this.f4835m == null || G0.this.f4835m.isEmpty() || !G0.this.f4835m.contains(value2)) && value2 != null) {
                    I0 i02 = value2.startsWith("cid:") ? (I0) ((ArrayMap) G0.this.f4831i).get(value2.substring(4)) : (I0) ((ArrayMap) G0.this.f4830h).get(value2);
                    if (i02 == null || (iY = i02.y()) == -1) {
                        return;
                    }
                    this.f4838b.a(i02);
                    for (int size2 = this.f4839c.size() - 1; size2 >= 0; size2--) {
                        if (Arrays.equals(this.f4839c.get(size2).e(), i02.e())) {
                            this.f4839c.remove(size2);
                        }
                    }
                    if (iY == 0) {
                        this.d++;
                        return;
                    } else {
                        this.f4840e++;
                        return;
                    }
                }
                return;
            }
            if ("region".equals(str2)) {
                String value3 = attributes.getValue("id");
                String value4 = attributes.getValue("top");
                if (TextUtils.isEmpty(value4)) {
                    return;
                }
                int i2 = 0;
                if (value4.endsWith("px")) {
                    value4 = value4.substring(0, value4.indexOf("px"));
                } else if (value4.endsWith("%")) {
                    value4 = value4.substring(0, value4.length() - 1);
                }
                if (TextUtils.isEmpty(value4)) {
                    return;
                }
                try {
                    i2 = Integer.parseInt(value4);
                } catch (Exception e2) {
                    Log.e("Mms/SimplePduDoc", "parse number error! " + e2);
                }
                if ("Image".equals(value3)) {
                    if (G0.this.f4836n != null) {
                        G0.this.f4836n.u().w(i2);
                    }
                } else {
                    if (!"Text".equals(value3) || G0.this.f4836n == null) {
                        return;
                    }
                    G0.this.f4836n.y().w(i2);
                }
            }
        }
    }

    public G0(Context context) {
        this.f4825a = context;
        this.f4826b = context.getContentResolver();
    }

    private boolean q() {
        if (this.f4832j.isEmpty()) {
            return false;
        }
        ArrayList<P0.E> arrayList = new ArrayList<>();
        this.f4834l = arrayList;
        this.d = r(arrayList, this.f4832j) || this.f4834l.size() > 1;
        return true;
    }

    private byte[] s(Cursor cursor, int i2) {
        String string = cursor.getString(i2);
        if (string != null) {
            return C0319o.d(string);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.util.ArrayMap, java.util.Map<java.lang.String, com.android.mmt.ui.I0>] */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.util.ArrayMap, java.util.Map<java.lang.String, com.android.mmt.ui.I0>] */
    /* JADX WARN: Type inference failed for: r4v22, types: [android.util.ArrayMap, java.util.Map<java.lang.String, com.android.mmt.ui.I0>] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.util.ArrayMap, java.util.Map<java.lang.String, com.android.mmt.ui.I0>] */
    private void t() throws C0303b {
        Integer numValueOf;
        String string;
        Context context = this.f4825a;
        ContentResolver contentResolver = this.f4826b;
        StringBuilder sbD = D2.e.d("content://mms/");
        sbD.append(this.f4829f);
        sbD.append("/part");
        Cursor cursorE = com.android.mmt.util.O.e(context, contentResolver, Uri.parse(sbD.toString()), f4824o, null, null, null);
        if (cursorE != null) {
            try {
                if (cursorE.getCount() != 0) {
                    DrmManagerClient drmManagerClientD = MmsApp.d();
                    this.f4830h.clear();
                    this.f4831i.clear();
                    while (cursorE.moveToNext()) {
                        I0 i02 = new I0(this.f4825a);
                        String strR = null;
                        try {
                            numValueOf = Integer.valueOf(cursorE.getInt(1));
                        } catch (NumberFormatException unused) {
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            i02.l(numValueOf.intValue());
                        }
                        byte[] bArrS = s(cursorE, 2);
                        if (bArrS != null) {
                            i02.m(bArrS);
                        }
                        byte[] bArrS2 = s(cursorE, 3);
                        if (bArrS2 != null) {
                            i02.n(bArrS2);
                        }
                        byte[] bArrS3 = s(cursorE, 4);
                        if (bArrS3 != null) {
                            i02.o(bArrS3);
                        }
                        byte[] bArrS4 = s(cursorE, 5);
                        if (bArrS4 != null) {
                            strR = C0319o.r(bArrS4);
                        }
                        if (bArrS4 == null) {
                            throw new C0303b("Content-Type must be set.");
                        }
                        i02.q(bArrS4);
                        if (Arrays.equals(bArrS4, "application/smil".getBytes())) {
                            this.f4833k = i02;
                            this.f4827c = 0;
                        } else {
                            if (C0337b.e(strR)) {
                                strR = drmManagerClientD.getOriginalMimeType(i02.i().getPath());
                            }
                            if (strR != null) {
                                if ("text/x-vCard".equalsIgnoreCase(strR)) {
                                    i02.G(4);
                                } else if (C0337b.g(strR) || "application/vnd.wap.xhtml+xml".equalsIgnoreCase(strR)) {
                                    i02.G(0);
                                } else if (C0337b.f(strR)) {
                                    i02.G(1);
                                } else if (C0337b.d(strR) || "application/ogg".equalsIgnoreCase(strR)) {
                                    i02.G(3);
                                } else if (C0337b.h(strR)) {
                                    i02.G(2);
                                } else {
                                    i02.G(5);
                                }
                            }
                        }
                        byte[] bArrS5 = s(cursorE, 6);
                        if (bArrS5 != null) {
                            i02.t(bArrS5);
                        }
                        byte[] bArrS6 = s(cursorE, 7);
                        if (bArrS6 != null) {
                            i02.u(bArrS6);
                        }
                        i02.s(Uri.parse("content://mms/part/" + cursorE.getLong(0)));
                        if (("text/plain".equals(strR) || "application/smil".equals(strR) || "text/html".equals(strR)) && (string = cursorE.getString(8)) != null) {
                            byte[] bArrG = new C0309e(106, string).g();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byteArrayOutputStream.write(bArrG, 0, bArrG.length);
                            i02.r(byteArrayOutputStream.toByteArray());
                        }
                        if (i02.y() != -1) {
                            if (i02.e() != null) {
                                this.f4830h.put(new String(i02.e()), i02);
                            }
                            if (i02.d() != null) {
                                String str = new String(i02.d());
                                if (str.length() > 2) {
                                    this.f4831i.put(str.substring(1, str.length() - 1), i02);
                                }
                            }
                            this.f4832j.add(i02);
                        }
                    }
                    return;
                }
            } finally {
                cursorE.close();
            }
        }
        if (cursorE != null) {
        }
    }

    public final boolean g() {
        I0 i0J = j();
        int iY = i0J != null ? i0J.y() : -1;
        return this.d || !(iY == -1 || iY == 0);
    }

    public final int h() {
        if (this.g == null) {
            this.g = 0;
            I0 i02 = this.f4833k;
            if (i02 != null && i02.E()) {
                this.g = Integer.valueOf(this.g.intValue() + this.f4833k.h().length);
            }
            Iterator<I0> it = this.f4832j.iterator();
            while (it.hasNext()) {
                I0 next = it.next();
                if (next.E()) {
                    this.g = Integer.valueOf(this.g.intValue() + next.h().length);
                }
            }
        }
        return this.g.intValue();
    }

    public final P0.E i(int i2) {
        if (this.f4834l == null || i2 >= k()) {
            return null;
        }
        return this.f4834l.get(i2);
    }

    public final I0 j() {
        if (this.f4834l == null || k() <= 0) {
            return null;
        }
        return i(0).b();
    }

    public final int k() {
        ArrayList<P0.E> arrayList = this.f4834l;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final I0 l() {
        if (this.f4834l == null || k() <= 0) {
            return null;
        }
        return i(0).e();
    }

    public final Uri m() {
        return this.f4828e;
    }

    public final boolean n() {
        G0.j jVar = this.f4836n;
        return jVar != null && jVar.u().u() > this.f4836n.y().u();
    }

    public final boolean o() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean p(Uri uri) {
        boolean z4;
        this.f4828e = uri;
        this.f4829f = ContentUris.parseId(uri);
        Context context = this.f4825a;
        ContentResolver contentResolver = this.f4826b;
        StringBuilder sbD = D2.e.d("content://mms/");
        sbD.append(this.f4829f);
        sbD.append("/addr");
        Cursor cursorE = com.android.mmt.util.O.e(context, contentResolver, Uri.parse(sbD.toString()), new String[]{"address", "charset", "type"}, null, null, null);
        if (cursorE != null) {
            while (cursorE.moveToNext()) {
                try {
                    String string = cursorE.getString(0);
                    if (!TextUtils.isEmpty(string) && cursorE.getInt(2) == 137) {
                        new C0309e(cursorE.getInt(1), C0319o.d(string));
                    }
                } finally {
                    cursorE.close();
                }
            }
        }
        try {
            t();
            int i2 = this.f4827c;
            if (i2 != 0) {
                q();
            } else if (i2 != 0) {
                z4 = false;
                if (!z4) {
                    q();
                }
            } else {
                this.f4834l = new ArrayList<>();
                a aVar = new a(this.f4832j);
                try {
                    SAXParser sAXParserNewSAXParser = SAXParserFactory.newInstance().newSAXParser();
                    byte[] bArrH = this.f4833k.h();
                    if (bArrH != null) {
                        sAXParserNewSAXParser.parse(new ByteArrayInputStream(bArrH), aVar);
                    }
                    boolean zB = aVar.b();
                    ArrayList<I0> arrayListA = aVar.a();
                    if (arrayListA != null && !arrayListA.isEmpty()) {
                        zB = r(this.f4834l, arrayListA) || zB;
                        if (this.f4832j.size() == 2 && this.f4834l.size() == 2) {
                            I0 i02 = this.f4832j.get(0);
                            I0 i03 = this.f4832j.get(1);
                            int iY = i02.y();
                            int iY2 = i03.y();
                            if ((iY == 0 && iY2 != 0) || (iY2 == 0 && iY != 0)) {
                                this.f4834l.clear();
                                P0.E e2 = new P0.E();
                                e2.a(i02);
                                e2.a(i03);
                                this.f4834l.add(e2);
                            }
                            zB = false;
                        }
                    }
                    this.d = zB || this.f4834l.size() > 1;
                    z4 = true;
                } catch (IOException | ParserConfigurationException | SAXException unused) {
                }
                if (!z4) {
                }
            }
            ArrayList<P0.E> arrayList = this.f4834l;
            return (arrayList == null || arrayList.isEmpty()) ? false : true;
        } catch (C0303b unused2) {
            return false;
        }
    }

    final boolean r(ArrayList<P0.E> arrayList, ArrayList<I0> arrayList2) {
        Iterator<I0> it = arrayList2.iterator();
        P0.E e2 = null;
        int i2 = 0;
        int i4 = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (it.hasNext()) {
            I0 next = it.next();
            int iY = next.y();
            if (e2 == null || ((z4 && z5) || ((z4 && iY != -1 && iY != 0) || (z5 && iY == 0)))) {
                e2 = new P0.E();
                arrayList.add(e2);
                z4 = false;
                z5 = false;
            }
            if (iY != -1) {
                e2.a(next);
                if (iY == 0) {
                    i2++;
                    z5 = true;
                } else {
                    i4++;
                    z4 = true;
                }
            }
        }
        return i2 > 1 || i4 > 1;
    }
}
