package V;

import android.database.Cursor;
import android.database.SQLException;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* loaded from: classes.dex */
public interface b extends Closeable {
    f C(String str);

    void G();

    Cursor R(e eVar);

    Cursor Y(String str);

    boolean b0();

    String getPath();

    void i();

    boolean isOpen();

    void j();

    List<Pair<String, String>> n();

    boolean p();

    void s(String str) throws SQLException;

    void y();
}
