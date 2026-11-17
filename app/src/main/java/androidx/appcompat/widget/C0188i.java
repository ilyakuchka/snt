package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.c;
import com.android.mmt.R;
import java.util.Objects;

/* renamed from: androidx.appcompat.widget.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0188i extends EditText implements androidx.core.view.m {

    /* renamed from: i, reason: collision with root package name */
    private final C0184e f3026i;

    /* renamed from: j, reason: collision with root package name */
    private final C0202x f3027j;

    /* renamed from: k, reason: collision with root package name */
    private final H.d f3028k;

    public C0188i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    @Override // androidx.core.view.m
    public final androidx.core.view.c a(androidx.core.view.c cVar) {
        return this.f3028k.a(this, cVar);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0184e c0184e = this.f3026i;
        if (c0184e != null) {
            c0184e.a();
        }
        C0202x c0202x = this.f3027j;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView
    public final TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        Objects.requireNonNull(this.f3027j);
        C0189j.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        int i2 = androidx.core.view.o.d;
        String[] strArr = (String[]) getTag(R.id.tag_on_receive_content_mime_types);
        if (inputConnectionOnCreateInputConnection == null || strArr == null) {
            return inputConnectionOnCreateInputConnection;
        }
        editorInfo.contentMimeTypes = strArr;
        return G.a.a(inputConnectionOnCreateInputConnection, editorInfo, new C0196q(this));
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z4 = false;
        if (dragEvent.getLocalState() == null) {
            int i2 = androidx.core.view.o.d;
            if (((String[]) getTag(R.id.tag_on_receive_content_mime_types)) != null) {
                Context context = getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity = null;
                        break;
                    }
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                }
                if (activity == null) {
                    Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
                } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                    activity.requestDragAndDropPermissions(dragEvent);
                    int offsetForPosition = getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
                    beginBatchEdit();
                    try {
                        Selection.setSelection((Spannable) getText(), offsetForPosition);
                        androidx.core.view.o.h(this, new c.a(dragEvent.getClipData(), 3).a());
                        endBatchEdit();
                        z4 = true;
                    } catch (Throwable th) {
                        endBatchEdit();
                        throw th;
                    }
                }
            }
        }
        if (z4) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i2) {
        if (i2 == 16908322 || i2 == 16908337) {
            int i4 = androidx.core.view.o.d;
            if (((String[]) getTag(R.id.tag_on_receive_content_mime_types)) != null) {
                ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
                ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
                if (primaryClip != null && primaryClip.getItemCount() > 0) {
                    c.a aVar = new c.a(primaryClip, 1);
                    aVar.c(i2 != 16908322 ? 1 : 0);
                    androidx.core.view.o.h(this, aVar.a());
                }
                i = 1;
            }
        }
        if (i != 0) {
            return true;
        }
        return super.onTextContextMenuItem(i2);
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0184e c0184e = this.f3026i;
        if (c0184e != null) {
            c0184e.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0184e c0184e = this.f3026i;
        if (c0184e != null) {
            c0184e.f(i2);
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0202x c0202x = this.f3027j;
        if (c0202x != null) {
            c0202x.h(context, i2);
        }
    }

    @Override // android.widget.TextView
    public final void setTextClassifier(TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0188i(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Q.a(context);
        O.a(this, getContext());
        C0184e c0184e = new C0184e(this);
        this.f3026i = c0184e;
        c0184e.d(attributeSet, i2);
        C0202x c0202x = new C0202x(this);
        this.f3027j = c0202x;
        c0202x.f(attributeSet, i2);
        c0202x.b();
        new C0201w(this);
        this.f3028k = new H.d();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final Editable getText() {
        return super.getText();
    }
}
