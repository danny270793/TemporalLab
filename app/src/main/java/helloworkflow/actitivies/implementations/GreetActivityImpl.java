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
    public String greet(String language, String name) {
      final ActivityExecutionContext ctx = Activity.getExecutionContext();
      final ActivityInfo info = ctx.getInfo();

      log.info("namespace=" +  info.getActivityNamespace());
      log.info("workflowId=" + info.getWorkflowId());
      log.info("runId=" + info.getRunId());
      log.info("activityId=" + info.getActivityId());
      log.info("activityTimeout=" + info.getStartToCloseTimeout());

      // if (Faker.chance(0.5)) {
      //   throw ApplicationFailure.newFailure("Failed to greet", RuntimeException.class.getName());
      // }

      if("Spanish".equals(language)) {
        return "Hola " + name;
      } else if("French".equals(language)) {
        return "Bonjour " + name;
      } else if("German".equals(language)) {
        return "Hallo " + name;
      } else if("Italian".equals(language)) {
        return "Ciao " + name;
      } else if("Portuguese".equals(language)) {
        return "Olá " + name;
      } else if("Russian".equals(language)) {
        return "Привет " + name;
      } else if("English".equals(language)) {
        return "Hello " + name;
      } else {
        return "xxxxxx " + name;
      }
    }
}
