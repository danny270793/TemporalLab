package helloworkflow.actitivies.implementations;

import helloworkflow.actitivies.interfaces.GreetActivity;
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
public class GreetActivityImpl implements GreetActivity {
    private static final Logger log = LoggerFactory.getLogger(GreetActivityImpl.class);

    @Override
    public String greet(String name) {
      final ActivityExecutionContext ctx = Activity.getExecutionContext();
      final ActivityInfo info = ctx.getInfo();

      log.info("namespace=" +  info.getActivityNamespace());
      log.info("workflowId=" + info.getWorkflowId());
      log.info("runId=" + info.getRunId());
      log.info("activityId=" + info.getActivityId());
      log.info("activityTimeout=" + info.getStartToCloseTimeout());

      if (Faker.chance(0.75)) {
        throw ApplicationFailure.newFailure("Failed to greet", RuntimeException.class.getName());
      }

      return "Hello " + name;
    }
}
