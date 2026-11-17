package com.android.mmt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mmt.R;
import t.C0384b;

/* loaded from: classes.dex */
public class BookmarkListItem extends L {

    /* renamed from: F0, reason: collision with root package name */
    private static int f4679F0;

    /* renamed from: G0, reason: collision with root package name */
    private static int f4680G0;

    /* renamed from: A0, reason: collision with root package name */
    private View f4681A0;

    /* renamed from: B0, reason: collision with root package name */
    private ImageView f4682B0;

    /* renamed from: C0, reason: collision with root package name */
    private TextView f4683C0;

    /* renamed from: D0, reason: collision with root package name */
    private TextView f4684D0;

    /* renamed from: E0, reason: collision with root package name */
    protected FrameLayout f4685E0;

    /* renamed from: y0, reason: collision with root package name */
    private TextView f4686y0;

    /* renamed from: z0, reason: collision with root package name */
    private ImageView f4687z0;

    public BookmarkListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private String U(C0243g0 c0243g0) {
        if (c0243g0 == null || !c0243g0.U()) {
            return null;
        }
        G0 g0D = c0243g0.D();
        if (g0D.o() || !g0D.g()) {
            return null;
        }
        return g0D.j().C();
    }

    private void V(boolean z4, boolean z5) {
        this.f4687z0.setVisibility(z4 ? 0 : 8);
        this.f4681A0.setVisibility(z5 ? 0 : 8);
        if (z5) {
            this.f4682B0.setVisibility(8);
            this.f4683C0.setVisibility(8);
            this.f4684D0.setVisibility(8);
        }
    }

    @Override // com.android.mmt.ui.L, com.android.mmt.ui.MessageListItem
    public final void L(C0243g0 c0243g0, boolean z4, boolean z5, boolean z6, String str, String str2) {
        ViewGroup viewGroup;
        LinearLayout.LayoutParams layoutParams;
        V(false, true);
        super.L(c0243g0, z4, z5, z6, str, str2);
        this.f4686y0.setVisibility(8);
        if (c0243g0.k() != null) {
            this.f4685E0.setVisibility(8);
        } else {
            this.f4685E0.setVisibility(0);
        }
        if (c0243g0.k() == null || (viewGroup = (ViewGroup) findViewById(R.id.contact_message_body)) == null || viewGroup.getChildCount() <= 0 || (layoutParams = (LinearLayout.LayoutParams) viewGroup.getChildAt(0).getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = -1;
    }

    @Override // com.android.mmt.ui.L, com.android.mmt.ui.MessageListItem
    public final void R() {
        super.R();
    }

    @Override // com.android.mmt.ui.L, android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        this.f4686y0 = (TextView) findViewById(R.id.favorite_date);
        this.f4685E0 = (FrameLayout) findViewById(R.id.bookmark_card);
        this.f4687z0 = (ImageView) findViewById(R.id.attachment_image);
        this.f4681A0 = findViewById(R.id.message_group);
        this.f4682B0 = (ImageView) findViewById(R.id.attachment_icon);
        this.f4683C0 = (TextView) findViewById(R.id.message_subject);
        this.f4684D0 = (TextView) findViewById(R.id.message_body);
        if (f4679F0 == 0) {
            f4679F0 = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
            f4680G0 = getResources().getDimensionPixelSize(R.dimen.bookmark_image_height);
        } else {
            if (this.f4687z0.getMeasuredWidth() == 0 || this.f4687z0.getMeasuredWidth() == f4679F0) {
                return;
            }
            f4679F0 = this.f4687z0.getMeasuredWidth();
            f4680G0 = this.f4687z0.getMeasuredHeight();
        }
    }

    @Override // com.android.mmt.ui.MessageListItem
    protected final void y(C0243g0 c0243g0) {
        I0 i0J;
        if (c0243g0.w() == 2 || c0243g0.w() == 6) {
            V(true, false);
            G0 g0D = c0243g0.D();
            if (!g0D.g() || (i0J = g0D.j()) == null) {
                return;
            }
            ((com.bumptech.glide.h) ((com.bumptech.glide.h) C0384b.y(getContext()).r(i0J.i()).O(f4679F0, f4680G0).P()).i()).c().g0(this.f4687z0);
            return;
        }
        int iW = c0243g0.w();
        if (iW != 1) {
            if (iW == 3) {
                V(false, true);
                this.f4682B0.setVisibility(0);
                this.f4682B0.setImageResource(R.drawable.ic_bookmark_audio);
                this.f4683C0.setVisibility(0);
                this.f4683C0.setText(U(c0243g0));
                return;
            }
            if (iW == 4) {
                V(false, true);
                this.f4682B0.setVisibility(0);
                this.f4682B0.setImageResource(R.drawable.ic_bookmark_video);
                this.f4683C0.setVisibility(0);
                this.f4683C0.setText(U(c0243g0));
                return;
            }
            if (iW != 5) {
                V(false, true);
                this.f4682B0.setVisibility(0);
                this.f4682B0.setImageResource(R.drawable.ic_bookmark_file);
            } else {
                V(false, true);
                this.f4682B0.setVisibility(0);
                this.f4682B0.setImageResource(R.drawable.ic_bookmark_file);
                this.f4683C0.setVisibility(0);
                this.f4683C0.setText(R.string.add_contact);
            }
        }
    }
}
