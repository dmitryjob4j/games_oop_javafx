package job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * Крестики-нолики на JavaFX [#242717]
 * модель данныйх Figure3T
 *
 * @since 10.05.2020
 */
public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    public Figure3T() {
    }

    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public boolean hasMarkX() {
        return this.markX;
    }

    public boolean hasMarkO() {
        return this.markO;
    }
}
