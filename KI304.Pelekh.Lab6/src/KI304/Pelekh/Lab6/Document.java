package KI304.Pelekh.Lab6;

import java.util.ArrayList;
/**
 * Class representing a document, which can be stored in the safe.
 */
class Document implements Data {
    private String docName;
    private int size;

    public Document(String name, int size) {
        this.docName = name;
        this.size = size;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Data other) {
        return Integer.compare(this.size, other.getSize());
    }

    @Override
    public void print() {
        System.out.println("Document Name: " + docName + ", Size: " + size);
    }
}
