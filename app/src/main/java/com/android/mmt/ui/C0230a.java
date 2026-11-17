package com.android.mmt.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.os.Message;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.L0;
import com.android.mmt.util.C0273e;
import com.miui.smsextra.provider.TempFileProvider;
import f0.C0303b;
import g0.C0318n;
import g0.C0319o;
import j0.C0337b;
import java.io.File;
import java.util.Objects;
import miuix.appcompat.app.g;
import t.C0384b;
import w.C0406b;
import x0.C0417d;

/* renamed from: com.android.mmt.ui.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0230a {

    /* renamed from: r, reason: collision with root package name */
    private static final String f5500r = MediaStore.Video.Media.getContentUri("external").toString();

    /* renamed from: s, reason: collision with root package name */
    private static final String f5501s = MediaStore.Images.Media.getContentUri("external").toString();

    /* renamed from: t, reason: collision with root package name */
    private static final String f5502t = MediaStore.Audio.Media.getContentUri("external").toString();
    private static final int u = MmsApp.c().getResources().getDimensionPixelSize(R.dimen.attachment_type_screen_height);

    /* renamed from: v, reason: collision with root package name */
    private static final int[] f5503v = {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: w, reason: collision with root package name */
    private static final int[] f5504w = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: x, reason: collision with root package name */
    private static final int[] f5505x = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    /* renamed from: a, reason: collision with root package name */
    private P f5506a;

    /* renamed from: b, reason: collision with root package name */
    private ViewSwitcher f5507b;

    /* renamed from: c, reason: collision with root package name */
    private AttachmentScreenView f5508c;
    private ViewGroup d;

    /* renamed from: e, reason: collision with root package name */
    private TabWidget f5509e;

    /* renamed from: f, reason: collision with root package name */
    private Animation f5510f;
    private Animation g;

    /* renamed from: h, reason: collision with root package name */
    private Animation f5511h;

    /* renamed from: i, reason: collision with root package name */
    private Animation f5512i;

    /* renamed from: m, reason: collision with root package name */
    private C0246i f5516m;

    /* renamed from: n, reason: collision with root package name */
    private P0.s f5517n;
    private int p;

    /* renamed from: j, reason: collision with root package name */
    private int f5513j = u;

    /* renamed from: k, reason: collision with root package name */
    private int f5514k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f5515l = 0;

    /* renamed from: o, reason: collision with root package name */
    private View[] f5518o = new View[13];

    /* renamed from: q, reason: collision with root package name */
    private final C0273e.InterfaceC0107e f5519q = new b();

    /* renamed from: com.android.mmt.ui.a$a, reason: collision with other inner class name */
    final class RunnableC0103a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f5520i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f5521j;

        RunnableC0103a(int i2, int i4) {
            this.f5520i = i2;
            this.f5521j = i4;
        }

        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            String string;
            String string2;
            Resources resources = C0230a.this.f5506a.getResources();
            String string3 = resources.getString(this.f5520i);
            int i2 = this.f5521j;
            if (i2 == -4) {
                string = resources.getString(R.string.failed_to_resize_image);
                string2 = resources.getString(R.string.resize_image_error_information);
            } else if (i2 == -3) {
                string = resources.getString(R.string.unsupported_media_format, string3);
                string2 = resources.getString(R.string.select_different_attachment);
            } else {
                if (i2 != -2) {
                    if (i2 == -1) {
                        Toast.makeText(C0230a.this.f5506a, resources.getString(R.string.failed_to_add_media, string3), 0).show();
                        return;
                    } else {
                        StringBuilder sbD = D2.e.d("unknown error ");
                        sbD.append(this.f5521j);
                        throw new IllegalArgumentException(sbD.toString());
                    }
                }
                string = resources.getString(R.string.exceed_message_size_limitation, string3);
                string2 = resources.getString(R.string.failed_to_add_media, string3);
            }
            C0273e.g(C0230a.this.f5506a, string, string2);
        }
    }

    /* renamed from: com.android.mmt.ui.a$b */
    final class b implements C0273e.InterfaceC0107e {
        b() {
        }

        @Override // com.android.mmt.util.C0273e.InterfaceC0107e
        public final void a(C0318n c0318n, boolean z4) {
            int i2 = -1;
            if (c0318n == null) {
                C0230a.this.v(-1, R.string.type_picture);
                return;
            }
            C0319o c0319oE = C0319o.e(C0230a.this.f5506a.getApplicationContext());
            x0.j jVar = C0230a.this.f5506a.f5241U;
            Uri uriQ = jVar.Q(true);
            if (uriQ != null) {
                try {
                    Uri uriQ2 = c0319oE.q(c0318n, ContentUris.parseId(uriQ));
                    int iT = jVar.T(1, uriQ2, z4);
                    Log.i("AttachmentProcessor", "ResizeImageResultCallback: dataUri=" + uriQ2);
                    i2 = iT;
                } catch (C0303b unused) {
                }
            }
            C0230a.this.v(i2, R.string.type_picture);
        }
    }

    /* renamed from: com.android.mmt.ui.a$c */
    final class c implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f5524i;

        c(int i2) {
            this.f5524i = i2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0230a.this.A(this.f5524i);
        }
    }

    /* renamed from: com.android.mmt.ui.a$d */
    final class d implements DialogInterface.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Uri f5526i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f5527j;

        d(Uri uri, String str) {
            this.f5526i = uri;
            this.f5527j = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            x0.j jVar = C0230a.this.f5506a.f5241U;
            if (jVar != null) {
                jVar.N(false);
                C0230a.this.f5506a.f5235N.setText("");
                jVar.K(this.f5526i, true, true);
                jVar.Z(this.f5527j, true);
                C0230a.this.f5506a.M.j(jVar);
                C0230a.this.f5506a.u0();
                C0230a.this.f5506a.t0();
                C0230a.this.D();
            }
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.android.mmt.ui.a$e */
    final class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.android.mmt.ui.a$f */
    private class f implements View.OnTouchListener {

        /* renamed from: i, reason: collision with root package name */
        private int f5529i = 0;

        /* renamed from: j, reason: collision with root package name */
        private boolean f5530j = false;

        /* renamed from: com.android.mmt.ui.a$f$a, reason: collision with other inner class name */
        private class RunnableC0104a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            private int f5532i;

            RunnableC0104a(int i2) {
                this.f5532i = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f5532i == f.this.f5529i) {
                    C0230a.this.f5506a.f5273y0.postDelayed(this, 100L);
                    if (f.this.f5530j) {
                        C0230a.d(C0230a.this);
                    }
                }
            }
        }

        f() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                C0230a.d(C0230a.this);
                this.f5529i++;
                this.f5530j = true;
                C0230a.this.f5506a.f5273y0.postDelayed(new RunnableC0104a(this.f5529i), 500L);
            } else if (actionMasked == 1) {
                this.f5529i++;
            } else if (actionMasked == 2) {
                int x2 = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (x2 < 0 || x2 >= view.getWidth() || y2 < 0 || y2 >= view.getHeight()) {
                    this.f5530j = false;
                } else {
                    this.f5530j = true;
                }
            } else if (actionMasked == 3) {
            }
            return false;
        }
    }

    /* renamed from: com.android.mmt.ui.a$g */
    private class g extends ListView {
        public g(Context context) {
            super(context, null);
            float f4 = context.getResources().getDisplayMetrics().density;
        }
    }

    /* renamed from: com.android.mmt.ui.a$h */
    private class h {

        /* renamed from: a, reason: collision with root package name */
        private boolean f5534a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f5535b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5536c;
        private boolean d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f5537e;

        /* renamed from: f, reason: collision with root package name */
        private int f5538f;
        private int g;

        public h(int i2) {
            this.g = i2;
            this.f5538f = i2;
        }

        public final int a() {
            return this.g;
        }

        public final int b(int i2) {
            int i4;
            while (i2 < this.f5538f && (((i4 = C0246i.b(i2).f5602a) == 0 && !this.f5534a) || ((i4 == 4 && !this.f5536c) || ((i4 == 5 && !this.d) || ((i4 == 7 && !this.f5535b) || (i4 == 8 && !this.f5537e)))))) {
                i2++;
            }
            return i2;
        }

        public final void c() {
            boolean z4 = C0384b.j("TW") || C0384b.j("HK");
            this.f5534a = z4;
            this.f5535b = true;
            this.f5536c = true;
            this.d = true;
            this.f5537e = true;
            if (z4) {
                return;
            }
            this.g--;
        }

        public final boolean d(int i2) {
            return i2 >= this.f5538f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.android.mmt.ui.a$i */
    class i implements L0.a {

        /* renamed from: a, reason: collision with root package name */
        private int f5539a;

        /* renamed from: b, reason: collision with root package name */
        private int f5540b;

        /* renamed from: c, reason: collision with root package name */
        private int f5541c;
        private int d;

        i(int i2, int i4, int i5, int i6) {
            this.f5539a = i2;
            this.f5540b = i4;
            this.f5541c = i5;
            this.d = i6;
        }

        public final void a(L0 l02) {
            C0230a.g(C0230a.this, l02, this.f5539a, this.f5540b, this.f5541c, this.d);
        }
    }

    public C0230a(P p) {
        this.f5506a = p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i2) {
        this.f5509e.setCurrentTab(i2);
        int i4 = 0;
        while (i4 < this.d.getChildCount()) {
            this.d.getChildAt(i4).setVisibility(i2 == i4 ? 0 : 8);
            i4++;
        }
    }

    static void c(C0230a c0230a) {
        P p = c0230a.f5506a;
        String[] strArr = new String[1];
        strArr[0] = O2.a.a() ? "android.permission.READ_MEDIA_AUDIO" : "android.permission.READ_EXTERNAL_STORAGE";
        if (com.android.mmt.util.A.k(p, strArr, 1027)) {
            return;
        }
        C0273e.b(c0230a.f5506a);
    }

    static void d(C0230a c0230a) {
        EditText editTextY0 = c0230a.f5506a.y0();
        editTextY0.onKeyDown(67, new KeyEvent(0, 67));
        editTextY0.onKeyUp(67, new KeyEvent(1, 67));
    }

    static void g(C0230a c0230a, L0 l02, int i2, int i4, int i5, int i6) {
        Objects.requireNonNull(c0230a);
        int i7 = i5 * i6;
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = (i4 * i5 * i6) + i8;
            if (i9 >= com.android.mmt.util.N.a(i2)) {
                return;
            }
            String strB = com.android.mmt.util.N.b(i2, i9);
            ViewGroup viewGroup = (ViewGroup) c0230a.f5506a.getLayoutInflater().inflate(R.layout.smiley_grid_item, (ViewGroup) null);
            TextView textView = (TextView) viewGroup.findViewById(R.id.smiley_text);
            textView.setText(strB);
            if (i2 == 0 || i2 == 1 || i2 == 2) {
                textView.setTextSize(0, textView.getTextSize() * 3.0f);
            } else if (i2 != 3) {
                if (i2 == 4) {
                    textView.setTextSize(0, textView.getTextSize() * 2.0f);
                }
            } else if (strB.length() < 7) {
                textView.setTextSize(0, textView.getTextSize() * 1.3f);
            }
            viewGroup.setOnClickListener(new ViewOnClickListenerC0240f(c0230a, strB));
            l02.addView(viewGroup);
        }
    }

    private void i(Uri uri, boolean z4) {
        if (uri != null) {
            v(this.f5506a.f5241U.T(3, uri, z4), R.string.type_audio);
        }
    }

    private void j(Uri uri, boolean z4) {
        Log.i("AttachmentProcessor", "addImage: append=" + z4);
        int iT = this.f5506a.f5241U.T(1, uri, z4);
        if (iT == 0) {
            return;
        }
        String type = C0.a.c().getContentResolver().getType(uri);
        if (iT != -4 && iT != -2 && (!"image/heic".equals(type) || iT != -3)) {
            v(iT, R.string.type_picture);
            return;
        }
        Log.i("AttachmentProcessor", "addImage: resize image ");
        P p = this.f5506a;
        C0273e.a(p, uri, p.f5273y0, this.f5519q, z4);
    }

    private void k(int i2) {
        int iP = p(R.integer.attachment_type_column_count);
        int iP2 = p(R.integer.attachment_type_row_count);
        int iO = o(R.dimen.attachment_type_row_height);
        int iMax = Math.max(0, this.f5513j - (iP2 * iO)) - o(R.dimen.attachment_type_screens_space);
        int i4 = iP * iP2;
        h hVar = new h(this.f5516m.getCount());
        Objects.requireNonNull(this.f5506a);
        int i5 = this.f5506a.q0;
        hVar.c();
        int iA = ((hVar.a() - 1) / i4) + 1 + 1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 81);
        layoutParams.bottomMargin = (iMax - 10) / 2;
        this.f5508c.s(layoutParams);
        this.f5508c.l();
        g gVar = new g(this.f5506a);
        gVar.setOverScrollMode(1);
        ViewGroup viewGroup = null;
        View viewInflate = View.inflate(this.f5506a, R.layout.phrase_list_item_bottom, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.phrase_body);
        textView.setBackground(null);
        textView.setTextColor(this.f5506a.getResources().getColor(R.color.text_color_attachment_edit_phrase));
        textView.setText(R.string.edit_phrase);
        viewInflate.setOnClickListener(new ViewOnClickListenerC0236d(this));
        gVar.addFooterView(viewInflate);
        gVar.setAdapter((ListAdapter) this.f5517n);
        this.f5517n.f();
        gVar.setOnItemClickListener(new C0238e(this));
        int i6 = -1;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        gVar.setPadding(0, 0, 0, o(R.dimen.seekbar_point_margin_bottom) + iMax);
        this.f5508c.addView(gVar, layoutParams2);
        int i7 = 0;
        int i8 = 1;
        while (i8 < iA) {
            int i9 = i8;
            int i10 = i6;
            ViewGroup viewGroup2 = viewGroup;
            int i11 = iA;
            L0 l02 = new L0(this.f5506a, iP2, iP, i2 / iP, iO, o(R.dimen.attachment_type_screens_margin_width));
            l02.d();
            int i12 = i7;
            for (int i13 = 0; i13 < i4; i13++) {
                int iB = hVar.b(i12);
                if (hVar.d(iB)) {
                    break;
                }
                View view = this.f5516m.getView(iB, viewGroup2, viewGroup2);
                int i14 = C0246i.b(iB).f5602a;
                view.setOnClickListener(new c(i14));
                l02.addView(view);
                this.f5518o[i14] = view;
                i12 = iB + 1;
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i10, i10);
            l02.setPadding(0, 0, 0, iMax);
            this.f5508c.addView(l02, layoutParams3);
            i8 = i9 + 1;
            i7 = i12;
            viewGroup = viewGroup2;
            i6 = i10;
            iA = i11;
        }
        this.f5508c.p(1);
        D();
    }

    private int o(int i2) {
        return this.f5506a.getResources().getDimensionPixelSize(i2);
    }

    private int p(int i2) {
        return this.f5506a.getResources().getInteger(i2);
    }

    private boolean u(Uri uri) {
        try {
            P p = this.f5506a;
            if (p != null && uri != null) {
                p.grantUriPermission(p.getPackageName(), uri, 1);
            }
            return true;
        } catch (SecurityException e2) {
            this.f5506a.runOnUiThread(new I(this, 2));
            e2.printStackTrace();
            return false;
        }
    }

    public final void A(int i2) {
        switch (i2) {
            case 0:
                if (y()) {
                    if (this.f5509e == null) {
                        this.f5506a.findViewById(R.id.message_edit_smiley_panel_stub).setVisibility(0);
                        P p = this.f5506a;
                        this.f5509e = (TabWidget) p.findViewById(R.id.smiley_tab_widget);
                        this.d = (ViewGroup) p.findViewById(R.id.smiley_screens);
                        for (int i4 = this.p; i4 < com.android.mmt.util.N.f5912b; i4++) {
                            this.f5509e.getChildAt(i4).setOnClickListener(new ViewOnClickListenerC0234c(this, i4));
                        }
                        for (int i5 = 0; i5 < this.p; i5++) {
                            this.f5509e.getChildAt(i5).setVisibility(8);
                        }
                        View viewFindViewById = p.findViewById(R.id.smiley_back);
                        viewFindViewById.setClickable(true);
                        viewFindViewById.setOnTouchListener(new f());
                        C(this.p);
                    }
                    if (this.f5510f == null) {
                        this.f5510f = AnimationUtils.loadAnimation(this.f5506a, R.anim.slide_left_in);
                    }
                    if (this.g == null) {
                        this.g = AnimationUtils.loadAnimation(this.f5506a, R.anim.slide_left_out);
                    }
                    this.f5507b.setInAnimation(this.f5510f);
                    this.f5507b.setOutAnimation(this.g);
                    this.f5507b.showPrevious();
                    break;
                }
                break;
            case 1:
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("vnd.android.cursor.dir/contact_pick_single");
                int i6 = P0.r.f937c;
                intent.setPackage("com.android.contacts");
                this.f5506a.startActivityForResult(intent, 109);
                break;
            case 2:
                if (!com.android.mmt.util.A.k(this.f5506a, O2.a.a() ? new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"} : new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1025)) {
                    C0273e.c(this.f5506a);
                    break;
                }
                break;
            case 3:
                if (!com.android.mmt.util.A.k(this.f5506a, O2.a.a() ? new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"} : new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1022)) {
                    t();
                    break;
                }
                break;
            case 4:
                Intent intent2 = new Intent(this.f5506a, (Class<?>) PickerActivity.class);
                intent2.setAction("android.intent.action.PICK");
                intent2.putExtra("pick_type", 0);
                this.f5506a.startActivityForResult(intent2, 112);
                break;
            case 5:
                if (this.f5506a.f5241U.x() == 0) {
                    this.f5506a.d1();
                    break;
                } else {
                    this.f5506a.n0();
                    break;
                }
            case 7:
                this.f5506a.j1();
                break;
            case 8:
                String[] strArr = {this.f5506a.getResources().getString(R.string.select_local_audio)};
                DialogInterfaceOnClickListenerC0244h dialogInterfaceOnClickListenerC0244h = new DialogInterfaceOnClickListenerC0244h(this);
                g.a aVar = new g.a(this.f5506a);
                aVar.h();
                aVar.c(true);
                aVar.i(strArr, dialogInterfaceOnClickListenerC0244h);
                aVar.A();
                break;
            case 9:
                String[] strArr2 = {this.f5506a.getResources().getString(R.string.attach_record_video), this.f5506a.getResources().getString(R.string.select_local_video)};
                DialogInterfaceOnClickListenerC0242g dialogInterfaceOnClickListenerC0242g = new DialogInterfaceOnClickListenerC0242g(this);
                g.a aVar2 = new g.a(this.f5506a);
                aVar2.h();
                aVar2.c(true);
                aVar2.i(strArr2, dialogInterfaceOnClickListenerC0242g);
                aVar2.A();
                break;
        }
    }

    public final void B() {
        this.f5514k = 0;
    }

    public final void D() {
        if (this.f5506a.f5241U.B()) {
            int i2 = 0;
            while (true) {
                View[] viewArr = this.f5518o;
                if (i2 >= viewArr.length) {
                    return;
                }
                if (viewArr[i2] != null) {
                    viewArr[i2].setEnabled(f5503v[i2] > 0);
                }
                i2++;
            }
        } else if (this.f5506a.f5241U.P()) {
            int i4 = 0;
            while (true) {
                View[] viewArr2 = this.f5518o;
                if (i4 >= viewArr2.length) {
                    return;
                }
                if (viewArr2[i4] != null) {
                    viewArr2[i4].setEnabled(f5504w[i4] > 0);
                }
                i4++;
            }
        } else {
            int i5 = 0;
            while (true) {
                View[] viewArr3 = this.f5518o;
                if (i5 >= viewArr3.length) {
                    return;
                }
                if (viewArr3[i5] != null) {
                    viewArr3[i5].setEnabled(f5505x[i5] > 0);
                }
                i5++;
            }
        }
    }

    public final void h(String str, Uri uri, boolean z4) {
        if (uri == null) {
            Y1.a.d("error: attachment uri is null", new Object[0]);
            return;
        }
        if (str == null || "*/*".equals(str)) {
            if (uri.toString().startsWith(f5501s)) {
                str = "image/*";
            } else if (uri.toString().startsWith(f5500r)) {
                str = "video/*";
            } else if (uri.toString().startsWith(f5502t)) {
                str = "audio/*";
            } else if (uri.toString().startsWith("file://") || uri.toString().startsWith("content://")) {
                uri.getLastPathSegment();
                String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
                str = fileExtensionFromUrl == null ? null : MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
            }
        }
        if (C0337b.f(str)) {
            if (u(uri)) {
                j(uri, z4);
                return;
            }
            return;
        }
        if (C0337b.h(str)) {
            if (u(uri)) {
                v(this.f5506a.f5241U.T(2, uri, z4), R.string.type_video);
            }
        } else if (C0337b.d(str) || "application/ogg".equalsIgnoreCase(str)) {
            if (u(uri)) {
                i(uri, z4);
            }
        } else if (!"text/x-vCard".equalsIgnoreCase(str)) {
            v(-3, R.string.type_attachment);
        } else if (u(uri)) {
            v(this.f5506a.f5241U.T(4, uri, z4), R.string.type_vcard);
        }
    }

    public final void l() {
        ViewSwitcher viewSwitcher = this.f5507b;
        if (viewSwitcher == null || viewSwitcher.getVisibility() == 8) {
            return;
        }
        this.f5507b.setVisibility(8);
    }

    public final void m(int i2) {
        int i4;
        if (this.f5507b == null) {
            this.f5506a.findViewById(R.id.message_edit_attachment_stub).setVisibility(0);
            P p = this.f5506a;
            AttachmentScreenView attachmentScreenView = (AttachmentScreenView) p.findViewById(R.id.attachment_type_screens);
            this.f5508c = attachmentScreenView;
            attachmentScreenView.r();
            this.f5516m = new C0246i(p);
            this.f5517n = new P0.s(p, R.layout.phrase_list_item_bottom);
            this.f5507b = (ViewSwitcher) p.findViewById(R.id.attachment_panel);
            this.p = p.getResources().getBoolean(R.bool.enable_emoji) ? 0 : 3;
        }
        q(false);
        if (this.f5508c.i() > 0 && this.f5508c.h() < 1) {
            this.f5508c.p(1);
        }
        int i5 = u;
        if (i2 <= i5) {
            i2 = i5;
        }
        ((ViewGroup.MarginLayoutParams) this.f5507b.getLayoutParams()).height = i2;
        if (i2 != this.f5513j) {
            this.f5513j = i2;
            if (this.f5508c != null && (i4 = this.f5514k) > 0) {
                k(i4);
            }
        }
        this.f5507b.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v2, types: [android.view.ViewGroup] */
    public final int n(int i2, int i4) {
        if (!x()) {
            return i4;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.f5514k == 0) {
            this.f5514k = size;
            k(size);
        }
        TabWidget tabWidget = this.f5509e;
        if (((tabWidget == null || tabWidget.getVisibility() == 8) ? false : true) && this.f5515l == 0) {
            this.f5515l = size;
            int iP = p(R.integer.smiley_column_count);
            int iP2 = p(R.integer.smiley_row_count);
            int iO = (this.f5513j - o(R.dimen.smiley_bottom_margin)) / 3;
            int i5 = iP * iP2;
            int i6 = this.p;
            while (i6 < com.android.mmt.util.N.f5912b) {
                ScreenView screenView = (ScreenView) this.d.getChildAt(i6);
                int i7 = -1;
                int iA = ((com.android.mmt.util.N.a(i6) - 1) / i5) + 1;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 81);
                layoutParams.bottomMargin = o(R.dimen.seekbar_point_margin_bottom);
                screenView.s(layoutParams);
                screenView.l();
                int i8 = 0;
                while (i8 < iA) {
                    L0 l02 = new L0(this.f5506a, iP2, iP, size / iP, iO, o(R.dimen.attachment_type_screens_margin_width));
                    int i9 = i8;
                    int i10 = i7;
                    ?? r15 = screenView;
                    l02.c(new i(i6, i9, iP2, iP));
                    r15.addView(l02, new FrameLayout.LayoutParams(i10, i10, 17));
                    i8 = i9 + 1;
                    iA = iA;
                    i7 = i10;
                    screenView = r15;
                    i6 = i6;
                }
                screenView.p(0);
                i6++;
            }
        }
        return this.f5513j;
    }

    public final void q(boolean z4) {
        if (y()) {
            return;
        }
        if (z4) {
            if (this.f5511h == null) {
                this.f5511h = AnimationUtils.loadAnimation(this.f5506a, R.anim.slide_right_in);
            }
            if (this.f5512i == null) {
                this.f5512i = AnimationUtils.loadAnimation(this.f5506a, R.anim.slide_right_out);
            }
            this.f5507b.setInAnimation(this.f5511h);
            this.f5507b.setOutAnimation(this.f5512i);
        } else {
            this.f5507b.setInAnimation(null);
            this.f5507b.setOutAnimation(null);
        }
        this.f5507b.showNext();
    }

    public final void r() {
        G0.p pVarU = this.f5506a.f5241U.u();
        int iW = pVarU != null ? pVarU.get(0).w() : 0;
        long j2 = k0.d.j() - 1024;
        if (pVarU != null) {
            j2 = (j2 - pVarU.y()) + iW;
        }
        if (j2 <= 0) {
            P p = this.f5506a;
            Toast.makeText(p, p.getString(R.string.message_too_big_for_audio), 0).show();
            return;
        }
        P p4 = this.f5506a;
        if (p4 instanceof Activity) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("audio/amr");
            intent.setClassName("com.android.soundrecorder", "com.android.soundrecorder.SoundRecorder");
            if (j2 > 0) {
                intent.putExtra("android.provider.MediaStore.extra.MAX_BYTES", j2);
            }
            intent.putExtra("source_name", p4.getString(R.string.multimedia_message));
            p4.startActivityForResult(intent, 105);
        }
    }

    public final void s() {
        G0.p pVarU = this.f5506a.f5241U.u();
        int iW = pVarU != null ? pVarU.get(0).w() : 0;
        long j2 = k0.d.j() - 1024;
        if (pVarU != null) {
            j2 = (j2 - pVarU.y()) + iW;
        }
        if (j2 <= 0) {
            P p = this.f5506a;
            Toast.makeText(p, p.getString(R.string.message_too_big_for_video), 0).show();
            return;
        }
        P p4 = this.f5506a;
        if (p4 instanceof Activity) {
            CamcorderProfile camcorderProfile = CamcorderProfile.get(0);
            int i2 = camcorderProfile == null ? 0 : camcorderProfile.duration;
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", 0);
            intent.putExtra("android.intent.extra.sizeLimit", j2);
            intent.putExtra("android.intent.extra.durationLimit", i2);
            try {
                p4.startActivityForResult(intent, 103);
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
                Toast.makeText(p4, p4.getString(R.string.activity_not_found_uri), 0).show();
            }
        }
    }

    public final void t() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        P p = this.f5506a;
        int i2 = TempFileProvider.f6137m;
        intent.putExtra("output", C0406b.b(p, new File(TempFileProvider.d(this.f5506a))));
        this.f5506a.startActivityForResult(intent, 101);
    }

    public final void v(int i2, int i4) {
        if (i2 == 0) {
            return;
        }
        this.f5506a.runOnUiThread(new RunnableC0103a(i4, i2));
    }

    public final void w(Message message) {
        switch (message.what) {
            case 1:
            case 4:
            case 7:
                x0.j jVar = this.f5506a.f5241U;
                G0.p pVarU = jVar.u();
                if (pVarU != null && pVarU.size() != 0 && !jVar.B()) {
                    Q2.c.a(new RunnableC0232b(this, jVar));
                    break;
                }
                break;
            case 2:
                A(2);
                break;
            case 3:
            case 6:
            case 9:
            case 12:
            case 13:
                this.f5506a.f5241U.N(true);
                break;
            case 5:
                A(9);
                break;
            case 8:
                A(8);
                break;
        }
    }

    public final boolean x() {
        ViewSwitcher viewSwitcher = this.f5507b;
        return (viewSwitcher == null || viewSwitcher.getVisibility() == 8) ? false : true;
    }

    public final boolean y() {
        ViewSwitcher viewSwitcher = this.f5507b;
        return viewSwitcher != null && viewSwitcher.getDisplayedChild() == 0;
    }

    public final void z(int i2, int i4, Intent intent) {
        Uri data;
        x0.j jVar = this.f5506a.f5241U;
        if (jVar != null && jVar.F()) {
            jVar.O();
        }
        if (i4 != -1) {
            return;
        }
        boolean z4 = true;
        switch (i2) {
            case 100:
                if (intent != null && u(intent.getData())) {
                    j(intent.getData(), false);
                    break;
                }
                break;
            case 101:
                j(Uri.fromFile(new File(TempFileProvider.d(this.f5506a))), false);
                break;
            case 102:
            case 103:
                if (intent != null && u(intent.getData()) && (data = intent.getData()) != null) {
                    v(this.f5506a.f5241U.T(2, data, false), R.string.type_video);
                    break;
                }
                break;
            case 104:
                if (intent != null && u(intent.getData())) {
                    i(intent.getData(), false);
                    break;
                }
                break;
            case 105:
                if (intent != null && u(intent.getData())) {
                    i(intent.getData(), false);
                    break;
                }
                break;
            case 106:
                x0.j jVar2 = this.f5506a.f5241U;
                if (jVar2 != null) {
                    Object objB = C0417d.c().b();
                    if (objB instanceof Uri) {
                        jVar2.J((Uri) objB, false);
                    }
                    this.f5506a.M.j(jVar2);
                    this.f5506a.t0();
                    D();
                    break;
                }
                break;
            case 109:
                if (intent != null) {
                    Editable text = this.f5506a.f5235N.getText();
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(text)) {
                        String strTrim = text.toString().trim();
                        if (!TextUtils.isEmpty(strTrim) && strTrim.charAt(strTrim.length() - 1) != '\r') {
                            sb.append("\n");
                        }
                    }
                    sb.append(G0.d.b(this.f5506a).a(intent));
                    text.insert(this.f5506a.f5235N.getSelectionStart(), sb);
                    break;
                }
                break;
            case 112:
                if (intent != null) {
                    Uri uri = (Uri) intent.getParcelableExtra("msg_uri");
                    String stringExtra = intent.getStringExtra("subject");
                    if (uri == null) {
                        EditText editText = this.f5506a.f5235N;
                        editText.getText().insert(editText.getSelectionStart(), intent.getStringExtra("android.intent.extra.shortcut.NAME"));
                        break;
                    } else {
                        x0.j jVar3 = this.f5506a.f5241U;
                        if (jVar3 == null || jVar3.G()) {
                            g.a aVar = new g.a(this.f5506a);
                            aVar.j(R.string.overwrite_edited_content);
                            aVar.t(android.R.string.yes, new d(uri, stringExtra));
                            aVar.m(android.R.string.cancel, new e());
                            aVar.A();
                            return;
                        }
                        jVar3.J(uri, true);
                        jVar3.Z(stringExtra, false);
                        this.f5506a.M.j(jVar3);
                        this.f5506a.u0();
                        this.f5506a.t0();
                        D();
                        return;
                    }
                }
                break;
            case 113:
                P0.s sVar = this.f5517n;
                if (sVar != null) {
                    sVar.f();
                    break;
                }
                break;
            case 114:
                Uri uriBuild = ContactsContract.Contacts.CONTENT_VCARD_URI.buildUpon().appendPath(Uri.encode(intent.getData().getPathSegments().get(2))).appendQueryParameter("no_photo", "true").build();
                if (uriBuild != null) {
                    v(this.f5506a.f5241U.T(4, uriBuild, false), R.string.type_vcard);
                    break;
                }
                break;
        }
        P p = this.f5506a;
        if (!p.I0(p.f5235N)) {
            P p4 = this.f5506a;
            if (!p4.I0(p4.f5231K)) {
                z4 = false;
            }
        }
        p.f5273y0.postDelayed(new Y(p, z4), 200L);
    }
}
