package DataStructures.Stacks;

import java.util.NoSuchElementException;

public class ThreeStackInOne {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeStackInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    /* Push Values onto stack. */
    public void push(int stackNum, int value) throws Exception {
        /* Check that we have space for the next element */
        if (isFull(stackNum)) {
            throw new Exception("Stack is full");
        } else {
            /* Increment stack pointer and then update top value. */
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }
    }

    /* Pop Item from top stack*/
    public int pop(int stackNum) throws NoSuchElementException {
        if (isEmpty(stackNum)){
            throw new NoSuchElementException();
        }
        int value = values[indexOfTop(stackNum)];
        values[indexOfTop(stackNum)] = 0;
        sizes[stackNum]--;
        return value;
    }

    /* Return if stack is empty. */
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    /* Return if stack is full. */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    /*Return index of the top of the stack. */
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
