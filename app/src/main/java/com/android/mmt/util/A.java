package com.android.mmt.util;

import O2.a;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.PermissionCheckActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f5835a = {"android.permission.READ_SMS", "android.permission.RECEIVE_SMS", "android.permission.SEND_SMS", "android.permission.RECEIVE_MMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};

    /* renamed from: b, reason: collision with root package name */
    private static String[] f5836b = {"android.permission.READ_SMS", "android.permission.RECEIVE_SMS", "android.permission.SEND_SMS", "android.permission.RECEIVE_MMS", "android.permission.RECEIVE_WAP_PUSH"};

    /* renamed from: c, reason: collision with root package name */
    private static String[] f5837c = {"android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE"};
    private static String[] d = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};

    /* renamed from: e, reason: collision with root package name */
    private static Hashtable<String, Integer> f5838e = new Hashtable<>();

    public static String[] a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!h(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        return strArr2;
    }

    public static void b(Activity activity, int i2, boolean z4) {
        g.a aVar = new g.a(activity, R.style.MmsTheme_Dialog);
        aVar.j(i2);
        aVar.c(false);
        aVar.t(R.string.permission_retry_setting, new DialogInterfaceOnClickListenerC0293z(activity, z4));
        aVar.m(R.string.permission_retry_deny, new DialogInterfaceOnClickListenerC0293z(z4, activity));
        aVar.a().show();
    }

    public static boolean c(Activity activity, String[] strArr) {
        String[] strArrA = a(strArr);
        List listAsList = Arrays.asList("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
        List listAsList2 = Arrays.asList("android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO");
        List listAsList3 = Arrays.asList("android.permission.READ_MEDIA_AUDIO");
        ArrayList arrayList = new ArrayList();
        for (String str : strArrA) {
            if (!activity.shouldShowRequestPermissionRationale(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == strArrA.length) {
            for (String str2 : strArrA) {
                if (TextUtils.equals(str2, "android.permission.CAMERA")) {
                    b(activity, R.string.toast_not_show_camera_perm_req, false);
                    return true;
                }
                if (TextUtils.equals(str2, "android.permission.RECORD_AUDIO")) {
                    b(activity, R.string.toast_not_show_microphone_perm_req, false);
                    return true;
                }
                if (listAsList.contains(str2)) {
                    b(activity, R.string.toast_not_show_storage_perm_req, false);
                    return true;
                }
                if (a.a() && listAsList2.contains(str2)) {
                    b(activity, R.string.toast_not_show_storage_perm_req, false);
                    return true;
                }
                if (a.a() && listAsList3.contains(str2)) {
                    b(activity, R.string.toast_not_show_storage_perm_req, false);
                    return true;
                }
            }
        }
        return false;
    }

    private static void d(SecurityException securityException, String str) {
        if (securityException.getMessage() != null && securityException.getMessage().indexOf(str) < 0) {
            throw securityException;
        }
    }

    public static void e(SecurityException securityException) {
        d(securityException, "android.permission.READ_CONTACTS");
    }

    public static void f(SecurityException securityException) {
        d(securityException, "android.permission.READ_PHONE_STATE");
    }

    public static void g(SecurityException securityException) {
        d(securityException, "android.permission.READ_SMS");
    }

    public static boolean h(String str) {
        if (!f5838e.containsKey(str) || f5838e.get(str).intValue() == -1) {
            f5838e.put(str, Integer.valueOf(MmsApp.c().getApplicationContext().checkSelfPermission(str)));
        }
        return f5838e.get(str).intValue() == 0;
    }

    public static boolean i() {
        String[] strArr = f5835a;
        for (int i2 = 0; i2 < 10; i2++) {
            String str = strArr[i2];
            if (!h(str)) {
                Log.w("PermissionUtils", "missing permission: " + str);
                return false;
            }
        }
        return true;
    }

    public static boolean j(Activity activity) {
        if ((activity instanceof PermissionCheckActivity) || i()) {
            return false;
        }
        String[] strArrA = a(f5835a);
        ArrayList arrayList = new ArrayList();
        int length = strArrA.length;
        int i2 = 0;
        while (true) {
            boolean z4 = true;
            if (i2 >= length) {
                break;
            }
            String str = strArrA[i2];
            String[] strArr = f5836b;
            int i4 = 0;
            while (true) {
                if (i4 >= 5) {
                    String[] strArr2 = d;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= 3) {
                            String[] strArr3 = f5837c;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= 2) {
                                    break;
                                }
                                if (TextUtils.equals(strArr3[i6], str)) {
                                    String[] strArr4 = f5837c;
                                    for (int i7 = 0; i7 < 2; i7++) {
                                        if (h(strArr4[i7])) {
                                            break;
                                        }
                                    }
                                } else {
                                    i6++;
                                }
                            }
                        } else if (TextUtils.equals(strArr2[i5], str)) {
                            String[] strArr5 = d;
                            for (int i8 = 0; i8 < 3; i8++) {
                                if (h(strArr5[i8])) {
                                    break;
                                }
                            }
                        } else {
                            i5++;
                        }
                    }
                } else if (TextUtils.equals(strArr[i4], str)) {
                    String[] strArr6 = f5836b;
                    for (int i9 = 0; i9 < 5; i9++) {
                        if (h(strArr6[i9])) {
                            break;
                        }
                    }
                } else {
                    i4++;
                }
            }
            z4 = false;
            if (z4) {
                arrayList.add(str);
            }
            i2++;
        }
        if (arrayList.size() == strArrA.length) {
            activity.requestPermissions((String[]) arrayList.toArray(new String[0]), 1100);
            return false;
        }
        activity.startActivity(new Intent(activity, (Class<?>) PermissionCheckActivity.class));
        return true;
    }

    public static boolean k(miuix.appcompat.app.h hVar, String[] strArr, int i2) {
        if (strArr != null && strArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && hVar.checkSelfPermission(str) != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                hVar.requestPermissions((String[]) arrayList.toArray(new String[0]), i2);
                return true;
            }
        }
        return false;
    }
}
