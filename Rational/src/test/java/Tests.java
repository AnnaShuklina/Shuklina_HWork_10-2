import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Tests extends Assert {

    private Rational fr;

    @Before
    public void initialize() {
        fr = new Rational();
    }

    @After
    public void drop() {
        fr = null;
    }

    //Блок тестов на создание рационального числа

    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test
    public void testStandardConstructorPositiveNumbers(){
        Rational ratNumber = new Rational(1 , 1 );
        assertEquals("1/1 constructor returns wrong numerator" , 1 , ratNumber.getNumerator());
        assertEquals("1/1 constructor returns wrong denominator", 1 , ratNumber.getDenominator());
    }

    @Test
    public void testStandardConstructorNegativeNumbers() {
        Rational ratNumber = new Rational(-1, 1);
        assertEquals("-1/1 constructor returns wrong numerator", -1, ratNumber.getNumerator());
        assertEquals("-1/1 constructor returns wrong denominator", 1, ratNumber.getDenominator());
    }

    // деление на ноль
    @Test
    public void divisionByZero(){
        try{
            Rational ratNumber = new Rational(1 , 0);
            Assert.fail("division by zero !");
        }
        catch (ArithmeticException thrown){
            Assert.assertEquals("division by zero !",thrown.getMessage());
        }
    }

    // сокращение дробей
    @Test
    public void reductionWith0(){
        Rational ratNumber = new Rational(0 , 123);
        assertEquals("wrong reduce 0/123", 0 , ratNumber.getNumerator());
        assertEquals("wrong reduce 0/123", 1 , ratNumber.getDenominator());
    }
    @Test
    public void standardReductionWith1Divider(){
        Rational ratNumber = new Rational(15 , 35);
        assertEquals("wrong reduce 15/35", 3 , ratNumber.getNumerator());
        assertEquals("wrong reduce 15/35", 7 , ratNumber.getDenominator());
    }
    @Test
    public void standardReductionWithNegativeNum(){
        Rational ratNumber = new Rational(-2,36);
        assertEquals("Wrong reduce -2/36",-1, ratNumber.getNumerator());
        assertEquals("Wrong reduce -2/36",18, ratNumber.getDenominator());
    }
    @Test
    public void standardReductionWithNegativeDenom(){
        Rational rational2 = new Rational(2 , -36);
        assertEquals("wrong reduce -2/36", -1 , rational2.getNumerator());
        assertEquals("wrong reduce -2/36", 18 , rational2.getDenominator());
    }
    @Test
    public void standardReductionWithNegativeDenom2Divider(){
        Rational rational3 = new Rational(35 , - 105) ;
        assertEquals("wrong reduce 35/-105", -1 , rational3.getNumerator());
        assertEquals("wrong reduce 35/-105", 3 , rational3.getDenominator());
    }

    //Блок тестов на арифметические операции
    // Сложение
    @Test
    public void testPlusStandard(){
        Rational ratNumberOne = new Rational(1 , 2);
        Rational ratNumberTwo = new Rational(1 , 3);
        assertEquals("wrong 1/2 + 1/3", new Rational (5 , 6) , ratNumberOne.plus(ratNumberTwo));
    }

    @Test
    public void testPlusStandardWithReduction(){
        Rational ratNumberOne = new Rational(1 , 10);
        Rational ratNumberTwo = new Rational(3 , 10);
        assertEquals("wrong 1/10 + 3/10", new Rational (2 , 5) , ratNumberOne.plus(ratNumberTwo));
    }

    @Test
    public void testPlusStandardNegative(){
        Rational ratNumberOne = new Rational(-1 , 2);
        Rational ratNumberTwo = new Rational(1 , 3);
        assertEquals("wrong (-1/2) + 1/3", new Rational (-1 , 6) , ratNumberOne.plus(ratNumberTwo));
    }

    @Test
    public void testPlusStandard2Negative(){
        Rational ratNumberOne = new Rational(-1 , 2);
        Rational ratNumberTwo = new Rational(-1 , 3);
        assertEquals("wrong (-1/2) + (-1/3)", new Rational (-5 , 6) , ratNumberOne.plus(ratNumberTwo));
    }

    @Test
    public void testPlusZero(){
        Rational ratNumberOne = new Rational(1 , 2);
        Rational ratNumberTwo = new Rational(0 , 1);
        assertEquals("wrong (1/2) + 0", ratNumberOne , ratNumberOne.plus(ratNumberTwo));
    }

    @Test
    public void testPlusNegativeZero(){
        Rational ratNumberOne = new Rational(-3 , 2);
        Rational ratNumberTwo = new Rational(0 , 1);
        assertEquals("wrong (-3/2) + 0", ratNumberOne , ratNumberOne.plus(ratNumberTwo));
    }

    @Test
    public void testPlusDoubleZero(){
        Rational ratNumberOne = new Rational(0 , 2);
        Rational ratNumberTwo = new Rational(0 , 3);
        assertEquals("wrong 0 + 0", new Rational (0 , 1) , ratNumberOne.plus(ratNumberTwo));
    }

    //Вычитание
    @Test
    public void testMinusStandard(){
        Rational ratNumberOne = new Rational(1 , 2);
        Rational ratNumberTwo = new Rational(1 , 3);
        assertEquals("wrong 1/2 - 1/3", new Rational (1 , 6) , ratNumberOne.minus(ratNumberTwo));
    }

    @Test
    public void testMinusStandardWithReduction(){
        Rational ratNumberOne = new Rational(3 , 10);
        Rational ratNumberTwo = new Rational(1 , 10);
        assertEquals("wrong 3/10 - 1/10", new Rational (1 , 5) , ratNumberOne.minus(ratNumberTwo));
    }

    @Test
    public void testMinusStandardNegative(){
        Rational ratNumberOne = new Rational(-1 , 2);
        Rational ratNumberTwo = new Rational(1 , 3);
        assertEquals("wrong (-1/2) - 1/3", new Rational (-5 , 6) , ratNumberOne.minus(ratNumberTwo));
    }

    @Test
    public void testMinusStandard2Negative(){
        Rational ratNumberOne = new Rational(-1 , 2);
        Rational ratNumberTwo = new Rational(-1 , 3);
        assertEquals("wrong (-1/2) - (-1/3)", new Rational (-1 , 6) , ratNumberOne.minus(ratNumberTwo));
    }


    @Test
    public void testMinusNegativeZero(){
        Rational ratNumberOne = new Rational(-3 , 2);
        Rational ratNumberTwo = new Rational(0 , 1);
        assertEquals("wrong (-3/2) - 0", ratNumberOne , ratNumberOne.minus(ratNumberTwo));
    }

    @Test
    public void testMinusDoubleZero(){
        Rational ratNumberOne = new Rational(0 , 2);
        Rational ratNumberTwo = new Rational(0 , 3);
        assertEquals("wrong 0 - 0", new Rational (0 , 1) , ratNumberOne.minus(ratNumberTwo));
    }

    //Умножение
    @Test
    public void testMultiplyPositiv(){
        Rational ratNumber = new Rational(3 , 2);
        assertEquals("wrong 3/2 * 3/2", new Rational(9 , 4) , ratNumber.multiply(ratNumber));
    }

    @Test
    public void testMultiplyNegativ(){
        Rational ratNumber = new Rational(-1 , 2);
        assertEquals("wrong (-1/2) * (-1/2)", new Rational(1 , 4) , ratNumber.multiply(ratNumber));
    }

    @Test
    public void testMultiplyNegativePositiv() {
        Rational ratNumberOne = new Rational(-3, 2);
        Rational ratNumberTwo = new Rational(3, 4);
        assertEquals("wrong (-3/2) * (3 / 4 )", new Rational(-9, 8), ratNumberOne.multiply(ratNumberTwo));
    }

    @Test
    public void testMultiplyPositivNegative() {
        Rational ratNumberOne = new Rational(3, 2);
        Rational ratNumberTwo = new Rational(-3, 4);
        assertEquals("wrong (3/2) * (-3 / 4 )", new Rational(-9, 8), ratNumberOne.multiply(ratNumberTwo));
    }

    @Test
    public void testMultiplyZero(){
        Rational ratNumberOne = new Rational(3 , 2);
        Rational ratNumberTwo = new Rational(0 , 2);
        assertEquals("wrong 3/2 * 0", ratNumberTwo , ratNumberOne.multiply(ratNumberTwo));
    }

    @Test
    public void testMultiplyZeroNegativ(){
        Rational ratNumberOne = new Rational(-3 , 2);
        Rational ratNumberTwo = new Rational(0 , 2);
        assertEquals("wrong (-3/2) * 0", ratNumberTwo , ratNumberOne.multiply(ratNumberTwo));
    }

    @Test
    public void testMultiplyDoubleZero(){
        Rational ratNumberOne = new Rational(0 , 2);
        Rational ratNumberTwo = new Rational(0 , 5);
        assertEquals("wrong 0 * 0", new Rational(0 , 1) , ratNumberOne.multiply(ratNumberTwo));
    }

    //Деление
    @Test
    public void testStandardDivide(){
        Rational ratNumber = new Rational(1 , 5);
        assertEquals("wrong (1/5) / (1/5)", new Rational(1 , 1) , ratNumber.divide(ratNumber));
    }

    @Test
    public void testDivideWith1NegativeReduction(){
        Rational ratNumberOne = new Rational(10 , 3);
        Rational ratNumberTwo = new Rational(- 100 , 9);
        assertEquals("wrong (10/3) / (-100/9 )", new Rational (-3 , 10 ) , ratNumberOne.divide(ratNumberTwo));
    }
    @Test
    public void testNegativeDivideNegative(){
        Rational ratNumber = new Rational(- 1 , 3);
        assertEquals("Wrong (-1/3) / (-1/3)" , new Rational( 1 , 1 ) , ratNumber.divide(ratNumber));
    }

    @Test
    public void testZeroDivide(){
        Rational ratZero = new Rational( 0 , 1);
        Rational ratNumber = new Rational( 1 , 3);
        assertEquals("Wrong 0 / (1/3)" , ratZero , ratZero.divide(ratNumber));
    }

    @Test
    public void testDivideZero(){
        Rational ratZero = new Rational(0 , 1) ;
        Rational ratNumberOne = new Rational(1 , 1) ;
        try{
            ratNumberOne.divide(ratZero);
            Assert.fail("division by zero !");
        }
        catch (ArithmeticException thrown){
            Assert.assertEquals("division by zero !",thrown.getMessage());
        }
    }

    //Блок тестов на операции сравнения
    @Test
    public  void positiveWithPositiveSameDenominator(){
        Rational ratNumberOne = new Rational(3,2);
        Rational ratNumberTwo = new Rational(5,2);
        assertEquals("Wrong 3/2 > 5/2",true, ratNumberOne.less(ratNumberTwo));
    }

    @Test
    public void compareTestNegativeAndPositive(){
        Rational ratNumberOne = new Rational(-1 , 2) ;
        Rational ratNumberTwo = new Rational(1 , 2) ;
        assertEquals("wrong (-1/2) >  1/2" , true , ratNumberOne.less(ratNumberTwo));
    }

    @Test
    public  void negativeWithNegativeSameDenominator(){
        Rational ratNumberOne = new Rational(-3,2);
        Rational ratNumberTwo = new Rational(-5,2);
        assertEquals("Wrong (-3/2) < (-5/2)",true, ratNumberTwo.less(ratNumberOne));
    }

    @Test
    public  void testLessDiffDenominator(){
        Rational ratNumberOne = new Rational(7,11);
        Rational ratNumberTwo = new Rational(3,4);
        assertEquals("Wrong 3/4 < 7/11",true, ratNumberOne.less(ratNumberTwo));
    }

    @Test
    public  void negativeWithNegativeDiffDenominator(){
        Rational ratNumberOne = new Rational(-7,11);
        Rational ratNumberTwo = new Rational(-3,4);
        assertEquals("Wrong (-3/4) > (-7/11)",true, ratNumberTwo.less(ratNumberOne));
    }


    @Test
    public void testLessZero(){
        Rational ratZero = new Rational();
        Rational ratNumber = new Rational(3 , 1);
        assertEquals("wrong 3/1 > 0", true , ratZero.less(ratNumber));
    }

    @Test
    public  void positiveWithPositiveLessOrEqual(){
        Rational ratNumberOne = new Rational(3,2);
        Rational ratNumberTwo = new Rational(7,2);
        assertEquals("Wrong 3/2 >= 7/2",true, ratNumberOne.lessOrEqual(ratNumberTwo));
    }

    @Test
    public  void positiveWithNegativeLessOrEqual(){
        Rational ratNumberOne = new Rational(-3,2);
        Rational ratNumberTwo = new Rational(7,2);
        assertEquals("Wrong -3/2 >= 7/2",true, ratNumberOne.lessOrEqual(ratNumberTwo));
    }

    @Test
    public  void positiveWithPositiveSameNumber(){
        Rational ratNumberOne = new Rational(3,2);
        assertEquals("Wrong 3/2 < 3/2",true, ratNumberOne.lessOrEqual(ratNumberOne));
    }

    @Test
    public  void negativeWithPositiveSameNumber(){
        Rational ratNumberOne = new Rational(-3,2);
        Rational ratNumberTwo = new Rational(3,2);
        assertEquals("Wrong -3/2 > 3/2",true, ratNumberOne.lessOrEqual(ratNumberTwo));
    }

    @Test
    public void testLessOrEqualZeroSameDenominator(){
        Rational ratZero = new Rational();
        Rational ratNumber = new Rational(3 , 1);
        assertEquals("wrong 3/1 < 0", true , ratZero.lessOrEqual(ratNumber));
    }

    @Test
    public void testLessOrEqualZeroSameDenominatorNegative(){
        Rational ratZero = new Rational();
        Rational ratNumber = new Rational(-3 , 1);
        assertEquals("wrong -3/1 > 0", true , ratNumber.lessOrEqual(ratZero));
    }






}