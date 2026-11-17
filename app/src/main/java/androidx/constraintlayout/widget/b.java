package androidx.constraintlayout.widget;

import D2.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import com.android.mmt.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.core.util.SystemProperties;
import org.xmlpull.v1.XmlPullParserException;
import t.C0383a;
import t.C0384b;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f3198b = {0, 4, 8};

    /* renamed from: c, reason: collision with root package name */
    private static SparseIntArray f3199c;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, C0061b> f3200a = new HashMap<>();

    /* renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    private static class C0061b {

        /* renamed from: A, reason: collision with root package name */
        public int f3201A;

        /* renamed from: B, reason: collision with root package name */
        public int f3202B;

        /* renamed from: C, reason: collision with root package name */
        public int f3203C;

        /* renamed from: D, reason: collision with root package name */
        public int f3204D;

        /* renamed from: E, reason: collision with root package name */
        public int f3205E;

        /* renamed from: F, reason: collision with root package name */
        public int f3206F;

        /* renamed from: G, reason: collision with root package name */
        public int f3207G;

        /* renamed from: H, reason: collision with root package name */
        public int f3208H;

        /* renamed from: I, reason: collision with root package name */
        public int f3209I;

        /* renamed from: J, reason: collision with root package name */
        public int f3210J;

        /* renamed from: K, reason: collision with root package name */
        public int f3211K;
        public int L;
        public int M;

        /* renamed from: N, reason: collision with root package name */
        public int f3212N;

        /* renamed from: O, reason: collision with root package name */
        public int f3213O;
        public int P;

        /* renamed from: Q, reason: collision with root package name */
        public float f3214Q;

        /* renamed from: R, reason: collision with root package name */
        public float f3215R;

        /* renamed from: S, reason: collision with root package name */
        public int f3216S;

        /* renamed from: T, reason: collision with root package name */
        public int f3217T;

        /* renamed from: U, reason: collision with root package name */
        public float f3218U;

        /* renamed from: V, reason: collision with root package name */
        public boolean f3219V;

        /* renamed from: W, reason: collision with root package name */
        public float f3220W;

        /* renamed from: X, reason: collision with root package name */
        public float f3221X;

        /* renamed from: Y, reason: collision with root package name */
        public float f3222Y;

        /* renamed from: Z, reason: collision with root package name */
        public float f3223Z;

        /* renamed from: a, reason: collision with root package name */
        boolean f3224a;

        /* renamed from: a0, reason: collision with root package name */
        public float f3225a0;

        /* renamed from: b, reason: collision with root package name */
        public int f3226b;

        /* renamed from: b0, reason: collision with root package name */
        public float f3227b0;

        /* renamed from: c, reason: collision with root package name */
        public int f3228c;

        /* renamed from: c0, reason: collision with root package name */
        public float f3229c0;
        int d;

        /* renamed from: d0, reason: collision with root package name */
        public float f3230d0;

        /* renamed from: e, reason: collision with root package name */
        public int f3231e;

        /* renamed from: e0, reason: collision with root package name */
        public float f3232e0;

        /* renamed from: f, reason: collision with root package name */
        public int f3233f;

        /* renamed from: f0, reason: collision with root package name */
        public float f3234f0;
        public float g;

        /* renamed from: g0, reason: collision with root package name */
        public float f3235g0;

        /* renamed from: h, reason: collision with root package name */
        public int f3236h;

        /* renamed from: h0, reason: collision with root package name */
        public boolean f3237h0;

        /* renamed from: i, reason: collision with root package name */
        public int f3238i;

        /* renamed from: i0, reason: collision with root package name */
        public boolean f3239i0;

        /* renamed from: j, reason: collision with root package name */
        public int f3240j;

        /* renamed from: j0, reason: collision with root package name */
        public int f3241j0;

        /* renamed from: k, reason: collision with root package name */
        public int f3242k;

        /* renamed from: k0, reason: collision with root package name */
        public int f3243k0;

        /* renamed from: l, reason: collision with root package name */
        public int f3244l;

        /* renamed from: l0, reason: collision with root package name */
        public int f3245l0;

        /* renamed from: m, reason: collision with root package name */
        public int f3246m;

        /* renamed from: m0, reason: collision with root package name */
        public int f3247m0;

        /* renamed from: n, reason: collision with root package name */
        public int f3248n;

        /* renamed from: n0, reason: collision with root package name */
        public int f3249n0;

        /* renamed from: o, reason: collision with root package name */
        public int f3250o;

        /* renamed from: o0, reason: collision with root package name */
        public int f3251o0;
        public int p;
        public float p0;

        /* renamed from: q, reason: collision with root package name */
        public int f3252q;
        public float q0;

        /* renamed from: r, reason: collision with root package name */
        public int f3253r;

        /* renamed from: r0, reason: collision with root package name */
        public boolean f3254r0;

        /* renamed from: s, reason: collision with root package name */
        public int f3255s;

        /* renamed from: s0, reason: collision with root package name */
        public int f3256s0;

        /* renamed from: t, reason: collision with root package name */
        public int f3257t;

        /* renamed from: t0, reason: collision with root package name */
        public int f3258t0;
        public float u;

        /* renamed from: u0, reason: collision with root package name */
        public int[] f3259u0;

        /* renamed from: v, reason: collision with root package name */
        public float f3260v;

        /* renamed from: v0, reason: collision with root package name */
        public String f3261v0;

        /* renamed from: w, reason: collision with root package name */
        public String f3262w;

        /* renamed from: x, reason: collision with root package name */
        public int f3263x;

        /* renamed from: y, reason: collision with root package name */
        public int f3264y;

        /* renamed from: z, reason: collision with root package name */
        public float f3265z;

        private C0061b() {
            this.f3224a = false;
            this.f3231e = -1;
            this.f3233f = -1;
            this.g = -1.0f;
            this.f3236h = -1;
            this.f3238i = -1;
            this.f3240j = -1;
            this.f3242k = -1;
            this.f3244l = -1;
            this.f3246m = -1;
            this.f3248n = -1;
            this.f3250o = -1;
            this.p = -1;
            this.f3252q = -1;
            this.f3253r = -1;
            this.f3255s = -1;
            this.f3257t = -1;
            this.u = 0.5f;
            this.f3260v = 0.5f;
            this.f3262w = null;
            this.f3263x = -1;
            this.f3264y = 0;
            this.f3265z = 0.0f;
            this.f3201A = -1;
            this.f3202B = -1;
            this.f3203C = -1;
            this.f3204D = -1;
            this.f3205E = -1;
            this.f3206F = -1;
            this.f3207G = -1;
            this.f3208H = -1;
            this.f3209I = -1;
            this.f3210J = 0;
            this.f3211K = -1;
            this.L = -1;
            this.M = -1;
            this.f3212N = -1;
            this.f3213O = -1;
            this.P = -1;
            this.f3214Q = 0.0f;
            this.f3215R = 0.0f;
            this.f3216S = 0;
            this.f3217T = 0;
            this.f3218U = 1.0f;
            this.f3219V = false;
            this.f3220W = 0.0f;
            this.f3221X = 0.0f;
            this.f3222Y = 0.0f;
            this.f3223Z = 0.0f;
            this.f3225a0 = 1.0f;
            this.f3227b0 = 1.0f;
            this.f3229c0 = Float.NaN;
            this.f3230d0 = Float.NaN;
            this.f3232e0 = 0.0f;
            this.f3234f0 = 0.0f;
            this.f3235g0 = 0.0f;
            this.f3237h0 = false;
            this.f3239i0 = false;
            this.f3241j0 = 0;
            this.f3243k0 = 0;
            this.f3245l0 = -1;
            this.f3247m0 = -1;
            this.f3249n0 = -1;
            this.f3251o0 = -1;
            this.p0 = 1.0f;
            this.q0 = 1.0f;
            this.f3254r0 = false;
            this.f3256s0 = -1;
            this.f3258t0 = -1;
        }

        static void b(C0061b c0061b, androidx.constraintlayout.widget.a aVar, int i2, c.a aVar2) {
            c0061b.f(i2, aVar2);
            if (aVar instanceof C0383a) {
                c0061b.f3258t0 = 1;
                C0383a c0383a = (C0383a) aVar;
                c0061b.f3256s0 = c0383a.i();
                c0061b.f3259u0 = Arrays.copyOf(c0383a.f3193i, c0383a.f3194j);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i2, ConstraintLayout.a aVar) {
            this.d = i2;
            this.f3236h = aVar.d;
            this.f3238i = aVar.f3166e;
            this.f3240j = aVar.f3168f;
            this.f3242k = aVar.g;
            this.f3244l = aVar.f3171h;
            this.f3246m = aVar.f3173i;
            this.f3248n = aVar.f3175j;
            this.f3250o = aVar.f3177k;
            this.p = aVar.f3179l;
            this.f3252q = aVar.p;
            this.f3253r = aVar.f3183q;
            this.f3255s = aVar.f3184r;
            this.f3257t = aVar.f3185s;
            this.u = aVar.f3191z;
            this.f3260v = aVar.f3136A;
            this.f3262w = aVar.f3137B;
            this.f3263x = aVar.f3180m;
            this.f3264y = aVar.f3181n;
            this.f3265z = aVar.f3182o;
            this.f3201A = aVar.P;
            this.f3202B = aVar.f3149Q;
            this.f3203C = aVar.f3150R;
            this.g = aVar.f3163c;
            this.f3231e = aVar.f3159a;
            this.f3233f = aVar.f3161b;
            this.f3226b = ((ViewGroup.MarginLayoutParams) aVar).width;
            this.f3228c = ((ViewGroup.MarginLayoutParams) aVar).height;
            this.f3204D = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            this.f3205E = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            this.f3206F = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            this.f3207G = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            this.f3214Q = aVar.f3140E;
            this.f3215R = aVar.f3139D;
            this.f3217T = aVar.f3142G;
            this.f3216S = aVar.f3141F;
            boolean z4 = aVar.f3151S;
            this.f3239i0 = aVar.f3152T;
            this.f3241j0 = aVar.f3143H;
            this.f3243k0 = aVar.f3144I;
            this.f3237h0 = z4;
            this.f3245l0 = aVar.L;
            this.f3247m0 = aVar.M;
            this.f3249n0 = aVar.f3145J;
            this.f3251o0 = aVar.f3146K;
            this.p0 = aVar.f3147N;
            this.q0 = aVar.f3148O;
            this.f3208H = aVar.getMarginEnd();
            this.f3209I = aVar.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i2, c.a aVar) {
            e(i2, aVar);
            this.f3218U = aVar.f3267l0;
            this.f3221X = aVar.f3270o0;
            this.f3222Y = aVar.p0;
            this.f3223Z = aVar.q0;
            this.f3225a0 = aVar.f3271r0;
            this.f3227b0 = aVar.f3272s0;
            this.f3229c0 = aVar.f3273t0;
            this.f3230d0 = aVar.f3274u0;
            this.f3232e0 = aVar.f3275v0;
            this.f3234f0 = aVar.f3276w0;
            this.f3235g0 = 0.0f;
            this.f3220W = aVar.f3269n0;
            this.f3219V = aVar.f3268m0;
        }

        public final Object clone() throws CloneNotSupportedException {
            C0061b c0061b = new C0061b();
            c0061b.f3224a = this.f3224a;
            c0061b.f3226b = this.f3226b;
            c0061b.f3228c = this.f3228c;
            c0061b.f3231e = this.f3231e;
            c0061b.f3233f = this.f3233f;
            c0061b.g = this.g;
            c0061b.f3236h = this.f3236h;
            c0061b.f3238i = this.f3238i;
            c0061b.f3240j = this.f3240j;
            c0061b.f3242k = this.f3242k;
            c0061b.f3244l = this.f3244l;
            c0061b.f3246m = this.f3246m;
            c0061b.f3248n = this.f3248n;
            c0061b.f3250o = this.f3250o;
            c0061b.p = this.p;
            c0061b.f3252q = this.f3252q;
            c0061b.f3253r = this.f3253r;
            c0061b.f3255s = this.f3255s;
            c0061b.f3257t = this.f3257t;
            c0061b.u = this.u;
            c0061b.f3260v = this.f3260v;
            c0061b.f3262w = this.f3262w;
            c0061b.f3201A = this.f3201A;
            c0061b.f3202B = this.f3202B;
            c0061b.u = this.u;
            c0061b.u = this.u;
            c0061b.u = this.u;
            c0061b.u = this.u;
            c0061b.u = this.u;
            c0061b.f3203C = this.f3203C;
            c0061b.f3204D = this.f3204D;
            c0061b.f3205E = this.f3205E;
            c0061b.f3206F = this.f3206F;
            c0061b.f3207G = this.f3207G;
            c0061b.f3208H = this.f3208H;
            c0061b.f3209I = this.f3209I;
            c0061b.f3210J = this.f3210J;
            c0061b.f3211K = this.f3211K;
            c0061b.L = this.L;
            c0061b.M = this.M;
            c0061b.f3212N = this.f3212N;
            c0061b.f3213O = this.f3213O;
            c0061b.P = this.P;
            c0061b.f3214Q = this.f3214Q;
            c0061b.f3215R = this.f3215R;
            c0061b.f3216S = this.f3216S;
            c0061b.f3217T = this.f3217T;
            c0061b.f3218U = this.f3218U;
            c0061b.f3219V = this.f3219V;
            c0061b.f3220W = this.f3220W;
            c0061b.f3221X = this.f3221X;
            c0061b.f3222Y = this.f3222Y;
            c0061b.f3223Z = this.f3223Z;
            c0061b.f3225a0 = this.f3225a0;
            c0061b.f3227b0 = this.f3227b0;
            c0061b.f3229c0 = this.f3229c0;
            c0061b.f3230d0 = this.f3230d0;
            c0061b.f3232e0 = this.f3232e0;
            c0061b.f3234f0 = this.f3234f0;
            c0061b.f3235g0 = this.f3235g0;
            c0061b.f3237h0 = this.f3237h0;
            c0061b.f3239i0 = this.f3239i0;
            c0061b.f3241j0 = this.f3241j0;
            c0061b.f3243k0 = this.f3243k0;
            c0061b.f3245l0 = this.f3245l0;
            c0061b.f3247m0 = this.f3247m0;
            c0061b.f3249n0 = this.f3249n0;
            c0061b.f3251o0 = this.f3251o0;
            c0061b.p0 = this.p0;
            c0061b.q0 = this.q0;
            c0061b.f3256s0 = this.f3256s0;
            c0061b.f3258t0 = this.f3258t0;
            int[] iArr = this.f3259u0;
            if (iArr != null) {
                c0061b.f3259u0 = Arrays.copyOf(iArr, iArr.length);
            }
            c0061b.f3263x = this.f3263x;
            c0061b.f3264y = this.f3264y;
            c0061b.f3265z = this.f3265z;
            c0061b.f3254r0 = this.f3254r0;
            return c0061b;
        }

        public final void d(ConstraintLayout.a aVar) {
            aVar.d = this.f3236h;
            aVar.f3166e = this.f3238i;
            aVar.f3168f = this.f3240j;
            aVar.g = this.f3242k;
            aVar.f3171h = this.f3244l;
            aVar.f3173i = this.f3246m;
            aVar.f3175j = this.f3248n;
            aVar.f3177k = this.f3250o;
            aVar.f3179l = this.p;
            aVar.p = this.f3252q;
            aVar.f3183q = this.f3253r;
            aVar.f3184r = this.f3255s;
            aVar.f3185s = this.f3257t;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = this.f3204D;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = this.f3205E;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = this.f3206F;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = this.f3207G;
            aVar.f3189x = this.P;
            aVar.f3190y = this.f3213O;
            aVar.f3191z = this.u;
            aVar.f3136A = this.f3260v;
            aVar.f3180m = this.f3263x;
            aVar.f3181n = this.f3264y;
            aVar.f3182o = this.f3265z;
            aVar.f3137B = this.f3262w;
            aVar.P = this.f3201A;
            aVar.f3149Q = this.f3202B;
            aVar.f3140E = this.f3214Q;
            aVar.f3139D = this.f3215R;
            aVar.f3142G = this.f3217T;
            aVar.f3141F = this.f3216S;
            aVar.f3151S = this.f3237h0;
            aVar.f3152T = this.f3239i0;
            aVar.f3143H = this.f3241j0;
            aVar.f3144I = this.f3243k0;
            aVar.L = this.f3245l0;
            aVar.M = this.f3247m0;
            aVar.f3145J = this.f3249n0;
            aVar.f3146K = this.f3251o0;
            aVar.f3147N = this.p0;
            aVar.f3148O = this.q0;
            aVar.f3150R = this.f3203C;
            aVar.f3163c = this.g;
            aVar.f3159a = this.f3231e;
            aVar.f3161b = this.f3233f;
            ((ViewGroup.MarginLayoutParams) aVar).width = this.f3226b;
            ((ViewGroup.MarginLayoutParams) aVar).height = this.f3228c;
            aVar.setMarginStart(this.f3209I);
            aVar.setMarginEnd(this.f3208H);
            aVar.a();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3199c = sparseIntArray;
        sparseIntArray.append(55, 25);
        f3199c.append(56, 26);
        f3199c.append(58, 29);
        f3199c.append(59, 30);
        f3199c.append(64, 36);
        f3199c.append(63, 35);
        f3199c.append(37, 4);
        f3199c.append(36, 3);
        f3199c.append(34, 1);
        f3199c.append(72, 6);
        f3199c.append(73, 7);
        f3199c.append(44, 17);
        f3199c.append(45, 18);
        f3199c.append(46, 19);
        f3199c.append(0, 27);
        f3199c.append(60, 32);
        f3199c.append(61, 33);
        f3199c.append(43, 10);
        f3199c.append(42, 9);
        f3199c.append(76, 13);
        f3199c.append(79, 16);
        f3199c.append(77, 14);
        f3199c.append(74, 11);
        f3199c.append(78, 15);
        f3199c.append(75, 12);
        f3199c.append(67, 40);
        f3199c.append(53, 39);
        f3199c.append(52, 41);
        f3199c.append(66, 42);
        f3199c.append(51, 20);
        f3199c.append(65, 37);
        f3199c.append(41, 5);
        f3199c.append(54, 75);
        f3199c.append(62, 75);
        f3199c.append(57, 75);
        f3199c.append(35, 75);
        f3199c.append(33, 75);
        f3199c.append(5, 24);
        f3199c.append(7, 28);
        f3199c.append(23, 31);
        f3199c.append(24, 8);
        f3199c.append(6, 34);
        f3199c.append(8, 2);
        f3199c.append(3, 23);
        f3199c.append(4, 21);
        f3199c.append(2, 22);
        f3199c.append(13, 43);
        f3199c.append(26, 44);
        f3199c.append(21, 45);
        f3199c.append(22, 46);
        f3199c.append(20, 60);
        f3199c.append(18, 47);
        f3199c.append(19, 48);
        f3199c.append(14, 49);
        f3199c.append(15, 50);
        f3199c.append(16, 51);
        f3199c.append(17, 52);
        f3199c.append(25, 53);
        f3199c.append(68, 54);
        f3199c.append(47, 55);
        f3199c.append(69, 56);
        f3199c.append(48, 57);
        f3199c.append(70, 58);
        f3199c.append(49, 59);
        f3199c.append(38, 61);
        f3199c.append(40, 62);
        f3199c.append(39, 63);
        f3199c.append(1, 38);
        f3199c.append(71, 69);
        f3199c.append(50, 70);
        f3199c.append(29, 71);
        f3199c.append(28, 72);
        f3199c.append(30, 73);
        f3199c.append(27, 74);
    }

    private int[] h(View view, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object objE;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i2 = 0;
        int i4 = 0;
        while (i2 < strArrSplit.length) {
            String strTrim = strArrSplit[i2].trim();
            try {
                iIntValue = C0384b.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objE = ((ConstraintLayout) view.getParent()).e(strTrim)) != null && (objE instanceof Integer)) {
                iIntValue = ((Integer) objE).intValue();
            }
            iArr[i4] = iIntValue;
            i2++;
            i4++;
        }
        return i4 != strArrSplit.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    private C0061b i(Context context, AttributeSet attributeSet) {
        C0061b c0061b = new C0061b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2112d0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            int i4 = f3199c.get(index);
            switch (i4) {
                case 1:
                    c0061b.p = k(typedArrayObtainStyledAttributes, index, c0061b.p);
                    break;
                case 2:
                    c0061b.f3207G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3207G);
                    break;
                case 3:
                    c0061b.f3250o = k(typedArrayObtainStyledAttributes, index, c0061b.f3250o);
                    break;
                case 4:
                    c0061b.f3248n = k(typedArrayObtainStyledAttributes, index, c0061b.f3248n);
                    break;
                case 5:
                    c0061b.f3262w = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 6:
                    c0061b.f3201A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c0061b.f3201A);
                    break;
                case 7:
                    c0061b.f3202B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c0061b.f3202B);
                    break;
                case 8:
                    c0061b.f3208H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3208H);
                    break;
                case 9:
                    c0061b.f3257t = k(typedArrayObtainStyledAttributes, index, c0061b.f3257t);
                    break;
                case 10:
                    c0061b.f3255s = k(typedArrayObtainStyledAttributes, index, c0061b.f3255s);
                    break;
                case 11:
                    c0061b.f3212N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3212N);
                    break;
                case 12:
                    c0061b.f3213O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3213O);
                    break;
                case 13:
                    c0061b.f3211K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3211K);
                    break;
                case 14:
                    c0061b.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.M);
                    break;
                case 15:
                    c0061b.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.P);
                    break;
                case MenuBuilder.CATEGORY_SHIFT /* 16 */:
                    c0061b.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.L);
                    break;
                case 17:
                    c0061b.f3231e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c0061b.f3231e);
                    break;
                case 18:
                    c0061b.f3233f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c0061b.f3233f);
                    break;
                case 19:
                    c0061b.g = typedArrayObtainStyledAttributes.getFloat(index, c0061b.g);
                    break;
                case 20:
                    c0061b.u = typedArrayObtainStyledAttributes.getFloat(index, c0061b.u);
                    break;
                case 21:
                    c0061b.f3228c = typedArrayObtainStyledAttributes.getLayoutDimension(index, c0061b.f3228c);
                    break;
                case 22:
                    int i5 = typedArrayObtainStyledAttributes.getInt(index, c0061b.f3210J);
                    c0061b.f3210J = i5;
                    c0061b.f3210J = f3198b[i5];
                    break;
                case 23:
                    c0061b.f3226b = typedArrayObtainStyledAttributes.getLayoutDimension(index, c0061b.f3226b);
                    break;
                case 24:
                    c0061b.f3204D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3204D);
                    break;
                case 25:
                    c0061b.f3236h = k(typedArrayObtainStyledAttributes, index, c0061b.f3236h);
                    break;
                case 26:
                    c0061b.f3238i = k(typedArrayObtainStyledAttributes, index, c0061b.f3238i);
                    break;
                case 27:
                    c0061b.f3203C = typedArrayObtainStyledAttributes.getInt(index, c0061b.f3203C);
                    break;
                case 28:
                    c0061b.f3205E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3205E);
                    break;
                case 29:
                    c0061b.f3240j = k(typedArrayObtainStyledAttributes, index, c0061b.f3240j);
                    break;
                case 30:
                    c0061b.f3242k = k(typedArrayObtainStyledAttributes, index, c0061b.f3242k);
                    break;
                case SystemProperties.PROP_NAME_MAX /* 31 */:
                    c0061b.f3209I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3209I);
                    break;
                case 32:
                    c0061b.f3252q = k(typedArrayObtainStyledAttributes, index, c0061b.f3252q);
                    break;
                case 33:
                    c0061b.f3253r = k(typedArrayObtainStyledAttributes, index, c0061b.f3253r);
                    break;
                case 34:
                    c0061b.f3206F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3206F);
                    break;
                case 35:
                    c0061b.f3246m = k(typedArrayObtainStyledAttributes, index, c0061b.f3246m);
                    break;
                case 36:
                    c0061b.f3244l = k(typedArrayObtainStyledAttributes, index, c0061b.f3244l);
                    break;
                case 37:
                    c0061b.f3260v = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3260v);
                    break;
                case 38:
                    c0061b.d = typedArrayObtainStyledAttributes.getResourceId(index, c0061b.d);
                    break;
                case 39:
                    c0061b.f3215R = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3215R);
                    break;
                case 40:
                    c0061b.f3214Q = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3214Q);
                    break;
                case 41:
                    c0061b.f3216S = typedArrayObtainStyledAttributes.getInt(index, c0061b.f3216S);
                    break;
                case 42:
                    c0061b.f3217T = typedArrayObtainStyledAttributes.getInt(index, c0061b.f3217T);
                    break;
                case 43:
                    c0061b.f3218U = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3218U);
                    break;
                case 44:
                    c0061b.f3219V = true;
                    c0061b.f3220W = typedArrayObtainStyledAttributes.getDimension(index, c0061b.f3220W);
                    break;
                case 45:
                    c0061b.f3222Y = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3222Y);
                    break;
                case 46:
                    c0061b.f3223Z = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3223Z);
                    break;
                case 47:
                    c0061b.f3225a0 = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3225a0);
                    break;
                case 48:
                    c0061b.f3227b0 = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3227b0);
                    break;
                case 49:
                    c0061b.f3229c0 = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3229c0);
                    break;
                case 50:
                    c0061b.f3230d0 = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3230d0);
                    break;
                case 51:
                    c0061b.f3232e0 = typedArrayObtainStyledAttributes.getDimension(index, c0061b.f3232e0);
                    break;
                case 52:
                    c0061b.f3234f0 = typedArrayObtainStyledAttributes.getDimension(index, c0061b.f3234f0);
                    break;
                case 53:
                    c0061b.f3235g0 = typedArrayObtainStyledAttributes.getDimension(index, c0061b.f3235g0);
                    break;
                default:
                    switch (i4) {
                        case 60:
                            c0061b.f3221X = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3221X);
                            break;
                        case 61:
                            c0061b.f3263x = k(typedArrayObtainStyledAttributes, index, c0061b.f3263x);
                            break;
                        case 62:
                            c0061b.f3264y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0061b.f3264y);
                            break;
                        case 63:
                            c0061b.f3265z = typedArrayObtainStyledAttributes.getFloat(index, c0061b.f3265z);
                            break;
                        default:
                            switch (i4) {
                                case 69:
                                    c0061b.p0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    c0061b.q0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    c0061b.f3256s0 = typedArrayObtainStyledAttributes.getInt(index, c0061b.f3256s0);
                                    break;
                                case 73:
                                    c0061b.f3261v0 = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 74:
                                    c0061b.f3254r0 = typedArrayObtainStyledAttributes.getBoolean(index, c0061b.f3254r0);
                                    break;
                                case 75:
                                    StringBuilder sbD = e.d("unused attribute 0x");
                                    sbD.append(Integer.toHexString(index));
                                    sbD.append("   ");
                                    sbD.append(f3199c.get(index));
                                    Log.w("ConstraintSet", sbD.toString());
                                    break;
                                default:
                                    StringBuilder sbD2 = e.d("Unknown attribute 0x");
                                    sbD2.append(Integer.toHexString(index));
                                    sbD2.append("   ");
                                    sbD2.append(f3199c.get(index));
                                    Log.w("ConstraintSet", sbD2.toString());
                                    break;
                            }
                    }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return c0061b;
    }

    private static int k(TypedArray typedArray, int i2, int i4) {
        int resourceId = typedArray.getResourceId(i2, i4);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    private String m(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public final void a(ConstraintLayout constraintLayout) {
        b(constraintLayout);
        constraintLayout.h();
    }

    final void b(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f3200a.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.f3200a.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                C0061b c0061b = this.f3200a.get(Integer.valueOf(id));
                if (childAt instanceof C0383a) {
                    c0061b.f3258t0 = 1;
                }
                int i4 = c0061b.f3258t0;
                if (i4 != -1 && i4 == 1) {
                    C0383a c0383a = (C0383a) childAt;
                    c0383a.setId(id);
                    c0383a.k(c0061b.f3256s0);
                    c0383a.j(c0061b.f3254r0);
                    int[] iArr = c0061b.f3259u0;
                    if (iArr != null) {
                        c0383a.d(iArr);
                    } else {
                        String str = c0061b.f3261v0;
                        if (str != null) {
                            int[] iArrH = h(c0383a, str);
                            c0061b.f3259u0 = iArrH;
                            c0383a.d(iArrH);
                        }
                    }
                }
                ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
                c0061b.d(aVar);
                childAt.setLayoutParams(aVar);
                childAt.setVisibility(c0061b.f3210J);
                childAt.setAlpha(c0061b.f3218U);
                childAt.setRotation(c0061b.f3221X);
                childAt.setRotationX(c0061b.f3222Y);
                childAt.setRotationY(c0061b.f3223Z);
                childAt.setScaleX(c0061b.f3225a0);
                childAt.setScaleY(c0061b.f3227b0);
                if (!Float.isNaN(c0061b.f3229c0)) {
                    childAt.setPivotX(c0061b.f3229c0);
                }
                if (!Float.isNaN(c0061b.f3230d0)) {
                    childAt.setPivotY(c0061b.f3230d0);
                }
                childAt.setTranslationX(c0061b.f3232e0);
                childAt.setTranslationY(c0061b.f3234f0);
                childAt.setTranslationZ(c0061b.f3235g0);
                if (c0061b.f3219V) {
                    childAt.setElevation(c0061b.f3220W);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0061b c0061b2 = this.f3200a.get(num);
            int i5 = c0061b2.f3258t0;
            if (i5 != -1 && i5 == 1) {
                C0383a c0383a2 = new C0383a(constraintLayout.getContext());
                c0383a2.setId(num.intValue());
                int[] iArr2 = c0061b2.f3259u0;
                if (iArr2 != null) {
                    c0383a2.d(iArr2);
                } else {
                    String str2 = c0061b2.f3261v0;
                    if (str2 != null) {
                        int[] iArrH2 = h(c0383a2, str2);
                        c0061b2.f3259u0 = iArrH2;
                        c0383a2.d(iArrH2);
                    }
                }
                c0383a2.k(c0061b2.f3256s0);
                ConstraintLayout.a aVarGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                c0383a2.g();
                c0061b2.d(aVarGenerateDefaultLayoutParams);
                constraintLayout.addView(c0383a2, aVarGenerateDefaultLayoutParams);
            }
            if (c0061b2.f3224a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.a aVarGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                c0061b2.d(aVarGenerateDefaultLayoutParams2);
                constraintLayout.addView(guideline, aVarGenerateDefaultLayoutParams2);
            }
        }
    }

    public final void c(int i2) {
        if (this.f3200a.containsKey(Integer.valueOf(i2))) {
            C0061b c0061b = this.f3200a.get(Integer.valueOf(i2));
            c0061b.f3255s = -1;
            c0061b.f3257t = -1;
            c0061b.f3208H = -1;
            c0061b.f3213O = -1;
        }
    }

    public final void d(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f3200a.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f3200a.containsKey(Integer.valueOf(id))) {
                this.f3200a.put(Integer.valueOf(id), new C0061b());
            }
            C0061b c0061b = this.f3200a.get(Integer.valueOf(id));
            c0061b.e(id, aVar);
            c0061b.f3210J = childAt.getVisibility();
            c0061b.f3218U = childAt.getAlpha();
            c0061b.f3221X = childAt.getRotation();
            c0061b.f3222Y = childAt.getRotationX();
            c0061b.f3223Z = childAt.getRotationY();
            c0061b.f3225a0 = childAt.getScaleX();
            c0061b.f3227b0 = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                c0061b.f3229c0 = pivotX;
                c0061b.f3230d0 = pivotY;
            }
            c0061b.f3232e0 = childAt.getTranslationX();
            c0061b.f3234f0 = childAt.getTranslationY();
            c0061b.f3235g0 = childAt.getTranslationZ();
            if (c0061b.f3219V) {
                c0061b.f3220W = childAt.getElevation();
            }
            if (childAt instanceof C0383a) {
                C0383a c0383a = (C0383a) childAt;
                c0061b.f3254r0 = c0383a.h();
                c0061b.f3259u0 = Arrays.copyOf(c0383a.f3193i, c0383a.f3194j);
                c0061b.f3256s0 = c0383a.i();
            }
        }
    }

    public final void e(c cVar) {
        int childCount = cVar.getChildCount();
        this.f3200a.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = cVar.getChildAt(i2);
            c.a aVar = (c.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f3200a.containsKey(Integer.valueOf(id))) {
                this.f3200a.put(Integer.valueOf(id), new C0061b());
            }
            C0061b c0061b = this.f3200a.get(Integer.valueOf(id));
            if (childAt instanceof androidx.constraintlayout.widget.a) {
                C0061b.b(c0061b, (androidx.constraintlayout.widget.a) childAt, id, aVar);
            }
            c0061b.f(id, aVar);
        }
    }

    public final void f(int i2, int i4, int i5, int i6) {
        if (!this.f3200a.containsKey(Integer.valueOf(i2))) {
            this.f3200a.put(Integer.valueOf(i2), new C0061b());
        }
        C0061b c0061b = this.f3200a.get(Integer.valueOf(i2));
        switch (i4) {
            case 1:
                if (i6 == 1) {
                    c0061b.f3236h = i5;
                    c0061b.f3238i = -1;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException(C2.c.b(e.d("Left to "), m(i6), " undefined"));
                    }
                    c0061b.f3238i = i5;
                    c0061b.f3236h = -1;
                }
                c0061b.f3204D = 0;
                return;
            case 2:
                if (i6 == 1) {
                    c0061b.f3240j = i5;
                    c0061b.f3242k = -1;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3242k = i5;
                    c0061b.f3240j = -1;
                }
                c0061b.f3205E = 0;
                return;
            case 3:
                if (i6 == 3) {
                    c0061b.f3244l = i5;
                    c0061b.f3246m = -1;
                    c0061b.p = -1;
                } else {
                    if (i6 != 4) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3246m = i5;
                    c0061b.f3244l = -1;
                    c0061b.p = -1;
                }
                c0061b.f3206F = 0;
                return;
            case 4:
                if (i6 == 4) {
                    c0061b.f3250o = i5;
                    c0061b.f3248n = -1;
                    c0061b.p = -1;
                } else {
                    if (i6 != 3) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3248n = i5;
                    c0061b.f3250o = -1;
                    c0061b.p = -1;
                }
                c0061b.f3207G = 0;
                return;
            case 5:
                if (i6 != 5) {
                    throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                }
                c0061b.p = i5;
                c0061b.f3250o = -1;
                c0061b.f3248n = -1;
                c0061b.f3244l = -1;
                c0061b.f3246m = -1;
                return;
            case 6:
                if (i6 == 6) {
                    c0061b.f3253r = i5;
                    c0061b.f3252q = -1;
                } else {
                    if (i6 != 7) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3252q = i5;
                    c0061b.f3253r = -1;
                }
                c0061b.f3209I = 0;
                return;
            case 7:
                if (i6 == 7) {
                    c0061b.f3257t = i5;
                    c0061b.f3255s = -1;
                } else {
                    if (i6 != 6) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3255s = i5;
                    c0061b.f3257t = -1;
                }
                c0061b.f3208H = 0;
                return;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(m(i4));
                sb.append(" to ");
                throw new IllegalArgumentException(C2.c.b(sb, m(i6), " unknown"));
        }
    }

    public final void g(int i2, int i4, int i5, int i6) {
        if (!this.f3200a.containsKey(Integer.valueOf(i2))) {
            this.f3200a.put(Integer.valueOf(i2), new C0061b());
        }
        C0061b c0061b = this.f3200a.get(Integer.valueOf(i2));
        switch (i4) {
            case 1:
                if (i6 == 1) {
                    c0061b.f3236h = i5;
                    c0061b.f3238i = -1;
                    return;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException(C2.c.b(e.d("left to "), m(i6), " undefined"));
                    }
                    c0061b.f3238i = i5;
                    c0061b.f3236h = -1;
                    return;
                }
            case 2:
                if (i6 == 1) {
                    c0061b.f3240j = i5;
                    c0061b.f3242k = -1;
                    return;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3242k = i5;
                    c0061b.f3240j = -1;
                    return;
                }
            case 3:
                if (i6 == 3) {
                    c0061b.f3244l = i5;
                    c0061b.f3246m = -1;
                    c0061b.p = -1;
                    return;
                } else {
                    if (i6 != 4) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3246m = i5;
                    c0061b.f3244l = -1;
                    c0061b.p = -1;
                    return;
                }
            case 4:
                if (i6 == 4) {
                    c0061b.f3250o = i5;
                    c0061b.f3248n = -1;
                    c0061b.p = -1;
                    return;
                } else {
                    if (i6 != 3) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3248n = i5;
                    c0061b.f3250o = -1;
                    c0061b.p = -1;
                    return;
                }
            case 5:
                if (i6 != 5) {
                    throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                }
                c0061b.p = i5;
                c0061b.f3250o = -1;
                c0061b.f3248n = -1;
                c0061b.f3244l = -1;
                c0061b.f3246m = -1;
                return;
            case 6:
                if (i6 == 6) {
                    c0061b.f3253r = i5;
                    c0061b.f3252q = -1;
                    return;
                } else {
                    if (i6 != 7) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3252q = i5;
                    c0061b.f3253r = -1;
                    return;
                }
            case 7:
                if (i6 == 7) {
                    c0061b.f3257t = i5;
                    c0061b.f3255s = -1;
                    return;
                } else {
                    if (i6 != 6) {
                        throw new IllegalArgumentException(C2.c.b(e.d("right to "), m(i6), " undefined"));
                    }
                    c0061b.f3255s = i5;
                    c0061b.f3257t = -1;
                    return;
                }
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(m(i4));
                sb.append(" to ");
                throw new IllegalArgumentException(C2.c.b(sb, m(i6), " unknown"));
        }
    }

    public final void j(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    C0061b c0061bI = i(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        c0061bI.f3224a = true;
                    }
                    this.f3200a.put(Integer.valueOf(c0061bI.d), c0061bI);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    public final void l() {
        HashMap<Integer, C0061b> map = this.f3200a;
        Integer numValueOf = Integer.valueOf(R.id.subject);
        if (!map.containsKey(numValueOf)) {
            this.f3200a.put(numValueOf, new C0061b());
        }
        this.f3200a.get(numValueOf).P = 0;
    }
}
