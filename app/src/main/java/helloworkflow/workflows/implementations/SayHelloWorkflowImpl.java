package helloworkflow.workflows.implementations;

import helloworkflow.actitivies.interfaces.GreetActivity;
import helloworkflow.workflows.interfaces.SayHelloWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

/**
 * Implementation of the say hello workflow.
 */
public class SayHelloWorkflowImpl implements SayHelloWorkflow {
    private final GreetActivity greetActivity = Workflow.newActivityStub(
        GreetActivity.class,
        ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .build()
    );

    @Override
    public String sayHello(String name) {
      return greetActivity.greet(name);
    }
}
