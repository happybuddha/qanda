package com.nav.qanda.chart.controller;

import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nav.qanda.chart.service.ChartService;

@Controller
public class ChartController {
	@Autowired
	ChartService chSrvc;
/*	
 * @RequestMapping(value="/viewChart/{id}", method = RequestMethod.POST, produces = MediaType.IMAGE_PNG_VALUE)
	 public ModelAndView login(@PathVariable("id") Long id) {
		System.out.println("Fetching chart by question ID "+id);
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, "Poll Results");
        byte [] image = new byte[0];
        image = 
        ChartUtilities.saveChartAsPNG(out, chart, 400, 300); Write the data to the output stream 
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("/pollChart");
        modelAndView.addObject("user", user);
		
	}*/
	@RequestMapping(value="/viewChart/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	 public void login(@PathVariable("id") Long id, HttpServletResponse response) {
		response.setContentType("image/png");
       PieDataset dataset = createDataset(id);
       JFreeChart chart = createChart(dataset, "Poll Results");
       try{
    	   ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 400, 300); //Write the data to the output stream   
       }catch(Exception e){
    	   e.printStackTrace();
       }
	}	

	private JFreeChart createChart(PieDataset dataset, String string) {
		 JFreeChart chart = ChartFactory.createPieChart3D("Poll Results",          // chart title
		            dataset,                // data
		            true,                   // include legend
		            true,
		            false);

		        PiePlot3D plot = (PiePlot3D) chart.getPlot();
		        plot.setStartAngle(290);
		        plot.setDirection(Rotation.CLOCKWISE);
		        plot.setForegroundAlpha(0.5f);
		        plot.setSimpleLabels(true);
		        
		        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
		                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
		         plot.setLabelGenerator(gen);
		        
		        return chart;
	}

	private PieDataset createDataset(Long questionId) {
/*		DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Linux", 29);
        result.setValue("Mac", 20);
        result.setValue("Windows", 51);
        return result;*/
        return chSrvc.getPollData(questionId);
	}

}