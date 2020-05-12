package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Крестики-нолики на JavaFX [#242717]
 *
 * @version 3 обьеденение методов isWinner
 * @since 10.05.2020
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean rsl = true;
        for (int i = 0; i != this.table.length; i++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public boolean isWin(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0) //первая вертикаль
                || this.fillBy(predicate, 0, 1, 1, 0) //втарая вертикаль
                || this.fillBy(predicate, 0, 2, 1, 0)//третья вертикаль
                || this.fillBy(predicate, 0, 0, 0, 1) //первая горизонталь
                || this.fillBy(predicate, 1, 0, 0, 1)//вторая горизонталь
                || this.fillBy(predicate, 2, 0, 0, 1)//третья горизонталь
                || this.fillBy(predicate, 0, 0, 1, 1) //диагональ слева в низ
                || this.fillBy(predicate, 2, 0, -1, 1); //справа на в низ
    }

    public boolean isWinnerX() {
        return this.isWin(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.isWin(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        boolean rsl = Arrays.stream(this.table).flatMap(Arrays::stream)
                .anyMatch(t -> !t.hasMarkO() && !t.hasMarkX());
        return rsl;
    }
}


