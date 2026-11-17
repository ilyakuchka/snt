package com.android.mmt.ui;

import P0.InterfaceC0164j;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.ActivityC0219o;
import androidx.fragment.app.Fragment;
import com.android.mmt.R;
import com.android.mmt.transaction.SendMessageService;
import com.android.mmt.ui.SizeAwareLinearLayout;
import com.android.mmt.util.C0287t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public class NewMessagePopupActivity extends ActivityC0219o {

    /* renamed from: v, reason: collision with root package name */
    private static NewMessagePopupActivity f5161v;
    private NewMessagePopupFragment u;

    public static class NewMessagePopupFragment extends Fragment implements SizeAwareLinearLayout.a, TextWatcher, View.OnClickListener, C0414a.c, InterfaceC0164j {

        /* renamed from: e0, reason: collision with root package name */
        private SizeAwareLinearLayout f5164e0;

        /* renamed from: f0, reason: collision with root package name */
        private ImageView f5165f0;

        /* renamed from: g0, reason: collision with root package name */
        private ImageView f5166g0;

        /* renamed from: h0, reason: collision with root package name */
        private View f5167h0;

        /* renamed from: i0, reason: collision with root package name */
        private TextView f5168i0;

        /* renamed from: j0, reason: collision with root package name */
        private TextView f5169j0;

        /* renamed from: k0, reason: collision with root package name */
        private ListView f5170k0;

        /* renamed from: l0, reason: collision with root package name */
        private EditText f5171l0;

        /* renamed from: m0, reason: collision with root package name */
        private TextView f5172m0;

        /* renamed from: n0, reason: collision with root package name */
        private Button f5173n0;

        /* renamed from: o0, reason: collision with root package name */
        private View f5174o0;
        private TextView p0;
        private TextView q0;

        /* renamed from: r0, reason: collision with root package name */
        private ImageView f5175r0;

        /* renamed from: s0, reason: collision with root package name */
        private View f5176s0;

        /* renamed from: t0, reason: collision with root package name */
        private View f5177t0;

        /* renamed from: u0, reason: collision with root package name */
        private x0 f5178u0;

        /* renamed from: v0, reason: collision with root package name */
        private int f5179v0;

        /* renamed from: c0, reason: collision with root package name */
        LinkedList<h> f5162c0 = new LinkedList<>();

        /* renamed from: d0, reason: collision with root package name */
        h f5163d0 = null;

        /* renamed from: w0, reason: collision with root package name */
        private Handler f5180w0 = new g();

        public static class MessagePopupLayout extends SizeAwareLinearLayout {

            /* renamed from: k, reason: collision with root package name */
            private Rect f5181k;

            public MessagePopupLayout(Context context, AttributeSet attributeSet) {
                super(context, attributeSet);
                this.f5181k = new Rect();
            }

            @Override // com.android.mmt.ui.SizeAwareLinearLayout, android.widget.LinearLayout, android.view.View
            protected final void onMeasure(int i2, int i4) {
                Window window = ((Activity) getContext()).getWindow();
                window.getDecorView().getWindowVisibleDisplayFrame(this.f5181k);
                Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
                int iMin = Math.min(defaultDisplay.getHeight() / 2, this.f5181k.height());
                if (iMin == 0) {
                    iMin = defaultDisplay.getHeight() / 2;
                }
                if (iMin > 0) {
                    i4 = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
                }
                super.onMeasure(i2, i4);
            }
        }

        final class a implements AdapterView.OnItemClickListener {
            a() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                NewMessagePopupFragment.d1(NewMessagePopupFragment.this);
            }
        }

        final class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMessagePopupFragment.e1(NewMessagePopupFragment.this);
            }
        }

        final class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMessagePopupFragment.f1(NewMessagePopupFragment.this);
            }
        }

        final class d implements View.OnClickListener {
            d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMessagePopupFragment.d1(NewMessagePopupFragment.this);
            }
        }

        final class e implements TextView.OnEditorActionListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f5186a;

            e(Activity activity) {
                this.f5186a = activity;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 4) {
                    return false;
                }
                if (TextUtils.isEmpty(NewMessagePopupFragment.this.f5171l0.getText())) {
                    Toast.makeText(this.f5186a, R.string.cannot_send_message, 1).show();
                    return false;
                }
                NewMessagePopupFragment.this.l1();
                return false;
            }
        }

        final class f implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ C0414a f5188i;

            f(C0414a c0414a) {
                this.f5188i = c0414a;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (C0414a.O(NewMessagePopupFragment.this.f5163d0.f5190a) == this.f5188i && com.android.mmt.util.e0.e(NewMessagePopupFragment.this.x())) {
                    NewMessagePopupFragment.this.n1(this.f5188i);
                }
            }
        }

        final class g extends Handler {
            g() {
            }

            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int i2 = message.what;
                super.handleMessage(message);
            }
        }

        class h {

            /* renamed from: a, reason: collision with root package name */
            public String f5190a;

            /* renamed from: b, reason: collision with root package name */
            public long f5191b;

            /* renamed from: c, reason: collision with root package name */
            ArrayList<C0243g0> f5192c;

            h() {
            }
        }

        static void d1(NewMessagePopupFragment newMessagePopupFragment) {
            if (newMessagePopupFragment.f5171l0.getText().length() > 0) {
                ((ClipboardManager) newMessagePopupFragment.x().getSystemService("clipboard")).setText(newMessagePopupFragment.f5171l0.getText());
                Toast.makeText(newMessagePopupFragment.x(), R.string.text_in_popup_saved_to_clipboard, 1).show();
            }
            ComposeMessageRouterActivity.e(newMessagePopupFragment.x(), ComposeMessageRouterActivity.a(newMessagePopupFragment.x(), C0416c.x(C0415b.l(newMessagePopupFragment.f5163d0.f5190a, false)).I()));
            newMessagePopupFragment.x().finish();
        }

        static void e1(NewMessagePopupFragment newMessagePopupFragment) {
            newMessagePopupFragment.f5173n0.setEnabled(false);
            ArrayList<C0243g0> arrayList = newMessagePopupFragment.f5163d0.f5192c;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ActivityC0219o activityC0219oX = newMessagePopupFragment.x();
                Uri uriV = arrayList.get(i2).v();
                int i4 = SendMessageService.f4514k;
                Intent intent = new Intent(activityC0219oX, (Class<?>) SendMessageService.class);
                intent.setAction("com.android.mmt.transaction.ACTION_DELETE_BACKGROUND");
                intent.putExtra("extra_uri", uriV.toString());
                activityC0219oX.startService(intent);
            }
            newMessagePopupFragment.j1();
            Q2.c.a(new w0(newMessagePopupFragment));
        }

        static void f1(NewMessagePopupFragment newMessagePopupFragment) {
            newMessagePopupFragment.f5173n0.setEnabled(false);
            newMessagePopupFragment.j1();
        }

        private void j1() {
            Iterator<h> it = this.f5162c0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() == this.f5163d0) {
                    it.remove();
                    break;
                }
            }
            if (this.f5162c0.isEmpty()) {
                NewMessagePopupActivity.z();
            } else {
                this.f5163d0 = this.f5162c0.getFirst();
                m1(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k1(Intent intent) {
            h hVar;
            boolean z4;
            Uri data = intent.getData();
            String stringExtra = intent.getStringExtra("body");
            long longExtra = intent.getLongExtra("time", 0L);
            int iT = C0287t.t(intent);
            this.f5179v0 = iT;
            long jM = C0287t.m(iT);
            String stringExtra2 = intent.getStringExtra("from");
            long longExtra2 = intent.getLongExtra("thread_id", 0L);
            C0243g0 c0243g0 = new C0243g0(x(), data, longExtra, stringExtra, jM, stringExtra2, longExtra2);
            Iterator<h> it = this.f5162c0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hVar = null;
                    break;
                }
                hVar = it.next();
                if (hVar.f5190a.equals(stringExtra2)) {
                    it.remove();
                    break;
                }
            }
            if (hVar == null) {
                hVar = new h();
                hVar.f5190a = stringExtra2;
                hVar.f5191b = longExtra2;
                hVar.f5192c = new ArrayList<>();
            }
            ArrayList<C0243g0> arrayList = hVar.f5192c;
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    z4 = false;
                    break;
                }
                C0243g0 c0243g02 = arrayList.get(i2);
                if (c0243g02.v() != null && c0243g0.v() != null && c0243g02.v().equals(c0243g0.v())) {
                    z4 = true;
                    break;
                }
                i2++;
            }
            if (!z4) {
                hVar.f5192c.add(c0243g0);
            }
            this.f5162c0.addFirst(hVar);
            h hVar2 = this.f5163d0;
            if (hVar2 == hVar) {
                m1(false);
                return;
            }
            if (hVar2 == null || this.f5171l0.getText().length() == 0) {
                this.f5163d0 = hVar;
                m1(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l1() {
            this.f5173n0.setEnabled(false);
            ActivityC0219o activityC0219oX = x();
            String str = this.f5163d0.f5190a;
            String string = this.f5171l0.getText().toString();
            int i2 = this.f5179v0;
            int i4 = SendMessageService.f4514k;
            Intent intent = new Intent(activityC0219oX, (Class<?>) SendMessageService.class);
            intent.setAction("com.android.mmt.transaction.SEND_SMS_BACKGROUND");
            intent.putExtra("extra_address", str);
            intent.putExtra("extra_text", string);
            intent.putExtra("extra_send_by_mx", false);
            intent.putExtra("slot_id", i2);
            activityC0219oX.startService(intent);
            j1();
        }

        private void m1(boolean z4) {
            C0414a c0414aO = C0414a.O(this.f5163d0.f5190a);
            c0414aO.m0(false, true);
            n1(c0414aO);
            this.f5178u0.f(this.f5163d0);
            this.f5178u0.notifyDataSetChanged();
            if (z4) {
                this.f5171l0.setText("");
            }
            this.f5173n0.setEnabled(this.f5171l0.getText().length() > 0);
            ActivityC0219o activityC0219oX = x();
            h hVar = this.f5163d0;
            String str = hVar.f5190a;
            long j2 = hVar.f5191b;
            int i2 = SendMessageService.f4514k;
            Intent intent = new Intent(activityC0219oX, (Class<?>) SendMessageService.class);
            intent.setAction("com.android.mmt.transaction.ACTION_MARK_READ_BACKGROUND");
            intent.putExtra("extra_address", str);
            intent.putExtra("extra_thread_id", j2);
            activityC0219oX.startService(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n1(C0414a c0414a) {
            if (c0414a.L()) {
                this.f5168i0.setText(c0414a.U());
            } else {
                if (c0414a.f8015b == 4) {
                    this.f5168i0.setText(c0414a.U());
                    this.f5169j0.setText(c0414a.W());
                } else {
                    this.f5168i0.setText(c0414a.W());
                }
            }
            com.android.mmt.transaction.d.B(C0416c.x(C0415b.l(this.f5163d0.f5190a, false)).I());
        }

        private void o1(int i2) {
            this.f5174o0.setVisibility(8);
            if (i2 == 0) {
                this.f5175r0.setImageResource(R.drawable.msg_edit_sim1);
                this.f5175r0.setContentDescription(Q(R.string.sim_card1));
                this.f5176s0.setSelected(true);
                this.f5177t0.setSelected(false);
                return;
            }
            if (i2 != 1) {
                return;
            }
            this.f5175r0.setImageResource(R.drawable.msg_edit_sim2);
            this.f5175r0.setContentDescription(Q(R.string.sim_card2));
            this.f5176s0.setSelected(false);
            this.f5177t0.setSelected(true);
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }

        @Override // P0.InterfaceC0164j
        public final void d(float f4) {
            EditText editText = this.f5171l0;
            if (editText != null) {
                editText.setTextSize(0, f4);
            }
            x0 x0Var = this.f5178u0;
            if (x0Var != null) {
                x0Var.e(f4);
            }
        }

        @Override // androidx.fragment.app.Fragment
        public final View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            ActivityC0219o activityC0219oX = x();
            SizeAwareLinearLayout sizeAwareLinearLayout = (SizeAwareLinearLayout) LayoutInflater.from(x()).inflate(R.layout.new_message_popup_activity, viewGroup, false);
            this.f5164e0 = sizeAwareLinearLayout;
            sizeAwareLinearLayout.a(this);
            com.android.mmt.util.e0.i(activityC0219oX);
            this.f5165f0 = (ImageView) this.f5164e0.findViewById(R.id.button_delete);
            this.f5166g0 = (ImageView) this.f5164e0.findViewById(R.id.button_dismiss);
            this.f5167h0 = this.f5164e0.findViewById(R.id.sender_panel);
            this.f5168i0 = (TextView) this.f5164e0.findViewById(R.id.msg_sender);
            this.f5169j0 = (TextView) this.f5164e0.findViewById(R.id.msg_sender_details);
            this.f5170k0 = (ListView) this.f5164e0.findViewById(android.R.id.list);
            this.f5171l0 = (EditText) this.f5164e0.findViewById(R.id.embedded_text_editor);
            this.f5172m0 = (TextView) this.f5164e0.findViewById(R.id.text_counter);
            this.f5173n0 = (Button) this.f5164e0.findViewById(R.id.send_button);
            this.f5164e0.findViewById(R.id.bottom_editor);
            if (C0287t.x()) {
                this.f5164e0.findViewById(R.id.new_message_popup_bottom_sim_button_stub).setVisibility(0);
                this.f5174o0 = this.f5164e0.findViewById(R.id.sim_button_container);
                View viewFindViewById = this.f5164e0.findViewById(R.id.sim_button1);
                this.f5176s0 = viewFindViewById;
                viewFindViewById.setOnClickListener(this);
                this.p0 = (TextView) this.f5164e0.findViewById(R.id.sim_button1_text);
                View viewFindViewById2 = this.f5164e0.findViewById(R.id.sim_button2);
                this.f5177t0 = viewFindViewById2;
                viewFindViewById2.setOnClickListener(this);
                this.q0 = (TextView) this.f5164e0.findViewById(R.id.sim_button2_text);
            }
            this.f5170k0.addFooterView(LayoutInflater.from(x()).inflate(R.layout.message_list_footer, (ViewGroup) null, false));
            this.f5170k0.setOnItemClickListener(new a());
            x0 x0Var = new x0(activityC0219oX);
            this.f5178u0 = x0Var;
            this.f5170k0.setAdapter((ListAdapter) x0Var);
            this.f5165f0.setOnClickListener(new b());
            this.f5166g0.setOnClickListener(new c());
            this.f5173n0.setOnClickListener(this);
            this.f5167h0.setOnClickListener(new d());
            this.f5171l0.addTextChangedListener(this);
            this.f5171l0.setOnEditorActionListener(new e(activityC0219oX));
            this.f5171l0.requestFocus();
            int i2 = P0.r.f937c;
            activityC0219oX.getTheme().resolveAttribute(android.R.attr.textCursorDrawable, new TypedValue(), true);
            k1(activityC0219oX.getIntent());
            if (C0287t.y()) {
                ImageView imageView = (ImageView) this.f5164e0.findViewById(R.id.send_slot_id);
                this.f5175r0 = imageView;
                if (this.f5179v0 == 1) {
                    imageView.setImageResource(R.drawable.msg_edit_sim2);
                    this.f5175r0.setContentDescription(Q(R.string.sim_card2));
                } else {
                    imageView.setImageResource(R.drawable.msg_edit_sim1);
                    this.f5175r0.setContentDescription(Q(R.string.sim_card1));
                }
                this.f5175r0.setVisibility(0);
                this.f5175r0.setOnClickListener(this);
                x();
                o1(this.f5179v0);
                x();
                String strK = C0287t.k(0);
                if (!TextUtils.isEmpty(strK)) {
                    this.p0.setText(strK);
                }
                x();
                String strK2 = C0287t.k(1);
                if (!TextUtils.isEmpty(strK2)) {
                    this.q0.setText(strK2);
                }
            } else {
                ImageView imageView2 = this.f5175r0;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                View view = this.f5174o0;
                if (view != null) {
                    view.setVisibility(8);
                }
            }
            return this.f5164e0;
        }

        @Override // com.android.mmt.ui.SizeAwareLinearLayout.a
        public final void l() {
        }

        @Override // androidx.fragment.app.Fragment
        public final void n0() {
            C0414a.n0(this);
            com.android.mmt.transaction.d.B(0L);
            super.n0();
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            switch (view.getId()) {
                case R.id.send_button /* 2131362271 */:
                    l1();
                    break;
                case R.id.send_slot_id /* 2131362273 */:
                    if (this.f5179v0 == 0) {
                        this.f5179v0 = 1;
                    } else {
                        this.f5179v0 = 0;
                    }
                    x();
                    o1(this.f5179v0);
                    break;
                case R.id.sim_button1 /* 2131362290 */:
                    this.f5179v0 = 0;
                    x();
                    o1(this.f5179v0);
                    break;
                case R.id.sim_button2 /* 2131362294 */:
                    this.f5179v0 = 1;
                    x();
                    o1(this.f5179v0);
                    break;
            }
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            this.f5173n0.setEnabled(charSequence.length() > 0);
            this.f5172m0.setText(P0.r.k(charSequence));
        }

        @Override // com.android.mmt.ui.SizeAwareLinearLayout.a
        public final void p(SizeAwareLinearLayout sizeAwareLinearLayout, int i2, int i4) {
            if (View.MeasureSpec.getMode(i4) != Integer.MIN_VALUE) {
                return;
            }
            if (this.f5171l0.getLineCount() <= 2) {
                this.f5172m0.setVisibility(8);
            } else {
                this.f5172m0.setVisibility(0);
            }
        }

        @Override // androidx.fragment.app.Fragment
        public final void p0() {
            super.p0();
            this.f5178u0.notifyDataSetChanged();
            C0414a.I(this);
            C0414a c0414aO = C0414a.O(this.f5163d0.f5190a);
            c0414aO.m0(false, true);
            n1(c0414aO);
        }

        @Override // androidx.fragment.app.Fragment
        public final void r0() {
            super.r0();
            P0.G.b().e(this, x());
            P0.G.b().g();
        }

        @Override // androidx.fragment.app.Fragment
        public final void s0() {
            P0.G.b();
            P0.G.a(this);
            super.s0();
        }

        @Override // x0.C0414a.c
        public final void t(C0414a c0414a) {
            Handler handler = this.f5180w0;
            if (handler != null) {
                handler.post(new f(c0414a));
            }
        }
    }

    public static void z() {
        NewMessagePopupActivity newMessagePopupActivity = f5161v;
        if (newMessagePopupActivity != null) {
            ((InputMethodManager) newMessagePopupActivity.getSystemService("input_method")).hideSoftInputFromWindow(newMessagePopupActivity.getWindow().getDecorView().getWindowToken(), 0);
            f5161v.finish();
            f5161v = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        f5161v = this;
        super.onCreate(bundle);
        androidx.fragment.app.w wVarU = u();
        NewMessagePopupFragment newMessagePopupFragment = (NewMessagePopupFragment) wVarU.T("dialog");
        androidx.fragment.app.E eF = wVarU.f();
        if (newMessagePopupFragment != null) {
            eF.n(newMessagePopupFragment);
        }
        NewMessagePopupFragment newMessagePopupFragment2 = new NewMessagePopupFragment();
        this.u = newMessagePopupFragment2;
        eF.b(android.R.id.content, newMessagePopupFragment2, "NewMessagePopupFragment");
        eF.p(this.u);
        eF.h();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        if (f5161v == this) {
            f5161v = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        NewMessagePopupFragment newMessagePopupFragment = this.u;
        if (newMessagePopupFragment != null) {
            newMessagePopupFragment.k1(intent);
        }
    }
}
