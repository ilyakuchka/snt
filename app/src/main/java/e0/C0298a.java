package e0;

import com.android.internal.telephony.GsmAlphabet;

/* renamed from: e0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0298a {
    public static int a(String str, int i2, int i4, int i5, int i6) {
        return GsmAlphabet.findGsmSeptetLimitIndex(str, i2, i4, i5, i6);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(StringBuffer stringBuffer, int i2, int i4) {
        if (i4 <= 0) {
            return "";
        }
        switch (stringBuffer.charAt(i2)) {
            case '1':
                if (i4 > 4) {
                    char cCharAt = stringBuffer.charAt(i2 + 1);
                    if (cCharAt != '7') {
                        switch (cCharAt) {
                            case '0':
                                if (stringBuffer.charAt(i2 + 2) == '1' && stringBuffer.charAt(i2 + 3) == '9' && stringBuffer.charAt(i2 + 4) == '3') {
                                    return "10193";
                                }
                                break;
                            case '1':
                                if (stringBuffer.charAt(i2 + 2) == '8' && stringBuffer.charAt(i2 + 3) == '0' && stringBuffer.charAt(i2 + 4) == '8') {
                                    return "11808";
                                }
                                break;
                            case '2':
                                if (stringBuffer.charAt(i2 + 2) == '5') {
                                    if (i4 > 5 && stringBuffer.charAt(i2 + 3) == '8' && stringBuffer.charAt(i2 + 4) == '3' && stringBuffer.charAt(i2 + 5) == '1') {
                                        return "125831";
                                    }
                                    if (i4 > 5 && stringBuffer.charAt(i2 + 3) == '8' && stringBuffer.charAt(i2 + 4) == '3' && stringBuffer.charAt(i2 + 5) == '2') {
                                        return "125832";
                                    }
                                    if (i4 > 5 && stringBuffer.charAt(i2 + 3) == '8' && stringBuffer.charAt(i2 + 4) == '3' && stringBuffer.charAt(i2 + 5) == '3') {
                                        return "125833";
                                    }
                                    if (stringBuffer.charAt(i2 + 3) == '9' && stringBuffer.charAt(i2 + 4) == '3') {
                                        return "12593";
                                    }
                                }
                                break;
                        }
                    } else if (stringBuffer.charAt(i2 + 2) == '9') {
                        int i5 = i2 + 3;
                        if (stringBuffer.charAt(i5) == '0' && stringBuffer.charAt(i2 + 4) == '0') {
                            return "17900";
                        }
                        if (stringBuffer.charAt(i5) == '0' && stringBuffer.charAt(i2 + 4) == '1') {
                            return "17901";
                        }
                        if (stringBuffer.charAt(i5) == '0' && stringBuffer.charAt(i2 + 4) == '8') {
                            return "17908";
                        }
                        if (stringBuffer.charAt(i5) == '0' && stringBuffer.charAt(i2 + 4) == '9') {
                            return "17909";
                        }
                        if (stringBuffer.charAt(i5) == '1' && stringBuffer.charAt(i2 + 4) == '1') {
                            return "17911";
                        }
                        if (stringBuffer.charAt(i5) == '5' && stringBuffer.charAt(i2 + 4) == '0') {
                            return "17950";
                        }
                        if (stringBuffer.charAt(i5) == '5' && stringBuffer.charAt(i2 + 4) == '1') {
                            return "17951";
                        }
                        if (stringBuffer.charAt(i5) == '6' && stringBuffer.charAt(i2 + 4) == '0') {
                            return "17960";
                        }
                        if (stringBuffer.charAt(i5) == '6' && stringBuffer.charAt(i2 + 4) == '1') {
                            return "17961";
                        }
                        if (stringBuffer.charAt(i5) == '6' && stringBuffer.charAt(i2 + 4) == '8') {
                            return "17968";
                        }
                        if (stringBuffer.charAt(i5) == '6' && stringBuffer.charAt(i2 + 4) == '9') {
                            return "17969";
                        }
                        if (stringBuffer.charAt(i5) == '9' && stringBuffer.charAt(i2 + 4) == '0') {
                            return "17990";
                        }
                        if (stringBuffer.charAt(i5) == '9' && stringBuffer.charAt(i2 + 4) == '1') {
                            return "17991";
                        }
                        if (stringBuffer.charAt(i5) == '9' && stringBuffer.charAt(i2 + 4) == '5') {
                            return "17995";
                        }
                        if (stringBuffer.charAt(i5) == '9' && stringBuffer.charAt(i2 + 4) == '6') {
                            return "17996";
                        }
                    }
                }
                return "";
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
                if (i4 >= 10 && stringBuffer.charAt(i2 + 1) == '0') {
                    int i6 = i2 + 2;
                    if (stringBuffer.charAt(i6) >= '1' && stringBuffer.charAt(i6) <= '9') {
                        return stringBuffer.substring(i2, i2 + 3);
                    }
                }
                return "";
            default:
                return "";
        }
    }
}
