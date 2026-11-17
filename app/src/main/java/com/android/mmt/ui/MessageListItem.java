package com.android.mmt.ui;

import G0.c;
import P0.C0157c;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.provider.Telephony;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.R;
import com.android.mmt.ui.C0243g0;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.EditableListViewV2;
import com.android.mmt.util.b0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import miuix.appcompat.app.g;
import t.C0384b;
import x0.C0414a;

/* loaded from: classes.dex */
public class MessageListItem extends RelativeLayout implements C0414a.c, EditableListViewV2.e {

    /* renamed from: A, reason: collision with root package name */
    private View f4923A;

    /* renamed from: B, reason: collision with root package name */
    private Button f4924B;

    /* renamed from: C, reason: collision with root package name */
    private View f4925C;

    /* renamed from: D, reason: collision with root package name */
    private ProgressBar f4926D;

    /* renamed from: E, reason: collision with root package name */
    protected Handler f4927E;

    /* renamed from: F, reason: collision with root package name */
    private C0243g0 f4928F;

    /* renamed from: G, reason: collision with root package name */
    private View f4929G;

    /* renamed from: H, reason: collision with root package name */
    private CheckBox f4930H;

    /* renamed from: I, reason: collision with root package name */
    private View f4931I;

    /* renamed from: J, reason: collision with root package name */
    private ThumbnailView f4932J;

    /* renamed from: K, reason: collision with root package name */
    private View f4933K;
    private View L;
    private int M;

    /* renamed from: N, reason: collision with root package name */
    private int f4934N;

    /* renamed from: O, reason: collision with root package name */
    private int f4935O;
    private int P;

    /* renamed from: Q, reason: collision with root package name */
    private final int f4936Q;

    /* renamed from: R, reason: collision with root package name */
    private final int f4937R;

    /* renamed from: S, reason: collision with root package name */
    private final int f4938S;

    /* renamed from: T, reason: collision with root package name */
    private final int f4939T;

    /* renamed from: U, reason: collision with root package name */
    private final int f4940U;

    /* renamed from: V, reason: collision with root package name */
    private final int f4941V;

    /* renamed from: W, reason: collision with root package name */
    private final int f4942W;

    /* renamed from: a0, reason: collision with root package name */
    private final int f4943a0;

    /* renamed from: b0, reason: collision with root package name */
    private final int f4944b0;

    /* renamed from: c0, reason: collision with root package name */
    private final int f4945c0;

    /* renamed from: d0, reason: collision with root package name */
    private final int f4946d0;

    /* renamed from: e0, reason: collision with root package name */
    private final int f4947e0;

    /* renamed from: f0, reason: collision with root package name */
    private final int f4948f0;

    /* renamed from: g0, reason: collision with root package name */
    private final int f4949g0;

    /* renamed from: h0, reason: collision with root package name */
    private final int f4950h0;

    /* renamed from: i, reason: collision with root package name */
    private Pair<Long, ArrayMap<TextView, Integer>> f4951i;

    /* renamed from: i0, reason: collision with root package name */
    private final int f4952i0;

    /* renamed from: j, reason: collision with root package name */
    private Context f4953j;

    /* renamed from: j0, reason: collision with root package name */
    private final int f4954j0;

    /* renamed from: k, reason: collision with root package name */
    private View f4955k;

    /* renamed from: k0, reason: collision with root package name */
    private final int f4956k0;

    /* renamed from: l, reason: collision with root package name */
    private View f4957l;

    /* renamed from: l0, reason: collision with root package name */
    private final int f4958l0;

    /* renamed from: m, reason: collision with root package name */
    private TextView f4959m;

    /* renamed from: m0, reason: collision with root package name */
    private final int f4960m0;

    /* renamed from: n, reason: collision with root package name */
    private View f4961n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f4962n0;

    /* renamed from: o, reason: collision with root package name */
    private TextView f4963o;

    /* renamed from: o0, reason: collision with root package name */
    private String f4964o0;
    private View p;
    private String p0;

    /* renamed from: q, reason: collision with root package name */
    private TextView f4965q;
    private int q0;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f4966r;

    /* renamed from: r0, reason: collision with root package name */
    private miuix.appcompat.app.g f4967r0;

    /* renamed from: s, reason: collision with root package name */
    private View f4968s;

    /* renamed from: s0, reason: collision with root package name */
    private int f4969s0;

    /* renamed from: t, reason: collision with root package name */
    private TextView f4970t;

    /* renamed from: t0, reason: collision with root package name */
    private List<TextView> f4971t0;
    private StaticTextView u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f4972u0;

    /* renamed from: v, reason: collision with root package name */
    private LinearLayout f4973v;

    /* renamed from: v0, reason: collision with root package name */
    private final RecyclerView.o f4974v0;

    /* renamed from: w, reason: collision with root package name */
    private f f4975w;

    /* renamed from: x, reason: collision with root package name */
    private e f4976x;

    /* renamed from: y, reason: collision with root package name */
    private ProgressBar f4977y;

    /* renamed from: z, reason: collision with root package name */
    private View f4978z;

    final class a extends ClickableSpan {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ URLSpan f4979i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ URLSpan f4980j;

        a(URLSpan uRLSpan, URLSpan uRLSpan2) {
            this.f4979i = uRLSpan;
            this.f4980j = uRLSpan2;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View view) {
            if ((!(MessageListItem.this.f4953j instanceof r) || ((r) MessageListItem.this.f4953j).b2()) && MessageListItem.this.f4928F != null) {
                URLSpan uRLSpan = this.f4979i;
                if (uRLSpan == null) {
                    uRLSpan = this.f4980j;
                }
                b0.a aVarA = com.android.mmt.util.b0.a(uRLSpan.getURL());
                StringBuilder sbD = D2.e.d("Url: ");
                Objects.requireNonNull(MessageListItem.this.f4928F);
                sbD.append(0);
                sbD.append(" | ");
                sbD.append(aVarA.f5942b);
                Log.d("MessageListItem", sbD.toString());
                com.android.mmt.util.b0.b(MessageListItem.this.f4953j, aVarA, MessageListItem.this.f4928F);
            }
        }
    }

    final class b implements View.OnTouchListener {

        /* renamed from: i, reason: collision with root package name */
        g f4982i;

