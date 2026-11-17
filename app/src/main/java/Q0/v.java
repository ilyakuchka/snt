package Q0;

import Q0.ViewOnClickListenerC0169b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mmt.R;
import com.android.mmt.ui.ServiceProviderConversationListActivity;
import x0.C0414a;
import x0.C0416c;

/* loaded from: classes.dex */
public final class v extends ViewOnClickListenerC0169b<L0.a> {

    /* renamed from: I, reason: collision with root package name */
    private ImageView f1174I;

    /* renamed from: J, reason: collision with root package name */
    private TextView f1175J;

    /* renamed from: K, reason: collision with root package name */
    private TextView f1176K;
    private char[] L;

    public v(View view, ViewOnClickListenerC0169b.InterfaceC0031b<L0.a> interfaceC0031b, ViewOnClickListenerC0169b.a aVar) throws Resources.NotFoundException {
        super(view, interfaceC0031b, aVar);
        this.L = new char[64];
        this.f1174I = (ImageView) view.findViewById(R.id.unread_indicator);
        this.f1175J = (TextView) view.findViewById(R.id.from);
        this.f1176K = (TextView) view.findViewById(R.id.subject);
        view.getContext().getResources().getDimension(R.dimen.multi_checkbox_size);
    }

    public final void G(int i2, L0.a aVar, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        String string;
        B(i2, aVar, z4, z6);
        this.f1174I.setVisibility((aVar.h() == 1) ^ true ? 0 : 8);
        TextView textView = this.f1175J;
        if (aVar.f() == -100) {
            string = this.f1089D.getContext().getString(R.string.block_messaging_entry_title);
        } else if (aVar.f() == -103) {
            string = this.f1089D.getContext().getString(R.string.sp_conversation_title);
        } else {
            C0416c c0416cV = C0416c.v(aVar.f());
            String strW = c0416cV.G().size() == 1 ? c0416cV.G().get(0).W() : null;
            if (C0414a.T() != 2) {
                z7 = true;
            } else {
                if (!TextUtils.isEmpty(strW)) {
                    synchronized (c0416cV) {
                    }
                }
                z7 = false;
            }
            if (z7) {
                c0416cV.Q(false, true);
            }
            this.f1175J.setText(this.L, 0, c0416cV.G().g(this.L));
            string = this.f1175J.getText().toString();
        }
        textView.setText(string);
        TextView textView2 = this.f1176K;
        textView2.setText(C0416c.t(textView2.getContext(), P0.r.e(aVar.i(), aVar.j())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Q0.ViewOnClickListenerC0169b, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f1087B) {
            return;
        }
        Context context = this.f1089D.getContext();
        if (((L0.a) this.f1090E).f() != -100) {
            if (((L0.a) this.f1090E).f() == -103) {
                context.startActivity(new Intent(context, (Class<?>) ServiceProviderConversationListActivity.class));
                D0.a.a(-103L);
                return;
            }
            return;
        }
        try {
            Intent intent = new Intent("miui.intent.action.SET_FIREWALL");
            intent.putExtra("antispam_action_source", "action_source_sms");
            context.startActivity(intent);
            D0.a.a(-100L);
        } catch (Exception e2) {
            Log.e("ConversationEntryVH", "open blocked ", e2);
        }
    }

    @Override // Q0.ViewOnClickListenerC0169b, android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return true;
    }
}
