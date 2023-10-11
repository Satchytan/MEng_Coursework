public class Total {
  
    private int total;
    
    public Total(){
      this.total = 0;
    }
    
    public int getTotal(){
      return this.total;
    }
    
    public static void add(Total t, int amount){
      t.total += amount;
    }
    
    public void subtract(int amount){
      this.total -= amount;
    }
  
    public static void main(String[] args) {
      
      Total t1 = new Total();
      Total t2 = new Total();
      
      Total.add(t1, 10);
      Total.add(t2, 20);
      
      System.out.println(t1.getTotal());
      System.out.println(t2.getTotal());
      
      
    }
}

