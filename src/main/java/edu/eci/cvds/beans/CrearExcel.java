package edu.eci.cvds.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;

/**
 * @author Carlos
 *
 */
public class CrearExcel {

	private Workbook workbook;
	private Sheet sheet;
	
	public CrearExcel()	
	{
        //Crear libro de trabajo en blanco
        workbook = new HSSFWorkbook();
        //Crea hoja nueva
        sheet = workbook.createSheet("Hoja de datos");
	}
	
	public void NovedadNovedad(List<Novedad> novedades)
	{
        //Por cada línea se crea un arreglo de objetos (Object[])
        Map<Integer, Object[]> datos = new TreeMap<Integer, Object[]>();
        datos.put(1, new Object[]{"Identificador", "Fecha", "Identificador del equipo", "Identificador del elemento", "Descripcion", "Tipo de la novedad"});
        for(Novedad novedad: novedades)
        {
        	datos.put(novedad.getId(), new Object[]{novedad.getId(), novedad.getFechaString(), novedad.getIdEquipo(), novedad.getIdElemento(), novedad.getDescripcion(), novedad.getTipoNovedad()});
        }
        
        llenarHoja(datos);
        generarDocumento("ReporteNovedad");
	}
	
	public void NovedadElemento(List<Novedad> novedadPorElemento)
	{
        //Por cada línea se crea un arreglo de objetos (Object[])
        Map<Integer, Object[]> datos = new TreeMap<Integer, Object[]>();
        datos.put(1, new Object[]{"Identificador", "Fecha", "Identificador del elemento", "Descripcion", "Tipo de la novedad"});
        for(Novedad novedad: novedadPorElemento)
        {
        	datos.put(novedad.getId(), new Object[]{novedad.getId(), novedad.getFechaString(), novedad.getIdElemento(), novedad.getDescripcion(), novedad.getTipoNovedad()});
        }
        
        llenarHoja(datos);
        generarDocumento("ReporteNovedadElemento");
	}

	public void NovedadEquipo(List<Novedad> novedadPorEquipo) 
	{
        //Por cada línea se crea un arreglo de objetos (Object[])
        Map<Integer, Object[]> datos = new TreeMap<Integer, Object[]>();
        datos.put(1, new Object[]{"Identificador", "Fecha", "Identificador del equipo", "Identificador del elemento", "Descripcion", "Tipo de la novedad"});
        for(Novedad novedad: novedadPorEquipo)
        {
        	datos.put(novedad.getId(), new Object[]{novedad.getId(), novedad.getFechaString(), novedad.getIdEquipo(), novedad.getIdElemento(), novedad.getDescripcion(), novedad.getTipoNovedad()});
        }
        
        llenarHoja(datos);
        generarDocumento("ReporteNovedadEquipo");
	}
	
	public void reporteLaboratorio(List<Laboratorio> laboratorios)
	{
        //Por cada línea se crea un arreglo de objetos (Object[])
        Map<Integer, Object[]> datos = new TreeMap<Integer, Object[]>();
        datos.put(1, new Object[]{"Identificador", "Nombre", "Capacidad", "disponible", "Fecha de creacion", "Fecha de cierre"});
        for(Laboratorio novedad: laboratorios)
        {
        	datos.put(novedad.getId(), new Object[]{novedad.getId(), novedad.getNombre(), novedad.getCapacidad(), novedad.isDisponible(), novedad.getFechaCreacionString(), novedad.getFechaCierreString()});
        }
        
        llenarHoja(datos);
        generarDocumento("ReporteLaboratorios");
	}
	
	public void reporteEquipos(List<Equipo> equipos)
	{
        //Por cada línea se crea un arreglo de objetos (Object[])
        Map<Integer, Object[]> datos = new TreeMap<Integer, Object[]>();
        datos.put(1, new Object[]{"Identificador", "Nombre", "Disponible", "En Funcionamiento", "Laboratorio"});
        for(Equipo novedad: equipos)
        {
        	datos.put(novedad.getId(), new Object[]{novedad.getId(), novedad.getNombre(), novedad.getDisponible(), novedad.getFuncionamiento(), novedad.getLaboratorio()});
        }
        
        llenarHoja(datos);
        generarDocumento("ReporteEquipos");
	}
	
	public void reporteElementos(List<Elemento> elementos)
	{
        //Por cada línea se crea un arreglo de objetos (Object[])
        Map<Integer, Object[]> datos = new TreeMap<Integer, Object[]>();
        datos.put(1, new Object[]{"Identificador", "Categoria", "Fabricante", "Disponible", "En Funcionamiento", "Equipo"});
        for(Elemento novedad: elementos)
        {
        	datos.put(novedad.getId(), new Object[]{novedad.getId(), novedad.getCategoria(), novedad.getFabricante(), novedad.getDisponible(), novedad.getFuncionamiento(), novedad.getEquipo()});
        }
        
        llenarHoja(datos);
        generarDocumento("ReporteElementos");
	}
	
	private void llenarHoja(Map<Integer, Object[]> datos)
	{
        //Iterar sobre datos para escribir en la hoja
        Set<Integer> keyset = datos.keySet();
        int numeroRenglon = 0;
        for (int key : keyset) {
            Row row = sheet.createRow(numeroRenglon++);
            Object[] arregloObjetos = datos.get(key);
            int numeroCelda = 0;
            for (Object obj : arregloObjetos) {
                Cell cell = row.createCell(numeroCelda++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
	}
	
	private void generarDocumento(String nombreArchivo)
	{
        try {
            //Se genera el documento
            FileOutputStream out = new FileOutputStream(new File("Reportes\\"+nombreArchivo+".xls"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/*
	 * public static void main(String args[], List<Novedad> novedades) { //Crear
	 * libro de trabajo en blanco //Workbook workbook = new HSSFWorkbook();
	 * 
	 * //Crea hoja nueva //Sheet sheet = workbook.createSheet("Hoja de datos");
	 * 
	 * //Por cada línea se crea un arreglo de objetos (Object[]) Map<Integer,
	 * Object[]> datos = new TreeMap<Integer, Object[]>(); datos.put(1, new
	 * Object[]{"Identificador", "Fecha", "Identificador del equipo",
	 * "Identificador del elemento", "Descripcion", "Tipo de la novedad"});
	 * for(Novedad novedad: novedades) { datos.put(novedad.getId(), new
	 * Object[]{novedad.getId(), novedad.getFechaString(), novedad.getIdEquipo(),
	 * novedad.getIdElemento(), novedad.getDescripcion(),
	 * novedad.getTipoNovedad()}); }
	 * 
	 * //Iterar sobre datos para escribir en la hoja Set<Integer> keyset =
	 * datos.keySet(); int numeroRenglon = 0; for (int key : keyset) { Row row =
	 * sheet.createRow(numeroRenglon++); Object[] arregloObjetos = datos.get(key);
	 * int numeroCelda = 0; for (Object obj : arregloObjetos) { Cell cell =
	 * row.createCell(numeroCelda++); if (obj instanceof String) {
	 * cell.setCellValue((String) obj); } else if (obj instanceof Integer) {
	 * cell.setCellValue((Integer) obj); } } } try { //Se genera el documento
	 * FileOutputStream out = new FileOutputStream(new
	 * File("Reportes\\NovedadEquipo.xlsx")); workbook.write(out); out.close(); }
	 * catch (Exception e) { e.printStackTrace(); } }
	 */
}