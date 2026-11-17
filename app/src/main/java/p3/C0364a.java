package p3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mmt.R;

/* renamed from: p3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0364a extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    protected CharSequence[] f7587a;

    /* renamed from: b, reason: collision with root package name */
    protected CharSequence[] f7588b;

    /* renamed from: c, reason: collision with root package name */
    protected Drawable[] f7589c;
    private LayoutInflater d;

    /* renamed from: p3.a$b */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        ImageView f7590a;

        /* renamed from: b, reason: collision with root package name */
        TextView f7591b;

        /* renamed from: c, reason: collision with root package name */
        TextView f7592c;

        private b() {
        }

        b(C0133a c0133a) {
        }
    }

    protected C0364a(Context context) {
        super(context, 0);
        this.d = LayoutInflater.from(context);
    }

    public final CharSequence[] b() {
        return this.f7587a;
    }

    public final void c(int[] iArr) {
        if (iArr == null) {
            this.f7589c = null;
            return;
        }
        Drawable[] drawableArr = new Drawable[iArr.length];
        Resources resources = getContext().getResources();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] > 0) {
                drawableArr[i2] = resources.getDrawable(iArr[i2]);
            } else {
                drawableArr[i2] = null;
            }
        }
        this.f7589c = drawableArr;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final int getCount() {
        CharSequence[] charSequenceArr = this.f7587a;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        Drawable drawable = null;
        if (view == null || view.getTag(R.id.tag_spinner_dropdown_view_double_line) == null) {
            view = this.d.inflate(R.layout.miuix_appcompat_spiner_dropdown_view_double_line, viewGroup, false);
            b bVar = new b(null);
            bVar.f7590a = (ImageView) view.findViewById(android.R.id.icon);
            bVar.f7591b = (TextView) view.findViewById(android.R.id.title);
            bVar.f7592c = (TextView) view.findViewById(android.R.id.summary);
            view.setTag(R.id.tag_spinner_dropdown_view_double_line, bVar);
        }
        CharSequence[] charSequenceArr = this.f7587a;
        CharSequence charSequence = (charSequenceArr == null || i2 >= charSequenceArr.length) ? null : charSequenceArr[i2];
        CharSequence[] charSequenceArr2 = this.f7588b;
        CharSequence charSequence2 = (charSequenceArr2 == null || i2 >= charSequenceArr2.length) ? null : charSequenceArr2[i2];
        Drawable[] drawableArr = this.f7589c;
        if (drawableArr != null && i2 < drawableArr.length) {
            drawable = drawableArr[i2];
        }
        Object tag = view.getTag(R.id.tag_spinner_dropdown_view_double_line);
        if (tag != null) {
            b bVar2 = (b) tag;
            if (TextUtils.isEmpty(charSequence)) {
                bVar2.f7591b.setVisibility(8);
            } else {
                bVar2.f7591b.setText(charSequence);
                bVar2.f7591b.setVisibility(0);
            }
            if (TextUtils.isEmpty(charSequence2)) {
                bVar2.f7592c.setVisibility(8);
            } else {
                bVar2.f7592c.setText(charSequence2);
                bVar2.f7592c.setVisibility(0);
            }
            if (drawable != null) {
                bVar2.f7590a.setImageDrawable(drawable);
                bVar2.f7590a.setVisibility(0);
            } else {
                bVar2.f7590a.setVisibility(8);
            }
        }
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final Object getItem(int i2) {
        CharSequence[] charSequenceArr = this.f7587a;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i2];
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
