package C3;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.android.mmt.R;
import w3.C0409b;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final C0409b.d<C3.a> f74a = C0409b.b(new a());

    final class a extends C0409b.c<C3.a> {
        a() {
        }

        @Override // w3.C0409b.c
        public final C3.a a() {
            return new C3.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(Context context, long j2, int i2) {
        StringBuilder sb = (StringBuilder) ((C0409b.f) C0409b.c()).a();
        b(context, sb, j2, i2);
        String string = sb.toString();
        ((C0409b.f) C0409b.c()).d(sb);
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:198:0x026c  */
    /* JADX WARN: Type inference failed for: r0v3, types: [w3.b$d<C3.a>, w3.b$f] */
    /* JADX WARN: Type inference failed for: r6v1, types: [w3.b$d<C3.a>, w3.b$f] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static StringBuilder b(Context context, StringBuilder sb, long j2, int i2) {
        int i4;
        int i5;
        int i6;
        int i7 = 16;
        if ((i2 & 16) == 0 && (i2 & 32) == 0) {
            i4 = i2 | (DateFormat.is24HourFormat(context) ? 32 : 16);
        } else {
            i4 = i2;
        }
        String string = context.getString((i4 & 1024) == 1024 ? (i4 & 896) != 0 ? (i4 & 15) != 0 ? (i4 & 2048) == 2048 ? R.string.fmt_weekday_date_time_timezone : R.string.fmt_weekday_date_time : (i4 & 2048) == 2048 ? R.string.fmt_weekday_date_timezone : R.string.fmt_weekday_date : (i4 & 15) != 0 ? (i4 & 2048) == 2048 ? R.string.fmt_weekday_time_timezone : R.string.fmt_weekday_time : (i4 & 2048) == 2048 ? R.string.fmt_weekday_timezone : R.string.fmt_weekday : (i4 & 896) != 0 ? (i4 & 15) != 0 ? (i4 & 2048) == 2048 ? R.string.fmt_date_time_timezone : R.string.fmt_date_time : (i4 & 2048) == 2048 ? R.string.fmt_date_timezone : R.string.fmt_date : (i4 & 15) != 0 ? (i4 & 2048) == 2048 ? R.string.fmt_time_timezone : R.string.fmt_time : (i4 & 2048) == 2048 ? R.string.fmt_timezone : R.string.empty);
        StringBuilder sb2 = (StringBuilder) ((C0409b.f) C0409b.c()).a();
        C3.a aVar = (C3.a) f74a.a();
        aVar.B();
        aVar.A(j2);
        int i8 = 0;
        int length = string.length();
        while (i8 < length) {
            char cCharAt = string.charAt(i8);
            if (cCharAt == 'D') {
                int i9 = i4 & 32768;
                int i10 = R.string.fmt_date_day;
                if (i9 == 32768) {
                    if ((i4 & 512) == 512) {
                        i10 = (i4 & 256) == 256 ? (i4 & 128) == 128 ? R.string.fmt_date_numeric_year_month_day : R.string.fmt_date_numeric_year_month : R.string.fmt_date_numeric_year;
                    } else if ((i4 & 256) == 256) {
                        i10 = (i4 & 128) == 128 ? R.string.fmt_date_numeric_month_day : R.string.fmt_date_numeric_month;
                    } else {
                        if ((i4 & 128) != 128) {
                            throw new IllegalArgumentException("no any time date");
                        }
                        i10 = R.string.fmt_date_numeric_day;
                    }
                } else if ((i4 & 4096) == 4096) {
                    if ((i4 & 512) == 512) {
                        i10 = (i4 & 256) == 256 ? (i4 & 128) == 128 ? R.string.fmt_date_short_year_month_day : R.string.fmt_date_short_year_month : R.string.fmt_date_year;
                    } else if ((i4 & 256) == 256) {
                        i10 = (i4 & 128) == 128 ? R.string.fmt_date_short_month_day : R.string.fmt_date_short_month;
                    } else if ((i4 & 128) != 128) {
                        throw new IllegalArgumentException("no any time date");
                    }
                } else if ((i4 & 512) == 512) {
                    if ((i4 & 256) == 256) {
                        i10 = (i4 & 128) == 128 ? R.string.fmt_date_long_year_month_day : R.string.fmt_date_long_year_month;
                    }
                } else if ((i4 & 256) == 256) {
                    i10 = (i4 & 128) == 128 ? R.string.fmt_date_long_month_day : R.string.fmt_date_long_month;
                } else if ((i4 & 128) != 128) {
                    throw new IllegalArgumentException("no any time date");
                }
                sb2.append(context.getString(i10));
            } else if (cCharAt == 'T') {
                if ((i4 & 16384) != 16384 || (((i4 & 1) == 1 && aVar.o(22) != 0) || (i4 & 14) == 0)) {
                    i5 = i4;
                } else {
                    i5 = i4 & (-2);
                    if (((i5 & 2) != 2 || aVar.o(21) == 0) && (i5 & 12) != 0) {
                        i5 &= -3;
                        if (aVar.o(20) == 0 && (i5 & 8) != 0) {
                            i5 &= -5;
                        }
                    }
                }
                if ((i5 & 8) == 8) {
                    i6 = (i5 & 16) == i7 ? (i5 & 64) == 64 ? (i5 & 4) == 4 ? (i5 & 2) == 2 ? (i5 & 1) == 1 ? R.string.fmt_time_12hour_minute_second_millis : R.string.fmt_time_12hour_minute_second : R.string.fmt_time_12hour_minute : R.string.fmt_time_12hour : (i5 & 4) == 4 ? (i5 & 2) == 2 ? (i5 & 1) == 1 ? R.string.fmt_time_12hour_minute_second_millis_pm : R.string.fmt_time_12hour_minute_second_pm : R.string.fmt_time_12hour_minute_pm : R.string.fmt_time_12hour_pm : (i5 & 4) == 4 ? (i5 & 2) == 2 ? (i5 & 1) == 1 ? R.string.fmt_time_24hour_minute_second_millis : R.string.fmt_time_24hour_minute_second : R.string.fmt_time_24hour_minute : R.string.fmt_time_24hour;
                } else if ((i5 & 4) == 4) {
                    i6 = (i5 & 2) == 2 ? (i5 & 1) == 1 ? R.string.fmt_time_minute_second_millis : R.string.fmt_time_minute_second : R.string.fmt_time_minute;
                } else {
                    int i11 = i5 & 2;
                    int i12 = i5 & 1;
                    if (i11 == 2) {
                        i6 = i12 == 1 ? R.string.fmt_time_second_millis : R.string.fmt_time_second;
                    } else {
                        if (i12 != 1) {
                            throw new IllegalArgumentException("no any time date");
                        }
                        i6 = R.string.fmt_time_millis;
                    }
                }
                sb2.append(context.getString(i6));
            } else if (cCharAt != 'W') {
                sb2.append(cCharAt);
            } else {
                sb2.append(context.getString((i4 & 8192) == 8192 ? R.string.fmt_weekday_short : R.string.fmt_weekday_long));
            }
            i8++;
            i7 = 16;
        }
        aVar.n(context, sb, sb2);
        ((C0409b.f) C0409b.c()).d(sb2);
        f74a.d(aVar);
        return sb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String c(Context context, long j2) {
        StringBuilder sb = (StringBuilder) ((C0409b.f) C0409b.c()).a();
        d(context, sb, j2);
        String string = sb.toString();
        ((C0409b.f) C0409b.c()).d(sb);
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
    /* JADX WARN: Type inference failed for: r9v3, types: [w3.b$d<C3.a>, w3.b$f] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static StringBuilder d(Context context, StringBuilder sb, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z4 = jCurrentTimeMillis >= j2;
        long jAbs = Math.abs(jCurrentTimeMillis - j2) / 60000;
        Resources resources = context.getResources();
        if (jAbs <= 60) {
            sb.append(String.format(resources.getQuantityString(z4 ? jAbs == 60 ? R.plurals.abbrev_a_hour_ago : jAbs == 30 ? R.plurals.abbrev_half_hour_ago : jAbs == 0 ? R.plurals.abbrev_less_than_one_minute_ago : R.plurals.abbrev_num_minutes_ago : jAbs == 60 ? R.plurals.abbrev_in_a_hour : jAbs == 30 ? R.plurals.abbrev_in_half_hour : jAbs == 0 ? R.plurals.abbrev_in_less_than_one_minute : R.plurals.abbrev_in_num_minutes, (int) jAbs), Long.valueOf(jAbs)));
        } else {
            ?? r9 = f74a;
            C3.a aVar = (C3.a) r9.a();
            aVar.B();
            aVar.A(jCurrentTimeMillis);
            int iO = aVar.o(1);
            int iO2 = aVar.o(12);
            int iO3 = aVar.o(14);
            aVar.A(j2);
            boolean z5 = iO == aVar.o(1);
            if (z5 && iO2 == aVar.o(12)) {
                b(context, sb, j2, 12300);
            } else if (z5 && Math.abs(iO2 - aVar.o(12)) < 2) {
                sb.append(resources.getString(z4 ? R.string.yesterday : R.string.tomorrow));
                sb.append(' ');
                b(context, sb, j2, 12300);
            } else if (z5 && Math.abs(iO2 - aVar.o(12)) < 7) {
                if (z4 == (iO3 > aVar.o(14))) {
                    b(context, sb, j2, 13324);
                }
            } else if (z5) {
                b(context, sb, j2, 12672);
            } else {
                b(context, sb, j2, 13184);
            }
            r9.d(aVar);
        }
        return sb;
    }
}
