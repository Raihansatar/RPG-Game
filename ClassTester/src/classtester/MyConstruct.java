
package classtester;


public class MyConstruct {
    private static double classfee; 
    
    public MyConstruct(){
       classfee=200;
    }
    
    public static void setFee(double fee){
        classfee=fee;
    }
    
    public static double getFee(){
        return classfee;
    }
    
}
