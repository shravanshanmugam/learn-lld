package com.shravan.learn.filesystem;

import java.util.Collection;

public interface FileSystem {
    void add(FileSystem fs);
    void ls();
    boolean isFile();
    Collection<FileSystem> getChildren();
    boolean contains(String path);
    FileSystem get(String path);
    String getName();
}
