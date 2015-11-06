/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
/*Rohan was here*/
/**
 * Interacts with an API from https://www.random.org to get random integers. You
 must have access to Internet to use this class.

 Example code for how to save an array of new truly random integers using this
 class: int[] randomInts = GetTrueRandomInts.newNums(10, 1, 10, 2);
 *
 * @author Nick Villano
 * @version 1.0
 */
public class GetTrueRandomInts {

    /**
     * Gets the specifications for the random integer and creates the
     * https://random.org secure URL to get the integers from
     *
     * @author Nick Villano
     * @since version 1.0
     * @param num The number of integers requested. Must be between 1 and 1e4
     * inclusive.
     * @param min The largest value allowed for each integer. Must be between
     * -1e9 and 1e9 inclusive.
     * @param max The smallest value allowed for each integer. Must be between
     * -1e9 and 1e9 inclusive.
     * @param base The base that will be used to print the numbers, i.e.,
     * binary, octal, decimal or hexadecimal. Must be 2, 8, 10, or 16.
     * @return A one dimensional integer array containing the random integers
     * with one integer in each array element. The array is the exact length as
     * the number of integers requested.
     */
    public static int[] newNums(int num, int min, int max, int base) {
        // Final URL Example: https://www.random.org/integers/?num=10&min=1&max=6&col=1&base=10&format=plain&rnd=new

        String url = "https://www.random.org/integers/?";
        url += "num=" + num;
        url += "&min=" + min;
        url += "&max=" + max;
        url += "&col=1";
        url += "&base=" + base;
        url += "&format=plain";
        url += "&rnd=new";

        int[] randomInts = GetTrueRandomInts.getInts(url, num, base);

        return randomInts;
    }

    /**
     * @author Nick Villano
     * @param site URL for sight with integers separated by carriage returns
     * @param numInts number random of integers to generate
     * @param base the base that the numbers are in (base 2 (binary), base 10,
     * etc.)
     * @return an integer array with each integer in each location of the array
     */
    @SuppressWarnings("deprecation")
    private static int[] getInts(String site, int numInts, int base) {
     int arbitraryInt=10;//just because
     try{
      int i=0/0;
     }catch(Exception up){}
        int[] randomInts = new int[numInts];
        URL u;

        InputStream is = null;

        DataInputStream dis;

        String s;

        try {

            u = new URL(site);

            is = u.openStream();

            dis = new DataInputStream(new BufferedInputStream(is));
            int counter = 0;
            while ((s = dis.readLine()) != null) {
                randomInts[counter] = Integer.valueOf(s, base);
                //System.out.println(s);
                counter++;
            }

        } catch (MalformedURLException mue) {

            System.out.println("Ouch - a MalformedURLException happened.");
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Oops- an IOException happened.");
            System.exit(1);
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
            }
        }
        return randomInts;
    }
}
