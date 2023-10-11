interface Series{
	public int getNext();
	public void reset();
	public void setStart(int start);
}


class ByTwos implements Series{
	int start, val;
	
	@Override
	public int getNext() {
		int current = val;
		val += 2;
		return current;
	}

	@Override
	public void reset() {
		val = start;
	}

	@Override
	public void setStart(int start) {
		this.start = this.val = start;
//		this.start = start;
//		this.val = start;
	}
	
}

public class InterfaceExample {

	public static void main(String[] args) {
		ByTwos b = new ByTwos();
		b.setStart(10);
		System.out.println(b.getNext());
		System.out.println(b.getNext());
		b.reset();
		System.out.println(b.getNext());
		
	}

}
