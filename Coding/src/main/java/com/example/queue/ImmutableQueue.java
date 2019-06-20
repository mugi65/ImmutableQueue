package com.example.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public final class ImmutableQueue<T> implements Queue<T> {

    private LinkedList<T> queues;

    public ImmutableQueue() {
        this.queues = new LinkedList<>();
    }

    private ImmutableQueue(LinkedList<T> queues) {
        this.queues = queues;
    }

    @Override
    public synchronized Queue<T> enQueue(T object) {
        final LinkedList<T> newQueues = new LinkedList<>(this.queues);
        newQueues.add(object);
        this.queues = newQueues;
        return this;
    }

    @Override
    public synchronized Queue<T> deQueue() {
        if (this.queues.isEmpty()) {
            return new ImmutableQueue<>(new LinkedList<>());
        }
        final LinkedList<T> cloneQueues = new LinkedList<>(this.queues);
        cloneQueues.pop();
        this.queues = cloneQueues;
        return this;
    }

    @Override
    public T head() {
        if (this.queues.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.queues.peek();
    }

    @Override
    public boolean isEmpty() {
        return this.queues.isEmpty();
    }
}
