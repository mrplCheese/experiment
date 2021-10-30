import java.math.BigInteger;
import java.util.Arrays;

public class TestObj {
    public static int[] Builder;
    public static int[] TrueFalse = {1,0,1};
    public static int n2;
    public static BigInteger N2_Fin = BigInteger.valueOf(n2);
    public static BigInteger[] Records;


    public TestObj(int[] larry) {
        Records = new BigInteger[larry.length];
        Arrays.fill(Records, I);
        Builder = larry;
        Driver(0);
    }

    public static void buildNew(int i)
    {
        if (TrueFalse[0] ==1){
            Builder[Records.length-1]++;
        }
        // if (TrueFalse[1]>=0)
        //{
        ////System.out.println("TrueFalse[1]: " + TrueFalse[1]); Most recently made the if statement a comment
        //Update: The problem remains the same, so there is still looming confusion.
        if (TrueFalse[1] ==0) {
            Driver(Records.length-1);
        }
        else if (TrueFalse[1] ==1) {
            Driver(Records.length);
        }
        else{
            Driver(Records.length-TrueFalse[1]);
        }
        //Driver(Records.length-TrueFalse[1]);
        //This was TrueFalse[1], but shouldn't it be the iteration of dimensions?
        //The iteration of each dimension should be determined by the received value in buildNew. What is keeping track currently?? Certainly not TrueFalse[1]...
        //}
    }


    //Driver was made so TestObj (The constructor) and buildNew (Used after the creation of Bob the object) won't have to be long passages of the same code, but can simply call Driver().
    private static void Driver(int i){;
        System.out.println("Records[0]: " + Records[0]);
        System.out.println("Records[1]: " + Records[1]);
        System.out.println("Beginning: Records[2]: " + Records[2]);
        System.out.println("Calling valueB from Driver");
        TrueFalse = valueB(i);
        for (int x=0; x<=TrueFalse.length-1;x++) {
            System.out.println("TrueFalse[" + x + "] =" + TrueFalse[x]);
        }
        for (int x=0; x<=Builder.length-1;x++) {
            System.out.println("Builder[" + x + "] =" + Builder[x]);
        }
        if (TrueFalse[0] == 1){ //TrueFalse[0] = 1 iff n2 !=0.
            TrueFalse[0] = maxCheck(0);
            if (TrueFalse[0] == 1){
                System.out.println("Test to begin");
                System.out.println("Records[0]: " + Records[0]);
                //TrueFalse[0] = 1 iff Records[Records.length-1] < MAX_VAL
                test();
                TrueFalse[1] = Records.length-1;
                ////System.out.println("TrueFalse[1] changes to:" + TrueFalse[1]);
            }
            else{ //Records[Records.length-1]>MAX_VAL
                System.out.println("maxTest not passed.");
                //System.out.println("Non-passing value: " + Records[Records.length-1]);
                TrueFalse[0] = 1;
                Organizer();
                /*TODO Bug fix: After the two lowest-level dimensions pass maxCheck, we go from (1,86,1) to (2,2,1)
                   [this works] but then increases to (3,2,1) instead of (2,2,2) Where does Records[0] change?? */
            }
            //At early failed numbers, Records[0] = 1, and Records[2] NPN = 2 instead of 3 (0,1,2) instead of (1,2,3)
        }
        else
        {
            Organizer();
        }
        //TrueFalse[0] = 0;
        //Organizer is only called in Driver.
    }

