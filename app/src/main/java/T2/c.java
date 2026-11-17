package T2;

import T2.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.net.Uri;
import android.os.SystemClock;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c extends AnimationDrawable {

    /* renamed from: j, reason: collision with root package name */
    private Resources f1573j;

    /* renamed from: k, reason: collision with root package name */
    private DrawableContainer.DrawableContainerState f1574k;

    /* renamed from: n, reason: collision with root package name */
    private int f1577n;

    /* renamed from: i, reason: collision with root package name */
    private final b f1572i = new b();

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<Integer> f1575l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<Integer> f1576m = new ArrayList<>();

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    public final boolean a(Context context, Uri uri) {
        Resources resources = context.getResources();
        e eVar = new e(context, uri);
        this.f1573j = resources;
        this.f1572i.f1565f = eVar;
        b.C0038b c0038bB = b.b(eVar, 1048576L, 0);
        d dVar = c0038bB.f1567a;
        if (dVar == null || !c0038bB.f1568b) {
            return false;
        }
        this.f1572i.d = dVar.f();
        int iD = dVar.d();
        if (iD <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < iD; i2++) {
            if (this.f1572i.d) {
                addFrame(new BitmapDrawable(this.f1573j, dVar.c(i2)), dVar.b(i2));
            } else {
                this.f1572i.f1561a.add(new b.c(dVar.c(i2), dVar.b(i2), i2));
            }
        }
        b bVar = this.f1572i;
        if (!bVar.d) {
            bVar.d();
            b.c cVar = (b.c) this.f1572i.f1561a.get(0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f1573j, cVar.f1569a);
            addFrame(bitmapDrawable, cVar.f1570b);
            addFrame(bitmapDrawable, cVar.f1570b);
        }
        setOneShot(false);
        super.selectDrawable(0);
        return true;
    }

    @Override // android.graphics.drawable.AnimationDrawable
    public final void addFrame(Drawable drawable, int i2) {
        super.addFrame(drawable, i2);
        this.f1575l.add(Integer.valueOf(i2));
        this.f1576m.add(Integer.valueOf(i2));
    }

    @Override // android.graphics.drawable.AnimationDrawable
    public final int getDuration(int i2) {
        return this.f1575l.get(i2).intValue();
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j2) {
        if (j2 == SystemClock.uptimeMillis() + this.f1576m.get(this.f1577n).intValue()) {
            j2 = SystemClock.uptimeMillis() + this.f1575l.get(this.f1577n).intValue();
        }
        super.scheduleSelf(runnable, j2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    @Override // android.graphics.drawable.DrawableContainer
    public final boolean selectDrawable(int i2) {
        if (!this.f1572i.f1561a.isEmpty()) {
            b.c cVar = (b.c) this.f1572i.f1561a.get(0);
            if (this.f1572i.f1561a.size() > 1) {
                this.f1572i.f1561a.remove(0);
            }
            this.f1572i.c();
            this.f1574k.getChildren()[i2] = new BitmapDrawable(this.f1573j, cVar.f1569a);
            this.f1575l.add(i2, Integer.valueOf(cVar.f1570b));
        }
        this.f1577n = i2;
        return super.selectDrawable(i2);
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.DrawableContainer
    protected final void setConstantState(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        this.f1574k = drawableContainerState;
    }
}
