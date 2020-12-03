package edu.eci.cvds.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;

import com.google.inject.Injector;


import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.servicios.ExcepcionServiciosLab;
import edu.eci.cvds.servicios.impl.ServiciosECILabImpl;

@ManagedBean(name="chartView")
@ApplicationScoped
public class ChartView extends BasePageBean {
 
	private Injector injector;
	private ServiciosECILabImpl servicios;
	private int laboratorio;
	private DonutChartModel donutModel;
	private BarChartModel barModel;
 
 
	@PostConstruct
    public void init() {
    	createBarModel();
    }
    
    public ChartView() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
	}
    public BarChartModel getBarModel() {
 		return barModel;
 	}

 	public void setBarModel(BarChartModel barModel) {
 		this.barModel = barModel;
 	}

 
	public List<Laboratorio> getTotalLaboratorios(){
		try{
			List<Laboratorio> el = servicios.getLaboratorios();
			return el;
		}catch(Exception e){
			return null;
		}
	}

	public int getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(int laboratorio) {
		this.laboratorio = laboratorio;
	} 
    
    public void createBarModel() {
    	barModel = new BarChartModel();
        ChartData data = new ChartData();
        
       
		try {
			
	         
	        BarChartDataSet barDataSet = new BarChartDataSet();
	        barDataSet.setLabel("Capacidad de Laboratorios");
	         
	        List<Number> values = new ArrayList<>();
			System.out.println("Entra a try Bar");
			List<Laboratorio> lista = new ArrayList<Laboratorio>();
			if(servicios.getLaboratorios() == null) {
				System.out.println("Es nulo");
			}
			lista = servicios.getLaboratorios();
			System.out.println(lista.size());
			for(int i = 0; i < lista.size(); i++) {
	        	values.add(lista.get(i).getCapacidad());
	        }
	        barDataSet.setData(values);
	        
	        
	        List<String> bgColor = new ArrayList<>();
	        for(int i = 0; i < lista.size(); i++) {
	        	Random r = new Random();
		        Random r1 = new Random();
		        Random r2 = new Random();
		        int n1 = r.nextInt(254)+1; 
		        int n2=r1.nextInt(254)+1;
		        int n3=r2.nextInt(254)+1;
		        String colorV = "rgb(" + n1 +","+ n2 +","+n3+")";
	        	bgColor.add(colorV);
	        }
	        barDataSet.setBackgroundColor(bgColor);
	         
	        List<String> borderColor = new ArrayList<>();
	        for(int i = 0; i < lista.size(); i++) {

	        	Random r = new Random();
		        Random r1 = new Random();
		        Random r2 = new Random();
		        int n1 = r.nextInt(254)+1; 
		        int n2=r1.nextInt(254)+1;
		        int n3=r2.nextInt(254)+1;
		        String colorV = "rgb(" + n1 +","+ n2 +","+n3+")";
	        	borderColor.add(colorV);
	        }
	        barDataSet.setBorderColor(borderColor);
	        barDataSet.setBorderWidth(1); 
	        data.addChartDataSet(barDataSet);
	         
	        List<String> labels = new ArrayList<>();
	        for(int i = 0; i < lista.size(); i++) {
	        	labels.add(lista.get(i).getNombre());
	        }
	        data.setLabels(labels);
	        barModel.setData(data);
	         
	        //Options
	        BarChartOptions options = new BarChartOptions();
	        CartesianScales cScales = new CartesianScales();
	        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
	        CartesianLinearTicks ticks = new CartesianLinearTicks();
	        ticks.setBeginAtZero(true);
	        linearAxes.setTicks(ticks);
	        cScales.addYAxesData(linearAxes);
	        options.setScales(cScales);
	         
	        Title title = new Title();
	        title.setDisplay(true);
	        title.setText("Datos de reporte de laboratorios");
	        title.setFontColor("#24241D");
	        options.setTitle(title);
	 
	        Legend legend = new Legend();
	        legend.setDisplay(true);
	        legend.setPosition("top");
	        LegendLabel legendLabels = new LegendLabel();
	        legendLabels.setFontStyle("bold");
	        legendLabels.setFontColor("#24241D");
	        legendLabels.setFontSize(24);
	        legend.setLabels(legendLabels);
	        options.setLegend(legend);
	 
	        barModel.setOptions(options);
		} catch (ExcepcionServiciosLab e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
