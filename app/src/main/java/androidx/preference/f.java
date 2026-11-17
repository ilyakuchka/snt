package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
final class f {

    /* renamed from: e, reason: collision with root package name */
    private static final Class<?>[] f3860e = {Context.class, AttributeSet.class};

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Constructor> f3861f = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final Context f3862a;

    /* renamed from: c, reason: collision with root package name */
    private g f3864c;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f3863b = new Object[2];
    private String[] d = {Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."};

    public f(Context context, g gVar) {
        this.f3862a = context;
        this.f3864c = gVar;
    }

    private Preference a(String str, String[] strArr, AttributeSet attributeSet) throws InflateException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        Class<?> cls;
        Constructor<?> constructor = f3861f.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f3862a.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        cls = Class.forName(str, false, classLoader);
                    } else {
                        cls = null;
                        ClassNotFoundException e2 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e4) {
                                e2 = e4;
                            }
                        }
                        if (cls == null) {
                            if (e2 != null) {
                                throw e2;
                            }
                            throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        }
                    }
                    constructor = cls.getConstructor(f3860e);
                    constructor.setAccessible(true);
                    f3861f.put(str, constructor);
                } catch (ClassNotFoundException e5) {
                    throw e5;
                }
            } catch (Exception e6) {
                InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                inflateException.initCause(e6);
                throw inflateException;
            }
        }
        Object[] objArr = this.f3863b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    private Preference b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? a(str, this.d, attributeSet) : a(str, null, attributeSet);
        } catch (InflateException e2) {
            throw e2;
        } catch (ClassNotFoundException e4) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e4);
            throw inflateException;
        } catch (Exception e5) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e5);
            throw inflateException2;
        }
    }

    private void e(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.g0(Intent.parseIntent(this.f3862a.getResources(), xmlPullParser, attributeSet));
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e2);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    this.f3862a.getResources().parseBundleExtra("extra", attributeSet, preference.k());
                    try {
                        int depth2 = xmlPullParser.getDepth();
                        while (true) {
                            int next2 = xmlPullParser.next();
                            if (next2 == 1 || (next2 == 3 && xmlPullParser.getDepth() <= depth2)) {
                                break;
                            }
                        }
                    } catch (IOException e4) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e4);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference preferenceB = b(name, attributeSet);
                    ((PreferenceGroup) preference).w0(preferenceB);
                    e(xmlPullParser, preferenceB, attributeSet);
                }
            }
        }
    }

    public final Preference c(int i2) throws Resources.NotFoundException {
        XmlResourceParser xml = this.f3862a.getResources().getXml(i2);
        try {
            return d(xml);
        } finally {
            xml.close();
        }
    }

    public final Preference d(XmlPullParser xmlPullParser) {
        int next;
        PreferenceGroup preferenceGroup;
        synchronized (this.f3863b) {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f3863b[0] = this.f3862a;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e2) {
                    throw e2;
                } catch (IOException e4) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e4.getMessage());
                    inflateException.initCause(e4);
                    throw inflateException;
                } catch (XmlPullParserException e5) {
                    InflateException inflateException2 = new InflateException(e5.getMessage());
                    inflateException2.initCause(e5);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            preferenceGroup = (PreferenceGroup) b(xmlPullParser.getName(), attributeSetAsAttributeSet);
            preferenceGroup.L(this.f3864c);
            e(xmlPullParser, preferenceGroup, attributeSetAsAttributeSet);
        }
        return preferenceGroup;
    }
}
