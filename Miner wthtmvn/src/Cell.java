import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JButton {
    public boolean isABomb = false;
    public static boolean loose = false;
    public static boolean win = false;
    public static boolean isAFirstTap = true;
    public int countBombsAround = 0;
    public int number = 0;
    public int x;
    public int y;
    public static boolean isOpened = false;
    public boolean clicked = false;

    public static Color color = new Color(255,156,237);
    public static Color colorCliced = new Color(237,150,220);
    public static Color colorWin = Color.ORANGE;
    public static Color colorLoose = new Color(219,79,79);
    public static Color colorRC = new Color(224,38,122);
    public static Color colorDRC = new Color(237,50,206);
    public static Color colorTRC = color;

    public ImageIcon icon0 = new ImageIcon(Main.class.getResource("image0.png"));
    public ImageIcon icon1 = new ImageIcon(Main.class.getResource("image1.png"));

    public Cell(){
        setBorder(BorderFactory.createBevelBorder(0));
        setBackground(color);
        ActionImpl action = new ActionImpl();
        addActionListener(action);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3){
                    switch (number){
                        case 0: setBackground(colorRC); number = 1; break;
                        case 1: setBackground(colorDRC); number = 2; break;
                        case 2: setBackground(colorTRC); number = 0; break;
                    }

                }
            }
        });
    }
    public void setCoordinate(int i, int j){
        x = i;
        y = j;
    }

    public void setCellImage(){
        if (isABomb) {
            if (MyWindow.theme == 0){setIcon(icon0);} else {setIcon(icon1);}
        } else if (countBombsAround>0){setText(Integer.toString(countBombsAround));}
    }
    public class ActionImpl implements ActionListener {
        public void actionPerformed(ActionEvent e){
            clicked = true;
            if (!isOpened){
                if (isAFirstTap){MyWindow.spawnBombs(x,y); isAFirstTap = false;}
            if (number == 0 && !loose && !win){
                MyWindow.lost--;
                setBackground(colorCliced);
                setBorder(BorderFactory.createBevelBorder(1));
                if (countBombsAround == 0){MyWindow.openAround(x,y);}
                setCellImage();
                number = 3;
            if (MyWindow.lost == 0){win = true;}
                if (win){
                    for(int i = 0; i < MyWindow.countOfStrings; i++){
                        for (int j = 0; j < MyWindow.countOfColoumns; j++){
                            MyWindow.cells[i][j].setCellImage();
                            MyWindow.cells[i][j].setBackground(colorWin);
                            colorTRC = colorWin;
                        }
                    }
                }
            if(isABomb){
            loose = true;}
            }
            if (loose){
                for(int i = 0; i < MyWindow.countOfStrings; i++){
                    for (int j = 0; j < MyWindow.countOfColoumns; j++){
                        MyWindow.cells[i][j].setCellImage();
                        MyWindow.cells[i][j].setBackground(colorLoose);
                        colorTRC = colorLoose;
                    }
                }
            }
            }
        }
    }

}
