package A0;

import android.util.Log;
import java.util.ArrayList;
import org.w3c.dom.DOMException;

/* loaded from: classes.dex */
public abstract class d implements a4.d {

    /* renamed from: a, reason: collision with root package name */
    final a4.f f0a;

    d(a4.f fVar) {
        this.f0a = fVar;
    }

    @Override // a4.d
    public final o a() {
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = this.f0a.getAttribute("end").split(";");
        if (strArrSplit.length != 1 || strArrSplit[0].length() != 0) {
            for (String str : strArrSplit) {
                try {
                    arrayList.add(new n(str));
                } catch (IllegalArgumentException e2) {
                    Log.e("ElementTimeImpl", "Malformed time value.", e2);
                }
            }
        }
        if (arrayList.size() == 0) {
            float fL = l();
            if (fL < 0.0f) {
                arrayList.add(new n("indefinite"));
            } else {
                o oVarF = f();
                for (int i2 = 0; i2 < oVarF.a(); i2++) {
                    arrayList.add(new n((oVarF.b(i2).c() + fL) + "s"));
                }
            }
        }
        return new o(arrayList);
    }

    public final short b() {
        String attribute = this.f0a.getAttribute("fillDefault");
        if (attribute.equalsIgnoreCase("remove")) {
            return (short) 0;
        }
        if (attribute.equalsIgnoreCase("freeze")) {
            return (short) 1;
        }
        if (attribute.equalsIgnoreCase("auto")) {
            return (short) 2;
        }
        if (attribute.equalsIgnoreCase("hold") || attribute.equalsIgnoreCase("transition")) {
            return (short) 1;
        }
        a4.d dVarC = c();
        if (dVarC == null) {
            return (short) 2;
        }
        return ((d) dVarC).b();
    }

    abstract a4.d c();

    @Override // a4.d
    public o f() {
        String[] strArrSplit = this.f0a.getAttribute("begin").split(";");
        ArrayList arrayList = new ArrayList();
        for (String str : strArrSplit) {
            try {
                arrayList.add(new n(str));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (arrayList.size() == 0) {
            arrayList.add(new n("0"));
        }
        return new o(arrayList);
    }

    @Override // a4.d
    public float l() {
        try {
            String attribute = this.f0a.getAttribute("dur");
            if (attribute != null) {
                return n.e(attribute) / 1000.0f;
            }
            return 0.0f;
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    @Override // a4.d
    public final void p(float f4) throws DOMException {
        this.f0a.setAttribute("dur", Integer.toString((int) (f4 * 1000.0f)) + "ms");
    }

    @Override // a4.d
    public final short x() {
        boolean z4;
        short sB;
        String attribute = this.f0a.getAttribute("fill");
        if (attribute.equalsIgnoreCase("freeze")) {
            return (short) 1;
        }
        if (attribute.equalsIgnoreCase("remove")) {
            return (short) 0;
        }
        if (attribute.equalsIgnoreCase("hold") || attribute.equalsIgnoreCase("transition")) {
            return (short) 1;
        }
        if (!attribute.equalsIgnoreCase("auto") && (sB = b()) != 2) {
            return sB;
        }
        if (this.f0a.getAttribute("dur").length() != 0 || this.f0a.getAttribute("end").length() != 0 || this.f0a.getAttribute("repeatCount").length() != 0 || this.f0a.getAttribute("repeatDur").length() != 0) {
            o oVarF = f();
            o oVarA = a();
            if (oVarF.a() == 1 && oVarA.a() == 1) {
                a4.m mVarB = oVarF.b(0);
                a4.m mVarB2 = oVarA.b(0);
                mVarB.b();
                mVarB2.b();
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                return (short) 0;
            }
        }
        return (short) 1;
    }
}
