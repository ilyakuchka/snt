package C2;

/* loaded from: classes.dex */
public final /* synthetic */ class c {
    public static String a(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder c(String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        return sb;
    }

    public static /* synthetic */ String e(int i2) {
        return i2 == 1 ? "ATTEMPT_MIGRATION" : i2 == 2 ? "NOT_GENERATED" : i2 == 3 ? "UNREGISTERED" : i2 == 4 ? "REGISTERED" : i2 == 5 ? "REGISTER_ERROR" : "null";
    }

    public static /* synthetic */ String f(int i2) {
        return i2 == 1 ? "OK" : i2 == 2 ? "BAD_CONFIG" : i2 == 3 ? "AUTH_ERROR" : "null";
    }

    public static /* synthetic */ String g(int i2) {
        return i2 == 1 ? "File" : i2 == 2 ? "Uri" : i2 == 3 ? "Asset" : i2 == 4 ? "ByteArray" : "null";
    }

    public static /* synthetic */ String h(int i2) {
        return i2 == 1 ? "INITIALIZE" : i2 == 2 ? "RESOURCE_CACHE" : i2 == 3 ? "DATA_CACHE" : i2 == 4 ? "SOURCE" : i2 == 5 ? "ENCODE" : i2 == 6 ? "FINISHED" : "null";
    }

    public static /* synthetic */ String i(int i2) {
        return i2 == 1 ? "NONE" : i2 == 2 ? "ADDING" : i2 == 3 ? "REMOVING" : "null";
    }
}
