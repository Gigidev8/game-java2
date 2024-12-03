package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.items.Usable;

public class Use<A extends Actor> extends AbstractAction<A> {
    private final Usable<? super A> usableActor;

    public Use(Usable<? super A> usableActor) {
        this.usableActor = usableActor;
    }

    @Override
    public void execute(float deltaTime) {
        A actor = getActor();

        if (actor != null && usableActor != null) {
            usableActor.useWith(actor);
        }

        setDone(true);
    }
}
