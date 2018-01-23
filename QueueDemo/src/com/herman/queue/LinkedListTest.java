package com.herman.queue;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
/**
 * @see ���еĳ�����ʶ
 * @author Herman.Xiong
 * @date 2014��2��27�� 08:58:15
 * @version V1.0
 * @since jdk 1.6
 */
public class LinkedListTest {
	public static void main(String[] args) {  
        LinkedListTest t=new LinkedListTest();
        t.test0();
        t.test1();
    }  
	
	void test0(){
		/**
		 * @see LinkedList�Ƚ��ȳ�����
		 */
		Queue<String> queue = new LinkedList<String>();  
        queue.offer("Hello");  
        queue.offer("World!");  
        queue.offer("��ã�");  
        System.out.println(queue.size());  
        String str;  
        while((str=queue.poll())!=null){  
            System.out.print(str);  
        }  
        System.out.println();  
        System.out.println(queue.size());  
	}
	
	@SuppressWarnings("unchecked")
	void test1(){
		LinkedList  list = new LinkedList();  
        
        list.add("one");  
        list.add("two");  
        list.add("three");        
        System.out.println("<--list�й��� ��" + list.size() + "��Ԫ��-->");  
        System.out.println("<--list�е����� ��" + list + "-->");  
          
        String first = (String) list.getFirst();  
        String last = (String) list.getLast();  
        System.out.println("<--list�е�һ��Ԫ��Ϊ ��" + first + "-->");  
        System.out.println("<--list�����һ��Ԫ��Ϊ ��" + last + "-->");  
          
        list.addFirst("Begin");  
        list.addLast("End");  
        System.out.println("<--list�й��� ��" + list.size() + "��Ԫ��-->");  
        System.out.println("<--list�е����� ��" + list + "-->");  
          
        System.out.println("<--ʹ��ListIterator�ӿڲ���list-->");  
        ListIterator lit = list.listIterator();  
        System.out.println("<--��һ��������"+ lit.nextIndex()+ "-->");  
        lit.next();  
        lit.add("zero"); 
        //��ǰ��
        lit.previous();  
        System.out.println("<--��һ��������"+ lit.previousIndex()+ "-->");        
        lit.previous();  
        System.out.println("<--��һ��������"+ lit.previousIndex()+ "-->");  
        lit.set("Start");  
        System.out.println("<--list�е����� ��" + list + "-->");  
          
        System.out.println("<--ɾ��list�е�zero-->");  
        lit.next();  
        lit.next();  
        lit.remove();  
        System.out.println("<--list�е����� ��" + list + "-->");  
          
          
        System.out.println("<--ɾ��list�еĵ�һ�������һ��Ԫ��-->");  
        list.removeFirst();  
        list.removeLast();  
          
        System.out.println("<--list�й��� ��" + list.size() + "��Ԫ��-->");  
        System.out.println("<--list�е����� ��" + list + "-->");  
	}
}
