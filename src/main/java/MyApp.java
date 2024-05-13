public class MyApp {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(MyApp.class);

    MyApp() {

        logger.info("started MyApp");
        logger.info("CICD_Project-v1.0 was run successfully");
        logger.info("Eric in: ");
        logger.info(System.getProperty("environment") + "foo");

        logger.info("existing MyApp");
    }
    public static void main(String[] args) {

        new MyApp();

    }

}
