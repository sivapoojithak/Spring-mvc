package com.java.cis;

import java.text.DecimalFormat;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BMIController {

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String bmiInput(Locale locale, Model model) {
        System.out.println("Home Page Requested, locale = " + locale);
        return "bmiInput";
    }
    @RequestMapping(value = "/bmi", method = RequestMethod.POST)
    public String bmiResult(@RequestParam("height") double heightInInches,
                         @RequestParam("weight") double weightInPounds,
                         Model model) {
        double bmi = weightInPounds / (heightInInches * heightInInches) * 703;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(java.math.RoundingMode.HALF_UP);
        String formattedBMI = df.format(bmi);
        double roundedBMI = Double.parseDouble(formattedBMI);
        model.addAttribute("bmi", roundedBMI);

        return "bmiResult";
    }
}