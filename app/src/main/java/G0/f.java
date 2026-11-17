package G0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaDrmException;
import android.text.TextUtils;
import android.util.Log;
import f0.C0303b;
import g0.C0313i;
import g0.C0318n;
import j0.C0337b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.DOMException;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static b f151a;

    static void a(Z3.b bVar, k kVar) {
        bVar.v("SmilMediaStart", kVar);
        bVar.v("SmilMediaEnd", kVar);
        bVar.v("SmilMediaPause", kVar);
        bVar.v("SmilMediaSeek", kVar);
    }

    public static a4.i b(a4.e eVar) {
        A0.e eVar2 = (A0.e) eVar;
        a4.i iVar = (a4.i) eVar2.createElement("par");
        iVar.p(8.0f);
        eVar2.A().appendChild(iVar);
        return iVar;
    }

    public static a4.h c(String str, a4.e eVar, String str2) throws DOMException {
        a4.h hVar = (a4.h) eVar.createElement(str);
        if (str2.startsWith("cid:")) {
            String strSubstring = str2.substring(4);
            if (strSubstring.startsWith("<") && strSubstring.endsWith(">")) {
                StringBuilder sbD = D2.e.d("cid:");
                sbD.append(strSubstring.substring(1, strSubstring.length() - 1));
                str2 = sbD.toString();
            }
        }
        hVar.d(str2.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;"));
        return hVar;
    }

    public static e d() {
        if (f151a == null) {
            f151a = new b();
        }
        return f151a;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a4.e e(p pVar) throws DOMException {
        a4.h hVarC;
        int i2;
        int i4;
        A0.e eVar = new A0.e();
        a4.f fVar = (a4.f) eVar.createElement("smil");
        eVar.appendChild(fVar);
        a4.f fVar2 = (a4.f) eVar.createElement("head");
        fVar.appendChild(fVar2);
        a4.g gVar = (a4.g) eVar.createElement("layout");
        fVar2.appendChild(gVar);
        a4.l lVar = (a4.l) eVar.createElement("root-layout");
        j jVarZ = pVar.z();
        lVar.o(jVarZ.w());
        lVar.e(jVarZ.v());
        String strT = jVarZ.t();
        if (!TextUtils.isEmpty(strT)) {
            lVar.m(strT);
        }
        gVar.appendChild(lVar);
        ArrayList<n> arrayListX = jVarZ.x();
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = arrayListX.iterator();
        while (it.hasNext()) {
            n next = it.next();
            a4.j jVar = (a4.j) eVar.createElement("region");
            jVar.i(next.t());
            jVar.y(next.s());
            jVar.b(next.u());
            jVar.o(next.v());
            jVar.e(next.r());
            jVar.c(next.q());
            arrayList.add(jVar);
        }
        fVar.appendChild((a4.f) eVar.createElement("body"));
        Iterator<o> it2 = pVar.iterator();
        int i5 = 1;
        while (it2.hasNext()) {
            o next2 = it2.next();
            a4.i iVarB = b(eVar);
            iVarB.p(next2.u() / 1000.0f);
            Z3.b bVar = (Z3.b) iVarB;
            boolean zH = false;
            bVar.v("SmilSlideStart", next2);
            bVar.v("SmilSlideEnd", next2);
            Iterator<k> it3 = next2.iterator();
            boolean zH2 = false;
            while (it3.hasNext()) {
                k next3 = it3.next();
                String strA = p.A(i5, next3.f170n);
                i5++;
                if (!(next3 instanceof q)) {
                    if (next3 instanceof i) {
                        hVarC = c("img", eVar, strA);
                        zH = h((a4.k) hVarC, arrayList, gVar, "Image", zH);
                    } else if (next3 instanceof s) {
                        hVarC = c("video", eVar, strA);
                        zH = h((a4.k) hVarC, arrayList, gVar, "Image", zH);
                    } else if (next3 instanceof a) {
                        hVarC = c("audio", eVar, strA);
                    } else {
                        Log.w("Mms/smil", "Unsupport media: " + next3);
                    }
                    i2 = next3.f167k;
                    if (i2 != 0) {
                    }
                    i4 = next3.f168l;
                    if (i4 != 0) {
                    }
                    iVarB.appendChild(hVarC);
                    a((Z3.b) hVarC, next3);
                } else if (!TextUtils.isEmpty(((q) next3).H())) {
                    hVarC = c("text", eVar, strA);
                    zH2 = h((a4.k) hVarC, arrayList, gVar, "Text", zH2);
                    i2 = next3.f167k;
                    if (i2 != 0) {
                        hVarC.setAttribute("begin", String.valueOf(i2 / 1000));
                    }
                    i4 = next3.f168l;
                    if (i4 != 0) {
                        hVarC.p(i4 / 1000.0f);
                    }
                    iVarB.appendChild(hVarC);
                    a((Z3.b) hVarC, next3);
                } else if (i5 == 2) {
                    i5--;
                }
            }
        }
        return eVar;
    }

    @SuppressLint({"LogTagMismatch"})
    private static k f(Context context, String str, String str2, a4.h hVar, C0318n c0318n, n nVar) throws C0303b, MediaDrmException, IOException {
        k qVar;
        A0.o oVarA;
        byte[] bArrG = c0318n.g();
        if (bArrG == null) {
            throw new IllegalArgumentException("Content-Type of the part may not be null.");
        }
        String str3 = new String(bArrG);
        if (str.equals("text")) {
            qVar = new q(context, str3, str2, c0318n.b(), c0318n.h(), nVar);
        } else if (str.equals("img")) {
            qVar = new i(context, str3, str2, c0318n.i(), nVar);
        } else if (str.equals("video")) {
            qVar = new s(context, str3, str2, c0318n.i(), nVar);
        } else if (str.equals("audio")) {
            qVar = new a(context, str3, str2, c0318n.i());
        } else {
            if (!str.equals("ref")) {
                throw new IllegalArgumentException(D2.e.c("Unsupported TAG: ", str));
            }
            if (C0337b.g(str3)) {
                qVar = new q(context, str3, str2, c0318n.b(), c0318n.h(), nVar);
            } else if (C0337b.f(str3)) {
                qVar = new i(context, str3, str2, c0318n.i(), nVar);
            } else if (C0337b.h(str3)) {
                qVar = new s(context, str3, str2, c0318n.i(), nVar);
            } else if (C0337b.d(str3)) {
                qVar = new a(context, str3, str2, c0318n.i());
            } else {
                Log.d("Mms:media", "[MediaModelFactory] getGenericMediaModel Unsupported Content-Type: " + str3);
                qVar = new q(context, "text/plain", null, 106, new byte[0], nVar);
            }
        }
        A0.o oVarF = hVar.f();
        int iC = (oVarF == null || oVarF.a() <= 0) ? 0 : (int) (oVarF.b(0).c() * 1000.0d);
        qVar.f167k = iC;
        qVar.g();
        int iL = (int) (hVar.l() * 1000.0f);
        if (iL <= 0 && (oVarA = hVar.a()) != null && oVarA.a() > 0) {
            a4.m mVarB = oVarA.b(0);
            if (mVarB.d() != 0 && (iL = ((int) (mVarB.c() * 1000.0d)) - iC) == 0 && ((qVar instanceof a) || (qVar instanceof s))) {
                iL = k0.d.l();
                if (Log.isLoggable("Mms:app", 2)) {
                    Log.d("Mms:media", "[MediaModelFactory] compute new duration for " + str + ", duration=" + iL);
                }
            }
        }
        qVar.B(iL);
        if (k0.d.q()) {
            hVar.x();
            qVar.g();
        } else {
            qVar.g();
        }
        return qVar;
    }

    public static k g(Context context, a4.h hVar, j jVar, C0313i c0313i) throws C0303b, MediaDrmException, IOException, IllegalArgumentException {
        String strSubstring;
        C0318n c0318nG;
        boolean z4;
        String tagName = hVar.getTagName();
        String strR = hVar.r();
        C0318n c0318nE = null;
        if (strR != null) {
            strSubstring = strR.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "\"").replaceAll("&apos;", "'").replaceAll("&amp;", "&");
            if (strSubstring.startsWith("cid:")) {
                StringBuilder sbD = D2.e.d("<");
                sbD.append(strSubstring.substring(4));
                sbD.append(">");
                c0318nG = c0313i.d(sbD.toString());
            } else {
                c0318nG = c0313i.g(strSubstring);
                if (c0318nG == null && (c0318nG = c0313i.f(strSubstring)) == null) {
                    c0318nG = c0313i.e(strSubstring);
                }
            }
        } else {
            strSubstring = strR;
            c0318nG = null;
        }
        if (c0318nG != null) {
            c0318nE = c0318nG;
        } else {
            if (strSubstring != null) {
                if (strSubstring.startsWith("cid:")) {
                    strSubstring = strSubstring.substring(4);
                    z4 = true;
                } else {
                    z4 = false;
                }
                int iLastIndexOf = strSubstring.lastIndexOf(".");
                if (iLastIndexOf != -1) {
                    String strSubstring2 = strSubstring.substring(0, iLastIndexOf);
                    if (z4) {
                        c0318nE = c0313i.d("<" + strSubstring2 + ">");
                    } else {
                        c0318nE = c0313i.e(strSubstring2);
                    }
                }
            }
            if (c0318nE == null) {
                throw new IllegalArgumentException("No part found for the model.");
            }
        }
        if (!(hVar instanceof a4.k)) {
            return f(context, tagName, strR, hVar, c0318nE, null);
        }
        a4.k kVar = (a4.k) hVar;
        a4.j jVarQ = kVar.q();
        if (jVarQ != null) {
            n nVarS = jVar.s(jVarQ.getId());
            if (nVarS != null) {
                return f(context, tagName, strR, kVar, c0318nE, nVarS);
            }
        } else {
            n nVarS2 = jVar.s(tagName.equals("text") ? "Text" : "Image");
            if (nVarS2 != null) {
                return f(context, tagName, strR, kVar, c0318nE, nVarS2);
            }
        }
        throw new IllegalArgumentException("Region not found or bad region ID.");
    }

    private static boolean h(a4.k kVar, ArrayList arrayList, a4.g gVar, String str, boolean z4) throws DOMException {
        a4.j jVar;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                jVar = null;
                break;
            }
            jVar = (a4.j) it.next();
            if (jVar.getId().equals(str)) {
                break;
            }
        }
        if (z4 || jVar == null) {
            return false;
        }
        kVar.s(jVar);
        gVar.appendChild(jVar);
        return true;
    }
}
