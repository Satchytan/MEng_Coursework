
public class Test {
	
	int a;
	Test(int i) { 
		a = i;
	}

	public static void main(String[] args) {
		Test t1 = new Test(1);
		Test t2 = new Test(2);
		System.out.println(t1.a+" - "+t2.a);
		
		t1.swap(t2);
		System.out.println(t1.a+" - "+t2.a);
		
		Test.swap(t1, t2);
		System.out.println(t1.a+" - "+t2.a);
		
		Test t3 = t1.swapPure(t2);
		System.out.println(t1.a+" - "+t2.a+" - "+t3.a);

	}
	
	void swap(Test that) {
		int temp = this.a;
		this.a = that.a;
		that.a = temp;
		
	}
	
	public static void swap(Test t1, Test t2) {
		int temp = t1.a;
		t1.a = t2.a;
		t2.a = temp;
	}
	
	//pure method: does not change arguments
	Test swapPure(Test that) {
		Test t = new Test(this.a);
		this.a = that.a;
		return t;
	}

}
