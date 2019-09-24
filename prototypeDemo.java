/*
170387f. M.W.G.V.Melaka
 */
package prototype;
import java.util.Scanner;
import java.util.Hashtable;

/**
 *
 * @author User
 */


abstract class person implements Cloneable{

private String name;
private String NIC;
private String other_name;
private String current_ad_resi;
private String current_ad_employ;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the other_name
     */
    public String getOther_name() {
        return other_name;
    }

    /**
     * @param other_name the other_name to set
     */
    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }

    /**
     * @return the current_ad_resi
     */
    public String getCurrent_ad_resi() {
        return current_ad_resi;
    }

    /**
     * @param current_ad_resi the current_ad_resi to set
     */
    public void setCurrent_ad_resi(String current_ad_resi) {
        this.current_ad_resi = current_ad_resi;
    }

    /**
     * @return the current_ad_employ
     */
    public String getCurrent_ad_employ() {
        return current_ad_employ;
    }

    /**
     * @param current_ad_employ the current_ad_employ to set
     */
    public void setCurrent_ad_employ(String current_ad_employ) {
        this.current_ad_employ = current_ad_employ;
    }

    public Object clone() {
    Object clone = null;
      
      try {
         clone = super.clone();
         
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      
      return clone;
   }
    
    abstract void role();

}

 class user extends person{   
    public void role(){
        System.out.println("YOUR DATA HAS SUCCESSFULY SAVED !");
        //you can add more functions if need
        //different roles like admin, service supporter (different typrs of people)
    }
}

public class prototypeDemo{

public static void main(String [] args){
    //this demonstrate for 10 users
    personCache pc = new personCache();
    Scanner ss = new Scanner(System.in);
     String service;
   
    for(int i =0;i<10;i++){
        System.out.println("enter (s) to save data or (r)to read data");
        service=ss.next();
        if (service.equals("s")){
      user uu= new user();
      System.out.println("Please enter your family name :");
      Scanner s1 = new Scanner(System.in);
      uu.setName(s1.next());
      System.out.println("Please enter your other names :");
      Scanner s2 = new Scanner(System.in);
      uu.setOther_name(s2.next());
      System.out.println("Please enter your NIC no :");
      Scanner s3 = new Scanner(System.in);
      uu.setNIC(s3.next());
      System.out.println("Please enter your address(residence) :");
      Scanner s4 = new Scanner(System.in);
      uu.setCurrent_ad_resi(s4.next());
      System.out.println("Please enter your address(employment) :");
      Scanner s5 = new Scanner(System.in);
      uu.setCurrent_ad_employ(s5.next());
      pc.putHash(uu);
      uu.role();
        }
        else if (service.equals("r")){
            System.out.println("Enter the NIC no :");
            String nic=ss.next();
            person p=pc.getHash(nic);
            System.out.println("Name :"+p.getName());
            System.out.println("Other names :"+p.getOther_name());
            System.out.println("Address_residential :"+p.getCurrent_ad_resi());
            System.out.println("Address_employment :"+p.getCurrent_ad_employ());
        }
        else{
        System.out.println("Please enter a valid input !!!");
        }
    }
}
}
//data base
class personCache{
   private static Hashtable<String, person> personMap  = new Hashtable<String, person>();
   
   public void putHash(person p){
       personMap.put(p.getNIC(),p);
   }
   
   public person getHash(String NIC){
       person p = personMap.get(NIC);
       return (person)p.clone();
   }
}


