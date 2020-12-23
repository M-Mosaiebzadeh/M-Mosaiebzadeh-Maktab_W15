import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ChangerTest {

    @Test
    public void toIntegerTest_normal() {
        String str1 = "1234";
        String str2 = "-14";
        String str3 = "-928";
        String str4 = "+1283";

        Assert.assertEquals(1234,Changer.toInteger(str1).intValue());
        Assert.assertEquals(-14,Changer.toInteger(str2).intValue());
        Assert.assertEquals(-928,Changer.toInteger(str3).intValue());
        Assert.assertEquals(1283,Changer.toInteger(str4).intValue());
    }
    
    @Test
    public void toIntegerTest_startWithZero() {
        String str1 = "0001234";
        String str2 = "-00014";
        String str3 = "000";
        String str4 = "-0";
        Assert.assertEquals(1234,Changer.toInteger(str1).intValue());
        Assert.assertEquals(-14,Changer.toInteger(str2).intValue());
        Assert.assertEquals(0,Changer.toInteger(str3).intValue());
        Assert.assertEquals(0,Changer.toInteger(str4).intValue());
    }

    @Test
    public void toIntegerTest_marginal() {
        String str1 = "32767";
        String str2 = "-32768";
        Assert.assertEquals(32767,Changer.toInteger(str1).intValue());
        Assert.assertEquals(-32768,Changer.toInteger(str2).intValue());
    }

    @Test(expected = NullPointerException.class)
    public void toIntegerTest_null() {
        Changer.toInteger(null);
    }

    @Test(expected = NumberFormatException.class)
    public void toIntegerTest_marginal2() {
        String str1 = "32768";
        String str2 = "-32769";

        Changer.toInteger(str1);
        Changer.toInteger(str2);
    }

    @Test(expected = NumberFormatException.class)
    public void toIntegerTest_notInteger() {
        String str1 = "-se327";
        String str2 = "83m34";
        String str3 = "@3m34";

        Changer.toInteger(str1);
        Changer.toInteger(str2);
        Changer.toInteger(str3);
    }

    @Test
    public void toIntegerWithJavaTest() {
        try{
            String str = "@3m34";
            Changer.toIntegerWithJava(str);
        }catch (NumberFormatException exception){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void toIntegerWithJava2Test() {
        try{
            String str = "-2321434";
            Changer.toIntegerWithJava2(str);
        }catch (NumberFormatException exception){
            Assert.assertTrue(true);
        }
    }
}
