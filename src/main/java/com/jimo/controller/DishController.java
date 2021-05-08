package com.jimo.controller;

import com.jimo.vo.*;
import org.springframework.web.bind.annotation.*;


/**
 * @author algorithm
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    @PostMapping("/existing")
    public PostExistingDishResponse postExistingDish(@RequestBody PostExistingDishRequest request){

        return new PostExistingDishResponse();
    }

    @PostMapping("/new")
    public PostNewDishResponse postNewDish(@RequestBody PostNewDishRequest request){

        return new PostNewDishResponse();
    }


}
