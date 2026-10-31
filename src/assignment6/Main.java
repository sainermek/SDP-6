package assignment6;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory src = new Directory("src");
        Directory docs = new Directory("docs");

        File mainJava = new File("Main.java", 1500);
        File utilsJava = new File("Utils.java", 800);
        File readme = new File("Readme.md", 450);
        File config = new File("config.xml", 300);

        src.addElement(mainJava);
        src.addElement(utilsJava);
        docs.addElement(readme);

        root.addElement(src);
        root.addElement(docs);
        root.addElement(config);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total File System Size: " + sizeVisitor.getTotalSize() + " bytes");

        SearchVisitor javaSearchVisitor = new SearchVisitor(".java");
        root.accept(javaSearchVisitor);

        System.out.println("\nMatching files found (.java):");
        for (String fileName : javaSearchVisitor.getMatchingFiles()) {
            System.out.println(" - " + fileName);
        }
    }
}