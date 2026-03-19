package helloworkflow.workflows.implementations;

import helloworkflow.actitivies.interfaces.GreetActivities;
import helloworkflow.workflows.interfaces.SayHelloWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

/**
 * Implementation of the say hello workflow.
 */
public class SayHelloWorkflowImpl implements SayHelloWorkflow {
    private final GreetActivities activities = Workflow.newActivityStub(
        GreetActivities.class,
        ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .build()
    );

    @Override
    public String sayHello(String name) {
      return activities.greet(name);
    }
}
