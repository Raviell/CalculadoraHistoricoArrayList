package br.edu.usd.ads.pw.calculadorahistorico;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalculadoraHistorico {

  
     List<String> historico = new ArrayList<>(); // Aqui usando ArrayList

    //Usando banco de dados Mysql

    
    
    @PostMapping(value="calcular")
    public ModelAndView postCalcular(@RequestParam String operando1, @RequestParam String operando2, @RequestParam String operador) {

        //Converter para Double
        Double operando1Double = Double.valueOf(operando1);
        Double operando2Double = Double.valueOf(operando2);

        //Operar

        //Verificar qual é a operação
        Double resultado = null;
        if ("+".equals(operador)) {
            resultado = operando1Double + operando2Double;
        }

        //Formatar operação
        String operacao = operando1 + " " + operador + " " + operando2 + " " + " = " + resultado;

        //Salvar operação no historico
        historico.add(operacao);
        
        //Instanciar template
        ModelAndView modelAndView = new ModelAndView("index");

        
        //Aplicar resultado da operação no template
        modelAndView.addObject("resultado", resultado);
        modelAndView.addObject("historico", historico);

        //Retornar       
        return modelAndView;
    }
    
    
}
