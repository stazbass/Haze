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
    private String name;
    private Set<BucketObject> files;
    private Function<String, BucketObject> bucketObjectFactory;

    public Bucket(String name, Function<String, BucketObject> bucketObjectFactory) {
        this.name = name;
        this.files = new HashSet<>();
        this.bucketObjectFactory = bucketObjectFactory;
    }

    public BucketObject addObject(String key) {
        BucketObject file = bucketObjectFactory.apply(key);
        files.add(file);
        return file;
    }

    public BucketObject addObject(String name, String content) {
        BucketObject object = addObject(name);
        object.writeContent( new ByteArrayInputStream(content.getBytes()));
        return object;
    }

    public BucketObject addObject(String name, InputStream content) {
        BucketObject file = addObject(name);
        file.writeContent(content);
        return file;
    }

    public String getName() {
        return name;
    }

    public Optional<BucketObject> getFile(String key) {
        return files.stream().filter(o->o.getKey().equals(key)).findFirst();
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
