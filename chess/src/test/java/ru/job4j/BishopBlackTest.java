package ru.job4j;

import org.junit.Test;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class BishopBlackTest {
    @Test
    public void positionBishopBlacC1() {
        BishopBlack positionBiBl = new BishopBlack(Cell.C1);
        Cell result = positionBiBl.position();
        Cell expected = Cell.C1;
        assertThat(result, is(expected));
    }

    @Test
    public void copyBishopBlacF1toA6() {
        BishopBlack copy = new BishopBlack(Cell.F1);
        Figure figere = copy.copy(Cell.C6);
        Figure expected = new BishopBlack(Cell.C6);
        assertThat(figere.equals(expected), is(true));
    }

    @Test
    public void wayBishopBlackC1toG5() {
        BishopBlack way = new BishopBlack(Cell.C1);
        Cell[] result = way.way(Cell.C1, Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expected));
    }

    @Test
    public void wayBishopBlackG5toC1() {
        BishopBlack way = new BishopBlack(Cell.G5);
        Cell[] result = way.way(Cell.G5, Cell.C1);
        Cell[] expected = new Cell[]{Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(result, is(expected));
    }

    @Test
    public void wayBishopBlackG1toA7() {
        BishopBlack way = new BishopBlack(Cell.G1);
        Cell[] result = way.way(Cell.G1, Cell.A7);
        Cell[] expected = new Cell[]{Cell.F2, Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7};
        assertThat(result, is(expected));
    }

    @Test
    public void wayBishopBlackA7toG1() {
        BishopBlack way = new BishopBlack(Cell.A7);
        Cell[] result = way.way(Cell.A7, Cell.G1);
        Cell[] expected = new Cell[]{Cell.B6, Cell.C5, Cell.D4, Cell.E3, Cell.F2, Cell.G1};
        assertThat(result, is(expected));
    }

    @Test
    public void isDiagonalA7toG1isTrue() {
        BishopBlack isDiagonal = new BishopBlack(Cell.A7);
        boolean result = isDiagonal.isDiagonal(Cell.A7, Cell.G1);
        assertThat(result, is(true));
    }

    @Test
    public void isDiagonalA7toG2isFalse() {
        BishopBlack isDiagonal = new BishopBlack(Cell.A7);
        boolean result = isDiagonal.isDiagonal(Cell.A7, Cell.G2);
        assertThat(result, is(false));
    }
}
