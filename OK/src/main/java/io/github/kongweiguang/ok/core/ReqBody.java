package io.github.kongweiguang.ok.core;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * http请求体
 *
 * @author kongweiguang
 */
public final class ReqBody extends RequestBody {
    private final MediaType mt;
    private final byte[] bt;

    public ReqBody(String contentType, Charset charset, byte[] bytes) {
        this.mt = MediaType.parse(contentType + ";charset=" + charset);
        this.mt.charset(charset);
        this.bt = bytes;
    }

    @Override
    public MediaType contentType() {
        return this.mt;
    }

    @Override
    public long contentLength() throws IOException {
        return this.bt.length;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        sink.write(this.bt, 0, this.bt.length);
    }
}