import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame{
    public JPanel myPanel = new JPanel();
    public JLabel label = new JLabel("     Сапер");
    public JLabel label1 = new JLabel("Количество строк");
    public JLabel label2= new JLabel("Количество столбцов");
    public JLabel label3 = new JLabel("Количество бомб");
    public static int countOfStrings = 3;
    public static int countOfColoumns = 3;
    public static int countOfBombs = 1;
    public JLabel label4 = new JLabel(Integer.toString(countOfStrings));
    public JLabel label5= new JLabel(Integer.toString(countOfColoumns));
    public JLabel label6 = new JLabel(Integer.toString(countOfBombs));
    public JButton[] buttons = new JButton[7];
    public JButton button1 = new JButton("В меню");
    public JButton button2 = new JButton("Заново");
    public JButton button3 = new JButton("Переставить");
    public JButton button4 = new JButton("Открыть все");
    public JRadioButton button5 = new JRadioButton("1",true);
    public JRadioButton button6 = new JRadioButton("2",false);
    public ButtonGroup group = new ButtonGroup();
    public Font font = new Font("Verdana",Font.PLAIN,80);
    public Font font1 = new Font("",Font.PLAIN,25);
    public static Cell[][] cells;
    public int cellsSize = 0;
    public int min = 0;
    public static int lost = 0;
    public static int theme = 0;
    public static Icon icon;
    public static ImageIcon maneIcon = new ImageIcon(MyWindow.class.getResource("image2.png"));
    public static Image image = maneIcon.getImage();
    public MyWindow(){
        setIconImage(image);

        setSize(600,700);
        setResizable(false);
        setLocation(400,30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        group.add(button5);
        group.add(button6);

        setStartPane();


        myPanel.setSize(600,700);
        myPanel.setLocation(0,0);
        myPanel.setLayout(null);
        myPanel.setBackground(new Color(237,162,200));

        add(myPanel);
    }

    public void setStartPane(){
        label.setBounds(40,40,540,100);
        label.setFont(font);
        label.setForeground(new Color(242,70,185));

        label1.setBounds(110,230,400,40);
        label1.setFont(font1);
        label2.setBounds(110,350,400,40);
        label2.setFont(font1);
        label3.setBounds(110,470,400,40);
        label3.setFont(font1);

        label4.setBounds(410,230,50,40);
        label4.setFont(font1);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label5.setBounds(410,350,50,40);
        label5.setFont(font1);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label6.setBounds(410,470,50,40);
        label6.setFont(font1);
        label6.setHorizontalAlignment(JLabel.CENTER);

        for(int i = 0; i < 7; i++){
            buttons[i] = new JButton();
            buttons[i].setBackground(new Color(255,156,237));
            buttons[i].setBorder(BorderFactory.createBevelBorder(0));
        }

        buttons[0].setBounds(410,200,50,30);
        buttons[0].setText("⬆");
        ActionImpl0 action0 = new ActionImpl0();
        buttons[0].addActionListener(action0);

        buttons[1].setBounds(410,270,50,30);
        buttons[1].setText("⬇");
        ActionImpl1 action1 = new ActionImpl1();
        buttons[1].addActionListener(action1);

        buttons[2].setBounds(410,320,50,30);
        buttons[2].setText("⬆");
        ActionImpl2 action2 = new ActionImpl2();
        buttons[2].addActionListener(action2);

        buttons[3].setBounds(410,390,50,30);
        buttons[3].setText("⬇");
        ActionImpl3 action3 = new ActionImpl3();
        buttons[3].addActionListener(action3);

        buttons[4].setBounds(410,440,50,30);
        buttons[4].setText("⬆");
        ActionImpl4 action4 = new ActionImpl4();
        buttons[4].addActionListener(action4);

        buttons[5].setBounds(410,510,50,30);
        buttons[5].setText("⬇");
        ActionImpl5 action5 = new ActionImpl5();
        buttons[5].addActionListener(action5);

        buttons[6].setBounds(200,570,200,60);
        buttons[6].setText("Старт");
        ActionImpl6 action6 = new ActionImpl6();
        buttons[6].addActionListener(action6);

        button1.setBounds(3,0,143,40);
        button1.setVisible(false);
        ActionImpl7 action7 = new ActionImpl7();
        button1.addActionListener(action7);
        button1.setBackground(new Color(242,70,245));
        button1.setBorder(BorderFactory.createBevelBorder(0));

        button2.setBounds(148,0,143,40);
        button2.setVisible(false);
        ActionImpl8 action8 = new ActionImpl8();
        button2.addActionListener(action8);
        button2.setBackground(new Color(242,70,245));
        button2.setBorder(BorderFactory.createBevelBorder(0));

        button3.setBounds(293,0,143,40);
        button3.setVisible(false);
        ActionImpl10 action10 = new ActionImpl10();
        button3.addActionListener(action10);
        button3.setBackground(new Color(242,70,245));
        button3.setBorder(BorderFactory.createBevelBorder(0));

        button4.setBounds(438,0,143,40);
        button4.setVisible(false);
        ActionImpl9 action9 = new ActionImpl9();
        button4.addActionListener(action9);
        button4.setBackground(new Color(242,70,245));
        button4.setBorder(BorderFactory.createBevelBorder(0));

        button5.setBounds(30,570,50,60);
        ActionImpl11 action11 = new ActionImpl11();
        button5.addActionListener(action11);
        button5.setBackground(new Color(237,162,200));

        button6.setBounds(80,570,50,60);
        ActionImpl12 action12 = new ActionImpl12();
        button6.addActionListener(action12);
        button6.setBackground(new Color(237,162,200));

        for(int i = 0; i < 7; i++){
            buttons[i].setFont(font1);
            myPanel.add(buttons[i]);
        }
        myPanel.add(label);
        myPanel.add(label1);
        myPanel.add(label2);
        myPanel.add(label3);
        myPanel.add(label4);
        myPanel.add(label5);
        myPanel.add(label6);
        myPanel.add(button1);
        myPanel.add(button2);
        myPanel.add(button3);
        myPanel.add(button4);
        myPanel.add(button5);
        myPanel.add(button6);
        myPanel.setVisible(true);
    }
    public static int random(int a){
        int st = (int) (Math.random() * (a));
        return st;
    }

    public static void openAround(int x, int y){
        try {if (cells[x - 1][y - 1].clicked == false)cells[x - 1][y - 1].doClick(0);} catch (Exception e1){}
        try {if (cells[x - 1][y].clicked == false)cells[x - 1][y].doClick(0);} catch (Exception e1){}
        try {if (cells[x - 1][y + 1].clicked == false)cells[x - 1][y + 1].doClick(0);} catch (Exception e1){}
        try {if (cells[x][y - 1].clicked == false)cells[x][y - 1].doClick(0);} catch (Exception e1){}
        try {if (cells[x][y + 1].clicked == false)cells[x][y + 1].doClick(0);} catch (Exception e1){}
        try {if (cells[x + 1][y - 1].clicked == false)cells[x + 1][y - 1].doClick(0);} catch (Exception e1){}
        try {if (cells[x + 1][y].clicked == false)cells[x + 1][y].doClick(0);} catch (Exception e1){}
        try {if (cells[x + 1][y + 1].clicked == false)cells[x + 1][y + 1].doClick(0);} catch (Exception e1){}
    }


    public static void spawnBombs(int x, int y){

        int ind = 0;
        while (ind < countOfBombs){
            int st = random(countOfStrings);
            int co = random(countOfColoumns);

            if (((st !=0) || (co != 0)) && ((st !=0) || (co !=countOfColoumns-1)) && ((st !=countOfStrings-1) || (co != 0)) && ((co !=countOfColoumns-1) || (st !=countOfStrings-1)) && ((st != x) || (co != y)) && (!cells[st][co].isABomb)){
                cells[st][co].isABomb = true;
                ind++;
            }
        }

        for(int i = 0; i < countOfStrings; i++){
            for (int j = 0; j < countOfColoumns; j++){
                if(cells[i][j].isABomb){
                    try { cells[i - 1][j - 1].countBombsAround++;} catch (Exception e1){}
                    try {cells[i - 1][j].countBombsAround++;} catch (Exception e1){}
                    try {cells[i - 1][j + 1].countBombsAround++;} catch (Exception e1){}
                    try {cells[i][j - 1].countBombsAround++;} catch (Exception e1){}
                    try{cells[i][j + 1].countBombsAround++;} catch (Exception e1){}
                    try{cells[i + 1][j - 1].countBombsAround++;} catch (Exception e1){}
                    try{cells[i + 1][j].countBombsAround++;} catch (Exception e1){}
                    try{cells[i + 1][j + 1].countBombsAround++;} catch (Exception e1){}
                }
            }
        }
    }

    public class ActionImpl0 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (countOfStrings < 12) {countOfStrings++;}
            label4.setText(Integer.toString(countOfStrings));
        }
    }

    public class ActionImpl1 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(countOfStrings>3){countOfStrings--;}
            if (countOfBombs > (countOfColoumns*countOfStrings - 5)) {countOfBombs = countOfColoumns*countOfStrings - 5;
            label6.setText(Integer.toString(countOfBombs));}
            label4.setText(Integer.toString(countOfStrings));
        }
    }

    public class ActionImpl2 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (countOfColoumns < 12) {countOfColoumns++;}
            label5.setText(Integer.toString(countOfColoumns));
        }
    }

    public class ActionImpl3 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (countOfColoumns>3){countOfColoumns--;}
            if (countOfBombs > (countOfColoumns*countOfStrings - 5)) {countOfBombs = countOfColoumns*countOfStrings - 5;
            label6.setText(Integer.toString(countOfBombs));}
            label5.setText(Integer.toString(countOfColoumns));
        }
    }

    public class ActionImpl4 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (countOfBombs < (countOfColoumns*countOfStrings - 5)) {countOfBombs++;}
            label6.setText(Integer.toString(countOfBombs));
        }
    }

    public class ActionImpl5 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (countOfBombs>1){countOfBombs--;}
            label6.setText(Integer.toString(countOfBombs));
        }
    }

    public class ActionImpl6 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Cell.loose = false;
            Cell.win = false;
            Cell.isOpened = false;
            Cell.isAFirstTap = true;
            Cell.colorTRC = Cell.color;

            cells = new Cell[countOfStrings][countOfColoumns];
            for(int i = 0; i < countOfStrings; i++){
                for (int j = 0; j < countOfColoumns; j++){
                    cells[i][j] = new Cell();
                    cells[i][j].number = 0;
                    cells[i][j].clicked = false;
                    cells[i][j].setBackground(Cell.color);
                    cells[i][j].setBorder(BorderFactory.createBevelBorder(0));
                    cells[i][j].setCoordinate(i,j);
                    cells[i][j].setIcon(icon);
                }
            }

            int x = 34;
            int y = 100;

            if(countOfColoumns > countOfStrings){
                cellsSize = 520/countOfColoumns;
                min = (700 -cellsSize*countOfStrings)/2;
                y =+ min;
            } else if (countOfColoumns < countOfStrings){
                cellsSize = 520/countOfStrings;
                min = (584 - cellsSize*countOfColoumns)/2;
                x =+ min;
            } else cellsSize = 520/countOfColoumns;

            int qx = x;

            for(int i = 0; i < countOfStrings; i++){
                for (int j = 0; j < countOfColoumns; j++){
                    cells[i][j].setVisible(false);
                    cells[i][j].setBounds(x,y,cellsSize,cellsSize);
                    x = x + cellsSize;
                }
                x = qx;
                y = y + cellsSize;
            }

            for(int i = 0; i < countOfStrings; i++){
                for (int j = 0; j < countOfColoumns; j++){
                    myPanel.add(cells[i][j]);
                }
            }

            lost = countOfColoumns*countOfStrings - countOfBombs;

            label.setVisible(false);
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);

            for(int i = 0; i < 7; i++){
                buttons[i].setVisible(false);
            }

            button1.setVisible(true);
            button2.setVisible(true);
            button3.setVisible(true);
            button4.setVisible(true);

            button5.setVisible(false);
            button6.setVisible(false);

            for(int i = 0; i < countOfStrings; i++){
                for (int j = 0; j < countOfColoumns; j++){
                    cells[i][j].setVisible(true);
                }
            }
        }
    }

    public class ActionImpl7 implements ActionListener {
        public void actionPerformed(ActionEvent e){

            for(int i = 0; i < countOfStrings; i++){
                for (int j = 0; j < countOfColoumns; j++){
                    cells[i][j].setVisible(false);
                }
            }

            label.setVisible(true);
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);

            for(int i = 0; i < 7; i++){
                buttons[i].setVisible(true);
            }

            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);

            button5.setVisible(true);
            button6.setVisible(true);
        }
    }

    public class ActionImpl8 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Cell.loose = false;
            Cell.win = false;
            Cell.isOpened = false;
            Cell.colorTRC = Cell.color;
            lost = countOfColoumns*countOfStrings - countOfBombs;

            for(int i = 0; i < countOfStrings; i++){
                for (int j = 0; j < countOfColoumns; j++){
                    cells[i][j].setBackground(Cell.color);
                    cells[i][j].setText("");
                    cells[i][j].number = 0;
                    cells[i][j].clicked = false;
                    cells[i][j].setBorder(BorderFactory.createBevelBorder(0));
                    cells[i][j].setIcon(icon);
                }
            }
        }
    }

    public class ActionImpl9 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Cell.isOpened = true;
            for(int i = 0; i < countOfStrings; i++){
                for (int j = 0; j < countOfColoumns; j++){
                    cells[i][j].setCellImage();
                }
            }
        }
    }

    public class ActionImpl10 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Cell.loose = false;
            Cell.win = false;
            Cell.isOpened = false;
            Cell.isAFirstTap = true;
            Cell.colorTRC = Cell.color;
            lost = countOfColoumns*countOfStrings - countOfBombs;

            for(int i = 0; i < countOfStrings; i++){
                for (int j = 0; j < countOfColoumns; j++){
                    cells[i][j].setBackground(Cell.color);
                    cells[i][j].setText("");
                    cells[i][j].isABomb = false;
                    cells[i][j].number = 0;
                    cells[i][j].countBombsAround = 0;
                    cells[i][j].clicked = false;
                    cells[i][j].setBorder(BorderFactory.createBevelBorder(0));
                    cells[i][j].setIcon(icon);
                }
            }
        }
    }

    public class ActionImpl11 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            theme = 0;
            label.setForeground(new Color(242,70,185));

            for(int i = 0; i < 7; i++){
                buttons[i].setBackground(new Color(255,156,237));
            }

            button1.setBackground(new Color(242,70,245));
            button2.setBackground(new Color(242,70,245));
            button3.setBackground(new Color(242,70,245));
            button4.setBackground(new Color(242,70,245));
            button5.setBackground(new Color(237,162,200));
            button6.setBackground(new Color(237,162,200));

            Cell.color = new Color(255,156,237);
            Cell.colorCliced = new Color(237,150,220);
            Cell.colorRC = new Color(224,38,122);
            Cell.colorDRC = new Color(237,50,206);

            myPanel.setBackground(new Color(237,162,200));
        }
    }

    public class ActionImpl12 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            theme = 1;
            label.setForeground(new Color(51,129,14));

            for(int i = 0; i < 7; i++){
                buttons[i].setBackground(new Color(22,170,25));
            }

            button1.setBackground(new Color(51,129,14));
            button2.setBackground(new Color(51,129,14));
            button3.setBackground(new Color(51,129,14));
            button4.setBackground(new Color(51,129,14));
            button5.setBackground(new Color(173,235,165));
            button6.setBackground(new Color(173,235,165));

            Cell.color = new Color(22,170,25);
            Cell.colorCliced = new Color(32,207,57);
            Cell.colorRC = new Color(50,89,11);
            Cell.colorDRC = new Color(77,122,46);

            myPanel.setBackground(new Color(173,235,165));
        }
    }
}
