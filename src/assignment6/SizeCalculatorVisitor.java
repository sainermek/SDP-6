package assignment6;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private long totalSize = 0;

    public long getTotalSize() {
        return totalSize;
    }

    @Override
    public void visitFile(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visitDirectory(Directory directory) {
    }
}