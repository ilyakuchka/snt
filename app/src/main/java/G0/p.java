package G0;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.drm.DrmManagerClient;
import android.media.MediaDrmException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.MmsApp;
import f0.C0303b;
import g0.C0310f;
import g0.C0311g;
import g0.C0313i;
import g0.C0318n;
import g0.C0319o;
import j0.C0337b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import k0.C0341b;
import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public final class p extends l implements List<o>, h {

    /* renamed from: j, reason: collision with root package name */
    private final j f191j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList<o> f192k;

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList<g> f193l;

    /* renamed from: m, reason: collision with root package name */
    private a4.e f194m;

    /* renamed from: n, reason: collision with root package name */
    private C0313i f195n;

    /* renamed from: o, reason: collision with root package name */
    private int f196o;
    private Context p;

    private p(Context context) {
        this.f191j = new j();
        this.f192k = new ArrayList<>();
        this.f193l = new ArrayList<>();
        this.p = context;
    }

    public static String A(int i2, String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cid:")) {
            str = str.substring(4);
        }
        int iLastIndexOf = str.lastIndexOf("/");
        if (-1 != iLastIndexOf && iLastIndexOf < str.length()) {
            str = str.substring(iLastIndexOf + 1);
        }
        if (str.length() <= 20) {
            return str;
        }
        int iLastIndexOf2 = str.lastIndexOf(".");
        return String.format(D2.e.c("part%06d", iLastIndexOf2 == -1 ? "" : str.substring(iLastIndexOf2, str.length())), Integer.valueOf(i2));
    }

    public static C0313i B(Context context, Uri uri) throws C0303b {
        C0310f c0310fH = C0319o.e(context.getApplicationContext()).h(uri);
        int iA = c0310fH.a();
        if (iA == 128 || iA == 132) {
            return ((C0311g) c0310fH).e();
        }
        throw new C0303b();
    }

    /* JADX WARN: Removed duplicated region for block: B:196:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static p s(Context context, Uri uri) throws C0303b, DOMException {
        C0318n c0318nC;
        a4.e eVarA;
        int i2;
        C0313i c0313i;
        String str;
        boolean z4;
        j jVar;
        a4.e eVar;
        NodeList nodeList;
        int i4;
        int iL;
        byte[] bArrH;
        C0313i c0313iB = B(context, uri);
        int iH = c0313iB.h();
        int i5 = 0;
        while (true) {
            if (i5 >= iH) {
                c0318nC = null;
                break;
            }
            c0318nC = c0313iB.c(i5);
            if (Arrays.equals(c0318nC.g(), "application/smil".getBytes())) {
                break;
            }
            i5++;
        }
        if (c0318nC != null) {
            try {
                bArrH = c0318nC.h();
            } catch (C0303b e2) {
                Log.e("Mms/smil", "Failed to parse SMIL document.", e2);
            } catch (IOException e4) {
                Log.e("Mms/smil", "Failed to parse SMIL document.", e4);
            } catch (SAXException e5) {
                Log.e("Mms/smil", "Failed to parse SMIL document.", e5);
            }
            eVarA = bArrH != null ? new B0.b().a(new ByteArrayInputStream(bArrH)) : null;
        }
        if (eVarA == null) {
            eVarA = new A0.e();
            a4.f fVar = (a4.f) eVarA.createElement("smil");
            fVar.setAttribute("xmlns", "http://www.w3.org/2001/SMIL20/Language");
            eVarA.appendChild(fVar);
            a4.f fVar2 = (a4.f) eVarA.createElement("head");
            fVar.appendChild(fVar2);
            fVar2.appendChild((a4.g) eVarA.createElement("layout"));
            fVar.appendChild((a4.f) eVarA.createElement("body"));
            a4.i iVarB = f.b(eVarA);
            int iH2 = c0313iB.h();
            if (iH2 != 0) {
                DrmManagerClient drmManagerClientD = MmsApp.d();
                boolean z5 = false;
                boolean z6 = false;
                for (int i6 = 0; i6 < iH2; i6++) {
                    if (z5 && z6) {
                        iVarB = f.b(eVarA);
                        z5 = false;
                        z6 = false;
                    }
                    C0318n c0318nC2 = c0313iB.c(i6);
                    String str2 = new String(c0318nC2.g());
                    if (C0337b.e(str2)) {
                        str2 = drmManagerClientD.getOriginalMimeType(c0318nC2.i().getPath());
                    }
                    if (str2.equals("text/plain") || str2.equalsIgnoreCase("application/vnd.wap.xhtml+xml") || str2.equals("text/html")) {
                        iVarB.appendChild(f.c("text", eVarA, c0318nC2.a()));
                        z6 = true;
                    } else {
                        if (C0337b.f(str2)) {
                            iVarB.appendChild(f.c("img", eVarA, c0318nC2.a()));
                        } else if (C0337b.h(str2)) {
                            iVarB.appendChild(f.c("video", eVarA, c0318nC2.a()));
                        } else if (C0337b.d(str2)) {
                            iVarB.appendChild(f.c("audio", eVarA, c0318nC2.a()));
                        } else {
                            Log.w("Mms/smil", "unsupport media type");
                        }
                        z5 = true;
                    }
                }
            }
        }
        a4.e eVar2 = eVarA;
        A0.e eVar3 = (A0.e) eVar2;
        a4.g gVarN = eVar3.n();
        a4.l lVarW = gVarN.w();
        int iG = lVarW.g();
        int iK = lVarW.k();
        if (iG == 0 || iK == 0) {
            iG = F0.b.a().b().d();
            iK = F0.b.a().b().a();
            lVarW.o(iG);
            lVarW.e(iK);
        }
        int i7 = 0;
        n nVar = new n(null, 0, iG, iK);
        ArrayList arrayList = new ArrayList();
        NodeList nodeListU = gVarN.u();
        int length = nodeListU.getLength();
        while (i7 < length) {
            a4.j jVar2 = (a4.j) nodeListU.item(i7);
            arrayList.add(new n(jVar2.getId(), jVar2.t(), jVar2.j(), jVar2.h(), jVar2.g(), jVar2.k(), jVar2.z()));
            i7++;
            nodeListU = nodeListU;
        }
        j jVar3 = new j(nVar, arrayList);
        NodeList childNodes = eVar3.A().getChildNodes();
        int length2 = childNodes.getLength();
        ArrayList arrayList2 = new ArrayList(length2);
        int i8 = 0;
        while (i8 < length2) {
            a4.i iVar = (a4.i) childNodes.item(i8);
            NodeList childNodes2 = iVar.getChildNodes();
            int length3 = childNodes2.getLength();
            ArrayList arrayList3 = new ArrayList(length3);
            NodeList nodeList2 = childNodes;
            int i9 = 0;
            while (i9 < length3) {
                a4.f fVar3 = (a4.f) childNodes2.item(i9);
                int i10 = length2;
                try {
                    if (fVar3 instanceof a4.h) {
                        k kVarG = f.g(context, (a4.h) fVar3, jVar3, c0313iB);
                        if (k0.d.q()) {
                            jVar = jVar3;
                            eVar = eVar2;
                            nodeList = childNodes2;
                            i4 = length3;
                        } else {
                            nodeList = childNodes2;
                            try {
                                int i11 = kVarG.f168l;
                                float fL = iVar.l();
                                if (fL == 0.0f) {
                                    i4 = length3;
                                    try {
                                        iL = k0.d.l() * 1000;
                                        kVarG.B(iL);
                                    } catch (MediaDrmException e6) {
                                        e = e6;
                                        jVar = jVar3;
                                        eVar = eVar2;
                                        Log.e("Mms/slideshow", e.getMessage(), e);
                                        i9++;
                                        length2 = i10;
                                        childNodes2 = nodeList;
                                        eVar2 = eVar;
                                        length3 = i4;
                                        jVar3 = jVar;
                                    } catch (IOException e7) {
                                        e = e7;
                                        jVar = jVar3;
                                        eVar = eVar2;
                                        Log.e("Mms/slideshow", e.getMessage(), e);
                                        i9++;
                                        length2 = i10;
                                        childNodes2 = nodeList;
                                        eVar2 = eVar;
                                        length3 = i4;
                                        jVar3 = jVar;
                                    } catch (IllegalArgumentException e8) {
                                        e = e8;
                                        jVar = jVar3;
                                        eVar = eVar2;
                                        Log.e("Mms/slideshow", e.getMessage(), e);
                                        i9++;
                                        length2 = i10;
                                        childNodes2 = nodeList;
                                        eVar2 = eVar;
                                        length3 = i4;
                                        jVar3 = jVar;
                                    }
                                } else {
                                    i4 = length3;
                                    iL = i11;
                                }
                                eVar = eVar2;
                                try {
                                    if (iL / 1000 != fL) {
                                        String tagName = fVar3.getTagName();
                                        jVar = jVar3;
                                        try {
                                            if (C0337b.h(kVarG.f171o) || tagName.equals("video") || C0337b.d(kVarG.f171o) || tagName.equals("audio")) {
                                                iVar.p((iL / 1000.0f) + 1.0f);
                                            } else if (iL / 1000 < fL) {
                                                kVarG.B(((int) fL) * 1000);
                                            } else {
                                                int i12 = (int) fL;
                                                if (i12 != 0) {
                                                    kVarG.B(i12 * 1000);
                                                } else {
                                                    iVar.p(iL / 1000.0f);
                                                }
                                            }
                                        } catch (MediaDrmException e9) {
                                            e = e9;
                                            Log.e("Mms/slideshow", e.getMessage(), e);
                                            i9++;
                                            length2 = i10;
                                            childNodes2 = nodeList;
                                            eVar2 = eVar;
                                            length3 = i4;
                                            jVar3 = jVar;
                                        } catch (IOException e10) {
                                            e = e10;
                                            Log.e("Mms/slideshow", e.getMessage(), e);
                                            i9++;
                                            length2 = i10;
                                            childNodes2 = nodeList;
                                            eVar2 = eVar;
                                            length3 = i4;
                                            jVar3 = jVar;
                                        } catch (IllegalArgumentException e11) {
                                            e = e11;
                                            Log.e("Mms/slideshow", e.getMessage(), e);
                                            i9++;
                                            length2 = i10;
                                            childNodes2 = nodeList;
                                            eVar2 = eVar;
                                            length3 = i4;
                                            jVar3 = jVar;
                                        }
                                    } else {
                                        jVar = jVar3;
                                    }
                                } catch (MediaDrmException e12) {
                                    e = e12;
                                    jVar = jVar3;
                                } catch (IOException e13) {
                                    e = e13;
                                    jVar = jVar3;
                                } catch (IllegalArgumentException e14) {
                                    e = e14;
                                    jVar = jVar3;
                                }
                            } catch (MediaDrmException e15) {
                                e = e15;
                                jVar = jVar3;
                                eVar = eVar2;
                                i4 = length3;
                                Log.e("Mms/slideshow", e.getMessage(), e);
                                i9++;
                                length2 = i10;
                                childNodes2 = nodeList;
                                eVar2 = eVar;
                                length3 = i4;
                                jVar3 = jVar;
                            } catch (IOException e16) {
                                e = e16;
                                jVar = jVar3;
                                eVar = eVar2;
                                i4 = length3;
                                Log.e("Mms/slideshow", e.getMessage(), e);
                                i9++;
                                length2 = i10;
                                childNodes2 = nodeList;
                                eVar2 = eVar;
                                length3 = i4;
                                jVar3 = jVar;
                            } catch (IllegalArgumentException e17) {
                                e = e17;
                                jVar = jVar3;
                                eVar = eVar2;
                                i4 = length3;
                                Log.e("Mms/slideshow", e.getMessage(), e);
                                i9++;
                                length2 = i10;
                                childNodes2 = nodeList;
                                eVar2 = eVar;
                                length3 = i4;
                                jVar3 = jVar;
                            }
                        }
                        f.a((Z3.b) fVar3, kVarG);
                        arrayList3.add(kVarG);
                    } else {
                        jVar = jVar3;
                        eVar = eVar2;
                        nodeList = childNodes2;
                        i4 = length3;
                        Log.i("Mms/slideshow", "sme is not SMILMediaElement");
                    }
                } catch (MediaDrmException e18) {
                    e = e18;
                    jVar = jVar3;
                    eVar = eVar2;
                    nodeList = childNodes2;
                } catch (IOException e19) {
                    e = e19;
                    jVar = jVar3;
                    eVar = eVar2;
                    nodeList = childNodes2;
                } catch (IllegalArgumentException e20) {
                    e = e20;
                    jVar = jVar3;
                    eVar = eVar2;
                    nodeList = childNodes2;
                }
                i9++;
                length2 = i10;
                childNodes2 = nodeList;
                eVar2 = eVar;
                length3 = i4;
                jVar3 = jVar;
            }
            o oVar = new o((int) (iVar.l() * 1000.0f), arrayList3);
            iVar.x();
            oVar.g();
            Z3.b bVar = (Z3.b) iVar;
            bVar.v("SmilSlideStart", oVar);
            bVar.v("SmilSlideEnd", oVar);
            arrayList2.add(oVar);
            i8++;
            childNodes = nodeList2;
            jVar3 = jVar3;
        }
        j jVar4 = jVar3;
        a4.e eVar4 = eVar2;
        int iH3 = c0313iB.h();
        ArrayList arrayList4 = new ArrayList();
        int i13 = 0;
        while (i13 < iH3) {
            C0318n c0318nC3 = c0313iB.c(i13);
            byte[] bArrE = c0318nC3.e();
            byte[] bArrK = c0318nC3.k();
            byte[] bArrD = c0318nC3.d();
            byte[] bArrJ = c0318nC3.j();
            byte[] bArrH2 = c0318nC3.h();
            if (bArrE != null) {
                str = new String(bArrE);
            } else if (bArrK != null) {
                str = new String(bArrK);
            } else if (bArrD != null) {
                str = new String(bArrD);
            } else if (bArrJ != null) {
                str = new String(bArrJ);
            } else {
                i2 = iH3;
                c0313i = c0313iB;
                Y1.a.d(D2.e.b("Cannot decide file name for part ", i13), new Object[0]);
                i13++;
                iH3 = i2;
                c0313iB = c0313i;
            }
            String str3 = new String(c0318nC3.g());
            byte[] bArrE2 = c0318nC3.e();
            byte[] bArrK2 = c0318nC3.k();
            byte[] bArrD2 = c0318nC3.d();
            byte[] bArrJ2 = c0318nC3.j();
            i2 = iH3;
            c0313i = c0313iB;
            if (bArrE2 != null) {
                z4 = "text/x-vCard".equalsIgnoreCase(str3) || ((str3.equals("application/oct-stream") || str3.equals("application/octet-stream")) && new String(bArrE2).endsWith(".vcf"));
            } else if (bArrK2 != null) {
                String str4 = new String(bArrK2);
                if ("text/x-vCard".equalsIgnoreCase(str3) || ((str3.equals("application/oct-stream") || str3.equals("application/octet-stream")) && str4.endsWith(".vcf"))) {
                }
            } else if (bArrD2 != null) {
                String str5 = new String(bArrD2);
                if ("text/x-vCard".equalsIgnoreCase(str3) || ((str3.equals("application/oct-stream") || str3.equals("application/octet-stream")) && str5.endsWith(".vcf"))) {
                }
            } else if (bArrJ2 != null) {
                String str6 = new String(bArrJ2);
                if ("text/x-vCard".equalsIgnoreCase(str3) || ((str3.equals("application/oct-stream") || str3.equals("application/octet-stream")) && str6.endsWith(".vcf"))) {
                }
            }
            if (z4) {
                arrayList4.add(new r(context, str, c0318nC3.i()));
            } else if (bArrH2 == null || !new String(bArrH2).startsWith("BEGIN:VCARD")) {
                Y1.a.d(D2.e.b("Unrecognized attachment part ", i13), new Object[0]);
            } else if (new String(bArrH2).startsWith("BEGIN:VCARD")) {
                arrayList4.add(new r(context, D2.e.c(str, ".vcf"), c0318nC3.i()));
            }
            i13++;
            iH3 = i2;
            c0313iB = c0313i;
        }
        p pVar = new p(jVar4, arrayList2, arrayList4, eVar4, c0313iB, context);
        pVar.h(pVar);
        return pVar;
    }

    public static p t(Context context) {
        return new p(context);
    }

    public final void C(int i2) {
        if (i2 > 0) {
            this.f196o += i2;
        }
    }

    @Override // java.util.List
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final o remove(int i2) {
        o oVarRemove = this.f192k.remove(i2);
        if (oVarRemove != null) {
            u(oVarRemove.w());
            oVarRemove.k();
            g();
        }
        return oVarRemove;
    }

    public final void E() {
        for (int size = this.f193l.size() - 1; size >= 0; size--) {
            g gVarRemove = this.f193l.remove(size);
            if (gVarRemove != null) {
                u(gVarRemove.f156n);
                gVarRemove.k();
                g();
            }
        }
    }

    public final void F(int i2) {
        this.f196o = i2;
    }

    public final int G() {
        ArrayList<g> arrayList = this.f193l;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void H(C0313i c0313i) {
        Iterator<o> it = this.f192k.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            Iterator<k> it2 = it.next().iterator();
            while (it2.hasNext()) {
                k next = it2.next();
                if (!next.y() || !TextUtils.isEmpty(((q) next).H())) {
                    String strA = A(i2, next.f170n);
                    i2++;
                    C0318n c0318nE = c0313i.e(strA);
                    if (c0318nE != null) {
                        next.D(c0318nE.i());
                    }
                }
            }
        }
        Iterator<g> it3 = this.f193l.iterator();
        while (it3.hasNext()) {
            g next2 = it3.next();
            C0318n c0318nE2 = c0313i.e(next2.f153k);
            if (c0318nE2 != null) {
                next2.f155m = c0318nE2.i();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0313i I() {
        String str;
        if (this.f195n == null) {
            a4.e eVarE = f.e(this);
            this.f194m = eVarE;
            C0313i c0313i = new C0313i();
            int i2 = 1;
            for (int i4 = 0; i4 < this.f192k.size(); i4++) {
                o oVar = this.f192k.get(i4);
                for (int i5 = 0; i5 < oVar.size(); i5++) {
                    k kVarS = oVar.s(i5);
                    C0318n c0318n = new C0318n();
                    if (kVarS.y()) {
                        q qVar = (q) kVarS;
                        if (!TextUtils.isEmpty(qVar.H())) {
                            c0318n.l(qVar.G());
                            c0318n.q(kVarS.f171o.getBytes());
                            str = kVarS.f170n;
                            String strA = A(i2, str);
                            i2++;
                            c0318n.o(strA.getBytes());
                            if (str.startsWith("cid:")) {
                                int iLastIndexOf = strA.lastIndexOf(".");
                                if (iLastIndexOf != -1) {
                                    strA = strA.substring(0, iLastIndexOf);
                                }
                                c0318n.n(strA.getBytes());
                            } else {
                                c0318n.n(strA.getBytes());
                            }
                            if (!kVarS.y()) {
                                c0318n.r(((q) kVarS).H().getBytes());
                            } else if (kVarS.f169m.equals("img") || kVarS.z() || kVarS.f169m.equals("audio")) {
                                c0318n.s(kVarS.u());
                            } else {
                                Log.w("Mms/slideshow", "Unsupport media: " + kVarS);
                            }
                            c0313i.b(c0318n);
                        }
                    } else {
                        c0318n.q(kVarS.f171o.getBytes());
                        str = kVarS.f170n;
                        String strA2 = A(i2, str);
                        i2++;
                        c0318n.o(strA2.getBytes());
                        if (str.startsWith("cid:")) {
                        }
                        if (!kVarS.y()) {
                        }
                        c0313i.b(c0318n);
                    }
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            B0.c.a(eVarE, byteArrayOutputStream);
            C0318n c0318n2 = new C0318n();
            c0318n2.n("smil".getBytes());
            c0318n2.o("smil.xml".getBytes());
            c0318n2.q("application/smil".getBytes());
            c0318n2.r(byteArrayOutputStream.toByteArray());
            c0313i.a(c0318n2);
            Iterator<g> it = this.f193l.iterator();
            while (it.hasNext()) {
                g next = it.next();
                C0318n c0318n3 = new C0318n();
                c0318n3.q(next.f154l.toLowerCase().getBytes());
                String strSubstring = next.f153k;
                boolean zStartsWith = strSubstring.startsWith("cid:");
                if (zStartsWith) {
                    strSubstring = strSubstring.substring(4);
                }
                c0318n3.o(strSubstring.getBytes());
                if (zStartsWith) {
                    c0318n3.n(strSubstring.getBytes());
                } else {
                    int iLastIndexOf2 = strSubstring.lastIndexOf(".");
                    if (iLastIndexOf2 != -1) {
                        strSubstring = strSubstring.substring(0, iLastIndexOf2);
                    }
                    c0318n3.n(strSubstring.getBytes());
                }
                c0318n3.u(next.f153k.getBytes());
                c0318n3.t(next.f153k.getBytes());
                if (next.s()) {
                    c0318n3.s(next.f155m);
                } else {
                    Y1.a.l("Unsupport file attachment: %s", next);
                }
                c0313i.b(c0318n3);
            }
            this.f195n = c0313i;
        }
        return this.f195n;
    }

    @Override // java.util.List
    public final void add(int i2, o oVar) throws C0341b {
        o oVar2 = oVar;
        if (oVar2 != null) {
            int iW = oVar2.w();
            r(iW);
            this.f192k.add(i2, oVar2);
            C(iW);
            oVar2.h(this);
            Iterator<h> it = this.f174i.iterator();
            while (it.hasNext()) {
                oVar2.h(it.next());
            }
            g();
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends o> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        if (this.f192k.size() > 0) {
            Iterator<o> it = this.f192k.iterator();
            while (it.hasNext()) {
                o next = it.next();
                next.n(this);
                Iterator<h> it2 = this.f174i.iterator();
                while (it2.hasNext()) {
                    next.n(it2.next());
                }
            }
            this.f196o = 0;
            this.f192k.clear();
            g();
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f192k.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        return this.f192k.containsAll(collection);
    }

    @Override // G0.h
    public final void d() {
        this.f194m = null;
        this.f195n = null;
    }

    @Override // G0.l
    protected final void i(h hVar) {
        this.f191j.h(hVar);
        Iterator<o> it = this.f192k.iterator();
        while (it.hasNext()) {
            it.next().h(hVar);
        }
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f192k.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f192k.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<o> iterator() {
        return this.f192k.iterator();
    }

    @Override // G0.l
    protected final void l() {
        this.f191j.k();
        Iterator<o> it = this.f192k.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.f192k.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<o> listIterator() {
        return this.f192k.listIterator();
    }

    @Override // G0.l
    protected final void o(h hVar) {
        this.f191j.n(hVar);
        Iterator<o> it = this.f192k.iterator();
        while (it.hasNext()) {
            it.next().n(hVar);
        }
    }

    @Override // java.util.List, java.util.Collection
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final boolean add(o oVar) {
        if (oVar == null) {
            return false;
        }
        int iW = oVar.w();
        r(iW);
        this.f192k.add(oVar);
        C(iW);
        oVar.h(this);
        Iterator<h> it = this.f174i.iterator();
        while (it.hasNext()) {
            oVar.h(it.next());
        }
        g();
        return true;
    }

    public final boolean q(g gVar) {
        int i2 = gVar.f156n;
        r(i2);
        this.f193l.add(gVar);
        C(i2);
        gVar.h(this);
        Iterator<h> it = this.f174i.iterator();
        while (it.hasNext()) {
            gVar.h(it.next());
        }
        g();
        return true;
    }

    public final void r(int i2) throws C0341b {
        e eVarD = f.d();
        int i4 = this.f196o;
        this.p.getContentResolver();
        Objects.requireNonNull((b) eVarD);
        if (i4 < 0 || i2 < 0) {
            throw new C0341b("Negative message size or increase size");
        }
        int i5 = i4 + i2;
        if (i5 < 0 || i5 > k0.d.j()) {
            throw new k0.c("Exceed message size limitation");
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public final o set(int i2, o oVar) throws C0341b {
        o oVar2 = oVar;
        o oVar3 = this.f192k.get(i2);
        if (oVar2 != null) {
            int iW = oVar2.w();
            int iW2 = oVar3 != null ? oVar3.w() : 0;
            if (iW > iW2) {
                int i4 = iW - iW2;
                r(i4);
                C(i4);
            } else {
                u(iW2 - iW);
            }
        }
        o oVar4 = this.f192k.set(i2, oVar2);
        if (oVar4 != null) {
            oVar4.k();
        }
        if (oVar2 != null) {
            oVar2.h(this);
            Iterator<h> it = this.f174i.iterator();
            while (it.hasNext()) {
                oVar2.h(it.next());
            }
        }
        g();
        return oVar4;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f192k.size();
    }

    @Override // java.util.List
    public final List<o> subList(int i2, int i4) {
        return this.f192k.subList(i2, i4);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return this.f192k.toArray();
    }

    public final void u(int i2) {
        if (i2 > 0) {
            this.f196o -= i2;
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public final void v(Uri uri) throws C0303b, k0.c {
        Iterator<g> it = this.f193l.iterator();
        int i2 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            i4 += it.next().f156n;
        }
        Iterator<o> it2 = this.f192k.iterator();
        int i5 = 0;
        while (it2.hasNext()) {
            Iterator<k> it3 = it2.next().iterator();
            while (it3.hasNext()) {
                k next = it3.next();
                Objects.requireNonNull(next);
                if (next instanceof i) {
                    i5++;
                } else {
                    i4 += next.f173r;
                }
            }
        }
        if (Log.isLoggable("Mms:app", 2)) {
            StringBuilder sbD = D2.e.d("finalResize: original message size: ");
            sbD.append(this.f196o);
            sbD.append(" getMaxMessageSize: ");
            sbD.append(k0.d.j());
            sbD.append(" fixedSizeTotal: ");
            sbD.append(i4);
            Log.v("Mms/slideshow", sbD.toString());
        }
        if (i5 > 0) {
            int iJ = (k0.d.j() - i4) - 1024;
            if (iJ <= 0) {
                throw new k0.c("No room for pictures");
            }
            try {
                long id = ContentUris.parseId(uri);
                int i6 = iJ / i5;
                Iterator<o> it4 = this.f192k.iterator();
                while (it4.hasNext()) {
                    Iterator<k> it5 = it4.next().iterator();
                    while (it5.hasNext()) {
                        k next2 = it5.next();
                        Objects.requireNonNull(next2);
                        if (next2 instanceof i) {
                            next2.A(i6, id);
                        }
                    }
                }
                Iterator<o> it6 = this.f192k.iterator();
                while (it6.hasNext()) {
                    Iterator<k> it7 = it6.next().iterator();
                    while (it7.hasNext()) {
                        i2 += it7.next().f173r;
                    }
                }
                if (Log.isLoggable("Mms:app", 2)) {
                    Log.v("Mms/slideshow", "finalResize: new message size: " + i2);
                }
                if (i2 > k0.d.j()) {
                    throw new k0.c("After compressing pictures, message too big");
                }
                this.f196o = i2;
                d();
                C0319o.e(this.p.getApplicationContext()).u(uri, I(), -1);
            } catch (NullPointerException unused) {
                throw new C0303b("attachment not found");
            }
        }
    }

    @Override // java.util.List
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final o get(int i2) {
        if (i2 < 0 || i2 >= this.f192k.size()) {
            return null;
        }
        return this.f192k.get(i2);
    }

    public final ArrayList<g> x() {
        return this.f193l;
    }

    public final int y() {
        return this.f196o;
    }

    public final j z() {
        return this.f191j;
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection<? extends o> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public final ListIterator<o> listIterator(int i2) {
        return this.f192k.listIterator(i2);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        if (obj == null || !this.f192k.remove(obj)) {
            return false;
        }
        o oVar = (o) obj;
        u(oVar.w());
        oVar.k();
        g();
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) this.f192k.toArray(tArr);
    }

    private p(j jVar, ArrayList<o> arrayList, ArrayList<g> arrayList2, a4.e eVar, C0313i c0313i, Context context) {
        this.f191j = jVar;
        this.f192k = arrayList;
        this.f193l = arrayList2;
        this.p = context;
        this.f194m = eVar;
        this.f195n = c0313i;
        Iterator<o> it = arrayList.iterator();
        while (it.hasNext()) {
            o next = it.next();
            C(next.w());
            next.J(this);
        }
        Iterator<g> it2 = this.f193l.iterator();
        while (it2.hasNext()) {
            C(it2.next().f156n);
        }
    }
}
