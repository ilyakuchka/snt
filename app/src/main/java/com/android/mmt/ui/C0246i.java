package com.android.mmt.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.android.mmt.ui.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0246i extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    private static List<a> f5600b = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private LayoutInflater f5601a;

    /* renamed from: com.android.mmt.ui.i$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f5602a;

        /* renamed from: b, reason: collision with root package name */
        public int f5603b;

        /* renamed from: c, reason: collision with root package name */
        public int f5604c;

        public a(int i2, int i4, int i5) {
            this.f5602a = i2;
            this.f5603b = i4;
            this.f5604c = i5;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    public C0246i(Context context) {
        this.f5601a = (LayoutInflater) context.getSystemService("layout_inflater");
        Log.v("AttachmentTypeAdapter", "init");
        synchronized (f5600b) {
            if (f5600b.size() == 0) {
                Log.v("AttachmentTypeAdapter", "init add");
                f5600b.add(new a(0, R.string.add_smiley, R.drawable.ic_attach_smiley));
                f5600b.add(new a(1, R.string.add_miui_contact, R.drawable.ic_attach_contact));
                f5600b.add(new a(2, R.string.attach_image, R.drawable.ic_attach_photo));
                f5600b.add(new a(3, R.string.attach_take_photo, R.drawable.ic_attach_take_photo));
                f5600b.add(new a(4, R.string.bookmark_list_title, R.drawable.ic_attach_phrase));
                f5600b.add(new a(7, R.string.attach_subject, R.drawable.ic_attach_subject));
                f5600b.add(new a(8, R.string.attach_sound, R.drawable.ic_attach_sound));
                f5600b.add(new a(9, R.string.attach_video, R.drawable.ic_attach_video));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    public static a b(int i2) {
        a aVar;
        synchronized (f5600b) {
            aVar = (a) f5600b.get(i2);
        }
        return aVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.i$a>] */
    @Override // android.widget.Adapter
    public final int getCount() {
        int size;
        synchronized (f5600b) {
            size = f5600b.size();
        }
        return size;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5601a.inflate(R.layout.attachment_type_grid_item, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.attachment_type_name);
        ImageView imageView = (ImageView) view.findViewById(R.id.attachment_type_icon);
        a aVarB = b(i2);
        textView.setText(aVarB.f5603b);
        imageView.setImageResource(aVarB.f5604c);
        return view;
    }
}
