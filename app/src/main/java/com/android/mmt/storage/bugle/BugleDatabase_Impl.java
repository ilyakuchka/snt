package com.android.mmt.storage.bugle;

import L0.e;
import R.g;
import R.i;
import R.j;
import U.d;
import V.b;
import V.c;
import android.database.Cursor;
import android.database.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class BugleDatabase_Impl extends BugleDatabase {

    /* renamed from: s, reason: collision with root package name */
    private volatile e f4504s;

    final class a extends j.a {
        a() {
        }

        @Override // R.j.a
        public final void a(b bVar) throws SQLException {
            bVar.s("CREATE TABLE IF NOT EXISTS `conversations` (`_id` INTEGER NOT NULL, `date` INTEGER NOT NULL, `message_count` INTEGER NOT NULL, `snippet` TEXT, `snippet_cs` INTEGER NOT NULL, `unread_count` INTEGER NOT NULL, `read` INTEGER NOT NULL, `type` INTEGER NOT NULL, `error` INTEGER NOT NULL, `has_attachment` INTEGER NOT NULL, `has_draft` INTEGER NOT NULL, `sp_type` INTEGER NOT NULL, `update_at` INTEGER NOT NULL DEFAULT CURRENT_TIMESTAMP, `blocked` INTEGER NOT NULL, PRIMARY KEY(`_id`))");
            bVar.s("CREATE UNIQUE INDEX IF NOT EXISTS `index_conversations__id` ON `conversations` (`_id`)");
            bVar.s("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.s("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f43fc469e99ef5157d82eba7b211a219')");
        }

        @Override // R.j.a
        protected final void b(b bVar) {
            if (((i) BugleDatabase_Impl.this).f1262h != null) {
                int size = ((i) BugleDatabase_Impl.this).f1262h.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((i.b) ((i) BugleDatabase_Impl.this).f1262h.get(i2)).a();
                }
            }
        }

        @Override // R.j.a
        public final void c(b bVar) {
            ((i) BugleDatabase_Impl.this).f1257a = bVar;
            BugleDatabase_Impl.this.s(bVar);
            if (((i) BugleDatabase_Impl.this).f1262h != null) {
                int size = ((i) BugleDatabase_Impl.this).f1262h.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Objects.requireNonNull((i.b) ((i) BugleDatabase_Impl.this).f1262h.get(i2));
                }
            }
        }

        @Override // R.j.a
        public final void d(b bVar) throws SQLException {
            ArrayList arrayList = new ArrayList();
            Cursor cursorY = bVar.Y("SELECT name FROM sqlite_master WHERE type = 'trigger'");
            while (cursorY.moveToNext()) {
                try {
                    arrayList.add(cursorY.getString(0));
                } catch (Throwable th) {
                    cursorY.close();
                    throw th;
                }
            }
            cursorY.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.startsWith("room_fts_content_sync_")) {
                    bVar.s("DROP TRIGGER IF EXISTS " + str);
                }
            }
        }

        @Override // R.j.a
        protected final j.b e(b bVar) {
            HashMap map = new HashMap(14);
            map.put("_id", new d.a("_id", "INTEGER", true, 1, null, 1));
            map.put("date", new d.a("date", "INTEGER", true, 0, null, 1));
            map.put("message_count", new d.a("message_count", "INTEGER", true, 0, null, 1));
            map.put("snippet", new d.a("snippet", "TEXT", false, 0, null, 1));
            map.put("snippet_cs", new d.a("snippet_cs", "INTEGER", true, 0, null, 1));
            map.put("unread_count", new d.a("unread_count", "INTEGER", true, 0, null, 1));
            map.put("read", new d.a("read", "INTEGER", true, 0, null, 1));
            map.put("type", new d.a("type", "INTEGER", true, 0, null, 1));
            map.put("error", new d.a("error", "INTEGER", true, 0, null, 1));
            map.put("has_attachment", new d.a("has_attachment", "INTEGER", true, 0, null, 1));
            map.put("has_draft", new d.a("has_draft", "INTEGER", true, 0, null, 1));
            map.put("sp_type", new d.a("sp_type", "INTEGER", true, 0, null, 1));
            map.put("update_at", new d.a("update_at", "INTEGER", true, 0, "CURRENT_TIMESTAMP", 1));
            map.put("blocked", new d.a("blocked", "INTEGER", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new d.C0040d("index_conversations__id", true, Arrays.asList("_id")));
            d dVar = new d(map, hashSet, hashSet2);
            d dVarA = d.a(bVar);
            if (dVar.equals(dVarA)) {
                return new j.b(true, null);
            }
            return new j.b(false, "conversations(com.android.mmt.storage.bugle.BugleConversation).\n Expected:\n" + dVar + "\n Found:\n" + dVarA);
        }
    }

    @Override // R.i
    public final void d() throws SQLException {
        a();
        b bVarT = k().T();
        try {
            c();
            bVarT.s("DELETE FROM `conversations`");
            v();
        } finally {
            h();
            bVarT.Y("PRAGMA wal_checkpoint(FULL)").close();
            if (!bVarT.b0()) {
                bVarT.s("VACUUM");
            }
        }
    }

    @Override // R.i
    protected final g f() {
        return new g(this, new HashMap(0), new HashMap(0), "conversations");
    }

    @Override // R.i
    protected final c g(R.c cVar) {
        j jVar = new j(cVar, new a());
        c.b.a aVarA = c.b.a(cVar.f1227b);
        aVarA.c(cVar.f1228c);
        aVarA.b(jVar);
        return ((W.c) cVar.f1226a).a(aVarA.a());
    }

    @Override // R.i
    protected final Map<Class<?>, List<Class<?>>> m() {
        HashMap map = new HashMap();
        map.put(L0.d.class, Collections.emptyList());
        return map;
    }

    @Override // com.android.mmt.storage.bugle.BugleDatabase
    public final L0.d x() {
        e eVar;
        if (this.f4504s != null) {
            return this.f4504s;
        }
        synchronized (this) {
            if (this.f4504s == null) {
                this.f4504s = new e(this);
            }
            eVar = this.f4504s;
        }
        return eVar;
    }
}
