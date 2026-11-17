package H;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.l;

/* loaded from: classes.dex */
public final class d implements l {
    private static CharSequence b(Context context, ClipData.Item item, int i2) {
        if ((i2 & 1) == 0) {
            return item.coerceToStyledText(context);
        }
        CharSequence charSequenceCoerceToText = item.coerceToText(context);
        return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
    }

    private static void c(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, charSequence);
    }

    @Override // androidx.core.view.l
    public final androidx.core.view.c a(View view, androidx.core.view.c cVar) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + cVar);
        }
        int iC = cVar.c();
        if (iC == 2) {
            return cVar;
        }
        int i2 = 0;
        if (iC == 3) {
            TextView textView = (TextView) view;
            ClipData clipDataA = cVar.a();
            Context context = textView.getContext();
            int iB = cVar.b();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            while (i2 < clipDataA.getItemCount()) {
                CharSequence charSequenceB = b(context, clipDataA.getItemAt(i2), iB);
                if (charSequenceB != null) {
                    spannableStringBuilder.append(charSequenceB);
                }
                i2++;
            }
            c((Editable) textView.getText(), spannableStringBuilder);
            return null;
        }
        ClipData clipDataA2 = cVar.a();
        int iB2 = cVar.b();
        TextView textView2 = (TextView) view;
        Editable editable = (Editable) textView2.getText();
        Context context2 = textView2.getContext();
        boolean z4 = false;
        while (i2 < clipDataA2.getItemCount()) {
            CharSequence charSequenceB2 = b(context2, clipDataA2.getItemAt(i2), iB2);
            if (charSequenceB2 != null) {
                if (z4) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceB2);
                } else {
                    c(editable, charSequenceB2);
                    z4 = true;
                }
            }
            i2++;
        }
        return null;
    }
}
