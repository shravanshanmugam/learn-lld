package com.shravan.learn.filesystem;

public class FileController {
    private final FileSystem root;

    public FileController() {
        root = new Directory("/");
    }

    public void add(String[] files) {
        for (String file : files) {
            String[] path = file.split("/");
            String last = path[path.length - 1];
            if (last.contains(".")) {
                FileSystem temp = dfsFolder(path.length - 1, path);
                FileSystem f = new File(last);
                temp.add(f);
            } else {
                dfsFolder(path.length, path);
            }
        }
        print(root);
    }

    private FileSystem dfsFolder(int path, String[] path1) {
        FileSystem temp = root;
        for (int i = 0; i < path; i++) {
            if (temp.contains(path1[i])) {
                temp = temp.get(path1[i]);
            } else {
                FileSystem dir = new Directory(path1[i]);
                temp.add(dir);
                temp = dir;
            }
        }
        return temp;
    }

    public void print(FileSystem root) {
        dfs(root, 0);
    }

    public void dfs(FileSystem root, int level) {
        if (root == null) return;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        if (!root.isFile()) {
            System.out.println(sb + root.getName() + "/");
            for (FileSystem fs : root.getChildren()) {
                dfs(fs, level + 1);
            }
        } else {
            System.out.println(sb + root.getName());
        }
    }
}
