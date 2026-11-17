package j3;

import D2.e;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.mmt.MmsApp;
import e0.C0298a;
import java.util.Iterator;
import k3.C0344a;
import k3.b;

/* renamed from: j3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0338a {

    /* renamed from: k, reason: collision with root package name */
    private static final C0338a[] f6406k = new C0338a[10];

    /* renamed from: l, reason: collision with root package name */
    private static int f6407l = -1;

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f6408a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuffer f6409b = new StringBuffer(256);

    /* renamed from: c, reason: collision with root package name */
    private String f6410c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private String f6411e;

    /* renamed from: f, reason: collision with root package name */
    private int f6412f;
    private String g;

    /* renamed from: h, reason: collision with root package name */
    private int f6413h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6414i;

    /* renamed from: j, reason: collision with root package name */
    private String f6415j;

    private C0338a() {
        b();
    }

    private static boolean a(CharSequence charSequence, int i2, CharSequence charSequence2, int i4) {
        if (charSequence == null || i2 < 0 || i4 < 0 || charSequence.length() < i2 + i4 || charSequence2.length() < i4 + 0) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (charSequence.charAt(i2 + i5) != charSequence2.charAt(0 + i5)) {
                return false;
            }
        }
        return true;
    }

    private void b() {
        this.f6409b.setLength(0);
        this.f6410c = null;
        this.d = null;
        this.f6411e = null;
        this.f6412f = 0;
        this.g = null;
        this.f6413h = 0;
        this.f6414i = false;
        this.f6415j = null;
    }

    public static C0338a i(CharSequence charSequence, String str) {
        C0338a c0338a;
        C0338a[] c0338aArr = f6406k;
        synchronized (c0338aArr) {
            int i2 = f6407l;
            if (i2 == -1) {
                c0338a = new C0338a();
            } else {
                C0338a c0338a2 = c0338aArr[i2];
                f6407l = i2 - 1;
                c0338aArr[i2] = null;
                c0338a = c0338a2;
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        c0338a.f6408a = charSequence;
        int length = charSequence.length();
        boolean z4 = false;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = charSequence.charAt(i4);
            if (z4 && PhoneNumberUtils.isNonSeparator(cCharAt)) {
                c0338a.f6409b.append(cCharAt);
            } else if (i4 == 0 && cCharAt == '+') {
                c0338a.f6409b.append(cCharAt);
            } else if (cCharAt >= '0' && cCharAt <= '9') {
                c0338a.f6409b.append(cCharAt);
            } else if (!z4 && PhoneNumberUtils.isStartsPostDial(cCharAt)) {
                c0338a.f6413h = c0338a.f6409b.length();
                c0338a.f6409b.append(cCharAt);
                z4 = true;
            }
        }
        if (!z4) {
            c0338a.f6413h = c0338a.f6409b.length();
        }
        c0338a.f6414i = false;
        c0338a.f6415j = str;
        return c0338a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c() {
        boolean z4;
        if (this.f6411e == null) {
            String string = "";
            this.f6411e = "";
            if (h()) {
                TextUtils.isEmpty(g());
                String strD = d();
                if (TextUtils.isEmpty(strD)) {
                    z4 = false;
                    int length = this.f6409b.length() - 1;
                    int i2 = this.f6412f;
                    if (length > i2 && this.f6409b.charAt(i2) == '0') {
                        this.f6412f++;
                        z4 = true;
                    }
                    if (z4) {
                        StringBuffer stringBuffer = this.f6409b;
                        int i4 = this.f6412f;
                        Uri uriBuild = Uri.parse("content://com.miui.core.telocation").buildUpon().appendPath("parse_area_code").appendQueryParameter("number", String.valueOf(stringBuffer)).appendQueryParameter("start", String.valueOf(i4)).appendQueryParameter("length", String.valueOf(this.f6413h - i4)).build();
                        Cursor cursorQuery = null;
                        try {
                            try {
                                cursorQuery = MmsApp.c().getContentResolver().query(uriBuild, null, null, null, null);
                                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                                    string = cursorQuery.getString(3);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                if (cursorQuery != null) {
                                }
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            this.f6411e = string;
                            if (string.length() == 0 && TextUtils.isEmpty(strD)) {
                                this.f6412f--;
                            } else {
                                this.f6412f = this.f6411e.length() + this.f6412f;
                            }
                        } catch (Throwable th) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                } else {
                    z4 = true;
                    if (z4) {
                    }
                }
            }
        }
        return this.f6411e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String d() {
        if (this.d == null) {
            g();
            Iterator<String> it = C0344a.b().iterator();
            while (true) {
                if (it.hasNext()) {
                    String next = it.next();
                    String str = "+";
                    if (!a(this.f6409b, this.f6412f, "+", 1)) {
                        if (!TextUtils.isEmpty(this.f6415j)) {
                            next = this.f6415j;
                        }
                        str = !a(this.f6409b, this.f6412f, next, next.length()) ? null : next;
                    }
                    String str2 = "";
                    if (str != null) {
                        int length = str.length() + this.f6412f;
                        this.f6412f = length;
                        StringBuffer stringBuffer = this.f6409b;
                        int i2 = this.f6413h - length;
                        int i4 = b.f6453c;
                        if (i2 > 0) {
                            switch (stringBuffer.charAt(length)) {
                                case '1':
                                    if (i2 > 3) {
                                        char cCharAt = stringBuffer.charAt(length + 2);
                                        char cCharAt2 = stringBuffer.charAt(length + 3);
                                        switch (stringBuffer.charAt(length + 1)) {
                                            case '2':
                                                if (cCharAt != '4') {
                                                    if (cCharAt != '6') {
                                                        if (cCharAt == '8' && cCharAt2 == '4') {
                                                            str2 = "1284";
                                                            break;
                                                        }
                                                    } else if (cCharAt2 != '4') {
                                                        if (cCharAt2 == '8') {
                                                            str2 = "1268";
                                                            break;
                                                        }
                                                    } else {
                                                        str2 = "1264";
                                                        break;
                                                    }
                                                } else if (cCharAt2 != '2') {
                                                    if (cCharAt2 == '6') {
                                                        str2 = "1246";
                                                        break;
                                                    }
                                                } else {
                                                    str2 = "1242";
                                                    break;
                                                }
                                                break;
                                            case '3':
                                                if (cCharAt == '4') {
                                                    if (cCharAt2 != '0') {
                                                        if (cCharAt2 == '5') {
                                                            str2 = "1345";
                                                            break;
                                                        }
                                                    } else {
                                                        str2 = "1340";
                                                        break;
                                                    }
                                                }
                                                break;
                                            case '4':
                                                if (cCharAt != '4' || cCharAt2 != '1') {
                                                    if (cCharAt == '7' && cCharAt2 == '3') {
                                                        str2 = "1473";
                                                        break;
                                                    }
                                                } else {
                                                    str2 = "1441";
                                                    break;
                                                }
                                                break;
                                            case '6':
                                                if (cCharAt != '4' || cCharAt2 != '9') {
                                                    if (cCharAt != '6' || cCharAt2 != '4') {
                                                        if (cCharAt == '7') {
                                                            if (cCharAt2 != '0') {
                                                                if (cCharAt2 == '1') {
                                                                    str2 = "1671";
                                                                    break;
                                                                }
                                                            } else {
                                                                str2 = "1670";
                                                                break;
                                                            }
                                                        }
                                                        if (cCharAt == '8' && cCharAt2 == '4') {
                                                            str2 = "1684";
                                                            break;
                                                        }
                                                    } else {
                                                        str2 = "1664";
                                                        break;
                                                    }
                                                } else {
                                                    str2 = "1649";
                                                    break;
                                                }
                                                break;
                                            case '7':
                                                if (cCharAt != '2' || cCharAt2 != '1') {
                                                    if (cCharAt != '5' || cCharAt2 != '8') {
                                                        if (cCharAt != '6' || cCharAt2 != '7') {
                                                            if (cCharAt == '8') {
                                                                if (cCharAt2 != '4') {
                                                                    if (cCharAt2 == '7') {
                                                                        str2 = "1787";
                                                                        break;
                                                                    }
                                                                } else {
                                                                    str2 = "1784";
                                                                    break;
                                                                }
                                                            }
                                                        } else {
                                                            str2 = "1767";
                                                            break;
                                                        }
                                                    } else {
                                                        str2 = "1758";
                                                        break;
                                                    }
                                                } else {
                                                    str2 = "1721";
                                                    break;
                                                }
                                                break;
                                            case '8':
                                                if (cCharAt != '0' || cCharAt2 != '9') {
                                                    if (cCharAt != '2' || cCharAt2 != '9') {
                                                        if (cCharAt != '4' || cCharAt2 != '9') {
                                                            if (cCharAt == '6') {
                                                                if (cCharAt2 != '8') {
                                                                    if (cCharAt2 == '9') {
                                                                        str2 = "1869";
                                                                        break;
                                                                    }
                                                                } else {
                                                                    str2 = "1868";
                                                                    break;
                                                                }
                                                            }
                                                            if (cCharAt == '7' && cCharAt2 == '6') {
                                                                str2 = "1876";
                                                                break;
                                                            }
                                                        } else {
                                                            str2 = "1849";
                                                            break;
                                                        }
                                                    } else {
                                                        str2 = "1829";
                                                        break;
                                                    }
                                                } else {
                                                    str2 = "1809";
                                                    break;
                                                }
                                                break;
                                            case '9':
                                                if (cCharAt == '3' && cCharAt2 == '9') {
                                                    str2 = "1939";
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                    str2 = "1";
                                    break;
                                case '2':
                                    if (i2 > 1) {
                                        switch (stringBuffer.charAt(length + 1)) {
                                            case '0':
                                                str2 = "20";
                                                break;
                                            case '1':
                                                if (i2 > 2) {
                                                    char cCharAt3 = stringBuffer.charAt(length + 2);
                                                    if (cCharAt3 == '2') {
                                                        str2 = "212";
                                                        break;
                                                    } else if (cCharAt3 == '3') {
                                                        str2 = "213";
                                                        break;
                                                    } else if (cCharAt3 == '6') {
                                                        str2 = "216";
                                                        break;
                                                    } else if (cCharAt3 == '8') {
                                                        str2 = "218";
                                                        break;
                                                    }
                                                }
                                                break;
                                            case '2':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "220";
                                                            break;
                                                        case '1':
                                                            str2 = "221";
                                                            break;
                                                        case '2':
                                                            str2 = "222";
                                                            break;
                                                        case '3':
                                                            str2 = "223";
                                                            break;
                                                        case '4':
                                                            str2 = "224";
                                                            break;
                                                        case '5':
                                                            str2 = "225";
                                                            break;
                                                        case '6':
                                                            str2 = "226";
                                                            break;
                                                        case '7':
                                                            str2 = "227";
                                                            break;
                                                        case '8':
                                                            str2 = "228";
                                                            break;
                                                        case '9':
                                                            str2 = "229";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '3':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "230";
                                                            break;
                                                        case '1':
                                                            str2 = "231";
                                                            break;
                                                        case '2':
                                                            str2 = "232";
                                                            break;
                                                        case '3':
                                                            str2 = "233";
                                                            break;
                                                        case '4':
                                                            str2 = "234";
                                                            break;
                                                        case '5':
                                                            str2 = "235";
                                                            break;
                                                        case '6':
                                                            str2 = "236";
                                                            break;
                                                        case '7':
                                                            str2 = "237";
                                                            break;
                                                        case '8':
                                                            str2 = "238";
                                                            break;
                                                        case '9':
                                                            str2 = "239";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '4':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "240";
                                                            break;
                                                        case '1':
                                                            str2 = "241";
                                                            break;
                                                        case '2':
                                                            str2 = "242";
                                                            break;
                                                        case '3':
                                                            str2 = "243";
                                                            break;
                                                        case '4':
                                                            str2 = "244";
                                                            break;
                                                        case '5':
                                                            str2 = "245";
                                                            break;
                                                        case '6':
                                                            str2 = "246";
                                                            break;
                                                        case '7':
                                                            str2 = "247";
                                                            break;
                                                        case '8':
                                                            str2 = "248";
                                                            break;
                                                        case '9':
                                                            str2 = "249";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '5':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "250";
                                                            break;
                                                        case '1':
                                                            str2 = "251";
                                                            break;
                                                        case '2':
                                                            str2 = "252";
                                                            break;
                                                        case '3':
                                                            str2 = "253";
                                                            break;
                                                        case '4':
                                                            str2 = "254";
                                                            break;
                                                        case '5':
                                                            str2 = "255";
                                                            break;
                                                        case '6':
                                                            str2 = "256";
                                                            break;
                                                        case '7':
                                                            str2 = "257";
                                                            break;
                                                        case '8':
                                                            str2 = "258";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '6':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "260";
                                                            break;
                                                        case '1':
                                                            str2 = "261";
                                                            break;
                                                        case '2':
                                                            str2 = "262";
                                                            break;
                                                        case '3':
                                                            str2 = "263";
                                                            break;
                                                        case '4':
                                                            str2 = "264";
                                                            break;
                                                        case '5':
                                                            str2 = "265";
                                                            break;
                                                        case '6':
                                                            str2 = "266";
                                                            break;
                                                        case '7':
                                                            str2 = "267";
                                                            break;
                                                        case '8':
                                                            str2 = "268";
                                                            break;
                                                        case '9':
                                                            str2 = "269";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '7':
                                                str2 = "27";
                                                break;
                                            case '9':
                                                if (i2 > 2) {
                                                    char cCharAt4 = stringBuffer.charAt(length + 2);
                                                    if (cCharAt4 == '0') {
                                                        str2 = "290";
                                                        break;
                                                    } else if (cCharAt4 == '1') {
                                                        str2 = "291";
                                                        break;
                                                    } else {
                                                        switch (cCharAt4) {
                                                            case '7':
                                                                str2 = "297";
                                                                break;
                                                            case '8':
                                                                str2 = "298";
                                                                break;
                                                            case '9':
                                                                str2 = "299";
                                                                break;
                                                        }
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                    break;
                                case '3':
                                    if (i2 > 1) {
                                        switch (stringBuffer.charAt(length + 1)) {
                                            case '0':
                                                str2 = "30";
                                                break;
                                            case '1':
                                                str2 = "31";
                                                break;
                                            case '2':
                                                str2 = "32";
                                                break;
                                            case '3':
                                                str2 = "33";
                                                break;
                                            case '4':
                                                str2 = "34";
                                                break;
                                            case '5':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "350";
                                                            break;
                                                        case '1':
                                                            str2 = "351";
                                                            break;
                                                        case '2':
                                                            str2 = "352";
                                                            break;
                                                        case '3':
                                                            str2 = "353";
                                                            break;
                                                        case '4':
                                                            str2 = "354";
                                                            break;
                                                        case '5':
                                                            str2 = "355";
                                                            break;
                                                        case '6':
                                                            str2 = "356";
                                                            break;
                                                        case '7':
                                                            str2 = "357";
                                                            break;
                                                        case '8':
                                                            str2 = "358";
                                                            break;
                                                        case '9':
                                                            str2 = "359";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '6':
                                                str2 = "36";
                                                break;
                                            case '7':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "370";
                                                            break;
                                                        case '1':
                                                            str2 = "371";
                                                            break;
                                                        case '2':
                                                            str2 = "372";
                                                            break;
                                                        case '3':
                                                            str2 = "373";
                                                            break;
                                                        case '4':
                                                            str2 = "374";
                                                            break;
                                                        case '5':
                                                            str2 = "375";
                                                            break;
                                                        case '6':
                                                            str2 = "376";
                                                            break;
                                                        case '7':
                                                            str2 = "377";
                                                            break;
                                                        case '8':
                                                            str2 = "378";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '8':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "380";
                                                            break;
                                                        case '1':
                                                            str2 = "381";
                                                            break;
                                                        case '2':
                                                            str2 = "382";
                                                            break;
                                                        case '5':
                                                            str2 = "385";
                                                            break;
                                                        case '6':
                                                            str2 = "386";
                                                            break;
                                                        case '7':
                                                            str2 = "387";
                                                            break;
                                                        case '9':
                                                            str2 = "389";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '9':
                                                if (i2 <= 6 || stringBuffer.charAt(length + 2) != '0' || stringBuffer.charAt(length + 3) != '6' || stringBuffer.charAt(length + 4) != '6' || stringBuffer.charAt(length + 5) != '9' || stringBuffer.charAt(length + 6) != '8') {
                                                    str2 = "39";
                                                    break;
                                                } else {
                                                    str2 = "3906698";
                                                    break;
                                                }
                                        }
                                    }
                                    break;
                                case '4':
                                    if (i2 > 1) {
                                        switch (stringBuffer.charAt(length + 1)) {
                                            case '0':
                                                str2 = "40";
                                                break;
                                            case '1':
                                                str2 = "41";
                                                break;
                                            case '2':
                                                if (i2 > 2) {
                                                    char cCharAt5 = stringBuffer.charAt(length + 2);
                                                    if (cCharAt5 == '0') {
                                                        str2 = "420";
                                                        break;
                                                    } else if (cCharAt5 == '1') {
                                                        str2 = "421";
                                                        break;
                                                    } else if (cCharAt5 == '3') {
                                                        str2 = "423";
                                                        break;
                                                    }
                                                }
                                                break;
                                            case '3':
                                                str2 = "43";
                                                break;
                                            case '4':
                                                if (i2 > 5) {
                                                    char cCharAt6 = stringBuffer.charAt(length + 3);
                                                    char cCharAt7 = stringBuffer.charAt(length + 4);
                                                    char cCharAt8 = stringBuffer.charAt(length + 5);
                                                    char cCharAt9 = stringBuffer.charAt(length + 2);
                                                    if (cCharAt9 == '1') {
                                                        if (cCharAt6 != '4' || cCharAt7 != '8' || cCharAt8 != '1') {
                                                            if (cCharAt6 != '5' || cCharAt7 != '3' || cCharAt8 != '4') {
                                                                if (cCharAt6 == '6' && cCharAt7 == '2' && cCharAt8 == '4') {
                                                                    str2 = "441624";
                                                                    break;
                                                                }
                                                            } else {
                                                                str2 = "441534";
                                                                break;
                                                            }
                                                        } else {
                                                            str2 = "441481";
                                                            break;
                                                        }
                                                    } else if (cCharAt9 == '7') {
                                                        if (cCharAt6 != '5' || cCharAt7 != '0' || cCharAt8 != '9') {
                                                            if (cCharAt6 != '5' || cCharAt7 != '2' || cCharAt8 != '4') {
                                                                if (cCharAt6 != '6' || cCharAt7 != '2' || cCharAt8 != '4') {
                                                                    if (cCharAt6 != '7' || cCharAt7 != '0' || cCharAt8 != '0') {
                                                                        if (cCharAt6 != '7' || cCharAt7 != '8' || cCharAt8 != '1') {
                                                                            if (cCharAt6 != '7' || cCharAt7 != '9' || cCharAt8 != '7') {
                                                                                if (cCharAt6 != '8' || cCharAt7 != '2' || cCharAt8 != '9') {
                                                                                    if (cCharAt6 != '8' || cCharAt7 != '3' || cCharAt8 != '9') {
                                                                                        if (cCharAt6 != '9' || cCharAt7 != '1' || cCharAt8 != '1') {
                                                                                            if (cCharAt6 == '9' && cCharAt7 == '2' && cCharAt8 == '4') {
                                                                                                str2 = "447924";
                                                                                                break;
                                                                                            }
                                                                                        } else {
                                                                                            str2 = "447911";
                                                                                            break;
                                                                                        }
                                                                                    } else {
                                                                                        str2 = "447839";
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    str2 = "447829";
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                str2 = "447797";
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            str2 = "447781";
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        str2 = "447700";
                                                                        break;
                                                                    }
                                                                } else {
                                                                    str2 = "447624";
                                                                    break;
                                                                }
                                                            } else {
                                                                str2 = "447524";
                                                                break;
                                                            }
                                                        } else {
                                                            str2 = "447509";
                                                            break;
                                                        }
                                                    }
                                                }
                                                str2 = "44";
                                                break;
                                            case '5':
                                                str2 = "45";
                                                break;
                                            case '6':
                                                str2 = "46";
                                                break;
                                            case '7':
                                                str2 = "47";
                                                break;
                                            case '8':
                                                str2 = "48";
                                                break;
                                            case '9':
                                                str2 = "49";
                                                break;
                                        }
                                    }
                                    break;
                                case '5':
                                    if (i2 > 1) {
                                        switch (stringBuffer.charAt(length + 1)) {
                                            case '0':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "500";
                                                            break;
                                                        case '1':
                                                            str2 = "501";
                                                            break;
                                                        case '2':
                                                            str2 = "502";
                                                            break;
                                                        case '3':
                                                            str2 = "503";
                                                            break;
                                                        case '4':
                                                            str2 = "504";
                                                            break;
                                                        case '5':
                                                            str2 = "505";
                                                            break;
                                                        case '6':
                                                            str2 = "506";
                                                            break;
                                                        case '7':
                                                            str2 = "507";
                                                            break;
                                                        case '8':
                                                            str2 = "508";
                                                            break;
                                                        case '9':
                                                            str2 = "509";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '1':
                                                str2 = "51";
                                                break;
                                            case '2':
                                                str2 = "52";
                                                break;
                                            case '3':
                                                str2 = "53";
                                                break;
                                            case '4':
                                                str2 = "54";
                                                break;
                                            case '5':
                                                str2 = "55";
                                                break;
                                            case '6':
                                                str2 = "56";
                                                break;
                                            case '7':
                                                str2 = "57";
                                                break;
                                            case '8':
                                                str2 = "58";
                                                break;
                                            case '9':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "590";
                                                            break;
                                                        case '1':
                                                            str2 = "591";
                                                            break;
                                                        case '2':
                                                            str2 = "592";
                                                            break;
                                                        case '3':
                                                            str2 = "593";
                                                            break;
                                                        case '4':
                                                            str2 = "594";
                                                            break;
                                                        case '5':
                                                            str2 = "595";
                                                            break;
                                                        case '6':
                                                            str2 = "596";
                                                            break;
                                                        case '7':
                                                            str2 = "597";
                                                            break;
                                                        case '8':
                                                            str2 = "598";
                                                            break;
                                                        case '9':
                                                            str2 = "599";
                                                            break;
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                    break;
                                case '6':
                                    if (i2 > 1) {
                                        switch (stringBuffer.charAt(length + 1)) {
                                            case '0':
                                                str2 = "60";
                                                break;
                                            case '1':
                                                str2 = "61";
                                                break;
                                            case '2':
                                                str2 = "62";
                                                break;
                                            case '3':
                                                str2 = "63";
                                                break;
                                            case '4':
                                                str2 = "64";
                                                break;
                                            case '5':
                                                str2 = "65";
                                                break;
                                            case '6':
                                                str2 = "66";
                                                break;
                                            case '7':
                                                if (i2 > 2) {
                                                    char cCharAt10 = stringBuffer.charAt(length + 2);
                                                    if (cCharAt10 == '0') {
                                                        str2 = "670";
                                                        break;
                                                    } else {
                                                        switch (cCharAt10) {
                                                            case '3':
                                                                str2 = "673";
                                                                break;
                                                            case '4':
                                                                str2 = "674";
                                                                break;
                                                            case '5':
                                                                str2 = "675";
                                                                break;
                                                            case '6':
                                                                str2 = "676";
                                                                break;
                                                            case '7':
                                                                str2 = "677";
                                                                break;
                                                            case '8':
                                                                str2 = "678";
                                                                break;
                                                            case '9':
                                                                str2 = "679";
                                                                break;
                                                        }
                                                    }
                                                }
                                                break;
                                            case '8':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "680";
                                                            break;
                                                        case '1':
                                                            str2 = "681";
                                                            break;
                                                        case '2':
                                                            str2 = "682";
                                                            break;
                                                        case '3':
                                                            str2 = "683";
                                                            break;
                                                        case '5':
                                                            str2 = "685";
                                                            break;
                                                        case '6':
                                                            str2 = "686";
                                                            break;
                                                        case '7':
                                                            str2 = "687";
                                                            break;
                                                        case '8':
                                                            str2 = "688";
                                                            break;
                                                        case '9':
                                                            str2 = "689";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '9':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "690";
                                                            break;
                                                        case '1':
                                                            str2 = "691";
                                                            break;
                                                        case '2':
                                                            str2 = "692";
                                                            break;
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                    break;
                                case '7':
                                    str2 = "7";
                                    break;
                                case '8':
                                    if (i2 > 1) {
                                        switch (stringBuffer.charAt(length + 1)) {
                                            case '1':
                                                str2 = "81";
                                                break;
                                            case '2':
                                                str2 = "82";
                                                break;
                                            case '4':
                                                str2 = "84";
                                                break;
                                            case '5':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "850";
                                                            break;
                                                        case '2':
                                                            str2 = "852";
                                                            break;
                                                        case '3':
                                                            str2 = "853";
                                                            break;
                                                        case '5':
                                                            str2 = "855";
                                                            break;
                                                        case '6':
                                                            str2 = "856";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '6':
                                                str2 = "86";
                                                break;
                                            case '8':
                                                if (i2 > 2) {
                                                    char cCharAt11 = stringBuffer.charAt(length + 2);
                                                    if (cCharAt11 == '0') {
                                                        str2 = "880";
                                                        break;
                                                    } else if (cCharAt11 == '6') {
                                                        str2 = "886";
                                                        break;
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                    break;
                                case '9':
                                    if (i2 > 1) {
                                        switch (stringBuffer.charAt(length + 1)) {
                                            case '0':
                                                str2 = "90";
                                                break;
                                            case '1':
                                                str2 = "91";
                                                break;
                                            case '2':
                                                str2 = "92";
                                                break;
                                            case '3':
                                                str2 = "93";
                                                break;
                                            case '4':
                                                str2 = "94";
                                                break;
                                            case '5':
                                                str2 = "95";
                                                break;
                                            case '6':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "960";
                                                            break;
                                                        case '1':
                                                            str2 = "961";
                                                            break;
                                                        case '2':
                                                            str2 = "962";
                                                            break;
                                                        case '3':
                                                            str2 = "963";
                                                            break;
                                                        case '4':
                                                            str2 = "964";
                                                            break;
                                                        case '5':
                                                            str2 = "965";
                                                            break;
                                                        case '6':
                                                            str2 = "966";
                                                            break;
                                                        case '7':
                                                            str2 = "967";
                                                            break;
                                                        case '8':
                                                            str2 = "968";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '7':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '0':
                                                            str2 = "970";
                                                            break;
                                                        case '1':
                                                            str2 = "971";
                                                            break;
                                                        case '2':
                                                            str2 = "972";
                                                            break;
                                                        case '3':
                                                            str2 = "973";
                                                            break;
                                                        case '4':
                                                            str2 = "974";
                                                            break;
                                                        case '5':
                                                            str2 = "975";
                                                            break;
                                                        case '6':
                                                            str2 = "976";
                                                            break;
                                                        case '7':
                                                            str2 = "977";
                                                            break;
                                                    }
                                                }
                                                break;
                                            case '8':
                                                str2 = "98";
                                                break;
                                            case '9':
                                                if (i2 > 2) {
                                                    switch (stringBuffer.charAt(length + 2)) {
                                                        case '2':
                                                            str2 = "992";
                                                            break;
                                                        case '3':
                                                            str2 = "993";
                                                            break;
                                                        case '4':
                                                            str2 = "994";
                                                            break;
                                                        case '5':
                                                            str2 = "995";
                                                            break;
                                                        case '6':
                                                            str2 = "996";
                                                            break;
                                                        case '8':
                                                            str2 = "998";
                                                            break;
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                    break;
                            }
                        }
                        this.d = str2;
                        if (str2.length() != 0) {
                            this.f6412f = this.d.length() + this.f6412f;
                        } else {
                            this.f6412f -= str.length();
                        }
                    } else {
                        this.d = "";
                    }
                }
            }
        }
        return this.d;
    }

    public final String e() {
        if (this.g == null) {
            c();
            int length = this.f6409b.length();
            int i2 = this.f6412f;
            if (length > i2) {
                this.g = this.f6409b.substring(i2, this.f6413h);
            } else {
                this.g = "";
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        String string = this.f6408a.toString();
        this.f6408a = string;
        return string.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String f() {
        boolean z4;
        boolean z5;
        if (!h()) {
            String strSubstring = this.f6409b.substring(this.f6412f - d().length(), this.f6409b.length());
            return d().length() > 0 ? e.c("+", strSubstring) : strSubstring;
        }
        c();
        if (h()) {
            int i2 = this.f6413h;
            int i4 = this.f6412f;
            int i5 = i2 - i4;
            if (i5 == 11) {
                if (this.f6409b.charAt(i4) == '1') {
                    switch (this.f6409b.charAt(this.f6412f + 1)) {
                        case '3':
                            if (this.f6409b.charAt(this.f6412f + 2) != '8' || this.f6409b.charAt(this.f6412f + 3) != '0' || this.f6409b.charAt(this.f6412f + 4) != '0' || this.f6409b.charAt(this.f6412f + 5) != '1' || this.f6409b.charAt(this.f6412f + 6) != '3' || this.f6409b.charAt(this.f6412f + 7) != '8' || this.f6409b.charAt(this.f6412f + 8) != '0' || this.f6409b.charAt(this.f6412f + 9) != '0' || this.f6409b.charAt(this.f6412f + 10) != '0') {
                                z4 = true;
                                break;
                            }
                            break;
                        case '7':
                            if (this.f6409b.charAt(this.f6412f + 2) != '9') {
                            }
                            break;
                    }
                }
                z4 = false;
            } else {
                if (i5 == 13 && this.f6409b.charAt(i4) == '1') {
                    if ((r0 = this.f6409b.charAt(this.f6412f + 1)) != '0') {
                    }
                }
                z4 = false;
            }
        } else {
            z4 = false;
        }
        if (z4) {
            return e.c("+86", this.f6409b.substring(this.f6412f, this.f6409b.length()));
        }
        int length = this.f6409b.length();
        if (!TextUtils.isEmpty(c())) {
            c();
            if (h()) {
                int i6 = this.f6413h;
                int i7 = this.f6412f;
                int i8 = i6 - i7;
                if (i8 > 2) {
                    char cCharAt = this.f6409b.charAt(i7);
                    char cCharAt2 = this.f6409b.charAt(this.f6412f + 1);
                    char cCharAt3 = this.f6409b.charAt(this.f6412f + 2);
                    if ((cCharAt == '1' && (cCharAt2 == '0' || cCharAt2 == '1' || cCharAt2 == '2')) || (cCharAt == '2' || cCharAt == '3' || cCharAt == '5' || cCharAt == '6' || cCharAt == '7' ? !(cCharAt2 != '0' || cCharAt3 != '0' || i8 <= 7) : !(i8 == 5 ? cCharAt != '9' || (cCharAt2 != '5' && cCharAt2 != '6') : i8 == 10 ? !((cCharAt == '4' || cCharAt == '8') && this.f6412f == 0 && cCharAt2 == '0' && cCharAt3 == '0') : !(i8 == 11 && "13800138000".equals(e().replaceAll(" ", "")))))) {
                        z5 = true;
                    }
                    if (!z5) {
                    }
                }
            } else {
                z5 = false;
                if (!z5) {
                    return e.c("+86", this.f6409b.substring(this.f6412f - c().length(), length));
                }
            }
        }
        return this.f6409b.substring(this.f6412f, length);
    }

    public final String g() {
        if (this.f6410c == null && this.f6414i) {
            StringBuffer stringBuffer = this.f6409b;
            int i2 = this.f6412f;
            String strB = C0298a.b(stringBuffer, i2, this.f6413h - i2);
            this.f6410c = strB;
            this.f6412f = strB.length() + this.f6412f;
        }
        return this.f6410c;
    }

    public final boolean h() {
        String strD = d();
        return !TextUtils.isEmpty(strD) ? "86".equals(strD) : this.f6414i || "86".equals(null);
    }

    public final void j() {
        b();
        C0338a[] c0338aArr = f6406k;
        synchronized (c0338aArr) {
            int i2 = f6407l;
            if (i2 < 10) {
                int i4 = i2 + 1;
                f6407l = i4;
                c0338aArr[i4] = this;
            }
        }
    }
}
