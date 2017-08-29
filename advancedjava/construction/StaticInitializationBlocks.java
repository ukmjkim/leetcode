public class StaticInitializationBlocks {
	final int val = 1000;
	final int squareVal;

	StaticInitializationBlocks() {
	}
	{
		this.squareVal = val * val;
	}

	public static void main(String[] args) {
		StaticInitializationBlocks object = new StaticInitializationBlocks();
		System.out.println(object.squareVal);
	}
}
