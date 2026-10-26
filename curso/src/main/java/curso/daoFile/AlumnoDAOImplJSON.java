package curso.daoFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import curso.dao.AlumnoDAO;
import curso.entity.Alumno;
import curso.exception.DAOException;

public class AlumnoDAOImplJSON implements AlumnoDAO {
	private Path pathjson;
	private ObjectMapper mapper;

	public AlumnoDAOImplJSON(String pathjson) {
		super();

		this.pathjson = Paths.get(pathjson);
		this.mapper = new ObjectMapper();
		this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
		this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		if (!Files.exists(this.pathjson)) {
			try {
				ObjectNode root = this.mapper.createObjectNode();
				this.mapper.writeValue(this.pathjson.toFile(), root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

private Map<String ,Alumno> read() throws DAOException{
	
		try {
			Map<String,Alumno> alumnmos=  this.mapper.readValue(this.pathjson.toFile(), new TypeReference<Map<String, Alumno>>(){});
		return alumnmos;
		} catch (StreamReadException e) {
			throw new DAOException(
			        String.format(
			            DAOException.ERROR_MESSAGE_BAD_FORMAT)
			    );		} catch (DatabindException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
throw new DAOException(String.format(DAOException.ERROR_MESSAGE_IO));
		}
return null;
	
}
	@Override
	public void add(String element) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public String get(Alumno key) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void uptade(String element) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(Alumno key) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
