package assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String targetExtension;
    private final List<String> matchingFiles = new ArrayList<>();

    public SearchVisitor(String targetExtension) {
        this.targetExtension = targetExtension;
    }

    public List<String> getMatchingFiles() {
        return Collections.unmodifiableList(matchingFiles);
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().endsWith(targetExtension)) {
            matchingFiles.add(file.getName() + " (" + file.getSize() + " bytes)");
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
    }
}