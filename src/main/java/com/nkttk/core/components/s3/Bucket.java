package com.nkttk.core.components.s3;

import com.nkttk.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;

/**
 *
 */
public class Bucket {
    private String url;
    private String name;
    private Set<BucketObject> files;
    private Function<String, BucketObject> bucketObjectFactory;

    public Bucket(String name, Function<String, BucketObject> bucketObjectFactory) {
        this.name = name;
        this.files = new HashSet<>();
        this.bucketObjectFactory = bucketObjectFactory;
    }

    public BucketObject addFile(String key) {
        BucketObject file = bucketObjectFactory.apply(key);
        files.add(file);
        return file;
    }

    public BucketObject addFile(String name, String content) {
        return addFile(name, new ByteArrayInputStream(content.getBytes()));
    }

    public BucketObject addFile(String name, InputStream content) {
        BucketObject file = addFile(name);
        writeFileContent(name, content);
        return file;
    }

    public String getName() {
        return name;
    }

    public void writeFileContent(String file, String content) {
        writeFileContent(file, new ByteArrayInputStream(content.getBytes()));
    }

    public void writeFileContent(String name, InputStream is) {
        BucketObject destination = getFile(name).orElseThrow(()->new RuntimeException("File not found: "+ name));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            IOUtils.copy(is, outputStream);
            destination.setContent(outputStream.toByteArray());
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

    public Optional<BucketObject> getFile(String key) {
        return files.stream().filter(o->o.getKey().equals(key)).findFirst();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(obj);
    }

    @Override
    public String toString() {
        return "Bucket[" + name + "]";
    }
}
