package miuix.preference;

import D2.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.h;
import com.android.mmt.R;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class TextPreference extends Preference {

    /* renamed from: W, reason: collision with root package name */
    private String f7359W;

    /* renamed from: X, reason: collision with root package name */
    private boolean f7360X;

    /* renamed from: Y, reason: collision with root package name */
    private a f7361Y;

    public interface a<T extends TextPreference> {
        CharSequence a();
    }

    public TextPreference(Context context, AttributeSet attributeSet, int i2, int i4) throws NoSuchMethodException, SecurityException {
        a aVar;
        super(context, attributeSet, i2, i4);
        this.f7360X = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.d, i2, i4);
        CharSequence text = typedArrayObtainStyledAttributes.getText(0);
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        if (!TextUtils.isEmpty(text)) {
            String string2 = text.toString();
            if (this.f7361Y != null) {
                throw new IllegalStateException("Preference already has a TextProvider set.");
            }
            if (!TextUtils.equals(string2, this.f7359W)) {
                this.f7359W = string2;
                H();
            }
        }
        if (TextUtils.isEmpty(string)) {
            aVar = null;
        } else {
            try {
                Constructor constructor = context.getClassLoader().loadClass(string).asSubclass(a.class).getConstructor(new Class[0]);
                constructor.setAccessible(true);
                aVar = (a) constructor.newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException(e.c("Can't find provider: ", string), e2);
            } catch (IllegalAccessException e4) {
                throw new IllegalStateException(e.c("Can't access non-public constructor ", string), e4);
            } catch (InstantiationException e5) {
                throw new IllegalStateException(e.c("Could not instantiate the TextProvider: ", string), e5);
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException(e.c("Error creating TextProvider ", string), e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException(e.c("Could not instantiate the TextProvider: ", string), e7);
            }
        }
        this.f7361Y = aVar;
        H();
    }

    @Override // androidx.preference.Preference
    public final void N(h hVar) {
        super.N(hVar);
        View view = hVar.f4055i;
        TextView textView = (TextView) hVar.B(R.id.text_right);
        if (textView != null) {
            a aVar = this.f7361Y;
            CharSequence charSequenceA = aVar != null ? aVar.a() : this.f7359W;
            if (TextUtils.isEmpty(charSequenceA)) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequenceA);
                textView.setVisibility(0);
            }
        }
        view.setClickable(this.f7360X);
    }

    public TextPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.Miuix_Preference_TextPreference);
    }

    public TextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textPreferenceStyle);
    }

    public TextPreference(Context context) {
        this(context, null);
    }
}
