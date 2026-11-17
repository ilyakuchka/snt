package com.android.mmt.ui;

import P0.C0155a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.android.mmt.R;
import com.android.mmt.util.C0273e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class AttachmentView extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private Context f4664i;

    /* renamed from: j, reason: collision with root package name */
    private ThumbnailView f4665j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f4666k;

    /* renamed from: l, reason: collision with root package name */
    private G0.p f4667l;

    /* renamed from: m, reason: collision with root package name */
    private Handler f4668m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f4669n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f4670o;
    private PopupWindow p;

    /* renamed from: q, reason: collision with root package name */
    private List<C0155a> f4671q;

    final class a implements AdapterView.OnItemClickListener {

        /* renamed from: com.android.mmt.ui.AttachmentView$a$a, reason: collision with other inner class name */
        final class RunnableC0091a implements Runnable {
            RunnableC0091a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AttachmentView.this.c();
            }
        }

        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            C0155a c0155a = (C0155a) AttachmentView.this.f4671q.get(i2);
            StringBuilder sbD = D2.e.d("attachmenrMenu id:");
            sbD.append(c0155a.a());
            Log.d("AttachmentView", sbD.toString());
            Message.obtain(AttachmentView.this.f4668m, c0155a.a()).sendToTarget();
            AttachmentView.this.f4668m.post(new RunnableC0091a());
        }
    }

    private class b extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private Context f4674a;

        /* renamed from: b, reason: collision with root package name */
        private List<C0155a> f4675b;

        public b(Context context, List<C0155a> list) {
            this.f4674a = context;
            this.f4675b = list;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            List<C0155a> list = this.f4675b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i2) {
            return this.f4675b.get(i2);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C0155a c0155a = this.f4675b.get(i2);
            if (view == null) {
                view = LayoutInflater.from(this.f4674a).inflate(R.layout.attachment_menu_item, (ViewGroup) null);
            }
            ((TextView) view.findViewById(R.id.attachment_menu_text)).setText(c0155a.b());
            return view;
        }
    }

    public AttachmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4664i = context;
        Resources resources = context.getResources();
        this.f4669n = resources.getDrawable(R.drawable.thumbnail_mask_default);
        this.f4670o = resources.getDrawable(R.drawable.thumbnail_mask_transparent);
    }

    private List<C0155a> d(Context context, int i2) {
        if (context == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Resources resources = context.getResources();
        if (i2 == 0) {
            arrayList.add(new C0155a(1, resources.getString(R.string.view)));
            arrayList.add(new C0155a(2, resources.getString(R.string.replace)));
            arrayList.add(new C0155a(3, resources.getString(R.string.remove)));
            return arrayList;
        }
        if (i2 == 1) {
            arrayList.add(new C0155a(4, resources.getString(R.string.play)));
            arrayList.add(new C0155a(5, resources.getString(R.string.replace)));
            arrayList.add(new C0155a(6, resources.getString(R.string.remove)));
            return arrayList;
        }
        if (i2 != 2) {
            if (i2 != 4) {
                return Collections.emptyList();
            }
            arrayList.add(new C0155a(13, resources.getString(R.string.remove)));
            return arrayList;
        }
        arrayList.add(new C0155a(7, resources.getString(R.string.play)));
        arrayList.add(new C0155a(8, resources.getString(R.string.replace)));
        arrayList.add(new C0155a(9, resources.getString(R.string.remove)));
        return arrayList;
    }

    private int e(int i2) {
        return (int) this.f4664i.getResources().getDimension(i2);
    }

    private void h(Drawable drawable, int i2, boolean z4) {
        this.f4665j.b(this.f4669n, 0);
        if (drawable == null) {
            this.f4665j.d(R.drawable.ic_missing_thumbnail_picture, true);
        } else {
            this.f4665j.f(null, this.f4670o);
            this.f4665j.e(i2);
            this.f4665j.c(drawable);
            C0273e.f(this.f4665j, drawable);
        }
        if (z4) {
            this.f4666k.setVisibility(0);
        } else {
            this.f4666k.setVisibility(8);
        }
    }

    public final void c() {
        PopupWindow popupWindow = this.p;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.p.dismiss();
    }

    public final boolean f() {
        PopupWindow popupWindow = this.p;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return false;
        }
        c();
        return true;
    }

    public final void g(Handler handler) {
        this.f4668m = handler;
    }

    public final void i(View view) {
        List<C0155a> list = this.f4671q;
        if (list == null || list.size() == 0) {
            return;
        }
        PopupWindow popupWindow = this.p;
        if (popupWindow == null || !popupWindow.isShowing()) {
            View viewInflate = LayoutInflater.from(this.f4664i).inflate(R.layout.attachment_menu, (ViewGroup) null);
            this.p = new PopupWindow(viewInflate, -2, -2);
            ListView listView = (ListView) viewInflate.findViewById(R.id.menu_list);
            listView.setAdapter((ListAdapter) new b(view.getContext(), this.f4671q));
            listView.setOnItemClickListener(new a());
            listView.setOverScrollMode(2);
            this.p.setBackgroundDrawable(new BitmapDrawable());
            this.p.setOutsideTouchable(true);
            listView.measure(0, 0);
            Drawable background = viewInflate.getBackground();
            Rect rect = new Rect();
            if (background != null) {
                background.getPadding(rect);
            }
            this.p.setHeight((this.f4671q.size() * listView.getMeasuredHeight()) + rect.top + rect.bottom);
            int length = 0;
            for (C0155a c0155a : this.f4671q) {
                if (c0155a.b().length() > length) {
                    length = c0155a.b().length();
                }
            }
            int iE = (length * e(R.dimen.attachment_menu_item_text_size)) + e(R.dimen.attachment_menu_text_space);
            this.p.setWidth(iE);
            this.p.showAsDropDown(view, (view.getMeasuredWidth() - iE) / 2, 0 - e(R.dimen.attachment_menu_margin_top));
        }
    }

    public final void j(x0.j jVar) {
        if (!jVar.A()) {
            setVisibility(8);
            return;
        }
        this.f4665j.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f4665j.e(0);
        this.f4667l = jVar.u();
        Bitmap frameAtTime = null;
        if (jVar.B()) {
            this.f4665j.b(null, 0);
            this.f4665j.d(R.drawable.ic_attachment_slideshow, false);
            this.f4665j.setContentDescription(this.f4664i.getString(R.string.attach_slideshow));
            this.f4671q = d(this.f4664i, 3);
            this.f4666k.setVisibility(8);
            setVisibility(0);
            return;
        }
        if (this.f4667l.G() == 1) {
            if (!this.f4667l.x().get(0).s()) {
                throw new IllegalStateException("Unsupported attachment type");
            }
            this.f4665j.setImageResource(R.drawable.flatshow_vcard_btn);
            this.f4665j.setContentDescription(this.f4664i.getString(R.string.type_vcard));
            this.f4671q = d(this.f4664i, 4);
            this.f4666k.setVisibility(8);
            setVisibility(0);
            return;
        }
        G0.o oVar = this.f4667l.get(0);
        if (oVar.A()) {
            G0.i iVarV = oVar.v();
            h(iVarV.F(), iVarV.G(), false);
            this.f4665j.setContentDescription(this.f4664i.getString(R.string.attach_image));
            this.f4671q = d(this.f4664i, 0);
            this.f4666k.setVisibility(8);
            setVisibility(0);
            return;
        }
        if (!oVar.C()) {
            if (oVar.z()) {
                G0.a aVarT = oVar.t();
                this.f4665j.b(null, 0);
                this.f4665j.setImageResource(R.drawable.ic_audio_attachment);
                this.f4665j.setContentDescription(this.f4664i.getString(R.string.attach_sound));
                this.f4671q = d(this.f4664i, 2);
                this.f4666k.setVisibility(8);
                setVisibility(0);
                aVarT.t();
                return;
            }
            return;
        }
        Uri uriU = oVar.y().u();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(getContext(), uriU);
            frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
        } catch (RuntimeException unused) {
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (IOException | RuntimeException unused2) {
            }
            throw th;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (IOException | RuntimeException unused3) {
        }
        h(new BitmapDrawable(getContext().getResources(), frameAtTime), 0, true);
        this.f4665j.setContentDescription(this.f4664i.getString(R.string.attach_video));
        this.f4671q = d(this.f4664i, 1);
        this.f4666k.setVisibility(0);
        setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        ThumbnailView thumbnailView = (ThumbnailView) findViewById(R.id.attachment_image);
        this.f4665j = thumbnailView;
        thumbnailView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f4666k = (ImageView) findViewById(R.id.play_icon);
    }
}
