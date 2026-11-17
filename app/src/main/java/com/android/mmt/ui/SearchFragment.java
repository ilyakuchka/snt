package com.android.mmt.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.ActivityC0219o;
import androidx.fragment.app.Fragment;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import g0.C0309e;
import g0.C0319o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public class SearchFragment extends Fragment implements View.OnTouchListener {

    /* renamed from: c0, reason: collision with root package name */
    private TextView f5384c0;

    /* renamed from: d0, reason: collision with root package name */
    private ListView f5385d0;

    /* renamed from: e0, reason: collision with root package name */
    private ActivityC0219o f5386e0;

    /* renamed from: g0, reason: collision with root package name */
    private c f5388g0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f5387f0 = false;

    /* renamed from: h0, reason: collision with root package name */
    Handler f5389h0 = new Handler();

    /* renamed from: i0, reason: collision with root package name */
    Runnable f5390i0 = new a();

    @SuppressLint({"AppCompatCustomView"})
    public static class TextViewSnippet extends TextView {

        /* renamed from: i, reason: collision with root package name */
        private String f5391i;

        /* renamed from: j, reason: collision with root package name */
        private String[] f5392j;

        /* renamed from: k, reason: collision with root package name */
        private int f5393k;

        public TextViewSnippet(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final void a(String str, String str2, int i2) {
            this.f5391i = str;
            this.f5392j = str2.split(" +");
            this.f5393k = i2;
            requestLayout();
        }

        @Override // android.widget.TextView, android.view.View
        protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
            String strSubstring;
            String[] strArr = this.f5392j;
            if (strArr == null || strArr.length == 0) {
                setText(this.f5391i);
                super.onLayout(z4, i2, i4, i5, i6);
                return;
            }
            String lowerCase = strArr[0].toLowerCase();
            String lowerCase2 = this.f5391i.toLowerCase();
            int iIndexOf = lowerCase2.indexOf(lowerCase);
            if (this.f5393k == 0 || iIndexOf == -1 || lowerCase.length() > lowerCase2.length()) {
                setText(this.f5391i);
                super.onLayout(z4, i2, i4, i5, i6);
                return;
            }
            TextPaint paint = getPaint();
            float fMeasureText = paint.measureText(lowerCase);
            float fMeasureText2 = paint.measureText(this.f5391i);
            float width = getWidth();
            if (fMeasureText > width) {
                strSubstring = this.f5391i.substring(iIndexOf, lowerCase.length() + iIndexOf);
            } else if (fMeasureText2 <= width) {
                strSubstring = this.f5391i;
            } else {
                float fMeasureText3 = width - (paint.measureText("…") * 2.0f);
                int length = lowerCase.length() + iIndexOf;
                float fMeasureText4 = paint.measureText(this.f5391i, iIndexOf, length);
                while (fMeasureText4 < fMeasureText3 && (iIndexOf > 0 || length < lowerCase2.length())) {
                    if (iIndexOf > 0) {
                        iIndexOf--;
                        fMeasureText4 = paint.measureText(this.f5391i, iIndexOf, iIndexOf + 1) + fMeasureText4;
                    }
                    if (length < lowerCase2.length()) {
                        length++;
                        fMeasureText4 += paint.measureText(this.f5391i, length - 1, length);
                    }
                }
                Object[] objArr = new Object[3];
                objArr[0] = iIndexOf == 0 ? "" : "…";
                objArr[1] = this.f5391i.substring(iIndexOf, length);
                objArr[2] = length == lowerCase2.length() ? "" : "…";
                strSubstring = String.format("%s%s%s", objArr);
            }
            com.android.mmt.util.e0.j(this, strSubstring, this.f5392j[0], this.f5393k);
            super.onLayout(z4, i2, i4, i5, i6);
        }
    }

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SearchFragment.this.f5388g0.v()) {
                return;
            }
            SearchFragment.this.f5388g0.w();
        }
    }

    final class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Intent intentU;
            int headerViewsCount = i2 - SearchFragment.this.f5385d0.getHeaderViewsCount();
            if (headerViewsCount < 0 || (intentU = SearchFragment.this.f5388g0.u(headerViewsCount)) == null) {
                return;
            }
            if (intentU.getBooleanExtra("is_verification_code", false)) {
                SearchFragment.this.b1(intentU);
            } else {
                ComposeMessageRouterActivity.e(SearchFragment.this.f5386e0, intentU);
            }
            SearchFragment.this.f5387f0 = true;
        }
    }

    class c extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private String f5396a;

        /* renamed from: b, reason: collision with root package name */
        private int f5397b;

        /* renamed from: c, reason: collision with root package name */
        private int f5398c;
        private int d;

        /* renamed from: e, reason: collision with root package name */
        private int f5399e;

        /* renamed from: f, reason: collision with root package name */
        private int f5400f;
        private Cursor g;

        /* renamed from: h, reason: collision with root package name */
        private ArrayList<C0416c> f5401h;

        /* renamed from: i, reason: collision with root package name */
        private ArrayList<C0416c> f5402i;

        /* renamed from: j, reason: collision with root package name */
        private ArrayList<Integer> f5403j;

        /* renamed from: k, reason: collision with root package name */
        private HashSet<String> f5404k;

        /* renamed from: l, reason: collision with root package name */
        private C0415b f5405l;

        /* renamed from: m, reason: collision with root package name */
        private HashSet<C0416c> f5406m = S2.d.l(new C0416c[0]);

        /* renamed from: n, reason: collision with root package name */
        private AsyncTask<Void, Void, Void> f5407n = null;

        final class a extends AsyncTask<Void, Void, Void> {

            /* renamed from: a, reason: collision with root package name */
            private ArrayList<C0416c> f5409a;

            /* renamed from: b, reason: collision with root package name */
            private ArrayList<C0416c> f5410b;

            /* renamed from: c, reason: collision with root package name */
            private LongSparseArray<ArrayList<Integer>> f5411c;
            private ArrayList<Long> d;

            /* renamed from: e, reason: collision with root package name */
            private C0415b f5412e;

            /* renamed from: f, reason: collision with root package name */
            private HashSet<String> f5413f;
            private Cursor g;

            /* renamed from: h, reason: collision with root package name */
            private String f5414h;

            a() {
                this.f5414h = c.this.f5396a;
            }

            @Override // android.os.AsyncTask
            protected final Void doInBackground(Void[] voidArr) {
                if (TextUtils.isEmpty(this.f5414h)) {
                    return null;
                }
                Cursor cursorE = com.android.mmt.util.O.e(SearchFragment.this.f5386e0, SearchFragment.this.f5386e0.getContentResolver(), Telephony.MmsSms.SEARCH_URI.buildUpon().appendQueryParameter("pattern", this.f5414h).build(), null, null, null, null);
                this.g = cursorE;
                if (cursorE == null || c.this.f5407n != this) {
                    return null;
                }
                int columnIndex = this.g.getColumnIndex("thread_id");
                this.f5409a = new ArrayList<>();
                this.f5411c = new LongSparseArray<>();
                this.d = new ArrayList<>();
                this.g.moveToPosition(-1);
                int i2 = 0;
                while (this.g.moveToNext()) {
                    long j2 = this.g.getLong(columnIndex);
                    if (this.f5411c.indexOfKey(j2) >= 0) {
                        this.f5411c.get(j2).add(Integer.valueOf(i2));
                    } else {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        arrayList.add(Integer.valueOf(i2));
                        this.f5411c.put(j2, arrayList);
                        this.d.add(Long.valueOf(j2));
                    }
                    i2++;
                }
                Iterator<Long> it = this.d.iterator();
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    int size = this.f5411c.get(jLongValue).size();
                    C0416c c0416cV = C0416c.v(jLongValue);
                    for (int i4 = 0; i4 < size; i4++) {
                        this.f5409a.add(c0416cV);
                    }
                }
                this.f5410b = C0416c.X(SearchFragment.this.f5386e0, this.f5414h);
                HashSet hashSetL = S2.d.l(new String[0]);
                HashSet hashSetL2 = S2.d.l(new C0414a[0]);
                this.f5413f = S2.d.l(new String[0]);
                Iterator<C0416c> it2 = this.f5410b.iterator();
                while (it2.hasNext()) {
                    C0414a c0414a = it2.next().G().get(0);
                    String strU = c0414a.U();
                    hashSetL2.add(c0414a);
                    if (hashSetL.contains(strU)) {
                        this.f5413f.add(strU);
                    } else {
                        hashSetL.add(strU);
                    }
                }
                C0415b c0415bP0 = C0414a.p0(this.f5414h);
                this.f5412e = c0415bP0;
                c0415bP0.removeAll(hashSetL2);
                Iterator<C0414a> it3 = this.f5412e.iterator();
                while (it3.hasNext()) {
                    String strU2 = it3.next().U();
                    if (hashSetL.contains(strU2)) {
                        this.f5413f.add(strU2);
                    } else {
                        hashSetL.add(strU2);
                    }
                }
                return null;
            }

            @Override // android.os.AsyncTask
            protected final void onPostExecute(Void r7) {
                if (c.this.f5407n != this || !SearchFragment.this.W()) {
                    Cursor cursor = this.g;
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                c.this.f5407n = null;
                c.this.t();
                c.this.g = this.g;
                c.this.f5402i = this.f5410b;
                c.this.f5401h = this.f5409a;
                c.this.f5404k = this.f5413f;
                c.this.f5405l = this.f5412e;
                c.this.f5406m.clear();
                c.this.f5403j = new ArrayList();
                ArrayList<Long> arrayList = this.d;
                if (arrayList != null && this.f5411c != null) {
                    Iterator<Long> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Iterator<Integer> it2 = this.f5411c.get(it.next().longValue()).iterator();
                        while (it2.hasNext()) {
                            c.this.f5403j.add(Integer.valueOf(it2.next().intValue()));
                        }
                    }
                }
                if (c.this.g != null) {
                    c cVar = c.this;
                    cVar.f5397b = cVar.g.getColumnIndex("thread_id");
                    c cVar2 = c.this;
                    cVar2.f5398c = cVar2.g.getColumnIndex("body");
                    c cVar3 = c.this;
                    cVar3.d = cVar3.g.getColumnIndex("_id");
                    c cVar4 = c.this;
                    cVar4.f5399e = cVar4.g.getColumnIndex("date");
                    c cVar5 = c.this;
                    cVar5.f5400f = cVar5.g.getColumnIndex("msg_type");
                }
                SearchFragment.this.f5384c0.setText(SearchFragment.this.N().getQuantityString(R.plurals.search_results_title, c.this.getCount(), Integer.valueOf(c.this.getCount()), c.this.f5396a));
                c.this.notifyDataSetChanged();
            }
        }

        final class b implements View.OnClickListener {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ C0416c f5416i;

            b(C0416c c0416c) {
                this.f5416i = c0416c;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.f5406m.add(this.f5416i);
                c.this.notifyDataSetChanged();
            }
        }

        c() {
        }

        static void l(c cVar) {
            Objects.requireNonNull(cVar);
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            Cursor cursor = this.g;
            if (cursor == null || this.f5402i == null) {
                return 0;
            }
            return this.f5405l.size() + this.f5402i.size() + cursor.getCount();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i2) {
            return null;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
        @Override // android.widget.BaseAdapter, android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int getItemViewType(int i2) {
            boolean z4;
            boolean z5 = false;
            if (i2 < this.f5402i.size()) {
                return 0;
            }
            if (i2 >= this.f5401h.size() + this.f5402i.size()) {
                return 7;
            }
            int size = i2 - this.f5402i.size();
            C0416c c0416c = this.f5401h.get(size);
            int i4 = this.f5406m.contains(c0416c) ? 10000 : 5;
            boolean z6 = size == 0 || c0416c != this.f5401h.get(size + (-1));
            boolean z7 = size == this.g.getCount() - 1 || c0416c != this.f5401h.get(size + 1);
            int i5 = i4 - 1;
            if (size >= i5) {
                int i6 = size - i4;
                z4 = c0416c == this.f5401h.get(i6 + 1) && (size == i5 || c0416c != this.f5401h.get(i6));
            }
            if (z6) {
                return (z7 || z4) ? 1 : 2;
            }
            if (z4) {
                return z7 ? 3 : 4;
            }
            if (size >= i4 && c0416c == this.f5401h.get(size - i4)) {
                z5 = true;
            }
            if (z5) {
                return 6;
            }
            return z7 ? 3 : 5;
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (this.g == null || this.f5402i == null) {
                return null;
            }
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (!(view instanceof LinearLayout)) {
                    view = LayoutInflater.from(SearchFragment.this.f5386e0).inflate(R.layout.search_fragment_conversation_item, viewGroup, false);
                }
                TextViewSnippet textViewSnippet = (TextViewSnippet) view.findViewById(R.id.name);
                TextViewSnippet textViewSnippet2 = (TextViewSnippet) view.findViewById(R.id.number);
                TextView textView = (TextView) view.findViewById(R.id.count);
                C0416c c0416c = this.f5402i.get(i2);
                C0414a c0414a = c0416c.G().get(0);
                textViewSnippet.a(c0414a.U(), this.f5396a, R.style.TextAppearance_List_Primary_Highlight);
                if (this.f5404k.contains(c0414a.U()) || (c0414a.U().indexOf(this.f5396a) == -1 && c0414a.W().indexOf(this.f5396a) != -1)) {
                    textViewSnippet2.setVisibility(0);
                    textViewSnippet2.a(c0414a.W(), this.f5396a, R.style.TextAppearance_List_Secondary_Highlight);
                } else {
                    textViewSnippet2.setVisibility(8);
                }
                textView.setText(SearchFragment.this.N().getQuantityString(R.plurals.message_count, c0416c.C(), Integer.valueOf(c0416c.C())));
                return view;
            }
            if (itemViewType == 6) {
                return view != null ? view : new View(SearchFragment.this.f5386e0);
            }
            if (itemViewType == 7) {
                if (!(view instanceof LinearLayout)) {
                    view = LayoutInflater.from(SearchFragment.this.f5386e0).inflate(R.layout.search_fragment_contact_item, viewGroup, false);
                }
                TextViewSnippet textViewSnippet3 = (TextViewSnippet) view.findViewById(R.id.name);
                TextViewSnippet textViewSnippet4 = (TextViewSnippet) view.findViewById(R.id.number);
                C0414a c0414a2 = this.f5405l.get((i2 - this.f5402i.size()) - this.f5401h.size());
                textViewSnippet3.a(c0414a2.U(), this.f5396a, R.style.TextAppearance_List_Primary_Highlight);
                textViewSnippet4.setText(c0414a2.W());
                textViewSnippet4.measure(0, 0);
                textViewSnippet4.getLayoutParams().width = textViewSnippet4.getMeasuredWidth();
                textViewSnippet4.a(c0414a2.W(), this.f5396a, R.style.TextAppearance_List_Secondary_Highlight);
                return view;
            }
            if (!(view instanceof LinearLayout)) {
                view = LayoutInflater.from(SearchFragment.this.f5386e0).inflate(R.layout.search_fragment_message_item, viewGroup, false);
                TextView textView2 = (TextView) view.findViewById(R.id.name);
                View viewFindViewById = view.findViewById(R.id.divider);
                TextView textView3 = (TextView) view.findViewById(R.id.expander);
                if (itemViewType == 1) {
                    textView2.setVisibility(0);
                    viewFindViewById.setVisibility(0);
                    textView3.setVisibility(8);
                } else if (itemViewType == 2) {
                    textView2.setVisibility(0);
                    viewFindViewById.setVisibility(8);
                    textView3.setVisibility(8);
                } else if (itemViewType == 3) {
                    textView2.setVisibility(8);
                    viewFindViewById.setVisibility(0);
                    textView3.setVisibility(8);
                } else if (itemViewType == 4) {
                    textView2.setVisibility(8);
                    viewFindViewById.setVisibility(0);
                    textView3.setVisibility(0);
                } else if (itemViewType != 5) {
                    Y1.a.d("Invalid item type in search result", new Object[0]);
                } else {
                    textView2.setVisibility(8);
                    viewFindViewById.setVisibility(8);
                    textView3.setVisibility(8);
                }
            }
            TextView textView4 = (TextView) view.findViewById(R.id.name);
            TextViewSnippet textViewSnippet5 = (TextViewSnippet) view.findViewById(R.id.message);
            TextView textView5 = (TextView) view.findViewById(R.id.date);
            TextView textView6 = (TextView) view.findViewById(R.id.expander);
            int size = i2 - this.f5402i.size();
            this.g.moveToPosition(this.f5403j.get(size).intValue());
            C0416c c0416c2 = this.f5401h.get(size);
            if (textView4.getVisibility() == 0) {
                textView4.setText(c0416c2.y());
            }
            String string = this.g.getString(this.f5398c);
            textViewSnippet5.a((this.g.getInt(this.f5400f) != 2 || string == null) ? this.g.getString(this.f5398c) : !TextUtils.isEmpty(string) ? new C0309e(106, C0319o.d(string)).f() : SearchFragment.this.Q(R.string.no_subject_view), this.f5396a, R.style.TextAppearance_List_Secondary_Highlight);
            long j2 = this.g.getLong(this.f5399e);
            StringBuilder sb = new StringBuilder();
            C3.c.d(SearchFragment.this.f5386e0, sb, j2);
            textView5.setText(sb.toString());
            if (itemViewType != 4) {
                return view;
            }
            textView6.setOnClickListener(new b(c0416c2));
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final int getViewTypeCount() {
            return 8;
        }

        public final void t() {
            Cursor cursor = this.g;
            if (cursor != null) {
                cursor.close();
            }
            this.g = null;
            notifyDataSetInvalidated();
        }

        public final Intent u(int i2) {
            String string = null;
            if (this.g == null) {
                return null;
            }
            if (i2 < this.f5402i.size()) {
                return ComposeMessageRouterActivity.a(SearchFragment.this.f5386e0, this.f5402i.get(i2).I());
            }
            if (i2 >= this.f5401h.size() + this.f5402i.size()) {
                int size = (i2 - this.f5402i.size()) - this.f5401h.size();
                if (size >= this.f5405l.size()) {
                    return null;
                }
                String strW = this.f5405l.get(size).W();
                Intent intentA = ComposeMessageRouterActivity.a(SearchFragment.this.f5386e0, -1L);
                intentA.putExtra("address", strW);
                return intentA;
            }
            int size2 = i2 - this.f5402i.size();
            if (!this.g.moveToPosition(this.f5403j.get(size2).intValue())) {
                Y1.a.d(D2.e.b("SearchFragment failed to move cursor to position ", size2), new Object[0]);
                return null;
            }
            long j2 = this.g.getLong(this.f5397b);
            long j4 = this.g.getLong(this.d);
            String str = this.g.getInt(this.f5400f) == 1 ? "sms" : "mms";
            if (j4 < 0) {
                string = this.g.getString(this.f5398c);
                j4 = -j4;
            }
            Intent intent = new Intent("android.intent.action.VIEW", ComposeMessageRouterActivity.b(j2, P0.r.i(str, j4), this.f5396a, string));
            ComposeMessageRouterActivity.c(intent, j2);
            return intent;
        }

        public final boolean v() {
            return this.f5407n != null;
        }

        public final void w() {
            a aVar = new a();
            this.f5407n = aVar;
            aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        public final void x(String str) {
            this.f5396a = TextUtils.isEmpty(str) ? null : str.trim();
            a aVar = new a();
            this.f5407n = aVar;
            aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.search_fragment, viewGroup, false);
        this.f5386e0 = x();
        ListView listView = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f5385d0 = listView;
        listView.setFocusable(true);
        this.f5385d0.setFocusableInTouchMode(true);
        this.f5385d0.setOnTouchListener(this);
        TextView textView = (TextView) layoutInflater.inflate(R.layout.search_fragment_footer, (ViewGroup) null);
        this.f5384c0 = textView;
        this.f5385d0.addFooterView(textView, null, false);
        c cVar = new c();
        this.f5388g0 = cVar;
        this.f5385d0.setAdapter((ListAdapter) cVar);
        this.f5385d0.setOnItemClickListener(new b());
        this.f5385d0.setEmptyView(viewInflate.findViewById(R.id.empty));
        return viewInflate;
    }

    public final void h1(String str) {
        R0.a.b().a(str);
        this.f5388g0.x(str);
    }

    @Override // androidx.fragment.app.Fragment
    public final void i0() {
        c.l(this.f5388g0);
        this.f5388g0.t();
        super.i0();
    }

    public final void i1() {
        this.f5385d0.setSelection(0);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.f5385d0) {
            ((InputMethodManager) this.f5386e0.getSystemService("input_method")).hideSoftInputFromWindow(this.f5385d0.getWindowToken(), 0);
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void r0() {
        super.r0();
        if (this.f5387f0) {
            this.f5389h0.post(this.f5390i0);
        }
        this.f5387f0 = false;
        MmsApp.f4464t = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void s0() {
        super.s0();
    }
}
