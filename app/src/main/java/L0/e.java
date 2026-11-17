package L0;

import N.e;
import R.i;
import R.k;
import R.o;
import android.database.Cursor;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class e extends L0.d {

    /* renamed from: a, reason: collision with root package name */
    private final i f349a;

    /* renamed from: b, reason: collision with root package name */
    private final R.e f350b;

    /* renamed from: c, reason: collision with root package name */
    private final R.e f351c;
    private final R.e d;

    /* renamed from: e, reason: collision with root package name */
    private final o f352e;

    final class a extends R.e {
        a(i iVar) {
            super(iVar);
        }

        @Override // R.o
        public final String b() {
            return "INSERT OR REPLACE INTO `conversations` (`_id`,`date`,`message_count`,`snippet`,`snippet_cs`,`unread_count`,`read`,`type`,`error`,`has_attachment`,`has_draft`,`sp_type`,`update_at`,`blocked`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // R.e
        public final void d(V.f fVar, Object obj) {
            L0.a aVar = (L0.a) obj;
            fVar.v(1, aVar.f());
            fVar.v(2, aVar.b());
            fVar.v(3, aVar.g());
            if (aVar.i() == null) {
                fVar.L(4);
            } else {
                fVar.u(4, aVar.i());
            }
            fVar.v(5, aVar.j());
            fVar.v(6, aVar.m());
            fVar.v(7, aVar.h());
            fVar.v(8, aVar.l());
            fVar.v(9, aVar.c());
            fVar.v(10, aVar.d());
            fVar.v(11, aVar.e());
            fVar.v(12, aVar.k());
            fVar.v(13, aVar.n());
            fVar.v(14, aVar.a());
        }
    }

    final class b extends R.e {
        b(i iVar) {
            super(iVar);
        }

        @Override // R.o
        public final String b() {
            return "DELETE FROM `conversations` WHERE `_id` = ?";
        }

        @Override // R.e
        public final void d(V.f fVar, Object obj) {
            fVar.v(1, ((L0.a) obj).f());
        }
    }

    final class c extends R.e {
        c(i iVar) {
            super(iVar);
        }

        @Override // R.o
        public final String b() {
            return "UPDATE OR REPLACE `conversations` SET `_id` = ?,`date` = ?,`message_count` = ?,`snippet` = ?,`snippet_cs` = ?,`unread_count` = ?,`read` = ?,`type` = ?,`error` = ?,`has_attachment` = ?,`has_draft` = ?,`sp_type` = ?,`update_at` = ?,`blocked` = ? WHERE `_id` = ?";
        }

        @Override // R.e
        public final void d(V.f fVar, Object obj) {
            L0.a aVar = (L0.a) obj;
            fVar.v(1, aVar.f());
            fVar.v(2, aVar.b());
            fVar.v(3, aVar.g());
            if (aVar.i() == null) {
                fVar.L(4);
            } else {
                fVar.u(4, aVar.i());
            }
            fVar.v(5, aVar.j());
            fVar.v(6, aVar.m());
            fVar.v(7, aVar.h());
            fVar.v(8, aVar.l());
            fVar.v(9, aVar.c());
            fVar.v(10, aVar.d());
            fVar.v(11, aVar.e());
            fVar.v(12, aVar.k());
            fVar.v(13, aVar.n());
            fVar.v(14, aVar.a());
            fVar.v(15, aVar.f());
        }
    }

    final class d extends o {
        d(i iVar) {
            super(iVar);
        }

        @Override // R.o
        public final String b() {
            return "DELETE FROM conversations WHERE _id=?";
        }
    }

    /* renamed from: L0.e$e, reason: collision with other inner class name */
    final class CallableC0015e implements Callable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f353a;

        CallableC0015e(k kVar) {
            this.f353a = kVar;
        }

        @Override // java.util.concurrent.Callable
        public final Integer call() throws Exception {
            Cursor cursorU = e.this.f349a.u(this.f353a);
            try {
                return (!cursorU.moveToFirst() || cursorU.isNull(0)) ? null : Integer.valueOf(cursorU.getInt(0));
            } finally {
                cursorU.close();
            }
        }

        protected final void finalize() {
            this.f353a.g0();
        }
    }

    final class f extends e.a<Integer, L0.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f355a;

        f(k kVar) {
            this.f355a = kVar;
        }

        @Override // N.e.a
        public final N.e<Integer, L0.a> a() {
            return new L0.f(e.this.f349a, this.f355a, "conversations");
        }
    }

    final class g extends e.a<Integer, L0.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f357a;

        g(k kVar) {
            this.f357a = kVar;
        }

        @Override // N.e.a
        public final N.e<Integer, L0.a> a() {
            return new L0.g(e.this.f349a, this.f357a, "conversations");
        }
    }

    public e(i iVar) {
        this.f349a = iVar;
        this.f350b = new a(iVar);
        this.f351c = new b(iVar);
        this.d = new c(iVar);
        this.f352e = new d(iVar);
    }

    @Override // L0.d
    public final void A() {
        this.f349a.c();
        try {
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final List<Long> B(Set<Long> set) {
        StringBuilder sbD = D2.e.d("SELECT _id FROM conversations WHERE _id IN (");
        int size = set.size();
        Y1.a.b(sbD, size);
        sbD.append(") AND read = 0 AND _id>0");
        k kVarI = k.I(sbD.toString(), size + 0);
        int i2 = 1;
        for (Long l2 : set) {
            if (l2 == null) {
                kVarI.L(i2);
            } else {
                kVarI.v(i2, l2.longValue());
            }
            i2++;
        }
        this.f349a.b();
        Cursor cursorU = this.f349a.u(kVarI);
        try {
            ArrayList arrayList = new ArrayList(cursorU.getCount());
            while (cursorU.moveToNext()) {
                arrayList.add(cursorU.isNull(0) ? null : Long.valueOf(cursorU.getLong(0)));
            }
            return arrayList;
        } finally {
            cursorU.close();
            kVarI.g0();
        }
    }

    @Override // L0.d
    public final List<Long> C(Set<Long> set) {
        StringBuilder sbD = D2.e.d("SELECT _id FROM conversations WHERE _id NOT IN (");
        int size = set.size();
        Y1.a.b(sbD, size);
        sbD.append(") AND read = 0 AND _id > 0");
        k kVarI = k.I(sbD.toString(), size + 0);
        int i2 = 1;
        for (Long l2 : set) {
            if (l2 == null) {
                kVarI.L(i2);
            } else {
                kVarI.v(i2, l2.longValue());
            }
            i2++;
        }
        this.f349a.b();
        Cursor cursorU = this.f349a.u(kVarI);
        try {
            ArrayList arrayList = new ArrayList(cursorU.getCount());
            while (cursorU.moveToNext()) {
                arrayList.add(cursorU.isNull(0) ? null : Long.valueOf(cursorU.getLong(0)));
            }
            return arrayList;
        } finally {
            cursorU.close();
            kVarI.g0();
        }
    }

    @Override // L0.d
    public final long D(long j2) {
        k kVarI = k.I("SELECT update_at FROM conversations WHERE _id=? ORDER BY update_at ASC LIMIT 1", 1);
        kVarI.v(1, j2);
        this.f349a.b();
        Cursor cursorU = this.f349a.u(kVarI);
        try {
            return cursorU.moveToFirst() ? cursorU.getLong(0) : 0L;
        } finally {
            cursorU.close();
            kVarI.g0();
        }
    }

    @Override // L0.d
    public final void E(L0.a... aVarArr) {
        this.f349a.c();
        try {
            super.E(aVarArr);
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final void G(List<Long> list) {
        this.f349a.b();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE conversations SET has_draft=1 WHERE _id IN (");
        ArrayList arrayList = (ArrayList) list;
        Y1.a.b(sb, arrayList.size());
        sb.append(")");
        V.f fVarE = this.f349a.e(sb.toString());
        Iterator it = arrayList.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            Long l2 = (Long) it.next();
            if (l2 == null) {
                fVarE.L(i2);
            } else {
                fVarE.v(i2, l2.longValue());
            }
            i2++;
        }
        this.f349a.c();
        try {
            fVarE.B();
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final void H(L0.a... aVarArr) {
        this.f349a.c();
        try {
            super.H(aVarArr);
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final void I() {
        this.f349a.c();
        try {
            super.I();
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    final void a(long j2) {
        this.f349a.b();
        V.f fVarA = this.f352e.a();
        fVarA.v(1, j2);
        this.f349a.c();
        try {
            fVarA.B();
            this.f349a.v();
        } finally {
            this.f349a.h();
            this.f352e.c(fVarA);
        }
    }

    @Override // L0.d
    final void b(List<Long> list) {
        this.f349a.b();
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM conversations WHERE _id IN (");
        Y1.a.b(sb, list.size());
        sb.append(")");
        V.f fVarE = this.f349a.e(sb.toString());
        int i2 = 1;
        for (Long l2 : list) {
            if (l2 == null) {
                fVarE.L(i2);
            } else {
                fVarE.v(i2, l2.longValue());
            }
            i2++;
        }
        this.f349a.c();
        try {
            fVarE.B();
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    final e.a<Integer, L0.a> c(List<Integer> list, int i2) {
        StringBuilder sbD = D2.e.d("SELECT * FROM conversations WHERE (_id > 0 OR _id IN (");
        int size = list.size();
        Y1.a.b(sbD, size);
        sbD.append(")) and blocked=");
        sbD.append("?");
        sbD.append(" and (message_count > 0 OR has_draft) ORDER BY date DESC");
        int i4 = 1;
        int i5 = size + 1;
        k kVarI = k.I(sbD.toString(), i5);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                kVarI.L(i4);
            } else {
                kVarI.v(i4, r3.intValue());
            }
            i4++;
        }
        kVarI.v(i5, i2);
        return new f(kVarI);
    }

    @Override // L0.d
    final e.a<Integer, L0.a> d(List<Integer> list, int i2) {
        StringBuilder sbD = D2.e.d("SELECT * FROM conversations WHERE (_id > 0 OR _id IN (");
        int size = list.size();
        Y1.a.b(sbD, size);
        sbD.append(")) AND sp_type=0 and blocked=");
        sbD.append("?");
        sbD.append(" ORDER BY date DESC");
        int i4 = 1;
        int i5 = size + 1;
        k kVarI = k.I(sbD.toString(), i5);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                kVarI.L(i4);
            } else {
                kVarI.v(i4, r3.intValue());
            }
            i4++;
        }
        kVarI.v(i5, i2);
        return new g(kVarI);
    }

    @Override // L0.d
    final long[] e(L0.a... aVarArr) {
        this.f349a.b();
        this.f349a.c();
        try {
            long[] jArrF = this.f350b.f(aVarArr);
            this.f349a.v();
            return jArrF;
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    final void f(List<Long> list) {
        this.f349a.b();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE conversations SET read=1 WHERE read=0 AND _id IN (");
        Y1.a.b(sb, list.size());
        sb.append(")");
        V.f fVarE = this.f349a.e(sb.toString());
        int i2 = 1;
        for (Long l2 : list) {
            if (l2 == null) {
                fVarE.L(i2);
            } else {
                fVarE.v(i2, l2.longValue());
            }
            i2++;
        }
        this.f349a.c();
        try {
            fVarE.B();
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    final void g(L0.a... aVarArr) {
        this.f349a.b();
        this.f349a.c();
        try {
            this.d.e(aVarArr);
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final void h(long j2) {
        this.f349a.c();
        try {
            super.h(j2);
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final void i(L0.a... aVarArr) {
        this.f349a.c();
        try {
            k(aVarArr);
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final boolean j(long j2) {
        this.f349a.c();
        try {
            h(j2);
            this.f349a.v();
            this.f349a.h();
            return true;
        } catch (Throwable th) {
            this.f349a.h();
            throw th;
        }
    }

    @Override // L0.d
    public final void k(L0.a... aVarArr) {
        this.f349a.c();
        try {
            super.k(aVarArr);
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/List<Ljava/lang/Long;>;Z)Z */
    @Override // L0.d
    public final void l(List list, boolean z4) {
        this.f349a.c();
        try {
            super.l(list, z4);
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/List<Ljava/lang/Long;>;Z)Z */
    @Override // L0.d
    public final void m(List list) {
        this.f349a.c();
        try {
            if (list.size() > 0) {
                b(list);
            }
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final long[] p(L0.a... aVarArr) {
        this.f349a.c();
        try {
            long[] jArrP = super.p(aVarArr);
            this.f349a.v();
            return jArrP;
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final void q(List<Long> list, int i2) {
        this.f349a.b();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE conversations SET blocked=");
        sb.append("?");
        sb.append(" WHERE _id IN (");
        Y1.a.b(sb, list.size());
        sb.append(")");
        V.f fVarE = this.f349a.e(sb.toString());
        fVarE.v(1, i2);
        int i4 = 2;
        for (Long l2 : list) {
            if (l2 == null) {
                fVarE.L(i4);
            } else {
                fVarE.v(i4, l2.longValue());
            }
            i4++;
        }
        this.f349a.c();
        try {
            fVarE.B();
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final void r(List list) {
        this.f349a.b();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE conversations SET blocked=");
        sb.append("?");
        sb.append(" WHERE _id NOT IN (");
        ArrayList arrayList = (ArrayList) list;
        Y1.a.b(sb, arrayList.size());
        sb.append(")");
        V.f fVarE = this.f349a.e(sb.toString());
        fVarE.v(1, 0);
        Iterator it = arrayList.iterator();
        int i2 = 2;
        while (it.hasNext()) {
            Long l2 = (Long) it.next();
            if (l2 == null) {
                fVarE.L(i2);
            } else {
                fVarE.v(i2, l2.longValue());
            }
            i2++;
        }
        this.f349a.c();
        try {
            fVarE.B();
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final void s(List<Long> list) {
        this.f349a.c();
        try {
            super.s(list);
            this.f349a.v();
        } finally {
            this.f349a.h();
        }
    }

    @Override // L0.d
    public final L0.a t(long j2) throws Throwable {
        k kVar;
        k kVarI = k.I("SELECT * FROM conversations WHERE _id=?", 1);
        kVarI.v(1, j2);
        this.f349a.b();
        Cursor cursorU = this.f349a.u(kVarI);
        try {
            int iA = U.b.a(cursorU, "_id");
            int iA2 = U.b.a(cursorU, "date");
            int iA3 = U.b.a(cursorU, "message_count");
            int iA4 = U.b.a(cursorU, "snippet");
            int iA5 = U.b.a(cursorU, "snippet_cs");
            int iA6 = U.b.a(cursorU, "unread_count");
            int iA7 = U.b.a(cursorU, "read");
            int iA8 = U.b.a(cursorU, "type");
            int iA9 = U.b.a(cursorU, "error");
            int iA10 = U.b.a(cursorU, "has_attachment");
            int iA11 = U.b.a(cursorU, "has_draft");
            int iA12 = U.b.a(cursorU, "sp_type");
            int iA13 = U.b.a(cursorU, "update_at");
            int iA14 = U.b.a(cursorU, "blocked");
            L0.a aVar = null;
            String string = null;
            if (cursorU.moveToFirst()) {
                kVar = kVarI;
                try {
                    L0.a aVar2 = new L0.a();
                    aVar2.z(cursorU.getLong(iA));
                    aVar2.s(cursorU.getLong(iA2));
                    aVar2.A(cursorU.getLong(iA3));
                    if (!cursorU.isNull(iA4)) {
                        string = cursorU.getString(iA4);
                    }
                    aVar2.C(string);
                    aVar2.D(cursorU.getInt(iA5));
                    aVar2.G(cursorU.getInt(iA6));
                    aVar2.B(cursorU.getInt(iA7));
                    aVar2.F(cursorU.getInt(iA8));
                    aVar2.u(cursorU.getInt(iA9));
                    aVar2.v(cursorU.getInt(iA10));
                    aVar2.x(cursorU.getLong(iA11));
                    aVar2.E(cursorU.getInt(iA12));
                    aVar2.H(cursorU.getLong(iA13));
                    aVar2.r(cursorU.getInt(iA14));
                    aVar = aVar2;
                } catch (Throwable th) {
                    th = th;
                    cursorU.close();
                    kVar.g0();
                    throw th;
                }
            } else {
                kVar = kVarI;
            }
            cursorU.close();
            kVar.g0();
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            kVar = kVarI;
        }
    }

    @Override // L0.d
    public final L0.a u(long j2) throws Throwable {
        k kVar;
        k kVarI = k.I("SELECT * FROM conversations WHERE _id=? AND blocked=?", 2);
        kVarI.v(1, j2);
        kVarI.v(2, 1);
        this.f349a.b();
        Cursor cursorU = this.f349a.u(kVarI);
        try {
            int iA = U.b.a(cursorU, "_id");
            int iA2 = U.b.a(cursorU, "date");
            int iA3 = U.b.a(cursorU, "message_count");
            int iA4 = U.b.a(cursorU, "snippet");
            int iA5 = U.b.a(cursorU, "snippet_cs");
            int iA6 = U.b.a(cursorU, "unread_count");
            int iA7 = U.b.a(cursorU, "read");
            int iA8 = U.b.a(cursorU, "type");
            int iA9 = U.b.a(cursorU, "error");
            int iA10 = U.b.a(cursorU, "has_attachment");
            int iA11 = U.b.a(cursorU, "has_draft");
            int iA12 = U.b.a(cursorU, "sp_type");
            int iA13 = U.b.a(cursorU, "update_at");
            int iA14 = U.b.a(cursorU, "blocked");
            L0.a aVar = null;
            String string = null;
            if (cursorU.moveToFirst()) {
                kVar = kVarI;
                try {
                    L0.a aVar2 = new L0.a();
                    aVar2.z(cursorU.getLong(iA));
                    aVar2.s(cursorU.getLong(iA2));
                    aVar2.A(cursorU.getLong(iA3));
                    if (!cursorU.isNull(iA4)) {
                        string = cursorU.getString(iA4);
                    }
                    aVar2.C(string);
                    aVar2.D(cursorU.getInt(iA5));
                    aVar2.G(cursorU.getInt(iA6));
                    aVar2.B(cursorU.getInt(iA7));
                    aVar2.F(cursorU.getInt(iA8));
                    aVar2.u(cursorU.getInt(iA9));
                    aVar2.v(cursorU.getInt(iA10));
                    aVar2.x(cursorU.getLong(iA11));
                    aVar2.E(cursorU.getInt(iA12));
                    aVar2.H(cursorU.getLong(iA13));
                    aVar2.r(cursorU.getInt(iA14));
                    aVar = aVar2;
                } catch (Throwable th) {
                    th = th;
                    cursorU.close();
                    kVar.g0();
                    throw th;
                }
            } else {
                kVar = kVarI;
            }
            cursorU.close();
            kVar.g0();
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            kVar = kVarI;
        }
    }

    @Override // L0.d
    final List<Long> v(List<Integer> list) {
        StringBuilder sbD = D2.e.d("SELECT _id FROM conversations WHERE sp_type IN (");
        ArrayList arrayList = (ArrayList) list;
        int size = arrayList.size();
        Y1.a.b(sbD, size);
        sbD.append(") AND _id>0");
        k kVarI = k.I(sbD.toString(), size + 0);
        Iterator it = arrayList.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            if (((Integer) it.next()) == null) {
                kVarI.L(i2);
            } else {
                kVarI.v(i2, r3.intValue());
            }
            i2++;
        }
        this.f349a.b();
        Cursor cursorU = this.f349a.u(kVarI);
        try {
            ArrayList arrayList2 = new ArrayList(cursorU.getCount());
            while (cursorU.moveToNext()) {
                arrayList2.add(cursorU.isNull(0) ? null : Long.valueOf(cursorU.getLong(0)));
            }
            return arrayList2;
        } finally {
            cursorU.close();
            kVarI.g0();
        }
    }

    @Override // L0.d
    final List<Long> w(List<Long> list, List<Integer> list2) {
        StringBuilder sbD = D2.e.d("SELECT _id FROM conversations WHERE _id NOT IN (");
        ArrayList arrayList = (ArrayList) list;
        int size = arrayList.size();
        Y1.a.b(sbD, size);
        sbD.append(") AND sp_type IN (");
        ArrayList arrayList2 = (ArrayList) list2;
        int size2 = arrayList2.size();
        Y1.a.b(sbD, size2);
        sbD.append(") AND _id>0");
        k kVarI = k.I(sbD.toString(), size + 0 + size2);
        Iterator it = arrayList.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            Long l2 = (Long) it.next();
            if (l2 == null) {
                kVarI.L(i2);
            } else {
                kVarI.v(i2, l2.longValue());
            }
            i2++;
        }
        int i4 = size + 1;
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            if (((Integer) it2.next()) == null) {
                kVarI.L(i4);
            } else {
                kVarI.v(i4, r8.intValue());
            }
            i4++;
        }
        this.f349a.b();
        Cursor cursorU = this.f349a.u(kVarI);
        try {
            ArrayList arrayList3 = new ArrayList(cursorU.getCount());
            while (cursorU.moveToNext()) {
                arrayList3.add(cursorU.isNull(0) ? null : Long.valueOf(cursorU.getLong(0)));
            }
            return arrayList3;
        } finally {
            cursorU.close();
            kVarI.g0();
        }
    }

    @Override // L0.d
    public final LiveData<Integer> x(List<Integer> list, int i2) {
        StringBuilder sbD = D2.e.d("SELECT COUNT(*) FROM conversations WHERE (_id > 0 OR _id IN (");
        ArrayList arrayList = (ArrayList) list;
        int size = arrayList.size();
        Y1.a.b(sbD, size);
        sbD.append("))AND blocked=");
        sbD.append("?");
        sbD.append(" AND (message_count > 0 OR has_draft)");
        int i4 = 1;
        int i5 = size + 1;
        k kVarI = k.I(sbD.toString(), i5);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((Integer) it.next()) == null) {
                kVarI.L(i4);
            } else {
                kVarI.v(i4, r3.intValue());
            }
            i4++;
        }
        kVarI.v(i5, i2);
        return this.f349a.j().d(new String[]{"conversations"}, new CallableC0015e(kVarI));
    }

    @Override // L0.d
    final L0.a y() throws Throwable {
        k kVar;
        k kVarI = k.I("SELECT * FROM conversations WHERE sp_type>0  ORDER BY date DESC LIMIT 1", 0);
        this.f349a.b();
        Cursor cursorU = this.f349a.u(kVarI);
        try {
            int iA = U.b.a(cursorU, "_id");
            int iA2 = U.b.a(cursorU, "date");
            int iA3 = U.b.a(cursorU, "message_count");
            int iA4 = U.b.a(cursorU, "snippet");
            int iA5 = U.b.a(cursorU, "snippet_cs");
            int iA6 = U.b.a(cursorU, "unread_count");
            int iA7 = U.b.a(cursorU, "read");
            int iA8 = U.b.a(cursorU, "type");
            int iA9 = U.b.a(cursorU, "error");
            int iA10 = U.b.a(cursorU, "has_attachment");
            int iA11 = U.b.a(cursorU, "has_draft");
            int iA12 = U.b.a(cursorU, "sp_type");
            int iA13 = U.b.a(cursorU, "update_at");
            int iA14 = U.b.a(cursorU, "blocked");
            L0.a aVar = null;
            String string = null;
            if (cursorU.moveToFirst()) {
                kVar = kVarI;
                try {
                    L0.a aVar2 = new L0.a();
                    aVar2.z(cursorU.getLong(iA));
                    aVar2.s(cursorU.getLong(iA2));
                    aVar2.A(cursorU.getLong(iA3));
                    if (!cursorU.isNull(iA4)) {
                        string = cursorU.getString(iA4);
                    }
                    aVar2.C(string);
                    aVar2.D(cursorU.getInt(iA5));
                    aVar2.G(cursorU.getInt(iA6));
                    aVar2.B(cursorU.getInt(iA7));
                    aVar2.F(cursorU.getInt(iA8));
                    aVar2.u(cursorU.getInt(iA9));
                    aVar2.v(cursorU.getInt(iA10));
                    aVar2.x(cursorU.getLong(iA11));
                    aVar2.E(cursorU.getInt(iA12));
                    aVar2.H(cursorU.getLong(iA13));
                    aVar2.r(cursorU.getInt(iA14));
                    aVar = aVar2;
                } catch (Throwable th) {
                    th = th;
                    cursorU.close();
                    kVar.g0();
                    throw th;
                }
            } else {
                kVar = kVarI;
            }
            cursorU.close();
            kVar.g0();
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            kVar = kVarI;
        }
    }

    @Override // L0.d
    public final List<Long> z(List<Long> list) {
        this.f349a.c();
        try {
            List<Long> listZ = super.z(list);
            this.f349a.v();
            return listZ;
        } finally {
            this.f349a.h();
        }
    }
}
