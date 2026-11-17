package v;

import android.app.Notification;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
final class i implements InterfaceC0397d {

    /* renamed from: a, reason: collision with root package name */
    private final Notification.Builder f7954a;

    /* renamed from: b, reason: collision with root package name */
    private final g f7955b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Bundle> f7956c = new ArrayList();
    private final Bundle d = new Bundle();

    i(g gVar) {
        RemoteInput[] remoteInputArr;
        this.f7955b = gVar;
        Context context = gVar.f7939a;
        Notification.Builder builder = new Notification.Builder(gVar.f7939a, gVar.f7950n);
        this.f7954a = builder;
        Notification notification = gVar.p;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(gVar.f7942e).setContentText(gVar.f7943f).setContentInfo(null).setContentIntent(gVar.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setLargeIcon(gVar.f7944h).setNumber(0).setProgress(0, 0, false);
        builder.setSubText(null).setUsesChronometer(false).setPriority(gVar.f7945i);
        Iterator<C0398e> it = gVar.f7940b.iterator();
        while (it.hasNext()) {
            C0398e next = it.next();
            IconCompat iconCompatB = next.b();
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompatB != null ? iconCompatB.e() : null, next.f7931j, next.f7932k);
            if (next.c() != null) {
                l[] lVarArrC = next.c();
                if (lVarArrC == null) {
                    remoteInputArr = null;
                } else {
                    remoteInputArr = new RemoteInput[lVarArrC.length];
                    for (int i2 = 0; i2 < lVarArrC.length; i2++) {
                        Objects.requireNonNull(lVarArrC[i2]);
                        RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(null).setLabel(null).setChoices(null).setAllowFreeFormInput(false).addExtras(null);
                        builderAddExtras.setEditChoicesBeforeSending(0);
                        remoteInputArr[i2] = builderAddExtras.build();
                    }
                }
                for (RemoteInput remoteInput : remoteInputArr) {
                    builder2.addRemoteInput(remoteInput);
                }
            }
            Bundle bundle = next.f7924a != null ? new Bundle(next.f7924a) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", next.a());
            builder2.setAllowGeneratedReplies(next.a());
            bundle.putInt("android.support.action.semanticAction", next.d());
            builder2.setSemanticAction(next.d());
            builder2.setContextual(next.e());
            bundle.putBoolean("android.support.action.showsUserInterface", next.f7928f);
            builder2.addExtras(bundle);
            this.f7954a.addAction(builder2.build());
        }
        Bundle bundle2 = gVar.f7949m;
        if (bundle2 != null) {
            this.d.putAll(bundle2);
        }
        this.f7954a.setShowWhen(gVar.f7946j);
        this.f7954a.setLocalOnly(false).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.f7954a.setCategory(gVar.f7948l).setColor(0).setVisibility(0).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        ArrayList<String> arrayList = gVar.f7952q;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.f7954a.addPerson(it2.next());
            }
        }
        if (gVar.d.size() > 0) {
            if (gVar.f7949m == null) {
                gVar.f7949m = new Bundle();
            }
            Bundle bundle3 = gVar.f7949m.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            for (int i4 = 0; i4 < gVar.d.size(); i4++) {
                bundle5.putBundle(Integer.toString(i4), j.a(gVar.d.get(i4)));
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            if (gVar.f7949m == null) {
                gVar.f7949m = new Bundle();
            }
            gVar.f7949m.putBundle("android.car.EXTENSIONS", bundle3);
            this.d.putBundle("android.car.EXTENSIONS", bundle4);
        }
        this.f7954a.setExtras(gVar.f7949m).setRemoteInputHistory(null);
        this.f7954a.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(gVar.f7950n)) {
            this.f7954a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator<k> it3 = gVar.f7941c.iterator();
        while (it3.hasNext()) {
            k next2 = it3.next();
            Notification.Builder builder3 = this.f7954a;
            Objects.requireNonNull(next2);
            builder3.addPerson(new Person.Builder().setName(null).setIcon(null).setUri(null).setKey(null).setBot(false).setImportant(false).build());
        }
        this.f7954a.setAllowSystemGeneratedContextualActions(gVar.f7951o);
        this.f7954a.setBubbleMetadata(null);
    }

    public final Notification a() {
        Bundle bundle;
        h hVar = this.f7955b.f7947k;
        if (hVar != null) {
            hVar.a(this);
        }
        Notification notificationBuild = this.f7954a.build();
        Objects.requireNonNull(this.f7955b);
        if (hVar != null) {
            Objects.requireNonNull(this.f7955b.f7947k);
        }
        if (hVar != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        return notificationBuild;
    }

    public final Notification.Builder b() {
        return this.f7954a;
    }
}
