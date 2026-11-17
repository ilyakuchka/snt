package D2;

/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static /* synthetic */ int a(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 3) {
            return 3;
        }
        if (i2 == 4) {
            return 4;
        }
        throw null;
    }

    public static String b(String str, int i2) {
        return str + i2;
    }

    public static String c(String str, String str2) {
        return str + str2;
    }

    public static StringBuilder d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static /* synthetic */ String g(int i2) {
        return i2 == 1 ? "OK" : i2 == 2 ? "BAD_CONFIG" : "null";
    }

    public static /* synthetic */ String h(int i2) {
        return i2 == 1 ? "NONE" : i2 == 2 ? "INFO" : i2 == 3 ? "FAILED" : i2 == 4 ? "PENDING" : i2 == 5 ? "SENT" : i2 == 6 ? "RECEIVED" : i2 == 7 ? "TRANSLATED" : i2 == 8 ? "REJECTED" : i2 == 9 ? "EXPIRED" : i2 == 10 ? "DISPLAYED" : "null";
    }

    public static /* synthetic */ String i(int i2) {
        return i2 == 1 ? "INITIALIZE" : i2 == 2 ? "SWITCH_TO_SOURCE_SERVICE" : i2 == 3 ? "DECODE_DATA" : "null";
    }

    public static /* synthetic */ String j(int i2) {
        return i2 == 1 ? "MAIN" : i2 == 2 ? "BAR" : i2 == 3 ? "SETTING" : i2 == 4 ? "OTHER" : "null";
    }

    public static /* synthetic */ String k(int i2) {
        return i2 == 1 ? "OK" : i2 == 2 ? "TRANSIENT_ERROR" : i2 == 3 ? "FATAL_ERROR" : i2 == 4 ? "INVALID_PAYLOAD" : "null";
    }
}
