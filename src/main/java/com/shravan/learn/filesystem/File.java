package com.shravan.learn.filesystem;

public class File implements FileSystem {
    private final String name;

    public File(String name) {
        this.name = name;
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
    public String getName() {
        return name;
    }
}
