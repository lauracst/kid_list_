package com.edu.umanizales.kid_list.services;

import com.edu.umanizales.kid_list.model.ListSE;
import com.edu.umanizales.kid_list.model.Node;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ListSEService {
    private ListSE listSE;

    @PostConstruct
    public void init() {
        listSE = new ListSE();
    }
    public Node showKids (){
        return listSE.getHead();
    }
}
