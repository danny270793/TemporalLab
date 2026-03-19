package helloworkflow;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.serviceclient.WorkflowServiceStubs;
import helloworkflow.workflows.interfaces.SayHelloWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter {
    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) throws Exception {
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);

        SayHelloWorkflow workflow = client.newWorkflowStub(
            SayHelloWorkflow.class,
            WorkflowOptions.newBuilder()
                .setTaskQueue("my-task-queue")
                .setWorkflowId("say-hello-workflow-id")
                .build()
        );

        logger.info("Starting workflow");
        WorkflowClient.start(workflow::sayHello, "Temporal");

        Thread signalThread = new Thread(() -> {
            try {
                Thread.sleep(10_000);
                logger.info("Sending setLanguage signal");
                workflow.setLanguage("English");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
        signalThread.start();

        String result = WorkflowStub.fromTyped(workflow).getResult(String.class);
        logger.info("Workflow result: {}", result);
    }
}
