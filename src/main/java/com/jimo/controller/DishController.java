package com.jimo.controller;

import com.jimo.model.common.Result;
import com.jimo.vo.*;
import org.springframework.web.bind.annotation.*;


/**
 * @author algorithm
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    @PostMapping("/existing")
    public Result postExistingDishReview(@RequestBody PostExistingDishRequest request){

        return new Result(201, "",new PostExistingDishResponse());
    }

    @PostMapping("/new")
    public Result postNewDishReview(@RequestBody PostNewDishRequest request){

        return new Result(201, "", new PostNewDishResponse());
    }


}
