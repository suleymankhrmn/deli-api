package com.mas.deliapi.controller;


import com.mas.deliapi.entity.Base;
import com.mas.deliapi.service.BaseServiceImpl;
import com.mas.deliapi.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BaseController {
    @Autowired
    private CommonService<Base> baseService;

    @GetMapping("/bases")
    public ResponseEntity<?> getBases(){
        try{
            List<Base> baseList = baseService.getList();
            return ResponseEntity.ok(baseList);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/base")
    public ResponseEntity<?> getBase(@RequestParam long id){
        try{
            Base result = baseService.getById(id);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/base")
    public ResponseEntity<?> createBase(@RequestBody Base base){
        try{

            baseService.saveOrUpdate(base);
            return ResponseEntity.ok(true);

        }catch ( Exception e){

            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @DeleteMapping("/base")
    public ResponseEntity<?>  deleteBase(@RequestParam long id){
        try{
            baseService.delete(id);
            return ResponseEntity.ok(true);

        }catch (Exception e){

            return  ResponseEntity.badRequest().body(e.getMessage());
        }

    }





}
