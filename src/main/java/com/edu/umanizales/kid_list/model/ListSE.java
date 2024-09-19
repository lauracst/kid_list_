package com.edu.umanizales.kid_list.model;

import lombok.Data;

import java.util.Scanner;

@Data
public class ListSE {
    private Node head;
    private int size;
    private Node tail;

    public void add(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(kid));
        }
        size++;
    }

    public void addToStart(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node newnode = new Node(kid);
            newnode.setNext(head);
            head = newnode;
        }
        size++;
    }

    public void addInPosition(Kid kid, int position) {
        if (head == null || position == 1) {
               addToStart(kid);
        }
        else{
            if (position > size) {
                add(kid);
            }
            else{
                int pos = 1;
                Node temp = head;
                while (pos < position - 1) {
                    temp = temp.getNext();
                    pos++;
                }
                ///position before
                Node newNode = new Node(kid);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
                size++;
            }
        }
    }

    public void invertList() {
        if (size > 1) {
            //crear la lista copia
            ListSE invertlist = new ListSE();
            Node temp = head;
            while (temp != null) {
                invertlist.addToStart(temp.getData());
                temp = temp.getNext(); //temporal al siguiente nodo lista original
            }
            head = invertlist.head; //actualizar lista original
        }

    }

    public void deletedId(String id) {
        // si el id a eliminar está al principio de la lista
        if (head.getData().getId().equals(id)) {
            head = head.getNext();
            size--;
            return;
        } else {
            Node temp = head;
            while (temp != null && temp.getData().getId().equals(id)) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }

    public void deletedPosition(int position) {
        if (position < 1 || position > size + 1) {
            return;
        }
        if (position == 1) {
            head = head.getNext();
            size --;
        }else { //si es otra posición recorrer la lista
            Node temp = head;
            int contador = 1;
            while (contador < position - 1 && temp.getNext() != null) {
                temp = temp.getNext();
                contador++;
            }
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }

    public void changeExtre() {
        if (size > 1){
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            Kid newkid = temp.getData();
            temp.setData(head.getData());
            head.setData(newkid);
        }
    }
    public void mixByGender() {
        if (size > 2){
            int posB = 1;
            int posG =2;
            ListSE listCp = new ListSE();
            Node temp = head;
            while (temp != null) {
                switch (temp.getData().getGender()) {
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

}





