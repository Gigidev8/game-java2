package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;

public class Move<T extends Movable> extends AbstractAction<T> {
    private Direction direction;
    private float duration;
    private float elapsedTime;

    public Move(Direction direction, float duration) {
        this.direction = direction;
        this.duration = duration;
    }

    @Override
    public void execute(float deltaTime) {
        T actor = getActor();
        if (actor == null || isDone()) return;

        if (elapsedTime == 0) {
            actor.startedMoving(direction);
        }

        float step = actor.getSpeed() * deltaTime;
        actor.setPosition(
            actor.getPosX() + (int)(step * direction.getDx()),
            actor.getPosY() + (int)(step * direction.getDy())
        );

        elapsedTime += deltaTime;
        if (elapsedTime >= duration) {
            stop();
        }
    }

    @Override
    public void reset() {
        elapsedTime = 0;
        setDone(false);
    }

    public void stop() {
        setDone(true);
        T actor = getActor();
        if (actor != null) {
            actor.stoppedMoving();
        }
    }
}