    private static void Organizer(){
        //The new problem is when 2 maxchecks are not passed. Maybe we haven't yet implemented a kind of "reset" for when multiple values must change. If we have one, it's not working properly.


        //seem to be having an orderfill problem. Builder[0] fills before Builder[1]. A bit annoying.
      /*int a =0;
      while (a <3)
      {
        //System.out.println("trueFalse[" + a + "]: " + TrueFalse[a]);
        a++;
      }*/
        int x = 0;
        if (TrueFalse[0] == 0){//TrueFalse[0] = 0 iff n2 = 0. TrueFalse[1] value is the dimension in which n2 is equal to 0 (Where 0 is the left-most dimension.)
            Builder[TrueFalse[1]]++;
            //I think this will work!
            ////System.out.println("Builder[" + TrueFalse[1] + "]: " + Builder[TrueFalse[1]]);//Can TrueFalse[1] be equal to 0 here??
            x = Records.length-TrueFalse[1];
            ////System.out.println("Value of x now: " + x);
            ////System.out.println("n2 = 0");
            //System.out.println("Out of line??");
            Builder[x]++;
            x++;
        }
        else if (TrueFalse[0] ==1){ //TrueFalse[0] != 0 iff Records[Records.length-1] > MAX_VAL
            while (maxCheck(x)==0 && x<Records.length )
            {
                x++;
            }
            ////System.out.println("x: " + x +" after iterating");
            //Builder[Records.length-x-2]++ originally
            Builder[Records.length-x-1]++;
            ////System.out.println("This value: " + (Records.length-x-2));
            x = Records.length-x+1;
            ////System.out.println("Maximum hit");
            x--;
            TrueFalse[1] = x;
            ////System.out.println("TrueFalse[1] changes to x: " + TrueFalse[1]);
            ////System.out.println("Before builder recollection, x =" + x);
        }
        else {
            System.out.println("Confusing");
        }
        for (;x<=Records.length-1;x++)
        {
            //System.out.println("You should be seeing this message");
            if (x == 1)
            {
                Builder[x] = 2;
            }
            else if (x==0)
            {
                Builder[x]++;
            }
            else{
                Builder[x] = 1;
            }
        }
        //Start at x
        //Expected values: 1,5,1.
        //Given values: 2,2,1
        //Why?
        for (int r=0; r<=Builder.length-1;r++)
        {
            System.out.println("Builder[" + r + "] =" + Builder[r] + " in Organizer (new iteration??)");
        }
    }

    private static int[] valueB(int x) {
        int [] imp = new int [3];
        //Only used when Records[] has no useful values
        BigInteger xPow = new BigInteger("16");
        BigInteger Bearer = I;
        if (x<Records.length) {
            for (; x < Records.length; x++) {
                Records[x] = valueMath(xPow, x);
                if (Records[x].compareTo(E)!=0){
                    Bearer = BigInteger.ZERO;
                    Bearer = Bearer.add(xPow);
                    xPow = BigInteger.valueOf(16);
                    System.out.println("Ho ho!");
                }
                else {
                    imp[1] = x;
                    imp[2] = 1;
                    System.out.println("He he!");
                    //What value of i will return if [1,2,3] has an n2 value of 0 at '2' ?? 0 || 1 || 2??? Answer (I think): '1' (:
                    return imp;
                }
            }
        }
        else{
            //Occurs when: x>Records.length (The highest dimension of Builder is a new value.
            Records[1] = I;
            Records[2] = I;
            TrueFalse[0] = 1;
            TrueFalse[1] = 0;
            TrueFalse[2] = 1;
            for (int dababy=0; dababy<=Builder.length-1;dababy++)
            {
                System.out.println("Builder[" + dababy + "] =" + Builder[dababy]);
            }
            System.out.println();
            Driver(0);
            //This was originally 0, let's see what changes.
            //TODO Test this else statement
            //Update: For some reason we're getting really high counts. (6,7,8) instead of (1,2,3)
        }
        System.out.println("Hi hi!");
        imp[0] = 1;
        imp[2] = 1;
        return imp;
    }

    private static BigInteger valueMath (BigInteger bob, int a)
    {
        BigInteger Place_Holder;
        bob = bob.pow(Builder[a]);
        System.out.println("bob: " + bob);
       // if (a == 0)
       // {
       //     a++;
        //}
        bob = bob.multiply(Records[a]);
        //a-1 --> a
        System.out.println("new bob: " + bob);
        //Was originally "a-1" and I don't remember why.
        //Update: a returns '-1' repeatedly, and I'm not sure why.
        boolean Needed = n2Builder(bob);
        //This is the only place where n2Builder is called.
        if (Needed)
        {
            Place_Holder = N2_Fin.divide(V);
            bob = bob.subtract(Place_Holder);
            bob = bob.divide(N2_Fin);
            System.out.println("Returning: " + bob + " from valueMath.");
            return bob;
        }
        else {
            System.out.println("Returning: -1 from valueMath.");
            return E;
        }
    }



