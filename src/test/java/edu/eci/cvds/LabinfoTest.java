package edu.eci.cvds;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
//import static org.quicktheories.QuickTheory.qt;
//import static org.quicktheories.generators.Generate.*;
//import static org.quicktheories.generators.SourceDSL.*;
import org.mybatis.guice.transactional.Transactional;
import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import com.google.inject.Inject;
// Clases
import edu.eci.cvds.servicios.ServiciosECILabImpl;
import edu.eci.cvds.entities.Usuario;


@Transactional
public class LabinfoTest
{
	@Inject
	private ServiciosECILabImpl laboratorio;
	
	@Test
	public void deberiaRetornarCarnetDeUsuario()
	{
		Usuario prueba = laboratorio.getUsuario("carlos.amo");
		assertEquals(prueba.getCarnet(), 1234);
	}
}