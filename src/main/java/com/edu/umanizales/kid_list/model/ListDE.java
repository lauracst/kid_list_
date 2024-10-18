package com.edu.umanizales.kid_list.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListDE {
    private NodeDE head;
    private int size;

    public void add(Kid kid) {
        if (head == null) {
            head = new NodeDE(kid);
        } else {
            NodeDE temp = head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            NodeDE newNode = new NodeDE(kid);
            temp.setNext(newNode);
            newNode.setPrevious(temp);
        }
        size++;
    }


    public void addToStart(Kid kid){
        if (head == null) {
            add(kid);
        }
        else{
            NodeDE newNode = new NodeDE(kid);
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    public void addInPosition(Kid kid, int position) {
        if (head == null || position == 1) {
            addToStart(kid);
        } else {
            if (position <= size+1) {
                int pos = 1;
                NodeDE temp = head;
                while (pos < position - 1) {
                    temp = temp.getNext();
                    pos++;
                }
                NodeDE newNode = new NodeDE(kid);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
                newNode.setPrevious(temp);

                if(newNode.getNext() != null) {
                    newNode.getNext().setPrevious(newNode);
                }
            }
        }
        size++;
    }

    public void deleteByPosition(int position) {
        if(position < 1 || position > getSize()){
        }
        if (position == 1) {
            head = head.getNext();
        }
        else {
            NodeDE temp = head;
            int pos = 1;
            while (pos < position - 1) {
                temp = temp.getNext();
                pos++;
            }
            temp.setNext(temp.getNext().getNext());

            if (temp.getNext() != null) {
                temp.getNext().setPrevious(temp);
            }
        }
        size--;
    }

    public String deleteById(String id) {
        if (head == null) {
            return "No hay nodos";
        }
        if (head.getData().getId().equals(id)) {
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
            size--;
            return "Borrado exitosamente";
        } else {
            NodeDE temp = head;

            while (temp.getNext() != null) {
                if (temp.getNext().getData().getId().equals(id)) {
                    NodeDE newNode = temp.getNext();
                    temp.setNext(newNode.getNext());

                    if (newNode.getNext() != null) {
                        newNode.getNext().setPrevious(temp);
                    }

                    size--;
                    return "Borrado exitosamente";
                }
                temp = temp.getNext();
            }
        }
        return "No se encontró";
    }
    public void invertList() {
        if (size > 1) {
            ListDE listCp = new ListDE();
            NodeDE temp = head;
            while (temp != null) {
                listCp.addToStart(temp.getData());
                temp = temp.getNext();
            }
            head = listCp.head;
        }
    }
    public void changeExtreme() {
        if (head == null) {
        } else {
            NodeDE temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Kid Newkid = temp.getData();
            temp.setData(head.getData());
            head.setData(Newkid);
        }
    }
    public void switchByGender() {
        if (size > 2) {
            int posB = 1;
            int posG = 2;
            ListDE listCp = new ListDE();
            NodeDE temp = head;
            while (temp != null) {
                switch (temp.getData().getGender()){
                    case 'F':
                    case 'f':
                        listCp.addInPosition(temp.getData(), posG);
                        posG += 2;
                        break;
                    default:
                        listCp.addInPosition(temp.getData(), posB);
                        posB += 2;
                }
                temp = temp.getNext();
            }
            this.head = listCp.getHead();
        }
    }
    public List show(){
        ArrayList list = new ArrayList();
        if(this.getHead() !=null){
            NodeDE temp = head;
            while(temp!=null){
                list.add(temp.getData());
                temp = temp.getNext();
            }
        }
        return list;
    }

}
