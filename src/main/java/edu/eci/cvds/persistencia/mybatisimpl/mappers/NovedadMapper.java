package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Novedad;

public interface NovedadMapper
{	
	public Novedad getNovedad(@Param("idNov") int id);	
	
	public List<Novedad> getNovedades();
}