package helloworkflow.workflows.interfaces;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.SignalMethod;

/**
 * Workflow to orchestrate the activities.
 */
@WorkflowInterface
public interface SayHelloWorkflow {
    @WorkflowMethod
    String sayHello(String name);

    @SignalMethod
    void setLanguage(String language);

    @QueryMethod
    boolean hasObtainedTheName();
}
