package geekbrains.java_1.noughts_and_crosses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameWindow extends JFrame {

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int POS_X = 800;
    private static final int POS_Y = 300;
    private static final int PANEL_BOTTOM_ROWS = 1;
    private static final int PANEL_BOTTOM_COLS = 2;

    private final StartNewGameWindow start_new_game_window;
    private final Map map;

    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Крестики-нолики");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(POS_X, POS_Y);
        setResizable(false);
        start_new_game_window = new StartNewGameWindow(this);
        JButton btn_new_game = new JButton("Новая игра");
        btn_new_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start_new_game_window.setVisible(true);
            }
        });
        JButton btn_exit = new JButton("Выход");
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel panel_bottom = new JPanel();
        panel_bottom.setLayout(new GridLayout(PANEL_BOTTOM_ROWS, PANEL_BOTTOM_COLS));
        panel_bottom.add(btn_new_game);
        panel_bottom.add(btn_exit);
        map = new Map();
        add(map, BorderLayout.CENTER);
        add(panel_bottom, BorderLayout.SOUTH);
        setVisible(true);
        start_new_game_window.setVisible(true);
    }

    void startNewGame(int mode, int field_size_x, int field_size_y, int win_len){
        map.startNewGame(mode, field_size_x, field_size_y, win_len);
    }
}
