package helloworkflow.actitivies.implementations;

import helloworkflow.actitivies.interfaces.AskActivity;
import helloworkflow.faker.Faker;
import io.temporal.failure.ApplicationFailure;
import io.temporal.activity.Activity;
import io.temporal.activity.ActivityExecutionContext;
import io.temporal.activity.ActivityInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Implementation of the greet activity.
 */
public class AskActivityImpl implements AskActivity {
    private static final Logger log = LoggerFactory.getLogger(AskActivityImpl.class);

    @Override
    public String ask() {
      final ActivityExecutionContext ctx = Activity.getExecutionContext();
      final ActivityInfo info = ctx.getInfo();

      log.info("namespace=" +  info.getActivityNamespace());
      log.info("workflowId=" + info.getWorkflowId());
      log.info("runId=" + info.getRunId());
      log.info("activityId=" + info.getActivityId());
      log.info("activityTimeout=" + info.getStartToCloseTimeout());

      // if (Faker.chance(0.5)) {
      //   throw ApplicationFailure.newFailure("Failed to ask", RuntimeException.class.getName());
      // }
      
      return "Danny";
    }
}
