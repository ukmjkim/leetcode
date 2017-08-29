public class ConsumerClass {
	public void someMethod() {
		ILogger logger = FactoryLogger.createLogger();
		logger.writeLog("This is a log");
	}
}

