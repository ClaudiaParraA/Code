package text2number;

import junit.framework.TestCase;

public class TextNumberTest extends TestCase
{
	TextNumber tn = new TextNumber();
	String numberOne="Zero";
	String numberTwo="EIGHTY-NINE";
	String numberThree="six hundred twenty seven";
	String numberFour="three thousand fifteen";
	String numberFive="seven million FOUR HUNDRED TWENTY  NINE";


    /**
     * Verifica la conversion de texto a entero
     */
    public void testLettersToNumbers( )
    {  
        assertEquals(0, tn.letters2numbers(numberOne));
        assertEquals(89, tn.letters2numbers(numberTwo));
        assertEquals(627, tn.letters2numbers(numberThree));
        assertEquals(3015, tn.letters2numbers(numberFour));
        assertEquals(7000429, tn.letters2numbers(numberFive));
        
    }
    
    /**
     * Verifica la suma de dos numeros en texto
     */
    public void  testSuma(){
        assertEquals(89, tn.suma(numberOne, numberTwo));
        assertEquals(7003444, tn.suma(numberFour, numberFive));
    }

}
