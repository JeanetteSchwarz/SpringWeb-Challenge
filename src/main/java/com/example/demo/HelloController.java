package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")

public class HelloController {

    @GetMapping()  //Lauscht der GET-Anfrage
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/{greetform")
    public String sayCustomGreet(@PathVariable String greetform, //Variabler Pfad in der URL -> Name muss übereinstimmen
                                 @RequestParam(required = false, defaultValue = "")   String name){  // -> ?name=Max
        return greetform + "" + name;
    }

    @PostMapping
    public String readData(@RequestBody Student currywurst) {
        return currywurst.name;
    }

}