        b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            TextView textView = (TextView) view;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
            int action = motionEvent.getAction();
            if (action == 0 || action == 1) {
                int x2 = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                int totalPaddingLeft = x2 - textView.getTotalPaddingLeft();
                int totalPaddingTop = y2 - textView.getTotalPaddingTop();
                int scrollX = textView.getScrollX() + totalPaddingLeft;
                int scrollY = textView.getScrollY() + totalPaddingTop;
                Layout layout = textView.getLayout();
                if (layout == null) {
                    Log.v("MessageListItem", " layout is null");
                    return false;
                }
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannableNewSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    if (action == 0) {
                        int spanStart = spannableNewSpannable.getSpanStart(clickableSpanArr[0]);
                        int spanEnd = spannableNewSpannable.getSpanEnd(clickableSpanArr[0]);
                        int dimension = (int) MessageListItem.this.getContext().getResources().getDimension(R.dimen.link_background_drawable_radius);
                        if (this.f4982i == null) {
                            this.f4982i = new g(MessageListItem.this.getContext().getColor(R.color.text_link_background), dimension);
                        }
                        this.f4982i.a(spannableNewSpannable, spanStart, spanEnd, layout);
                        textView.setBackground(this.f4982i);
                    } else if (action == 1) {
                        textView.setBackground(null);
                        clickableSpanArr[0].onClick(textView);
                    }
                    return true;
                }
                if (action == 1) {
                    textView.setBackground(null);
                }
            } else if (action == 3) {
                textView.setBackground(null);
            }
            return false;
        }
    }

    final class c implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ C0414a f4984i;

        c(C0414a c0414a) {
            this.f4984i = c0414a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (MessageListItem.this.f4928F == null || MessageListItem.this.f4928F.j() != this.f4984i) {
                return;
            }
            if (MessageListItem.this.f4975w != null && MessageListItem.this.f4975w.f4990a.getVisibility() == 0) {
                MessageListItem.this.f4975w.f4991b.setText(MessageListItem.this.f4928F.l());
            }
            if (!MessageListItem.this.f4928F.S()) {
                if (MessageListItem.this.f4928F.N() || MessageListItem.this.f4963o == null) {
                    return;
                }
                MessageListItem.this.f4963o.setText(MessageListItem.this.f4953j.getString(R.string.phrase_from, MessageListItem.this.f4928F.l()));
                return;
            }
            if (MessageListItem.this.f4963o == null || MessageListItem.this.f4928F.R() || MessageListItem.this.f4928F.W()) {
                return;
            }
            MessageListItem.this.f4963o.setText(MessageListItem.this.f4928F.l());
        }
    }

    final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageListItem.this.T();
        }
    }

    public class e {

        /* renamed from: a, reason: collision with root package name */
        public TextView f4987a;

        /* renamed from: b, reason: collision with root package name */
        public Button f4988b;

        /* renamed from: c, reason: collision with root package name */
        public Button f4989c;
        public View d;
    }

    public class f {

        /* renamed from: a, reason: collision with root package name */
        public TextView f4990a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f4991b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f4992c;
        public LinearLayout d;

        public f() {
        }
    }

    private static class g extends Drawable {

        /* renamed from: a, reason: collision with root package name */
        private CharSequence f4994a;

        /* renamed from: b, reason: collision with root package name */
        private int f4995b;

        /* renamed from: c, reason: collision with root package name */
        private int f4996c;
        private Layout d;

        /* renamed from: e, reason: collision with root package name */
        private TextPaint f4997e;

        /* renamed from: f, reason: collision with root package name */
        private int f4998f;
        private int g;

        public g(int i2, int i4) {
            this.f4998f = i2;
            this.g = i4;
        }

        public final void a(CharSequence charSequence, int i2, int i4, Layout layout) {
            this.f4994a = charSequence;
            this.d = layout;
            this.f4995b = i2;
            this.f4996c = i4;
            TextPaint paint = layout.getPaint();
            this.f4997e = paint;
            paint.setAntiAlias(true);
            this.f4997e.setColor(this.f4998f);
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            int lineForOffset = this.d.getLineForOffset(this.f4995b);
            int lineForOffset2 = this.d.getLineForOffset(this.f4996c);
            for (int i2 = lineForOffset; i2 <= lineForOffset2; i2++) {
                int lineStart = this.d.getLineStart(i2);
                int lineEnd = this.d.getLineEnd(i2);
                if (i2 == lineForOffset) {
                    lineStart = this.f4995b;
                }
                if (i2 == lineForOffset2) {
                    lineEnd = this.f4996c;
                }
                int primaryHorizontal = (int) this.d.getPrimaryHorizontal(lineStart);
                int iMeasureText = (int) this.f4997e.measureText(this.f4994a, lineStart, lineEnd);
                float lineBounds = this.d.getLineBounds(i2, new Rect());
                RectF rectF = new RectF(primaryHorizontal, this.f4997e.ascent() + lineBounds, primaryHorizontal + iMeasureText, this.f4997e.descent() + lineBounds);
                float f4 = this.g;
                canvas.drawRoundRect(rectF, f4, f4, this.f4997e);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i2) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    private static class h extends RecyclerView.o {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<MessageListItem> f4999a;

        h(MessageListItem messageListItem) {
            this.f4999a = new WeakReference<>(messageListItem);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public final void a(RecyclerView recyclerView, int i2) {
            MessageListItem messageListItem = this.f4999a.get();
            if (messageListItem != null) {
                messageListItem.f4972u0 = i2 != 0;
                if (messageListItem.f4972u0) {
                    return;
                }
                MessageListItem.j(messageListItem);
            }
        }
    }

    public MessageListItem(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.f4967r0 = null;
        this.f4969s0 = 0;
        this.f4971t0 = new ArrayList();
        this.f4972u0 = false;
        this.f4974v0 = new h(this);
        this.f4953j = context;
        this.f4936Q = context.getResources().getDimensionPixelSize(R.dimen.mms_attachment_padding_width);
        this.f4953j.getResources().getDimensionPixelSize(R.dimen.timed_message_padding_width);
        this.f4937R = this.f4953j.getResources().getDimensionPixelSize(R.dimen.mms_download_padding_width);
        this.f4938S = this.f4953j.getResources().getDimensionPixelSize(R.dimen.check_box_width);
        this.f4939T = this.f4953j.getResources().getDimensionPixelSize(R.dimen.max_bubble_text_width);
        this.f4940U = this.f4953j.getResources().getDimensionPixelSize(R.dimen.bubble_checkbox_distance);
        this.f4941V = this.f4953j.getResources().getDimensionPixelSize(R.dimen.bubble_indicator_top_margin);
        this.f4942W = this.f4953j.getResources().getDimensionPixelSize(R.dimen.bubble_item_attachment_preview_margin);
        this.f4943a0 = R.drawable.thumbnail_mask_default;
        this.f4944b0 = R.drawable.message_bubble_in_attachment_bg;
        this.f4945c0 = R.drawable.message_bubble_in_attachment_bg;
        this.f4946d0 = R.drawable.message_bubble_out_bg_n;
        this.f4947e0 = R.drawable.message_bubble_out_last_bg_n;
        this.f4948f0 = R.drawable.message_bubble_in_thumbnail_bg_p;
        this.f4949g0 = R.drawable.message_bubble_in_thumbnail_last_bg_p;
        this.f4950h0 = R.drawable.message_bubble_out_thumbnail_bg_p;
        this.f4952i0 = R.drawable.message_bubble_out_thumbnail_last_bg_p;
        this.f4954j0 = R.drawable.message_bubble_in_thumbnail_bg_n;
        this.f4956k0 = R.drawable.message_bubble_in_thumbnail_last_bg_n;
        this.f4958l0 = R.drawable.message_bubble_out_thumbnail_bg_n;
        this.f4960m0 = R.drawable.message_bubble_out_thumbnail_last_bg_n;
        this.P = R.drawable.thumbnail_mask_transparent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<android.widget.TextView>] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.view.ViewGroup, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.util.ArrayList, java.util.List<android.widget.TextView>] */
    private void A(String str, String str2, String str3, G0.c cVar, int i2, boolean z4) throws Resources.NotFoundException {
        int iE;
        boolean zP;
        ArrayList<Object> arrayList;
        int i4;
        ArrayList<Pair<String, String>> arrayList2;
        View view;
        TextView textView;
        int i5;
        boolean z5;
        int i6 = i2;
        boolean z6 = false;
        if (this.f4970t != null) {
            if (TextUtils.isEmpty(str)) {
                this.f4970t.setVisibility(8);
            } else {
                this.f4970t.setVisibility(0);
                if (i6 > 0) {
                    this.f4970t.setMaxWidth(i6);
                }
                com.android.mmt.util.e0.j(this.f4970t, str, this.f4964o0, R.style.TextAppearance_MessageSubject_Highlight);
            }
        }
        this.f4971t0.clear();
        this.f4973v.removeAllViews();
        ?? r2 = 0;
        if (cVar == null) {
            this.f4973v.setVisibility(8);
            if (TextUtils.isEmpty(str2)) {
                this.u.setVisibility(8);
                return;
            }
            this.u.setVisibility(0);
            if (i2 > 0) {
                this.u.setMaxWidth(i2);
            }
            if ("text/html".equals(str3)) {
                this.u.setText(Html.fromHtml(str2));
                return;
            } else {
                CharSequence charSequenceH = this.f4928F.h();
                this.f4928F.e0(w(this.u, charSequenceH == null ? com.android.mmt.util.e0.b(this.u, str2, this.f4964o0, R.style.TextAppearance_MessageBody_Highlight) : charSequenceH, null, charSequenceH));
                return;
            }
        }
        this.u.setVisibility(8);
        this.f4973v.setVisibility(0);
        ArrayList<Object> arrayListC = cVar.c();
        int i7 = 0;
        while (i7 < arrayListC.size()) {
            Object obj = arrayListC.get(i7);
            if (obj instanceof c.a) {
                final c.a aVar = (c.a) obj;
                boolean z7 = i7 == 0 ? true : z6;
                int i8 = this.f4939T;
                if (this.f4928F.N()) {
                    zP = P(this.f4928F);
                    iE = E(this.f4928F);
                } else {
                    iE = i8;
                    zP = z6;
                }
                final Context context = getContext();
                Objects.requireNonNull(this.f4928F);
                int i9 = this.f4928F.L() ? R.drawable.bookmark_timed_contact_card_bg : !zP ? R.drawable.contact_card_covered_bg_n : z4 ? R.drawable.contact_card_bg_out : R.drawable.contact_card_bg_in;
                LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.contact_message_list_item, r2);
                linearLayout.setBackgroundResource(i9);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.card_name);
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.card_name_layout);
                LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.card_details);
                View viewFindViewById = linearLayout.findViewById(R.id.card_divider);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.bubble_padding_left);
                int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.bubble_padding_right);
                int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.card_background_covered_padding);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
                if (zP) {
                    dimensionPixelSize3 = dimensionPixelSize;
                }
                layoutParams.setMarginStart(dimensionPixelSize3);
                layoutParams.setMarginEnd(zP ? dimensionPixelSize2 : dimensionPixelSize3);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
                layoutParams2.setMarginStart(zP ? dimensionPixelSize : dimensionPixelSize3);
                layoutParams2.setMarginEnd(zP ? dimensionPixelSize2 : dimensionPixelSize3);
                if (zP) {
                    linearLayout2.getLayoutParams().width = iE;
                }
                final ArrayList<Pair<String, String>> arrayListB = aVar.b();
                final int i10 = 0;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.android.mmt.util.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        String str4;
                        switch (i10) {
                            case 0:
                                Context context2 = context;
                                Pair pair = (Pair) ((ArrayList) arrayListB).get(((Integer) view2.getTag()).intValue());
                                if (!"vnd.android.cursor.item/phone_v2".equals(pair.first)) {
                                    str4 = "vnd.android.cursor.item/email_v2".equals(pair.first) ? "mailto:" : "tel:";
                                }
                                StringBuilder sbD = D2.e.d(str4);
                                sbD.append((String) pair.second);
                                b0.b(context2, b0.a(sbD.toString()), null);
                                break;
                            default:
                                Context context3 = context;
                                c.a aVar2 = (c.a) arrayListB;
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setType("vnd.android.cursor.dir/preview_contact");
                                intent.putExtra("insert_instantly", true);
                                Objects.requireNonNull(G0.d.b(context3));
                                if (aVar2 != null) {
                                    ArrayMap arrayMap = new ArrayMap();
                                    Iterator<Pair<String, String>> it = aVar2.b().iterator();
                                    while (it.hasNext()) {
                                        Pair<String, String> next = it.next();
                                        ArrayList arrayList3 = (ArrayList) arrayMap.get(next.first);
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                            arrayMap.put((String) next.first, arrayList3);
                                        }
                                        arrayList3.add((String) next.second);
                                    }
                                    for (Map.Entry entry : arrayMap.entrySet()) {
                                        intent.putStringArrayListExtra((String) entry.getKey(), (ArrayList) entry.getValue());
                                    }
                                }
                                context3.startActivity(intent);
                                break;
                        }
                    }
                };
                arrayList = arrayListC;
                int i11 = 0;
                while (i11 < arrayListB.size()) {
                    Pair<String, String> pair = arrayListB.get(i11);
                    int i12 = iE;
                    if ("vnd.android.cursor.item/name".equals(pair.first)) {
                        textView2.setText((CharSequence) pair.second);
                        arrayList2 = arrayListB;
                        z5 = z7;
                        i5 = i7;
                        view = viewFindViewById;
                        textView = textView2;
                    } else {
                        viewFindViewById.setVisibility(0);
                        arrayListB.size();
                        G0.d dVarB = G0.d.b(context);
                        arrayList2 = arrayListB;
                        boolean zEquals = "vnd.android.cursor.item/phone_v2".equals(pair.first);
                        view = viewFindViewById;
                        boolean zEndsWith = "vnd.android.cursor.item/email_v2".endsWith((String) pair.first);
                        textView = textView2;
                        String str4 = String.format("%s", dVarB.c(context, (String) pair.first));
                        String str5 = (String) pair.second;
                        boolean z8 = zEndsWith || zEquals;
                        View viewInflate = LayoutInflater.from(context).inflate(R.layout.contact_message_list_item_details, (ViewGroup) linearLayout, false);
                        viewInflate.setBackgroundResource(R.drawable.contact_card_item_bg_n);
                        TextView textView3 = (TextView) viewInflate.findViewById(R.id.card_tag);
                        TextView textView4 = (TextView) viewInflate.findViewById(R.id.card_text);
                        i5 = i7;
                        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.arrow);
                        if (TextUtils.isEmpty(str4)) {
                            z5 = z7;
                            textView3.setVisibility(8);
                        } else {
                            z5 = z7;
                            textView3.setVisibility(0);
                            textView3.setText(str4);
                        }
                        imageView.setVisibility(z8 ? 0 : 8);
                        textView4.setText(str5);
                        viewInflate.setTag(Integer.valueOf(i11));
                        viewInflate.setOnClickListener(onClickListener);
                        linearLayout3.addView(viewInflate);
                    }
                    i11++;
                    iE = i12;
                    arrayListB = arrayList2;
                    viewFindViewById = view;
                    textView2 = textView;
                    i7 = i5;
                    z7 = z5;
                }
                boolean z9 = z7;
                i4 = i7;
                int i13 = iE;
                if (!z4) {
                    View viewFindViewById2 = linearLayout.findViewById(R.id.insert);
                    viewFindViewById2.setVisibility(0);
                    final int i14 = 1;
                    viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.android.mmt.util.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            String str42;
                            switch (i14) {
                                case 0:
                                    Context context2 = context;
                                    Pair pair2 = (Pair) ((ArrayList) aVar).get(((Integer) view2.getTag()).intValue());
                                    if (!"vnd.android.cursor.item/phone_v2".equals(pair2.first)) {
                                        str42 = "vnd.android.cursor.item/email_v2".equals(pair2.first) ? "mailto:" : "tel:";
                                    }
                                    StringBuilder sbD = D2.e.d(str42);
                                    sbD.append((String) pair2.second);
                                    b0.b(context2, b0.a(sbD.toString()), null);
                                    break;
                                default:
                                    Context context3 = context;
                                    c.a aVar2 = (c.a) aVar;
                                    Intent intent = new Intent("android.intent.action.VIEW");
                                    intent.setType("vnd.android.cursor.dir/preview_contact");
                                    intent.putExtra("insert_instantly", true);
                                    Objects.requireNonNull(G0.d.b(context3));
                                    if (aVar2 != null) {
                                        ArrayMap arrayMap = new ArrayMap();
                                        Iterator<Pair<String, String>> it = aVar2.b().iterator();
                                        while (it.hasNext()) {
                                            Pair<String, String> next = it.next();
                                            ArrayList arrayList3 = (ArrayList) arrayMap.get(next.first);
                                            if (arrayList3 == null) {
                                                arrayList3 = new ArrayList();
                                                arrayMap.put((String) next.first, arrayList3);
                                            }
                                            arrayList3.add((String) next.second);
                                        }
                                        for (Map.Entry entry : arrayMap.entrySet()) {
                                            intent.putStringArrayListExtra((String) entry.getKey(), (ArrayList) entry.getValue());
                                        }
                                    }
                                    context3.startActivity(intent);
                                    break;
                            }
                        }
                    });
                }
                int i15 = zP ? -2 : i13;
                if (this.f4928F.L()) {
                    i15 = -1;
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i15, -2);
                if (!z9) {
                    layoutParams3.topMargin = (int) getResources().getDimension(R.dimen.bubble_top_margin_minimum);
                }
                this.f4973v.addView(linearLayout, layoutParams3);
            } else {
                boolean z10 = i7 == 0 ? true : z6;
                boolean zP2 = this.f4928F.N() ? P(this.f4928F) : z6;
                View viewInflate2 = View.inflate(this.f4953j, zP2 ? R.layout.contact_message_item : R.layout.contact_message_item_covered, r2);
                TextView textView5 = (TextView) viewInflate2.findViewById(R.id.message_body);
                textView5.setLineSpacing(textView5.getLineSpacingExtra(), Float.parseFloat(this.f4953j.getResources().getStringArray(R.array.bubble_body_line_spacing_multiplier)[com.android.mmt.util.e0.d(this.f4953j)]));
                if (zP2) {
                    textView5.setTextColor(this.u.getTextColors());
                    textView5.setLinkTextColor(getResources().getColorStateList(z4 ? R.color.message_highlight_text_out_color : R.color.message_highlight_text_in_color));
                    if (i6 > 0) {
                        textView5.setMaxWidth(i6);
                    }
                }
                textView5.setAutoLinkMask(23);
                N(textView5);
                textView5.setLinksClickable(z6);
                w(textView5, obj.toString(), r2, r2);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(zP2 ? -2 : -1, -2);
                if (!z10) {
                    layoutParams4.topMargin = (int) getResources().getDimension(R.dimen.bubble_top_margin_minimum);
                }
                this.f4973v.addView(viewInflate2, layoutParams4);
                this.f4971t0.add(textView5);
                viewInflate2.setBackgroundResource(zP2 ? this.q0 : R.drawable.message_covered_bg);
                arrayList = arrayListC;
                i4 = i7;
            }
            i7 = i4 + 1;
            i6 = i2;
            arrayListC = arrayList;
            r2 = 0;
            z6 = false;
        }
    }

    private void B(C0243g0 c0243g0) {
        c0243g0.W();
        View view = this.f4933K;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void C(C0243g0 c0243g0) {
        View viewFindViewById;
        long jQ = c0243g0.q();
        if (c0243g0.S()) {
            Context context = this.f4953j;
            int i2 = P0.r.f937c;
            String strC = C3.c.c(context, jQ);
            if (this.f4963o != null) {
                if (c0243g0.R() || c0243g0.W()) {
                    this.f4963o.setVisibility(8);
                } else {
                    this.f4963o.setVisibility(0);
                    this.f4963o.setText(c0243g0.l());
                }
            }
            TextView textView = this.f4965q;
            if (textView != null) {
                textView.setText(strC != null ? strC : "");
            }
            if (this.f4966r != null) {
                z(c0243g0);
                return;
            }
            return;
        }
        if (!c0243g0.N()) {
            Context context2 = this.f4953j;
            int i4 = P0.r.f937c;
            String strC2 = C3.c.c(context2, jQ);
            TextView textView2 = this.f4963o;
            if (textView2 != null) {
                textView2.setText(this.f4953j.getString(R.string.phrase_from, c0243g0.l()));
            }
            TextView textView3 = this.f4965q;
            if (textView3 != null) {
                textView3.setText(strC2 != null ? strC2 : "");
            }
            if (this.f4966r != null) {
                z(c0243g0);
                return;
            }
            return;
        }
        String strQ = c0243g0.C() ? P0.r.q(this.f4953j, jQ) : null;
        if (strQ == null) {
            TextView textView4 = this.f4965q;
            if (textView4 != null) {
                textView4.setVisibility(8);
                this.f4966r.setVisibility(8);
            }
            if (this.p != null) {
                if (this.f4965q.getVisibility() == 8 && this.f4966r.getVisibility() == 8) {
                    this.p.setVisibility(8);
                    return;
                } else {
                    this.p.setVisibility(0);
                    return;
                }
            }
            return;
        }
        if (this.p == null) {
            int i5 = this.f4969s0;
            int i6 = i5 == 1 ? R.id.message_item_bubble_in_date_indicator_stub : i5 == 2 ? R.id.message_item_bubble_out_date_indicator_stub : 0;
            if (i6 > 0) {
                ViewStub viewStub = (ViewStub) findViewById(i6);
                if (viewStub != null) {
                    if (com.android.mmt.util.e0.g(this.f4953j)) {
                        int i7 = this.f4969s0;
                        if (i7 == 1) {
                            viewStub.setLayoutResource(R.layout.message_item_bubble_indicator_in_hugeui);
                        } else if (i7 == 2) {
                            viewStub.setLayoutResource(R.layout.message_item_bubble_indicator_out_hugeui);
                        }
                    }
                    viewFindViewById = viewStub.inflate();
                } else {
                    viewFindViewById = findViewById(R.id.date_indicator_panel);
                }
                if (viewFindViewById == null) {
                    return;
                }
                this.p = viewFindViewById.findViewById(R.id.date_indicator_panel);
                this.f4965q = (TextView) viewFindViewById.findViewById(R.id.message_date);
                this.f4966r = (ImageView) viewFindViewById.findViewById(R.id.message_slot_id);
                if (com.android.mmt.util.e0.f()) {
                    this.f4961n = findViewById(R.id.status_divider);
                }
                if (this.f4959m == null) {
                    this.f4959m = (TextView) viewFindViewById.findViewById(R.id.deliver_status_text);
                }
                if (this.f4978z == null) {
                    this.f4978z = viewFindViewById.findViewById(R.id.btn_resend);
                }
            }
        }
        TextView textView5 = this.f4965q;
        if (textView5 != null) {
            textView5.setText(strQ);
            this.f4965q.setVisibility(0);
        }
        if (this.f4966r != null) {
            z(c0243g0);
        }
        if (this.p != null) {
            if (this.f4965q.getVisibility() == 8 && this.f4966r.getVisibility() == 8) {
                this.p.setVisibility(8);
            } else {
                this.p.setVisibility(0);
            }
        }
    }

    private H0.a D(int i2, long j2, boolean z4) {
        String strK;
        H0.a aVar = new H0.a();
        aVar.f256a = i2;
        if (i2 != 0) {
            if (i2 != 1) {
                strK = "";
            } else if (C0287t.D(1)) {
                strK = C0287t.k(1);
                aVar.f257b = C0287t.n(1);
            } else {
                strK = this.f4953j.getString(R.string.sim_card2);
            }
        } else if (C0287t.D(0)) {
            strK = C0287t.k(0);
            aVar.f257b = C0287t.n(0);
        } else {
            strK = this.f4953j.getString(R.string.sim_card1);
        }
        aVar.f258c = strK;
        aVar.d = j2;
        aVar.f259e = z4;
        aVar.f260f = false;
        return aVar;
    }

    private int E(C0243g0 c0243g0) {
        if (!c0243g0.N()) {
            return 0;
        }
        int dimensionPixelSize = this.f4939T;
        if (this.f4962n0) {
            dimensionPixelSize -= com.android.mmt.util.e0.d(this.f4953j) == 5 ? this.f4953j.getResources().getDimensionPixelSize(R.dimen.max_bubble_text_width_checkbox_diff_godzillaui) : com.android.mmt.util.e0.d(this.f4953j) == 4 ? this.f4953j.getResources().getDimensionPixelSize(R.dimen.max_bubble_text_width_checkbox_diff_hugeui) : this.f4953j.getResources().getDimensionPixelSize(R.dimen.max_bubble_text_width_checkbox_diff);
        }
        return (!c0243g0.U() || c0243g0.w() == 1) ? dimensionPixelSize : dimensionPixelSize - this.f4936Q;
    }

    private boolean H(C0243g0 c0243g0) {
        if (c0243g0.U() && TextUtils.isEmpty(c0243g0.g()) && TextUtils.isEmpty(c0243g0.F())) {
            if (!(c0243g0.w() == 5)) {
                return true;
            }
        }
        return false;
    }

    private void I(Uri uri) {
        Intent intent = new Intent(this.f4953j, (Class<?>) SlideshowActivity.class);
        intent.setData(uri);
        intent.putExtra("highlight", this.f4964o0);
        Log.d("MessageListItem", "launchSlideshow: testing:");
        this.f4953j.startActivity(intent);
    }

    private void N(TextView textView) {
        if (this.f4953j instanceof NewMessagePopupActivity) {
            textView.setAutoLinkMask(0);
        }
    }

    private boolean P(C0243g0 c0243g0) {
        return c0243g0.Z() && c0243g0.k() != null;
    }

    private boolean Q() {
        if (this.f4928F.U()) {
            if (this.f4928F.w() == 6) {
                return true;
            }
            if (this.f4928F.w() > 1 && this.f4928F.x() != null && this.f4928F.x().length() > 70) {
                return true;
            }
        }
        return false;
    }

    private void S(boolean z4, float f4) {
        if (this.f4928F == null || this.f4931I == null) {
            return;
        }
        boolean zM = getLayoutDirection() == 1 ? this.f4928F.M() : this.f4928F.O();
        Objects.requireNonNull(this.f4928F);
        boolean z5 = zM | false;
        int dimensionPixelSize = this.f4928F.S() ? this.f4938S + this.f4940U : this.f4938S - this.f4953j.getResources().getDimensionPixelSize(R.dimen.bubble_margin);
        if (z4) {
            if (z5) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4955k.getLayoutParams();
                layoutParams.setMarginEnd((int) (dimensionPixelSize * f4));
                this.f4955k.setLayoutParams(layoutParams);
            }
            View view = this.f4931I;
            if (view != null) {
                view.setAlpha(f4);
                float f5 = (0.2f * f4) + 0.8f;
                this.f4931I.setScaleX(f5);
                this.f4931I.setScaleY(f5);
            }
            TextView textView = this.f4959m;
            if (textView != null && textView.getVisibility() == 0) {
                this.f4959m.setAlpha(1.0f - f4);
            }
            View view2 = this.f4978z;
            if (view2 == null || view2.getVisibility() != 0) {
                return;
            }
            this.f4978z.setAlpha(1.0f - f4);
            return;
        }
        if (z5) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f4955k.getLayoutParams();
            layoutParams2.setMarginEnd((int) ((1.0f - f4) * dimensionPixelSize));
            this.f4955k.setLayoutParams(layoutParams2);
        }
        View view3 = this.f4931I;
        if (view3 != null) {
            view3.setAlpha(1.0f - f4);
            float f6 = 1.0f - (0.2f * f4);
            this.f4931I.setScaleX(f6);
            this.f4931I.setScaleY(f6);
            this.f4931I.setVisibility(0);
        }
        TextView textView2 = this.f4959m;
        if (textView2 != null && textView2.getVisibility() == 0) {
            this.f4959m.setAlpha(f4);
        }
        View view4 = this.f4978z;
        if (view4 == null || view4.getVisibility() != 0) {
            return;
        }
        this.f4978z.setAlpha(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        I0 i0J;
        C0243g0 c0243g0 = this.f4928F;
        if (c0243g0 == null || !c0243g0.U()) {
            return;
        }
        View view = this.f4957l;
        if (view == null || view.getVisibility() != 0) {
            if (Q()) {
                I(this.f4928F.v());
                return;
            }
            G0 g0D = this.f4928F.D();
            if (g0D.o()) {
                I(g0D.m());
                return;
            }
            if (!g0D.g() || (i0J = g0D.j()) == null) {
                return;
            }
            Intent intentB = i0J.B();
            try {
                this.f4953j.startActivity(intentB);
            } catch (ActivityNotFoundException unused) {
                intentB.setPackage("");
                this.f4953j.startActivity(intentB);
            }
        }
    }

    static void d(MessageListItem messageListItem, View view, long j2, boolean z4) {
        Objects.requireNonNull(messageListItem);
        if ((view.getContext() instanceof Activity) && com.android.mmt.util.e0.e((Activity) view.getContext())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(messageListItem.D(0, j2, z4));
            arrayList.add(messageListItem.D(1, j2, z4));
            P0.v vVar = new P0.v(view.getContext(), arrayList);
            g.a aVar = new g.a(view.getContext());
            aVar.x(R.string.resent_message);
            aVar.b(vVar, new DialogInterfaceOnClickListenerC0249j0(messageListItem, vVar));
            miuix.appcompat.app.g gVarA = aVar.a();
            messageListItem.f4967r0 = gVarA;
            gVarA.show();
        }
    }

    static void e(MessageListItem messageListItem, long j2, int i2, boolean z4) {
        Objects.requireNonNull(messageListItem);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("sub_id", Long.valueOf(C0287t.m(i2)));
        Context context = messageListItem.f4953j;
        ContentResolver contentResolver = context.getContentResolver();
        com.android.mmt.util.O.g(context, contentResolver, z4 ? Telephony.Sms.CONTENT_URI : Telephony.Mms.CONTENT_URI, contentValues, "_id=" + j2, null);
    }

    static void j(MessageListItem messageListItem) {
        Pair<Long, ArrayMap<TextView, Integer>> pair = messageListItem.f4951i;
        if (pair == null || messageListItem.f4928F == null || ((Long) pair.first).longValue() != messageListItem.f4928F.z()) {
            return;
        }
        for (Map.Entry entry : ((ArrayMap) messageListItem.f4951i.second).entrySet()) {
            TextView textView = (TextView) entry.getKey();
            Integer num = (Integer) entry.getValue();
            if (num != null) {
                textView.setAutoLinkMask(num.intValue());
            }
        }
    }

    private void r(C0243g0 c0243g0) {
        if (this.f4932J == null) {
            return;
        }
        if (c0243g0.N() && H(c0243g0)) {
            this.f4932J.b(this.f4953j.getResources().getDrawable(this.M), this.f4934N);
        } else {
            if (c0243g0.w() == 5) {
                this.f4932J.b(null, 0);
            } else {
                this.f4932J.b(this.f4953j.getResources().getDrawable(this.f4943a0), 0);
            }
        }
        this.f4932J.f(this.f4935O == 0 ? null : this.f4953j.getResources().getDrawable(this.f4935O), this.P == 0 ? null : this.f4953j.getResources().getDrawable(this.P));
        if (C0.a.d(c0243g0) == 2 || C0.a.d(c0243g0) == 6) {
            G0 g0D = c0243g0.D();
            if (g0D.g()) {
                this.f4932J.setVisibility(0);
                I0 i0J = g0D.j();
                if (i0J != null) {
                    ((com.bumptech.glide.h) ((com.bumptech.glide.h) C0384b.y(getContext()).r(i0J.i()).g().P()).i()).g0(this.f4932J);
                    return;
                }
                return;
            }
            return;
        }
        int iW = c0243g0.w();
        if (iW != 1) {
            if (iW == 3) {
                this.f4932J.setVisibility(0);
                if (H(c0243g0)) {
                    this.f4932J.b(null, this.f4934N);
                    this.f4932J.d(c0243g0.O() ? R.drawable.message_attachment_audio_out : R.drawable.message_attachment_audio_in, false);
                    return;
                } else {
                    this.f4932J.b(null, 0);
                    this.f4932J.d(R.drawable.message_attachment_audio_new, true);
                    return;
                }
            }
            if (iW == 4) {
                this.f4932J.setVisibility(0);
                if (H(c0243g0)) {
                    this.f4932J.b(null, this.f4934N);
                    this.f4932J.d(c0243g0.O() ? R.drawable.message_attachment_video_out : R.drawable.message_attachment_video_in, false);
                    return;
                } else {
                    this.f4932J.b(null, 0);
                    this.f4932J.d(R.drawable.message_attachment_video_new, true);
                    return;
                }
            }
            if (iW == 5) {
                this.f4932J.setVisibility(0);
                this.f4932J.setImageResource(R.drawable.message_attachment_card);
                return;
            }
            this.f4932J.setVisibility(0);
            if (this.f4970t.getVisibility() == 8 && this.u.getVisibility() == 8) {
                this.f4932J.b(null, this.f4934N);
                this.f4932J.d(c0243g0.O() ? R.drawable.message_attachment_default_out : R.drawable.message_attachment_default_in, false);
            } else {
                this.f4932J.b(null, 0);
                this.f4932J.d(R.drawable.message_attachment_default_new, false);
            }
        }
    }

    private void s(C0243g0 c0243g0) throws Resources.NotFoundException {
        String strF = c0243g0.F();
        boolean zV = c0243g0.V();
        if (c0243g0.N()) {
            if (Q() && this.p0 == null) {
                this.u.setMaxLines(TextUtils.isEmpty(strF) ? 3 : 2);
                this.u.setEllipsize(TextUtils.TruncateAt.END);
                this.u.setAutoLinkMask(0);
            } else {
                this.u.setMaxHeight(Integer.MAX_VALUE);
                this.u.setEllipsize(null);
                this.u.setAutoLinkMask(23);
                N(this.u);
            }
            if (zV) {
                this.u.setTextColor(getResources().getColorStateList(R.color.message_text_out_color));
            }
        }
        int iE = E(c0243g0);
        if (c0243g0.R() && c0243g0.Y()) {
            A(strF, c0243g0.A(), c0243g0.G(), c0243g0.B(), iE, true);
            return;
        }
        String strG = this.p0;
        if (strG == null) {
            strG = c0243g0.g();
        }
        A(strF, strG, c0243g0.G(), c0243g0.k(), iE, zV);
    }

    private void u(boolean z4, boolean z5) {
        ViewStub viewStub;
        if (!this.f4962n0) {
            View view = this.f4931I;
            if (view != null) {
                view.setVisibility(8);
                S(false, 1.0f);
                return;
            }
            return;
        }
        if (this.f4931I == null && (viewStub = (ViewStub) findViewById(R.id.checkbox_container)) != null) {
            this.f4931I = viewStub.inflate();
            this.f4930H = (CheckBox) findViewById(android.R.id.checkbox);
        }
        this.f4930H.setChecked(z4);
        if (z5) {
            return;
        }
        this.f4930H.setChecked(z4);
        this.f4931I.setVisibility(0);
        S(true, 1.0f);
    }

    private CharSequence w(TextView textView, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        URLSpan[] uRLSpanArr;
        CharSequence charSequence4;
        ArrayMap arrayMap;
        int i2;
        URLSpan uRLSpan;
        if (charSequence2 instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence2;
            uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        } else {
            uRLSpanArr = null;
        }
        if (TextUtils.isEmpty(charSequence3)) {
            SpannableString spannableString = new SpannableString(charSequence);
            Linkify.addLinks(spannableString, textView.getAutoLinkMask());
            charSequence4 = spannableString;
        } else {
            charSequence4 = charSequence3;
        }
        if (charSequence4 instanceof Spannable) {
            Spannable spannable2 = (Spannable) charSequence4;
            URLSpan[] uRLSpanArr2 = (URLSpan[]) spannable2.getSpans(0, spannable2.length(), URLSpan.class);
            SpannableString spannableString2 = new SpannableString(spannable2);
            int i4 = 0;
            for (URLSpan uRLSpan2 : uRLSpanArr2) {
                if (uRLSpanArr != null && uRLSpanArr2.length > uRLSpanArr.length) {
                    break;
                }
                int spanStart = spannable2.getSpanStart(uRLSpan2);
                int spanEnd = spannable2.getSpanEnd(uRLSpan2);
                if (spanStart >= 0 && spanEnd >= 0 && spanEnd <= spannable2.length()) {
                    if (uRLSpanArr != null) {
                        i2 = i4 + 1;
                        uRLSpan = uRLSpanArr[i4];
                    } else {
                        i2 = i4;
                        uRLSpan = null;
                    }
                    spannableString2.setSpan(new a(uRLSpan, uRLSpan2), spanStart, spanEnd, 34);
                    spannableString2.removeSpan(uRLSpan2);
                    i4 = i2;
                }
                String scheme = Uri.parse(uRLSpan2.getURL()).getScheme();
                if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                    "rtsp".equalsIgnoreCase(scheme);
                }
            }
            SpannedString spannedString = new SpannedString(spannableString2);
            if (this.f4972u0) {
                Pair<Long, ArrayMap<TextView, Integer>> pair = this.f4951i;
                if (pair == null || ((Long) pair.first).longValue() != this.f4928F.z()) {
                    arrayMap = new ArrayMap();
                    this.f4951i = new Pair<>(Long.valueOf(this.f4928F.z()), arrayMap);
                } else {
                    arrayMap = (ArrayMap) this.f4951i.second;
                }
                arrayMap.put(textView, Integer.valueOf(textView.getAutoLinkMask()));
                textView.setAutoLinkMask(0);
            }
            textView.setText(spannedString);
        }
        C0243g0 c0243g0 = this.f4928F;
        if (c0243g0 != null) {
            Objects.requireNonNull(c0243g0);
        }
        textView.setOnTouchListener(new b());
        return charSequence4;
    }

    private void x(C0243g0 c0243g0) {
        boolean z4;
        String string;
        C(c0243g0);
        if (c0243g0.R() || !c0243g0.T()) {
            View view = this.f4968s;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            if (this.f4968s == null) {
                ViewStub viewStub = (ViewStub) findViewById(R.id.favorite_and_rcs_progress_layout);
                if (viewStub != null) {
                    viewStub.inflate();
                }
                ViewStub viewStub2 = (ViewStub) findViewById(R.id.favorite_icon_panel);
                if (viewStub2 != null) {
                    this.f4968s = viewStub2.inflate();
                }
            }
            View view2 = this.f4968s;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        if (this.f4959m != null) {
            String string2 = null;
            if (c0243g0.V()) {
                if (c0243g0.Q()) {
                    this.f4959m.setText(getContext().getString(R.string.message_failed));
                    this.f4959m.setVisibility(0);
                } else {
                    int iO = c0243g0.o();
                    if (iO != 0) {
                        if (c0243g0.Z()) {
                            if ((iO & 16) == 16) {
                                if (c0243g0.p() == 6) {
                                    string2 = getContext().getString(R.string.message_received);
                                } else if (c0243g0.p() == 4) {
                                    string2 = getContext().getString(R.string.message_pending);
                                }
                            }
                        } else if (c0243g0.U()) {
                            if (C0287t.x()) {
                                C0287t.q(c0243g0.E());
                            }
                            if ((iO & 4) == 4) {
                                if (c0243g0.p() == 6) {
                                    string = getContext().getString(R.string.message_received);
                                } else if (c0243g0.p() == 8) {
                                    string = getContext().getString(R.string.message_rejected);
                                } else if (c0243g0.i() == 4) {
                                    string = getContext().getString(R.string.message_pending);
                                }
                                string2 = string;
                            }
                            int i2 = iO & 1;
                        }
                        if (c0243g0.R() && c0243g0.Z()) {
                            this.f4959m.setVisibility(4);
                        } else if (string2 != null) {
                            this.f4959m.setVisibility(0);
                            this.f4959m.setText(string2);
                        } else {
                            this.f4959m.setVisibility(8);
                        }
                    } else {
                        this.f4959m.setVisibility(4);
                    }
                }
            }
        }
        if (this.f4978z != null) {
            if (c0243g0.V() && c0243g0.Q()) {
                this.f4978z.setFocusable(false);
                this.f4978z.setVisibility(0);
                if (this.f4962n0) {
                    this.f4978z.setEnabled(false);
                } else {
                    this.f4978z.setEnabled(true);
                    this.f4978z.setOnClickListener(new ViewOnClickListenerC0259o0(this, c0243g0));
                }
            } else {
                this.f4978z.setVisibility(8);
            }
        }
        if (this.f4961n == null) {
            return;
        }
        TextView textView = this.f4959m;
        if (textView != null) {
            z4 = (textView.getVisibility() == 0) | false;
        } else {
            z4 = false;
        }
        View view3 = this.f4978z;
        if (view3 != null) {
            z4 |= view3.getVisibility() == 0;
        }
        if (z4) {
            this.f4961n.setVisibility(0);
        } else {
            this.f4961n.setVisibility(8);
        }
    }

    private void z(C0243g0 c0243g0) {
        if (C0287t.e() <= 1) {
            this.f4966r.setVisibility(8);
            return;
        }
        int iR = C0287t.r(c0243g0.E());
        if (iR == 0) {
            this.f4966r.setVisibility(0);
            this.f4966r.setImageResource(R.drawable.sim1_indicator);
            this.f4966r.setContentDescription(getResources().getString(R.string.sim_card1));
        } else {
            if (iR != 1) {
                this.f4966r.setVisibility(8);
                return;
            }
            this.f4966r.setVisibility(0);
            this.f4966r.setImageResource(R.drawable.sim2_indicator);
            this.f4966r.setContentDescription(getResources().getString(R.string.sim_card2));
        }
    }

    public final C0243g0 F() {
        return this.f4928F;
    }

    final RecyclerView.o G(RecyclerView recyclerView, int i2) {
        RecyclerView.o oVar = this.f4974v0;
        if (oVar != null) {
            oVar.a(recyclerView, i2);
        }
        return this.f4974v0;
    }

    public final void J() {
        C0243g0 c0243g0;
        Context context = this.f4953j;
        if ((!(context instanceof r) || ((r) context).b2()) && (c0243g0 = this.f4928F) != null) {
            if (c0243g0.k() == null) {
                T();
                return;
            }
            C0157c c0157c = new C0157c(getContext());
            if (this.f4928F.U() && this.f4928F.D().g()) {
                c0157c.b(R.string.context_menu_view_mms, new d());
            }
            c0157c.d();
            c0157c.f();
        }
    }

    public final void K() {
        C0243g0 c0243g0 = this.f4928F;
        if (c0243g0 == null || !c0243g0.Z() || TextUtils.isEmpty(this.f4928F.g())) {
            return;
        }
        Intent intent = new Intent(this.f4953j, (Class<?>) MessageFullscreenActivity.class);
        intent.putExtra("body", this.f4928F.g());
        this.f4953j.startActivity(intent);
        ((miuix.appcompat.app.h) this.f4953j).overridePendingTransition(0, R.anim.no_anim);
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x068e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void L(C0243g0 c0243g0, boolean z4, boolean z5, boolean z6, String str, String str2) {
        View view;
        int i2;
        int dimensionPixelSize;
        int iY;
        View view2;
        View view3;
        this.f4962n0 = z4;
        this.f4928F = c0243g0;
        this.f4964o0 = str;
        this.p0 = str2;
        Objects.requireNonNull(c0243g0);
        ThumbnailView thumbnailView = this.f4932J;
        if (thumbnailView != null) {
            thumbnailView.setVisibility(8);
        }
        e eVar = this.f4976x;
        if (eVar != null && (view3 = eVar.d) != null) {
            view3.setVisibility(8);
        }
        Objects.requireNonNull(this.f4928F);
        View view4 = this.f4957l;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        if (c0243g0.L()) {
            s(c0243g0);
            if (c0243g0.U()) {
                y(c0243g0);
            }
            C(c0243g0);
            return;
        }
        f fVar = this.f4975w;
        if (fVar != null) {
            fVar.f4990a.setVisibility(8);
            this.f4975w.f4991b.setVisibility(8);
            this.f4975w.f4992c.setVisibility(8);
        }
        C0414a.I(this);
        if (c0243g0.M()) {
            this.f4929G.setVisibility(0);
        }
        this.M = this.f4943a0;
        this.f4934N = 0;
        this.f4935O = 0;
        int iS = c0243g0.s();
        int i4 = R.drawable.message_bubble_out_bg;
        switch (iS) {
            case 3:
                i4 = R.drawable.message_bubble_in_bg;
                this.f4934N = 1;
                this.M = this.f4944b0;
                this.f4935O = this.f4948f0;
                this.P = this.f4954j0;
                break;
            case 4:
                i4 = R.drawable.message_bubble_in_last_bg_n;
                this.f4934N = 1;
                this.M = this.f4945c0;
                this.f4935O = this.f4949g0;
                this.P = this.f4956k0;
                break;
            case 5:
            default:
                i4 = 0;
                break;
            case 6:
                this.f4934N = 2;
                this.M = this.f4946d0;
                this.f4935O = this.f4950h0;
                this.P = this.f4958l0;
                break;
            case 7:
                i4 = R.drawable.message_bubble_out_last_bg_n;
                this.f4934N = 2;
                this.M = this.f4947e0;
                this.f4935O = this.f4952i0;
                this.P = this.f4960m0;
                break;
            case 8:
                this.f4934N = 2;
                this.M = this.f4946d0;
                this.f4935O = this.f4950h0;
                this.P = this.f4958l0;
                break;
            case 9:
                i4 = R.drawable.message_bubble_out_last_bg;
                this.f4934N = 2;
                this.M = this.f4947e0;
                this.f4935O = this.f4952i0;
                this.P = this.f4960m0;
                break;
        }
        if (this.f4929G != null && (H(c0243g0) || P(c0243g0))) {
            this.f4929G.setBackground(null);
            this.f4929G.setPadding(0, 0, 0, 0);
        } else if (i4 != 0 && (view = this.f4929G) != null) {
            view.setBackgroundResource(i4);
            this.P = 0;
        }
        this.q0 = i4;
        u(z5, z6);
        x(c0243g0);
        if (c0243g0.u() == 130) {
            String str3 = this.f4953j.getString(R.string.message_size_label) + String.valueOf((c0243g0.t() + 1023) / 1024) + this.f4953j.getString(R.string.kilobyte) + '\n' + c0243g0.r();
            if (!c0243g0.N()) {
                i2 = 0;
            } else {
                if (this.f4962n0) {
                    dimensionPixelSize = (this.f4939T - this.f4937R) - (com.android.mmt.util.e0.d(this.f4953j) == 5 ? this.f4953j.getResources().getDimensionPixelSize(R.dimen.max_bubble_text_width_checkbox_diff_godzillaui) : com.android.mmt.util.e0.d(this.f4953j) == 4 ? this.f4953j.getResources().getDimensionPixelSize(R.dimen.max_bubble_text_width_checkbox_diff_hugeui) : this.f4953j.getResources().getDimensionPixelSize(R.dimen.max_bubble_text_width_checkbox_diff));
                    this.u.setMaxHeight(Integer.MAX_VALUE);
                    this.u.setEllipsize(null);
                    this.u.setAutoLinkMask(23);
                    N(this.u);
                    A(c0243g0.F(), str3, "text/plain", null, dimensionPixelSize, false);
                    iY = c0243g0.y() & (-5);
                    if (iY != 0) {
                        View view5 = this.f4923A;
                        if (view5 != null) {
                            view5.setVisibility(8);
                        }
                    } else if (this.f4923A != null) {
                        this.f4923A.setVisibility(0);
                        view2 = this.L;
                        if (view2 != null) {
                            view2.setVisibility(0);
                        }
                        if (iY == 129) {
                            this.f4925C.clearAnimation();
                            this.f4925C.setVisibility(8);
                            this.f4926D.setVisibility(8);
                            this.f4924B.setVisibility(0);
                            this.f4924B.setFocusable(false);
                            if (this.f4962n0) {
                                this.f4924B.setEnabled(false);
                            } else {
                                this.f4924B.setEnabled(true);
                                this.f4924B.setOnClickListener(new ViewOnClickListenerC0251k0(this, c0243g0));
                            }
                        } else {
                            if (com.android.mmt.transaction.l.d() == c0243g0.z()) {
                                this.f4926D.setVisibility(0);
                                this.f4925C.clearAnimation();
                                this.f4925C.setVisibility(8);
                                this.f4926D.setProgress(com.android.mmt.transaction.l.e());
                            } else {
                                this.f4926D.setVisibility(8);
                                this.f4925C.setVisibility(0);
                                this.f4925C.startAnimation(AnimationUtils.loadAnimation(this.f4953j, R.anim.pending));
                            }
                            this.f4924B.setVisibility(8);
                        }
                    } else {
                        ViewStub viewStub = (ViewStub) findViewById(R.id.mms_download_controls);
                        if (viewStub != null) {
                            this.f4923A = viewStub.inflate();
                            this.f4924B = (Button) findViewById(R.id.btn_download_msg);
                            this.f4925C = findViewById(R.id.download_pending);
                            ProgressBar progressBar = (ProgressBar) findViewById(R.id.download_progress);
                            this.f4926D = progressBar;
                            progressBar.setIndeterminate(true);
                            this.f4926D.setMax(100);
                            this.f4923A.setVisibility(0);
                            view2 = this.L;
                            if (view2 != null) {
                            }
                            if (iY == 129) {
                            }
                        }
                    }
                    B(c0243g0);
                    return;
                }
                i2 = this.f4939T - this.f4937R;
            }
            dimensionPixelSize = i2;
            this.u.setMaxHeight(Integer.MAX_VALUE);
            this.u.setEllipsize(null);
            this.u.setAutoLinkMask(23);
            N(this.u);
            A(c0243g0.F(), str3, "text/plain", null, dimensionPixelSize, false);
            iY = c0243g0.y() & (-5);
            if (iY != 0) {
            }
            B(c0243g0);
            return;
        }
        s(c0243g0);
        View view6 = this.f4923A;
        if (view6 != null) {
            view6.setVisibility(8);
        }
        View view7 = this.L;
        if (view7 != null) {
            view7.setVisibility(8);
        }
        if (c0243g0.O() && c0243g0.Z() && (c0243g0.W() || c0243g0.R() || c0243g0.X())) {
            if (this.f4975w == null) {
                this.f4975w = new f();
                View viewInflate = ((ViewStub) findViewById(R.id.group_send_to_panel)).inflate();
                f fVar2 = this.f4975w;
                fVar2.d = (LinearLayout) viewInflate;
                fVar2.f4990a = (TextView) viewInflate.findViewById(R.id.group_send_to_title);
                this.f4975w.f4991b = (TextView) viewInflate.findViewById(R.id.group_send_to);
                this.f4975w.f4992c = (TextView) viewInflate.findViewById(R.id.group_send_count);
                this.f4975w.f4990a.setVisibility(8);
                this.f4975w.f4991b.setVisibility(8);
                this.f4975w.f4992c.setVisibility(8);
            }
            if (c0243g0.W()) {
                this.f4975w.f4990a.setVisibility(0);
                this.f4975w.f4991b.setText(c0243g0.l());
                this.f4975w.f4991b.setVisibility(0);
            } else if (c0243g0.R()) {
                if (c0243g0.Y()) {
                    this.f4975w.f4990a.setVisibility(0);
                    this.f4975w.f4991b.setText(c0243g0.l());
                } else {
                    this.f4975w.f4990a.setVisibility(8);
                    int size = 0 - c0243g0.d().size();
                    this.f4975w.f4991b.setText(this.f4953j.getResources().getQuantityString(R.plurals.send_to_count, size, Integer.valueOf(size)));
                }
                this.f4975w.f4991b.setVisibility(0);
            } else if (c0243g0.X()) {
                this.f4975w.f4990a.setVisibility(8);
                this.f4975w.f4991b.setText(R.string.group_message);
                this.f4975w.f4991b.setVisibility(0);
            }
            this.f4975w.f4992c.setVisibility(8);
            ProgressBar progressBar2 = this.f4977y;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            if (c0243g0.R() && c0243g0.Y()) {
                int iD0 = c0243g0.d0() + 1;
                this.f4975w.f4992c.setText(this.f4953j.getResources().getString(R.string.send_to_index_contact, String.valueOf(iD0), String.valueOf(0)));
                this.f4975w.f4992c.setVisibility(0);
                if (this.f4977y == null) {
                    ProgressBar progressBar3 = (ProgressBar) ((ViewStub) findViewById(R.id.group_send_icon)).inflate();
                    this.f4977y = progressBar3;
                    progressBar3.setIndeterminate(true);
                    this.f4977y.setIndeterminateDrawable(getResources().getDrawable(R.drawable.group_send_progress_back));
                }
                ProgressBar progressBar4 = this.f4977y;
                if (progressBar4 != null) {
                    progressBar4.setVisibility(0);
                    this.f4977y.setMax(0);
                    this.f4977y.setProgress(iD0 - 1);
                }
            }
            boolean zP = P(c0243g0);
            f fVar3 = this.f4975w;
            if (zP) {
                fVar3.d.setPadding(0, 0, (int) MessageListItem.this.getResources().getDimension(R.dimen.card_group_send_view_padding_right), 0);
                fVar3.f4990a.setTextColor(MessageListItem.this.getResources().getColorStateList(R.color.message_desc_text_color));
                fVar3.f4991b.setTextColor(MessageListItem.this.getResources().getColorStateList(R.color.message_desc_text_color));
                fVar3.f4992c.setTextColor(MessageListItem.this.getResources().getColorStateList(R.color.message_desc_text_color));
            } else {
                fVar3.d.setPadding(0, 0, 0, 0);
                fVar3.f4990a.setTextColor(MessageListItem.this.getResources().getColorStateList(R.color.message_text_out_sendtitle_color));
                Objects.requireNonNull(MessageListItem.this.f4928F);
                fVar3.f4991b.setTextColor(MessageListItem.this.getResources().getColorStateList(R.color.message_text_out_color));
                fVar3.f4992c.setTextColor(MessageListItem.this.getResources().getColorStateList(R.color.message_text_out_color));
            }
        }
        if (c0243g0.Z() && c0243g0.R() && c0243g0.Q() && !c0243g0.Y()) {
            if (this.f4976x == null) {
                this.f4976x = new e();
                View viewInflate2 = ((ViewStub) findViewById(R.id.group_send_failed_panel)).inflate();
                e eVar2 = this.f4976x;
                eVar2.d = viewInflate2;
                eVar2.f4987a = (TextView) viewInflate2.findViewById(R.id.group_message_failed_title);
                this.f4976x.f4988b = (Button) viewInflate2.findViewById(R.id.group_btn_resend);
                this.f4976x.f4989c = (Button) viewInflate2.findViewById(R.id.group_btn_nosend);
            }
            this.f4976x.d.setVisibility(0);
            this.f4976x.f4987a.setText(this.f4953j.getResources().getQuantityString(R.plurals.group_message_failed_title, c0243g0.d().size(), Integer.valueOf(c0243g0.d().size())));
            ArrayList<C0243g0.a> arrayListD = c0243g0.d();
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.group_message_failed_items);
            viewGroup.removeAllViews();
            Iterator<C0243g0.a> it = arrayListD.iterator();
            while (it.hasNext()) {
                C0243g0.a next = it.next();
                View viewInflate3 = View.inflate(this.f4953j, R.layout.group_failed_item, null);
                TextView textView = (TextView) viewInflate3.findViewById(R.id.contact_info_name);
                TextView textView2 = (TextView) viewInflate3.findViewById(R.id.contact_info_number);
                CheckBox checkBox = (CheckBox) viewInflate3.findViewById(R.id.contact_info_checked);
                checkBox.setFocusable(false);
                if (this.f4962n0) {
                    checkBox.setEnabled(false);
                } else {
                    checkBox.setEnabled(true);
                    checkBox.setOnCheckedChangeListener(new C0253l0(this, c0243g0, next));
                }
                C0414a c0414aO = C0414a.O(next.f5597a);
                textView.setText(c0414aO.U());
                textView2.setText(c0414aO.W());
                if (c0414aO.U().equals(c0414aO.W())) {
                    textView2.setVisibility(4);
                } else {
                    textView2.setVisibility(0);
                }
                viewGroup.addView(viewInflate3);
            }
            this.f4976x.f4988b.setText(this.f4953j.getString(R.string.group_resend_message, Integer.valueOf(c0243g0.b0().size())));
            this.f4976x.f4988b.setFocusable(false);
            if (this.f4962n0) {
                this.f4976x.f4988b.setEnabled(false);
            } else {
                this.f4976x.f4988b.setEnabled(true);
                this.f4976x.f4988b.setOnClickListener(new ViewOnClickListenerC0255m0(this, c0243g0));
            }
            long jH = c0243g0.H();
            long jM = c0243g0.m();
            this.f4976x.f4989c.setFocusable(false);
            if (this.f4962n0) {
                this.f4976x.f4989c.setEnabled(false);
            } else {
                this.f4976x.f4989c.setEnabled(true);
                this.f4976x.f4989c.setOnClickListener(new ViewOnClickListenerC0257n0(jH, jM));
            }
        } else {
            e eVar3 = this.f4976x;
            if (eVar3 != null) {
                eVar3.d.setVisibility(8);
            }
        }
        B(c0243g0);
        if (c0243g0.U()) {
            r(c0243g0);
            if (c0243g0.N()) {
                if (this.f4932J.getVisibility() == 8 || H(c0243g0) || (this.u.getVisibility() == 8 && this.f4970t.getVisibility() == 8)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4932J.getLayoutParams();
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                    this.f4932J.setLayoutParams(layoutParams);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f4932J.getLayoutParams();
                if (c0243g0.O()) {
                    layoutParams2.leftMargin = this.f4942W;
                    layoutParams2.rightMargin = 0;
                } else {
                    layoutParams2.rightMargin = this.f4942W;
                    layoutParams2.leftMargin = 0;
                }
                this.f4932J.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<android.widget.TextView>] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList, java.util.List<android.widget.TextView>] */
    public final void M(float f4) {
        StaticTextView staticTextView = this.u;
        if (staticTextView != null && staticTextView.getVisibility() == 0 && this.u.getTextSize() != f4) {
            this.u.setTextSize(0, f4);
        }
        TextView textView = this.f4970t;
        if (textView != null && textView.getVisibility() == 0 && this.f4970t.getTextSize() != f4) {
            this.f4970t.setTextSize(0, f4);
        }
        int size = this.f4971t0.size();
        for (int i2 = 0; i2 < size; i2++) {
            TextView textView2 = (TextView) this.f4971t0.get(i2);
            if (textView2 != null && textView2.getVisibility() == 0 && textView2.getTextSize() != f4) {
                textView2.setTextSize(0, f4);
            }
        }
    }

    public final void O() {
        StaticTextView staticTextView = this.u;
        if (staticTextView instanceof ExpandableTextView) {
            ((ExpandableTextView) staticTextView).e(this);
        }
    }

    public void R() {
        C0243g0 c0243g0 = this.f4928F;
        if (c0243g0 != null && c0243g0.U()) {
            P0.t.d().a(this.f4928F.z(), this.f4932J);
        }
        C0414a.n0(this);
        this.f4928F = null;
    }

    @Override // com.android.mmt.util.EditableListViewV2.e
    public final void a(boolean z4) {
        S(z4, 1.0f);
    }

    @Override // com.android.mmt.util.EditableListViewV2.e
    public final void b(boolean z4) {
        if (this.f4931I == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.checkbox_container);
            if (viewStub != null) {
                this.f4931I = viewStub.inflate();
                this.f4930H = (CheckBox) findViewById(android.R.id.checkbox);
            }
            this.f4931I.setVisibility(0);
            this.f4930H = (CheckBox) findViewById(android.R.id.checkbox);
        }
        this.f4931I.setVisibility(0);
        S(z4, 0.0f);
    }

    @Override // com.android.mmt.util.EditableListViewV2.e
    public final void c(boolean z4, float f4) {
        S(z4, f4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        View view;
        super.onMeasure(i2, i4);
        if (this.f4955k == null || (view = this.f4931I) == null || view.getVisibility() != 0) {
            return;
        }
        int measuredHeight = 0;
        View view2 = this.p;
        if (view2 != null && view2.getVisibility() == 0) {
            measuredHeight = (this.p.getMeasuredHeight() + this.f4941V) / 2;
        }
        ((ViewGroup.MarginLayoutParams) this.f4930H.getLayoutParams()).topMargin = measuredHeight;
    }

    public final void q(C0243g0 c0243g0) {
        this.f4969s0 = 0;
        this.f4955k = findViewById(R.id.bubble);
        this.f4957l = findViewById(R.id.bubble_holder);
        switch (c0243g0.s()) {
            case 0:
            case 1:
            case 2:
                findViewById(R.id.message_item_list_stub).setVisibility(0);
                findViewById(R.id.message_body_list_stub).setVisibility(0);
                break;
            case 3:
            case 4:
                this.f4969s0 = 1;
                findViewById(R.id.message_item_bubble_in_stub).setVisibility(0);
                break;
            case 6:
            case 7:
                this.f4969s0 = 2;
                ViewStub viewStub = (ViewStub) findViewById(R.id.message_item_bubble_out_stub);
                if (viewStub != null) {
                    if (com.android.mmt.util.e0.g(this.f4953j)) {
                        viewStub.setLayoutResource(R.layout.message_item_bubble_out_hugeui);
                    }
                    viewStub.inflate().setVisibility(0);
                    break;
                }
                break;
            case 8:
            case 9:
                this.f4969s0 = 2;
                ViewStub viewStub2 = (ViewStub) findViewById(R.id.message_item_bubble_out_alert_stub);
                if (viewStub2 != null) {
                    if (com.android.mmt.util.e0.g(this.f4953j)) {
                        viewStub2.setLayoutResource(R.layout.message_item_bubble_out_alert_hugeui);
                    }
                    View viewInflate = viewStub2.inflate();
                    if (viewInflate != null) {
                        viewInflate.setVisibility(0);
                        break;
                    }
                }
                break;
            case 11:
                ViewStub viewStub3 = (ViewStub) findViewById(R.id.message_body_list_stub);
                if (viewStub3 != null) {
                    viewStub3.setVisibility(0);
                    break;
                }
                break;
        }
        findViewById(R.id.message_item_container);
        if (this.f4969s0 == 0) {
            this.p = findViewById(R.id.date_indicator_panel);
            this.f4965q = (TextView) findViewById(R.id.message_date);
            if (c0243g0.L()) {
                this.f4966r = (ImageView) findViewById(R.id.message_slot_id);
            }
            this.f4963o = (TextView) findViewById(R.id.message_sender);
        }
        float f4 = Float.parseFloat(this.f4953j.getResources().getStringArray(R.array.bubble_body_line_spacing_multiplier)[com.android.mmt.util.e0.d(this.f4953j)]);
        TextView textView = (TextView) findViewById(R.id.message_subject);
        this.f4970t = textView;
        if (textView != null) {
            textView.setLineSpacing(textView.getLineSpacingExtra(), f4);
        }
        StaticTextView staticTextView = (StaticTextView) findViewById(R.id.message_body);
        this.u = staticTextView;
        if (staticTextView != null) {
            staticTextView.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            StaticTextView staticTextView2 = this.u;
            staticTextView2.setLineSpacing(staticTextView2.getLineSpacingExtra(), f4);
        }
        this.f4973v = (LinearLayout) findViewById(R.id.contact_message_body);
        this.f4959m = (TextView) findViewById(R.id.deliver_status_text);
        this.f4978z = findViewById(R.id.btn_resend);
        this.f4929G = findViewById(R.id.message_item);
        this.f4932J = (ThumbnailView) findViewById(R.id.attachment_preview);
        if (c0243g0.N()) {
            this.L = findViewById(R.id.mms_download_padding_view);
            this.f4933K = findViewById(R.id.timed_message_padding_view);
        }
    }

    public void t(C0414a c0414a) {
        Handler handler = this.f4927E;
        if (handler == null) {
            return;
        }
        handler.post(new c(c0414a));
    }

    public final CharSequence v(TextView textView, CharSequence charSequence, CharSequence charSequence2) {
        return w(textView, charSequence, charSequence2, null);
    }

    protected void y(C0243g0 c0243g0) {
        r(c0243g0);
    }
}
