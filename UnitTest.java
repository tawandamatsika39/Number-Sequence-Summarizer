import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
* The program tests if the output produced matches the one specified in the requirements example.
* 
* @author  Tawanda Matsika
* @version 1.0
* @since   2019-09-12
*/
public class UnitTest{
 
  @Test
  public void reultCheck() {
  	Runner obj = new Runner();
  	String str= "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
    String str1 = "1, 3, 6-8, 12-15, 21-24, 31";
    String str2 = obj.summarizeCollection(obj.collect(str));
    assertEquals(str1,str2);
  }
}