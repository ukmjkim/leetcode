public class FactoryLogger {
	public static ILogger createLogger() {
		// return new DatabaseLogger();
		// Or
		return new FileSystemLogger();
	}
}
