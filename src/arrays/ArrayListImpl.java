package arrays;

import java.util.Iterator;

public class ArrayListImpl {

    public static final int SIZE_FACTOR = 5;

    private Object[] data;

    private int index;

    private int size;

    ArrayListImpl() {
        index = 0;
        size = SIZE_FACTOR;
        data = new Object[size];
    }

    public void add(Object obj) {
        if (this.index == this.size - 1)
            increaseSizeAndReallocate();
        data[this.index] = obj;
        this.index++;
    }

    private void increaseSizeAndReallocate() {
        this.size = this.size + SIZE_FACTOR;
        Object[] newData = new Object[this.size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
        System.out.println("***index:" + this.index + "size:" + this.size + "data size:" + this.data.length);
    }

    public Object get(int i) throws Exception {
        if (i > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        if (i < 0) {
            throw new Exception("Negative Value");
        }
        return this.data[i];

    }

    public void remove(int i) throws Exception {
        if (i > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        if (i < 0) {
            throw new Exception("Negative Value");
        }
        System.out.println("Object getting removed:" + this.data[i]);
        for (int x = i; x < this.data.length - 1; x++) {
            data[x] = data[x + 1];
        }
        this.index--;
    }

    @Override
    public String toString() {
        int len = this.index;
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) sb.append(this.data[i] + ", ");
            return sb.append(this.data[len - 1] + "]").toString();
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayListImpl mal = new ArrayListImpl();
        mal.add("100");
        mal.add("1");
        mal.add("2");
        mal.add("3");
        mal.add("4");
        mal.add("5");
        mal.add("6");
        mal.add("7");
        mal.add("8");
        mal.add("9");

        mal.remove(5);
        System.out.println(mal.toString());
    }
}
