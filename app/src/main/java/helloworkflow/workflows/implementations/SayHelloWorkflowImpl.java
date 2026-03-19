package helloworkflow.workflows.implementations;

import helloworkflow.actitivies.interfaces.GreetActivity;
import helloworkflow.actitivies.interfaces.AskActivity;
import helloworkflow.workflows.interfaces.SayHelloWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import io.temporal.workflow.QueryMethod;

import java.time.Duration;

/**
 * Implementation of the say hello workflow.
 */
public class SayHelloWorkflowImpl implements SayHelloWorkflow {
    private boolean hasObtainedTheName = false;
    private final AskActivity askActivity = Workflow.newActivityStub(
        AskActivity.class,
        ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .build()
    );

    private final GreetActivity greetActivity = Workflow.newActivityStub(
        GreetActivity.class,
        ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .build()
    );

    @Override
    public String sayHello(String name) {
      final String response = askActivity.ask();
      hasObtainedTheName = true;
      return greetActivity.greet(response);
    }

    @Override
    public boolean hasObtainedTheName() {
      return hasObtainedTheName;
    }
}
