package helloworkflow.actitivies.implementations;

import helloworkflow.actitivies.interfaces.GreetActivities;

/**
 * Implementation of the greet activity.
 */
public class GreetActivitiesImpl implements GreetActivities {
    @Override
    public String greet(String name) {
      return "Hello " + name;
    }
}
