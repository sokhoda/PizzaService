package pizzaservice.states;

/**
 * Created by s_okhoda on 10.10.2016.
 */
public class DoneState extends State {

    public DoneState() {
        name = StateEn.DONE;
    }

    @Override
    public State nextState(OrderStateCycle context) {
        return context.getCurState();
    }

    @Override
    public State previousState(OrderStateCycle context) {
        return setStateAndReturn(context, OrderStateCycle.getInProgressSt());
    }
}
