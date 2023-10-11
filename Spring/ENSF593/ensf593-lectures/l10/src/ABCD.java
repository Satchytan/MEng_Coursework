
public class ABCD {

	public abstract class A {}
	public class B extends A {}
	public class C extends B {}
	public class D extends A {}
	
	A o5 = new C();


	D o3 = new B();


	C o4 = new D();


	B o2 = new C();


	A o1 = new A();

}
