package br.ufal.ic.easy.collections.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ArrayStackTest {

    private StackADT<Integer> stack;

    @Before
    public void setUp() {
        this.stack = new ArrayStack<>();
    }

    @Test
    public void testSizeIsZeroInEmptyStack() {
        Assert.assertEquals(0, this.stack.size());
    }

    @Test
    public void testIsEmptyInEmptyStack() {
        Assert.assertTrue(this.stack.isEmpty());
    }

    @Test
    public void testPopInEmptyStack() {
        Assert.assertEquals(0, this.stack.size());

        Assert.assertNull(this.stack.pop());
    }

    @Test
    public void testPeekInEmptyStack() {
        Assert.assertEquals(0, this.stack.size());

        Assert.assertNull(this.stack.peek());
    }

    @Test
    public void testPushSize() {
        this.stack.push(100);

        Assert.assertEquals(1, this.stack.size());
    }

    @Test
    public void testPopSize() {
        this.stack.push(100);

        Assert.assertEquals(1, this.stack.size());
        Assert.assertEquals(100, this.stack.pop().intValue());
        Assert.assertNull(this.stack.pop());
        Assert.assertEquals(0, this.stack.size());
    }

    @Test
    public void testPeekSize() {
        this.stack.push(100);

        Assert.assertEquals(1, this.stack.size());
        Assert.assertEquals(100, this.stack.peek().intValue());
        Assert.assertEquals(1, this.stack.size());
        Assert.assertEquals(100, this.stack.peek().intValue());
    }

    @Test
    public void testPopOrder() {
        this.stack.push(100);
        this.stack.push(200);
        this.stack.push(300);
        this.stack.push(400);
        this.stack.push(500);
        this.stack.push(600);
        this.stack.push(700);
        this.stack.push(800);

        Assert.assertEquals(8, this.stack.size());
        Assert.assertEquals(800, this.stack.pop().intValue());
        Assert.assertEquals(700, this.stack.peek().intValue());

        Assert.assertEquals(7, this.stack.size());
        Assert.assertEquals(700, this.stack.pop().intValue());
        Assert.assertEquals(600, this.stack.peek().intValue());

        Assert.assertEquals(6, this.stack.size());
        Assert.assertEquals(600, this.stack.pop().intValue());
        Assert.assertEquals(500, this.stack.peek().intValue());

        Assert.assertEquals(5, this.stack.size());
        Assert.assertEquals(500, this.stack.pop().intValue());
        Assert.assertEquals(400, this.stack.peek().intValue());

        Assert.assertEquals(4, this.stack.size());
        Assert.assertEquals(400, this.stack.pop().intValue());
        Assert.assertEquals(300, this.stack.peek().intValue());

        Assert.assertEquals(3, this.stack.size());
        Assert.assertEquals(300, this.stack.pop().intValue());
        Assert.assertEquals(200, this.stack.peek().intValue());

        Assert.assertEquals(2, this.stack.size());
        Assert.assertEquals(200, this.stack.pop().intValue());
        Assert.assertEquals(100, this.stack.peek().intValue());

        Assert.assertEquals(1, this.stack.size());
        Assert.assertEquals(100, this.stack.pop().intValue());
        Assert.assertNull(this.stack.peek());

        Assert.assertEquals(0, this.stack.size());
    }

    @Test
    public void testPopAndPushOrder() {
        this.stack.push(100);
        this.stack.push(200);
        this.stack.push(300);
        this.stack.push(400);
        this.stack.push(500);
        this.stack.push(600);
        this.stack.push(700);
        this.stack.push(800);

        Assert.assertEquals(8, this.stack.size());
        Assert.assertEquals(800, this.stack.pop().intValue());
        Assert.assertEquals(700, this.stack.peek().intValue());

        this.stack.push(999);

        Assert.assertEquals(8, this.stack.size());
        Assert.assertEquals(999, this.stack.pop().intValue());
        Assert.assertEquals(700, this.stack.peek().intValue());

        Assert.assertEquals(7, this.stack.size());
        Assert.assertEquals(700, this.stack.pop().intValue());
        Assert.assertEquals(600, this.stack.peek().intValue());

        Assert.assertEquals(6, this.stack.size());
        Assert.assertEquals(600, this.stack.pop().intValue());
        Assert.assertEquals(500, this.stack.peek().intValue());

        this.stack.push(999);

        Assert.assertEquals(6, this.stack.size());
        Assert.assertEquals(999, this.stack.pop().intValue());
        Assert.assertEquals(500, this.stack.peek().intValue());

        Assert.assertEquals(5, this.stack.size());
        Assert.assertEquals(500, this.stack.pop().intValue());
        Assert.assertEquals(400, this.stack.peek().intValue());

        Assert.assertEquals(4, this.stack.size());
        Assert.assertEquals(400, this.stack.pop().intValue());
        Assert.assertEquals(300, this.stack.peek().intValue());

        Assert.assertEquals(3, this.stack.size());
        Assert.assertEquals(300, this.stack.pop().intValue());
        Assert.assertEquals(200, this.stack.peek().intValue());

        this.stack.push(999);

        Assert.assertEquals(3, this.stack.size());
        Assert.assertEquals(999, this.stack.pop().intValue());
        Assert.assertEquals(200, this.stack.pop().intValue());
        Assert.assertEquals(100, this.stack.pop().intValue());

        Assert.assertEquals(0, this.stack.size());
        Assert.assertTrue(this.stack.isEmpty());
        Assert.assertNull(this.stack.peek());
    }

    @Test
    public void testClearEmptyStack() {
        this.stack.clear();

        Assert.assertEquals(0, this.stack.size());
        Assert.assertTrue(this.stack.isEmpty());
        Assert.assertNull(this.stack.peek());
        Assert.assertNull(this.stack.pop());
    }

    @Test
    public void testClear() {

        this.stack.push(-99);
        this.stack.push(-99);
        this.stack.push(-99);
        this.stack.push(-99);

        this.stack.clear();

        Assert.assertEquals(0, this.stack.size());
        Assert.assertTrue(this.stack.isEmpty());
        Assert.assertNull(this.stack.peek());
        Assert.assertNull(this.stack.pop());
    }

    @Test
    public void testMaxInitialCapacity() {

        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);
        this.stack.push(4);
        this.stack.push(5);
        this.stack.push(6);
        this.stack.push(7);
        this.stack.push(8);
        this.stack.push(9);
        this.stack.push(10);
        this.stack.push(11);
        this.stack.push(12);
        this.stack.push(13);
        this.stack.push(14);
        this.stack.push(15);
        this.stack.push(16);
        this.stack.push(17);
        this.stack.push(18);
        this.stack.push(19);
        this.stack.push(20);
        this.stack.push(21);
        this.stack.push(22);
        this.stack.push(23);
        this.stack.push(24);
        this.stack.push(25);
        this.stack.push(26);
        this.stack.push(27);

        Assert.assertEquals(25, this.stack.size());

        Assert.assertEquals(27, this.stack.pop().intValue());
        Assert.assertEquals(26, this.stack.pop().intValue());
        Assert.assertEquals(25, this.stack.pop().intValue());
        Assert.assertEquals(24, this.stack.pop().intValue());
        Assert.assertEquals(23, this.stack.pop().intValue());
        Assert.assertEquals(22, this.stack.pop().intValue());
        Assert.assertEquals(21, this.stack.pop().intValue());
        Assert.assertEquals(20, this.stack.pop().intValue());
        Assert.assertEquals(19, this.stack.pop().intValue());
        Assert.assertEquals(18, this.stack.pop().intValue());
        Assert.assertEquals(17, this.stack.pop().intValue());
        Assert.assertEquals(16, this.stack.pop().intValue());
        Assert.assertEquals(15, this.stack.pop().intValue());
        Assert.assertEquals(14, this.stack.pop().intValue());
        Assert.assertEquals(13, this.stack.pop().intValue());
        Assert.assertEquals(12, this.stack.pop().intValue());
        Assert.assertEquals(11, this.stack.pop().intValue());
        Assert.assertEquals(10, this.stack.pop().intValue());
        Assert.assertEquals(9, this.stack.pop().intValue());
        Assert.assertEquals(8, this.stack.pop().intValue());
        Assert.assertEquals(7, this.stack.pop().intValue());
        Assert.assertEquals(6, this.stack.pop().intValue());
        Assert.assertEquals(5, this.stack.pop().intValue());
        Assert.assertEquals(4, this.stack.pop().intValue());
        Assert.assertEquals(3, this.stack.pop().intValue());

        Assert.assertNull(this.stack.pop());
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testStackNegativeCapacity() {
        new ArrayStack<>(-1);
    }

    @Test
    public void testStackZeroCapacity() {
        StackADT<Integer> stack = new ArrayStack<>(0);

        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopStackZeroCapacity() {
        StackADT<Integer> stack = new ArrayStack<>(0);

        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.isEmpty());
        Assert.assertNull(stack.pop());
    }

    @Test
    public void testPeekStackZeroCapacity() {
        StackADT<Integer> stack = new ArrayStack<>(0);

        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.isEmpty());
        Assert.assertNull(stack.peek());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPushStackZeroCapacity() {
        StackADT<Integer> stack = new ArrayStack<>(0);

        stack.push(100);
    }

    @Test
    public void testClearStackZeroCapacity() {
        StackADT<Integer> stack = new ArrayStack<>(0);

        stack.clear();

        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.isEmpty());
        Assert.assertNull(stack.pop());
    }

    @Test
    public void testPushStackOneCapacity() {
        StackADT<Integer> stack = new ArrayStack<>(1);

        stack.push(100);

        Assert.assertEquals(1, stack.size());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(100, stack.pop().intValue());
    }

    @Test
    public void testTwoPushStackOneCapacity() {
        StackADT<Integer> stack = new ArrayStack<>(1);

        stack.push(100);
        stack.push(200);

        Assert.assertEquals(1, stack.size());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(200, stack.pop().intValue());
    }

    @Test
    public void testPushMaxInteger() {
        this.stack.push(Integer.MAX_VALUE);

        Assert.assertEquals(1, stack.size());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(Integer.MAX_VALUE, stack.pop().intValue());
    }

    @Test
    public void testPushMinInteger() {
        this.stack.push(Integer.MIN_VALUE);

        Assert.assertEquals(1, stack.size());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(Integer.MIN_VALUE, stack.pop().intValue());
    }

    @Test
    public void testPushNull() {
        this.stack.push(null);

        Assert.assertEquals(1, stack.size());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertNull(stack.pop());
        Assert.assertEquals(0, stack.size());
    }

}
