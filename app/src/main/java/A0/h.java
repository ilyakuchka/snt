package A0;

import android.util.Log;
import org.w3c.dom.DOMException;

/* loaded from: classes.dex */
public class h extends f implements a4.h {
    a4.d g;

    final class a extends d {
        a(a4.f fVar) {
            super(fVar);
        }

        @Override // A0.d
        final a4.d c() {
            return ((i) this.f0a.getParentNode()).g;
        }

        @Override // A0.d, a4.d
        public final float l() {
            float fL = super.l();
            if (fL != 0.0f) {
                return fL;
            }
            String tagName = h.this.getTagName();
            if (tagName.equals("video") || tagName.equals("audio")) {
                return -1.0f;
            }
            if (tagName.equals("text") || tagName.equals("img")) {
                return 0.0f;
            }
            Log.w("Mms:smil", "Unknown media type");
            return fL;
        }
    }

    h(e eVar, String str) {
        super(eVar, str);
        this.g = new a(this);
    }

    @Override // a4.d
    public final o a() {
        return ((d) this.g).a();
    }

    @Override // a4.h
    public final void d(String str) throws DOMException {
        setAttribute("src", str);
    }

    @Override // a4.d
    public final o f() {
        return ((d) this.g).f();
    }

    @Override // a4.d
    public final float l() {
        return ((a) this.g).l();
    }

    @Override // a4.d
    public final void p(float f4) throws DOMException {
        ((d) this.g).p(f4);
    }

    @Override // a4.h
    public final String r() {
        return getAttribute("src");
    }

    @Override // a4.d
    public final short x() {
        return ((d) this.g).x();
    }
}
