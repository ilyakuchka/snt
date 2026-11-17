package Y0;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class s extends Exception {

    /* renamed from: n, reason: collision with root package name */
    private static final StackTraceElement[] f2049n = new StackTraceElement[0];

    /* renamed from: i, reason: collision with root package name */
    private final List<Throwable> f2050i;

    /* renamed from: j, reason: collision with root package name */
    private V0.f f2051j;

    /* renamed from: k, reason: collision with root package name */
    private V0.a f2052k;

    /* renamed from: l, reason: collision with root package name */
    private Class<?> f2053l;

    /* renamed from: m, reason: collision with root package name */
    private String f2054m;

    public s(String str) {
        this(str, Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        if (!(th instanceof s)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((s) th).f2050i.iterator();
        while (it.hasNext()) {
            a(it.next(), list);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            a aVar = (a) appendable;
            aVar.append("Cause (");
            int i4 = i2 + 1;
            aVar.append(String.valueOf(i4));
            aVar.append(" of ");
            aVar.append(String.valueOf(size));
            aVar.append("): ");
            Throwable th = list.get(i2);
            if (th instanceof s) {
                ((s) th).f(appendable);
            } else {
                d(th, appendable);
            }
            i2 = i4;
        }
    }

    private static void d(Throwable th, Appendable appendable) throws IOException {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void f(Appendable appendable) throws IOException {
        d(this, appendable);
        b(this.f2050i, new a(appendable));
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sbD = D2.e.d("Root cause (");
            int i4 = i2 + 1;
            sbD.append(i4);
            sbD.append(" of ");
            sbD.append(size);
            sbD.append(")");
            Log.i("Glide", sbD.toString(), (Throwable) arrayList.get(i2));
            i2 = i4;
        }
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }

    final void g(V0.f fVar, V0.a aVar) {
        this.f2051j = fVar;
        this.f2052k = aVar;
        this.f2053l = null;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String string;
        String string2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f2054m);
        String string3 = "";
        if (this.f2053l != null) {
            StringBuilder sbD = D2.e.d(", ");
            sbD.append(this.f2053l);
            string = sbD.toString();
        } else {
            string = "";
        }
        sb.append(string);
        if (this.f2052k != null) {
            StringBuilder sbD2 = D2.e.d(", ");
            sbD2.append(this.f2052k);
            string2 = sbD2.toString();
        } else {
            string2 = "";
        }
        sb.append(string2);
        if (this.f2051j != null) {
            StringBuilder sbD3 = D2.e.d(", ");
            sbD3.append(this.f2051j);
            string3 = sbD3.toString();
        }
        sb.append(string3);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" causes:");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Throwable th = (Throwable) it.next();
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    final void h(V0.f fVar, V0.a aVar, Class<?> cls) {
        this.f2051j = fVar;
        this.f2052k = aVar;
        this.f2053l = cls;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() throws IOException {
        f(System.err);
    }

    public s(String str, List<Throwable> list) {
        this.f2054m = str;
        setStackTrace(f2049n);
        this.f2050i = list;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) throws IOException {
        f(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) throws IOException {
        f(printWriter);
    }

    private static final class a implements Appendable {

        /* renamed from: i, reason: collision with root package name */
        private final Appendable f2055i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f2056j = true;

        a(Appendable appendable) {
            this.f2055i = appendable;
        }

        @Override // java.lang.Appendable
        public final Appendable append(char c2) throws IOException {
            if (this.f2056j) {
                this.f2056j = false;
                this.f2055i.append("  ");
            }
            this.f2056j = c2 == '\n';
            this.f2055i.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            append(charSequence, 0, charSequence.length());
            return this;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i2, int i4) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z4 = false;
            if (this.f2056j) {
                this.f2056j = false;
                this.f2055i.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i4 - 1) == '\n') {
                z4 = true;
            }
            this.f2056j = z4;
            this.f2055i.append(charSequence, i2, i4);
            return this;
        }
    }
}
