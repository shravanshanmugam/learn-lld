package com.shravan.learn.filesystem;

import java.util.Collections;
import java.util.List;

public class File implements FileSystem {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void add(FileSystem fs) {

    }

    @Override
    public void ls() {
        System.out.print(name);
        System.out.println();
    }

    public boolean isFile() {
        return true;
    }

    @Override
    public List<FileSystem> getChildren() {
        return null;
    }

    @Override
    public boolean contains(String path) {
        return false;
    }

    @Override
    public FileSystem get(String path) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
