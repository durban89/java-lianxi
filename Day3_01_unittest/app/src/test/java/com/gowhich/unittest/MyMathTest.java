package com.gowhich.unittest;


import org.junit.Test;
import static org.junit.Assert.*;

public class MyMathTest {
    @Test
    public void add() {
        MyMath math = new MyMath();
        assertEquals(7, math.add(3,4));
    }
}
