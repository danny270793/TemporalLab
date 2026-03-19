package helloworkflow.workflows.interfaces;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

/**
 * Workflow to orchestrate the activities.
 */
@WorkflowInterface
public interface SayHelloWorkflow {
    @WorkflowMethod
    String sayHello(String name);
}
