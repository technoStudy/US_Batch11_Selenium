package utilities;

public class ReusableMethods {

    public static void myWait(int sec){
        try{
           Thread.sleep(sec * 1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }



}
