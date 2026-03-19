package helloworkflow.workers;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

import helloworkflow.workflows.implementations.SayHelloWorkflowImpl;
import helloworkflow.actitivies.implementations.GreetActivityImpl;
import helloworkflow.actitivies.implementations.AskActivityImpl;

/**
 * Worker to execute the say hello workflow.
 */
public class SayHelloWorker {
    public static void main(String[] args) {
      WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
      WorkflowClient client = WorkflowClient.newInstance(service);
      WorkerFactory factory = WorkerFactory.newInstance(client);

      Worker worker = factory.newWorker("my-task-queue");
      worker.registerWorkflowImplementationTypes(SayHelloWorkflowImpl.class);
      worker.registerActivitiesImplementations(new GreetActivityImpl());
      worker.registerActivitiesImplementations(new AskActivityImpl());

      System.out.println("Starting SayHelloWorker for task queue 'my-task-queue'...");

      factory.start();
    }
}
