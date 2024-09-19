package com.edu.umanizales.kid_list.controller;

import com.edu.umanizales.kid_list.model.Kid;
import com.edu.umanizales.kid_list.model.Node;
import com.edu.umanizales.kid_list.services.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listse")
public class listSEController {
    @Autowired
    private ListSEService listSEService;

    @GetMapping
    public Node getListChildren() {

        return listSEService.showKids();
    }

    @PostMapping
    public String addKidToFinal(@RequestBody Kid kid) {
        listSEService.getListSE().add(kid);
        return "Adicionado exitosamente";
    }

    @PostMapping("/tostart")
    public String addKidToStart(@RequestBody Kid kid) {
        listSEService.getListSE().addToStart(kid);
        return "Adicionado exitosamente";
    }

    @PostMapping("/inposition/{position}")
    public String addInPosition(@RequestBody Kid kid, @PathVariable int position) {
        if(position < 1 || position > listSEService.getListSE().getSize())
        {
            return "Posición no valida";
        }
        listSEService.getListSE().addInPosition(kid, position);
        return "Adicionado exitosamente";
    }

    @PostMapping("/invertlist")
    public String invertList() {
        listSEService.getListSE().invertList();
        return "Invertido exitosamente";
    }

    @PostMapping("/deletedid/{id}")
    public String deletedId(@PathVariable String id) {
        listSEService.getListSE().deletedId(id);
        return "ID eliminado exitosamente";
    }

    @PostMapping("/deletedposition/{position}")
    public String deletedPosition(@PathVariable int position) {
        listSEService.getListSE().deletedPosition(position);
        return "Posición eliminada exitosamente";
    }

    @PostMapping("/changeextre")
    public String changeExtre() {
        listSEService.getListSE().changeExtre();
        return "Intercambio exitoso";
    }
    @PostMapping("/mixbygender")
    public String mixByGender() {
        listSEService.getListSE().mixByGender();
        return "mix exitoso";
    }
}
