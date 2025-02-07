package com.shravan.learn.filesystem;

import java.util.*;

public class Directory implements FileSystem {
    private final String name;
    private Map<String, FileSystem> files;

    public Directory(String name) {
        this.name = name;
        this.files = new HashMap<>();
    }

    public void add(FileSystem fs) {
        files.put(fs.getName(), fs);
    }

    @Override
    public void ls() {
        System.out.println(name + "->");
        for (FileSystem fs : files.values()) {
            fs.ls();
        }
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public List<FileSystem> getChildren() {
        return new ArrayList<>(files.values());
    }

    @Override
    public boolean contains(String path) {
        return files.containsKey(path);
    }

    @Override
    public FileSystem get(String path) {
        return files.get(path);
    }

    @Override
    public String getName() {
        return name;
    }
}
