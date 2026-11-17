package com.android.mmt.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.mmt.R;
import t.C0384b;
import x0.C0414a;
import x0.C0415b;

/* loaded from: classes.dex */
public class MultipleRecipientsConversationHeader extends RelativeLayout implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    private final Context f5078i;

    /* renamed from: j, reason: collision with root package name */
    private Button f5079j;

    /* renamed from: k, reason: collision with root package name */
    private MultipleRecipientsConversationHeader f5080k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f5081l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f5082m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f5083n;

    /* renamed from: o, reason: collision with root package name */
    private PopupWindow f5084o;
    private C0415b p;

    /* renamed from: q, reason: collision with root package name */
    private c f5085q;

    final class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            MultipleRecipientsConversationHeader.this.f5083n.setImageResource(R.drawable.show_contact_info_unchecked);
            MultipleRecipientsConversationHeader.this.f5083n.setContentDescription(MultipleRecipientsConversationHeader.this.f5078i.getString(R.string.button_unfold));
        }
    }

    private class b extends RelativeLayout {

        /* renamed from: i, reason: collision with root package name */
        private TextView f5087i;

        /* renamed from: j, reason: collision with root package name */
        private TextView f5088j;

        public b(Context context) {
            super(context);
            View.inflate(context, R.layout.multi_recipients_title_info_item, this);
            this.f5087i = (TextView) findViewById(R.id.contact_info_name);
            this.f5088j = (TextView) findViewById(R.id.contact_info_number);
        }

        public final void a(C0414a c0414a) {
            this.f5087i.setText(c0414a.U());
            this.f5088j.setText(c0414a.W());
            if (c0414a.U().equals(c0414a.W())) {
                this.f5088j.setVisibility(8);
            } else {
                this.f5088j.setVisibility(0);
            }
        }
    }

    private class c extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private Context f5089a;

        /* renamed from: b, reason: collision with root package name */
        private C0415b f5090b = new C0415b();

        public c(Context context) {
            this.f5089a = context;
        }

        final void b(C0415b c0415b) {
            if (c0415b != null) {
                this.f5090b.addAll(c0415b);
            }
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return this.f5090b.size();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i2) {
            return this.f5090b.get(i2);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar = (view == null || !(view instanceof b)) ? new b(this.f5089a) : (b) view;
            bVar.a(this.f5090b.get(i2));
            return bVar;
        }
    }

    public MultipleRecipientsConversationHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5078i = context;
    }

    private void c(boolean z4) {
        if (!z4) {
            PopupWindow popupWindow = this.f5084o;
            if (popupWindow != null) {
                popupWindow.dismiss();
                return;
            }
            return;
        }
        if (this.f5084o == null) {
            this.f5085q = new c(this.f5078i);
            View viewInflate = LayoutInflater.from(this.f5078i).inflate(R.layout.multi_recipients_title_info, (ViewGroup) null);
            ((ListView) viewInflate.findViewById(R.id.list_multi_recipient)).setAdapter((ListAdapter) this.f5085q);
            this.f5085q.b(this.p);
            PopupWindow popupWindow2 = new PopupWindow(viewInflate, -1, -2, true);
            this.f5084o = popupWindow2;
            popupWindow2.setOutsideTouchable(true);
            this.f5084o.setBackgroundDrawable(new ColorDrawable());
            this.f5084o.setOnDismissListener(new a());
        }
        this.f5084o.showAsDropDown(this.f5080k, 0, 0);
        this.f5083n.setImageResource(R.drawable.show_contact_info_checked);
        this.f5083n.setContentDescription(this.f5078i.getString(R.string.button_fold));
    }

    public final void d(C0415b c0415b) {
        int size;
        this.p = c0415b;
        String strH = "";
        if (c0415b != null) {
            size = c0415b.size();
            if (size != 0) {
                strH = size != 1 ? c0415b.h(", ") : c0415b.get(0).V();
            }
        } else {
            size = 0;
        }
        c cVar = this.f5085q;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        this.f5081l.setText(strH);
        if (size > 0) {
            this.f5082m.setText(this.f5078i.getResources().getQuantityString(R.plurals.to_count, size, Integer.valueOf(size)));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f5080k) {
            PopupWindow popupWindow = this.f5084o;
            if (popupWindow == null || !popupWindow.isShowing()) {
                c(true);
            } else {
                c(false);
            }
        }
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        this.f5080k = this;
        setOnClickListener(this);
        this.f5079j = (Button) findViewById(R.id.home);
        this.f5081l = (TextView) findViewById(R.id.to_title);
        this.f5082m = (TextView) findViewById(R.id.to_count);
        this.f5083n = (ImageView) findViewById(R.id.image_arrow);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        int measuredHeight = (((this.f5082m.getMeasuredHeight() + this.f5081l.getMeasuredHeight()) - this.f5079j.getMeasuredHeight()) / 2) + this.f5081l.getTop();
        int right = getLayoutDirection() == 1 ? i5 - this.f5079j.getRight() : this.f5079j.getLeft();
        Button button = this.f5079j;
        C0384b.l(button, right, measuredHeight, button.getMeasuredWidth() + right, button.getMeasuredHeight() + measuredHeight, getLayoutDirection() == 1, i5);
    }
}
