package sk.tuke.kpi.oop.game.items;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.oop.game.characters.Ripley;

public class Energy extends AbstractActor implements Usable<Actor> {
    private static final int FULL_ENERGY = 100;

    public Energy() {
        setAnimation(new Animation("sprites/energy.png"));
    }

    @Override
    public void useWith(Actor actor) {
        if (actor instanceof Ripley) {
            Ripley ripley = (Ripley) actor;
            ripley.setEnergy(FULL_ENERGY);
            getScene().removeActor(this);
        }
    }

    @Override
    public Class<Actor> getUsingActorClass() {
        return Actor.class;
    }
}
