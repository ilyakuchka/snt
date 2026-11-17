package U;

import D2.e;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1646a = "conversations";

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, a> f1647b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<b> f1648c;
    public final Set<C0040d> d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f1649a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1650b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1651c;
        public final boolean d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1652e;

        /* renamed from: f, reason: collision with root package name */
        public final String f1653f;
        private final int g;

        public a(String str, String str2, boolean z4, int i2, String str3, int i4) {
            this.f1649a = str;
            this.f1650b = str2;
            this.d = z4;
            this.f1652e = i2;
            int i5 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i5 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i5 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i5 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.f1651c = i5;
            this.f1653f = str3;
            this.g = i4;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f1652e != aVar.f1652e || !this.f1649a.equals(aVar.f1649a) || this.d != aVar.d) {
                return false;
            }
            if (this.g == 1 && aVar.g == 2 && (str3 = this.f1653f) != null && !str3.equals(aVar.f1653f)) {
                return false;
            }
            if (this.g == 2 && aVar.g == 1 && (str2 = aVar.f1653f) != null && !str2.equals(this.f1653f)) {
                return false;
            }
            int i2 = this.g;
            return (i2 == 0 || i2 != aVar.g || ((str = this.f1653f) == null ? aVar.f1653f == null : str.equals(aVar.f1653f))) && this.f1651c == aVar.f1651c;
        }

        public final int hashCode() {
            return (((((this.f1649a.hashCode() * 31) + this.f1651c) * 31) + (this.d ? 1231 : 1237)) * 31) + this.f1652e;
        }

        public final String toString() {
            StringBuilder sbD = e.d("Column{name='");
            sbD.append(this.f1649a);
            sbD.append('\'');
            sbD.append(", type='");
            sbD.append(this.f1650b);
            sbD.append('\'');
            sbD.append(", affinity='");
            sbD.append(this.f1651c);
            sbD.append('\'');
            sbD.append(", notNull=");
            sbD.append(this.d);
            sbD.append(", primaryKeyPosition=");
            sbD.append(this.f1652e);
            sbD.append(", defaultValue='");
            sbD.append(this.f1653f);
            sbD.append('\'');
            sbD.append('}');
            return sbD.toString();
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f1654a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1655b;

        /* renamed from: c, reason: collision with root package name */
        public final String f1656c;
        public final List<String> d;

        /* renamed from: e, reason: collision with root package name */
        public final List<String> f1657e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f1654a = str;
            this.f1655b = str2;
            this.f1656c = str3;
            this.d = Collections.unmodifiableList(list);
            this.f1657e = Collections.unmodifiableList(list2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f1654a.equals(bVar.f1654a) && this.f1655b.equals(bVar.f1655b) && this.f1656c.equals(bVar.f1656c) && this.d.equals(bVar.d)) {
                return this.f1657e.equals(bVar.f1657e);
            }
            return false;
        }

        public final int hashCode() {
            return this.f1657e.hashCode() + ((this.d.hashCode() + ((this.f1656c.hashCode() + ((this.f1655b.hashCode() + (this.f1654a.hashCode() * 31)) * 31)) * 31)) * 31);
        }

        public final String toString() {
            StringBuilder sbD = e.d("ForeignKey{referenceTable='");
            sbD.append(this.f1654a);
            sbD.append('\'');
            sbD.append(", onDelete='");
            sbD.append(this.f1655b);
            sbD.append('\'');
            sbD.append(", onUpdate='");
            sbD.append(this.f1656c);
            sbD.append('\'');
            sbD.append(", columnNames=");
            sbD.append(this.d);
            sbD.append(", referenceColumnNames=");
            sbD.append(this.f1657e);
            sbD.append('}');
            return sbD.toString();
        }
    }

    static class c implements Comparable<c> {

        /* renamed from: i, reason: collision with root package name */
        final int f1658i;

        /* renamed from: j, reason: collision with root package name */
        final int f1659j;

        /* renamed from: k, reason: collision with root package name */
        final String f1660k;

        /* renamed from: l, reason: collision with root package name */
        final String f1661l;

        c(int i2, int i4, String str, String str2) {
            this.f1658i = i2;
            this.f1659j = i4;
            this.f1660k = str;
            this.f1661l = str2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(c cVar) {
            c cVar2 = cVar;
            int i2 = this.f1658i - cVar2.f1658i;
            return i2 == 0 ? this.f1659j - cVar2.f1659j : i2;
        }
    }

    /* renamed from: U.d$d, reason: collision with other inner class name */
    public static final class C0040d {

        /* renamed from: a, reason: collision with root package name */
        public final String f1662a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1663b;

        /* renamed from: c, reason: collision with root package name */
        public final List<String> f1664c;

        public C0040d(String str, boolean z4, List<String> list) {
            this.f1662a = str;
            this.f1663b = z4;
            this.f1664c = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0040d)) {
                return false;
            }
            C0040d c0040d = (C0040d) obj;
            if (this.f1663b == c0040d.f1663b && this.f1664c.equals(c0040d.f1664c)) {
                return this.f1662a.startsWith("index_") ? c0040d.f1662a.startsWith("index_") : this.f1662a.equals(c0040d.f1662a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f1664c.hashCode() + ((((this.f1662a.startsWith("index_") ? -1184239155 : this.f1662a.hashCode()) * 31) + (this.f1663b ? 1 : 0)) * 31);
        }

        public final String toString() {
            StringBuilder sbD = e.d("Index{name='");
            sbD.append(this.f1662a);
            sbD.append('\'');
            sbD.append(", unique=");
            sbD.append(this.f1663b);
            sbD.append(", columns=");
            sbD.append(this.f1664c);
            sbD.append('}');
            return sbD.toString();
        }
    }

    public d(Map map, Set set, Set set2) {
        this.f1647b = Collections.unmodifiableMap(map);
        this.f1648c = Collections.unmodifiableSet(set);
        this.d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static d a(V.b bVar) {
        int i2;
        int i4;
        Cursor cursorY = bVar.Y("PRAGMA table_info(`conversations`)");
        HashMap map = new HashMap();
        try {
            if (cursorY.getColumnCount() > 0) {
                int columnIndex = cursorY.getColumnIndex("name");
                int columnIndex2 = cursorY.getColumnIndex("type");
                int columnIndex3 = cursorY.getColumnIndex("notnull");
                int columnIndex4 = cursorY.getColumnIndex("pk");
                int columnIndex5 = cursorY.getColumnIndex("dflt_value");
                while (cursorY.moveToNext()) {
                    String string = cursorY.getString(columnIndex);
                    map.put(string, new a(string, cursorY.getString(columnIndex2), cursorY.getInt(columnIndex3) != 0, cursorY.getInt(columnIndex4), cursorY.getString(columnIndex5), 2));
                }
            }
            cursorY.close();
            HashSet hashSet = new HashSet();
            cursorY = bVar.Y("PRAGMA foreign_key_list(`conversations`)");
            try {
                int columnIndex6 = cursorY.getColumnIndex("id");
                int columnIndex7 = cursorY.getColumnIndex("seq");
                int columnIndex8 = cursorY.getColumnIndex("table");
                int columnIndex9 = cursorY.getColumnIndex("on_delete");
                int columnIndex10 = cursorY.getColumnIndex("on_update");
                List<c> listB = b(cursorY);
                int count = cursorY.getCount();
                int i5 = 0;
                while (i5 < count) {
                    cursorY.moveToPosition(i5);
                    if (cursorY.getInt(columnIndex7) != 0) {
                        i2 = columnIndex6;
                        i4 = columnIndex7;
                    } else {
                        int i6 = cursorY.getInt(columnIndex6);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = ((ArrayList) listB).iterator();
                        while (it.hasNext()) {
                            int i7 = columnIndex6;
                            c cVar = (c) it.next();
                            int i8 = columnIndex7;
                            if (cVar.f1658i == i6) {
                                arrayList.add(cVar.f1660k);
                                arrayList2.add(cVar.f1661l);
                            }
                            columnIndex7 = i8;
                            columnIndex6 = i7;
                        }
                        i2 = columnIndex6;
                        i4 = columnIndex7;
                        hashSet.add(new b(cursorY.getString(columnIndex8), cursorY.getString(columnIndex9), cursorY.getString(columnIndex10), arrayList, arrayList2));
                    }
                    i5++;
                    columnIndex7 = i4;
                    columnIndex6 = i2;
                }
                cursorY.close();
                cursorY = bVar.Y("PRAGMA index_list(`conversations`)");
                try {
                    int columnIndex11 = cursorY.getColumnIndex("name");
                    int columnIndex12 = cursorY.getColumnIndex("origin");
                    int columnIndex13 = cursorY.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 == -1 || columnIndex12 == -1 || columnIndex13 == -1) {
                        break;
                    }
                    HashSet hashSet3 = new HashSet();
                    while (cursorY.moveToNext()) {
                        if ("c".equals(cursorY.getString(columnIndex12))) {
                            C0040d c0040dC = c(bVar, cursorY.getString(columnIndex11), cursorY.getInt(columnIndex13) == 1);
                            if (c0040dC == null) {
                                break;
                            }
                            hashSet3.add(c0040dC);
                        }
                    }
                    cursorY.close();
                    hashSet2 = hashSet3;
                    return new d(map, hashSet, hashSet2);
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private static List<c> b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < count; i2++) {
            cursor.moveToPosition(i2);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static C0040d c(V.b bVar, String str, boolean z4) {
        Cursor cursorY = bVar.Y("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorY.getColumnIndex("seqno");
            int columnIndex2 = cursorY.getColumnIndex("cid");
            int columnIndex3 = cursorY.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (cursorY.moveToNext()) {
                    if (cursorY.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(cursorY.getInt(columnIndex)), cursorY.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new C0040d(str, z4, arrayList);
            }
            return null;
        } finally {
            cursorY.close();
        }
    }

    public final boolean equals(Object obj) {
        Set<C0040d> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f1646a;
        if (str == null ? dVar.f1646a != null : !str.equals(dVar.f1646a)) {
            return false;
        }
        Map<String, a> map = this.f1647b;
        if (map == null ? dVar.f1647b != null : !map.equals(dVar.f1647b)) {
            return false;
        }
        Set<b> set2 = this.f1648c;
        if (set2 == null ? dVar.f1648c != null : !set2.equals(dVar.f1648c)) {
            return false;
        }
        Set<C0040d> set3 = this.d;
        if (set3 == null || (set = dVar.d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public final int hashCode() {
        String str = this.f1646a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f1647b;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f1648c;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbD = e.d("TableInfo{name='");
        sbD.append(this.f1646a);
        sbD.append('\'');
        sbD.append(", columns=");
        sbD.append(this.f1647b);
        sbD.append(", foreignKeys=");
        sbD.append(this.f1648c);
        sbD.append(", indices=");
        sbD.append(this.d);
        sbD.append('}');
        return sbD.toString();
    }
}
