package com.android.mmt.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.mmt.R;
import java.lang.ref.WeakReference;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public class PhraseActivity extends miuix.appcompat.app.h {

    /* renamed from: v, reason: collision with root package name */
    private P0.s f5307v;

    /* renamed from: w, reason: collision with root package name */
    private b f5308w;

    /* renamed from: x, reason: collision with root package name */
    private ListView f5309x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f5310y;

    /* renamed from: z, reason: collision with root package name */
    private AdapterView.OnItemClickListener f5311z = new a();

    final class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            PhraseActivity.O(PhraseActivity.this, view, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private Pair<String, Integer> f5313a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f5314b;

        /* renamed from: c, reason: collision with root package name */
        private miuix.appcompat.app.g f5315c;
        private EditText d;

        /* renamed from: e, reason: collision with root package name */
        private View f5316e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<PhraseActivity> f5317f;

        final class a implements DialogInterface.OnClickListener {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ PhraseActivity f5318i;

            a(PhraseActivity phraseActivity) {
                this.f5318i = phraseActivity;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f5318i.f5307v.d(((Integer) b.this.f5313a.second).intValue());
            }
        }

        public b(PhraseActivity phraseActivity) {
            WeakReference<PhraseActivity> weakReference = new WeakReference<>(phraseActivity);
            this.f5317f = weakReference;
            PhraseActivity phraseActivity2 = weakReference.get();
            if (this.f5317f.get() == null) {
                return;
            }
            View viewInflate = LayoutInflater.from(phraseActivity2).inflate(R.layout.phrase_edit_text, (ViewGroup) null);
            this.f5316e = viewInflate;
            this.d = (EditText) viewInflate.findViewById(R.id.new_phrase_content);
            g.a aVar = new g.a(phraseActivity2);
            aVar.c(true);
            aVar.z(this.f5316e);
            aVar.s(new z0(this, phraseActivity2));
            aVar.t(R.string.confirm, new A0(this, phraseActivity2));
            aVar.m(R.string.no, null);
            this.f5315c = aVar.a();
        }

        static void f(b bVar) {
            miuix.appcompat.app.g gVar = bVar.f5315c;
            if (gVar == null || !gVar.isShowing()) {
                return;
            }
            bVar.f5315c.dismiss();
            bVar.f5315c = null;
        }

        public final void g() {
            PhraseActivity phraseActivity = this.f5317f.get();
            if (phraseActivity == null) {
                return;
            }
            g.a aVar = new g.a(phraseActivity);
            aVar.x(R.string.delete_phrase);
            aVar.j(R.string.phrase_confirm_delete_message);
            aVar.c(true);
            aVar.t(R.string.delete, new a(phraseActivity));
            aVar.m(R.string.no, null);
            aVar.A();
        }

        public final void h() {
            String str;
            int i2;
            PhraseActivity phraseActivity = this.f5317f.get();
            if (this.f5317f.get() == null) {
                return;
            }
            if (this.f5314b) {
                str = null;
                i2 = R.string.new_phrase;
            } else {
                str = (String) this.f5313a.first;
                i2 = R.string.edit_phrase;
            }
            this.d.setText(str);
            if (!TextUtils.isEmpty(str)) {
                this.d.setSelection(str.length());
            }
            this.f5315c.setTitle(phraseActivity.getResources().getString(i2));
            this.f5315c.show();
        }

        public final String i() {
            return (String) this.f5313a.first;
        }

        public final void j(int i2, String str) {
            if (str == null) {
                this.f5314b = true;
            } else {
                this.f5314b = false;
            }
            this.f5313a = new Pair<>(str, Integer.valueOf(i2));
        }
    }

    static void O(PhraseActivity phraseActivity, View view, int i2) {
        if (i2 - phraseActivity.f5309x.getHeaderViewsCount() < 0 || view.getParent() == null || phraseActivity.f5310y) {
            return;
        }
        phraseActivity.f5310y = true;
        view.showContextMenu();
    }

    @Override // miuix.appcompat.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        setResult(-1, null);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public final boolean onContextItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 1) {
            this.f5308w.h();
            return true;
        }
        if (itemId != 2) {
            return super.onContextItemSelected(menuItem);
        }
        this.f5308w.g();
        return true;
    }

    @Override // android.app.Activity
    public final void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
        this.f5310y = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.phrase_list_screen);
        this.f5308w = new b(this);
        this.f5307v = new P0.s(this, R.layout.phrase_list_item);
        ListView listView = (ListView) findViewById(R.id.expandable_list);
        this.f5309x = listView;
        listView.setAdapter((ListAdapter) this.f5307v);
        this.f5309x.setOnCreateContextMenuListener(this);
        this.f5309x.setOnItemClickListener(this.f5311z);
        TextView textView = (TextView) findViewById(R.id.empty);
        if (textView != null) {
            textView.setText(getResources().getString(R.string.phrase_empty));
            this.f5309x.setEmptyView(textView);
        }
        K().m(R.string.phrase_list_title);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        int i2 = ((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position;
        this.f5308w.j(i2, (String) this.f5307v.getItem(i2));
        contextMenu.setHeaderTitle(this.f5308w.i());
        contextMenu.add(0, 1, 0, getResources().getString(R.string.menu_edit));
        contextMenu.add(0, 2, 0, getResources().getString(R.string.delete_phrase));
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.phrase_action_options, menu);
        return true;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        b bVar = this.f5308w;
        if (bVar != null) {
            b.f(bVar);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super.onKeyDown(i2, keyEvent);
        }
        com.android.mmt.util.C.e(this);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            setResult(-1, null);
            finish();
            return true;
        }
        if (itemId != R.id.menu_phrase_new || this.f5307v.e()) {
            return false;
        }
        this.f5308w.j(-1, null);
        this.f5308w.h();
        return true;
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onStart() {
        super.onStart();
        this.f5307v.f();
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onStop() {
        super.onStop();
        this.f5307v.notifyDataSetInvalidated();
    }
}
