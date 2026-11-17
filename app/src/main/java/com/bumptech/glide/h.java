package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class h<TranscodeType> extends o1.a<h<TranscodeType>> {

    /* renamed from: I, reason: collision with root package name */
    private final Context f6106I;

    /* renamed from: J, reason: collision with root package name */
    private final i f6107J;

    /* renamed from: K, reason: collision with root package name */
    private final Class<TranscodeType> f6108K;
    private final e L;
    private j<?, ? super TranscodeType> M;

    /* renamed from: N, reason: collision with root package name */
    private Object f6109N;

    /* renamed from: O, reason: collision with root package name */
    private List<o1.d<TranscodeType>> f6110O;
    private boolean P;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6111a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f6112b;

        static {
            int[] iArr = new int[f.values().length];
            f6112b = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6112b[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6112b[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6112b[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f6111a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6111a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6111a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6111a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6111a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6111a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6111a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6111a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
    }

    @SuppressLint({"CheckResult"})
    protected h(c cVar, i iVar, Class<TranscodeType> cls, Context context) {
        this.f6107J = iVar;
        this.f6108K = cls;
        this.f6106I = context;
        this.M = iVar.f6114i.h().e(cls);
        this.L = cVar.h();
        Iterator it = ((CopyOnWriteArrayList) iVar.p()).iterator();
        while (it.hasNext()) {
            a0((o1.d) it.next());
        }
        a(iVar.q());
    }

    private o1.b c0(Object obj, p1.f fVar, j jVar, f fVar2, int i2, int i4, o1.a aVar, Executor executor) {
        return k0(obj, fVar, aVar, jVar, fVar2, i2, i4, executor);
    }

    private p1.f f0(p1.f fVar, o1.a aVar, Executor executor) {
        Objects.requireNonNull(fVar, "Argument must not be null");
        if (!this.P) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        o1.b bVarC0 = c0(new Object(), fVar, this.M, aVar.v(), aVar.s(), aVar.r(), aVar, executor);
        o1.b bVarI = fVar.i();
        if (((o1.g) bVarC0).j(bVarI)) {
            if (!(!aVar.D() && bVarI.c())) {
                Objects.requireNonNull(bVarI, "Argument must not be null");
                if (!bVarI.isRunning()) {
                    bVarI.b();
                }
                return fVar;
            }
        }
        this.f6107J.o(fVar);
        fVar.b(bVarC0);
        this.f6107J.t(fVar, bVarC0);
        return fVar;
    }

    private o1.b k0(Object obj, p1.f fVar, o1.a aVar, j jVar, f fVar2, int i2, int i4, Executor executor) {
        Context context = this.f6106I;
        e eVar = this.L;
        return o1.g.n(context, eVar, obj, this.f6109N, this.f6108K, aVar, i2, i4, fVar2, fVar, this.f6110O, eVar.f(), jVar.b(), executor);
    }

    public h<TranscodeType> a0(o1.d<TranscodeType> dVar) {
        if (dVar != null) {
            if (this.f6110O == null) {
                this.f6110O = new ArrayList();
            }
            this.f6110O.add(dVar);
        }
        return this;
    }

    @Override // o1.a
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> a(o1.a<?> aVar) {
        Objects.requireNonNull(aVar, "Argument must not be null");
        return (h) super.a(aVar);
    }

    @Override // o1.a
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> clone() {
        h<TranscodeType> hVar = (h) super.clone();
        hVar.M = hVar.M.a();
        return hVar;
    }

    public final <Y extends p1.f<TranscodeType>> Y e0(Y y2) {
        f0(y2, this, s1.e.b());
        return y2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final p1.g<ImageView, TranscodeType> g0(ImageView imageView) {
        o1.a aVarK;
        s1.j.a();
        Objects.requireNonNull(imageView, "Argument must not be null");
        if (!I() && G() && imageView.getScaleType() != null) {
            switch (a.f6111a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarK = clone().K();
                    break;
                case 2:
                    aVarK = clone().L();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarK = clone().M();
                    break;
                case 6:
                    aVarK = clone().L();
                    break;
            }
        } else {
            aVarK = this;
        }
        p1.g<ImageView, TranscodeType> gVarA = this.L.a(imageView, this.f6108K);
        f0(gVarA, aVarK, s1.e.b());
        return gVarA;
    }

    public h<TranscodeType> h0(Uri uri) {
        this.f6109N = uri;
        this.P = true;
        return this;
    }

    public h<TranscodeType> i0(Object obj) {
        this.f6109N = obj;
        this.P = true;
        return this;
    }

    public h<TranscodeType> j0(String str) {
        this.f6109N = str;
        this.P = true;
        return this;
    }
}
