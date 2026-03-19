package helloworkflow.actitivies.implementations;

import helloworkflow.actitivies.interfaces.GreetActivity;

/**
 * Implementation of the greet activity.
 */
public class GreetActivityImpl implements GreetActivity {
    @Override
    public String greet(String name) {
      return "Hello " + name;
    }
}
