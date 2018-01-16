package com.nkttk.haze.engine.component.s3;

import com.nkttk.haze.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Bucket content - object. File in S3 terms, which identifies by it's key ( aka path  )
 */
public class FileObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileObject.class);

    private String key;
    private byte[] content;

    public FileObject(String key) {
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

    public void setContent(InputStream contentsSource) {
        writeContent(contentsSource);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FileObject) {
            return key.equals(((FileObject) obj).getKey());
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
        return "FileObject[" + key + "]";
    }

    private void writeContent(InputStream is) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            IOUtils.copy(is, outputStream);
            content = (outputStream.toByteArray());
            LOGGER.debug("Writing content to object '{}' :'{}'", key, new String(content));
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
