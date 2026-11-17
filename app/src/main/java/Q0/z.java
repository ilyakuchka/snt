package Q0;

import Q0.q;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.ActivityC0219o;
import com.android.mmt.R;
import com.android.mmt.ui.MmsTabActivity;

/* loaded from: classes.dex */
public abstract class z extends q {

    /* renamed from: w0, reason: collision with root package name */
    private View f1197w0;

    /* renamed from: x0, reason: collision with root package name */
    private TextView f1198x0;

    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (z.this.x() instanceof MmsTabActivity) {
                MmsTabActivity mmsTabActivity = (MmsTabActivity) z.this.x();
                View view2 = z.this.f1197w0;
                View view3 = z.this.f1134i0;
                mmsTabActivity.b0(view2);
            }
            z.this.B1(true);
        }
    }

    protected class b extends q.l {
        public b(z zVar, ContentResolver contentResolver) {
            super(contentResolver);
        }

        @Override // Q0.q.l, com.android.mmt.util.AbstractHandlerC0272d
        protected final void c(int i2, Object obj, Cursor cursor) throws Resources.NotFoundException {
            super.c(i2, obj, cursor);
        }
    }

    protected class c extends q.m {
        protected c(z zVar) {
        }
    }

    protected void A1() {
        TextView textView = this.f1198x0;
        if (textView != null) {
            textView.setHint(R.string.search_hint);
        }
    }

    public void B1(boolean z4) {
    }

    @Override // Q0.q, androidx.fragment.app.Fragment
    public View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f1139n0 == null) {
            this.f1139n0 = new b(this, B().getContentResolver());
        }
        return super.g0(layoutInflater, viewGroup, bundle);
    }

    @Override // Q0.q
    protected void j1() {
        super.j1();
        View viewFindViewById = this.f1134i0.findViewById(R.id.header_view);
        this.f1197w0 = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new a());
            this.f1198x0 = (TextView) this.f1197w0.findViewById(android.R.id.input);
        }
    }

    @Override // Q0.q, androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        ActivityC0219o activityC0219oX = x();
        if (activityC0219oX != null && (activityC0219oX instanceof MmsTabActivity) && ((MmsTabActivity) activityC0219oX).a0()) {
            return;
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // Q0.q
    protected int p1() {
        return R.layout.fragment_conversation_private;
    }
}
