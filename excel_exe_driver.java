/* Eoin McDonough           18241646
 * Jakub Pažej              18260179
 * Aleksander Jakusev       18257038
 */
public class excel_exe_driver
{
  public static void main() {
      excel_exe workbook = new excel_exe();
      System.out.println("We will first add sheets so we have 9 all together.");
      workbook.add();
      workbook.add();
      workbook.add();
      workbook.add();
      workbook.add();
      workbook.add();
      workbook.display();
      System.out.println("Now we will remove Sheet1");
      workbook.remove("Sheet1");
      workbook.display();
      System.out.println("Now we will remove the 3rd sheet");
      workbook.remove(3);
      workbook.display();
      System.out.println("Now we will move the 3rd sheet to before the 6th");
      workbook.move(3,6,true);
      workbook.display();
      System.out.println("We will move sheet2 to the end");
      workbook.moveToEnd("Sheet2");
      workbook.display();
      System.out.println("Now we will move the 4th sheet to the end");
      workbook.moveToEnd(4);
      workbook.display();
      System.out.println("We will rename the last sheet to BillyH");
      workbook.rename("Sheet6","BillyH");
      workbook.display();
      System.out.println("Now we will find the position of Sheet7");
      workbook.index("Sheet7");
      System.out.println("It is at position " + workbook.index("Sheet7"));
      System.out.println("Now we will find out what sheet is at position 4");
      System.out.println("It is called "+workbook.sheetName(4)); 
      System.out.println("The length of the list is " +workbook.length());
    }
}
