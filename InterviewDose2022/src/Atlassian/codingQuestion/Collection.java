package Atlassian.codingQuestion;

import java.util.*;

public class Collection {
    public String name;
    public int totalSize;
    private List<File> files;

    Collection(String n) {
        this.name = n;
        this.totalSize = 0;
        files = new ArrayList<>();
    }

    public void addFile(File file){
        files.add(file);
        this.totalSize = this.totalSize + file.getSize();
    }
}
