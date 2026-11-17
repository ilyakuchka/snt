package t;

import O3.c;
import O3.d;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.view.u;
import androidx.lifecycle.k;
import androidx.lifecycle.x;
import com.android.mmt.R;
import com.bumptech.glide.i;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;
import miuix.appcompat.internal.app.widget.ActionBarOverlayLayout;
import w0.InterfaceC0407b;

/* renamed from: t.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0384b implements u, InterfaceC0407b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f7872a = {R.attr.fabColor, R.attr.fabShadowEnabled};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f7873b = {R.attr.lunarCalendar};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f7874c = {android.R.attr.textColorHighlight, android.R.attr.textColorHint, android.R.attr.background, android.R.attr.text, android.R.attr.labelTextSize, R.attr.labelPadding, R.attr.labelTextColor, R.attr.pickerBackgroundColor, R.attr.textSizeHighlight, R.attr.textSizeHint};
    public static final int[] d = {android.R.attr.background, R.attr.bar, R.attr.barOff, R.attr.barOn, R.attr.frame, R.attr.sliderOff, R.attr.sliderOn, R.attr.slidingBarColor};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f7875e = {android.R.attr.name, android.R.attr.id, android.R.attr.tag};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f7876f = {android.R.attr.name, android.R.attr.tag};
    public static final int[] g = {android.R.attr.selectableItemBackground, R.attr.selectableItemBackground};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f7877h = {android.R.attr.summaryOn, android.R.attr.summaryOff, android.R.attr.disableDependentsState, R.attr.disableDependentsState, R.attr.summaryOff, R.attr.summaryOn};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f7878i = {android.R.attr.dialogTitle, android.R.attr.dialogMessage, android.R.attr.dialogIcon, android.R.attr.positiveButtonText, android.R.attr.negativeButtonText, android.R.attr.dialogLayout, R.attr.dialogIcon, R.attr.dialogLayout, R.attr.dialogMessage, R.attr.dialogTitle, R.attr.negativeButtonText, R.attr.positiveButtonText};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f7879j = {R.attr.useSimpleSummaryProvider};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f7880k = {android.R.attr.entries, android.R.attr.entryValues, R.attr.entries, R.attr.entryValues, R.attr.useSimpleSummaryProvider};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f7881l = {android.R.attr.entries, android.R.attr.entryValues, R.attr.entries, R.attr.entryValues};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f7882m = {android.R.attr.icon, android.R.attr.persistent, android.R.attr.enabled, android.R.attr.layout, android.R.attr.title, android.R.attr.selectable, android.R.attr.key, android.R.attr.summary, android.R.attr.order, android.R.attr.widgetLayout, android.R.attr.dependency, android.R.attr.defaultValue, android.R.attr.shouldDisableView, android.R.attr.fragment, android.R.attr.singleLineTitle, android.R.attr.iconSpaceReserved, R.attr.allowDividerAbove, R.attr.allowDividerBelow, R.attr.defaultValue, R.attr.dependency, R.attr.enableCopying, R.attr.enabled, R.attr.fragment, R.attr.icon, R.attr.iconSpaceReserved, R.attr.isPreferenceVisible, R.attr.key, R.attr.layout, R.attr.order, R.attr.persistent, R.attr.selectable, R.attr.shouldDisableView, R.attr.singleLineTitle, R.attr.summary, R.attr.title, R.attr.widgetLayout};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f7883n = {android.R.attr.layout, android.R.attr.divider, android.R.attr.dividerHeight, R.attr.allowDividerAfterLastItem};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f7884o = {android.R.attr.orderingFromXml, R.attr.initialExpandedChildrenCount, R.attr.orderingFromXml};
    public static final int[] p = {android.R.attr.maxWidth, android.R.attr.maxHeight, R.attr.maxHeight, R.attr.maxWidth};

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f7885q = {android.R.attr.layout, android.R.attr.max, R.attr.adjustable, R.attr.min, R.attr.seekBarIncrement, R.attr.showSeekBarValue, R.attr.updatesContinuously};

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f7886r = {android.R.attr.summaryOn, android.R.attr.summaryOff, android.R.attr.disableDependentsState, android.R.attr.switchTextOn, android.R.attr.switchTextOff, R.attr.disableDependentsState, R.attr.summaryOff, R.attr.summaryOn, R.attr.switchTextOff, R.attr.switchTextOn};

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f7887s = {android.R.attr.summaryOn, android.R.attr.summaryOff, android.R.attr.disableDependentsState, android.R.attr.switchTextOn, android.R.attr.switchTextOff, R.attr.disableDependentsState, R.attr.summaryOff, R.attr.summaryOn, R.attr.switchTextOff, R.attr.switchTextOn};

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f7888t = {android.R.attr.minWidth, android.R.attr.minHeight, R.attr.cardBackgroundColor, R.attr.cardCornerRadius, R.attr.cardElevation, R.attr.cardMaxElevation, R.attr.cardPreventCornerOverlap, R.attr.cardUseCompatPadding, R.attr.contentPadding, R.attr.contentPaddingBottom, R.attr.contentPaddingLeft, R.attr.contentPaddingRight, R.attr.contentPaddingTop};
    public static final int[] u = {android.R.attr.color, android.R.attr.alpha, R.attr.alpha};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f7889v = {R.attr.fontProviderAuthority, R.attr.fontProviderCerts, R.attr.fontProviderFetchStrategy, R.attr.fontProviderFetchTimeout, R.attr.fontProviderPackage, R.attr.fontProviderQuery, R.attr.fontProviderSystemFontFamily};

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f7890w = {android.R.attr.font, android.R.attr.fontWeight, android.R.attr.fontStyle, android.R.attr.ttcIndex, android.R.attr.fontVariationSettings, R.attr.font, R.attr.fontStyle, R.attr.fontVariationSettings, R.attr.fontWeight, R.attr.ttcIndex};

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f7891x = {android.R.attr.startColor, android.R.attr.endColor, android.R.attr.type, android.R.attr.centerX, android.R.attr.centerY, android.R.attr.gradientRadius, android.R.attr.tileMode, android.R.attr.centerColor, android.R.attr.startX, android.R.attr.startY, android.R.attr.endX, android.R.attr.endY};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f7892y = {android.R.attr.color, android.R.attr.offset};

    public static final void d(O3.a aVar, c cVar, String str) {
        d.b bVar = d.f854h;
        Logger logger = d.f856j;
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f());
        sb.append(' ');
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        f3.c.c(str2, "format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(aVar.b());
        logger.fine(sb.toString());
    }

    public static void e(Object obj, StringBuilder sb) {
        int iLastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void f(boolean z4, String str) {
        if (!z4) {
            throw new IllegalArgumentException(str);
        }
    }

    public static int g(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static Object h(Object obj) {
        Objects.requireNonNull(obj, "Argument must not be null");
        return obj;
    }

    public static Object i(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static boolean j(String str) {
        return str.equals(C0.a.c().getResources().getConfiguration().locale.getCountry());
    }

    public static int k(Context context, String str) {
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) == -1) {
            return -1;
        }
        String strPermissionToOp = AppOpsManager.permissionToOp(str);
        if (strPermissionToOp != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            if (((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, packageName) != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static void l(View view, int i2, int i4, int i5, int i6, boolean z4, int i7) {
        int i8 = z4 ? i7 - i5 : i2;
        if (z4) {
            i5 = i7 - i2;
        }
        view.layout(i8, i4, i5, i6);
    }

    public static final String m(long j2) {
        String str;
        if (j2 <= -999500000) {
            str = ((j2 - 500000000) / 1000000000) + " s ";
        } else if (j2 <= -999500) {
            str = ((j2 - 500000) / 1000000) + " ms";
        } else if (j2 <= 0) {
            str = ((j2 - 500) / 1000) + " µs";
        } else if (j2 < 999500) {
            str = ((j2 + 500) / 1000) + " µs";
        } else if (j2 < 999500000) {
            str = ((j2 + 500000) / 1000000) + " ms";
        } else {
            str = ((j2 + 500000000) / 1000000000) + " s ";
        }
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        f3.c.c(str2, "format(format, *args)");
        return str2;
    }

    public static ViewGroup n(View view) {
        while (view != null) {
            if (view instanceof ActionBarOverlayLayout) {
                return (ActionBarOverlayLayout) view;
            }
            view = view.getParent() instanceof View ? (View) view.getParent() : null;
        }
        return null;
    }

    public static final int o(int i2, int i4, int i5) {
        if (i5 > 0) {
            if (i2 >= i4) {
                return i4;
            }
            int i6 = i4 % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i2 % i5;
            if (i7 < 0) {
                i7 += i5;
            }
            int i8 = (i6 - i7) % i5;
            if (i8 < 0) {
                i8 += i5;
            }
            return i4 - i8;
        }
        if (i5 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        if (i2 <= i4) {
            return i4;
        }
        int i9 = -i5;
        int i10 = i2 % i9;
        if (i10 < 0) {
            i10 += i9;
        }
        int i11 = i4 % i9;
        if (i11 < 0) {
            i11 += i9;
        }
        int i12 = (i10 - i11) % i9;
        if (i12 < 0) {
            i12 += i9;
        }
        return i4 + i12;
    }

    public static Uri p(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        try {
            return contentResolver.insert(uri, contentValues);
        } catch (SQLiteException e2) {
            Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when insert", e2);
            return null;
        } catch (IllegalArgumentException e4) {
            Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when insert", e4);
            return null;
        }
    }

    public static boolean q(Activity activity) throws NoSuchMethodException, SecurityException {
        try {
            Method method = activity.getClass().getMethod("isInMultiWindowMode", new Class[0]);
            method.setAccessible(true);
            return ((Boolean) method.invoke(activity, new Object[0])).booleanValue();
        } catch (Exception e2) {
            Log.e("CompatUtil", "reflection error", e2);
            return false;
        }
    }

    public static Cursor r(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (SQLiteException e2) {
            Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when query", e2);
            return null;
        } catch (IllegalArgumentException e4) {
            Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when query", e4);
            return null;
        }
    }

    public static Cursor s(Context context, ContentResolver contentResolver, Uri uri, String[] strArr, String str, String str2) {
        boolean z4;
        try {
            return contentResolver.query(uri, strArr, str, null, str2);
        } catch (SQLiteException e2) {
            Log.e("SmsSqliteWrapper", "Catch a SQLiteException when query: ", e2);
            if ((e2 instanceof SQLiteFullException) && e2.getMessage().contains("database or disk is full")) {
                Log.e("SmsSqliteWrapper", "Sqlite disk is full.");
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                if (!e2.getMessage().equals("unable to open database file")) {
                    throw e2;
                }
                Toast.makeText(context, context.getText(R.string.sqlite_low_memory), 0).show();
            }
            return null;
        } catch (SecurityException e4) {
            if (e4.getMessage() == null || e4.getMessage().indexOf("android.permission.READ_SMS") >= 0) {
                return null;
            }
            throw e4;
        }
    }

    public static void t(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (O2.a.a()) {
            context.registerReceiver(broadcastReceiver, intentFilter, 2);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public static void u(View view, k kVar) {
        view.setTag(R.id.view_tree_lifecycle_owner, kVar);
    }

    public static void v(View view, x xVar) {
        view.setTag(R.id.view_tree_view_model_store_owner, xVar);
    }

    public static void w(View view, androidx.savedstate.b bVar) {
        view.setTag(R.id.view_tree_saved_state_registry_owner, bVar);
    }

    public static int x(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        try {
            return contentResolver.update(uri, contentValues, null, null);
        } catch (SQLiteException e2) {
            Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when update", e2);
            return -1;
        } catch (IllegalArgumentException e4) {
            Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when update", e4);
            return -1;
        }
    }

    public static i y(Context context) {
        if (context == null) {
            context = C0.a.c();
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                context = context.getApplicationContext();
            }
        }
        return com.bumptech.glide.c.o(context);
    }

    @Override // androidx.core.view.u
    public void b(View view) {
    }

    @Override // androidx.core.view.u
    public void c() {
    }
}
