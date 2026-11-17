package P0;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.mmt.R;
import com.android.mmt.ui.PhraseListItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

/* loaded from: classes.dex */
public final class s extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f945a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f946b;

    /* renamed from: c, reason: collision with root package name */
    private a f947c;
    private final int d;

    private class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f948a;

        /* renamed from: b, reason: collision with root package name */
        private final String f949b;

        /* renamed from: c, reason: collision with root package name */
        private SharedPreferences f950c;
        private Vector<String> d;

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00fa, code lost:
        
            if (r0 == null) goto L41;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v21, types: [java.util.Vector, java.util.Vector<java.lang.String>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(s sVar) throws Throwable {
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2;
            SharedPreferences sharedPreferencesC = androidx.preference.g.c(sVar.f945a);
            this.f950c = sharedPreferencesC;
            int i2 = sharedPreferencesC.getInt("sms_phrase_version", 1);
            if (i2 != 2) {
                Y1.a.c("Upgrading phrase data from ver %d to %d", Integer.valueOf(i2), 2);
                if (i2 == 1) {
                    String string = this.f950c.getString("sms_phrase_data_zh_TW", "");
                    if (!string.isEmpty()) {
                        this.f950c.edit().putString("sms_phrase_data_zh_TW", string.replaceAll("稍後回複", "稍後回覆")).apply();
                    }
                }
                this.f950c.edit().putInt("sms_phrase_version", 2).apply();
            }
            String language = Locale.getDefault().getLanguage();
            String country = Locale.getDefault().getCountry();
            String str = "sms_phrase_data_count_" + language + "_" + country;
            this.f948a = str;
            String str2 = "sms_phrase_data_" + language + "_" + country;
            this.f949b = str2;
            String string2 = this.f950c.getString(str2, "");
            if (this.f950c.getInt(str, -1) != -1) {
                this.d = new Vector<>();
                StringTokenizer stringTokenizer = new StringTokenizer(string2, "\t");
                while (stringTokenizer.hasMoreTokens()) {
                    this.d.add(stringTokenizer.nextToken());
                }
                return;
            }
            this.d = new Vector<>();
            BufferedReader bufferedReader3 = null;
            BufferedReader bufferedReader4 = null;
            bufferedReader3 = null;
            bufferedReader3 = null;
            bufferedReader3 = null;
            try {
                try {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(sVar.f945a.getResources().openRawResource(R.raw.sms_frequently_used_phrase)));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                ?? r02 = this.d;
                                r02.add(line);
                                bufferedReader4 = r02;
                            } catch (Resources.NotFoundException e2) {
                                e = e2;
                                bufferedReader3 = bufferedReader;
                                e.printStackTrace();
                                bufferedReader2 = bufferedReader3;
                            } catch (IOException e4) {
                                e = e4;
                                bufferedReader3 = bufferedReader;
                                e.printStackTrace();
                                if (bufferedReader3 != null) {
                                    bufferedReader2 = bufferedReader3;
                                    bufferedReader2.close();
                                    bufferedReader3 = bufferedReader2;
                                }
                                e();
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                        bufferedReader.close();
                        bufferedReader3 = bufferedReader4;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                } catch (Resources.NotFoundException e7) {
                    e = e7;
                } catch (IOException e8) {
                    e = e8;
                }
                e();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader3;
            }
        }

        private void e() {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.d.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\t");
            }
            if (sb.length() != 0) {
                sb.delete(sb.lastIndexOf("\t"), sb.length());
            }
            SharedPreferences.Editor editorEdit = this.f950c.edit();
            editorEdit.putString(this.f949b, sb.toString());
            editorEdit.putInt(this.f948a, this.d.size());
            editorEdit.apply();
        }

        public final void a(String str) {
            this.d.add(0, str);
            e();
        }

        public final void b(int i2) {
            if (i2 < 0 || i2 >= this.d.size()) {
                return;
            }
            this.d.remove(i2);
            e();
        }

        public final int c() {
            return this.d.size();
        }

        public final String d(int i2) {
            if (i2 < 0 || i2 >= this.d.size()) {
                return null;
            }
            return this.d.get(i2);
        }

        public final void f(int i2, String str) {
            if (i2 < 0 || i2 >= this.d.size()) {
                return;
            }
            this.d.set(i2, str);
            e();
        }
    }

    public s(Context context, int i2) {
        this.f945a = context;
        this.d = i2;
        this.f946b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final void c(String str) {
        a aVar = this.f947c;
        if (aVar == null) {
            return;
        }
        aVar.a(str);
        notifyDataSetChanged();
    }

    public final void d(int i2) {
        a aVar = this.f947c;
        if (aVar == null) {
            return;
        }
        aVar.b(i2);
        notifyDataSetChanged();
    }

    public final boolean e() {
        a aVar = this.f947c;
        return aVar != null && aVar.c() > 50;
    }

    public final void f() {
        this.f947c = new a(this);
        notifyDataSetChanged();
    }

    public final void g(int i2, String str) {
        a aVar = this.f947c;
        if (aVar == null) {
            return;
        }
        aVar.f(i2, str);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        a aVar = this.f947c;
        if (aVar == null) {
            return 0;
        }
        return aVar.c();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        a aVar = this.f947c;
        if (aVar == null) {
            return null;
        }
        return aVar.d(i2);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (this.f947c == null) {
            return null;
        }
        if (view == null) {
            view = this.f946b.inflate(this.d, viewGroup, false);
        }
        if (!(view instanceof PhraseListItem)) {
            return null;
        }
        ((PhraseListItem) view).a(this.f947c.d(i2));
        return view;
    }
}
