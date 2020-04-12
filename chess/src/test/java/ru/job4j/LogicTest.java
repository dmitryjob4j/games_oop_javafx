package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 *  * 2. Каркас шахматной доски[#242942]
 *  * @author Dmitry Stepanov [#242692]
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class LogicTest {
    @Test
    public void moveFigureC1toF4freeTrue() {
        Logic logic = new Logic();
        Cell source = Cell.C1;
        Cell dest = Cell.F4;
        Figure figureBishop = new BishopBlack(source);
        logic.add(figureBishop);
        Boolean muve = logic.move(source, dest);
        assertThat(muve, is(true));
    }

    @Test
    public void moveFigureF1toA6PawnE2False() {
        Logic logic = new Logic();
        Cell source = Cell.A6;
        Cell dest = Cell.E2;
        Figure figureBishop = new BishopBlack(source);
        Figure figurePown = new PawnBlack(Cell.E2);
        logic.add(figureBishop);
        logic.add(figurePown);
        Boolean muve = logic.move(source, dest);
        assertThat(muve, is(false));
    }

}
