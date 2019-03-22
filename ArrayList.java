public class ArrayList<T> implements List<T> {

    private int size = 0;
    private T[] data;

    public ArrayList() {
        Object[] temp = new Object[10];
        data = (T[]) temp;
    }

    @Override
    public void add(T item) {
        if (size + 1 == data.length) {
            growArray();
        }
        data[size++] = item;
    }

    @Override
    public void add(int pos, T item) {
        if (pos > size || pos < 0) {
            throw new IllegalArgumentException("Invalid position");
        }

        if (size + 1 == data.length) {
            growArray();
        }

        // Shift elements to make space at pos
        for (int i = size; i > pos; i++) {
            data[i] = data[i - 1];
        }

        data[pos] = item;
        size++;
    }

    @Override
    public T get(int pos) {
        if (pos > size - 1 || pos < 0) {
            throw new IllegalArgumentException("Invalid position");
        }
        return data[pos];
    }

    @Override
    public T remove(int pos) {
        if (pos > size - 1 || pos < 0) {
            throw new IllegalArgumentException("Invalid position");
        }
        T value = data[pos];

        // Shift elements to remove element at pos
        for (int i = pos; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    private void growArray() {
        T[] temp = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }
}
