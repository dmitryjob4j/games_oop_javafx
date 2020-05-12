package job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Крестики-нолики на JavaFX [#242717]
 * тесты
 *
 * @version 3 обьеденение методов isWinner
 * @since 10.05.2020
 */
public class Logic3TTest {

    @Test
    public void whenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }


    @Test
    public void whenNotFill() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)}
        };
        Logic3T logic3T = new Logic3T(table);
        assertThat(logic3T.isWinnerO(), is(false));
        assertThat(logic3T.isWinnerX(), is(false));
        assertThat(logic3T.hasGap(), is(false));

    }

    @Test
    public void whenHasXHorizontalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)}
        };
        Logic3T logic3T = new Logic3T(table);
        assertThat(logic3T.isWinnerX(), is(true));
        assertThat(logic3T.isWinnerO(), is(true));
    }

    @Test
    public void whenHasXVerticalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(), new Figure3T(true), new Figure3T(false)}
        };
        Logic3T logic3T = new Logic3T(table);
        assertThat(logic3T.isWinnerX(), is(true));
        assertThat(logic3T.isWinnerO(), is(true));
    }

    @Test
    public void whenHasXBackDiagonalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T()}
        };
        Logic3T logic3T = new Logic3T(table);
        assertThat(logic3T.isWinnerO(), is(true));
    }

    @Test
    public void whenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(true), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(true)}
        };
        Logic3T logic3T = new Logic3T(table);
        assertThat(logic3T.isWinnerO(), is(true));
    }

    @Test
    public void whenHasGas() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(false), new Figure3T()}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }
}
