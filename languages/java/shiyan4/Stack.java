package shiyan4;

public class Stack {
    private int top;
    private int maxSize;
    private int[] stack;

    public Stack() {
        maxSize = 10;
        stack = new int[maxSize];
        top = -1;
    }

    public boolean Stack_isFull() {
        return top == maxSize - 1;
    }

    public boolean Stack_isEmpty() {
        return top == -1;
    }

    public void Stack_Push(int value) {
        if (Stack_isFull()) {
            System.out.println("栈满，无法入栈");
            return;
        }
        stack[++top] = value;
    }

    public int Stack_Pop() {
        if (Stack_isEmpty()) {
            throw new RuntimeException("栈空，无法出栈");
        }
        return stack[top--];
    }

    public void Stack_Print() {
        if (Stack_isEmpty()) {
            System.out.println("栈空");
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        // 入栈1-5
        stack.Stack_Push(1);
        stack.Stack_Push(2);
        stack.Stack_Push(3);
        stack.Stack_Push(4);
        stack.Stack_Push(5);
        System.out.println("入栈后栈中元素为: ");
        stack.Stack_Print();
        // 出栈操作
        System.out.println("出栈元素：" + stack.Stack_Pop());
        System.out.println("出栈后栈中元素为：");
        stack.Stack_Print();
    }
}