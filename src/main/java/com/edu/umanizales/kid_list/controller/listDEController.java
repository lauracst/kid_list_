package com.edu.umanizales.kid_list.controller;

import com.edu.umanizales.kid_list.services.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.umanizales.kid_list.model.Kid;
import java.util.List;
@RestController
@RequestMapping("/listde")
public class listDEController {
    @Autowired
    private ListDEService listDEService;

    @GetMapping
    public List getlistDE(){
        return listDEService.showKids();
    }

    @PostMapping("/add")
    public String addlistDE(@RequestBody Kid kid){
        listDEService.getListDE().add(kid);
        return "Agregado exitosamente";
    }
    @PostMapping("/addtostart")
    public String addtostartDE (@RequestBody Kid kid){
        listDEService.getListDE().addToStart(kid);
        return "Agregado exitosamente";
    }
    @PostMapping("/addinposition/{position}")
    public String addinpositionDE (@RequestBody Kid kid, @PathVariable int position){
        listDEService.getListDE().addInPosition(kid, position);
        return "Agregado exitosamente";
    }
    @PostMapping("/deletedbyposition/{position}")
    public String deletedbypositionDE (@PathVariable int position){
        listDEService.getListDE().deleteByPosition(position);
        return "Eliminado exitosamente";
    }
    @PostMapping("/deletedbyid/{id}")
    public String deletedbyidDE (@PathVariable String id){
        listDEService.getListDE().deleteById(id);
        return "Eliminado exitosamente";
    }
    @PostMapping("/invertlist")
    public String invertlistDE (){
        listDEService.getListDE().invertList();
        return "Invertido exitosamente";
    }
    @PostMapping("/changeextreme")
    public String changeextreDE() {
        listDEService.getListDE().changeExtreme();
        return "Intercambio exitoso";
    }
    @PostMapping("/switchbygender")
    public String switchbygenderDE() {
        listDEService.getListDE().switchByGender();
        return "switch exitoso";
    }
}
