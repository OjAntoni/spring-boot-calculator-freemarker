package com.example.bootcalculator.controller;

import com.example.bootcalculator.entity.Operation;
import com.example.bootcalculator.entity.User;
import com.example.bootcalculator.service.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/calc")
public class CalculateController {
    private OperationService operationService;

    public CalculateController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public ModelAndView calcGet(ModelAndView modelAndView){
        modelAndView.setViewName("calc");
        Map<String, String> operations = new HashMap<>();
        operations.put("sum", "+");
        operations.put("sub", "-");
        operations.put("div", "/");
        operations.put("mult", "*");
        modelAndView.addObject("operations", operations);
        modelAndView.addObject("operationDto", new Operation());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView calcPost(@Valid Operation operationDto, HttpSession session){
        double num1 = operationDto.getNum1();
        double num2 = operationDto.getNum2();
        String operationSign = operationDto.getOperationSign();
        double result = operationService.calcResult(num1, num2, operationSign);
        operationService.save(new Operation(0, num1, num2, result, operationSign, ((User) session.getAttribute("user"))));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("operationDto", operationDto);
        modelAndView.addObject("result", result);
        modelAndView.setViewName("calc");
        Map<String, String> operations = new HashMap<>();
        operations.put("sum", "+");
        operations.put("sub", "-");
        operations.put("div", "/");
        operations.put("mult", "*");
        modelAndView.addObject("operations", operations);
        return modelAndView;
    }

    @GetMapping("/history")
    public ModelAndView historyGet(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Operation> all = operationService.getAll(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userOperations", all);
        modelAndView.setViewName("history");
        return modelAndView;
    }
}
