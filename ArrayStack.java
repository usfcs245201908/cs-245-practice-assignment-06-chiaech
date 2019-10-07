public class ArrayStack<T> implements Stack<T>{

    protected T[] a = (T[]) new Object[10];
    protected int top = -1;

    @Override
    public void push(T item){
        if(top == a.length-1)
            grow_array();
        a[++top] = item;
    }

    @Override
    public T pop(){
        if(empty()){
            throw new RuntimeException("Cannot pop (stack is empty).");
        }else {
            return a[top--];
        }
    }

    @Override
    public T peek(){
        if(empty()){
            throw new RuntimeException("Cannot peek (stack is empty).");
        }else{
            return a[top];
        }
    }

    @Override
    public boolean empty(){
        if(top == -1){
            return true;
        } else {
            return false;
        }
    }

    void grow_array(){
        T[] new_array = (T[]) new Object[a.length*2];
        for (int i = 0; i < a.length; i++){
            new_array[i] = a[i];
        }
        a = new_array;
    }
}
