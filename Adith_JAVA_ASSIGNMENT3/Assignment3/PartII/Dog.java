
public class Dog {
        private int age;
        private String owner;
        private String breed;
        
        public Dog()
        { this.age=0;
         this.owner="default";
         this.breed="default";
        	
        }
        
       public Dog(int age,String owner,String breed)
        {
    	   this.age=age;
    	   this.owner=owner;
    	   this.breed=breed;
        	
        }
       
       public static boolean hasSameOwner(Dog d1,Dog d2)
       {
    	   if(d1.owner.equals(d2.owner))
    		   return true;
    	   else
    		   return false;
    	   
       }
       
       public static double avgAge(Dog[] dogs)
       {
    	   
    	   double a=0;
    	   
    	   int i;
    	   
    	   for(i=0;i<dogs.length;i++)
    	   {
    		   a+=dogs[i].age;
    	   }
    	   
    	   return a/dogs.length;
    	   
       }
       
       public int getAge()
       {
    	   return this.age;
       }
       
       public setAge(int age)
       {
    	   this.age=age;
       }
       
       public String getOwner()
       {
    	   return this.owner;
    	   
       }
       
       public setOwner(String owner)
       {
    	   this.owner=owner;
       }
       
       public String getBreed()
       {
    	   return this.breed;
    	   
       }
       
       public setBreed(String breed)
       {
    	   this.breed=breed;
    	   
       }
       
       public String toString()
       {
    	  
    	   
    	   String g=new String();
    	   
    	   g+=this.breed+": Owner:"+this.owner+",Age: "+this.age;
    	   
    	   return g;
       }
        
        public static void main(String[] args) {
                
                Dog[] dogs = new Dog[5];
                dogs[0] = new Dog(4, "Stephen Colbert", "Boxer");
                
                dogs[1] = new Dog(8, "Dexter Morgan", "Corgi");
                dogs[2] = new Dog(7, "John", "Poodle");
                
                dogs[3] = new Dog(6, "Jordan", "Golden Retriever");
                dogs[4] = new Dog(5, "Tommy", "German shepherd");
                System.out.println(dogs[0].hasSameOwner(dogs[0], dogs[1]));
                
                System.out.println(dogs[1]);
                
                double a=dogs[0].avgAge(dogs);
                System.out.println(a);
                String s=dogs[4].toString();
                System.out.println(s);
        }
}