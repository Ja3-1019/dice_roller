package com.DiceRoll.slot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Random;

@RestController
public class controller {


    @PostMapping("/play")
    public Response calculate(@RequestBody Request request) {
        if(request.getNumOfDices()<=0)throw new RuntimeException("Invalid num of dices !");
        if(request.getBet()<=0)throw new RuntimeException("Invalid bet !");
        if(request.getBalance()< request.getBet())throw new RuntimeException("Insufficient funds !");
        Random rn = new Random();
        int sum = 0;
        for (int i = 0; i < request.getNumOfDices(); i++) {
           sum+= rn.nextInt(6)+1;
        }
        double result = request.getBalance() - request.getBet() + sum;

        Response response = new Response();
        response.setResult(sum);
        response.setUpdatedBalance(result);
        return response;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
