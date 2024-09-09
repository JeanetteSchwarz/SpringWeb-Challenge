package com.example.demo;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
@Data

public class HelloController {

    @GetMapping()  //Lauscht der GET-Anfrage
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("hello/{name}")
    public String sayIndividualGreet(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("/{greetform}")
    public String sayCustomGreet(@PathVariable String greetform,//Variab. Pfad in URL -> Name muss übereinstimmen
                                 @RequestParam(required = false, defaultValue = "") String name,
                                 @RequestParam(required = false, defaultValue = "") String q){ // -> ?name=Max
        return greetform + " " + name + " " + q;
    }


    @PostMapping
    public String readData(@RequestBody Student currywurst) {
        return currywurst.name();
    }

}
