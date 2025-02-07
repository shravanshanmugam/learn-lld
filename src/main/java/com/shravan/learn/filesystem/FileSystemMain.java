package com.shravan.learn.filesystem;

public class FileSystemMain {
    public static void main(String[] args) {
        String[] files = new String[]{"web/assets/html/a1.html","web/assets/html/b1.html","web/assets/js/c1.js","web/assets/css","web/index.html"};
        FileController fileController = new FileController();
        fileController.add(files);

    }
}
