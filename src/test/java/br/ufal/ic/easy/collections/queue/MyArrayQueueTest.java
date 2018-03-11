package br.ufal.ic.easy.collections.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayQueueTest {

    private MyArrayQueue<Integer> queue;

    @Before
    public void setUp() {
        this.queue = new MyArrayQueue<>();
    }

    @Test
    public void testSizeIsZeroInEmptyQueue() {
        Assert.assertEquals(0, this.queue.size);
    }

    @Test
    public void testEnqueueSize() {
        this.queue.enqueue(100);

        Assert.assertEquals(1, this.queue.size);
    }

    @Test(expected = EmptyQueueException.class)
    public void testDequeueInEmptyQueue() {
        Assert.assertEquals(0, this.queue.size);

        this.queue.dequeue();
    }

    @Test(expected = EmptyQueueException.class)
    public void testDequeueAfterEmptyQueue() {

        this.queue.enqueue(100);

        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(100, this.queue.dequeue().intValue());

        this.queue.dequeue();
    }

    @Test
    public void testEnqueueMaxIntegerValue() {
        this.queue.enqueue(Integer.MAX_VALUE);

        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(Integer.MAX_VALUE, this.queue.dequeue().intValue());
    }

    @Test
    public void testDequeueCorrectOrder() {

        this.queue.enqueue(100);
        this.queue.enqueue(200);
        this.queue.enqueue(300);
        this.queue.enqueue(400);
        this.queue.enqueue(500);

        Assert.assertEquals(5, this.queue.size);
        Assert.assertEquals(100, this.queue.dequeue().intValue());
        Assert.assertEquals(200, this.queue.dequeue().intValue());
        Assert.assertEquals(300, this.queue.dequeue().intValue());
        Assert.assertEquals(400, this.queue.dequeue().intValue());
        Assert.assertEquals(500, this.queue.dequeue().intValue());
    }

    @Test
    public void testDequeue() {

        this.queue.enqueue(100);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(100, this.queue.dequeue().intValue());
        this.queue.enqueue(200);
        this.queue.enqueue(300);
        Assert.assertEquals(2, this.queue.size);
        Assert.assertEquals(200, this.queue.dequeue().intValue());
        this.queue.enqueue(400);
        this.queue.enqueue(500);
        this.queue.enqueue(600);
        Assert.assertEquals(4, this.queue.size);
        Assert.assertEquals(300, this.queue.dequeue().intValue());
        this.queue.enqueue(700);
        this.queue.enqueue(800);
        this.queue.enqueue(900);
        this.queue.enqueue(1000);
        Assert.assertEquals(7, this.queue.size);
        Assert.assertEquals(400, this.queue.dequeue().intValue());

        Assert.assertEquals(6, this.queue.size);
        Assert.assertEquals(500, this.queue.dequeue().intValue());
        Assert.assertEquals(600, this.queue.dequeue().intValue());
        Assert.assertEquals(700, this.queue.dequeue().intValue());
        Assert.assertEquals(800, this.queue.dequeue().intValue());
        Assert.assertEquals(900, this.queue.dequeue().intValue());
        Assert.assertEquals(1000, this.queue.dequeue().intValue());
        Assert.assertEquals(0, this.queue.size);

    }

    @Test
    public void testDequeue2() {

        this.queue.enqueue(100);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(100, this.queue.dequeue().intValue());
        this.queue.enqueue(200);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(200, this.queue.dequeue().intValue());
        this.queue.enqueue(300);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(300, this.queue.dequeue().intValue());
        this.queue.enqueue(400);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(400, this.queue.dequeue().intValue());
        this.queue.enqueue(500);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(500, this.queue.dequeue().intValue());
        this.queue.enqueue(600);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(600, this.queue.dequeue().intValue());
        this.queue.enqueue(700);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(700, this.queue.dequeue().intValue());
        this.queue.enqueue(800);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(800, this.queue.dequeue().intValue());
        this.queue.enqueue(900);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(900, this.queue.dequeue().intValue());
        this.queue.enqueue(1000);
        Assert.assertEquals(1, this.queue.size);
        Assert.assertEquals(1000, this.queue.dequeue().intValue());
    }

    @Test
    public void testEnlargeOddItems() {
        this.queue.enqueue(100);
        this.queue.enqueue(200);
        this.queue.enqueue(300);
        this.queue.enqueue(400);
        this.queue.enqueue(500);
        this.queue.enqueue(600);
        this.queue.enqueue(700);
        this.queue.enqueue(800);
        this.queue.enqueue(900);
        this.queue.enqueue(1000);
        this.queue.enqueue(1200);

        Assert.assertEquals(11, this.queue.size);
    }

    @Test
    public void testEnlargeEvenItems() {
        this.queue.enqueue(100);
        this.queue.enqueue(200);
        this.queue.enqueue(300);
        this.queue.enqueue(400);
        this.queue.enqueue(500);
        this.queue.enqueue(600);
        this.queue.enqueue(700);
        this.queue.enqueue(800);
        this.queue.enqueue(900);
        this.queue.enqueue(1000);
        this.queue.enqueue(1200);
        this.queue.enqueue(1300);

        Assert.assertEquals(12, this.queue.size);
    }

    @Test
    public void testEnqueueNull() {
        this.queue.enqueue(null);

        Assert.assertEquals(1, this.queue.size);
    }

    @Test
    public void testDequeueNull() {
        this.queue.enqueue(null);

        Assert.assertNull(this.queue.dequeue());
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testConstructorWithNegativeCapacity() {
        new MyArrayQueue<>(-1);
    }

    @Test()
    public void testConstructorWithZeroCapacity() {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(0);

        Assert.assertEquals(0, queue.size);
    }

    @Test(expected = EmptyQueueException.class)
    public void testDequeueWithZeroCapacity() {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(0);

        queue.dequeue();
    }

    @Test()
    public void testEnlargeWithZeroCapacity() {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(0);

        queue.enqueue(100);

        Assert.assertEquals(1, queue.size);
        Assert.assertEquals(100, queue.dequeue().intValue());
    }

    @Test()
    public void testEnlargeWithCapacity() {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(1);

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.enqueue(500);
        queue.enqueue(600);
        queue.enqueue(700);
        queue.enqueue(800);
        queue.enqueue(900);
        queue.enqueue(1000);
        queue.enqueue(1100);
        queue.enqueue(1200);

        Assert.assertEquals(12, queue.size);
    }


    @Test()
    public void testDequeueOrderWithCapacity() {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(1);

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        Assert.assertEquals(3, queue.size);
        Assert.assertEquals(100, queue.dequeue().intValue());
        Assert.assertEquals(200, queue.dequeue().intValue());
        Assert.assertEquals(300, queue.dequeue().intValue());
    }

}
