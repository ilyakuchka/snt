package h0;

import D2.e;
import android.content.Context;
import android.drm.DrmConvertedStatus;
import android.drm.DrmManagerClient;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: h0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0331b {

    /* renamed from: a, reason: collision with root package name */
    private DrmManagerClient f6312a;

    /* renamed from: b, reason: collision with root package name */
    private int f6313b;

    private C0331b(DrmManagerClient drmManagerClient, int i2) {
        this.f6312a = drmManagerClient;
        this.f6313b = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.drm.DrmManagerClient] */
    /* JADX WARN: Type inference failed for: r3v10, types: [android.drm.DrmManagerClient] */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0331b c(Context context, String str) {
        ?? Equals;
        int iOpenConvertSession = -1;
        if (context == null || (Equals = str.equals("")) != 0) {
            Equals = 0;
        } else {
            try {
                try {
                    Equals = new DrmManagerClient(context);
                } catch (IllegalArgumentException unused) {
                    Log.w("DrmConvertSession", "DrmManagerClient instance could not be created, context is Illegal.");
                    if (Equals != 0) {
                    }
                    return null;
                } catch (IllegalStateException unused2) {
                    Log.w("DrmConvertSession", "DrmManagerClient didn't initialize properly.");
                    if (Equals != 0) {
                    }
                    return null;
                }
                try {
                    iOpenConvertSession = Equals.openConvertSession(str);
                } catch (IllegalArgumentException e2) {
                    Log.w("DrmConvertSession", "Conversion of Mimetype: " + str + " is not supported.", e2);
                    if (Equals != 0) {
                    }
                    return null;
                } catch (IllegalStateException e4) {
                    Log.w("DrmConvertSession", "Could not access Open DrmFramework.", e4);
                    if (Equals != 0) {
                    }
                    return null;
                }
            } catch (IllegalArgumentException unused3) {
                Equals = 0;
                Log.w("DrmConvertSession", "DrmManagerClient instance could not be created, context is Illegal.");
                if (Equals != 0) {
                }
                return null;
            } catch (IllegalStateException unused4) {
                Equals = 0;
                Log.w("DrmConvertSession", "DrmManagerClient didn't initialize properly.");
                if (Equals != 0) {
                }
                return null;
            }
        }
        if (Equals != 0 || iOpenConvertSession < 0) {
            return null;
        }
        return new C0331b(Equals, iOpenConvertSession);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(String str) throws Throwable {
        int i2;
        RandomAccessFile randomAccessFile;
        StringBuilder sb;
        RandomAccessFile randomAccessFile2;
        DrmManagerClient drmManagerClient = this.f6312a;
        int i4 = 491;
        if (drmManagerClient == null || (i2 = this.f6313b) < 0) {
            return 491;
        }
        try {
            DrmConvertedStatus drmConvertedStatusCloseConvertSession = drmManagerClient.closeConvertSession(i2);
            if (drmConvertedStatusCloseConvertSession == null || drmConvertedStatusCloseConvertSession.statusCode != 1 || drmConvertedStatusCloseConvertSession.convertedData == null) {
                return 406;
            }
            RandomAccessFile randomAccessFile3 = null;
            RandomAccessFile randomAccessFile4 = null;
            RandomAccessFile randomAccessFile5 = null;
            RandomAccessFile randomAccessFile6 = null;
            RandomAccessFile randomAccessFile7 = null;
            RandomAccessFile randomAccessFile8 = null;
            try {
                try {
                    try {
                        try {
                            randomAccessFile = new RandomAccessFile(str, "rw");
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile = randomAccessFile3;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile = randomAccessFile8;
                        i4 = 492;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                } catch (IOException e4) {
                    e = e4;
                } catch (IllegalArgumentException e5) {
                    e = e5;
                } catch (SecurityException e6) {
                    e = e6;
                }
                try {
                    int i5 = drmConvertedStatusCloseConvertSession.offset;
                    randomAccessFile.seek(i5);
                    randomAccessFile.write(drmConvertedStatusCloseConvertSession.convertedData);
                    i4 = 200;
                    try {
                        randomAccessFile.close();
                        randomAccessFile3 = i5;
                    } catch (IOException e7) {
                        e = e7;
                        sb = new StringBuilder();
                        sb.append("Failed to close File:");
                        sb.append(str);
                        sb.append(".");
                        randomAccessFile2 = i5;
                        str = sb.toString();
                        Log.w("DrmConvertSession", str, e);
                        randomAccessFile8 = randomAccessFile2;
                        return 492;
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                    randomAccessFile4 = randomAccessFile;
                    Log.w("DrmConvertSession", "File: " + str + " could not be found.", e);
                    randomAccessFile8 = randomAccessFile4;
                    if (randomAccessFile4 != null) {
                        try {
                            randomAccessFile4.close();
                            randomAccessFile8 = randomAccessFile4;
                        } catch (IOException e9) {
                            e = e9;
                            sb = new StringBuilder();
                            sb.append("Failed to close File:");
                            sb.append(str);
                            sb.append(".");
                            randomAccessFile2 = randomAccessFile4;
                            str = sb.toString();
                            Log.w("DrmConvertSession", str, e);
                            randomAccessFile8 = randomAccessFile2;
                            return 492;
                        }
                    }
                    return 492;
                } catch (IOException e10) {
                    e = e10;
                    randomAccessFile5 = randomAccessFile;
                    Log.w("DrmConvertSession", "Could not access File: " + str + " .", e);
                    randomAccessFile8 = randomAccessFile5;
                    if (randomAccessFile5 != null) {
                        try {
                            randomAccessFile5.close();
                            randomAccessFile8 = randomAccessFile5;
                        } catch (IOException e11) {
                            e = e11;
                            sb = new StringBuilder();
                            sb.append("Failed to close File:");
                            sb.append(str);
                            sb.append(".");
                            randomAccessFile2 = randomAccessFile5;
                            str = sb.toString();
                            Log.w("DrmConvertSession", str, e);
                            randomAccessFile8 = randomAccessFile2;
                            return 492;
                        }
                    }
                    return 492;
                } catch (IllegalArgumentException e12) {
                    e = e12;
                    randomAccessFile6 = randomAccessFile;
                    Log.w("DrmConvertSession", "Could not open file in mode: rw", e);
                    randomAccessFile8 = randomAccessFile6;
                    if (randomAccessFile6 != null) {
                        try {
                            randomAccessFile6.close();
                            randomAccessFile8 = randomAccessFile6;
                        } catch (IOException e13) {
                            e = e13;
                            sb = new StringBuilder();
                            sb.append("Failed to close File:");
                            sb.append(str);
                            sb.append(".");
                            randomAccessFile2 = randomAccessFile6;
                            str = sb.toString();
                            Log.w("DrmConvertSession", str, e);
                            randomAccessFile8 = randomAccessFile2;
                            return 492;
                        }
                    }
                    return 492;
                } catch (SecurityException e14) {
                    e = e14;
                    randomAccessFile7 = randomAccessFile;
                    Log.w("DrmConvertSession", "Access to File: " + str + " was denied denied by SecurityManager.", e);
                    randomAccessFile3 = randomAccessFile7;
                    if (randomAccessFile7 != null) {
                        try {
                            randomAccessFile7.close();
                            randomAccessFile3 = randomAccessFile7;
                        } catch (IOException e15) {
                            e = e15;
                            sb = new StringBuilder();
                            sb.append("Failed to close File:");
                            sb.append(str);
                            sb.append(".");
                            randomAccessFile2 = randomAccessFile7;
                            str = sb.toString();
                            Log.w("DrmConvertSession", str, e);
                            randomAccessFile8 = randomAccessFile2;
                            return 492;
                        }
                    }
                    return i4;
                } catch (Throwable th3) {
                    th = th3;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e16) {
                            Log.w("DrmConvertSession", "Failed to close File:" + str + ".", e16);
                            throw th;
                        }
                    }
                    throw th;
                }
                return i4;
            } catch (IllegalStateException e17) {
                e = e17;
                i4 = 492;
                StringBuilder sbD = e.d("Could not close convertsession. Convertsession: ");
                sbD.append(this.f6313b);
                Log.w("DrmConvertSession", sbD.toString(), e);
                return i4;
            }
        } catch (IllegalStateException e18) {
            e = e18;
        }
    }

    public final byte[] b(byte[] bArr, int i2) {
        DrmConvertedStatus drmConvertedStatusConvertData;
        try {
            if (i2 != bArr.length) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                drmConvertedStatusConvertData = this.f6312a.convertData(this.f6313b, bArr2);
            } else {
                drmConvertedStatusConvertData = this.f6312a.convertData(this.f6313b, bArr);
            }
            if (drmConvertedStatusConvertData == null || drmConvertedStatusConvertData.statusCode != 1) {
                return null;
            }
            byte[] bArr3 = drmConvertedStatusConvertData.convertedData;
            if (bArr3 != null) {
                return bArr3;
            }
            return null;
        } catch (IllegalArgumentException e2) {
            StringBuilder sbD = e.d("Buffer with data to convert is illegal. Convertsession: ");
            sbD.append(this.f6313b);
            Log.w("DrmConvertSession", sbD.toString(), e2);
            return null;
        } catch (IllegalStateException e4) {
            StringBuilder sbD2 = e.d("Could not convert data. Convertsession: ");
            sbD2.append(this.f6313b);
            Log.w("DrmConvertSession", sbD2.toString(), e4);
            return null;
        }
    }
}
