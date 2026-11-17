package com.bumptech.glide.load;

import Z0.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);


        /* renamed from: i, reason: collision with root package name */
        private final boolean f6128i;

        ImageType(boolean z4) {
            this.f6128i = z4;
        }

        public boolean hasAlpha() {
            return this.f6128i;
        }
    }

    ImageType a(ByteBuffer byteBuffer) throws IOException;

    int b(InputStream inputStream, b bVar) throws IOException;

    ImageType c(InputStream inputStream) throws IOException;
}
