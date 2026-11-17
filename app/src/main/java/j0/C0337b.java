package j0;

import java.util.ArrayList;

/* renamed from: j0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0337b {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<String> f6357a;

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList<String> f6358b;

    /* renamed from: c, reason: collision with root package name */
    private static final ArrayList<String> f6359c;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f6357a = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        f6358b = arrayList2;
        ArrayList<String> arrayList3 = new ArrayList<>();
        f6359c = arrayList3;
        arrayList.add("image/jpeg");
        arrayList.add("image/gif");
        arrayList.add("image/vnd.wap.wbmp");
        arrayList.add("image/png");
        arrayList.add("image/jpg");
        arrayList.add("image/x-ms-bmp");
        arrayList2.add("audio/aac");
        arrayList2.add("audio/amr");
        arrayList2.add("audio/imelody");
        arrayList2.add("audio/mid");
        arrayList2.add("audio/midi");
        arrayList2.add("audio/mp3");
        arrayList2.add("audio/mpeg3");
        arrayList2.add("audio/mpeg");
        arrayList2.add("audio/mpg");
        arrayList2.add("audio/mp4");
        arrayList2.add("audio/x-mid");
        arrayList2.add("audio/x-midi");
        arrayList2.add("audio/x-mp3");
        arrayList2.add("audio/x-mpeg3");
        arrayList2.add("audio/x-mpeg");
        arrayList2.add("audio/x-mpg");
        arrayList2.add("audio/x-wav");
        arrayList2.add("audio/3gpp");
        arrayList2.add("application/ogg");
        arrayList2.add("audio/ogg");
        arrayList3.add("video/3gpp");
        arrayList3.add("video/3gpp2");
        arrayList3.add("video/h263");
        arrayList3.add("video/mp4");
    }

    public static ArrayList<String> a() {
        return (ArrayList) f6358b.clone();
    }

    public static ArrayList<String> b() {
        return (ArrayList) f6357a.clone();
    }

    public static ArrayList<String> c() {
        return (ArrayList) f6359c.clone();
    }

    public static boolean d(String str) {
        return str != null && (str.startsWith("audio/") || str.equalsIgnoreCase("application/ogg") || str.equalsIgnoreCase("audio/ogg"));
    }

    public static boolean e(String str) {
        return str != null && (str.equals("application/vnd.oma.drm.content") || str.equals("application/vnd.oma.drm.message"));
    }

    public static boolean f(String str) {
        return str != null && str.startsWith("image/");
    }

    public static boolean g(String str) {
        return "text/plain".equals(str) || "text/html".equals(str) || "application/vnd.wap.xhtml+xml".equals(str);
    }

    public static boolean h(String str) {
        return str != null && str.startsWith("video/");
    }
}
