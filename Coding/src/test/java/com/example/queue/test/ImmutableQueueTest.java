package com.example.queue.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.example.queue.ImmutableQueue;
import com.example.queue.Queue;

public class ImmutableQueueTest {

    @Test
    public void testQueue() {
        Queue<Integer> queue = new ImmutableQueue<Integer>().enQueue(1);
        assertEquals(1, queue.head().intValue());
        queue = queue.deQueue();
        assertTrue(queue.isEmpty());

        queue = new ImmutableQueue<>();
        assertTrue(queue.isEmpty());
        Integer[] data = {1, 2, 4, 8, 16, 32};
        for (Integer number : data) {
            queue = queue.enQueue(number);
        }
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.head().intValue());
        assertEquals(2, queue.deQueue().head().intValue());
        assertFalse(queue.isEmpty());
        assertEquals(4, queue.deQueue().head().intValue());
        assertEquals(8, queue.deQueue().head().intValue());
        assertEquals(16, queue.deQueue().head().intValue());
        assertFalse(queue.isEmpty());
        assertEquals(32, queue.deQueue().head().intValue());
        queue.deQueue();
        assertTrue(queue.isEmpty());

    }
}
