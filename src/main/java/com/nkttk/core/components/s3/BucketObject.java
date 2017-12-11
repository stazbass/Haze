package com.nkttk.core.components.s3;

import com.nkttk.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class BucketObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(BucketObject.class);
    private String key;
    private byte[] content;

    public BucketObject(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(String contentSource) {
        writeContent(new ByteArrayInputStream(contentSource.getBytes()));
    }

    public void setContent(byte[] contentsSource) {
       writeContent(new ByteArrayInputStream(contentsSource));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BucketObject) {
            return key.equals(((BucketObject) obj).getKey());
        } else {
            return super.equals(obj);
        }
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
            LOGGER.debug("Setting object '{}' content '{}'", new String(content));
        } catch (IOException e) {
            throw new RuntimeException("Exception writing to object ", e);
        } finally {
            try {
                outputStream.close();
                is.close();
            } catch (IOException e) {
                throw new RuntimeException("Exception writing to object ", e);
            }
        }
    }
}
