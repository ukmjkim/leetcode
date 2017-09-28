public class CallByReference {
	int data = 50;

	public void change(int data) {
		this.data = data + 100;
	}

	public static void main(String[] args) {
		CallByReference call = new CallByReference();

		System.out.println("before change" + call.data);
		call.change(500);
		System.out.println("after change" + call.data);
	}
}
		
