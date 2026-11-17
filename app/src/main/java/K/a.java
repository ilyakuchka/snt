package K;

import D2.e;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: A, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f288A;

    /* renamed from: B, reason: collision with root package name */
    static final Charset f289B;

    /* renamed from: C, reason: collision with root package name */
    static final byte[] f290C;

    /* renamed from: k, reason: collision with root package name */
    private static final List<Integer> f291k = Arrays.asList(1, 6, 3, 8);

    /* renamed from: l, reason: collision with root package name */
    private static final List<Integer> f292l = Arrays.asList(2, 7, 4, 5);

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f293m = {8, 8, 8};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f294n = {8};

    /* renamed from: o, reason: collision with root package name */
    static final byte[] f295o = {-1, -40, -1};
    private static final byte[] p = {79, 76, 89, 77, 80, 0};

    /* renamed from: q, reason: collision with root package name */
    private static final byte[] f296q = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: r, reason: collision with root package name */
    static final String[] f297r = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* renamed from: s, reason: collision with root package name */
    static final int[] f298s = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: t, reason: collision with root package name */
    static final byte[] f299t = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final c u;

    /* renamed from: v, reason: collision with root package name */
    static final c[][] f300v;

    /* renamed from: w, reason: collision with root package name */
    private static final c[] f301w;

    /* renamed from: x, reason: collision with root package name */
    private static final HashMap<Integer, c>[] f302x;

    /* renamed from: y, reason: collision with root package name */
    private static final HashMap<String, c>[] f303y;

    /* renamed from: z, reason: collision with root package name */
    private static final HashSet<String> f304z;

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager.AssetInputStream f305a;

    /* renamed from: b, reason: collision with root package name */
    private int f306b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, b>[] f307c;
    private Set<Integer> d;

    /* renamed from: e, reason: collision with root package name */
    private ByteOrder f308e;

    /* renamed from: f, reason: collision with root package name */
    private int f309f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f310h;

    /* renamed from: i, reason: collision with root package name */
    private int f311i;

    /* renamed from: j, reason: collision with root package name */
    private int f312j;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f319a;

        /* renamed from: b, reason: collision with root package name */
        public final int f320b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f321c;

        b(int i2, int i4, byte[] bArr) {
            this.f319a = i2;
            this.f320b = i4;
            this.f321c = bArr;
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f289B);
            return new b(2, bytes.length, bytes);
        }

        public static b b(long j2, ByteOrder byteOrder) {
            long[] jArr = {j2};
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f298s[4] * 1]);
            byteBufferWrap.order(byteOrder);
            for (int i2 = 0; i2 < 1; i2++) {
                byteBufferWrap.putInt((int) jArr[i2]);
            }
            return new b(4, 1, byteBufferWrap.array());
        }

        public static b c(d dVar, ByteOrder byteOrder) {
            d[] dVarArr = {dVar};
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f298s[5] * 1]);
            byteBufferWrap.order(byteOrder);
            for (int i2 = 0; i2 < 1; i2++) {
                d dVar2 = dVarArr[i2];
                byteBufferWrap.putInt((int) dVar2.f325a);
                byteBufferWrap.putInt((int) dVar2.f326b);
            }
            return new b(5, 1, byteBufferWrap.array());
        }

        public static b d(int i2, ByteOrder byteOrder) {
            int[] iArr = {i2};
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f298s[3] * 1]);
            byteBufferWrap.order(byteOrder);
            for (int i4 = 0; i4 < 1; i4++) {
                byteBufferWrap.putShort((short) iArr[i4]);
            }
            return new b(3, 1, byteBufferWrap.array());
        }

        public final double e(ByteOrder byteOrder) throws Throwable {
            Object objH = h(byteOrder);
            if (objH == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objH instanceof String) {
                return Double.parseDouble((String) objH);
            }
            if (objH instanceof long[]) {
                if (((long[]) objH).length == 1) {
                    return r3[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objH instanceof int[]) {
                if (((int[]) objH).length == 1) {
                    return r3[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objH instanceof double[]) {
                double[] dArr = (double[]) objH;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objH instanceof d[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            d[] dVarArr = (d[]) objH;
            if (dVarArr.length != 1) {
                throw new NumberFormatException("There are more than one component");
            }
            d dVar = dVarArr[0];
            return dVar.f325a / dVar.f326b;
        }

        public final int f(ByteOrder byteOrder) throws Throwable {
            Object objH = h(byteOrder);
            if (objH == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objH instanceof String) {
                return Integer.parseInt((String) objH);
            }
            if (objH instanceof long[]) {
                long[] jArr = (long[]) objH;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objH instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objH;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public final String g(ByteOrder byteOrder) throws Throwable {
            Object objH = h(byteOrder);
            if (objH == null) {
                return null;
            }
            if (objH instanceof String) {
                return (String) objH;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (objH instanceof long[]) {
                long[] jArr = (long[]) objH;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objH instanceof int[]) {
                int[] iArr = (int[]) objH;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objH instanceof double[]) {
                double[] dArr = (double[]) objH;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objH instanceof d[])) {
                return null;
            }
            d[] dVarArr = (d[]) objH;
            while (i2 < dVarArr.length) {
                sb.append(dVarArr[i2].f325a);
                sb.append('/');
                sb.append(dVarArr[i2].f326b);
                i2++;
                if (i2 != dVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x019c: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:152:0x019c */
        /* JADX WARN: Removed duplicated region for block: B:176:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final Object h(ByteOrder byteOrder) throws Throwable {
            C0013a c0013a;
            InputStream inputStream;
            byte b2;
            byte[] bArr;
            InputStream inputStream2 = null;
            try {
                try {
                    c0013a = new C0013a(this.f321c);
                    try {
                        c0013a.I(byteOrder);
                        boolean z4 = true;
                        int length = 0;
                        switch (this.f319a) {
                            case 1:
                            case 6:
                                byte[] bArr2 = this.f321c;
                                if (bArr2.length != 1 || bArr2[0] < 0 || bArr2[0] > 1) {
                                    String str = new String(bArr2, a.f289B);
                                    try {
                                        c0013a.close();
                                    } catch (IOException e2) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                    }
                                    return str;
                                }
                                String str2 = new String(new char[]{(char) (bArr2[0] + 48)});
                                try {
                                    c0013a.close();
                                } catch (IOException e4) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                                }
                                return str2;
                            case 2:
                            case 7:
                                if (this.f320b >= a.f299t.length) {
                                    int i2 = 0;
                                    while (true) {
                                        bArr = a.f299t;
                                        if (i2 < bArr.length) {
                                            if (this.f321c[i2] != bArr[i2]) {
                                                z4 = false;
                                            } else {
                                                i2++;
                                            }
                                        }
                                    }
                                    if (z4) {
                                        length = bArr.length;
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (length < this.f320b && (b2 = this.f321c[length]) != 0) {
                                    if (b2 >= 32) {
                                        sb.append((char) b2);
                                    } else {
                                        sb.append('?');
                                    }
                                    length++;
                                }
                                String string = sb.toString();
                                try {
                                    c0013a.close();
                                } catch (IOException e5) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                                }
                                return string;
                            case 3:
                                int[] iArr = new int[this.f320b];
                                while (length < this.f320b) {
                                    iArr[length] = c0013a.readUnsignedShort();
                                    length++;
                                }
                                try {
                                    c0013a.close();
                                } catch (IOException e6) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                                }
                                return iArr;
                            case 4:
                                long[] jArr = new long[this.f320b];
                                while (length < this.f320b) {
                                    jArr[length] = c0013a.f();
                                    length++;
                                }
                                try {
                                    c0013a.close();
                                } catch (IOException e7) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                                }
                                return jArr;
                            case 5:
                                d[] dVarArr = new d[this.f320b];
                                while (length < this.f320b) {
                                    dVarArr[length] = new d(c0013a.f(), c0013a.f());
                                    length++;
                                }
                                try {
                                    c0013a.close();
                                } catch (IOException e8) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                                }
                                return dVarArr;
                            case 8:
                                int[] iArr2 = new int[this.f320b];
                                while (length < this.f320b) {
                                    iArr2[length] = c0013a.readShort();
                                    length++;
                                }
                                try {
                                    c0013a.close();
                                } catch (IOException e9) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                                }
                                return iArr2;
                            case 9:
                                int[] iArr3 = new int[this.f320b];
                                while (length < this.f320b) {
                                    iArr3[length] = c0013a.readInt();
                                    length++;
                                }
                                try {
                                    c0013a.close();
                                } catch (IOException e10) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                                }
                                return iArr3;
                            case 10:
                                d[] dVarArr2 = new d[this.f320b];
                                while (length < this.f320b) {
                                    dVarArr2[length] = new d(c0013a.readInt(), c0013a.readInt());
                                    length++;
                                }
                                try {
                                    c0013a.close();
                                } catch (IOException e11) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                                }
                                return dVarArr2;
                            case 11:
                                double[] dArr = new double[this.f320b];
                                while (length < this.f320b) {
                                    dArr[length] = c0013a.readFloat();
                                    length++;
                                }
                                try {
                                    c0013a.close();
                                } catch (IOException e12) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                                }
                                return dArr;
                            case 12:
                                double[] dArr2 = new double[this.f320b];
                                while (length < this.f320b) {
                                    dArr2[length] = c0013a.readDouble();
                                    length++;
                                }
                                try {
                                    c0013a.close();
                                } catch (IOException e13) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                                }
                                return dArr2;
                            default:
                                try {
                                    c0013a.close();
                                } catch (IOException e14) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                                }
                                return null;
                        }
                    } catch (IOException e15) {
                        e = e15;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (c0013a != null) {
                            try {
                                c0013a.close();
                            } catch (IOException e16) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e17) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e17);
                        }
                    }
                    throw th;
                }
            } catch (IOException e18) {
                e = e18;
                c0013a = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        }

        public final String toString() {
            StringBuilder sbD = e.d("(");
            sbD.append(a.f297r[this.f319a]);
            sbD.append(", data length:");
            sbD.append(this.f321c.length);
            sbD.append(")");
            return sbD.toString();
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f325a;

        /* renamed from: b, reason: collision with root package name */
        public final long f326b;

        d(long j2, long j4) {
            if (j4 == 0) {
                this.f325a = 0L;
                this.f326b = 1L;
            } else {
                this.f325a = j2;
                this.f326b = j4;
            }
        }

        public final String toString() {
            return this.f325a + "/" + this.f326b;
        }
    }

    static {
        c[] cVarArr = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256), new c("ImageLength", 257), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278), new c("StripByteCounts", 279), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
        c[] cVarArr2 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962), new c("PixelYDimension", 40963), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720)};
        c[] cVarArr3 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        c[] cVarArr4 = {new c("InteroperabilityIndex", 1, 2)};
        c[] cVarArr5 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256), new c("ThumbnailImageLength", 257), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278), new c("StripByteCounts", 279), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720)};
        u = new c("StripOffsets", 273, 3);
        f300v = new c[][]{cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr, new c[]{new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)}, new c[]{new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)}, new c[]{new c("AspectFrame", 4371, 3)}, new c[]{new c("ColorSpace", 55, 3)}};
        f301w = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        f302x = new HashMap[10];
        f303y = new HashMap[10];
        f304z = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f288A = new HashMap<>();
        Charset charsetForName = Charset.forName("US-ASCII");
        f289B = charsetForName;
        f290C = "Exif\u0000\u0000".getBytes(charsetForName);
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            c[][] cVarArr6 = f300v;
            if (i2 >= cVarArr6.length) {
                HashMap<Integer, Integer> map = f288A;
                c[] cVarArr7 = f301w;
                map.put(Integer.valueOf(cVarArr7[0].f322a), 5);
                map.put(Integer.valueOf(cVarArr7[1].f322a), 1);
                map.put(Integer.valueOf(cVarArr7[2].f322a), 2);
                map.put(Integer.valueOf(cVarArr7[3].f322a), 3);
                map.put(Integer.valueOf(cVarArr7[4].f322a), 7);
                map.put(Integer.valueOf(cVarArr7[5].f322a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            f302x[i2] = new HashMap<>();
            f303y[i2] = new HashMap<>();
            for (c cVar : cVarArr6[i2]) {
                f302x[i2].put(Integer.valueOf(cVar.f322a), cVar);
                f303y[i2].put(cVar.f323b, cVar);
            }
            i2++;
        }
    }

    public a(InputStream inputStream) throws IOException {
        c[][] cVarArr = f300v;
        this.f307c = new HashMap[cVarArr.length];
        this.d = new HashSet(cVarArr.length);
        this.f308e = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f305a = (AssetManager.AssetInputStream) inputStream;
        } else {
            this.f305a = null;
        }
        for (int i2 = 0; i2 < f300v.length; i2++) {
            try {
                this.f307c[i2] = new HashMap<>();
            } catch (IOException unused) {
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.f306b = g(bufferedInputStream);
        C0013a c0013a = new C0013a(bufferedInputStream);
        switch (this.f306b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                j(c0013a);
                break;
            case 4:
                f(c0013a, 0, 0);
                break;
            case 7:
                h(c0013a);
                break;
            case 9:
                i(c0013a);
                break;
            case 10:
                k(c0013a);
                break;
        }
        q(c0013a);
        a();
    }

    private void a() {
        String strC = c("DateTimeOriginal");
        if (strC != null && c("DateTime") == null) {
            this.f307c[0].put("DateTime", b.a(strC));
        }
        if (c("ImageWidth") == null) {
            this.f307c[0].put("ImageWidth", b.b(0L, this.f308e));
        }
        if (c("ImageLength") == null) {
            this.f307c[0].put("ImageLength", b.b(0L, this.f308e));
        }
        if (c("Orientation") == null) {
            this.f307c[0].put("Orientation", b.b(0L, this.f308e));
        }
        if (c("LightSource") == null) {
            this.f307c[1].put("LightSource", b.b(0L, this.f308e));
        }
    }

    private static long[] b(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            jArr[i2] = iArr[i2];
        }
        return jArr;
    }

    private b e(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < f300v.length; i2++) {
            b bVar = this.f307c[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x011b, code lost:
    
        r10.I(r9.f308e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0120, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(C0013a c0013a, int i2, int i4) throws IOException {
        c0013a.I(ByteOrder.BIG_ENDIAN);
        c0013a.H(i2);
        byte b2 = c0013a.readByte();
        if (b2 != -1) {
            StringBuilder sbD = e.d("Invalid marker: ");
            sbD.append(Integer.toHexString(b2 & 255));
            throw new IOException(sbD.toString());
        }
        int i5 = i2 + 1;
        if (c0013a.readByte() != -40) {
            StringBuilder sbD2 = e.d("Invalid marker: ");
            sbD2.append(Integer.toHexString(b2 & 255));
            throw new IOException(sbD2.toString());
        }
        int i6 = i5 + 1;
        while (true) {
            byte b4 = c0013a.readByte();
            if (b4 != -1) {
                StringBuilder sbD3 = e.d("Invalid marker:");
                sbD3.append(Integer.toHexString(b4 & 255));
                throw new IOException(sbD3.toString());
            }
            byte b5 = c0013a.readByte();
            int i7 = i6 + 1 + 1;
            if (b5 != -39 && b5 != -38) {
                int unsignedShort = c0013a.readUnsignedShort() - 2;
                int i8 = i7 + 2;
                if (unsignedShort < 0) {
                    throw new IOException("Invalid length");
                }
                if (b5 != -31) {
                    if (b5 != -2) {
                        switch (b5) {
                            default:
                                switch (b5) {
                                    default:
                                        switch (b5) {
                                            default:
                                                switch (b5) {
                                                }
                                            case -55:
                                            case -54:
                                            case -53:
                                                if (c0013a.skipBytes(1) != 1) {
                                                    throw new IOException("Invalid SOFx");
                                                }
                                                this.f307c[i4].put("ImageLength", b.b(c0013a.readUnsignedShort(), this.f308e));
                                                this.f307c[i4].put("ImageWidth", b.b(c0013a.readUnsignedShort(), this.f308e));
                                                unsignedShort -= 5;
                                                break;
                                        }
                                    case -59:
                                    case -58:
                                    case -57:
                                        break;
                                }
                            case -64:
                            case -63:
                            case -62:
                            case -61:
                                break;
                        }
                    } else {
                        byte[] bArr = new byte[unsignedShort];
                        if (c0013a.read(bArr) != unsignedShort) {
                            throw new IOException("Invalid exif");
                        }
                        if (c("UserComment") == null) {
                            this.f307c[1].put("UserComment", b.a(new String(bArr, f289B)));
                        }
                        unsignedShort = 0;
                    }
                } else if (unsignedShort >= 6) {
                    byte[] bArr2 = new byte[6];
                    if (c0013a.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    i8 += 6;
                    unsignedShort -= 6;
                    if (Arrays.equals(bArr2, f290C)) {
                        if (unsignedShort <= 0) {
                            throw new IOException("Invalid exif");
                        }
                        this.f309f = i8;
                        byte[] bArr3 = new byte[unsignedShort];
                        if (c0013a.read(bArr3) != unsignedShort) {
                            throw new IOException("Invalid exif");
                        }
                        i8 += unsignedShort;
                        C0013a c0013a2 = new C0013a(bArr3);
                        n(c0013a2, unsignedShort);
                        p(c0013a2, i4);
                        unsignedShort = 0;
                    }
                }
                if (unsignedShort < 0) {
                    throw new IOException("Invalid length");
                }
                if (c0013a.skipBytes(unsignedShort) != unsignedShort) {
                    throw new IOException("Invalid JPEG segment");
                }
                i6 = i8 + unsignedShort;
            }
        }
    }

    private int g(BufferedInputStream bufferedInputStream) throws IOException {
        boolean z4;
        boolean z5;
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f295o;
            if (i2 >= bArr2.length) {
                z4 = true;
                break;
            }
            if (bArr[i2] != bArr2[i2]) {
                z4 = false;
                break;
            }
            i2++;
        }
        if (z4) {
            return 4;
        }
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i4 = 0;
        while (true) {
            if (i4 >= bytes.length) {
                z5 = true;
                break;
            }
            if (bArr[i4] != bytes[i4]) {
                z5 = false;
                break;
            }
            i4++;
        }
        if (z5) {
            return 9;
        }
        C0013a c0013a = new C0013a(bArr);
        ByteOrder byteOrderO = o(c0013a);
        this.f308e = byteOrderO;
        c0013a.I(byteOrderO);
        short s2 = c0013a.readShort();
        c0013a.close();
        if (s2 == 20306 || s2 == 21330) {
            return 7;
        }
        C0013a c0013a2 = new C0013a(bArr);
        ByteOrder byteOrderO2 = o(c0013a2);
        this.f308e = byteOrderO2;
        c0013a2.I(byteOrderO2);
        short s4 = c0013a2.readShort();
        c0013a2.close();
        return s4 == 85 ? 10 : 0;
    }

    private void h(C0013a c0013a) throws Throwable {
        j(c0013a);
        b bVar = this.f307c[1].get("MakerNote");
        if (bVar != null) {
            C0013a c0013a2 = new C0013a(bVar.f321c);
            c0013a2.I(this.f308e);
            byte[] bArr = p;
            byte[] bArr2 = new byte[bArr.length];
            c0013a2.readFully(bArr2);
            c0013a2.H(0L);
            byte[] bArr3 = f296q;
            byte[] bArr4 = new byte[bArr3.length];
            c0013a2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                c0013a2.H(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                c0013a2.H(12L);
            }
            p(c0013a2, 6);
            b bVar2 = this.f307c[7].get("PreviewImageStart");
            b bVar3 = this.f307c[7].get("PreviewImageLength");
            if (bVar2 != null && bVar3 != null) {
                this.f307c[5].put("JPEGInterchangeFormat", bVar2);
                this.f307c[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = this.f307c[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.h(this.f308e);
                if (iArr == null || iArr.length != 4) {
                    StringBuilder sbD = e.d("Invalid aspect frame values. frame=");
                    sbD.append(Arrays.toString(iArr));
                    Log.w("ExifInterface", sbD.toString());
                } else {
                    if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                        return;
                    }
                    int i2 = (iArr[2] - iArr[0]) + 1;
                    int i4 = (iArr[3] - iArr[1]) + 1;
                    if (i2 < i4) {
                        int i5 = i2 + i4;
                        i4 = i5 - i4;
                        i2 = i5 - i4;
                    }
                    b bVarD = b.d(i2, this.f308e);
                    b bVarD2 = b.d(i4, this.f308e);
                    this.f307c[0].put("ImageWidth", bVarD);
                    this.f307c[0].put("ImageLength", bVarD2);
                }
            }
        }
    }

    private void i(C0013a c0013a) throws IOException {
        c0013a.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        c0013a.read(bArr);
        c0013a.skipBytes(4);
        c0013a.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i4 = ByteBuffer.wrap(bArr2).getInt();
        f(c0013a, i2, 5);
        c0013a.H(i4);
        c0013a.I(ByteOrder.BIG_ENDIAN);
        int i5 = c0013a.readInt();
        for (int i6 = 0; i6 < i5; i6++) {
            int unsignedShort = c0013a.readUnsignedShort();
            int unsignedShort2 = c0013a.readUnsignedShort();
            if (unsignedShort == u.f322a) {
                short s2 = c0013a.readShort();
                short s4 = c0013a.readShort();
                b bVarD = b.d(s2, this.f308e);
                b bVarD2 = b.d(s4, this.f308e);
                this.f307c[0].put("ImageLength", bVarD);
                this.f307c[0].put("ImageWidth", bVarD2);
                return;
            }
            c0013a.skipBytes(unsignedShort2);
        }
    }

    private void j(C0013a c0013a) throws Throwable {
        b bVar;
        n(c0013a, c0013a.available());
        p(c0013a, 0);
        s(c0013a, 0);
        s(c0013a, 5);
        s(c0013a, 4);
        r(0, 5);
        r(0, 4);
        r(5, 4);
        b bVar2 = this.f307c[1].get("PixelXDimension");
        b bVar3 = this.f307c[1].get("PixelYDimension");
        if (bVar2 != null && bVar3 != null) {
            this.f307c[0].put("ImageWidth", bVar2);
            this.f307c[0].put("ImageLength", bVar3);
        }
        if (this.f307c[4].isEmpty() && m(this.f307c[5])) {
            HashMap<String, b>[] mapArr = this.f307c;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        if (!m(this.f307c[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        if (this.f306b != 8 || (bVar = this.f307c[1].get("MakerNote")) == null) {
            return;
        }
        C0013a c0013a2 = new C0013a(bVar.f321c);
        c0013a2.I(this.f308e);
        c0013a2.H(6L);
        p(c0013a2, 9);
        b bVar4 = this.f307c[9].get("ColorSpace");
        if (bVar4 != null) {
            this.f307c[1].put("ColorSpace", bVar4);
        }
    }

    private void k(C0013a c0013a) throws Throwable {
        j(c0013a);
        if (this.f307c[0].get("JpgFromRaw") != null) {
            f(c0013a, this.f312j, 5);
        }
        b bVar = this.f307c[0].get("ISO");
        b bVar2 = this.f307c[1].get("PhotographicSensitivity");
        if (bVar == null || bVar2 != null) {
            return;
        }
        this.f307c[1].put("PhotographicSensitivity", bVar);
    }

    private void l(C0013a c0013a, HashMap map) throws Throwable {
        int i2;
        b bVar = (b) map.get("JPEGInterchangeFormat");
        b bVar2 = (b) map.get("JPEGInterchangeFormatLength");
        if (bVar == null || bVar2 == null) {
            return;
        }
        int iF = bVar.f(this.f308e);
        int iMin = Math.min(bVar2.f(this.f308e), c0013a.available() - iF);
        int i4 = this.f306b;
        if (i4 != 4 && i4 != 9 && i4 != 10) {
            if (i4 == 7) {
                i2 = this.g;
            }
            if (iF > 0 || iMin <= 0 || this.f305a != null) {
                return;
            }
            c0013a.H(iF);
            c0013a.readFully(new byte[iMin]);
            return;
        }
        i2 = this.f309f;
        iF += i2;
        if (iF > 0) {
        }
    }

    private boolean m(HashMap map) throws IOException {
        b bVar = (b) map.get("ImageLength");
        b bVar2 = (b) map.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.f(this.f308e) <= 512 && bVar2.f(this.f308e) <= 512;
    }

    private void n(C0013a c0013a, int i2) throws IOException {
        ByteOrder byteOrderO = o(c0013a);
        this.f308e = byteOrderO;
        c0013a.I(byteOrderO);
        int unsignedShort = c0013a.readUnsignedShort();
        int i4 = this.f306b;
        if (i4 != 7 && i4 != 10 && unsignedShort != 42) {
            StringBuilder sbD = e.d("Invalid start code: ");
            sbD.append(Integer.toHexString(unsignedShort));
            throw new IOException(sbD.toString());
        }
        int i5 = c0013a.readInt();
        if (i5 < 8 || i5 >= i2) {
            throw new IOException(e.b("Invalid first Ifd offset: ", i5));
        }
        int i6 = i5 - 8;
        if (i6 > 0 && c0013a.skipBytes(i6) != i6) {
            throw new IOException(e.b("Couldn't jump to first Ifd: ", i6));
        }
    }

    private ByteOrder o(C0013a c0013a) throws IOException {
        short s2 = c0013a.readShort();
        if (s2 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        StringBuilder sbD = e.d("Invalid byte order: ");
        sbD.append(Integer.toHexString(s2));
        throw new IOException(sbD.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0119  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.HashSet, java.util.Set<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.HashSet, java.util.Set<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.HashSet, java.util.Set<java.lang.Integer>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p(C0013a c0013a, int i2) throws IOException {
        short s2;
        short s4;
        long j2;
        boolean z4;
        int i4;
        int i5;
        int i6;
        short s5;
        int unsignedShort;
        long j4;
        this.d.add(Integer.valueOf(c0013a.f318l));
        if (c0013a.f318l + 2 > c0013a.f317k) {
            return;
        }
        short s6 = c0013a.readShort();
        if ((s6 * 12) + c0013a.f318l > c0013a.f317k || s6 <= 0) {
            return;
        }
        short s7 = 0;
        while (s7 < s6) {
            int unsignedShort2 = c0013a.readUnsignedShort();
            int unsignedShort3 = c0013a.readUnsignedShort();
            int i7 = c0013a.readInt();
            long j5 = c0013a.f318l + 4;
            c cVar = f302x[i2].get(Integer.valueOf(unsignedShort2));
            if (cVar == null) {
                Log.w("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
            } else {
                if (unsignedShort3 > 0) {
                    int[] iArr = f298s;
                    if (unsignedShort3 < iArr.length) {
                        int i8 = cVar.f324c;
                        if (i8 == 7 || unsignedShort3 == 7 || i8 == unsignedShort3 || (i4 = cVar.d) == unsignedShort3 || ((i8 == 4 || i4 == 4) && unsignedShort3 == 3) || (((i8 == 9 || i4 == 9) && unsignedShort3 == 8) || ((i8 == 12 || i4 == 12) && unsignedShort3 == 11))) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = i8;
                            }
                            int i9 = iArr[unsignedShort3];
                            s2 = s6;
                            s4 = s7;
                            j2 = i9 * i7;
                            if (j2 < 0 || j2 > 2147483647L) {
                                Log.w("ExifInterface", "Skip the tag entry since the number of components is invalid: " + i7);
                                z4 = false;
                                if (z4) {
                                    c0013a.H(j5);
                                    s5 = s2;
                                } else {
                                    if (j2 > 4) {
                                        int i10 = c0013a.readInt();
                                        int i11 = this.f306b;
                                        s5 = s2;
                                        if (i11 == 7) {
                                            if ("MakerNote".equals(cVar.f323b)) {
                                                this.g = i10;
                                            } else if (i2 == 6 && "ThumbnailImage".equals(cVar.f323b)) {
                                                this.f310h = i10;
                                                this.f311i = i7;
                                                b bVarD = b.d(6, this.f308e);
                                                i5 = unsignedShort3;
                                                i6 = i7;
                                                b bVarB = b.b(this.f310h, this.f308e);
                                                j4 = j5;
                                                b bVarB2 = b.b(this.f311i, this.f308e);
                                                this.f307c[4].put("Compression", bVarD);
                                                this.f307c[4].put("JPEGInterchangeFormat", bVarB);
                                                this.f307c[4].put("JPEGInterchangeFormatLength", bVarB2);
                                            }
                                            i5 = unsignedShort3;
                                            i6 = i7;
                                            j4 = j5;
                                        } else {
                                            i5 = unsignedShort3;
                                            i6 = i7;
                                            j4 = j5;
                                            if (i11 == 10 && "JpgFromRaw".equals(cVar.f323b)) {
                                                this.f312j = i10;
                                            }
                                        }
                                        long j6 = i10;
                                        if (j6 + j2 <= c0013a.f317k) {
                                            c0013a.H(j6);
                                            j5 = j4;
                                        } else {
                                            Log.w("ExifInterface", "Skip the tag entry since data offset is invalid: " + i10);
                                            c0013a.H(j4);
                                        }
                                    } else {
                                        i5 = unsignedShort3;
                                        i6 = i7;
                                        s5 = s2;
                                    }
                                    Integer num = f288A.get(Integer.valueOf(unsignedShort2));
                                    if (num != null) {
                                        long jF = -1;
                                        int i12 = i5;
                                        if (i12 != 3) {
                                            if (i12 == 4) {
                                                jF = c0013a.f();
                                            } else if (i12 == 8) {
                                                unsignedShort = c0013a.readShort();
                                            } else if (i12 == 9 || i12 == 13) {
                                                unsignedShort = c0013a.readInt();
                                            }
                                            if (jF > 0 || jF >= c0013a.f317k) {
                                                Log.w("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jF);
                                            } else if (this.d.contains(Integer.valueOf((int) jF))) {
                                                Log.w("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jF + ")");
                                            } else {
                                                c0013a.H(jF);
                                                p(c0013a, num.intValue());
                                            }
                                            c0013a.H(j5);
                                        } else {
                                            unsignedShort = c0013a.readUnsignedShort();
                                        }
                                        jF = unsignedShort;
                                        if (jF > 0) {
                                            Log.w("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jF);
                                            c0013a.H(j5);
                                        }
                                    } else {
                                        byte[] bArr = new byte[(int) j2];
                                        c0013a.readFully(bArr);
                                        b bVar = new b(i5, i6, bArr);
                                        this.f307c[i2].put(cVar.f323b, bVar);
                                        if ("DNGVersion".equals(cVar.f323b)) {
                                            this.f306b = 3;
                                        }
                                        if ((("Make".equals(cVar.f323b) || "Model".equals(cVar.f323b)) && bVar.g(this.f308e).contains("PENTAX")) || ("Compression".equals(cVar.f323b) && bVar.f(this.f308e) == 65535)) {
                                            this.f306b = 8;
                                        }
                                        if (c0013a.f318l != j5) {
                                            c0013a.H(j5);
                                        }
                                    }
                                }
                                s7 = (short) (s4 + 1);
                                s6 = s5;
                            } else {
                                z4 = true;
                                if (z4) {
                                }
                                s7 = (short) (s4 + 1);
                                s6 = s5;
                            }
                        } else {
                            StringBuilder sbD = e.d("Skip the tag entry since data format (");
                            sbD.append(f297r[unsignedShort3]);
                            sbD.append(") is unexpected for tag: ");
                            sbD.append(cVar.f323b);
                            Log.w("ExifInterface", sbD.toString());
                        }
                    }
                }
                s2 = s6;
                s4 = s7;
                Log.w("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                j2 = 0;
                z4 = false;
                if (z4) {
                }
                s7 = (short) (s4 + 1);
                s6 = s5;
            }
            s2 = s6;
            s4 = s7;
            j2 = 0;
            z4 = false;
            if (z4) {
            }
            s7 = (short) (s4 + 1);
            s6 = s5;
        }
        if (c0013a.f318l + 4 <= c0013a.f317k) {
            int i13 = c0013a.readInt();
            long j7 = i13;
            if (j7 <= 0 || i13 >= c0013a.f317k) {
                Log.w("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i13);
                return;
            }
            if (this.d.contains(Integer.valueOf(i13))) {
                Log.w("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i13);
                return;
            }
            c0013a.H(j7);
            if (this.f307c[4].isEmpty()) {
                p(c0013a, 4);
            } else if (this.f307c[5].isEmpty()) {
                p(c0013a, 5);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void q(C0013a c0013a) throws Throwable {
        b bVar;
        int iF;
        HashMap<String, b> map = this.f307c[4];
        b bVar2 = map.get("Compression");
        if (bVar2 == null) {
            l(c0013a, map);
            return;
        }
        int iF2 = bVar2.f(this.f308e);
        boolean z4 = true;
        if (iF2 != 1) {
            if (iF2 == 6) {
                l(c0013a, map);
                return;
            } else if (iF2 != 7) {
                return;
            }
        }
        b bVar3 = map.get("BitsPerSample");
        if (bVar3 != null) {
            int[] iArr = (int[]) bVar3.h(this.f308e);
            int[] iArr2 = f293m;
            if (!Arrays.equals(iArr2, iArr) && (this.f306b != 3 || (bVar = map.get("PhotometricInterpretation")) == null || (((iF = bVar.f(this.f308e)) != 1 || !Arrays.equals(iArr, f294n)) && (iF != 6 || !Arrays.equals(iArr, iArr2))))) {
                z4 = false;
            }
        }
        if (z4) {
            b bVar4 = map.get("StripOffsets");
            b bVar5 = map.get("StripByteCounts");
            if (bVar4 == null || bVar5 == null) {
                return;
            }
            long[] jArrB = b(bVar4.h(this.f308e));
            long[] jArrB2 = b(bVar5.h(this.f308e));
            if (jArrB == null) {
                Log.w("ExifInterface", "stripOffsets should not be null.");
                return;
            }
            if (jArrB2 == null) {
                Log.w("ExifInterface", "stripByteCounts should not be null.");
                return;
            }
            long j2 = 0;
            for (long j4 : jArrB2) {
                j2 += j4;
            }
            byte[] bArr = new byte[(int) j2];
            int i2 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < jArrB.length; i5++) {
                int i6 = (int) jArrB[i5];
                int i7 = (int) jArrB2[i5];
                int i8 = i6 - i2;
                if (i8 < 0) {
                    Log.d("ExifInterface", "Invalid strip offset value");
                }
                c0013a.H(i8);
                int i9 = i2 + i8;
                byte[] bArr2 = new byte[i7];
                c0013a.read(bArr2);
                i2 = i9 + i7;
                System.arraycopy(bArr2, 0, bArr, i4, i7);
                i4 += i7;
            }
        }
    }

    private void r(int i2, int i4) throws Throwable {
        if (this.f307c[i2].isEmpty() || this.f307c[i4].isEmpty()) {
            return;
        }
        b bVar = this.f307c[i2].get("ImageLength");
        b bVar2 = this.f307c[i2].get("ImageWidth");
        b bVar3 = this.f307c[i4].get("ImageLength");
        b bVar4 = this.f307c[i4].get("ImageWidth");
        if (bVar == null || bVar2 == null || bVar3 == null || bVar4 == null) {
            return;
        }
        int iF = bVar.f(this.f308e);
        int iF2 = bVar2.f(this.f308e);
        int iF3 = bVar3.f(this.f308e);
        int iF4 = bVar4.f(this.f308e);
        if (iF >= iF3 || iF2 >= iF4) {
            return;
        }
        HashMap<String, b>[] mapArr = this.f307c;
        HashMap<String, b> map = mapArr[i2];
        mapArr[i2] = mapArr[i4];
        mapArr[i4] = map;
    }

    private void s(C0013a c0013a, int i2) throws Throwable {
        b bVar;
        b bVarD;
        b bVarD2;
        b bVar2 = this.f307c[i2].get("DefaultCropSize");
        b bVar3 = this.f307c[i2].get("SensorTopBorder");
        b bVar4 = this.f307c[i2].get("SensorLeftBorder");
        b bVar5 = this.f307c[i2].get("SensorBottomBorder");
        b bVar6 = this.f307c[i2].get("SensorRightBorder");
        if (bVar2 != null) {
            if (bVar2.f319a == 5) {
                d[] dVarArr = (d[]) bVar2.h(this.f308e);
                if (dVarArr == null || dVarArr.length != 2) {
                    StringBuilder sbD = e.d("Invalid crop size values. cropSize=");
                    sbD.append(Arrays.toString(dVarArr));
                    Log.w("ExifInterface", sbD.toString());
                    return;
                }
                bVarD = b.c(dVarArr[0], this.f308e);
                bVarD2 = b.c(dVarArr[1], this.f308e);
            } else {
                int[] iArr = (int[]) bVar2.h(this.f308e);
                if (iArr == null || iArr.length != 2) {
                    StringBuilder sbD2 = e.d("Invalid crop size values. cropSize=");
                    sbD2.append(Arrays.toString(iArr));
                    Log.w("ExifInterface", sbD2.toString());
                    return;
                }
                bVarD = b.d(iArr[0], this.f308e);
                bVarD2 = b.d(iArr[1], this.f308e);
            }
            this.f307c[i2].put("ImageWidth", bVarD);
            this.f307c[i2].put("ImageLength", bVarD2);
            return;
        }
        if (bVar3 == null || bVar4 == null || bVar5 == null || bVar6 == null) {
            b bVar7 = this.f307c[i2].get("ImageLength");
            b bVar8 = this.f307c[i2].get("ImageWidth");
            if ((bVar7 == null || bVar8 == null) && (bVar = this.f307c[i2].get("JPEGInterchangeFormat")) != null) {
                f(c0013a, bVar.f(this.f308e), i2);
                return;
            }
            return;
        }
        int iF = bVar3.f(this.f308e);
        int iF2 = bVar5.f(this.f308e);
        int iF3 = bVar6.f(this.f308e);
        int iF4 = bVar4.f(this.f308e);
        if (iF2 <= iF || iF3 <= iF4) {
            return;
        }
        b bVarD3 = b.d(iF2 - iF, this.f308e);
        b bVarD4 = b.d(iF3 - iF4, this.f308e);
        this.f307c[i2].put("ImageLength", bVarD3);
        this.f307c[i2].put("ImageWidth", bVarD4);
    }

    public final String c(String str) {
        b bVarE = e(str);
        if (bVarE != null) {
            if (!f304z.contains(str)) {
                return bVarE.g(this.f308e);
            }
            if (str.equals("GPSTimeStamp")) {
                int i2 = bVarE.f319a;
                if (i2 != 5 && i2 != 10) {
                    StringBuilder sbD = e.d("GPS Timestamp format is not rational. format=");
                    sbD.append(bVarE.f319a);
                    Log.w("ExifInterface", sbD.toString());
                    return null;
                }
                d[] dVarArr = (d[]) bVarE.h(this.f308e);
                if (dVarArr != null && dVarArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (dVarArr[0].f325a / dVarArr[0].f326b)), Integer.valueOf((int) (dVarArr[1].f325a / dVarArr[1].f326b)), Integer.valueOf((int) (dVarArr[2].f325a / dVarArr[2].f326b)));
                }
                StringBuilder sbD2 = e.d("Invalid GPS Timestamp array. array=");
                sbD2.append(Arrays.toString(dVarArr));
                Log.w("ExifInterface", sbD2.toString());
                return null;
            }
            try {
                return Double.toString(bVarE.e(this.f308e));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final int d() {
        b bVarE = e("Orientation");
        if (bVarE == null) {
            return 1;
        }
        try {
            return bVarE.f(this.f308e);
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    /* renamed from: K.a$a, reason: collision with other inner class name */
    private static class C0013a extends InputStream implements DataInput {

        /* renamed from: m, reason: collision with root package name */
        private static final ByteOrder f313m = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: n, reason: collision with root package name */
        private static final ByteOrder f314n = ByteOrder.BIG_ENDIAN;

        /* renamed from: i, reason: collision with root package name */
        private DataInputStream f315i;

        /* renamed from: j, reason: collision with root package name */
        private ByteOrder f316j;

        /* renamed from: k, reason: collision with root package name */
        final int f317k;

        /* renamed from: l, reason: collision with root package name */
        int f318l;

        public C0013a(InputStream inputStream) throws IOException {
            this.f316j = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f315i = dataInputStream;
            int iAvailable = dataInputStream.available();
            this.f317k = iAvailable;
            this.f318l = 0;
            this.f315i.mark(iAvailable);
        }

        public final void H(long j2) throws IOException {
            int i2 = this.f318l;
            if (i2 > j2) {
                this.f318l = 0;
                this.f315i.reset();
                this.f315i.mark(this.f317k);
            } else {
                j2 -= i2;
            }
            int i4 = (int) j2;
            if (skipBytes(i4) != i4) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public final void I(ByteOrder byteOrder) {
            this.f316j = byteOrder;
        }

        @Override // java.io.InputStream
        public final int available() throws IOException {
            return this.f315i.available();
        }

        public final long f() throws IOException {
            return readInt() & 4294967295L;
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            this.f318l++;
            return this.f315i.read();
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() throws IOException {
            this.f318l++;
            return this.f315i.readBoolean();
        }

        @Override // java.io.DataInput
        public final byte readByte() throws IOException {
            int i2 = this.f318l + 1;
            this.f318l = i2;
            if (i2 > this.f317k) {
                throw new EOFException();
            }
            int i4 = this.f315i.read();
            if (i4 >= 0) {
                return (byte) i4;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final char readChar() throws IOException {
            this.f318l += 2;
            return this.f315i.readChar();
        }

        @Override // java.io.DataInput
        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i2, int i4) throws IOException {
            int i5 = this.f318l + i4;
            this.f318l = i5;
            if (i5 > this.f317k) {
                throw new EOFException();
            }
            if (this.f315i.read(bArr, i2, i4) != i4) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public final int readInt() throws IOException {
            int i2 = this.f318l + 4;
            this.f318l = i2;
            if (i2 > this.f317k) {
                throw new EOFException();
            }
            int i4 = this.f315i.read();
            int i5 = this.f315i.read();
            int i6 = this.f315i.read();
            int i7 = this.f315i.read();
            if ((i4 | i5 | i6 | i7) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f316j;
            if (byteOrder == f313m) {
                return (i7 << 24) + (i6 << 16) + (i5 << 8) + i4;
            }
            if (byteOrder == f314n) {
                return (i4 << 24) + (i5 << 16) + (i6 << 8) + i7;
            }
            StringBuilder sbD = e.d("Invalid byte order: ");
            sbD.append(this.f316j);
            throw new IOException(sbD.toString());
        }

        @Override // java.io.DataInput
        public final String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public final long readLong() throws IOException {
            int i2 = this.f318l + 8;
            this.f318l = i2;
            if (i2 > this.f317k) {
                throw new EOFException();
            }
            int i4 = this.f315i.read();
            int i5 = this.f315i.read();
            int i6 = this.f315i.read();
            int i7 = this.f315i.read();
            int i8 = this.f315i.read();
            int i9 = this.f315i.read();
            int i10 = this.f315i.read();
            int i11 = this.f315i.read();
            if ((i4 | i5 | i6 | i7 | i8 | i9 | i10 | i11) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f316j;
            if (byteOrder == f313m) {
                return (i11 << 56) + (i10 << 48) + (i9 << 40) + (i8 << 32) + (i7 << 24) + (i6 << 16) + (i5 << 8) + i4;
            }
            if (byteOrder == f314n) {
                return (i4 << 56) + (i5 << 48) + (i6 << 40) + (i7 << 32) + (i8 << 24) + (i9 << 16) + (i10 << 8) + i11;
            }
            StringBuilder sbD = e.d("Invalid byte order: ");
            sbD.append(this.f316j);
            throw new IOException(sbD.toString());
        }

        @Override // java.io.DataInput
        public final short readShort() throws IOException {
            int i2;
            int i4 = this.f318l + 2;
            this.f318l = i4;
            if (i4 > this.f317k) {
                throw new EOFException();
            }
            int i5 = this.f315i.read();
            int i6 = this.f315i.read();
            if ((i5 | i6) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f316j;
            if (byteOrder == f313m) {
                i2 = (i6 << 8) + i5;
            } else {
                if (byteOrder != f314n) {
                    StringBuilder sbD = e.d("Invalid byte order: ");
                    sbD.append(this.f316j);
                    throw new IOException(sbD.toString());
                }
                i2 = (i5 << 8) + i6;
            }
            return (short) i2;
        }

        @Override // java.io.DataInput
        public final String readUTF() throws IOException {
            this.f318l += 2;
            return this.f315i.readUTF();
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() throws IOException {
            this.f318l++;
            return this.f315i.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() throws IOException {
            int i2 = this.f318l + 2;
            this.f318l = i2;
            if (i2 > this.f317k) {
                throw new EOFException();
            }
            int i4 = this.f315i.read();
            int i5 = this.f315i.read();
            if ((i4 | i5) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f316j;
            if (byteOrder == f313m) {
                return (i5 << 8) + i4;
            }
            if (byteOrder == f314n) {
                return (i4 << 8) + i5;
            }
            StringBuilder sbD = e.d("Invalid byte order: ");
            sbD.append(this.f316j);
            throw new IOException(sbD.toString());
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i2) throws IOException {
            int iMin = Math.min(i2, this.f317k - this.f318l);
            int iSkipBytes = 0;
            while (iSkipBytes < iMin) {
                iSkipBytes += this.f315i.skipBytes(iMin - iSkipBytes);
            }
            this.f318l += iSkipBytes;
            return iSkipBytes;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i4) throws IOException {
            int i5 = this.f315i.read(bArr, i2, i4);
            this.f318l += i5;
            return i5;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr) throws IOException {
            int length = this.f318l + bArr.length;
            this.f318l = length;
            if (length <= this.f317k) {
                if (this.f315i.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public C0013a(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f322a;

        /* renamed from: b, reason: collision with root package name */
        public final String f323b;

        /* renamed from: c, reason: collision with root package name */
        public final int f324c;
        public final int d;

        c(String str, int i2, int i4) {
            this.f323b = str;
            this.f322a = i2;
            this.f324c = i4;
            this.d = -1;
        }

        c(String str, int i2) {
            this.f323b = str;
            this.f322a = i2;
            this.f324c = 3;
            this.d = 4;
        }
    }
}
