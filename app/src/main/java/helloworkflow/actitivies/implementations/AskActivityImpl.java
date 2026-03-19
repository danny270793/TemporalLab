package helloworkflow.actitivies.implementations;

import helloworkflow.actitivies.interfaces.AskActivity;

/**
 * Implementation of the greet activity.
 */
public class AskActivityImpl implements AskActivity {
    @Override
    public String ask() {
      return "Danny";
    }
}
