public class ArrayQueue<T> implements Queue<T> {

    protected T[] a = (T[]) new Object[10];
    protected int front = 0;

    @Override
    public T dequeue() {
        if(empty()) {
            throw new RuntimeException("Cannot dequeue (empty).");
        } else {
            for (int i = 1; i <= front; i++)
                a[i - 1] = a[i];
        }
        front--;
        return a[0];
    }

    @Override
    public void enqueue(T item) {
        if(front >= a.length-1)
            grow_array();
        a[++front] = item;
    }

    @Override
    public boolean empty() {
        return (front == 0);
    }

    void grow_array(){
        T[] new_array = (T[]) new Object[a.length*2];
        for (int i = 0; i < a.length; i++){
            new_array[i] = a[i];
        }
        a = new_array;
    }
}
