abstract class CrossCompiler {
	public final void crossCompile() {
		collectSource();
		compileToTarget();
	}

	// Template methods
	protected abstract void collectSource();

	protected abstract void compileToTarget();
}

class IPhoneCompiler extends CrossCompiler {
	@Override
	protected void collectSource() {
		System.out.println("IPhoneCompiler Collecting Source");
	}

	@Override
	protected void compileToTarget() {
		System.out.println("IPhoneCompiler Compiling Source");
	}
}

class AndroidCompiler extends CrossCompiler {
	@Override
	protected void collectSource() {
		System.out.println("AndroidCompiler Collecting Source");
	}

	@Override
	protected void compileToTarget() {
		System.out.println("AndroidCompiler Compiling Source");
	}
}

public class TemplateDemo {
	public static void main(String[] args) {
		CrossCompiler iphone = new IPhoneCompiler();
		iphone.crossCompile();
		CrossCompiler android = new AndroidCompiler();
		android.crossCompile();
	}
}
