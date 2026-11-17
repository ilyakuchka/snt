package R;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class n implements V.c, d {

    /* renamed from: i, reason: collision with root package name */
    private final Context f1299i;

    /* renamed from: j, reason: collision with root package name */
    private final String f1300j;

    /* renamed from: k, reason: collision with root package name */
    private final File f1301k;

    /* renamed from: l, reason: collision with root package name */
    private final Callable<InputStream> f1302l;

    /* renamed from: m, reason: collision with root package name */
    private final int f1303m;

    /* renamed from: n, reason: collision with root package name */
    private final V.c f1304n;

    /* renamed from: o, reason: collision with root package name */
    private c f1305o;
    private boolean p;

    private void H(File file) throws IOException {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.f1300j != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.f1299i.getAssets().open(this.f1300j));
        } else if (this.f1301k != null) {
            readableByteChannelNewChannel = new FileInputStream(this.f1301k).getChannel();
        } else {
            Callable<InputStream> callable = this.f1302l;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                readableByteChannelNewChannel = Channels.newChannel(callable.call());
            } catch (Exception e2) {
                throw new IOException("inputStreamCallable exception on call", e2);
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f1299i.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(fileCreateTempFile).getChannel();
        try {
            channel.transferFrom(readableByteChannelNewChannel, 0L, Long.MAX_VALUE);
            channel.force(false);
            readableByteChannelNewChannel.close();
            channel.close();
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                StringBuilder sbD = D2.e.d("Failed to create directories for ");
                sbD.append(file.getAbsolutePath());
                throw new IOException(sbD.toString());
            }
            if (fileCreateTempFile.renameTo(file)) {
                return;
            }
            StringBuilder sbD2 = D2.e.d("Failed to move intermediate file (");
            sbD2.append(fileCreateTempFile.getAbsolutePath());
            sbD2.append(") to destination (");
            sbD2.append(file.getAbsolutePath());
            sbD2.append(").");
            throw new IOException(sbD2.toString());
        } catch (Throwable th) {
            readableByteChannelNewChannel.close();
            channel.close();
            throw th;
        }
    }

    private void e0(boolean z4) throws IOException {
        String databaseName = getDatabaseName();
        File databasePath = this.f1299i.getDatabasePath(databaseName);
        U.a aVar = new U.a(databaseName, this.f1299i.getFilesDir(), this.f1305o == null);
        try {
            aVar.a();
            if (!databasePath.exists()) {
                try {
                    H(databasePath);
                    aVar.b();
                    return;
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to copy database file.", e2);
                }
            }
            if (this.f1305o == null) {
                aVar.b();
                return;
            }
            try {
                if (U.c.a(databasePath) == this.f1303m) {
                    aVar.b();
                    return;
                } else {
                    Objects.requireNonNull(this.f1305o);
                    aVar.b();
                    return;
                }
            } catch (IOException e4) {
                Log.w("ROOM", "Unable to read database version.", e4);
                aVar.b();
                return;
            }
        } catch (Throwable th) {
            aVar.b();
            throw th;
        }
        aVar.b();
        throw th;
    }

    final void I(c cVar) {
        this.f1305o = cVar;
    }

    @Override // V.c
    public final synchronized V.b T() {
        if (!this.p) {
            e0(true);
            this.p = true;
        }
        return this.f1304n.T();
    }

    @Override // V.c, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f1304n.close();
        this.p = false;
    }

    @Override // R.d
    public final V.c f() {
        return this.f1304n;
    }

    @Override // V.c
    public final String getDatabaseName() {
        return this.f1304n.getDatabaseName();
    }

    @Override // V.c
    public final void setWriteAheadLoggingEnabled(boolean z4) {
        this.f1304n.setWriteAheadLoggingEnabled(z4);
    }
}
