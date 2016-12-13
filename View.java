import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JOptionPane;


public class View extends javax.swing.JFrame {
    public View() {
        initComponents();
    }

    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameTable = new javax.swing.JTable();
        historyPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        scorePanel = new javax.swing.JPanel();
        blackLogoLabel = new javax.swing.JLabel();
        whiteLogoLabel = new javax.swing.JLabel();
        nextPlayerLabel = new javax.swing.JLabel();
        blackScoreLabel = new javax.swing.JLabel();
        whiteScoreLabel = new javax.swing.JLabel();
        logoPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        historyTableModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Player", "Position"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        moveCount = 0;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Othello");
        setResizable(false);

        gamePanel.setBackground(new java.awt.Color(200, 195, 184));
        gamePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gamePanel.setAutoscrolls(true);
        gamePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gamePanel.setPreferredSize(new java.awt.Dimension(420, 420));

        gameTable.setBackground(new java.awt.Color(236, 240, 226));
        gameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null},
                {"8", "", null, null, null, null, null, null, null}
            },
            new String [] {
                "", "A", "B", "C", "D", "E", "F", "G", "H"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gameTable.setGridColor(new java.awt.Color(92, 90, 90));
        gameTable.setRowHeight(50);
        gameTable.getTableHeader().setResizingAllowed(false);
        gameTable.getTableHeader().setReorderingAllowed(false);
        gameTable.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(gameTable);
        gameTable.getColumnModel().getColumn(0).setResizable(false);
        gameTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        gameTable.getColumnModel().getColumn(1).setResizable(false);
        gameTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        gameTable.getColumnModel().getColumn(2).setResizable(false);
        gameTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        gameTable.getColumnModel().getColumn(3).setResizable(false);
        gameTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        gameTable.getColumnModel().getColumn(4).setResizable(false);
        gameTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        gameTable.getColumnModel().getColumn(5).setResizable(false);
        gameTable.getColumnModel().getColumn(5).setPreferredWidth(50);
        gameTable.getColumnModel().getColumn(6).setResizable(false);
        gameTable.getColumnModel().getColumn(6).setPreferredWidth(50);
        gameTable.getColumnModel().getColumn(7).setResizable(false);
        gameTable.getColumnModel().getColumn(7).setPreferredWidth(50);
        gameTable.getColumnModel().getColumn(8).setResizable(false);
        gameTable.getColumnModel().getColumn(8).setPreferredWidth(50);

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        historyPanel.setBackground(new java.awt.Color(255, 255, 255));

        historyTable.setModel(historyTableModel);
        historyTable.setToolTipText("game history");
        historyTable.setShowHorizontalLines(false);
        historyTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(historyTable);
        historyTable.getColumnModel().getColumn(0).setResizable(false);
        historyTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        historyTable.getColumnModel().getColumn(1).setResizable(false);
        historyTable.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout historyPanelLayout = new javax.swing.GroupLayout(historyPanel);
        historyPanel.setLayout(historyPanelLayout);
        historyPanelLayout.setHorizontalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        historyPanelLayout.setVerticalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout scorePanelLayout = new javax.swing.GroupLayout(scorePanel);
        scorePanel.setLayout(scorePanelLayout);
        scorePanelLayout.setHorizontalGroup(
            scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorePanelLayout.createSequentialGroup()
                .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scorePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(blackLogoLabel, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(whiteLogoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(whiteScoreLabel)
                            .addComponent(blackScoreLabel)))
                    .addGroup(scorePanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(nextPlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        scorePanelLayout.setVerticalGroup(
            scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blackLogoLabel)
                    .addComponent(blackScoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(whiteLogoLabel)
                    .addComponent(whiteScoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextPlayerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );

       // logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("./images/logo.png")));

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(historyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scorePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(historyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public void update(GameState gameState) {
		blackScoreLabel.setText("" + gameState.getBlackCount());
		whiteScoreLabel.setText("" + gameState.getWhiteCount());
		blackLogoLabel.setIcon(new ImageIcon(getClass().getResource("./images/small_black.png")));
		whiteLogoLabel.setIcon(new ImageIcon(getClass().getResource("./images/small_white.png")));
		if(gameState.getNextPlayer() == 'B') {
			nextPlayerLabel.setIcon(new ImageIcon(getClass().getResource("./images/small_black.png")));
		} else if(gameState.getNextPlayer() == 'W') {
			nextPlayerLabel.setIcon(new ImageIcon(getClass().getResource("./images/small_white.png")));
		}	  
    	
		for(int i = 1; i <= 8; i++) {
			gameTable.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer(gameState.getBoard()));
		}
		gamePanel.repaint();
		moveCount += 1;
		if(gameState.getNextPlayer() == 'B') {
			historyTableModel.addRow(new Object[] {"" + moveCount, "White", gameState.getPreviousMove()});
		} else if(gameState.getNextPlayer() == 'W') {
			historyTableModel.addRow(new Object[] {"" + moveCount, "Black", gameState.getPreviousMove()});
		}
		historyTable.setModel(historyTableModel);
		historyPanel.repaint();
    }

    public void display(String message) {
    	JOptionPane.showMessageDialog(null, message, "Announcement", JOptionPane.INFORMATION_MESSAGE);
    	System.exit(0);
    }

    private javax.swing.JLabel blackLogoLabel;
    private javax.swing.JLabel blackScoreLabel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JTable gameTable;
    private javax.swing.JPanel historyPanel;
    private javax.swing.JTable historyTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JLabel nextPlayerLabel;
    private javax.swing.JPanel scorePanel;
    private javax.swing.JLabel whiteLogoLabel;
    private javax.swing.JLabel whiteScoreLabel;
    private javax.swing.table.DefaultTableModel historyTableModel;
    private int moveCount;
}

class ImageRenderer extends DefaultTableCellRenderer {
    private char board[][];
    public ImageRenderer(char board[][]) {
    	this.board = board;
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
            boolean hasFocus, int row, int column) {
      JLabel label = new JLabel();
      if(board[row][column - 1] == 'B') {
          label.setIcon(new ImageIcon(getClass().getResource("./images/black.png")));
      } else if(board[row][column - 1] == 'W') {
	      label.setIcon(new ImageIcon(getClass().getResource("./images/white.png")));
	  }
	  JPanel panel = new JPanel();
	  panel.setBackground(java.awt.Color.green);
	  panel.add(label);
      return panel;
  }
}



