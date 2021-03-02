//********************************************************************
//  TestData.java       Java Foundations
//
//  Demonstrates I/O exceptions and the use of a character file
//  output stream.
//********************************************************************

import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class Application
{
   //-----------------------------------------------------------------
   //  Creates a file of test data that consists of ten lines each
   //  containing ten integer values in the range 10 to 99.
   //-----------------------------------------------------------------
   public static void main(String[] args) throws IOException, FileNotFoundException
   {
      final int MAX = 10;

      int value;
      String file = "test1.dat";

      Random rand = new Random();

      FileWriter fw = new FileWriter(file);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter outFile = new PrintWriter(bw);
      for (int line=1; line <= MAX; line++)
      {
         for (int num=1; num <= MAX; num++)
         {
            value = rand.nextInt(90) + 10;
            outFile.print(value + "   ");
         }
         outFile.println();
      }

      outFile.close();
      System.out.println("Output file has been created: " + file);
   
	try {
		File f = new File(file);
		Scanner Reader = new Scanner(f);
		while(Reader.hasNextLine()) {
			System.out.println(Reader.nextLine());			
		}
		Reader.close();
	}
	 catch (FileNotFoundException e) {
			System.out.println("error");
			//e.printStackTrace();
	}//ends catch
   }
}		
