package y;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import java.io.IOException;
import miuix.appcompat.internal.app.widget.SearchActionModeView;
import x.C0412a;

/* loaded from: classes.dex */
public final class d extends e {
    public final Typeface a(Context context, C0412a.b bVar, Resources resources, int i2) throws IOException {
        try {
            C0412a.c[] cVarArrA = bVar.a();
            int length = cVarArrA.length;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    break;
                }
                C0412a.c cVar = cVarArrA[i4];
                try {
                    Font.Builder weight = new Font.Builder(resources, cVar.a()).setWeight(cVar.d());
                    if (!cVar.e()) {
                        i5 = 0;
                    }
                    Font fontBuild = weight.setSlant(i5).setTtcIndex(cVar.b()).setFontVariationSettings(cVar.c()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
                i4++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : SearchActionModeView.ANIMATION_DURATION, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }
}
