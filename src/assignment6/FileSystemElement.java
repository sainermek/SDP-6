package assignment6;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}