package g0;

import android.util.SparseArray;
import f0.C0302a;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: g0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0316l {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<Object> f6273a;

    public C0316l() {
        this.f6273a = null;
        this.f6273a = new SparseArray<>();
    }

    protected final void a(C0309e c0309e, int i2) {
        if (i2 != 129 && i2 != 130 && i2 != 151) {
            throw new RuntimeException("Invalid header field!");
        }
        ArrayList arrayList = (ArrayList) this.f6273a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(c0309e);
        this.f6273a.put(i2, arrayList);
    }

    protected final C0309e b(int i2) {
        return (C0309e) this.f6273a.get(i2);
    }

    protected final C0309e[] c(int i2) {
        ArrayList arrayList = (ArrayList) this.f6273a.get(i2);
        if (arrayList == null) {
            return null;
        }
        return (C0309e[]) arrayList.toArray(new C0309e[arrayList.size()]);
    }

    protected final long d(int i2) {
        Long l2 = (Long) this.f6273a.get(i2);
        if (l2 == null) {
            return -1L;
        }
        return l2.longValue();
    }

    protected final int e(int i2) {
        Integer num = (Integer) this.f6273a.get(i2);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    protected final byte[] f(int i2) {
        return (byte[]) this.f6273a.get(i2);
    }

    public final boolean g() {
        return this.f6273a.get(153, null) != null;
    }

    protected final void h(C0309e c0309e, int i2) {
        Objects.requireNonNull(c0309e);
        if (i2 != 137 && i2 != 147 && i2 != 150 && i2 != 154 && i2 != 160 && i2 != 164 && i2 != 166 && i2 != 181 && i2 != 182) {
            throw new RuntimeException("Invalid header field!");
        }
        this.f6273a.put(i2, c0309e);
    }

    protected final void i(C0309e[] c0309eArr) {
        ArrayList arrayList = new ArrayList();
        for (C0309e c0309e : c0309eArr) {
            arrayList.add(c0309e);
        }
        this.f6273a.put(151, arrayList);
    }

    protected final void j(long j2, int i2) {
        if (i2 != 133 && i2 != 142 && i2 != 157 && i2 != 159 && i2 != 161 && i2 != 173 && i2 != 175 && i2 != 179 && i2 != 135 && i2 != 136) {
            throw new RuntimeException("Invalid header field!");
        }
        this.f6273a.put(i2, Long.valueOf(j2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void k(int i2, int i4) throws C0302a {
        if (i4 == 134) {
            if (128 != i2 && 129 != i2) {
                throw new C0302a();
            }
        } else if (i4 != 153) {
            if (i4 != 165) {
                if (i4 != 167 && i4 != 169 && i4 != 171 && i4 != 177) {
                    if (i4 != 180) {
                        if (i4 != 191) {
                            if (i4 != 140) {
                                if (i4 != 141) {
                                    if (i4 != 148) {
                                        if (i4 != 149) {
                                            if (i4 != 155) {
                                                if (i4 != 156) {
                                                    if (i4 != 162) {
                                                        if (i4 != 163) {
                                                            switch (i4) {
                                                                case 143:
                                                                    if (i2 < 128 || i2 > 130) {
                                                                        throw new C0302a();
                                                                    }
                                                                    break;
                                                                case 144:
                                                                case 145:
                                                                    break;
                                                                case 146:
                                                                    if (i2 > 196 && i2 < 224) {
                                                                        i2 = 192;
                                                                        break;
                                                                    } else if ((i2 > 235 && i2 <= 255) || i2 < 128 || ((i2 > 136 && i2 < 192) || i2 > 255)) {
                                                                        i2 = 224;
                                                                        break;
                                                                    }
                                                                default:
                                                                    switch (i4) {
                                                                        case 186:
                                                                            if (i2 < 128 || i2 > 135) {
                                                                                throw new C0302a();
                                                                            }
                                                                        case 187:
                                                                        case 188:
                                                                            break;
                                                                        default:
                                                                            throw new RuntimeException("Invalid header field!");
                                                                    }
                                                                    break;
                                                            }
                                                        } else if (i2 < 128 || i2 > 132) {
                                                            throw new C0302a();
                                                        }
                                                    }
                                                } else if (i2 < 128 || i2 > 131) {
                                                    throw new C0302a();
                                                }
                                            } else if (128 != i2 && 129 != i2) {
                                                throw new C0302a();
                                            }
                                        } else if (i2 < 128 || i2 > 135) {
                                            throw new C0302a();
                                        }
                                    }
                                } else if (i2 < 16 || i2 > 19) {
                                    i2 = 18;
                                }
                            } else if (i2 < 128 || i2 > 151) {
                                throw new C0302a();
                            }
                        } else if (128 != i2 && 129 != i2) {
                            throw new C0302a();
                        }
                    } else if (128 != i2) {
                        throw new C0302a();
                    }
                }
            } else if (i2 <= 193 || i2 >= 224) {
                if ((i2 > 228 && i2 <= 255) || i2 < 128 || ((i2 > 128 && i2 < 192) || i2 > 255)) {
                }
            }
        } else if (i2 <= 194 || i2 >= 224) {
            if ((i2 > 227 && i2 <= 255) || i2 < 128 || ((i2 > 128 && i2 < 192) || i2 > 255)) {
            }
        }
        this.f6273a.put(i4, Integer.valueOf(i2));
    }

    protected final void l(byte[] bArr, int i2) {
        Objects.requireNonNull(bArr);
        if (i2 != 131 && i2 != 132 && i2 != 138 && i2 != 139 && i2 != 152 && i2 != 158 && i2 != 189 && i2 != 190) {
            switch (i2) {
                case 183:
                case 184:
                case 185:
                    break;
                default:
                    throw new RuntimeException("Invalid header field!");
            }
        }
        this.f6273a.put(i2, bArr);
    }
}
