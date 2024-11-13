package KI304.Pelekh.Lab6;

import java.util.ArrayList;
/**
 import java.util.ArrayList;
 * Class representing a picture, which can be stored in the safe.
 */
class Picture implements Data {
    private String picName;
    private int size;

    public Picture(String name, int size) {
        this.picName = name;
        this.size = size;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
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
        System.out.println("Picture Name: " + picName + ", Size: " + size);
        
    }
}










