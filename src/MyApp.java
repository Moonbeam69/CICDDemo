import javax.swing.*;

public class MyApp {

    MyApp() {
        System.out.println("I am a constructor");
    }

    // feature bla
    private void setMeUp(JFrame frame) {
        frame.setVisible(true);
    }


    // TODO fix this now - OK This is fixed now
    public static void main(String[] args) {
        System.out.println("Hello world");

        new MyApp();

        // foo master
    }
}