    private static int maxCheck(int x) {
        x++;
        int wizard = Records[Records.length-x].compareTo(MAX_VAL);
        //When wizard is equal to 1, Records[Records-1] > MAX_VAL (Returns 0 for "false")
        if (wizard ==1) {
            return 0;
        } else {
            return 1;
        }
    }

    public static boolean n2Builder(BigInteger tested) {
        tested = tested.mod(V);
        int tester4 = tested.compareTo(IV);
        int tester3 = tested.compareTo(III);
        int tester2 = tested.compareTo(II);
        int tester1 = tested.compareTo(I);
        if (tester4 == 0) {
            n2 = 20;
        } else if (tester3 == 0) {
            n2 = 40;
        } else if (tester2 == 0) {
            n2 = 10;
        } else if (tester1 == 0) {
            n2 = 5;
        } else {
            n2 = 0;
        } //Only when n2 = 0, we give false
        N2_Fin = BigInteger.valueOf(n2);
        if (n2!=0){
            System.out.println("Returning true");
            return true;
        }
        else{
            System.out.println("Returning false (:");
            return false;
        }
    }

    public static int[] getBuilder()
    {
        return Builder;
    }

    public static int getTrueFalse(){
        return TrueFalse[2];
    }

    public static BigInteger getRecords()
    {
        if (TrueFalse[0] ==1 && TrueFalse[2] == 1)
        {
            System.out.println("Returning: an actual value.");
        }
        else if (TrueFalse[2]!=0)
        {
            //TrueFalse[2] = 0;
            Organizer();
            Driver(0);
        }
        return Records[Records.length-1];
        //Most likely will break stuff. Let's see :D
      /*else if (TrueFalse[1] <= Records.length-1 && TrueFalse[2] ==1){
          //System.out.println("Returning 0");
        return E;
      }
        else
        {
           for (int i = 0; i<100; i++)
        {
          //System.out.println("Returning -1");
        }
          return R;
        }*/
    }

    public static void test() {
        BigInteger Bearer = Records[Records.length-1];
        if (Builder[2] == 1)
        {
            //TODO When Builder[2] == 1 (And perhaps in other cases) the test fails. Not sure what's up.
        }
        int count = 0;
        boolean bob = true;
        BigInteger Tested;
        int twisted;
        int terminator;
        //BigInteger Holder = Bearer;
        while (bob)// our beloved bob loop
        {
            Tested = Bearer.mod(II);
            twisted = Tested.compareTo(I);
            // If bearer is odd, twisted is 0.
            // If bearer is even, twisted is -1.

            if (twisted == 0)// If bearer is odd
            {
                Bearer = Bearer.multiply(V);
                Bearer = Bearer.add(I);
                count++;
            } else// If bearer is even
            {
                Bearer = Bearer.divide(II);
            }
            terminator = Bearer.compareTo(I);
            // This terminates the bob loop, thus completing the count! (Poor beloved bob
            // loop)
            if (terminator == 0) {
                bob = false;
            }
        }
        if (count != Records.length) {
            System.out.println("failed number: "  + Records[Records.length-1]);
            TrueFalse[2] = 0;
        }
        else
        {
            System.out.println("Success!");
        }
    }

    //Important BigInteger values for doing basic math more quickly when working with BigIntegers
    public static final BigInteger R = BigInteger.valueOf(-1);
    public static final BigInteger E = BigInteger.ZERO;
    public static final BigInteger I = BigInteger.ONE;
    public static final BigInteger II = BigInteger.TWO;
    public static final BigInteger III = BigInteger.valueOf(3);
    public static final BigInteger IV = BigInteger.valueOf(4);
    public static final BigInteger V = BigInteger.valueOf(5);
    public static final BigInteger MAX_VAL = new BigInteger(
            "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
}
//Possible problems: there may not be a proper change of "TrueFalse[]" values, or maybe there is a problem with the organizer, or maybe there is a problem with RecordsKeeper[].

//I'm confident in: n2builder, getBuilder, maxCheck, TestObj, test,

//I'm fairly confident in valueMath.

//Leaving: ValueB, Organizer, Driver, and BuildNew
//I think the Organizer problems for n2 =0 are now solved. What is next? maxchecks when more than dimension has exceeded the maximum. (This should be the final hoop! I won't get my hopes up, though.) It's possible that there's another, unaccounted for reason.