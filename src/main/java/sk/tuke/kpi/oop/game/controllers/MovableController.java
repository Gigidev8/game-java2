package sk.tuke.kpi.oop.game.controllers;

import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class MovableController implements KeyboardListener {
    private Movable actor;
    private Move<Movable> currentMoveAction;
    private Set<Input.Key> pressedKeys;

    private Map<Input.Key, Direction> keyDirectionMap = Map.ofEntries(
        Map.entry(Input.Key.UP, Direction.NORTH),
        Map.entry(Input.Key.DOWN, Direction.SOUTH),
        Map.entry(Input.Key.RIGHT, Direction.WEST),
        Map.entry(Input.Key.LEFT, Direction.EAST)
    );

    public MovableController(Movable actor) {
        this.actor = actor;
        this.pressedKeys = new HashSet<>();
    }

    @Override
    public void keyPressed(Input.Key key) {
        pressedKeys.add(key);
        updateMovement();
    }

    @Override
    public void keyReleased(Input.Key key) {
        pressedKeys.remove(key);
        updateMovement();
    }

    private void updateMovement() {
        if (currentMoveAction != null) currentMoveAction.stop();

        Direction direction = getDirectionFromPressedKeys();
        if (direction != null) {
            currentMoveAction = new Move<>(direction, Float.MAX_VALUE);
            currentMoveAction.scheduleFor(actor);
        }
    }

    private Direction getDirectionFromPressedKeys() {
        boolean up = pressedKeys.contains(Input.Key.UP);
        boolean down = pressedKeys.contains(Input.Key.DOWN);
        boolean left = pressedKeys.contains(Input.Key.LEFT);
        boolean right = pressedKeys.contains(Input.Key.RIGHT);

        if (up && left) return Direction.NORTH_EAST;
        if (up && right) return Direction.NORTH_WEST;
        if (down && left) return Direction.SOUTH_EAST;
        if (down && right) return Direction.SOUTH_WEST;

        if (up) return Direction.NORTH;
        if (down) return Direction.SOUTH;
        if (right) return Direction.WEST;
        if (left) return Direction.EAST;

        return null;
    }
}
