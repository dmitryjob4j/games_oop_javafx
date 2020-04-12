package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Objects;

/**
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
        for (int i = 1; i <= size; i++) {
            int x = (source.x < dest.x) ? (source.x + i) : (source.x - i);
            int y = (source.y < dest.y) ? (source.y + i) : (source.y - i);
            steps[i - 1] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        if (source.x != dest.x || source.y != dest.y) {
            int size = (source.x < dest.x) ? (dest.x - source.x) : (source.x - dest.x);
            for (int i = 1; i <= size; i++) {
                int x = (source.x < dest.x) ? (source.x + i) : (source.x - i);
                int y = (source.y < dest.y) ? (source.y + i) : (source.y - i);
                if (dest == Cell.findBy(x, y)) {
                    rsl = true;
                }
            }
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BishopBlack that = (BishopBlack) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
