package com.qiho;
import java.util.PriorityQueue;

public class CusAndPro {

 

    private int queueSize = 10 ;

    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

     

    public static void main(String[] args) {

        CusAndPro cap = new CusAndPro();

        Consumer cus = cap.new Consumer();

        Producer pro = cap.new Producer();

        Thread cusT = new Thread(cus);

        Thread proT = new Thread(pro);

         cusT.start();
         proT.start();
         try {
			cusT.join();
			proT.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        

    }

    /**

     * 消费者

     * com.subject01.CusAndPro.java

     * @author 孙涛

     * 2016年5月10日

     */

    class Consumer implements Runnable{
       
        public void run() {

            cousume();

        }
        private void cousume() {

            while(true){

                synchronized (queue) {

                    while(queue.size() ==0){

                        try {

                            System.out.println("队列空，等待数据。。。");

                            queue.wait();

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                            queue.notify();

                        }

                    }
                    queue.poll() ;

                    queue.notify();

                    System.out.println("从队列中取走一个元素，队列中剩余"+queue.size()+"个");

                }

            }

        }
    }

    /**

     * 生产者

     * com.subject01.CusAndPro.java

     * @author 孙涛

     * 2016年5月10日

     */

    class Producer implements Runnable{

 

        @Override

        public void run() {

            produce();

        }

 

        private void produce() {

            while(true){

                synchronized(queue){

                    while(queue.size() == queueSize){

                        try {

                            System.out.println("队列已满，等待空余的空间");

                            queue.wait();

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                            queue.notify();

                        }

                    }

                     

                    queue.offer(1);   // 每次插入一个元素

                    queue.notify();

                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));

                }

            }

        }
        

    }

}