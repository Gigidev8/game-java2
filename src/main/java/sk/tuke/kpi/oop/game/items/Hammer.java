package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Hammer extends BreakableTool<Reactor> implements Collectible {

    public Hammer(int uses) {
        super(uses);
        setAnimation(new Animation("sprites/hammer.png"));
    }

    public Hammer() {
        this(1);
    }

    @Override
    public void useWith(Reactor reactor) {
        if (reactor != null && reactor.repair()) {
            super.use();
        }
    }

    @Override
    public Class<?> getUsingActorClass() {
        return null;
    }
}

