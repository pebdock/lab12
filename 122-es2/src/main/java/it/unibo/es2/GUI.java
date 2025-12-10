package it.unibo.es2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The GUI class representing the graphical user interface of the application.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> buttons = new ArrayList<>();
    private final transient Logics logics;

    /**
     * Constructs a GUI with the specified size.
     *
     * @param size the size of the grid
     */
    public GUI(final int size) {
        this.logics = new LogicsImpl(size);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * size, 100 * size);
        // Layout
        final var panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(BorderLayout.CENTER, panel);
        // Buttons
        IntStream.range(0, size * size).forEach(i -> {
            final JButton jb = new JButton(Logics.EMPTY);
            this.buttons.add(jb);
            jb.addActionListener(e -> {
                jb.setText(logics.hit(i));

                if (logics.toQuit()) {
                    this.dispose();
                }
            });
            panel.add(jb);
        });
        this.setVisible(true);
    }
}
