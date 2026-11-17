package h1;

import V0.h;
import V0.j;
import Y0.x;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class d implements j<Uri, Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6323a;

    public d(Context context) {
        this.f6323a = context.getApplicationContext();
    }

    @Override // V0.j
    public final boolean a(Uri uri, h hVar) throws IOException {
        return uri.getScheme().equals("android.resource");
    }

    @Override // V0.j
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final x<Drawable> b(Uri uri, int i2, int i4, h hVar) throws PackageManager.NameNotFoundException, NumberFormatException {
        Context contextCreatePackageContext;
        int identifier;
        String authority = uri.getAuthority();
        if (authority.equals(this.f6323a.getPackageName())) {
            contextCreatePackageContext = this.f6323a;
        } else {
            try {
                contextCreatePackageContext = this.f6323a.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                if (!authority.contains(this.f6323a.getPackageName())) {
                    throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
                }
                contextCreatePackageContext = this.f6323a;
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            identifier = contextCreatePackageContext.getResources().getIdentifier(str2, str, authority2);
            if (identifier == 0) {
                identifier = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (identifier == 0) {
                throw new IllegalArgumentException("Failed to find resource id for: " + uri);
            }
        } else {
            if (pathSegments.size() != 1) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
            }
            try {
                identifier = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e4) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e4);
            }
        }
        return c.e(a.b(this.f6323a, contextCreatePackageContext, identifier));
    }
}
