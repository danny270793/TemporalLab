package helloworkflow.actitivies.interfaces;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

/**
 * Action to be executed by temporal workflow.
 */
@ActivityInterface
public interface AskActivity {
    @ActivityMethod
    String ask();
}
