public class MyApp {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(MyApp.class);

    MyApp() {

        logger.info("started MyApp");
        System.out.println("CICD_Project-v1.0 was run successfully");
        System.out.println("Eric in: ");
        System.out.println(System.getProperty("environment") + "foo");

        logger.info("existing MyApp");
    }
    public static void main(String[] args) {

        MyApp app = new MyApp();

    }

}
