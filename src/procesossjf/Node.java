/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesossjf;

/**
 *
 * @author jgale
 */
public class Node {
    private Node next;
    private int id;
    private int timeIn;         //tiempo llegada
    private int raf;            //ráfaga
    private int timeStart;      //tiempo Comienzo
    private int timeEnd;        //tiempo Final
    private int timeReturn;        //tiempo Retorno
    private int timeWait;           //Tiempo espera
    private int rafProcessed;   //Rafaga procesada
    private String status;   //estados "Ready","OnProcess","Blocked","Done"

    public Node(int id, int timeIn, int raf) {
        
        this.id = id;
        this.next = null;
        this.timeIn = timeIn;
        this.raf = raf;
        this.timeStart = 0;
        this.timeEnd = 0;
        this.timeReturn = 0;
        this.timeWait = 0;
        this.rafProcessed = 0;
        this.status = "Ready";
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    public int getRaf() {
        return raf;
    }

    public void setRaf(int raf) {
        this.raf = raf;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getTimeReturn() {
        return timeReturn;
    }

    public void setTimeReturn(int timeRet) {
        this.timeReturn = timeRet;
    }

    public int getTimeWait() {
        return timeWait;
    }

    public void setTimeWait(int timeWait) {
        this.timeWait = timeWait;
    }

    public int getRafExecuted() {
        return rafProcessed;
    }

    public void sumRafExecuted() {
        this.rafProcessed ++;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

