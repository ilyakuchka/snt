package P0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import com.android.mmt.R;
import com.android.mmt.util.O;
import java.lang.ref.WeakReference;
import x0.C0414a;

/* loaded from: classes.dex */
public final class u extends ResourceCursorAdapter {
    private static final String[] d = {"_id", "contact_id", "data2", "data1", "data3", "display_name", "photo_id"};

    /* renamed from: a, reason: collision with root package name */
    private final Context f954a;

    /* renamed from: b, reason: collision with root package name */
    private final ContentResolver f955b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f956c;

    public u(Context context) {
        super(context, R.layout.recipient_filter_item, (Cursor) null, false);
        this.f956c = false;
        this.f954a = context;
        this.f955b = context.getContentResolver();
    }

    public final void b() {
        this.f956c = false;
    }

    @Override // android.widget.CursorAdapter
    public final void bindView(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.findViewById(R.id.name);
        textView.setText(cursor.getString(5));
        textView.setVisibility(0);
        TextView textView2 = (TextView) view.findViewById(R.id.number);
        textView2.setText(cursor.getString(3));
        ((TextView) view.findViewById(R.id.type)).setText(ContactsContract.CommonDataKinds.Phone.getTypeLabel(context.getResources(), cursor.getInt(2), cursor.getString(4)).toString());
        TextView textView3 = (TextView) view.findViewById(R.id.location);
        new WeakReference(textView2);
        new WeakReference(textView3);
    }

    public final void c() {
        this.f956c = true;
    }

    @Override // android.widget.CursorAdapter
    public final void changeCursor(Cursor cursor) {
        if (!this.f956c) {
            super.changeCursor(cursor);
            return;
        }
        if (cursor != null) {
            cursor.close();
        }
        Log.v("RecipientsAdapter", "change cursor close for stop");
    }

    @Override // android.widget.CursorAdapter
    public final CharSequence convertToString(Cursor cursor) {
        String string = cursor.getString(3);
        if (string == null) {
            return "";
        }
        String strTrim = string.trim();
        String string2 = cursor.getString(5);
        CharSequence typeLabel = ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.f954a.getResources(), cursor.getInt(2), cursor.getString(4));
        String strReplace = string2 != null ? string2.replace(", ", " ").replace(",", " ") : "";
        SpannableString spannableString = new SpannableString(C0414a.M(strReplace, strTrim));
        int length = spannableString.length();
        if (TextUtils.isEmpty(strReplace)) {
            spannableString.setSpan(new Annotation("name", strTrim), 0, length, 33);
        } else {
            spannableString.setSpan(new Annotation("name", strReplace), 0, length, 33);
        }
        spannableString.setSpan(new Annotation("person_id", cursor.getString(1)), 0, length, 33);
        spannableString.setSpan(new Annotation("label", typeLabel.toString()), 0, length, 33);
        spannableString.setSpan(new Annotation("number", strTrim), 0, length, 33);
        return spannableString;
    }

    @Override // android.widget.CursorAdapter
    public final Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        return O.f(this.f954a, this.f955b, ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI.buildUpon().appendPath(charSequence != null ? charSequence.toString() : null).appendQueryParameter("type", "short_text").build(), d, null, null, null);
    }
}
