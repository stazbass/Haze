package com.nkttk.core.components.s3;

import com.nkttk.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 *
 */
public class BucketObject {
    private String etag;
    private String key;
    private byte[] content;

    public BucketObject(String key) {
        this.key = key;
        this.etag = UUID.randomUUID().toString();
    }

    public String getKey() {
        return key;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(String content) {
        writeContent(new ByteArrayInputStream(content.getBytes()));
    }

    @Override
    public boolean equals(Object obj) {
        return key.equals(obj);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return "BucketObject[" + key + "]";
    }

    public void writeContent(InputStream is) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            IOUtils.copy(is, outputStream);
            content = (outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Exception writing to file ", e);
        } finally {
            try {
                outputStream.close();
                is.close();
            } catch (IOException e) {
                throw new RuntimeException("Exception writing to file ", e);
            }
        }
    }
}
