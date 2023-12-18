package rca.devopsexam.utils;

import org.junit.jupiter.api.Test;
import rca.devopsexam.v1.exceptions.InvalidOperationException;
import rca.devopsexam.v1.serviceImpls.MathOperatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleCalculatorTest {
    private  MathOperatorImpl mathOperatorService = new MathOperatorImpl();
    @Test
    void givenTwoNumbers_whenAdded_returnSum() throws InvalidOperationException {
        //given, act, assert
        double actual = mathOperatorService.doMath(1,4,"+");
        double expected  = 5;
        assertEquals(actual,expected);
    }
    @Test
    public void givenZeroAndAnumber_whenAdded_returnAnumber() throws InvalidOperationException {
        assertEquals(mathOperatorService.doMath(0,4,"+"),4.0);
    }
    @Test
    void givenZeroValues_whenAdded_returnZero() throws InvalidOperationException {
        double actual = mathOperatorService.doMath(0,0,"+");
        double expected = 0.0;
        assertEquals(actual,expected);
    }
    @Test
    void givenTwoNumbers_whenDivided_returnQuotient() throws InvalidOperationException {
        double actual = mathOperatorService.doMath(4,2,"/");
        double expected = 2.0;
        assertEquals(actual,expected);
    }
    @Test
    void throwException_whenDivisorIsZero(){
        Exception exception = assertThrows(InvalidOperationException.class, () -> {
            mathOperatorService.doMath(1,0,"/");
        });
        assertEquals(exception.getMessage(),"Cannot divide by 0");
    }
    @Test
    void returnNumber_WhenDivide_ByOne() throws InvalidOperationException {
        double expected = 8.0;
        double actual = mathOperatorService.doMath(8,1,"/");
        assertEquals(actual , expected);
    }
    @Test
    void multiplied_byOne_returnNumber() throws InvalidOperationException {
        double actual = mathOperatorService.doMath(5,1,"*");
        double expected = 5.0;
        assertEquals(actual,expected);
    }

}

