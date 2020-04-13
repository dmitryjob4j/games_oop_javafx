package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Objects;

/**
 * 2. Каркас шахматной доски[#242942]
 *
 * @author Dmitry Stepanov [#242692]
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = (source.x < dest.x) ? dest.x - source.x : source.x - dest.x;
        Cell[] steps = new Cell[size];
        int deltaX = (source.x < dest.x) ? 1 : -1;
        int deltaY = (source.y < dest.y) ? 1 : -1;
        for (int i = 0; i < size; i++) {
            int x = Math.abs((i + 1) + source.x * deltaX);
            int y = Math.abs((i + 1) + source.y * deltaY);
            steps[i] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        rsl = Math.abs(dest.x - source.x) - Math.abs(dest.y - source.y) == 0 ? true : false;
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BishopBlack that = (BishopBlack) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
