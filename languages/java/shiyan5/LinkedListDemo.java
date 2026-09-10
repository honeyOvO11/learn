package shiyan5;

class Node {
    int data; // 节点存储的数据
    Node next; // 指向下一个节点的指针

    // 节点构造方法
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head; // 链表头节点
    private int size; // 链表长度

    // 构造方法：初始化空链表
    public LinkedList() {
        head = null;
        size = 0;
    }

    // 1. 在链表末尾添加元素
    public void addValue(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode; // 如果是空链表，新节点作为头节点
        } else {
            Node current = head;
            // 遍历到链表末尾
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // 在末尾添加新节点
        }
        size++; // 链表长度增加
    }

    // 2. 遍历打印链表
    public void printList() {
        Node current = head;
        System.out.print("链表内容: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 3. 获取链表长度
    public int getLength() {
        return size;
    }

    // 4. 清空链表
    public void clear() {
        head = null; // 将头节点设为null
        size = 0; // 重置链表长度
    }

    // 5. 查找指定元素
    public boolean findValue(int k) {
        Node current = head;
        while (current != null) {
            if (current.data == k) {
                return true; // 找到元素
            }
            current = current.next;
        }
        return false; // 未找到元素
    }

    // 6. 删除指定元素
    public void deleteValue(int val) {
        if (head == null)
            return; // 空链表直接返回

        // 如果要删除的是头节点
        if (head.data == val) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        // 查找要删除的节点
        while (current.next != null) {
            if (current.next.data == val) {
                current.next = current.next.next; // 跳过要删除的节点
                size--;
                return;
            }
            current = current.next;
        }
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // 添加元素
        list.addValue(10);
        list.addValue(20);
        list.addValue(30);
        list.addValue(40);

        // 打印链表
        list.printList();
        System.out.println("链表长度: " + list.getLength());

        // 查找元素
        System.out.println("元素20是否存在: " + list.findValue(20));
        System.out.println("元素50是否存在: " + list.findValue(50));

        // 删除元素
        System.out.println("\n删除元素20...");
        list.deleteValue(20);
        list.printList();
        System.out.println("链表长度: " + list.getLength());

        // 清空链表
        System.out.println("\n清空链表...");
        list.clear();
        list.printList();
        System.out.println("链表长度: " + list.getLength());
    }
}