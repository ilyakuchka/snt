package com.android.mmt.util;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.android.mmt.util.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0277i {

    /* renamed from: A, reason: collision with root package name */
    private static final SimpleDateFormat f5985A;

    /* renamed from: B, reason: collision with root package name */
    public static String f5986B;

    /* renamed from: C, reason: collision with root package name */
    public static String f5987C;

    /* renamed from: D, reason: collision with root package name */
    private static Pattern f5988D;

    /* renamed from: E, reason: collision with root package name */
    private static Pattern f5989E;

    /* renamed from: F, reason: collision with root package name */
    private static final DateFormat[] f5990F;

    /* renamed from: G, reason: collision with root package name */
    private static Map<Character, Character> f5991G;

    /* renamed from: H, reason: collision with root package name */
    private static Map<String, Integer> f5992H;

    /* renamed from: I, reason: collision with root package name */
    private static Map<String, Integer> f5993I;

    /* renamed from: J, reason: collision with root package name */
    private static Map<String, Integer> f5994J;

    /* renamed from: K, reason: collision with root package name */
    private static Map<String, Integer> f5995K;
    private static Map<String, Integer> L;
    private static Map<String, Integer> M;

    /* renamed from: N, reason: collision with root package name */
    private static Map<String, Integer> f5996N;

    /* renamed from: O, reason: collision with root package name */
    private static Map<String, Integer> f5997O;
    private static Map<String, String> P;

    /* renamed from: Q, reason: collision with root package name */
    private static String f5998Q;

    /* renamed from: R, reason: collision with root package name */
    private static String f5999R;

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f6000a;

    /* renamed from: b, reason: collision with root package name */
    private static final SimpleDateFormat f6001b;

    /* renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f6002c;
    private static final SimpleDateFormat d;

    /* renamed from: e, reason: collision with root package name */
    private static final SimpleDateFormat f6003e;

    /* renamed from: f, reason: collision with root package name */
    private static final SimpleDateFormat f6004f;
    private static final SimpleDateFormat g;

    /* renamed from: h, reason: collision with root package name */
    private static final SimpleDateFormat f6005h;

    /* renamed from: i, reason: collision with root package name */
    private static final SimpleDateFormat f6006i;

    /* renamed from: j, reason: collision with root package name */
    private static final SimpleDateFormat f6007j;

    /* renamed from: k, reason: collision with root package name */
    private static final SimpleDateFormat f6008k;

    /* renamed from: l, reason: collision with root package name */
    private static final SimpleDateFormat f6009l;

    /* renamed from: m, reason: collision with root package name */
    private static final SimpleDateFormat f6010m;

    /* renamed from: n, reason: collision with root package name */
    private static final SimpleDateFormat f6011n;

    /* renamed from: o, reason: collision with root package name */
    private static final SimpleDateFormat f6012o;
    private static final SimpleDateFormat p;

    /* renamed from: q, reason: collision with root package name */
    private static final SimpleDateFormat f6013q;

    /* renamed from: r, reason: collision with root package name */
    private static final SimpleDateFormat f6014r;

    /* renamed from: s, reason: collision with root package name */
    private static final SimpleDateFormat f6015s;

    /* renamed from: t, reason: collision with root package name */
    private static final SimpleDateFormat f6016t;
    private static final SimpleDateFormat u;

    /* renamed from: v, reason: collision with root package name */
    private static final SimpleDateFormat f6017v;

    /* renamed from: w, reason: collision with root package name */
    private static final SimpleDateFormat f6018w;

    /* renamed from: x, reason: collision with root package name */
    private static final SimpleDateFormat f6019x;

    /* renamed from: y, reason: collision with root package name */
    private static final SimpleDateFormat f6020y;

    /* renamed from: z, reason: collision with root package name */
    private static final SimpleDateFormat f6021z;

    /* renamed from: com.android.mmt.util.i$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6022a;

        /* renamed from: b, reason: collision with root package name */
        private Date f6023b;

        /* renamed from: c, reason: collision with root package name */
        private int f6024c;

        public a(boolean z4, Date date, int i2) {
            this.f6022a = z4;
            this.f6023b = date;
            this.f6024c = i2;
        }

        public final Date a() {
            return this.f6023b;
        }

        public final int b() {
            return this.f6024c;
        }

        public final boolean c() {
            return this.f6022a;
        }
    }

    /* JADX WARN: Type inference failed for: r0v100, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v101, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v102, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v103, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v104, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v105, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v106, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v107, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v108, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v109, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v110, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v111, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v112, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v113, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v114, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v115, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v116, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v117, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v118, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v119, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v120, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v121, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v122, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v123, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v124, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v125, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v126, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v127, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v128, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v129, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v130, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v131, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v132, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v133, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v134, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v135, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v136, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v137, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v138, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v139, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v140, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v141, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v142, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v143, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v144, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v145, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v146, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v147, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v148, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v149, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v150, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v151, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v152, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v153, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v154, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v155, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v156, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v157, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v158, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v159, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v160, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v161, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v162, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v163, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v164, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v165, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v166, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v167, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v168, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v169, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v170, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v171, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v172, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v173, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v174, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v175, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v176, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v177, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v178, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v179, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v28, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v29, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v30, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v31, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v32, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v33, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v34, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v35, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v36, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v37, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v38, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v39, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v40, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v41, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v42, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v43, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v44, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v45, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v46, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v47, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v48, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v49, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v50, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v51, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r0v52, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v53, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v54, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v55, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v56, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v57, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v58, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v59, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v60, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v61, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v62, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v63, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v64, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v65, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v66, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v67, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v68, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v69, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v70, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v71, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v72, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v73, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v74, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v75, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v76, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v77, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v78, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v79, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v80, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v81, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v82, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v83, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v84, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v85, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v86, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v87, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v88, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v89, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v90, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v91, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v92, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v93, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v94, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v95, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v96, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v97, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v98, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v99, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    static {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm", locale);
        f6000a = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm yyyy/MM/dd", locale);
        f6001b = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy.MM.dd HH:mm", locale);
        f6002c = simpleDateFormat3;
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("HH:mm yyyy.MM.dd", locale);
        d = simpleDateFormat4;
        SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("yyyy/MM/dd HH:", locale);
        f6003e = simpleDateFormat5;
        SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat("HH: yyyy/MM/dd", locale);
        f6004f = simpleDateFormat6;
        SimpleDateFormat simpleDateFormat7 = new SimpleDateFormat("yyyy.MM.dd HH:", locale);
        g = simpleDateFormat7;
        SimpleDateFormat simpleDateFormat8 = new SimpleDateFormat("HH: yyyy.MM.dd", locale);
        f6005h = simpleDateFormat8;
        SimpleDateFormat simpleDateFormat9 = new SimpleDateFormat("yyyy/MM/dd", locale);
        f6006i = simpleDateFormat9;
        SimpleDateFormat simpleDateFormat10 = new SimpleDateFormat("yyyy.MM.dd", locale);
        f6007j = simpleDateFormat10;
        SimpleDateFormat simpleDateFormat11 = new SimpleDateFormat("MM/dd HH:mm", locale);
        f6008k = simpleDateFormat11;
        SimpleDateFormat simpleDateFormat12 = new SimpleDateFormat("MM.dd HH:mm", locale);
        f6009l = simpleDateFormat12;
        SimpleDateFormat simpleDateFormat13 = new SimpleDateFormat("MM/dd HH:");
        f6010m = simpleDateFormat13;
        SimpleDateFormat simpleDateFormat14 = new SimpleDateFormat("HH: MM/dd");
        f6011n = simpleDateFormat14;
        SimpleDateFormat simpleDateFormat15 = new SimpleDateFormat("MM.dd HH:");
        f6012o = simpleDateFormat15;
        SimpleDateFormat simpleDateFormat16 = new SimpleDateFormat("dd HH:mm");
        p = simpleDateFormat16;
        SimpleDateFormat simpleDateFormat17 = new SimpleDateFormat("dd HH:");
        f6013q = simpleDateFormat17;
        SimpleDateFormat simpleDateFormat18 = new SimpleDateFormat("MM/dd/yyyy HH:mm", locale);
        f6014r = simpleDateFormat18;
        SimpleDateFormat simpleDateFormat19 = new SimpleDateFormat("HH:mm MM/dd/yyyy", locale);
        f6015s = simpleDateFormat19;
        SimpleDateFormat simpleDateFormat20 = new SimpleDateFormat("MM/dd/yyyy HH:", locale);
        f6016t = simpleDateFormat20;
        SimpleDateFormat simpleDateFormat21 = new SimpleDateFormat("HH: MM/dd/yyyy", locale);
        u = simpleDateFormat21;
        SimpleDateFormat simpleDateFormat22 = new SimpleDateFormat("MM/dd", locale);
        f6017v = simpleDateFormat22;
        SimpleDateFormat simpleDateFormat23 = new SimpleDateFormat("MM.dd", locale);
        f6018w = simpleDateFormat23;
        SimpleDateFormat simpleDateFormat24 = new SimpleDateFormat("HH:mm:ss", locale);
        f6019x = simpleDateFormat24;
        SimpleDateFormat simpleDateFormat25 = new SimpleDateFormat("HH:mm", locale);
        f6020y = simpleDateFormat25;
        SimpleDateFormat simpleDateFormat26 = new SimpleDateFormat("HH:", locale);
        f6021z = simpleDateFormat26;
        SimpleDateFormat simpleDateFormat27 = new SimpleDateFormat("dd", locale);
        f5985A = simpleDateFormat27;
        f5986B = "(january|jan(\\.)?|february|feb(\\.)?|march|[Mm]ar(\\.)?|april|apr(\\.)?|may|may(\\.)?|june|jun(\\.)?|july|jul(\\.)?|august|aug(\\.)?|september|sep(\\.)?|october|oct(\\.)?|november|nov(\\.)?|december|dec(\\.)?)";
        f5987C = "(1st|2nd|3rd|((3[01]|[12][0-9]|0?[4-9])(th)?)|[1-3])";
        StringBuilder sbD = D2.e.d("((");
        sbD.append(f5986B);
        sbD.append("\\s+");
        sbD.append(f5987C);
        sbD.append(")|(");
        sbD.append(f5987C);
        sbD.append("\\s+");
        sbD.append(f5986B);
        sbD.append("))");
        f5988D = Pattern.compile(sbD.toString());
        f5989E = Pattern.compile("((((((2[0-4]|(1|0?)[0-9]):([1-5][0-9]|0?[0-9])(:([1-5][0-9]|0?[0-9]))?([aApP][mM])?)|(2[0-4]|(1|0?)[0-9])([aApP][mM]))(\\s+,?|(,\\s*))(((((\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))\\s+(1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3]))|((1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3])\\s+(\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))))(\\s+,?|(,\\s*))\\d{4})|(((\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))\\s+(1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3]))|((1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3])\\s+(\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))))|(((\\d{4})-)?(1[012]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9]))|(((\\d{4})/)?(1[012]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9]))|((\\d{4})\\.(1[012]|0?[1-9])\\.(3[01]|[12][0-9]|0?[1-9]))))|((((2[0-4]|(1|0?)[0-9]):([1-5][0-9]|0?[0-9])(:([1-5][0-9]|0?[0-9]))?([aApP][mM])?)|(2[0-4]|(1|0?)[0-9])([aApP][mM]))(\\s+(,|([Oo][Nn]\\s+))?|(,\\s*))(\\b(([Mm][Oo][Nn]|[Tt][Uu][Ee][Ss]|[Tt][Hh][Uu][Rr]|[Ff][Rr][Ii]|[Ss][Uu][Nn])((\\.)|([Dd][Aa][Yy]))?|[Ww][Ee][Dd]((\\.)|([Nn][Ee][Ss][Dd][Aa][Yy]))?|[Ss][Aa][Tt]((\\.)|([Uu][Rr][Dd][Aa][Yy]))?)))|(((((\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))\\s+(1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3]))|((1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3])\\s+(\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))))(\\s+,?|(,\\s*))\\d{4})|(((\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))\\s+(1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3]))|((1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3])\\s+(\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?)))))|(((2[0-4]|(1|0?)[0-9]):([1-5][0-9]|0?[0-9])(:([1-5][0-9]|0?[0-9]))?([aApP][mM])?)|(2[0-4]|(1|0?)[0-9])([aApP][mM]))))|((((([周週]|(星期))[一二三四五六日天])(凌晨|上午|下午|早上|晚上|傍晚|中午)?)|(((今|明|大?后)天|次日)(凌晨|上午|下午|早上|晚上|傍晚|中午))|(((((((\\d{4}|[零一二三四五六七八九]{4}|(今|明|大?[后後]))年))?((1[012]|0?[1-9]|十[一二]?|[一二三四五六七八九])月))?|((本|下[个個]?|这个|這個)月))((3[01]|[12][0-9]|0?[1-9]|三十一?|(二?十)[一二三四五六七八九]?|[一二三四五六七八九])(日|号|號)))(凌晨|上午|下午|早上|晚上|傍晚|中午)?)|(凌晨|上午|下午|早上|晚上|傍晚|中午)|((今|明|大?后)天|次日))?(2[0-4]|(1|0?)[0-9]|二十[一二三四]?|十?[一二三四五六七八九两兩]|零|十)(((时|点|時|點|[Pp][Mm])(([123一二三两]刻|半|[1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])(分(([1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])秒)?)?)?)|(:([123一二三两]刻|半|[1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])(:([1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩]))?))|((([周週]|(星期))[一二三四五六日天])(凌晨|上午|下午|早上|晚上|傍晚|中午)?)|(((今|明|大?后)天|次日)(凌晨|上午|下午|早上|晚上|傍晚|中午))|(((((((\\d{4}|[零一二三四五六七八九]{4}|(今|明|大?[后後]))年))?((1[012]|0?[1-9]|十[一二]?|[一二三四五六七八九])月))?|((本|下[个個]?|这个|這個)月))((3[01]|[12][0-9]|0?[1-9]|三十一?|(二?十)[一二三四五六七八九]?|[一二三四五六七八九])(日|号|號)))(凌晨|上午|下午|早上|晚上|傍晚|中午)?)|((((\\d{4})-)?(1[012]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])|((\\d{4})/)?(1[012]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9])|(\\d{4})\\.(1[012]|0?[1-9])\\.(3[01]|[12][0-9]|0?[1-9]))((凌晨|上午|下午|早上|晚上|傍晚|中午)|(\\s)+)((2[0-4]|(1|0?)[0-9]|二十[一二三四]?|十?[一二三四五六七八九两兩]|零|十)(((时|点|時|點|[Pp][Mm])(([123一二三两]刻|半|[1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])(分(([1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])秒)?)?)?)|(:([123一二三两]刻|半|[1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])(:([1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩]))?))))|((((\\d{4})-)?(1[012]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])|((\\d{4})/)?(1[012]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9])|(\\d{4})\\.(1[012]|0?[1-9])\\.(3[01]|[12][0-9]|0?[1-9]))((凌晨|上午|下午|早上|晚上|傍晚|中午))?))");
        f5990F = new DateFormat[]{simpleDateFormat, simpleDateFormat2, simpleDateFormat3, simpleDateFormat4, simpleDateFormat5, simpleDateFormat6, simpleDateFormat7, simpleDateFormat8, simpleDateFormat9, simpleDateFormat10, simpleDateFormat11, simpleDateFormat12, simpleDateFormat13, simpleDateFormat14, simpleDateFormat15, simpleDateFormat16, simpleDateFormat17, simpleDateFormat18, simpleDateFormat19, simpleDateFormat20, simpleDateFormat21, simpleDateFormat22, simpleDateFormat23, simpleDateFormat24, simpleDateFormat25, simpleDateFormat26, simpleDateFormat27};
        f5991G = new ArrayMap(32);
        f5992H = new ArrayMap(8);
        f5993I = new ArrayMap(8);
        f5994J = new ArrayMap(8);
        f5995K = new ArrayMap(8);
        L = new ArrayMap(4);
        M = new ArrayMap(8);
        f5996N = new ArrayMap(64);
        f5997O = new ArrayMap(48);
        P = new ArrayMap(6);
        f5998Q = "二三四五六七八九";
        f5999R = "一二三四五六七八九";
        f5991G.put((char) 24180, '/');
        f5991G.put((char) 26376, '/');
        f5991G.put((char) 26085, ' ');
        f5991G.put((char) 21495, ' ');
        f5991G.put((char) 34399, ' ');
        f5991G.put((char) 26102, ':');
        f5991G.put((char) 26178, ' ');
        f5991G.put((char) 28857, ':');
        f5991G.put((char) 40670, ' ');
        f5991G.put((char) 20998, ' ');
        f5991G.put('-', '/');
        f5991G.put((char) 19968, '1');
        f5991G.put((char) 20108, '2');
        f5991G.put((char) 19977, '3');
        f5991G.put((char) 22235, '4');
        f5991G.put((char) 20116, '5');
        f5991G.put((char) 20845, '6');
        f5991G.put((char) 19971, '7');
        f5991G.put((char) 20843, '8');
        f5991G.put((char) 20061, '9');
        f5991G.put((char) 21313, '1');
        f5991G.put((char) 20004, '2');
        f5991G.put((char) 20841, '2');
        f5991G.put((char) 38646, '0');
        f5992H.put("今天", 0);
        f5992H.put("今日", 0);
        f5992H.put("次日", 1);
        f5992H.put("明天", 1);
        f5992H.put("明日", 1);
        f5992H.put("后天", 2);
        f5992H.put("後天", 2);
        f5992H.put("大后天", 3);
        f5992H.put("大後天", 3);
        f5993I.put("本月", 0);
        f5993I.put("这个月", 0);
        f5993I.put("這個月", 0);
        f5993I.put("下月", 1);
        f5993I.put("下个月", 1);
        f5993I.put("下個月", 1);
        f5994J.put("今年", 0);
        f5994J.put("明年", 1);
        f5994J.put("后年", 2);
        f5994J.put("後年", 2);
        f5994J.put("大后年", 3);
        f5994J.put("大後年", 3);
        f5995K.put("凌晨", 0);
        f5995K.put("早上", 0);
        f5995K.put("早晨", 0);
        f5995K.put("上午", 0);
        f5995K.put("中午", 0);
        f5995K.put("下午", 12);
        f5995K.put("傍晚", 12);
        f5995K.put("晚上", 12);
        L.put("pm", 12);
        L.put("am", 0);
        M.put("凌晨", 0);
        M.put("早上", 9);
        M.put("早晨", 9);
        M.put("上午", 9);
        M.put("中午", 12);
        M.put("下午", 14);
        M.put("傍晚", 17);
        M.put("晚上", 20);
        P.put("半", "30");
        P.put("1刻", "15");
        P.put("2刻", "30");
        P.put("3刻", "45");
        f5996N.put("周1", 2);
        f5996N.put("周一", 2);
        f5996N.put("週1", 2);
        f5996N.put("週一", 2);
        f5996N.put("周2", 3);
        f5996N.put("周二", 3);
        f5996N.put("週2", 3);
        f5996N.put("週二", 3);
        f5996N.put("周3", 4);
        f5996N.put("周三", 4);
        f5996N.put("週3", 4);
        f5996N.put("週三", 4);
        f5996N.put("周4", 5);
        f5996N.put("周四", 5);
        f5996N.put("週4", 5);
        f5996N.put("週四", 5);
        f5996N.put("周5", 6);
        f5996N.put("周五", 6);
        f5996N.put("週5", 6);
        f5996N.put("週五", 6);
        f5996N.put("周6", 7);
        f5996N.put("周六", 7);
        f5996N.put("週6", 7);
        f5996N.put("週六", 7);
        f5996N.put("周日", 1);
        f5996N.put("週日", 1);
        f5996N.put("周天", 1);
        f5996N.put("週天", 1);
        f5996N.put("monday", 2);
        f5996N.put("tuesday", 3);
        f5996N.put("wednesday", 4);
        f5996N.put("thursday", 5);
        f5996N.put("friday", 6);
        f5996N.put("saturday", 7);
        f5996N.put("sunday", 1);
        f5996N.put("mon.", 2);
        f5996N.put("tues.", 3);
        f5996N.put("wed.", 4);
        f5996N.put("thur.", 5);
        f5996N.put("fri.", 6);
        f5996N.put("sat.", 7);
        f5996N.put("sun.", 1);
        f5996N.put("mon", 2);
        f5996N.put("tues", 3);
        f5996N.put("wed", 4);
        f5996N.put("thur", 5);
        f5996N.put("fri", 6);
        f5996N.put("sat", 7);
        f5996N.put("sun", 1);
        f5997O.put("january", 0);
        f5997O.put("february", 1);
        f5997O.put("march", 2);
        f5997O.put("april", 3);
        f5997O.put("may", 4);
        f5997O.put("june", 5);
        f5997O.put("july", 6);
        f5997O.put("august", 7);
        f5997O.put("september", 8);
        f5997O.put("october", 9);
        f5997O.put("november", 10);
        f5997O.put("december", 11);
        f5997O.put("jan.", 0);
        f5997O.put("feb.", 1);
        f5997O.put("mar.", 2);
        f5997O.put("apr.", 3);
        f5997O.put("may.", 4);
        f5997O.put("jun.", 5);
        f5997O.put("jul.", 6);
        f5997O.put("aug.", 7);
        f5997O.put("sept.", 8);
        f5997O.put("oct.", 9);
        f5997O.put("nov.", 10);
        f5997O.put("dec.", 11);
        f5997O.put("jan", 0);
        f5997O.put("feb", 1);
        f5997O.put("mar", 2);
        f5997O.put("apr", 3);
        f5997O.put("may", 4);
        f5997O.put("jun", 5);
        f5997O.put("jul", 6);
        f5997O.put("aug", 7);
        f5997O.put("sept", 8);
        f5997O.put("oct", 9);
        f5997O.put("nov", 10);
        f5997O.put("dec", 11);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0767 A[RETURN] */
    /* JADX WARN: Type inference failed for: r0v39, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v45, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v49, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r10v18, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r10v21, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r12v93, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r12v96, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r14v75, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r15v14, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r15v17, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r16v4, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r1v16, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v13, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r2v16, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r6v12, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r6v13, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r6v9, types: [android.util.ArrayMap, java.util.Map<java.lang.Character, java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r8v8, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a a(String str, Date date, int i2) {
        int i4;
        int iIntValue;
        boolean z4;
        int iIntValue2;
        boolean z5;
        int iIntValue3;
        boolean z6;
        int iIntValue4;
        boolean z7;
        boolean z8;
        int iIntValue5;
        int iIntValue6;
        int iIntValue7;
        boolean z9;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z10;
        int iIntValue8;
        int i9;
        boolean z11;
        int i10;
        boolean z12;
        boolean z13;
        String string;
        int i11;
        boolean z14;
        boolean z15;
        DateFormat dateFormat;
        boolean z16;
        int i12;
        int i13;
        int i14;
        String strReplace = str.toLowerCase().trim().replace("星期", "周");
        Matcher matcher = f5988D.matcher(strReplace);
        if (matcher.matches()) {
            String strSubstring = strReplace.substring(matcher.start(), matcher.end());
            if (!TextUtils.isEmpty(strSubstring)) {
                Iterator it = f5997O.keySet().iterator();
                i4 = -1;
                iIntValue = -1;
                z4 = false;
                String strTrim = strSubstring;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    if (strTrim.contains(str2)) {
                        int iIntValue9 = ((Integer) f5997O.get(str2)).intValue();
                        strTrim = strTrim.replace(str2, "").trim().replaceAll("((th)|(rd)|(st)|(nd))", "").trim();
                        if (!TextUtils.isEmpty(strTrim)) {
                            try {
                                iIntValue = Integer.valueOf(strTrim).intValue();
                                try {
                                    strReplace = strReplace.replace(strSubstring, "");
                                    z4 = true;
                                    i4 = iIntValue9;
                                    break;
                                } catch (NumberFormatException e2) {
                                    e = e2;
                                    z4 = true;
                                    Log.e("DateParseUtils", "exception thrown when parsing english date format:" + str + ", " + e.toString());
                                    i4 = iIntValue9;
                                }
                            } catch (NumberFormatException e4) {
                                e = e4;
                            }
                        }
                        i4 = iIntValue9;
                    }
                }
            } else {
                i4 = -1;
                iIntValue = -1;
                z4 = false;
            }
        }
        if (TextUtils.isEmpty(strReplace)) {
            iIntValue2 = 0;
            z5 = false;
        } else {
            for (String str3 : f5994J.keySet()) {
                if (strReplace.contains(str3)) {
                    iIntValue2 = ((Integer) f5994J.get(str3)).intValue();
                    strReplace = strReplace.replace(str3, "").trim();
                    z5 = true;
                    break;
                }
            }
            iIntValue2 = 0;
            z5 = false;
        }
        if (TextUtils.isEmpty(strReplace)) {
            iIntValue3 = 0;
            z6 = false;
        } else {
            for (String str4 : f5993I.keySet()) {
                if (strReplace.contains(str4)) {
                    iIntValue3 = ((Integer) f5993I.get(str4)).intValue();
                    strReplace = strReplace.replace(str4, "").trim();
                    z6 = true;
                    break;
                }
            }
            iIntValue3 = 0;
            z6 = false;
        }
        if (TextUtils.isEmpty(strReplace)) {
            iIntValue4 = 0;
            z7 = false;
        } else {
            for (String str5 : f5992H.keySet()) {
                if (strReplace.contains(str5)) {
                    iIntValue4 = ((Integer) f5992H.get(str5)).intValue();
                    strReplace = strReplace.replace(str5, "").trim();
                    z7 = true;
                    break;
                }
            }
            iIntValue4 = 0;
            z7 = false;
        }
        if (TextUtils.isEmpty(strReplace)) {
            z8 = false;
            iIntValue5 = 0;
            iIntValue6 = 0;
        } else {
            for (String str6 : f5995K.keySet()) {
                if (strReplace.contains(str6)) {
                    iIntValue6 = ((Integer) f5995K.get(str6)).intValue();
                    iIntValue5 = ((Integer) M.get(str6)).intValue();
                    strReplace = strReplace.replace(str6, " ").trim();
                    z8 = true;
                    break;
                }
            }
            z8 = false;
            iIntValue5 = 0;
            iIntValue6 = 0;
        }
        if (TextUtils.isEmpty(strReplace)) {
            iIntValue7 = iIntValue6;
            z9 = false;
        } else {
            for (String str7 : L.keySet()) {
                int i15 = iIntValue6;
                if (strReplace.contains(str7)) {
                    iIntValue7 = ((Integer) L.get(str7)).intValue();
                    strReplace = strReplace.replace(str7, ":").trim();
                    z9 = true;
                    break;
                }
                iIntValue6 = i15;
            }
            iIntValue7 = iIntValue6;
            z9 = false;
        }
        boolean z17 = z9;
        int i16 = iIntValue7;
        if (TextUtils.isEmpty(strReplace)) {
            i5 = i4;
            i6 = iIntValue;
            i7 = i16;
            i8 = iIntValue5;
            z10 = false;
            iIntValue8 = 0;
        } else {
            for (String str8 : f5996N.keySet()) {
                i6 = iIntValue;
                if (strReplace.contains(str8)) {
                    i5 = i4;
                    iIntValue8 = ((Integer) f5996N.get(str8)).intValue();
                    i7 = i16;
                    StringBuilder sb = new StringBuilder();
                    sb.append(strReplace);
                    i8 = iIntValue5;
                    sb.append(", weekAlpha:");
                    sb.append(iIntValue8);
                    Log.d("DateParseUtils", sb.toString());
                    strReplace = strReplace.replace(str8, "").trim();
                    z10 = true;
                    break;
                }
                iIntValue = i6;
            }
            i5 = i4;
            i6 = iIntValue;
            i7 = i16;
            i8 = iIntValue5;
            z10 = false;
            iIntValue8 = 0;
        }
        if (strReplace == null) {
            i9 = iIntValue8;
            string = "";
            z11 = z10;
            i10 = iIntValue4;
            z12 = z8;
            z13 = z17;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            String strTrim2 = strReplace.trim();
            int i17 = 0;
            i9 = iIntValue8;
            while (i17 < strTrim2.length()) {
                char cCharAt = strTrim2.charAt(i17);
                boolean z18 = z10;
                if (cCharAt != 21313) {
                    i11 = iIntValue4;
                    z14 = z8;
                    z15 = z17;
                    if (f5991G.containsKey(Character.valueOf(cCharAt))) {
                        stringBuffer.append(f5991G.get(Character.valueOf(cCharAt)));
                    } else {
                        stringBuffer.append(cCharAt);
                    }
                } else if (i17 > 0) {
                    z15 = z17;
                    z14 = z8;
                    if (f5998Q.indexOf(strTrim2.charAt(i17 - 1)) != -1) {
                        if (i17 >= strTrim2.length() - 1) {
                            stringBuffer.append("0");
                        } else if (f5999R.indexOf(strTrim2.charAt(i17 + 1)) == -1) {
                            stringBuffer.append("0");
                        }
                        i11 = iIntValue4;
                    } else if (i17 < strTrim2.length() - 1) {
                        i11 = iIntValue4;
                        if (f5999R.indexOf(strTrim2.charAt(i17 + 1)) != -1) {
                            stringBuffer.append(f5991G.get(Character.valueOf(cCharAt)));
                        } else {
                            stringBuffer.append("10");
                        }
                    } else {
                        i11 = iIntValue4;
                        stringBuffer.append("10");
                    }
                } else {
                    i11 = iIntValue4;
                    z14 = z8;
                    z15 = z17;
                    if (i17 >= strTrim2.length() - 1) {
                        stringBuffer.append("10");
                    } else if (f5999R.indexOf(strTrim2.charAt(i17 + 1)) != -1) {
                        stringBuffer.append(f5991G.get(Character.valueOf(cCharAt)));
                    } else {
                        stringBuffer.append("10");
                    }
                }
                i17++;
                z10 = z18;
                z17 = z15;
                z8 = z14;
                iIntValue4 = i11;
            }
            z11 = z10;
            i10 = iIntValue4;
            z12 = z8;
            z13 = z17;
            string = stringBuffer.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            for (Map.Entry entry : P.entrySet()) {
                if (string.contains((String) entry.getKey())) {
                    string = string.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
                }
            }
            string = string.replace("on", "").trim();
        }
        Log.d("DateParseUtils", "formatDate:" + string);
        Calendar calendar = Calendar.getInstance();
        DateFormat[] dateFormatArr = f5990F;
        int length = dateFormatArr.length;
        int i18 = 0;
        while (true) {
            if (i18 >= length) {
                dateFormat = null;
                break;
            }
            dateFormat = dateFormatArr[i18];
            ParsePosition parsePosition = new ParsePosition(0);
            if (dateFormat.parse(string, parsePosition) != null && parsePosition.getErrorIndex() == -1) {
                StringBuilder sbD = D2.e.d("matched pattern: ");
                sbD.append(((SimpleDateFormat) dateFormat).toPattern());
                Log.d("DateParseUtils", sbD.toString());
                break;
            }
            i18++;
        }
        if (dateFormat == null) {
            int i19 = i6;
            int i20 = i9;
            int i21 = i5;
            int i22 = i7;
            int i23 = i8;
            int i24 = i10;
            boolean z19 = true;
            if (z7) {
                calendar.add(5, i24);
            }
            if (z11) {
                calendar.set(7, i20);
            } else {
                z19 = false;
            }
            if (z4 && i21 != -1 && i19 != -1) {
                calendar.set(2, i21);
                calendar.set(5, i19);
            }
            if (z12) {
                calendar.set(11, i23);
                z19 = false;
                calendar.set(12, 0);
                calendar.set(13, 0);
            }
            return new a(z19, calendar.getTime(), i22);
        }
        Date date2 = dateFormat.parse(string, new ParsePosition(0));
        if (f6000a.equals(dateFormat) || f6002c.equals(dateFormat) || f6001b.equals(dateFormat) || d.equals(dateFormat)) {
            calendar.set(date2.getYear() + 1900, date2.getMonth(), date2.getDate(), date2.getHours(), date2.getMinutes());
        } else {
            if (!f6003e.equals(dateFormat) && !g.equals(dateFormat) && !f6004f.equals(dateFormat) && !f6005h.equals(dateFormat)) {
                if (f6006i.equals(dateFormat) || f6007j.equals(dateFormat)) {
                    calendar.set(date2.getYear() + 1900, date2.getMonth(), date2.getDate());
                } else if (f6014r.equals(dateFormat) || f6015s.equals(dateFormat)) {
                    calendar.set(date2.getYear() + 1900, date2.getMonth(), date2.getDate(), date2.getHours(), date2.getMinutes());
                } else if (f6016t.equals(dateFormat) || u.equals(dateFormat)) {
                    calendar.set(date2.getYear() + 1900, date2.getMonth(), date2.getDate(), date2.getHours(), 0);
                } else if (f6008k.equals(dateFormat) || f6009l.equals(dateFormat)) {
                    if (date != null && !z5) {
                        calendar.set(1, date.getYear() + 1900);
                    }
                    calendar.set(2, date2.getMonth());
                    calendar.set(5, date2.getDate());
                    calendar.set(11, date2.getHours());
                    calendar.set(12, date2.getMinutes());
                    calendar.set(13, 0);
                } else if (f6010m.equals(dateFormat) || f6012o.equals(dateFormat) || f6011n.equals(dateFormat)) {
                    if (date != null && !z5) {
                        calendar.set(1, date.getYear() + 1900);
                    }
                    calendar.set(2, date2.getMonth());
                    calendar.set(5, date2.getDate());
                    calendar.set(11, date2.getHours());
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                } else if (p.equals(dateFormat)) {
                    if (date != null && !z5 && !z6) {
                        calendar.set(1, date.getYear() + 1900);
                        calendar.set(2, date.getMonth());
                    }
                    calendar.set(5, date2.getDate());
                    calendar.set(11, date2.getHours());
                    calendar.set(12, date2.getMinutes());
                } else if (f6013q.equals(dateFormat)) {
                    if (date != null && !z5 && !z6) {
                        calendar.set(1, date.getYear() + 1900);
                        calendar.set(2, date.getMonth());
                    }
                    calendar.set(5, date2.getDate());
                    calendar.set(11, date2.getHours());
                    calendar.set(12, 0);
                } else if (f6019x.equals(dateFormat)) {
                    if (date != null && !z7 && !z4) {
                        calendar.set(date.getYear() + 1900, date.getMonth(), date.getDate());
                    }
                    calendar.set(11, date2.getHours());
                    calendar.set(12, date2.getMinutes());
                    calendar.set(13, date2.getSeconds());
                    calendar.add(5, date2.getDate() - 1);
                } else if (f6017v.equals(dateFormat) || f6018w.equals(dateFormat)) {
                    if (date != null && !z5) {
                        calendar.set(1, date.getYear() + 1900);
                    }
                    calendar.set(2, date2.getMonth());
                    calendar.set(5, date2.getDate());
                } else if (f6020y.equals(dateFormat)) {
                    if (date != null && !z7 && !z4) {
                        calendar.set(date.getYear() + 1900, date.getMonth(), date.getDate());
                    }
                    calendar.set(11, date2.getHours());
                    calendar.set(12, date2.getMinutes());
                    calendar.set(13, 0);
                    calendar.add(5, date2.getDate() - 1);
                } else if (f6021z.equals(dateFormat)) {
                    if (date != null && !z7 && !z4) {
                        calendar.set(date.getYear() + 1900, date.getMonth(), date.getDate());
                    }
                    calendar.set(11, date2.getHours());
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    calendar.add(5, date2.getDate() - 1);
                } else if (f5985A.equals(dateFormat)) {
                    if (date != null && !z6) {
                        calendar.set(1, date.getYear() + 1900);
                        calendar.set(2, date.getMonth());
                    }
                    calendar.set(5, date2.getDate());
                }
                z16 = true;
                if (date2 != null) {
                    return null;
                }
                if (z5) {
                    calendar.add(1, iIntValue2);
                }
                if (z6) {
                    calendar.add(2, iIntValue3);
                }
                if (z7) {
                    calendar.add(5, i10);
                }
                if (z12 || z13) {
                    if (!z16 || !z12) {
                        if (date2.getHours() < 12) {
                            i12 = i7;
                            calendar.add(11, i12);
                        }
                        if (z11) {
                            calendar.set(7, i9);
                        }
                        if (z4 && (i13 = i5) != -1 && (i14 = i6) != -1) {
                            calendar.set(2, i13);
                            calendar.set(5, i14);
                        }
                        return new a(z16, calendar.getTime(), i12);
                    }
                    calendar.set(11, i8);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    z16 = false;
                } else if (date != null && i2 > 0 && date2.getHours() < 12) {
                    calendar.add(11, 12);
                }
                i12 = i7;
                if (z11) {
                }
                if (z4) {
                    calendar.set(2, i13);
                    calendar.set(5, i14);
                }
                return new a(z16, calendar.getTime(), i12);
            }
            calendar.set(date2.getYear() + 1900, date2.getMonth(), date2.getDate(), date2.getHours(), 0);
        }
        z16 = false;
        if (date2 != null) {
        }
    }

    public static List<a> b(String str) {
        a aVarA;
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(2);
        Pattern pattern = f5989E;
        if (pattern != null) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                arrayList2.add(str.substring(matcher.start(), matcher.end()));
            }
        }
        if (arrayList2.size() == 1) {
            a aVarA2 = a((String) arrayList2.get(0), null, 0);
            if (aVarA2 != null) {
                arrayList.add(aVarA2);
            }
        } else if (arrayList2.size() == 2 && (aVarA = a((String) arrayList2.get(0), null, 0)) != null) {
            arrayList.add(aVarA);
            a aVarA3 = a((String) arrayList2.get(1), aVarA.a(), aVarA.b());
            if (aVarA3 != null) {
                arrayList.add(aVarA3);
            }
        }
        return arrayList;
    }
}
