day====1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Calculate {
public static void main(String[] args) {
//creating lambda expression
Calculator adder =(num1, num2) -> {
return num1;
};
//executing lambda expression
int result = adder.operation(5,6); //Line 3
System.out.println(result);

===========================================================
Function<Integer, String> getCube = (value) -> value*value*value+" Res";
String resultCube = getCube.apply(6);
System.out.println(resultCube);
BiPredicate<Integer,String> checkExpRole = (exp,role) -> exp>4 && role=="Manager";
System.out.println(checkExpRole.test(5, "Manager"));
//Supply 5 Random Double Values Using Supplier<T>
Supplier<Double> generateRandom = ()-> 100.0;
System.out.println(generateRandom.get());
Calculator add = (x,y) -> x+y;
Calculator subtract = (x,y) -> x-y;
Calculator multiply = (x,y) -> x*y;
Calculator divide = (x,y) -> x/y;
System.out.println("Result is: "+doOperation(12, 4,(x,y) -> x+y));
============================================================================
List<String> castList = List.of("Sam","Dean","Castiel","Crowley");
Stream<String> supernatural = castList.stream();
Integer[] array = {672, 340, 999};
Stream<Integer> stream = Arrays.stream(array);
Stream<Integer> streams = Stream.of(672, 340, 999);
List<String> placesToVisit= new ArrayList<String>();
placesToVisit.add("Chicago");
placesToVisit.add("Venice");
placesToVisit.add("Tokyo");
placesToVisit.add("San Francisco");
placesToVisit.add("Kyoto");
placesToVisit.add("Abu Dhabi");
placesToVisit.stream().forEach(place1 -> System.out.println("Trip to " + place1));
========================================================================================
List<String> placesToVisit1= new ArrayList<String>();
placesToVisit1.add("Chicago");
placesToVisit1.add("Venice");
placesToVisit1.add("Tokyo");
placesToVisit1.add("San Francisco");
placesToVisit1.add("Kyoto");
placesToVisit1.add("Abu Dhabi");
// CHICAGO
// VENICE
// TOKYO
// SAN FRANCISCO
// KYOTO
// ABU DHABI
List<String> placesToVisit2= new ArrayList<String>();
placesToVisit2.add("Chicago");
placesToVisit2.add("Venice");
placesToVisit2.add("Tokyo");
placesToVisit2.add("San Francisco");
placesToVisit2.add("Kyoto");
placesToVisit2.add("Abu Dhabi");
System.out.println();
placesToVisit2.stream().filter(place -> place.length() == 5).forEach(x -> System.out.println(x));
===========================================================================================
//No Argument passed in sorted()
List<String> placesToVisit3= new ArrayList<String>();
placesToVisit3.add("Chicago");
placesToVisit3.add("Venice");
placesToVisit3.add("Tokyo");
placesToVisit3.add("San Francisco");
placesToVisit3.add("Kyoto");
placesToVisit3.add("Abu Dhabi");
System.out.println();
placesToVisit3.stream().sorted().forEach(place -> System.out.println(place));
List<Integer> number = new ArrayList();
number.add(2);
number.add(3);
number.add(4);
number.add(5);
//4,6,8,10
//The Modified Stream is stored in "doubled" using collect()
List<Integer> doubled = number.stream().map(x -> 2*x).collect(Collectors.toList());
System.out.println();
System.out.println(doubled);
System.out.println();
placesToVisit.stream() //stream()
.filter(place -> place.length() <= 8) //filter()
.map(place -> place.toUpperCase()) //map()
.forEach(x -> System.out.println(x));
Stream<String> streamPlaces = placesToVisit.stream();
======================================================================================
//filter() applies the appropriate filter conditions to obtain Modified Stream
Stream<String> filterStream = streamPlaces.filter(place -> place.length() <= 8);
//map() applies appropriate modification to a given Stream
Stream<String> mapFilter = filterStream.map(place -> place.toUpperCase());
//forEach() displays all the content of the Stream in console
System.out.println();
mapFilter.forEach(x -> System.out.println(x));
=============================================================
Stream<Integer> intStream = Stream.of(10,2,7,5,6,5,8,11);
intStream.filter(n -> { System.out.println("Filtering Current Element: "+n);return n % 2 == 0;})
.map(n -> { System.out.println("Mapping Current Element: "+n); return n * n * n; })
.sorted()
.forEach(n -> System.out.println(n));
Stream<String> streamNames = Stream.of("Deadpool", "Iron Man", "Spiderman", "Captain America", "Punisher", "Black Panther");
streamNames.filter(name -> name.length()<=10) //Line1
.sorted()
.forEach(name -> System.out.println(name));
streamNames.map(name -> name.toUpperCase()) //Line2
.forEach(name -> System.out.println(name));
}
public static double doOperation(int firstNum, int secondNum, Calculator operator) {
return operator.operation(firstNum, secondNum);
}
}
@FunctionalInterface
interface Calculator{
int operation(int firstNum, int secondNum);
}
=====================================================
day============2
package day3;
 
public class VoterValidator {
                                                                                                            //-14
            public Boolean validateVoterAge(int age) throws Exception {
                       
                       
                        if(age<0)
                                    throw new Exception("Invalid age");
                        else if(age>=0 && age <= 8) {
                                    throw new Exception("Childhood age");
                        }if(age >= 18) {
                                    return true;
                        }
                        else {
                                    return false;
                        }
            }
}
 =====================================================================
Testsuit
 
 
package test;
 
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
 
@RunWith(JUnitPlatform.class)
@SelectClasses({ VoterValidatorTest.class})
@ExcludeTags("dev")
public class TestSuite {
}
 ========================================================
VoterValidaterTest
 
 
package test;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
 
import day3.VoterValidator;
 
import java.util.*;
 ===========================
public class VoterValidatorTest {
   @Test
            public void validateVoterAgeValidTest() throws Exception {
                int age = 18;
                VoterValidator voterValidator = new VoterValidator();
        boolean actualResult =voterValidator.validateVoterAge(age);
                Assertions.assertTrue(actualResult);
    }
------------------------------------------2           
   @Test
            public void validateVoterAgeInValidTest1() throws Exception {
                int age = 17;
                VoterValidator voterValidator = new VoterValidator();
        boolean actualResult =voterValidator.validateVoterAge(age);
                Assertions.assertNotNull(actualResult);
               
                //assertNull(Object actual)
    }
=============================================================
@Test
            public void validateVoterAgeInValidTest2() throws Exception {
                        int age = -14;
                        VoterValidator voterValidator = new VoterValidator();
                        Exception exception = Assertions.assertThrows(Exception.class,()->voterValidator.validateVoterAge(age));
                        Assertions.assertEquals("Invalid age",exception.getMessage());
            }
           
}
