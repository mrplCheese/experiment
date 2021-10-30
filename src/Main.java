import java.math.BigInteger;
import java.io.*;
class Main {
    public static void main(String[] args) {
        try{
            BigInteger imp = BigInteger.ONE;
            File f = new File("Answers");
            FileOutputStream fos = new FileOutputStream(f);
            PrintWriter pw = new PrintWriter(fos);
            int[] firstVal = {1,2,1};
            TestObj Bob = new TestObj(firstVal);
            //My fault for making everything static. I'm not sure if I'll have to change anything.
            pw.write(TestObj.getRecords().toString());
            pw.println(", ");

            //Calls method buildNew
            for (int i = 0; imp.compareTo(R)!=0&&firstVal[0]<2; i++) {
                System.out.println("New iteration");
                TestObj.buildNew(i);
                imp = TestObj.getRecords();
                if (imp.compareTo(E)>0)
                {
                    pw.write(imp.toString());
                    pw.println(", ");
                }
                pw.flush();
            }
            System.out.println("Completeeee!");

            fos.close();
            pw.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    public static final BigInteger R = BigInteger.valueOf(-1);
    public static final BigInteger E = BigInteger.ZERO;
}
