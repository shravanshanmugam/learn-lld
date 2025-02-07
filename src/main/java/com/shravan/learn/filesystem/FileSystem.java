package com.shravan.learn.filesystem;

import java.util.List;

public interface FileSystem {
    default void add(FileSystem fs) {
    }

    void ls();

    boolean isFile();

    default List<FileSystem> getChildren() {
        return null;
    }

    default boolean contains(String path) {
        return false;
    }

    default FileSystem get(String path) {
        return null;
    }

    String getName();
}
