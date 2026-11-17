package C;

import C.j;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import miuix.appcompat.internal.app.widget.SearchActionModeView;
import x.C0412a;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<byte[]> f23a = new a();

    final class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length == bArr4.length) {
                for (int i2 = 0; i2 < bArr3.length; i2++) {
                    if (bArr3[i2] != bArr4[i2]) {
                        length = bArr3[i2];
                        length2 = bArr4[i2];
                    }
                }
                return 0;
            }
            length = bArr3.length;
            length2 = bArr4.length;
            return length - length2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098 A[LOOP:1: B:15:0x0053->B:30:0x0098, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x009c A[EDGE_INSN: B:82:0x009c->B:32:0x009c BREAK  A[LOOP:1: B:15:0x0053->B:30:0x0098], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static j.a a(Context context, e eVar) throws PackageManager.NameNotFoundException {
        Cursor cursorQuery;
        boolean z4;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String strC = eVar.c();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strC, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(D2.e.c("No package found for authority: ", strC));
        }
        if (!providerInfoResolveContentProvider.packageName.equals(eVar.d())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strC + ", but package was not " + eVar.d());
        }
        Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        Collections.sort(arrayList, f23a);
        List<List<byte[]>> listA = eVar.a() != null ? eVar.a() : C0412a.b(resources, 0);
        int i2 = 0;
        while (true) {
            cursorQuery = null;
            if (i2 >= listA.size()) {
                providerInfoResolveContentProvider = null;
                break;
            }
            ArrayList arrayList2 = new ArrayList(listA.get(i2));
            Collections.sort(arrayList2, f23a);
            if (arrayList.size() != arrayList2.size()) {
                z4 = false;
                if (!z4) {
                    break;
                }
                i2++;
            } else {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    if (!Arrays.equals((byte[]) arrayList.get(i4), (byte[]) arrayList2.get(i4))) {
                        z4 = false;
                        break;
                    }
                }
                z4 = true;
                if (!z4) {
                }
            }
        }
        if (providerInfoResolveContentProvider == null) {
            return new j.a(1, null);
        }
        String str = providerInfoResolveContentProvider.authority;
        ArrayList arrayList3 = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        try {
            cursorQuery = context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{eVar.e()}, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("result_code");
                ArrayList arrayList4 = new ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                while (cursorQuery.moveToNext()) {
                    arrayList4.add(new j.b(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : SearchActionModeView.ANIMATION_DURATION, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0));
                }
                arrayList3 = arrayList4;
            }
            return new j.a(0, (j.b[]) arrayList3.toArray(new j.b[0]));
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}
