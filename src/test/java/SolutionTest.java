import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SolutionTest {

    private TestCase tc1;
    private TestCase tc2;
    private TestCase tc3;
    private TestCase tc4;
    private TestCase tc5;
    private TestCase tc6;

    @Before
    public void setUp() {
        tc1 = readArrayFromFile(System.getProperty("user.dir").concat("\\src\\test\\java\\inputs\\test1.txt"));
        tc2 = readArrayFromFile(System.getProperty("user.dir").concat("\\src\\test\\java\\inputs\\test2.txt"));
        tc3 = readArrayFromFile(System.getProperty("user.dir").concat("\\src\\test\\java\\inputs\\test3.txt"));
        tc4 = readArrayFromFile(System.getProperty("user.dir").concat("\\src\\test\\java\\inputs\\test4.txt"));
        tc5 = readArrayFromFile(System.getProperty("user.dir").concat("\\src\\test\\java\\inputs\\test5.txt"));
        tc6 = readArrayFromFile(System.getProperty("user.dir").concat("\\src\\test\\java\\inputs\\test6.txt"));
    }

    @Test(timeout=4000)
    public void test1() {
        assertEquals(633, Solution.activityNotifications(tc1.getArray(), tc1.getD()));
    }

    @Test(timeout=4000)
    public void test2() {
        assertEquals(926,Solution.activityNotifications(tc2.getArray(), tc2.getD()));
    }

    @Test(timeout=4000)
    public void test3() {
        assertEquals(492,Solution.activityNotifications(tc3.getArray(), tc3.getD()));
    }

    @Test(timeout=4000)
    public void test4() {
        assertEquals(2,Solution.activityNotifications(tc4.getArray(), tc4.getD()));
    }

    @Test(timeout=4000)
    public void test5() {
        assertEquals(0,Solution.activityNotifications(tc5.getArray(), tc5.getD()));
    }

    @Test(timeout=4000)
    public void test6() {
        assertEquals(1,Solution.activityNotifications(tc6.getArray(), tc6.getD()));
    }

    class TestCase{
        int[] array;
        int d;
        TestCase(int[] array, int d){
            this.array=array;this.d=d;
        }
        private int[] getArray(){return array;}
        private int getD() {return d;}
    }

    private TestCase readArrayFromFile(String fileName){
        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            String[] nd = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nd[0]);

            int d = Integer.parseInt(nd[1]);

            int[] expenditure = new int[n];

            String[] expenditureItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int expenditureItem = Integer.parseInt(expenditureItems[i]);
                expenditure[i] = expenditureItem;
            }
            return new TestCase(expenditure,d);
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

}