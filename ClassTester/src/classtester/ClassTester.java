
package classtester;

/**
 *
 * @author Jeremiah
 */
public class ClassTester {


    public static void main(String[] args) {
     
        System.out.println(MyConstruct.getFee());
                 ClassA.runFrame();
        option2();

        
        
    }
    
    public static void option2(){
        MyConstruct myconstruct=new MyConstruct();
          System.out.println(myconstruct.getFee());
    }
    
}
