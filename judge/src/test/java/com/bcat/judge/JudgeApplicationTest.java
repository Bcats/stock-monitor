package com.bcat.judge;

import static org.junit.Assert.assertTrue;

import com.bcat.judge.utils.CompareItemResolver;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class JudgeApplicationTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String s = "x lt 6.12";
        boolean b = new CompareItemResolver().isTriggerAlarm(s, "7");
        System.out.println("");
    }
}
