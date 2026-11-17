package com.android.mmt.ui;

import P0.C0157c;
import P0.InterfaceC0164j;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.mmt.R;
import com.android.mmt.ui.I0;
import com.android.mmt.util.C0273e;
import com.android.mmt.util.C0283o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public class SlideshowActivity extends miuix.appcompat.app.h implements Z3.a, InterfaceC0164j {

    /* renamed from: A, reason: collision with root package name */
    private static final String[] f5434A = {"sub", "sub_cs", "date", "date_sent"};

    /* renamed from: v, reason: collision with root package name */
    private ListView f5435v;

    /* renamed from: w, reason: collision with root package name */
    private a f5436w;

    /* renamed from: x, reason: collision with root package name */
    private miuix.appcompat.app.b f5437x;

    /* renamed from: y, reason: collision with root package name */
    private String f5438y;

    /* renamed from: z, reason: collision with root package name */
    private Runnable f5439z;

    /* JADX INFO: Access modifiers changed from: private */
    class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private G0 f5440a;

        /* renamed from: b, reason: collision with root package name */
        private String f5441b;

        /* renamed from: c, reason: collision with root package name */
        private ArrayList<Object> f5442c = new ArrayList<>();
        private float d;

        /* renamed from: com.android.mmt.ui.SlideshowActivity$a$a, reason: collision with other inner class name */
        final class ViewOnClickListenerC0100a implements View.OnClickListener {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ I0 f5444i;

            ViewOnClickListenerC0100a(I0 i02) {
                this.f5444i = i02;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Intent intentB = this.f5444i.B();
                try {
                    SlideshowActivity.this.startActivity(intentB);
                } catch (ActivityNotFoundException unused) {
                    intentB.setPackage("");
                    SlideshowActivity.this.startActivity(intentB);
                }
            }
        }

        final class b implements View.OnLongClickListener {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ I0 f5446i;

            /* renamed from: com.android.mmt.ui.SlideshowActivity$a$b$a, reason: collision with other inner class name */
            final class RunnableC0101a implements Runnable {
                RunnableC0101a() {
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() throws Throwable {
                    boolean z4;
                    b bVar = b.this;
                    H0 h02 = new H0(this, bVar.f5446i);
                    SlideshowActivity slideshowActivity = SlideshowActivity.this;
                    String[] strArr = {"android.permission.READ_MEDIA_IMAGES"};
                    String[] strArr2 = com.android.mmt.util.A.f5835a;
                    if (slideshowActivity != null) {
                        z4 = true;
                        if (!O2.a.a() ? com.android.mmt.util.A.k(slideshowActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1029) : com.android.mmt.util.A.k(slideshowActivity, strArr, 1029)) {
                        }
                        if (z4) {
                            SlideshowActivity.this.f5439z = h02;
                            return;
                        } else {
                            h02.run();
                            return;
                        }
                    }
                    Log.e("PermissionUtils", "checkPermission: context is null");
                    z4 = false;
                    if (z4) {
                    }
                }
            }

            b(I0 i02) {
                this.f5446i = i02;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                C0157c c0157c = new C0157c(SlideshowActivity.this);
                c0157c.b(R.string.copy_to_sdcard, new RunnableC0101a());
                c0157c.f();
                return true;
            }
        }

        public a(Uri uri) {
            G0 g02 = new G0(SlideshowActivity.this);
            this.f5440a = g02;
            g02.p(uri);
            this.f5441b = uri.getLastPathSegment();
            boolean zN = this.f5440a.n();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < this.f5440a.k()) {
                P0.E eI = this.f5440a.i(i2);
                if (eI != null) {
                    for (int i4 = 0; i4 < eI.d(); i4++) {
                        I0 i0C = eI.c(i4);
                        if (zN && i0C.y() == 0) {
                            this.f5442c.add(i0C);
                        } else if (zN || !(i0C.y() == 1 || i0C.y() == 2)) {
                            arrayList.add(i0C);
                        } else {
                            this.f5442c.add(i0C);
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.f5442c.addAll(arrayList);
                    }
                    arrayList.clear();
                }
                i2++;
                this.f5442c.add(Integer.valueOf(i2));
            }
        }

        public final void c(float f4) {
            this.d = f4;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return this.f5442c.size();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i2) {
            return this.f5442c.get(i2);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final int getItemViewType(int i2) {
            Object obj = this.f5442c.get(i2);
            if (obj instanceof Integer) {
                return 0;
            }
            if (obj instanceof I0) {
                return ((I0) obj).y() == 0 ? 1 : 2;
            }
            throw new IllegalStateException("Cannot recognize flatshow view type");
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) throws Resources.NotFoundException, IOException {
            TextView textView;
            Drawable drawableZ;
            View view2;
            final ImageView imageView;
            Object obj = this.f5442c.get(i2);
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(SlideshowActivity.this);
            ImageView imageView2 = null;
            int iC = 0;
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                View viewInflate = view;
                if (view == null) {
                    viewInflate = layoutInflaterFrom.inflate(R.layout.flatshow_dividing_line, (ViewGroup) null, false);
                }
                int dimensionPixelOffset = SlideshowActivity.this.getResources().getDimensionPixelOffset(R.dimen.flatshow_padding_left);
                int dimensionPixelOffset2 = SlideshowActivity.this.getResources().getDimensionPixelOffset(R.dimen.flatshow_padding_top);
                viewInflate.setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
                ((TextView) viewInflate.findViewById(R.id.page_no)).setText(String.format(SlideshowActivity.this.getString(R.string.flatshow_page_no), Integer.valueOf(iIntValue)));
                return viewInflate;
            }
            if (!(obj instanceof I0)) {
                return null;
            }
            int dimensionPixelOffset3 = SlideshowActivity.this.getResources().getDimensionPixelOffset(R.dimen.flatshow_padding_left);
            int dimensionPixelOffset4 = SlideshowActivity.this.getResources().getDimensionPixelOffset(R.dimen.flatshow_padding_top);
            I0 i02 = (I0) obj;
            int iY = i02.y();
            if (iY != 0) {
                if (iY == 1) {
                    imageView = view != null ? (ImageView) ((LinearLayout) view).getChildAt(0) : new ImageView(SlideshowActivity.this);
                    imageView.setContentDescription(SlideshowActivity.this.getResources().getString(R.string.attach_image));
                    drawableZ = i02.z();
                    if (drawableZ == null) {
                        i02.x(new I0.b() { // from class: com.android.mmt.ui.K0
                            @Override // com.android.mmt.ui.I0.b
                            public final void a(Drawable drawable) {
                                ImageView imageView3 = imageView;
                                if (drawable == null) {
                                    imageView3.setImageResource(R.drawable.ic_missing_thumbnail_picture);
                                } else {
                                    imageView3.setImageDrawable(drawable);
                                    C0273e.f(imageView3, drawable);
                                }
                                SlideshowActivity.Q(drawable, imageView3);
                            }
                        });
                        i02.F();
                    }
                } else if (iY == 2) {
                    imageView = view != null ? (ImageView) ((LinearLayout) view).getChildAt(0) : new ImageView(SlideshowActivity.this);
                    drawableZ = SlideshowActivity.this.getResources().getDrawable(R.drawable.flatshow_video_play_btn);
                } else if (iY == 3) {
                    imageView = view != null ? (ImageView) ((LinearLayout) view).getChildAt(0) : new ImageView(SlideshowActivity.this);
                    drawableZ = SlideshowActivity.this.getResources().getDrawable(R.drawable.flatshow_audio_play_btn);
                } else if (iY == 4) {
                    imageView = view != null ? (ImageView) ((LinearLayout) view).getChildAt(0) : new ImageView(SlideshowActivity.this);
                    drawableZ = SlideshowActivity.this.getResources().getDrawable(R.drawable.flatshow_vcard_btn);
                } else if (iY != 5) {
                    textView = null;
                    drawableZ = null;
                } else {
                    imageView = view != null ? (ImageView) ((LinearLayout) view).getChildAt(0) : new ImageView(SlideshowActivity.this);
                    drawableZ = SlideshowActivity.this.getResources().getDrawable(R.drawable.flatshow_default_btn);
                }
                imageView2 = imageView;
                textView = null;
            } else {
                textView = view != null ? (TextView) view : (TextView) layoutInflaterFrom.inflate(R.layout.flatshow_text, (ViewGroup) null);
                com.android.mmt.util.e0.j(textView, i02.D(), SlideshowActivity.this.f5438y, R.style.TextAppearance_MessageBody_Highlight);
                textView.setTextSize(0, this.d);
                textView.setTextIsSelectable(true);
                textView.setLinksClickable(true);
                drawableZ = null;
            }
            if (imageView2 != null) {
                Uri uriI = i02.i();
                if (uriI != null && G0.k.w(uriI)) {
                    iC = C0283o.c(SlideshowActivity.this, uriI);
                }
                imageView2.setRotation(iC);
                if (drawableZ == null) {
                    imageView2.setImageResource(R.drawable.ic_missing_thumbnail_picture);
                } else {
                    imageView2.setImageDrawable(drawableZ);
                    C0273e.f(imageView2, drawableZ);
                }
                imageView2.setClickable(true);
                imageView2.setOnClickListener(new ViewOnClickListenerC0100a(i02));
                imageView2.setOnLongClickListener(new b(i02));
                SlideshowActivity.Q(drawableZ, imageView2);
                if (view == null) {
                    LinearLayout linearLayout = new LinearLayout(SlideshowActivity.this);
                    linearLayout.setGravity(3);
                    linearLayout.setOrientation(1);
                    linearLayout.addView(imageView2);
                    view2 = linearLayout;
                } else {
                    view2 = view;
                }
            } else {
                view2 = textView;
            }
            if (view2 != null) {
                view2.setPadding(dimensionPixelOffset3, dimensionPixelOffset4, dimensionPixelOffset3, dimensionPixelOffset4);
            }
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final int getViewTypeCount() {
            return 3;
        }
    }

    static void Q(Drawable drawable, ImageView imageView) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth <= 200) {
                imageView.setLayoutParams(new LinearLayout.LayoutParams((intrinsicWidth * 3) / 2, (intrinsicHeight * 3) / 2));
            } else if (intrinsicWidth > 300) {
                imageView.setLayoutParams(new LinearLayout.LayoutParams(300, (intrinsicHeight * 300) / intrinsicWidth));
            } else {
                imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            }
        }
    }

    @Override // P0.InterfaceC0164j
    public final void d(float f4) {
        a aVar = this.f5436w;
        if (aVar != null) {
            aVar.c(f4);
        }
        ListView listView = this.f5435v;
        if (listView == null || listView.getVisibility() != 0) {
            return;
        }
        int count = this.f5435v.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            View childAt = this.f5435v.getChildAt(i2);
            if (childAt != null && (childAt instanceof TextView)) {
                ((TextView) childAt).setTextSize(0, f4);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Objects.requireNonNull(P0.G.b());
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, this.getString(R.string.activity_not_found), 0).show();
            return true;
        }
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new Handler();
        Intent intent = getIntent();
        this.f5438y = intent.getStringExtra("highlight");
        intent.getBooleanExtra("useslide", false);
        this.f5437x = K();
        getWindow().setFlags(8388608, 8388608);
        Uri data = getIntent().getData();
        setContentView(R.layout.flatshow);
        Cursor cursorE = com.android.mmt.util.O.e(this, getContentResolver(), data, f5434A, null, null, null);
        if (cursorE != null && this.f5437x != null) {
            try {
                if (cursorE.getCount() > 0) {
                    cursorE.moveToFirst();
                    String strD = P0.r.d(cursorE, 0, 1);
                    if (TextUtils.isEmpty(strD)) {
                        this.f5437x.m(R.string.no_subject);
                    } else {
                        this.f5437x.n(strD);
                    }
                    androidx.preference.g.c(this);
                    long j2 = cursorE.getLong(2) * 1000;
                    cursorE.getLong(3);
                    String strR = P0.r.r(getApplicationContext(), j2, true);
                    miuix.appcompat.app.b bVar = this.f5437x;
                    if (strR == null) {
                        strR = "";
                    }
                    bVar.l(strR);
                } else {
                    this.f5437x.m(R.string.no_subject);
                }
            } finally {
                cursorE.close();
            }
        }
        this.f5435v = (ListView) findViewById(R.id.slide_view);
        this.f5435v.addHeaderView(getLayoutInflater().inflate(R.layout.flatshow_list_header, (ViewGroup) null));
        a aVar = new a(data);
        this.f5436w = aVar;
        this.f5435v.setAdapter((ListAdapter) aVar);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuOpened(int i2, Menu menu) {
        return false;
    }

    @Override // androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1029) {
            for (int i4 : iArr) {
                if (i4 != 0) {
                    return;
                }
            }
            Runnable runnable = this.f5439z;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onStart() {
        super.onStart();
        P0.G.b().e(this, this);
        P0.G.b().g();
        ListView listView = this.f5435v;
        if (listView == null || listView.getVisibility() == 8) {
            return;
        }
        this.f5435v.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onStop() {
        super.onStop();
        P0.G.a(this);
    }

    @Override // android.app.Activity
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
