/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gimhani
 */
public class Player {

    DateFormat dateFormat;
    Date date;
    private String name;
    private String currentDate;
    private String playerType;
    private int isWin;
    private int playerNumber; //player 1 or 2
    private int image; //gold_x=1 ,gold_o=2, red_x=3, red_o=4
    private int port;
    private String ipAddress;
    private boolean isServer;
    private int turn; //turn 1 and 2
    private int wincount;

    public Player() {
        this.dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.date = new Date();
        wincount = 0;
    }

    public Player(String name, String type, String Date, int isWin) {
        this();
        this.name = name;
        this.currentDate = Date;
        this.playerType = type;
        this.isWin = isWin;

    }

    public int getWincount() {
        return wincount;
    }

    public void setWincount() {
        this.wincount++;
    }

    public Player(String name, int playerNumber, int image, int turn) {
        this();
        this.name = name;
        this.playerNumber = playerNumber;
        this.image = image;
        this.turn = turn;
    }

    public Player(int port, String ipAddress, boolean isServer, int turn) {
        this();
        this.port = port;
        this.ipAddress = ipAddress;
        this.isServer = isServer;
        this.turn = turn;

    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate() {
        this.currentDate = dateFormat.format(date);
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public int getIsWin() {
        return isWin;
    }

    public void setIsWin(int isWin) {
        this.isWin = isWin;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public boolean isIsServer() {
        return isServer;
    }

    public void setIsServer(boolean isServer) {
        this.isServer = isServer;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
