package R;

/* loaded from: classes.dex */
public abstract class e extends o {
    public /* synthetic */ e(i iVar) {
        super(iVar);
    }

    protected abstract void d(V.f fVar, Object obj);

    public final int e(Object[] objArr) {
        V.f fVarA = a();
        try {
            int iB = 0;
            for (Object obj : objArr) {
                d(fVarA, obj);
                iB += fVarA.B();
            }
            return iB;
        } finally {
            c(fVarA);
        }
    }

    public final long[] f(Object[] objArr) {
        V.f fVarA = a();
        try {
            long[] jArr = new long[objArr.length];
            int i2 = 0;
            for (Object obj : objArr) {
                d(fVarA, obj);
                jArr[i2] = fVarA.W();
                i2++;
            }
            return jArr;
        } finally {
            c(fVarA);
        }
    }
}
