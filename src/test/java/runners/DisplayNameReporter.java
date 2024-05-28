package runners;

import org.junit.jupiter.api.extension.*;

public class DisplayNameReporter implements TestWatcher {

  @Override
  public void testSuccessful(ExtensionContext context) {
    logDisplayName(context);
  }

  @Override
  public void testFailed(ExtensionContext context, Throwable cause) {
    logDisplayName(context);
  }

  private void logDisplayName(ExtensionContext context) {
    String displayName = context.getDisplayName();
    System.out.println("DisplayName: " + displayName); // This will appear in the Surefire console output
  }
}
