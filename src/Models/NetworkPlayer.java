/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Interfaces.MainFrame;
import Interfaces.ModeSelector;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.scene.input.KeyCode;
import org.apache.log4j.Logger;

/**
 *
 * @author Gimhani
 */
public class NetworkPlayer {

    static Logger log = Logger.getLogger(NetworkPlayer.class.getName());

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private ServerSocket serverSocket;

    private String ip = "localhost";
    private int port = 22222;
    private MainFrame frame;

    private String[] matrix = new String[9];

    private boolean yourTurn = false;
    private boolean is_server = true;
    private boolean accepted = false;
    private boolean unableToCommunicateWithOpponent = false;
    private boolean won = false;
    private boolean enemyWon = false;
    private boolean tie = false;

    private int error_count;

    private int[][] wins = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public NetworkPlayer(String ip, int port, MainFrame frame) {
        this.ip = ip;
        this.port = port;
        this.frame = frame;
    }

    public void replay(int position, MainFrame frame) {
        if (position == -1) {
            matrix=new String[9];
            frame.addButtonLabel(matrix);
            won=false;
            enemyWon=false;
            tie=false;
           // new MainFrame(ip, port).setVisible(true);
            //matrix=new String[9];
        }
    }

    public void control(int position, MainFrame frame) {
        if (accepted) { //connected
            log.info("Accepted true");
            if (yourTurn && !unableToCommunicateWithOpponent && !won && !enemyWon) {
                log.info("qual met");
                frame.setNetworkMsgLabelText("");
                if (matrix[position] == null) {
                    log.info("position ok");
                    if (!is_server) {
                        matrix[position] = "X";
                    } else {
                        matrix[position] = "O";
                    }
                    yourTurn = false;
                    frame.addButtonLabel(matrix);
                    try {
                        log.info("write");
                        dos.writeInt(position);
                        log.info("flush");
                        dos.flush();
                    } catch (IOException e1) {
                        error_count++;
                        e1.printStackTrace();
                    }

                    log.info("DATA WAS SENT");
                    checkForWin();
                    checkForTie();

                }else{
                    log.debug("Position null");
                }
            } else {
                log.debug("qual not met");
            }
        }

    }

    public void tick(MainFrame frame) {
        int space = -1;

        if (error_count >= 10) {
            unableToCommunicateWithOpponent = true;
        }
        //log.debug("yourTurn"+yourTurn+"unableToCOm"+unableToCommunicateWithOpponent);
        if (!yourTurn && !unableToCommunicateWithOpponent) {
            try {
                space = dis.readInt();
                frame.setNetworkMsgLabelText("");
                log.debug("Read input sream " + space);
                if (is_server) {
                    matrix[space] = "X";
                } else {
                    matrix[space] = "O";
                }
                frame.addButtonLabel(matrix);
                checkForEnemyWin();
                checkForTie();

                yourTurn = true;

            } catch (IOException e) {
                log.error("IO error" + e.getMessage());
                error_count++;
            }
        }
        //return space;
    }

    private void checkForWin() {
        for (int i = 0; i < wins.length; i++) {
            if (is_server) {
                if (matrix[wins[i][0]] == "O" && matrix[wins[i][1]] == "O" && matrix[wins[i][2]] == "O") {
                    won = true;
                    log.debug("won");
                }
            } else {
                if (matrix[wins[i][0]] == "X" && matrix[wins[i][1]] == "X" && matrix[wins[i][2]] == "X") {
                    won = true;
                    log.debug("won");
                }
            }
        }
    }

    private void checkForEnemyWin() {
        for (int i = 0; i < wins.length; i++) {
            if (is_server) {
                if (matrix[wins[i][0]] == "X" && matrix[wins[i][1]] == "X" && matrix[wins[i][2]] == "X") {
                    enemyWon = true;
                }
            } else {
                if (matrix[wins[i][0]] == "O" && matrix[wins[i][1]] == "O" && matrix[wins[i][2]] == "O") {
                    enemyWon = true;
                }
            }
        }
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isEnemyWon() {
        return enemyWon;
    }

    public void setEnemyWon(boolean enemyWon) {
        this.enemyWon = enemyWon;
    }

    public boolean isTie() {
        return tie;
    }

    public void setTie(boolean tie) {
        this.tie = tie;
    }

    private void checkForTie() {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                return;
            }
        }
        tie = true;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void listenForServerRequest() {
        Socket socket = null;
        try {
            log.debug("LISTENING");
            socket = serverSocket.accept(); //accept a server by client
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            accepted = true;
            log.info("CLIENT HAS REQUESTED TO JOIN, AND WE HAVE ACCEPTED");
            frame.setNetworkMsgLabelText("Found another player Ready to go!");
        } catch (IOException e) {
            log.error("IO error" + e.getMessage());
        }
    }

    public boolean connect() {
        //returns false if a server, return true if a client
        try {
            socket = new Socket(ip, port);
            //if a client:
            dos = new DataOutputStream(socket.getOutputStream());
            log.debug("done output stream");
            dis = new DataInputStream(socket.getInputStream());
            log.debug("done input stream");
            accepted = true;
        } catch (IOException e) {
            //this is the server
            log.info("Unable to connect to the address: " + ip + ":" + port + " | Starting a server");
            frame.setNetworkMsgLabelText("Waiting for another player");
            is_server = true;
            return false;
        }
        //this is a client
        log.info("Successfully connected to the server.");
        frame.setNetworkMsgLabelText("Succefully connected with a player");
        is_server = false;
        return true;
    }

    public void initializeServer() {
        try {
            serverSocket = new ServerSocket(port, 8, InetAddress.getByName(ip));//set the server for 2 players
        } catch (Exception e) {
            e.printStackTrace();
        }
        yourTurn = true;
        is_server = false;
    }

    public String[] getMatrix() {
        return matrix;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isIs_server() {
        return is_server;
    }

    public void setIs_server(boolean is_server) {
        this.is_server = is_server;
    }

}
